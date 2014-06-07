package armijn.vink.numberviewanimation;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import armijn.vink.numberviewanimation.fonts.Roboto;

public class NumberView extends View {
	 
    private final Interpolator mInterpolator;
    private Paint mPaint;
    private final Path mPath;
 
    // Numbers currently shown.
    private int mCurrent = 0;
    private int mNext = 1;
 
    // Frame of transition between current and next frames.
    private int mFrame = 0;
     
    private float[][][] mPoints;
    private float[][][] mControlPoint1;
    private float[][][] mControlPoint2;
    
    private int textColor;
    private float strokeSize;
	private float viewSize;
	private String font;
    
    public NumberView(Context context, AttributeSet attrs) {
        super(context, attrs);
         
        init(attrs);
        
        setWillNotDraw(false);
        mInterpolator = new AccelerateDecelerateInterpolator();
        
        // A new paint with the style as stroke.
        mPaint = new Paint();

    		Roboto roboto = new Roboto(textColor, strokeSize*3);
	    	mPoints = Roboto.getMpoints();
	        mControlPoint1 = Roboto.getMcontrolpoint1();
	        mControlPoint2 = Roboto.getMcontrolpoint2();
	        mPaint = roboto.getPaint();
	    if(font.equals("roboto_thin")){
	    	mPaint.setStrokeWidth(strokeSize*3);
        }else if(font.equals("roboto_light")){
        	mPaint.setStrokeWidth(strokeSize*6);
        }else if(font.equals("roboto_regular")){
        	mPaint.setStrokeWidth(strokeSize*9);
        }else if(font.equals("roboto_medium")){
        	mPaint.setStrokeWidth(strokeSize*12);
        }else if(font.equals("roboto_bold")){
        	mPaint.setStrokeWidth(strokeSize*15);
        }else if(font.equals("roboto_black")){
        	mPaint.setStrokeWidth(strokeSize*18);
        }
        
        mPath = new Path();
    }
    
    private void init(AttributeSet attrs) { 
    	TypedArray ta=getContext().obtainStyledAttributes(attrs, R.styleable.NumberViewAttr);

      //set custom attr
        try {
            textColor = ta.getColor(R.styleable.NumberViewAttr_android_textColor, Color.BLACK);
            strokeSize = ta.getDimensionPixelSize(R.styleable.NumberViewAttr_strokeSize, 5);
            viewSize = ta.getDimensionPixelSize(R.styleable.NumberViewAttr_viewSize, 250);
            font = ta.getString(R.styleable.NumberViewAttr_font);
            if(font == null){
            	font = "roboto_regular";
            }
            
            viewSize = (viewSize/250);
            strokeSize = (viewSize);
        } finally {
            ta.recycle();
        }
    }
     
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Frames 0, 1 is the first pause.
        // Frames 9, 10 is the last pause.
        // Constrain current frame to be between 0 and 6.
        
        final int currentFrame;
        if (mFrame < 2) {
            currentFrame = 0;
        } else if (mFrame > 8) {
            currentFrame = 6;
        } else {
            currentFrame = mFrame - 2;
        }
         
        // A factor of the difference between current
        // and next frame based on interpolation.
        // Only 6 frames are used between the transition.
        final float factor = mInterpolator.getInterpolation(currentFrame / 6.0f);
         
        // Reset the path.
        mPath.reset();
 
        final float[][] current = mPoints[mCurrent];
        final float[][] next = mPoints[mNext];
 
        final float[][] curr1 = mControlPoint1[mCurrent];
        final float[][] next1 = mControlPoint1[mNext];
 
        final float[][] curr2 = mControlPoint2[mCurrent];
        final float[][] next2 = mControlPoint2[mNext];
         
        // First point.
        mPath.moveTo((current[0][0]*viewSize) + (((next[0][0]*viewSize) - (current[0][0]*viewSize)) * factor),
                     (current[0][1]*viewSize) + (((next[0][1]*viewSize) - (current[0][1]*viewSize)) * factor));
         
        // Rest of the points connected as bezier curve.
        for (int i = 1; i < 5; i++) {
            mPath.cubicTo((curr1[i-1][0]*viewSize) + (((next1[i-1][0]*viewSize) - (curr1[i-1][0]*viewSize)) * factor),
                          (curr1[i-1][1]*viewSize) + (((next1[i-1][1]*viewSize) - (curr1[i-1][1]*viewSize)) * factor),
                          (curr2[i-1][0]*viewSize) + (((next2[i-1][0]*viewSize) - (curr2[i-1][0]*viewSize)) * factor),
                          (curr2[i-1][1]*viewSize) + (((next2[i-1][1]*viewSize) - (curr2[i-1][1]*viewSize)) * factor),
                          (current[i][0]*viewSize) + (((next[i][0]*viewSize) - (current[i][0]*viewSize)) * factor),
                          (current[i][1]*viewSize) + (((next[i][1]*viewSize) - (current[i][1]*viewSize)) * factor));
        }
 
        // Draw the path.
        canvas.drawPath(mPath, mPaint);
 
        // Next frame.
        mFrame++;
 
        // Each number change has 10 frames. Reset.
        if (mFrame == 10) {
            // Reset to zerro.
            mFrame = 0;
 
            mCurrent = mNext;
            mNext++;
 
            // Reset to zerro.
            if (mNext == 10) {
                mNext = 0;
            }
        }
        
        // Callback for the next frame.
        postInvalidateDelayed(50);
    }
    
}