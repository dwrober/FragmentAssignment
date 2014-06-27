package com.example.fragmentassignment;

import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentMain extends Fragment {
	private ListView listView;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
    
	@Override
	public void onStart() {
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
	
	private void setupList() {
		listView = (ListView) getActivity().findViewById(R.id.listview);
		String[] values = new String[] { "Even Numbers","Odd Numbers"};
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
	              android.R.layout.simple_list_item_1, android.R.id.text1, values);
	
		listView.setAdapter(adapter); 
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
}