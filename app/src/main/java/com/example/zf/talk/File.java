package com.example.zf.talk;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class File extends AppCompatActivity {
    MediaPlayer mediaPlayer1 = null;
    MediaPlayer mediaPlayer2 = null;
    MediaPlayer mediaPlayer3 = null;
    MediaPlayer mediaPlayer4 = null;
    private ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
            actionBar.hide();
        }
        imageView1 = (ImageView) findViewById(R.id.gifImageView2);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.beijng);
        mediaPlayer2 = MediaPlayer.create(this,R.raw.hanxiu1);
        mediaPlayer3 = MediaPlayer.create(this,R.raw.ask);
        mediaPlayer4 = MediaPlayer.create(this,R.raw.richang1);
        mediaPlayer1.start();
        mediaPlayer1.setVolume(1,1);
        mediaPlayer1.setLooping(true);
        Button button1 = (Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mediaPlayer1.pause();
                Toast toast=Toast.makeText(getApplicationContext(), "哎呀，真不好意思", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                //创建图片视图对象
                ImageView imageView= new ImageView(getApplicationContext());
                //设置图片
                imageView.setImageResource(R.drawable.dong2);
                imageView.setAdjustViewBounds(true);
                imageView.setMaxWidth(100);
                imageView.setMaxHeight(100);
                //获得toast的布局
                LinearLayout toastView = (LinearLayout) toast.getView();
                //设置此布局为横向的
                toastView.setOrientation(LinearLayout.HORIZONTAL);
                //将ImageView在加入到此布局中的第一个位置
                toastView.addView(imageView, 0);
                toast.show();
                //imageView1.setImageResource(R.drawable.dong2);
                mediaPlayer2.setVolume(2,1);
                mediaPlayer2.start();
                //try
                //{
                //     Thread.currentThread().sleep(3100);//毫秒
                // }
                //  catch(Exception e){}
                //  mediaPlayer2.pause();
                // mediaPlayer1.start();
                //   Intent intent = new Intent(File.this, MainActivity.class);
                //   startActivity(intent);
                //Intent mainIntent = new Intent(File.this,MainActivity.class);
                //startActivity(mainIntent);
                //overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
            }
        });
        Button button2 = (Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mediaPlayer1.pause();
                Toast toast=Toast.makeText(getApplicationContext(), "可以吗", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                //创建图片视图对象
                ImageView imageView= new ImageView(getApplicationContext());
                //设置图片
                imageView.setImageResource(R.drawable.xizao);
                imageView.setAdjustViewBounds(true);
                imageView.setMaxWidth(100);
                imageView.setMaxHeight(100);
                //获得toast的布局
                LinearLayout toastView = (LinearLayout) toast.getView();
                //设置此布局为横向的
                toastView.setOrientation(LinearLayout.HORIZONTAL);
                //将ImageView在加入到此布局中的第一个位置
                toastView.addView(imageView, 0);
                toast.show();
                mediaPlayer3.setVolume(2,2);
                mediaPlayer3.start();
                //  mediaPlayer3.pause();
                // mediaPlayer1.start();
            }
        });
        Button button3 = (Button)findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mediaPlayer1.pause();
                Toast toast=Toast.makeText(getApplicationContext(), "啦啦啦啦啦", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                //创建图片视图对象
                ImageView imageView= new ImageView(getApplicationContext());
                //设置图片
                imageView.setImageResource(R.drawable.zoulu);
                imageView.setAdjustViewBounds(true);
                imageView.setMaxWidth(100);
                imageView.setMaxHeight(100);
                //获得toast的布局
                LinearLayout toastView = (LinearLayout) toast.getView();
                //设置此布局为横向的
                toastView.setOrientation(LinearLayout.HORIZONTAL);
                //将ImageView在加入到此布局中的第一个位置
                toastView.addView(imageView, 0);
                toast.show();
                mediaPlayer4.setVolume(2,2);
                mediaPlayer4.start();
                // try
                // {
                //     Thread.currentThread().sleep(2000);//毫秒
                // }
                // catch(Exception e){}
                // mediaPlayer4.pause();
                //  mediaPlayer1.start();
            }
        });
        Button button4 = (Button)findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(File.this,MainActivity.class);
                //startActivity(intent);
                startActivityForResult(intent, 1);
            }
        });
        Button button5 = (Button)findViewById(R.id.button_music1);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer1.pause();
            }
        });
        Button button6 = (Button)findViewById(R.id.button_music2);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer1.start();
            }
        });
        Button button7 = (Button)findViewById(R.id.button_return);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer1.stop();
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView textView = (TextView) findViewById(R.id.text1);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");
                    int b;
                    try {
                        b = Integer.valueOf(returnData).intValue();
                        if(b == 0) {
                            imageView1.setImageResource(R.drawable.dong3);
                            textView.setText("轩辕铁牛");
                        }
                        if(b == 1) {
                            imageView1.setImageResource(R.drawable.dong2 );
                            textView.setText("上官翠花");
                        }
                        if(b == 2) {
                            imageView1.setImageResource(R.drawable.xizao);
                            textView.setText("欧阳铁柱");
                        }
                        if(b == 3) {
                            imageView1.setImageResource(R.drawable.yidali);
                            textView.setText("二营长的意大利炮");
                        }
                        if(b == 4) {
                            imageView1.setImageResource(R.drawable.dong1);
                            textView.setText("许墨");
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }

                }
                break;
            default:
        }
    }
}
