package com.example.jsu.lab4b;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class MilesToKilometersConverter extends Fragment implements View.OnClickListener {


    public MilesToKilometersConverter() {
        // Required empty public constructor
    }

    String miles = "";
    String km = "";
    EditText milesField;
    EditText kilometersField;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_miles_to_kilometers_converter, container, false);

        Button b = (Button)v.findViewById(R.id.convertButton); // Acquire button reference
        b.setOnClickListener(this);                     // Set event handler
        milesField = v.findViewById(R.id.milesField);
        kilometersField = v.findViewById(R.id.kilometersField);

        return v;

    }

    public void onClick(View v) {
        miles = milesField.getText().toString();
        km = kilometersField.getText().toString();


        if(!miles.matches("") && !km.matches("")){
            String s = Double.toString(convertMtoKM());
            kilometersField.setText(s);
        }

        else if(!miles.matches("") && km.matches("")) {
            String s = Double.toString(convertMtoKM());
            kilometersField.setText(s);
        }

        else if(miles.matches("") && !km.matches("")) {
            String s = Double.toString(convertKMtoM());
            milesField.setText(s);
        }

    }

    public double convertMtoKM() {
        double i = Double.parseDouble(miles) * 1.60934;
        return i;
    }

    public double convertKMtoM() {
        double i = Double.parseDouble(km) * 0.6214;
        return i;
    }

}
