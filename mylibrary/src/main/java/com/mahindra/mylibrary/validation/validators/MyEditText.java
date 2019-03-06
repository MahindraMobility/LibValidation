package com.mahindra.mylibrary.validation.validators;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.mahindra.mylibrary.R;
import com.mahindra.mylibrary.validation.RegexpValidator;

import java.util.regex.Pattern;

public class MyEditText extends AppCompatEditText {

    String email;
    String emailPattern = "[\\\\w-]+@([\\\\w-]+\\\\.)+[\\\\w-]+";
    RegexpValidator regexpValidator;
    MyEditText myEditTextclass;




    TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // TODO Auto-generated method stub
            System.out.println("Demo Value change listener1");



        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // TODO Auto-generated method stub
            System.out.println("Demo Value change listener2");
        }

        @SuppressLint("ResourceType")
        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            System.out.println("Demo Value change listener3");



            if (!TextUtils.isEmpty(s) && isValidEmailId(s.toString())) {
                System.out.print("Valid Email");
               setBackgroundResource(R.drawable.rounded_shapegreen);
              //  DrawableCompat.setTint(new MyEditText(getContext()).getBackground(), ContextCompat.getColor(getContext(),Color.GREEN));

            } else {
               //,
                setBackgroundResource(R.drawable.rounded_shape);
                setError(" Email must Contain Special Characters");
            }

        }
    };

    public MyEditText(Context context) {
        super(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
         super(context, attrs);
          addTextChangedListener(textWatcher);
     }
    public boolean isValidEmailId(String email) {

        if (email == null) {
            return false;
        } else {
            //android Regex to check the email address Validation
            return Pattern.compile("[\\w-]+@([\\w-]+\\.)+[\\w-]+").matcher(email).matches();
        }

    }



}
