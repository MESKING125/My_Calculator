package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.Window;
import android.view.WindowManager;



public class MainActivity extends AppCompatActivity {


    // creating constant keys for shared preferences.
    public static final String SHARED_PREFS = "shared_prefs";

    // key for storing email.
    public static final String EMAIL_KEY = "email_key";

    // key for storing password.
    public static final String PASSWORD_KEY = "password_key";

    SharedPreferences sharedpreferences;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        EditText txtUsername;
        EditText txtPassword;
        Button btnLogin;

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnPassword);

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        email = sharedpreferences.getString(EMAIL_KEY, null);
        password = sharedpreferences.getString(PASSWORD_KEY, null);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();
                if (username.equalsIgnoreCase("admin") &&
                        password.equalsIgnoreCase("admin")){
//                    Toast.makeText(getApplicationContext(), "Sukses Login", Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Sukses")
                            .setMessage("Login Sukses")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Continue with delete operation
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton(android.R.string.no, null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();

                            SharedPreferences.Editor editor = sharedpreferences.edit();

                            // below two lines will put values for
                            // email and password in shared preferences.
                            editor.putString(EMAIL_KEY, txtUsername.getText().toString());
                            editor.putString(PASSWORD_KEY, txtPassword.getText().toString());

                            // to save our data with key and value.
                            editor.apply();

                            Intent intent= new Intent(MainActivity.this,CalculatorActivity.class);
                            startActivity(intent);
                            finish();

                }else{
                    Toast.makeText(getApplicationContext(), "Gagal Login", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}



