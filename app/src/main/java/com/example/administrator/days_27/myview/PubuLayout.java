package com.example.administrator.days_27.myview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-31.
 */
public class PubuLayout extends ScrollView{

    private Context context;
    private ImageView imgView;

    public PubuLayout(Context context){
        super(context);
        initLayout(context);
    }

    public PubuLayout(Context context, AttributeSet attrs){
        super(context, attrs);
        initLayout(context);
    }

    private void initLayout(Context context){
        this.context = context;
        LinearLayout hLayout = new LinearLayout(context);
        hLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1);
        for(int i = 0; i < 3; i++){
            LinearLayout vLayout = new LinearLayout(context);
            vLayout.setOrientation(LinearLayout.VERTICAL);

            vLayout.setLayoutParams(params);

            chidLayoutList.add(vLayout);
            hLayout.addView(vLayout);
        }

        this.addView(hLayout);
    }

    List<LinearLayout> chidLayoutList = new ArrayList<>();
    int count = 0;
    public void addImg(Bitmap bitmap){
        imgView = new ImageView(context);
        imgView.setImageBitmap(bitmap);

        imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imgView.setAdjustViewBounds(true);

        int index = count%3;
        chidLayoutList.get(index).addView(imgView);
        count++;

        ViewTreeObserver observer = imgView.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(){
            @Override
            public void onGlobalLayout(){
                imgView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int imgHeight = imgView.getHeight();
                Log.e("PubuLayout", "imgHeight:" + imgHeight);
            }
        });
    }
}
