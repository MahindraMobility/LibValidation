package com.mahindra.mylibrary.validation.validators;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.mahindra.mylibrary.R;

import java.util.regex.Pattern;

public class EditTextName extends AppCompatEditText {

    public EditTextName(Context context) {
        super(context);
    }

    public EditTextName(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTextChangedListener(textWatcher);
    }


    TextWatcher textWatcher = new TextWatcher(){

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!TextUtils.isEmpty(s) && isValidnameId(s.toString())) {
                System.out.print("Valid NAme");
                setBackgroundResource(R.drawable.rounded_shapegreen);

            } else {
                setBackgroundResource(R.drawable.rounded_shape);
                setError("Numbers not Allowed");
            }

        }
    };

    public boolean isValidnameId(String name) {

        if (name == null) {
            return false;
        } else {
            //android Regex to check the email address Validation
            return Pattern.compile("^[a-zA-Z_ ]*$").matcher(name).matches();
        }

    }
}
