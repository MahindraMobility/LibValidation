package com.mahindra.mylibrary.validation.validators;

import android.content.Context;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerSelection extends AppCompatSpinner implements AdapterView.OnItemSelectedListener {
    ValidationHolder validationHolder;

    public SpinnerSelection(Context context, AttributeSet attrs) {

        super(context, attrs);
    }




    public  boolean spinnerselection(ValidationHolder validationHolder){
        if (((Spinner) validationHolder.getView()).getSelectedItem().toString().equals("< Please select one >")) {

            return false;
        } else {

            return true;
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        Object item = parent.getItemAtPosition(position);
        Toast.makeText(view.getContext(),item.toString(),Toast.LENGTH_LONG).show();

//        TextView textViewError = (TextView) ((Spinner) validationHolder.getView()).getSelectedView();
//        textViewError.setError("Nothng is selected");
//        spinnerselection(validationHolder);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
