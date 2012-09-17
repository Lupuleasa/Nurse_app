package com.example.mobile.hub;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableRow;

public class EditPatientInfoActivity extends Activity implements OnClickListener{

	
	private static final int SELECT_PICTURE = 1;
	private String selectedImagePath;
	private String filemanagerstring;
	
	
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_patient_info);
		
		ImageView view=(ImageView) findViewById(R.id.imageView1);
		view.setOnClickListener(this);  
	 }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,
                "Select Picture"), SELECT_PICTURE); 
	}  
	
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
    	
		if (requestCode == SELECT_PICTURE && resultCode == RESULT_OK && null != data) {
			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };

			Cursor cursor = getContentResolver().query(selectedImage,
					filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			String picturePath = cursor.getString(columnIndex);
			cursor.close();
			
			ImageView imageView = (ImageView) findViewById(R.id.imageView1);
			imageView.setLayoutParams(new TableRow.LayoutParams(100, 100));
			imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
			
		 
		}
    
    
    }
}
