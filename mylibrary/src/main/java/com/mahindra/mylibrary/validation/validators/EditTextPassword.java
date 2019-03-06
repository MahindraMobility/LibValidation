package com.mahindra.mylibrary.validation.validators;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.mahindra.mylibrary.R;

import java.util.regex.Pattern;

public class EditTextPassword extends AppCompatEditText {

    TextWatcher textWatcher = new TextWatcher(){

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            if (!TextUtils.isEmpty(s) && isValidPassword(s.toString())) {
                System.out.print("Valid Email");
                setBackgroundResource(R.drawable.rounded_shapegreen);
            } else {
                setBackgroundResource(R.drawable.rounded_shape);
                setError("Incorrect Email-ID");
            }
        }
    };

    public EditTextPassword(Context context) {
        super(context);
    }

    public EditTextPassword(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTextChangedListener(textWatcher);
    }


    public boolean isValidPassword(String password) {

        if (password == null) {
            return false;
        } else {
            //android Regex to check the email address Validation
            return Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})").matcher(password).matches();
        }

    }
}
