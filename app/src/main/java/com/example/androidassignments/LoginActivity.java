package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "LoginActivity";

    private Button loginBtn;
    private EditText editLoginTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(ACTIVITY_NAME, "In onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Read from SharedPreferences and set Login Text
        editLoginTxt = (EditText)findViewById(R.id.login_input); // Target Login input in activity_login.xml
        SharedPreferences getSP = getSharedPreferences("DefaultEmail", Context.MODE_PRIVATE);
        String defaultEmail = getResources().getString(R.string.DefaultEmailText); //get default email from strings.xml
        String emailText = getSP.getString(String.valueOf(R.string.SavedEmailText),defaultEmail);
        editLoginTxt.setText(emailText);

        loginBtn = (Button)findViewById(R.id.loginbtn);
        loginBtn.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){

               // Write email to SharedPreferences
               String loginTxt = editLoginTxt.getText().toString();
               SharedPreferences setSP = getSharedPreferences("DefaultEmail",Context.MODE_PRIVATE);
               SharedPreferences.Editor editor = setSP.edit();
               editor.putString(String.valueOf(R.string.SavedEmailText),emailText);
               editor.commit();

               Intent intent = new Intent(LoginActivity.this, MainActivity.class);
               startActivity(intent);
           }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }

}