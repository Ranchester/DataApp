package com.data.app;

import android.app.Activity;
import android.content.Intent;
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
		Intent i = new Intent(this, Numbers.class);
		
		switch(v.getId()) {
		case R.id.button1:
			// width button
			i.putExtra("numbers", "width"); //add data to intent,  data = String numbers = "width"
			startActivityForResult(i, 1);
			break;
		case R.id.button2:
			//height button
			i.putExtra("numbers", "height"); //add data to intent, data = String numbers = "height"
			startActivityForResult(i, 1);
			break;
		case R.id.button3:
			//calc button
			int a;
			int b;
			a = Integer.valueOf(width.getText().toString());
			b = Integer.valueOf(height.getText().toString());
			area.setText(a*b + "sq feet"); //set square feet to textarea
			break;
		
		}
							
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(data.getExtras().containsKey("widthInfo")){
			width.setText(data.getStringExtra("widthInfo"));
		}
		if(data.getExtras().containsKey("heightInfo")){
			height.setText(data.getStringExtra("heightInfo"));	
		}
	}
	
	
	
	

}
