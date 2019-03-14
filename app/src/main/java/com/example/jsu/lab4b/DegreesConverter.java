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
public class DegreesConverter extends Fragment implements View.OnClickListener {


    public DegreesConverter() {
        // Required empty public constructor
    }

    String f = "";
    String c = "";
    EditText fField;
    EditText cField;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_degrees_converter, container, false);

        Button b = (Button)v.findViewById(R.id.convertButton); // Acquire button reference
        fField = (EditText)v.findViewById(R.id.fahrenheitField);
        cField = (EditText)v.findViewById(R.id.celsiusField);
        b.setOnClickListener(this);                     // Set event handler

        return v;

    }


    public void onClick(View v) {
        f = fField.getText().toString();
        c = cField.getText().toString();


        if(!f.matches("") && !c.matches("")){
            String s = Double.toString(convertMtoKM());
            cField.setText(s);
        }

        else if(!f.matches("") && c.matches("")) {
            String s = Double.toString(convertMtoKM());
            cField.setText(s);
        }

        else if(f.matches("") && !c.matches("")) {
            String s = Double.toString(convertKMtoM());
            fField.setText(s);
        }

    }

    public double convertMtoKM() {
        double i = (Double.parseDouble(f) - 32) * 1.8;
        return i;
    }

    public double convertKMtoM() {
        double i = (Double.parseDouble(c) * 1.8) + 32;
        return i;
    }

}
