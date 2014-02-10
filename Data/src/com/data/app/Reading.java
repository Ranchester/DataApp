package com.data.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
		List<String> list = new ArrayList<String>(); //List for filenames
		//Loops the filenames table and adds filename to the list
		for(int i = 0; i<filenames.length; i++){
			//Log.d("Filename", filenames[i]); //for logging
			list.add(filenames[i]);
		}
		
		//sets adapter to the spinner
		ArrayAdapter<String> filenamesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list); 
		spinner.setAdapter(filenamesAdapter);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String selectFile = String.valueOf(spinner.getSelectedItem()); //gets content of spinner to the string
		openFile(selectFile);
		
	}

	private void openFile(String selectFile) {
		// TODO Auto-generated method stub
		String value = ""; //empty at default
		FileInputStream fis;
		
		try {
			fis = openFileInput(selectFile);
			byte[] input = new byte[fis.available()]; //array of bytes in selected file
			//while there's something to read in file input
			while(fis.read(input) != -1){
				value += new String(input); //puts string containing input to value
			}
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		entry.setText(value);
	}
	
	

}
