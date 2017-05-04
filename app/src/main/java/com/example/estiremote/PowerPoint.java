package com.example.estiremote;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class PowerPoint extends Activity implements OnClickListener{
	Button avant,apres;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.powerpoint);
		apres =((Button)this.findViewById(R.id.avant));
		apres.setOnClickListener(this);

		avant =((Button)this.findViewById(R.id.apres));
		avant.setOnClickListener(this);
	
	}
	public void send(String msg) {
		 
		 try{
          Bluetooth.wr(msg.getBytes());    
		 }catch (NullPointerException e)
		 {
			 Toast.makeText(getApplicationContext(),"erreur d'envoie", 0).show(); 
		 }
		 }
	@Override
	public void onClick(View a) {
		if(a.getId()==R.id.avant)
		{
			send("A");
		}
		if(a.getId()==R.id.apres)
		{
			send("B");
			
		}
	}
}
