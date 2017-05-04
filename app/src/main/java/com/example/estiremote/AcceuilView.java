package com.example.estiremote;

import android.os.Bundle;

import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.app.Activity;
import android.content.Intent;

public class AcceuilView extends Activity {

	 // used to know if the back button was pressed in the splash screen activity and avoid opening the next activity
  
	 private static String TAG = AcceuilView.class.getName();
	   private static long SLEEP_TIME = 3;    // Sleep for some time
	 


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);    // Removes title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);    // Removes notification bar
   
        setContentView(R.layout.acceuil_view);
   
        // Start timer and launch main activity
        IntentLauncher launcher = new IntentLauncher();
        launcher.start();
     }
   
     private class IntentLauncher extends Thread {
        @Override
        /**
         * Sleep for some time and than start new activity.
         */
        public void run() {
           try {
              // Sleeping
              Thread.sleep(SLEEP_TIME*1000);
           } catch (Exception e) {
              Log.e(TAG, e.getMessage());
           }
   
           // Start main activity
           Intent intent = new Intent(AcceuilView.this, RechercheView.class);
           AcceuilView.this.startActivity(intent);
           AcceuilView.this.finish();
        }
     }
  }