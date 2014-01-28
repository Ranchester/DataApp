package com.data.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CalcActivity extends Activity implements OnClickListener{
	
	Button width, height, calc;
	TextView area;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calcactivity);
		width = (Button)findViewById(R.id.button1);
		height = (Button)findViewById(R.id.button2);
		calc = (Button)findViewById(R.id.button3);
		area = (TextView)findViewById(R.id.textView1);
		
		width.setOnClickListener(this);
		height.setOnClickListener(this);
		calc.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
