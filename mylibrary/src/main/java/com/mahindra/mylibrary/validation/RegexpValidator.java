package com.mahindra.mylibrary.validation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;

import java.util.regex.Pattern;


public class RegexpValidator extends Validator implements TextWatcher {

    private Pattern pattern;
    String email,name;


    public RegexpValidator(Context context) {
        super("");
    }







    public final static boolean isValidEmail(String target) {
        if (target == null) {
            return false;
        } else {
            //android Regex to check the email address Validation
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public RegexpValidator(@NonNull String errorMessage, @NonNull String regex) {
        super(errorMessage);

        pattern = Pattern.compile(regex);

    }

    public RegexpValidator(@NonNull String errorMessage, @NonNull Pattern pattern) {
        super(errorMessage);
        this.pattern = pattern;
    }

    @Override
    public boolean isValid(@NonNull CharSequence text, boolean isEmpty) {
        return pattern.matcher(text).matches();
    }

    @Override
    public boolean trigger() {
        return false;
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


        }


    @Override
    public void afterTextChanged(Editable editable) {
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
        }
        else {
           setErrorMessage("wrong input");
        }
    }
}
