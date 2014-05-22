package com.example.invokinganactivtyfromservices;

import java.net.MalformedURLException;
import java.net.URL;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;

public class MyIntentService extends IntentService {

	public MyIntentService() {
		super("MyIntentServiceName");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		try {
			int result = DownloadFile(new URL(
					"http://siliconangle.com/files/2014/02/Android1.jpg"));
			Log.d("customize Service", "result" + result);
			Bundle b = new Bundle();
			Intent broadcastIntent = new Intent();
			//b.putInt("key", result);
			broadcastIntent.putExtra("key", result);
			broadcastIntent.setAction("FILE_DOWNLOADED_ACTION");
			getBaseContext().sendBroadcast(broadcastIntent);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	private int DownloadFile(URL url) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		return 100;
	}
}
