package com.data.app;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class Reading extends Activity implements OnClickListener {
	
	Spinner spinner;
	TextView title, entry;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reading);
		spinner = (Spinner)findViewById(R.id.spinner1);
	    title = (TextView)findViewById(R.id.textView1);
	    entry = (TextView)findViewById(R.id.textView2);
		getFilesNames();
	}

	private void getFilesNames() {
		// TODO Auto-generated method stub
		String[] filenames = getApplicationContext().fileList(); //string table for filenames
		List<String> list = new ArrayList<String>(); //List for 
		//Loops the filenames table
		for(int i = 0; i<filenames.length; i++){
			//Log.d("Filename", filenames[i]); //for logging
			list.add(filenames[i]);
		}
		
		ArrayAdapter<String> filenamesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
		spinner.setAdapter(filenamesAdapter);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	

}
