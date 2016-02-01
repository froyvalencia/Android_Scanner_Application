package com.example.froyvalencia.myapp;

import com.facebook.FacebookSdk;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bLogout;
    Button scan;
    EditText etName, etAge, etUsername;
    UserLocalStore userLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FacebookSdk.sdkInitialize(getApplicationContext());

        etName= (EditText) findViewById(R.id.etName) ;
        etAge= (EditText) findViewById(R.id.etAge);
        etUsername=  (EditText) findViewById(R.id.etUsername);
        bLogout= (Button) findViewById(R.id.bLogout);
        scan = (Button) findViewById(R.id.scan);
        bLogout.setOnClickListener(this);
        scan.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);

    }


    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bLogout:
                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false);
                Intent loginIntent = new Intent(this, Login.class);
                startActivity(loginIntent);
                break;
            case R.id.scan:
                startActivity(new Intent(this, Scanner.class));
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (authenticate() == true) {
           // displayUserDetails();
        }
    }
    /*
    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }*/

    private boolean authenticate() {
        //userLocalStore.getUserLoggedIn())
        return true;
    }
/*
    private void displayUserDetails() {
        User user = userLocalStore.getLoggedInUser();
        etUsername.setText(user.username);
        etName.setText(user.name);
        etAge.setText(user.age);
    }
*/
}
