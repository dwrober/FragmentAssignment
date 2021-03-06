package com.example.fragmentassignment;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentDetail extends Fragment {
	private String operation = "";
	private ListView detailList;
	
    public void setOperation(String op) {
    	operation = op;
    }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }
	
	@Override
	public void onStart() {
		super.onStart();
		setText();
		setupList();
	}
	
	private void setupList() {
		ArrayList<String> values = getValues(operation);
		detailList = (ListView) getActivity().findViewById(R.id.detailList);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, android.R.id.text1, values);
		detailList.setAdapter(adapter); 
		
	}
	
	private void setText() {
		TextView tv = (TextView) getActivity().findViewById(R.id.operation);
		tv.setText(operation);	
	}
	
	private ArrayList<String> getValues(String operation) {
		ArrayList<String> even = new ArrayList<String>();
		ArrayList<String> odd = new ArrayList<String>();
		for(int i = 1; i <= 100; i++) {
			if(i%2==0) {
				even.add(Integer.toString(i));
			}
			else {
				odd.add(Integer.toString(i));
			}
		}
		return operation=="Even Numbers" ? even : odd;
	}
}