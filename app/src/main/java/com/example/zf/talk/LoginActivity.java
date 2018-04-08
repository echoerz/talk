package com.example.zf.talk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BsaeActivity {
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
            actionBar.hide();
        }//隐藏标题栏

        pref = PreferenceManager.getDefaultSharedPreferences(this);  //记住密码参数
        accountEdit = (EditText)findViewById(R.id.account);         //获取账号ID
        passwordEdit = (EditText)findViewById(R.id.password);       //获取密码ID
        rememberPass = (CheckBox)findViewById(R.id.remember_pass);  // 获取是否记住密码ID
        login = (Button) findViewById(R.id.login);

        boolean isRemember = pref.getBoolean("remember_password",false);
        if (isRemember){
            String ac = pref.getString("account","");
            String ps = pref.getString("password","");
            accountEdit.setText(ac);
            passwordEdit.setText(ps);
            rememberPass.setChecked(true);
        }                                       //读取文件中账户密码

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                    //按键判断是否登陆
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if (account.equals("zijie") && password.equals("5201314")){
                    //账号是否正确
                   // Toast.makeText(LoginActivity.this,"登陆成功",
                   //         Toast.LENGTH_SHORT).show();

                    editor = pref.edit();
                    if (rememberPass.isChecked()){
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }else {
                        editor.clear();
                    }
                    editor.apply();                      //保存密码

                    Intent intent = new Intent(LoginActivity.this,talkchoose.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this,"账户或密码错误",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
