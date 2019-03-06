package com.mahindra.mylibrary.validation.validators;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.mahindra.mylibrary.R;

import java.util.regex.Pattern;

public class EditTextDOB extends AppCompatEditText {

    TextWatcher textWatcher = new TextWatcher(){

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!TextUtils.isEmpty(s) && isValidDOB(s.toString())) {
                System.out.print("Valid DOB");
           setBackgroundResource(R.drawable.rounded_shapegreen);

            } else {
              setBackgroundResource(R.drawable.rounded_shape);
                setError("Invalid DOB");

            }
        }
    };



    public EditTextDOB(Context context) {
        super(context);
    }

    public EditTextDOB(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTextChangedListener(textWatcher);
    }

    public boolean isValidDOB(String dob) {

        if (dob == null) {
            return false;
        } else {
            //android Regex to check the email address Validation
            return Pattern.compile("^(1[0-9]|0[1-9]|3[0-1]|2[1-9])/(0[1-9]|1[0-2])/[0-9]{4}$").matcher(dob).matches();
        }

    }
}
