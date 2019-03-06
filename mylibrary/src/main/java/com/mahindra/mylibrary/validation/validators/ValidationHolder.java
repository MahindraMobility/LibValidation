package com.mahindra.mylibrary.validation.validators;

import android.view.View;

import com.mahindra.mylibrary.validation.CustomErrorReset;
import com.mahindra.mylibrary.validation.CustomValidation;
import com.mahindra.mylibrary.validation.CustomValidationCallback;

public class ValidationHolder {

    private View mView;
    private String mErrMsg;
    private CustomValidation mCustomValidation;
    private CustomValidationCallback mCustomValidationCallback;
    private CustomErrorReset mCustomErrorReset;

    public ValidationHolder(View view, CustomValidation customValidation, CustomValidationCallback customValidationCallback, CustomErrorReset customErrorReset, String errMsg) {
        mView = view;
        mCustomValidation = customValidation;
        mCustomValidationCallback = customValidationCallback;
        mCustomErrorReset = customErrorReset;
        mErrMsg = errMsg;
    }

    public String getErrMsg() {
        return mErrMsg;
    }


    public boolean isSomeSortOfView() {
        return mView != null;
    }
    public View getView() {
        if (isSomeSortOfView()) {
            return mView;
        } else {
            return null;
        }
    }


}

