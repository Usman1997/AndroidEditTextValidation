package com.example.edittextanimation.ValidationHelper;


public class BasicValidator extends Validator {

    private ValidationCallback mValidationCallback = new ValidationCallback() {

        @Override
        public void execute(ValidationHolder validationHolder) {
            validationHolder.getEditText().setError(validationHolder.getErr_msg());
        }
    };


    @Override
    public boolean trigger() {
        return checkFields(mValidationCallback);
    }

    @Override
    public void halt() {
        for (ValidationHolder validationHolder : mValidationHolderList) {
            validationHolder.getEditText().setError(null);
        }
    }

}
