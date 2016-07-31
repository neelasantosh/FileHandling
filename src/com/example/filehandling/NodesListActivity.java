package com.example.filehandling;

import java.io.File;
import java.io.FileReader;

import android.app.ListActivity;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NodesListActivity extends ListActivity {
	ListView listViewNotes;
	ArrayAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		listViewNotes = getListView();
		// find name of all files in notes directory
		//ApplicationInfo appInfo = getApplicationInfo();
		//final String notesFolderPath = appInfo.dataDir + "/notes";

		File sdcardFile = Environment.getExternalStorageDirectory();//for sdcard path
		String sdCardPath = sdcardFile.getAbsolutePath();//for sdcard
		final String notesFolderPath = sdCardPath + "/notes";//for sdcard
		File notesDir = new File(notesFolderPath);
		String fileNameArray[] = notesDir.list();

		adapter = new ArrayAdapter(NodesListActivity.this,
				android.R.layout.simple_list_item_1, fileNameArray);
		listViewNotes.setAdapter(adapter);

		// SHOW NOTES DATA ON TITLE SELECTED
		listViewNotes.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				//find path selected
				String title = (String) adapter.getItem(arg2);
				String filePath = notesFolderPath+"/"+title;
				//read data from file
				try
				{
					FileReader reader = new FileReader(filePath);
					String str="";
					while(true)
					{
						int ch = reader.read();
						if(ch!=-1)
							str+=(char)ch;
						else
							break;
					}
					reader.close();
					Toast.makeText(NodesListActivity.this, str,Toast.LENGTH_LONG).show();
					
				}catch(Exception ex){
					Log.e("no data present", ex.toString());
				}
			}
		});

	}
}
