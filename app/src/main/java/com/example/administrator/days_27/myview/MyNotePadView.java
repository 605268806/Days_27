package com.example.administrator.days_27.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

import com.example.administrator.days_27.R;

/**
 * Created by Administrator on 16-5-31.
 */
public class MyNotePadView extends EditText{

    private Paint mPaint;
    private int lineColor;
    private float lineWidth;

    public MyNotePadView(Context context){
        super(context);
        initPaint();
    }

    public MyNotePadView(Context context, AttributeSet attrs){
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.my_custom_attr);
        lineColor = typedArray.getColor(R.styleable.my_custom_attr_line_color, Color.GREEN);
        lineWidth = typedArray.getDimension(R.styleable.my_custom_attr_line_width, 1);
        typedArray.recycle();
        initPaint();
    }

    private void initPaint(){
        mPaint = new Paint();
        mPaint.setColor(lineColor);
        mPaint.setStrokeWidth(lineWidth);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int lineHeight = getLineHeight();
        int width = getWidth();
        int count = getHeight()/lineHeight;
        int inputLineCount = getLineCount();
        count = count>inputLineCount?count:inputLineCount;
        for(int i = 0; i < count; i++){
            float startX = 0;
            float startY = (1+i)*lineHeight;
            float stopX = width;
            float stopY = startY;
            canvas.drawLine(startX,startY,stopX,stopY,mPaint);
        }
    }
}
