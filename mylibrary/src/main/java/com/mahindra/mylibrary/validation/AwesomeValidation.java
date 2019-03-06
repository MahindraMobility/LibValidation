package com.mahindra.mylibrary.validation;


import android.app.Activity;

public class AwesomeValidation {

    private Validator mValidator = null;

    private static boolean autoFocusOnFirstFailure = true;



    public void  addValidation(Activity activity, int viewId, String regex, int errMsgId) {
        mValidator.set(activity, viewId, regex, errMsgId);
    }



    public void addValidation(Activity activity, int viewId, CustomValidation customValidation, CustomValidationCallback customValidationCallback, CustomErrorReset customErrorReset, int errMsgId) {
        mValidator.set(activity, viewId, customValidation, customValidationCallback, customErrorReset, errMsgId);
    }
    public boolean validate() {
        return mValidator.trigger();
    }


}
