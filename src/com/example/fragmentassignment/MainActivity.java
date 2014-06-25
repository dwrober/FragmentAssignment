package com.example.fragmentassignment;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Build;

public class MainActivity extends Activity {
	private ListView listView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		setupList();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		Log.i("onOptionsItemSelected", Integer.toString(id));
		Log.i("list_items_key", Integer.toString(R.id.list_items));
		Log.i("bool", R.id.list_items == id ? "yup" : "nope");
		if (id == R.id.action_settings) {
			return true;
		}
		if (id == R.id.list_items) {
			// handle menu item here
			//item.setVisible(false);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void setupList() {
		listView = (ListView) findViewById(R.id.listview);
		String[] values = new String[] { "Android List View", 
			"Adapter implementation",
			"Simple List View In Android",
			"Create List View Android", 
			"Android Example", 
			"List View Source Code", 
			"List View Array Adapter", 
			"Android Example List View" 
			};
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	              android.R.layout.simple_list_item_1, android.R.id.text1, values);
	
		listView.setAdapter(adapter); 
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
