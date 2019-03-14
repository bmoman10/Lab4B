package com.example.jsu.lab4b;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipFragment extends Fragment implements View.OnClickListener {


    public TipFragment() {
        // Required empty public constructor
    }

    TextView t;
    EditText totalField;
    EditText percentageField;
    EditText numPeopleField;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tip, container, false);

        Button b = (Button)v.findViewById(R.id.calculateButton); // Acquire button reference
        b.setOnClickListener(this);                     // Set event handler
        totalField = v.findViewById(R.id.totalBillField);
        percentageField = v.findViewById(R.id.percentageField);
        numPeopleField = v.findViewById(R.id.numPeopleField);
        t = v.findViewById(R.id.tipPerPersonView);

        return v;

    }

    public void onClick(View v) {
        double total = Double.parseDouble(totalField.getText().toString());
        double percentage = Double.parseDouble(percentageField.getText().toString())/100;
        int numPeople = Integer.parseInt(numPeopleField.getText().toString());

        double tipPerPerson = ((total * percentage)/numPeople);

        String text = "$" + String.format("%.2f", tipPerPerson);

        t.setText(text);
    }

}
