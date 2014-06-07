package armijn.vink.numberviewanimation.fonts;

import android.graphics.Paint;

public class Roboto {
	
	private Paint mPaint;

    // The 5 end points. (Note: The last end point is the first end point of the next segment.
	private static final float[][][] mPoints = {
    	{{59, 100}, {100, 29.3f}, {141, 100}, {100, 170.66f}, {59, 100}}, // 0
		{{79.27f, 37.18f}, {120.73f, 29.11f}, {120.73f, 170.89f}, {120.73f, 170.89f}, {120.73f, 170.89f}}, //1
		{{58.5f, 69.97f}, {100, 30.25f}, {127.75f, 86.25f}, {61.25f, 169}, {144, 169}}, // 2
		{{61.38f, 65.38f}, {102.38f, 29.66f}, {86.24f, 98.63f}, {102.17f, 170.17f}, {59, 131.54f}}, // 3
		{{148.75f, 130.21f}, {51.25f, 130.21f}, {120.75f, 28.96f}, {120.75f, 171.04f}, {120.75f, 171.04f}}, //4
		{{134.8f, 30.79f}, {71, 30.79f}, {63.8f, 101.79f}, {138.5f, 126.79f}, {61.8f, 134.04f}}, // 5
		{{127.91f, 39.79f}, {65.66f, 59.05f}, {61.41f, 116.29f}, {138.66f, 127.79f}, {62.5f, 128.89f}}, // 6
		{{57.25f, 34}, {146.84f, 34}, {88.5f, 174}, {88.5f, 174}, {88.5f, 176}},  // 7
		{{99.83f, 100}, {99.83f, 19.11f}, {99.83f, 100}, {99.83f, 180.89f}, {99.83f, 100}}, // 8
		{{145.5f, 67.5f}, {53.5f, 67.5f}, {145.5f, 67.5f}, {65.82f, 175.35f}, {65.82f, 175.35f}} // 9
    };
    // The set of the "first" control points of each segment.
	private static final float[][][] mControlPoint1 = {
		{{59, 55.75f}, {131.5f, 29.3f}, {141 , 143.75f}, {68, 170.66f}}, // 0
		{{79.27f, 37.18f}, {120.73f, 29.11f}, {120.73f, 170.89f}, {120.73f, 170.89f}}, // 1
		{{57.83f, 39.5f}, {133f, 31.5f}, {114.8f, 109.5f}, {61.25f, 169}}, // 2
		{{60, 38.5f}, {149.33f, 28.83f}, {156.67f, 97.66f}, {83, 170f}}, // 3
		{{148.75f, 130.21f}, {51.25f, 130.21f}, {120.75f, 28.96f}, {120.75f, 171.04f}}, // 4
		{{134.8f, 30.79f}, {71, 30.79f}, {89.66f, 67.66f}, {133, 185f}}, // 5
		{{96f, 25.33f}, {60.16f, 72.83f}, {61f, 184.66f}, {138.16f, 77.66f}}, // 6
		{{57.25f, 34}, {98.5f, 89}, {88.5f, 174.16f}, {88.5f, 174.16f}}, // 7
		{{41, 99.83f}, {163.33f, 19.11f}, {41, 99.83f}, {162.3f, 180.3f}}, // 8
		{{145.6f, 133.6f}, {53.7f, 0}, {145.6f, 133.6f}, {27.6f, 159}} // 9
    };
    // The set of the "second" control points of each segment.
	private static final float[][][] mControlPoint2 = { 
		{{68, 29.3f}, {141, 55.75f}, {131.5f, 170.66f}, {59, 143.75f}}, // 0
		{{79.27f, 37.18f}, {120.73f, 29.11f}, {120.73f, 170.89f}, {120.73f, 170.89f}}, // 1
		{{80.3f, 29.3f}, {139.8f, 65}, {61.25f, 169}, {144, 169}}, // 2
		{{86.66f, 29.832f}, {150.66f, 97.66f}, {151.165f, 170.33f}, {58f, 162}}, // 3
		{{148.75f, 130.21f}, {51.25f, 130.21f}, {120.75f, 28.96f}, {120.75f, 171.04f}}, // 4
		{{71.5f, 30.79f}, {63.8f, 101.79f}, {141.66f, 83}, {61.66f, 179.33f}}, // 5
		{{72.5f, 38.83f}, {61.3f, 92.66f}, {138.49f, 177.33f}, {61.9f, 75.66f}}, // 6
		{{57.25f, 34}, {88.5f, 174.16f}, {88.5f, 174.16f}, {88.5f, 174.16f}}, // 7
		{{41, 19.22f}, {162.3f, 99.83f}, {41, 180.3f}, {163.33f, 99.83f}}, // 8
		{{54, 132}, {145, -8}, {152, 203}, {65.82f, 175.35f}} // 9
    };
	
	public Roboto(int textColor, float strokeSize) {
		// A new paint with the style as stroke.
        setPaint(new Paint());
        getPaint().setAntiAlias(true);
        getPaint().setColor(textColor);
        getPaint().setStrokeWidth(strokeSize);
        
        getPaint().setStrokeCap(Paint.Cap.SQUARE);
        getPaint().setStrokeJoin(Paint.Join.BEVEL);
        getPaint().setStyle(Paint.Style.STROKE);
	}

	public Paint getPaint() {
		return mPaint;
	}

	public void setPaint(Paint mPaint) {
		this.mPaint = mPaint;
	}

	public static float[][][] getMpoints() {
		return mPoints;
	}

	public static float[][][] getMcontrolpoint1() {
		return mControlPoint1;
	}

	public static float[][][] getMcontrolpoint2() {
		return mControlPoint2;
	}
    
    
}
