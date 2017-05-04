package com.example.estiremote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Touchpad extends Activity implements OnClickListener {
	protected ImageView interface_touchpad;
    Button button_gauche,button_droite,button_keyboard;

    public static final int Touchpad_begin=10;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.touchpad);
		
				
button_gauche =((Button)this.findViewById(R.id.gauche_touchpad));
button_gauche.setOnClickListener(this);

button_droite =((Button)this.findViewById(R.id.droite_touchpad));
button_droite.setOnClickListener(this);

button_keyboard=((Button)this.findViewById(R.id.keyboard));
button_keyboard.setOnClickListener(this);
	
	}
	
	public boolean onTouchEvent(MotionEvent event) {
	    	int x=(int)event.getX();
	    	int y=(int)event.getY();
	    	
	    	String msg="T";
	    	switch(event.getAction()){
	    	case MotionEvent.ACTION_DOWN:
	    		msg=msg+x+"A"+y;
	    		send(msg);
	    		break;
	    		
	    	case MotionEvent.ACTION_UP:
	    		msg=msg+x+"A"+y;    	
	    		send(msg);
	    		break;
	    		
	    	case MotionEvent.ACTION_MOVE:
	    		msg=msg+x+"A"+y;
	    		send(msg);
	    		break;
	    	
	    	}
	     	return super.onTouchEvent(event);
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
	public void onClick(View arg0) {
		if(arg0.getId() == R.id.gauche_touchpad)
		{
			send("G");
		}
		else if(arg0.getId()==R.id.droite_touchpad)
		{
			send("D");
			
		}
		else if(arg0.getId() == R.id.keyboard)
		{
			
			
		}
	}
	
	
	
	 
}
