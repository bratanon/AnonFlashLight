package com.example.anonflashlight;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.widget.Toast;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	/**
	 * 
	 */
	private Camera camera;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onToggleClicked(View view) {
		// Is the toggle on?
		boolean on = ((ToggleButton) view).isChecked();

		if (on) {
			this.turnOn();
		} else {
			this.turnOff();
		}
	}

	/**
	 * Turn the flashlight on.
	 */
	private void turnOn() {
		// Show awesome message.
		Toast onMSG = Toast.makeText(this, "Flashlight is on!",
				Toast.LENGTH_SHORT);
		onMSG.show();

		// Get the camera object.
		this.camera = Camera.open();

		// Get camera params.
		Parameters p = camera.getParameters();

		// Set the flash to constant light.
		p.setFlashMode(Parameters.FLASH_MODE_TORCH);
		this.camera.setParameters(p);
	}

	/**
	 * Turn the flashlight off.
	 */
	private void turnOff() {
		// Show awesome message.
		Toast offMSG = Toast.makeText(this, "Flashlight is off!",
				Toast.LENGTH_SHORT);
		offMSG.show();

		// Release the camera, this will turn the flash off.
		this.camera.release();
	}

}
