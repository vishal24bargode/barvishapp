package com.mva;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mva.db.DatabaseHandler;
import com.mva.dto.User;

public class LoginActivity extends Activity {
	private EditText loginId,password;
	private static DatabaseHandler db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		//test
		db = new DatabaseHandler(this);
		db.addUser(new User(1,"jayant","jay@123"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	public void login(View view)
	{
		loginId=(EditText)findViewById(R.id.loginId);  
		password=(EditText)findViewById(R.id.password);  
		
		User user = db.getUser(loginId.getText().toString().trim(), password.getText().toString().trim());
    	if(user != null)
    	{
    		//correct password
    		Intent intent = new Intent(getApplicationContext(), MainActivity.class);  
    		startActivity(intent); 
    	} else {
    		//wrong password
    		Toast.makeText(getApplicationContext(),"Fail",Toast.LENGTH_SHORT).show();    		
		}
	}
	
}
