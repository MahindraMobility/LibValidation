package com.mahindra.mylibrary.validation;

import com.mahindra.mylibrary.validation.validators.ValidationHolder;

import java.util.regex.Matcher;

public interface ValidationCallback {

    void execute(ValidationHolder validationHolder, Matcher matcher);

}