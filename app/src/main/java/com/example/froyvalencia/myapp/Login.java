package com.example.froyvalencia.myapp;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;

import android.bluetooth.le.BluetoothLeScanner;
import android.content.Intent;
import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**

created by Froylan Valencia on 1/30/16
*/

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button bLogin;
    EditText etUsername, etPassword;
    TextView tvRegisterLink;
    UserLocalStore userLocalStore;
    private TextView info;
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FacebookSdk.sdkInitialize(getApplicationContext());

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
        bLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);

        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_login);
        info = (TextView)findViewById(R.id.info);
        loginButton = (LoginButton)findViewById(R.id.login_button);




        userLocalStore = new UserLocalStore(this);

    }
    /*
    loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

        @Override
        public void onSuccess(LoginResult loginResult) {
            info.setText("User ID: " + loginResult.getAccessToken().getUserId() + "\n" + "Auth Token: " + loginResult.getAccessToken().getToken());
        }

        @Override
        public void onCancel() {
            info.setText("Login attempt canceled.");
        }

        @Override
        public void onError(FacebookException e) {
            info.setText("Login attempt failed.");
        }
    });
    */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);

   }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bLogin:
                User user = new User(null,null);

                userLocalStore.storeUserData(user);
                userLocalStore.setUserLoggedIn(true);

                // String username = etUsername.getText().toString();
                //String password = etPassword.getText().toString();

                //User user = new User(username, password);
                //authenticate(user);
                break;
            case R.id.tvRegisterLink:
                startActivity(new Intent(this, Register.class));
                break;

        }
    }




}
