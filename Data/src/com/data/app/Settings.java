package com.data.app;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class Settings extends Activity implements OnClickListener {
	
	CheckBox cb;
	EditText et;
	Button b;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        cb = (CheckBox) findViewById(R.id.checkBox1);
        et = (EditText) findViewById(R.id.EditText1);
        b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(this);

    	cb.setOnClickListener(new OnClickListener() {
     
    		@Override
    		public void onClick(View v) {
    			//is checkbox checked?
    			if (((CheckBox) v).isChecked()) {
    				b.setText("Save and quit");
    			} else {
    				b.setText("Quit");
    			}
     
    		}
    	});
        
    	loadPrefs(); //loads default preferences
        
    }

    //loads saved preferences and sets default string for textbox
    private void loadPrefs() {
    	SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this); //Needed for data handling
    	boolean cbValue = sp.getBoolean("CHECKBOX", false); //sets default value to "checkbox"
    	String name = sp.getString("NAME", "Name");
    	if(cbValue){
    		cb.setChecked(true);
    		b.setText("Save and quit");
    	} else {
    		cb.setChecked(false);
    		b.setText("Quit");
    	}
        et.setText(name);
    }
    
    //Saves boolean value for checkbox
    private void savePrefs(String key, boolean value){
    	SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this); //Needed for data handling
    	Editor edit = sp.edit();
    	edit.putBoolean(key, value);
    	edit.commit();
    }
    
    //Saves String for edit text
    private void savePrefs(String key, String value){
    	SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
    	Editor edit = sp.edit();
    	edit.putString(key, value);
    	edit.commit();	    
    }

	@Override
	public void onClick(View v) {
		savePrefs("CHECKBOX", cb.isChecked());
		if (cb.isChecked()){
			savePrefs("NAME", et.getText().toString());
		}
		
		finish(); //closes activity after click
		
	}
	    
}
