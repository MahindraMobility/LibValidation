package com.mahindra.mylibrary.validation.validators;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.mahindra.mylibrary.R;

import java.util.regex.Pattern;

public class EditTextCity extends AppCompatEditText {

    Context context;
    EditTextCity editTextCity;

    TextWatcher textWatcher = new TextWatcher(){

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void afterTextChanged(Editable s) {
            if (!TextUtils.isEmpty(s) && isValidcity(s.toString())) {
                System.out.print("Valid city");

               setBackgroundResource(R.drawable.rounded_shapegreen);
                }
                else
                    {
                setError("Invalid city");
                setBackgroundResource(R.drawable.rounded_shape);


            }
        }
    };

    public EditTextCity(Context context) {
        super(context);
    }

    public EditTextCity(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        addTextChangedListener(textWatcher);
    }

    public boolean isValidcity(String city) {

        if (city == null) {
            return false;
        } else {
            //android Regex to check the email address Validation
            return Pattern.compile("^[a-zA-Z_ ]*$").matcher(city).matches();
        }

    }
}
