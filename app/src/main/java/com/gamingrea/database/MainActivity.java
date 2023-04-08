package com.gamingrea.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity  extends AppCompatActivity {

    EditText nameRegister;
    EditText usernameRegister;
    EditText passwordRegister;
    Button register;
    EditText usernameLogin;
    EditText passwordLogin;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameRegister = findViewById(R.id.nameRegister);
        usernameRegister = findViewById(R.id.usernameRegister);
        passwordRegister = findViewById(R.id.passwordRegister);
        register = findViewById(R.id.register);
        usernameLogin = findViewById(R.id.usernameLogin);
        passwordLogin = findViewById(R.id.passwordLogin);
        login = findViewById(R.id.login);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameRegister.getText().toString();
                String username = usernameRegister.getText().toString();
                String password = passwordRegister.getText().toString();
                String url = "https://192.168.240.44/myproject/insertData.php";
                String type = "register";
                BackgroundWorker backgroundWorker = new BackgroundWorker(MainActivity.this);
                backgroundWorker.execute(url,type,name,username,password);
                Log.d("back","check");
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameLogin.getText().toString();
                String password = passwordLogin.getText().toString();
                String url = " https://192.168.240.44/myproject/validateData.php";
                String type = "login";
                BackgroundWorker backgroundWorker = new BackgroundWorker(MainActivity.this);
                backgroundWorker.execute(url,type,username,password);
            }
        });

    }
}