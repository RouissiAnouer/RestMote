package com.example.estiremote;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Souris_classique extends Activity implements OnClickListener, SensorEventListener  {
	private Bluetooth mbluetooth=null;
    Button button_gauche,button_droite;	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.souris);
SensorManager sensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
        
        boolean accelSupported = sensorMgr.registerListener(this, sensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_UI);
        
		button_gauche =((Button)this.findViewById(R.id.gauche));
		button_gauche.setOnClickListener(this);
		button_droite =((Button)this.findViewById(R.id.droite));
		button_droite.setOnClickListener(this);
	}
public void send(String msg)
{
     	
 		byte [] bytes=msg.getBytes();
   mbluetooth.wr(bytes);
}
@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
 if(v.getId()==R.id.gauche)
	{send("G");}
 else if(v.getId()==R.id.droite)
 {send("D");}
}
@Override
public void onAccuracyChanged(Sensor arg0, int arg1) {
	// TODO Auto-generated method stub
	
}
@Override
public void onSensorChanged(SensorEvent event) {
	// TODO Auto-generated method stub
	float x,y,z;
	x = event.values[0];
	y = event.values[1];
	z = event.values[2];				
	String msg=x+" "+y;
	send(msg);
}
		
}