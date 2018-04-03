package com.example.zf.talk;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class test extends BsaeActivity {
    private EditText gamename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
            actionBar.hide();
        }
        gamename = (EditText)findViewById(R.id.shuru1);
        Button button = (Button)findViewById(R.id.Button_4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button button1 = (Button)findViewById(R.id.kaishi);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gamename1 = gamename.getText().toString();
                Intent intent = new Intent(test.this,File.class);
                intent.putExtra("extra_data",gamename1);
                startActivity(intent);
            }
        });
        Button forceOffline1 =(Button)findViewById(R.id.Button_6);
        forceOffline1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.brosdcastbestpractice.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}
