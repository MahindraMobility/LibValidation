package com.mahindra.mylibrary.validation.validators;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.mahindra.mylibrary.validation.LengthChecker;
import com.mahindra.mylibrary.validation.RegexpValidator;
import com.mahindra.mylibrary.validation.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class MaterialEditText extends AppCompatEditText    {


    String passwordinput = "", emailinput = "", usernameinput = "", mobileinput = "";
    private LengthChecker lengthChecker;

    RegexpValidator regexpValidator;

    private static final Pattern USERNAME_PATTERN = Pattern.compile(
            "^[a-zA-Z](([\\._\\-][a-zA-Z0-9])|[a-zA-Z0-9])*[a-z0-9]$");

    public MaterialEditText(Context context) {
        super(context);
    }

    public MaterialEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MaterialEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private List<Validator> validators;



    public MaterialEditText addValidator(Validator validator) {
        if (validators == null) {
            this.validators = new ArrayList<>();
        }
        this.validators.add(validator);
        return this;
    }



    public boolean validate() {
        if (validators == null || validators.isEmpty()) {
            return true;
        }

        CharSequence text = getText();
        boolean isEmpty = text.length() == 0;

        boolean isValid = true;
        for (Validator validator : validators) {
            //noinspection ConstantConditions
            isValid = isValid && validator.isValid(text, isEmpty);
            if (!isValid) {
                setError(validator.getErrorMessage());
                break;
            }
        }
        if (isValid) {
            setError(null);
        }

        postInvalidate();
        return isValid;
    }



}



