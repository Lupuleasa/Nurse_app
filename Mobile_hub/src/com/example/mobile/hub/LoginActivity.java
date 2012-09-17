package com.example.mobile.hub;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class LoginActivity extends Activity{
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.login);
	    	
	    	
		}
		
		 public void onLogin(View button)
		 {
			 Intent loginIntent = new Intent(LoginActivity.this, HomeActivity.class);
			 startActivity(loginIntent);
			 new AsyncTask<String, Void, String[]>()
			 {

				@Override
				protected String[] doInBackground(String... arg0) {
					// TODO Auto-generated method stub
					
					try
					{
						HttpPost request = new HttpPost("http://app.dignio.com/");	
						//HttpClient mClient = new DefaultHttpClient();
						//HttpResponse response =mClient.execute(request);  
						//HttpEntity entity = response.getEntity();
						//Log.d("srgd","connect123 " + entity.toString());
						//request.addHeader("HOST", HOST);
						//request.addHeader("Application", "web-site");
					}
					catch(Exception e)
					{
						Log.d("srgd","connect123 " + e.toString());
					}
					
					return null;
				}
				 
			 }.execute(new String[] { "email", "password" });
		 }
		 
		 
}
