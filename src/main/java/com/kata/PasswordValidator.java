package com.kata;

public class PasswordValidator {
    private ValidatorType validatorType;

    public PasswordValidator(ValidatorType validatorType) {
        this.validatorType = validatorType;
    }

    public Boolean isValid(String password) {
        switch (this.validatorType) {
            case EASY :
                return hasUpperCase(password)
                        && hasLowerCase(password)
                        && hasNumber(password)
                        && isLongEnough(password, 6);
            case MEDIUM :
                return hasUpperCase(password)
                    && hasLowerCase(password)
                    && hasUnderScore(password)
                    && hasNumber(password)
                    && isLongEnough(password, 8);
            case STRONG :
                return hasUpperCase(password)
                        && hasLowerCase(password)
                        && hasUnderScore(password)
                        && hasNumber(password)
                        && isLongEnough(password, 16);
            default:
                return false;
        }

    }

    private boolean hasNumber(String password) {
         return password.matches(".*\\d.*");
    }

    private boolean isLongEnough(String password, int minLenght) {
        return password.length() > minLenght;
    }

    private boolean hasUnderScore(String password) {
        return password.indexOf('_') != -1;
    }

    private boolean hasLowerCase(String password) {
        return !password.toUpperCase().equals(password);
    }

    private boolean hasUpperCase(String password) {
        return !password.toLowerCase().equals(password);
    }
}
