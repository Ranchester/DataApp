package com.data.app;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Numbers extends Activity implements OnClickListener{

    EditText number;
    Button sendInfo;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        number = (EditText) findViewById(R.id.editText1);
        sendInfo = (Button) findViewById(R.id.button1);
        sendInfo.setOnClickListener(this);
        
    }
    
    @Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
