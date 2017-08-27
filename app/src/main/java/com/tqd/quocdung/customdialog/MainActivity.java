package com.tqd.quocdung.customdialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView access;
    final String pass= "123456789";
    final String name = "Lepdeptrai";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        access = (TextView) findViewById(R.id.txtLogin);
        access.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogLogin();
            }
        });

    }

    private void DialogLogin()
    {
        Dialog dialogLogin = new Dialog(this);
        dialogLogin.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogLogin.setContentView(R.layout.custom_dialog);
        dialogLogin.setCanceledOnTouchOutside(false);
        dialogLogin.setTitle("Access system");
        final EditText username = (EditText) dialogLogin.findViewById(R.id.editTextUsername);
        final EditText password = (EditText) dialogLogin.findViewById(R.id.editTextPassword);
        Button login = (Button) dialogLogin.findViewById(R.id.ButtonLogin);
        Button logout =(Button) dialogLogin.findViewById(R.id.ButtonLogout);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString() == name && password.getText().toString().trim() == pass)
                {
                    Toast.makeText(MainActivity.this, username.getText(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Access successful!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Access failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.setText(null);
                password.setText(null);
                Toast.makeText(MainActivity.this, "You have logout", Toast.LENGTH_SHORT).show();
            }
        });
        dialogLogin.show();
    }

}
