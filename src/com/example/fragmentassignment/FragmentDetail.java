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
	}
	
	private void setText() {
		String text = operation + " {" + getText(operation) + "}";
		TextView tv = (TextView) getActivity().findViewById(R.id.operation);
		tv.setText(text);
	}
	
	private String getText(String operation) {
		String even = "";
		String odd = "";
		for(int i = 1; i <= 100; i++) {
			if(i%2==0) {
				even += Integer.toString(i);
			}
			else {
				odd += Integer.toString(i);
			}
		}
		
		return operation=="Even Numbers" ? even : odd;
	}
}