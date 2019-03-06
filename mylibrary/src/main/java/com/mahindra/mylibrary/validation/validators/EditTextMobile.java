package com.mahindra.mylibrary.validation.validators;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.mahindra.mylibrary.R;

import java.util.regex.Pattern;

public class EditTextMobile  extends AppCompatEditText {

    TextWatcher textWatcher = new TextWatcher(){

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!TextUtils.isEmpty(s) && isValidMobile(s.toString())) {
                System.out.print("Valid Mobile");
                setBackgroundResource(R.drawable.rounded_shapegreen);
            } else {
                setBackgroundResource(R.drawable.rounded_shape);
                setError("Max 10 numbers only");
            }
        }
    };

    public EditTextMobile(Context context) {
        super(context);
    }

    public EditTextMobile(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTextChangedListener(textWatcher);
    }


    public boolean isValidMobile(String mobile) {

        if (mobile == null) {
            return false;
        } else {
            //android Regex to check the email address Validation
            return Pattern.compile("^[0][1-9]\\d{9}$|^[1-9]\\d{9}$").matcher(mobile).matches();
        }

    }
}
