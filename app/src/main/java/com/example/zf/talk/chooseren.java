package com.example.zf.talk;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class chooseren extends AppCompatActivity {
    private String[] data1 = {"轩辕铁牛","上官翠花","欧阳铁柱","二营长的意大利炮","李泽言"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseren);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.hide();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                chooseren.this,android.R.layout.simple_list_item_1,data1
        );
        ListView listView1 = (ListView)findViewById(R.id.recycler_2);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                if(position == 0) {intent.putExtra("data_return", "0");}
                if(position == 1) {intent.putExtra("data_return", "1");}
                if(position == 2) {intent.putExtra("data_return", "2");}
                if(position == 3) {intent.putExtra("data_return", "3");}
                if(position == 4) {intent.putExtra("data_return", "4");}
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }
}
