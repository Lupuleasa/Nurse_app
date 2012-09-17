package com.example.mobile.hub;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true; 
    }
    
    public void onLogin(View button)
    {
    	Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
    	startActivity(loginIntent);
    }
}
