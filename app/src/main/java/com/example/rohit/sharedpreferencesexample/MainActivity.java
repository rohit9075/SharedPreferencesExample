package com.example.rohit.sharedpreferencesexample;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
    SharedPreferences sharedpreferences;
    EditText name;
    EditText email;
    public static final String mypreference = "mySharedPreference";
    public static final String NameKey = "name";
    public static final String EmailKey = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

// checking for name and email id in the sharedpreferenc file
        if (sharedpreferences.contains(NameKey)) {
            name.setText(sharedpreferences.getString(NameKey, ""));
        }
        if (sharedpreferences.contains(EmailKey)) {
            email.setText(sharedpreferences.getString(EmailKey, ""));
            }
    }

    public void Save(View view) {

        String stringName = name.getText().toString();
        String stirngEmail = email.getText().toString();

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(NameKey, stringName);
        editor.putString(EmailKey, stirngEmail);
        editor.apply();
    }

    public void clear(View view) {
        name = findViewById(R.id.etName);
        email =  findViewById(R.id.etEmail);

        name.getText().clear();
        email.getText().clear();

    }

    public void Get(View view) {

        name =  findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
// checking for name and id in the shared Preference file
        if (sharedpreferences.contains(NameKey)) {
            name.setText(sharedpreferences.getString(NameKey, ""));
        }
        if (sharedpreferences.contains(EmailKey)) {
            email.setText(sharedpreferences.getString(EmailKey, ""));

        }
    }

}