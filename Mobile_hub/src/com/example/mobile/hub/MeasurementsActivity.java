package com.example.mobile.hub;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class MeasurementsActivity extends ListActivity implements OnItemClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.measurements);
		
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1
				,getResources().getStringArray(R.array.measurements)));
		getListView().setOnItemClickListener(this);
	}	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(MeasurementsActivity.this, MeasurementsTabActivity.class);
		startActivity(intent);
	}
}
