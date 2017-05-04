package com.example.estiremote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ChoixView extends Activity implements OnClickListener {
	Button touchpad,souris,point;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choix);
		Toast monToast;
		monToast = Toast.makeText(getApplicationContext(), "Thanks for connect", 0);
		monToast.setGravity(Gravity.CENTER,0, 0);
		monToast.show();
		touchpad = ((Button)this.findViewById(R.id.touchpad));
	    touchpad.setOnClickListener(this);

        souris = ((Button)this.findViewById(R.id.Power));
	    souris.setOnClickListener(this);
	    point = ((Button)this.findViewById(R.id.Power));
	    point.setOnClickListener(this);
	
	}
	@Override
	public void onClick(View v) {
		
		if(v.getId() == R.id.touchpad)
		{
			Intent intent = new Intent (this,Touchpad.class);
			this.startActivityForResult(intent, 1000);
		}
		if(v.getId() == R.id.souris)
		{

			Intent intent = new Intent (this,Souris_classique.class);
			this.startActivityForResult(intent, 1000);
			
		}
		if(v.getId() == R.id.Power)
		{

			Intent intent = new Intent (this,PowerPoint.class);
			this.startActivityForResult(intent, 1000);
			
		}
	}
}
