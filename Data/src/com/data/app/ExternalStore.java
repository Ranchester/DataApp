package com.data.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ExternalStore extends Activity implements OnClickListener {
	
	Button savePic, saveSound;
	EditText filename;
	boolean isSDavailable = false;
	boolean isSDwriteable = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_externalstore);
		savePic = (Button)findViewById(R.id.savePicture);
		saveSound = (Button)findViewById(R.id.saveSound);
		filename = (EditText)findViewById(R.id.filename);
		savePic.setOnClickListener(this);
		saveSound.setOnClickListener(this);
		checkSD();
	}
	
	private void checkSD() {
		// TODO Auto-generated method stub
		String state = Environment.getExternalStorageState();
		if(Environment.MEDIA_MOUNTED.equals(state)){
			//write
			isSDavailable = true;
			isSDwriteable = true;
		} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
			//read only
			isSDavailable = true;
			isSDwriteable = false;			
		} else {
			//SD missing
			isSDavailable = false;
			isSDwriteable = false;
		}
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
