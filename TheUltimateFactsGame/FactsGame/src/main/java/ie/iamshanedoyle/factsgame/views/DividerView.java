package ie.iamshanedoyle.factsgame.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import ie.iamshanedoyle.factsgame.R;

/**
 * Created by shane on 11/01/2014.
 */
public class DividerView extends View {

    private int mColor;
    private float mThickness;
    private boolean mIsVertical;
    private Paint mPaint;

    public DividerView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.DividerView, 0, 0);

        try {
            mColor = typedArray.getColor(0, android.R.color.darker_gray);
            mThickness = typedArray.getDimension(1, 2);
            mIsVertical = typedArray.getInt(2, 0) == 0 ? true : false;
        } finally {
            typedArray.recycle();
        }

        init();

    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(mColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mThickness);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // Get the initial positions.
        int startX = 0;
        int stopX = isVertical() ? 0 : getRight();
        int startY = 0;
        int stopY = isVertical() ? getTop() : 0;

        // Adjust for Padding
        startX += getPaddingLeft();
        startY += getPaddingBottom();
        stopX -= getPaddingRight();
        stopY -= getPaddingTop();

        canvas.drawLine(startX, startY, stopX, stopY, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = widthMeasureSpec;
        int height = heightMeasureSpec;

        if (isVertical()) {
            width = (int) getThickness();
        } else {
            height = (int) getThickness();
        }

        setMeasuredDimension(width, height);
    }

    public int getColor() {
        return mColor;
    }

    public float getThickness() {
        return mThickness;
    }

    public boolean isVertical() {
        return mIsVertical;
    }

    public void setThickness(float mWidth) {
        this.mThickness = mWidth;
        invalidate();
        requestLayout();
    }

    public void setColor(int mColor) {
        this.mColor = mColor;
        invalidate();
        requestLayout();
    }

    public void setIsVertical(boolean mIsVertical) {
        this.mIsVertical = mIsVertical;
        invalidate();
        requestLayout();
    }
}