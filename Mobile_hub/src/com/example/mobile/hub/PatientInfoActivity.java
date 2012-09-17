package com.example.mobile.hub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PatientInfoActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patient_info);
		
		Button b=(Button) findViewById(R.id.button1);
		b.setOnClickListener(this);  
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(PatientInfoActivity.this, EditPatientInfoActivity.class);
		startActivity(intent);
	}
	
	
}
