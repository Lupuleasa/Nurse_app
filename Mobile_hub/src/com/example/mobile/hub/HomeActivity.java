package com.example.mobile.hub;

import java.lang.reflect.Method;

import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class HomeActivity extends ListActivity implements OnItemClickListener {
	
	private static final int REQUEST_ENABLE_BT = 1;
	private BluetoothAdapter bluetoothAdapter;
	private BluetoothSocket mmSocket;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1
				,getResources().getStringArray(R.array.home_activities)));
		getListView().setOnItemClickListener(this);
		
		
		 bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
	     Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
	     startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
			
	     CheckBlueToothState();
	        
	     IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
	     registerReceiver(ActionFoundReceiver, intentFilter);
	        
	     bluetoothAdapter.startDiscovery();
	}
  
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		switch(arg2)
		{
			case 0://Measurements
			{
				Intent intent = new Intent(HomeActivity.this, MeasurementsActivity.class);
				startActivity(intent);
				break;
			}
			case 2://Patient Info
			{
				Intent intent = new Intent(HomeActivity.this, PatientInfoActivity.class);
				startActivity(intent);
				break;
			}
			
		}
	}
	
	
	private BroadcastReceiver ActionFoundReceiver = new BroadcastReceiver(){

		  @Override
		  public void onReceive(Context context, Intent intent) {
		   // TODO Auto-generated method stub

		   Log.d("Bluetooth","Bluetooth onReceive");
		   String action = intent.getAction();
		   if(BluetoothDevice.ACTION_FOUND.equals(action)) {
		             BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
		             Log.d("Bluetooth","Bluetooth getName " + device.getName() + " " + device.getAddress());
		             if(device.getName().equals(new String("TaiDoc-Device")))
		             {
		            	 BluetoothDevice termodevice=bluetoothAdapter.getRemoteDevice(device.getAddress());
		                 {

		                	 try
		                	 { 
		                		 Method m = termodevice.getClass().getMethod("createRfcommSocket", new Class[] {int.class});
		                		 mmSocket=(BluetoothSocket) m.invoke(device, 1);
		                		 
		                		// mmSocket = termodevice.createRfcommSocketToServiceRecord(u);
		                		 
		                		 
		                		 mmSocket.connect();
		                		 Log.d("Bluetooth","Bluetooth "+ mmSocket.toString());	                	 	
		                	 }
		                	 catch(Exception e)
		                	 {
		                		 Log.d("Eroare","Bluetooth "+ e.toString());
		                	 }
		                 }
		             }
		             
		             else
		            	 if(device.getName().equals(new String("Spirodoc - SN:W01892")))
		            	 {
		            		 BluetoothDevice spirodoc=bluetoothAdapter.getRemoteDevice(device.getAddress());
		            		 try
		                	 { 
		                		 Method m = spirodoc.getClass().getMethod("createRfcommSocket", new Class[] {int.class});
		                		 mmSocket=(BluetoothSocket) m.invoke(device, 1);		                		 
		                		 mmSocket.connect();
		                		 Log.d("Bluetooth","Bluetooth "+ mmSocket.toString());	                	 	
		                	 }
		                	 catch(Exception e)
		                	 {
		                		 Log.d("Eroare","Bluetooth "+ e.toString());
		                	 }
		            	 } 
		         }
		  }};
	
	private void CheckBlueToothState(){
	     if (bluetoothAdapter != null)
	     {
	         if (bluetoothAdapter.isEnabled())
	         {
	        	 if(bluetoothAdapter.isDiscovering())
	        	 {
	        		 Log.d("Bluetooth","Bluetooth is receiving");
	        	 }
	         } 
	         else
	         {
	        	 Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
	             startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
	         }
	       }
	    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		  if(requestCode == REQUEST_ENABLE_BT){
			   CheckBlueToothState();
		  }
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		bluetoothAdapter.cancelDiscovery();
		unregisterReceiver(ActionFoundReceiver);
	}

} 
