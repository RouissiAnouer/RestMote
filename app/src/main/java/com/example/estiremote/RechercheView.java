package com.example.estiremote;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RechercheView extends Activity implements OnClickListener {
Button button;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rechercheview);
		   button = ((Button)this.findViewById(R.id.button1));	  
		   button.setOnClickListener(this);
		 	
		 	
		 	}
		 	@Override
		 	public void onClick(View arg0) {
		 	Intent intent= new Intent(this,Bluetooth.class);
		 	this.startActivityForResult(intent, 1000);
		 	}
}