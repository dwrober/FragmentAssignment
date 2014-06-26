package com.example.fragmentassignment;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
		
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		      @Override
		      public void onItemClick(AdapterView parent, final View view, int position, long id) {
		        final String item = (String) parent.getItemAtPosition(position);
		        Log.i("itemSelected",item);
		        selectDetail(item);
		      }
    	});
	}
	
	private void selectDetail(String item) {
		FragmentDetail fragDetail = new FragmentDetail();
		fragDetail.setOperation(item);
		FragmentManager fragmentManager= getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
	
		fragmentTransaction.replace(R.id.container, fragDetail);
		fragmentTransaction.addToBackStack("asdf");
		fragmentTransaction.commit();
	}
	
	private void selectList() {
		
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
		if (id == R.id.action_settings) {
			return true;
		}
		if (id == R.id.list_items) {
			Log.i("list_items", "called");
			selectList();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void setupList() {
		listView = (ListView) findViewById(R.id.listview);
		String[] values = new String[] { "Even Numbers",
				"Odd Numbers",
				"Random numbers",
				"Fib Numbers"
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
