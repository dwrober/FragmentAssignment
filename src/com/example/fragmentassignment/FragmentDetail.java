package com.example.fragmentassignment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentDetail extends Fragment {
	private String operation = "";
	
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
		
    	TextView tv = (TextView) getActivity().findViewById(R.id.operation);
    	tv.setText(operation);
	}
}