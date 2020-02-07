package com.example.edittextanimation.ValidationHelper;

public enum ValidationStyle {

    BASIC(0),
    UNDERLABEL(1),
    SIDELABEL(2);

    private int mValue;

    ValidationStyle(int value) {
        mValue = value;
    }

    public int value() {
        return mValue;
    }

    public static ValidationStyle fromValue(int value) {
        switch (value) {
            case 0:
                return ValidationStyle.BASIC;
            case 1:
                return ValidationStyle.UNDERLABEL;
            case 2:
                return ValidationStyle.SIDELABEL;
            default:
                throw new IllegalArgumentException("Unknown ValidationStyle value.");
        }
    }

}