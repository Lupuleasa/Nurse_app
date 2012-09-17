package com.example.mobile.hub;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MeasurementsTabActivity extends TabActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.measurements_tab);
		
		TabHost tabHost = getTabHost();
	
		 // Tab for today
        TabSpec todaySpec = tabHost.newTabSpec("Today");
        todaySpec.setIndicator("Today");
        Intent dayIntent = new Intent(this, MeasurementsValuesActivity.class);
        todaySpec.setContent(dayIntent);
        
        // Tab for this week
        TabSpec weekSpec = tabHost.newTabSpec("Week");
        weekSpec.setIndicator("This week");
        Intent weekintent = new Intent(this, MeasurementsValuesActivity.class);
        weekSpec.setContent(weekintent);
        
        // Tab for this month
        TabSpec monthSpec = tabHost.newTabSpec("Month");
        monthSpec.setIndicator("This month");
        Intent monthintent = new Intent(this, MeasurementsValuesActivity.class);
        monthSpec.setContent(monthintent);
        
        
         tabHost.addTab(todaySpec);
         tabHost.addTab(weekSpec);
         tabHost.addTab(monthSpec);
	}
}
