package com.data.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
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
    	String s = number.getText().toString(); //gets the string to the extras called in CalcActivity putExtra(i, s)
    	Intent i = getIntent(); //gets intent to the extras called in CalcActivity
    	String msg = i.getStringExtra("numbers"); //names the extras "numbers" for CalcActivity to call
    	
    	if(msg.contentEquals("width")) { //if msg content set to string "width"
    		i.putExtra("widthInfo", s); //puts "widthInfo" string to extras called in CalcActivity
    		setResult(RESULT_OK, i);
    		finish();
    	}
    	
    	if(msg.contentEquals("height")){
    		i.putExtra("heightInfo", s);
    		setResult(RESULT_OK, i);
    		finish();
    	}
		
	}
}
