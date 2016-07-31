package com.example.filehandling;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends Activity {
	EditText editTitle, editDesc;
	Button buttonCreateNode;
	ArrayList<Notes> notesList = new ArrayList<Notes>();
	//NoteAdapter adapter;
	Button closeButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		editTitle = (EditText) findViewById(R.id.editText1);
		editDesc = (EditText) findViewById(R.id.editText2);
		buttonCreateNode = (Button) findViewById(R.id.button1);
		
		// create notes folder in application package folder
		// 1.get path of app data folder
		//ApplicationInfo appInfo = getApplicationInfo();
		File sdcardFile = Environment.getExternalStorageDirectory();//for sdcard path
		String sdCardPath = sdcardFile.getAbsolutePath();
		// editDesc.setText(appInfo.dataDir);

		// 2.Create path for notes folder
		//final String notesFolderPath = appInfo.dataDir + "/notes";
		final String notesFolderPath = sdCardPath + "/notes";//for sdcard
		// 3.create nodes folder if not exist
		File notesFile = new File(notesFolderPath);
		if (!notesFile.exists()) {
			notesFile.mkdir();
		}

		// create notes file in notes directory on button click
		buttonCreateNode.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String title = editTitle.getText().toString();
				String desc = editDesc.getText().toString();
				// create path of new file for notes
				String filePath = notesFolderPath + "/" + title + ".txt";
				// save desc
				try {
					FileWriter writer = new FileWriter(filePath);
					writer.write(desc);
					writer.flush();
					writer.close();

				} catch (Exception ex) {
					Log.e("File handling", ex.toString());
				}
				editTitle.setText("");
				editDesc.setText("");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.list_view, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.history: {
			Intent in = new Intent(HomeActivity.this, NodesListActivity.class);
			startActivity(in);
		}
			break;
		case R.id.exit:
			finish();
			break;
		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}
}

class customadapter extends BaseAdapter
{

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}
	
}