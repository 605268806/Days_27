package com.example.administrator.days_27;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.days_27.myview.PubuLayout;

import java.io.IOException;
import java.io.InputStream;

public class PubuTestActivity extends AppCompatActivity{

    private PubuLayout pubuLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pubu_test);
        pubuLayout = (PubuLayout) findViewById(R.id.pubu_Layout);
        /*
        pubuLayout.addImg(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        pubuLayout.addImg(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        pubuLayout.addImg(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        pubuLayout.addImg(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));*/
        AssetManager assetsManager = getAssets();
        try{
            String[] imagesFileNames = assetsManager.list("images");
            for(int i = 0; i < imagesFileNames.length; i++){
                InputStream inputStream = assetsManager.open("images/" + imagesFileNames[i]);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                pubuLayout.addImg(bitmap);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
