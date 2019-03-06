package com.mahindra.mylibrary.validation;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;

import com.mahindra.mylibrary.validation.validators.ValidationHolder;

import java.util.ArrayList;


public abstract class Validator {

  protected ArrayList<ValidationHolder> mValidationHolderList;
  protected String errorMessage;

  public void set(Activity activity, int viewId, CustomValidation customValidation, CustomValidationCallback customValidationCallback, CustomErrorReset customErrorReset, int errMsgId) {
    View view = activity.findViewById(viewId);
    String errMsg = activity.getResources().getString(errMsgId);
    set(view, customValidation, customValidationCallback, customErrorReset, errMsg);
  }
  public void set(View view, CustomValidation customValidation, CustomValidationCallback customValidationCallback, CustomErrorReset customErrorReset, String errMsg) {
    ValidationHolder validationHolder = new ValidationHolder(view, customValidation, customValidationCallback, customErrorReset, errMsg);
    mValidationHolderList.add(validationHolder);
  }

  public Validator(@NonNull String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public void setErrorMessage(@NonNull String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @NonNull
  public String getErrorMessage() {
    return this.errorMessage;
  }


  public abstract boolean isValid(@NonNull CharSequence text, boolean isEmpty);


    public void set(Activity activity, int viewId, String regex, int errMsgId) {
    }

  public abstract boolean trigger();
}


