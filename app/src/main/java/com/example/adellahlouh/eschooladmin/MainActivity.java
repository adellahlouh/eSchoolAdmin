package com.example.adellahlouh.eschooladmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button btn_login;
    EditText edt_email, edt_password;
    TextView txt_check;


//fuck you adel

///////////
    ///////////
    //////////
    //////////
    //////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.btn_login);
        edt_email = findViewById(R.id.edt_Email);
        edt_password = findViewById(R.id.edt_Pass);
        txt_check = findViewById(R.id.txt_check);


        btn_login.setOnClickListener(v -> {

            String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                    "\\@" +

                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                    "(" +

                    "\\." +

                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                    ")+";

            String email = edt_email.getText().toString();

            Matcher matcher = Pattern.compile(validemail).matcher(email);


            if (matcher.matches()) {

                txt_check.setVisibility(View.GONE);

            } else {
                txt_check.setVisibility(View.VISIBLE);
            }


        });


    }
}
