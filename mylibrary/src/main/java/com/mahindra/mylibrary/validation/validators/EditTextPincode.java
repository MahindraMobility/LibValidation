package com.mahindra.mylibrary.validation.validators;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.mahindra.mylibrary.R;

import java.util.regex.Pattern;

public class EditTextPincode  extends AppCompatEditText {

    int errorColor;
    final int version = Build.VERSION.SDK_INT;
    public EditTextPincode(Context context) {
        super(context);
    }

    public EditTextPincode(Context context, AttributeSet attrs) {
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
                if (!TextUtils.isEmpty(s) && isValidpincode(s.toString())) {
                    System.out.print("Valid Pincode");
                    setBackgroundResource(R.drawable.rounded_shapegreen);

                } else {
                    setBackgroundResource(R.drawable.rounded_shape);
                    setError("Max 6 Digit numbers");
                }
        }
    };

    public boolean isValidpincode(String pincode) {

        if (pincode == null) {
            return false;
        } else {
            //android Regex to check the email address Validation
            return Pattern.compile("^[1-9][0-9]{5}$").matcher(pincode).matches();
        }

    }
}
