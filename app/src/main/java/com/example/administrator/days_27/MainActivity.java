package com.example.administrator.days_27;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        String[] titles = {"自定义记事本","瀑布照片墙"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,titles);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        switch(position){
            case 0:
                Intent intent0 = new Intent(MainActivity.this,MyNotePadTestActivity.class);
                startActivity(intent0);
                break;
            case 1:
                Intent intent1 = new Intent(MainActivity.this,PubuTestActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
