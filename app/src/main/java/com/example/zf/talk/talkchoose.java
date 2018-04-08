package com.example.zf.talk;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class talkchoose extends BsaeActivity {
    private String[] data = {"轩辕铁牛","上官翠花","欧阳铁柱","二营长的意大利炮","李泽言"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talkchoose);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                talkchoose.this,android.R.layout.simple_list_item_1,data
        );
        Button button = (Button)findViewById(R.id.Button_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(talkchoose.this,test.class);
                startActivity(intent);
            }
        });
        ListView listView2= (ListView)findViewById(R.id.recycler_1);
        listView2.setAdapter(adapter);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(talkchoose.this,MainActivity.class);
                if(position == 0) {startActivity(intent1);}
                //setResult(RESULT_OK, intent);
                //finish();
            }
        });

        Button forceOffline =(Button)findViewById(R.id.Button_3);    //发送下线广播
        forceOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.brosdcastbestpractice.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}
