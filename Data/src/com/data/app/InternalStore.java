package com.data.app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class InternalStore extends Activity implements OnClickListener{
	
	Button save;
	EditText filename, entry;
	private String FILENAME; //string for named file
	private String JOURNAL_ENTRY; //text to be saved to the file

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_internalstore);
		save = (Button)findViewById(R.id.button1);
		save.setOnClickListener(this);
		filename = (EditText)findViewById(R.id.editText1);
		entry = (EditText)findViewById(R.id.editText2);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		FILENAME = filename.getText().toString(); //edittext content to FILENAME string
		//if edittext is empty filename is untitled
		if(FILENAME.contentEquals("")){
			FILENAME = "UNTITLED";
		}
		JOURNAL_ENTRY = entry.getText().toString();
		
		//saving the file
		FileOutputStream fos;
		try {
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE); //opens a file FILENAME(with edittext content) in private mode
			fos.write(JOURNAL_ENTRY.getBytes()); //writes JURNAL_ENTRY string inside the file
			fos.close(); //file stream close
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
