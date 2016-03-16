package armijn.vink.numberviewanimation.fonts;

import android.graphics.Paint;

public class Roboto {

    private Paint mPaint;

    // The 5 end points. (Note: The last end point is the first end point of the next segment.
    private static final float[][][] mPoints =
            {{{59f, 100f}, {100f, 29.3f}, {141f, 100f}, {100f, 170.66f}, {59f, 100f}}, // 0
                    {{79.27f, 37.18f}, {120.73f, 29.11f}, {120.73f, 170.89f}, {120.73f, 170.89f}, {120.73f, 170.89f}}, // 1
                    {{58.5f, 69.97f}, {100f, 30.25f}, {127.75f, 86.25f}, {61.25f, 169f}, {144f, 169f}}, // 2
                    {{61.38f, 65.38f}, {102.38f, 29.66f}, {86.24f, 98.63f}, {102.17f, 170.17f}, {59f, 131.54f}}, // 3
                    {{148.75f, 130.21f}, {51.25f, 130.21f}, {120.75f, 28.96f}, {120.75f, 171.04f}, {120.75f, 171.04f}}, // 4
                    {{134.8f, 30.79f}, {71f, 30.79f}, {63.8f, 101.79f}, {138.5f, 126.79f}, {61.8f, 134.04f}}, // 5
                    {{127.91f, 35.79f}, {65.66f, 55.05f}, {61.41f, 118.29f}, {138.66f, 129.79000000000002f}, {62.5f, 130.89f}}, // 6
                    {{57.25f, 31f}, {146.84f, 31f}, {88.5f, 171f}, {88.5f, 171f}, {88.5f, 173f}}, // 7
                    {{99.83f, 87f}, {99.83f, 32.11f}, {99.83f, 87f}, {99.83f, 167.89f}, {99.83f, 87f}}, // 8
                    {{72.09f, 164.21f}, {134.34f, 144.95f}, {138.59f, 81.71f}, {61.34f, 70.20999999999998f}, {137.5f, 69.11000000000001f}} // 9
            };
    // The set of the "first" control points of each segment.
    private static final float[][][] mControlPoint1 =
            {{{59f, 55.75f}, {131.5f, 29.3f}, {141f, 143.75f}, {68f, 170.66f}}, // 0
                    {{79.27f, 37.18f}, {120.73f, 29.11f}, {120.73f, 170.89f}, {120.73f, 170.89f}}, // 1
                    {{57.83f, 39.5f}, {133f, 31.5f}, {114.8f, 109.5f}, {61.25f, 169f}}, // 2
                    {{60f, 38.5f}, {149.33f, 28.83f}, {156.67f, 97.66f}, {83f, 170f}}, // 3
                    {{148.75f, 130.21f}, {51.25f, 130.21f}, {120.75f, 28.96f}, {120.75f, 171.04f}}, // 4
                    {{134.8f, 30.79f}, {71f, 30.79f}, {89.66f, 67.66f}, {133f, 185f}}, // 5
                    {{96f, 21.33f}, {60.16f, 68.83f}, {61f, 186.66f}, {138.16f, 73.66f}}, // 6
                    {{57.25f, 31f}, {98.5f, 86f}, {88.5f, 171.16f}, {88.5f, 171.16f}}, // 7
                    {{56f, 86.83f}, {148.33f, 32.11f}, {46f, 86.83f}, {157.3f, 167.3f}}, // 8
                    {{104f, 178.67000000000002f}, {139.84f, 131.17000000000002f}, {139f, 13.340000000000003f}, {61.84f, 126.34f}} // 9
            };
    // The set of the "second" control points of each segment.
    private static final float[][][] mControlPoint2 =
            {{{68f, 29.3f}, {141f, 55.75f}, {131.5f, 170.66f}, {59f, 143.75f}}, // 0
                    {{79.27f, 37.18f}, {120.73f, 29.11f}, {120.73f, 170.89f}, {120.73f, 170.89f}}, // 1
                    {{80.3f, 29.3f}, {139.8f, 65f}, {61.25f, 169f}, {144f, 169f}}, // 2
                    {{86.66f, 29.832f}, {150.66f, 97.66f}, {151.165f, 170.33f}, {58f, 162f}}, // 3
                    {{148.75f, 130.21f}, {51.25f, 130.21f}, {120.75f, 28.96f}, {120.75f, 171.04f}}, // 4
                    {{71.5f, 30.79f}, {63.8f, 101.79f}, {141.66f, 83f}, {61.66f, 179.33f}}, // 5
                    {{72.5f, 34.83f}, {61.3f, 88.66f}, {138.49f, 179.33f}, {61.9f, 71.66f}}, // 6
                    {{57.25f, 31f}, {88.5f, 171.16f}, {88.5f, 171.16f}, {88.5f, 171.16f}}, // 7
                    {{56f, 32.22f}, {147.3f, 86.83f}, {46f, 167.3f}, {158.33f, 86.83f}}, // 8
                    {{127.5f, 165.17000000000002f}, {138.7f, 111.34f}, {61.50999999999999f, 20.669999999999987f}, {138.1f, 128.34f}} // 9
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
