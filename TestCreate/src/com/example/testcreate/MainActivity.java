package com.example.testcreate;

import java.io.File;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private final static String ALBUM_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/nvshen/";
	private static String FilepathMusic="mnt/sdcard/nvshen/";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new Thread(new Runnable(){

			@Override
			public void run() {
				createSDCardDir();
				
			}
			
		}).start();
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	 public static void createSDCardDir()
		{
		     if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()))
		     {
		         File path1 = new File(FilepathMusic);
		         if (!path1.exists()) 
		         {
		             //若不存在，创建目录
		             boolean ret = path1.mkdir();
		             if (!ret)
		            	 Log.d("jzhang", "Create dir failed!");
		         }
		     }
		     else
		     {
		    	 return;
		     }

		}

}
