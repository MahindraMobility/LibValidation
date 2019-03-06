package com.mahindra.mylibrary.validation.validators;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerCustom extends android.support.v7.widget.AppCompatSpinner   {
    Context context;

    public SpinnerCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        context = context;
        setOnItemSelectedListener(listener);
    }

     OnItemSelectedListener listener = new OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Object item = adapterView.getItemAtPosition(i);
            Toast.makeText(view.getContext(),item.toString(),Toast.LENGTH_LONG).show();
            if(i==0){
                TextView errorText = (TextView)adapterView.getSelectedView();
                errorText.setError("please select item");
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };


    public void setSelectionByItemId(AdapterView<?> parent, long id){
        for (int i = 0; i < parent.getCount(); i++) {
            long itemIdAtPosition = parent.getItemIdAtPosition(i);
            if (itemIdAtPosition == id) {
                parent.setSelection(i);
                break;
            }
           System.out.println("Demo");
        }
    }
}
