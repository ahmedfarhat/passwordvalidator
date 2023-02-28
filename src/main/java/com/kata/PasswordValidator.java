package com.kata;

import java.util.List;
import java.util.function.Predicate;

public class PasswordValidator {

    private ValidatorType validatorType;

    public PasswordValidator(ValidatorType validatorType) {
        this.validatorType = validatorType;

    }

    public Boolean isValid(String password) {

        switch (validatorType) {
            case EASY:
                Predicate<String> hasNumberPredicate2 = (p2) -> p2.matches(".*\\d.*");
                Predicate<String> hasLowerCasePredicate2 = (p2) -> !p2.toUpperCase().equals(p2);
                Predicate<String> isLongEnoughPredicate2 = (p2) -> p2.length() > 6;
                Predicate<String> hasUpperCasePredicate2 = (p2) -> !p2.toLowerCase().equals(p2);
                return hasNumberPredicate2.test(password) && hasLowerCasePredicate2.test(password) && isLongEnoughPredicate2.test(password) && hasUpperCasePredicate2.test(password) ;

            case MEDIUM:
                Predicate<String> hasNumberPredicate1 = (p1) -> p1.matches(".*\\d.*");
                Predicate<String> hasLowerCasePredicate1 = (p1) -> !p1.toUpperCase().equals(p1);

                Predicate<String> isLongEnoughPredicate1 = (p1) -> p1.length() > 8;
                Predicate<String> hasUnderScorePredicate1 = (p1) -> p1.indexOf('_') != -1;

                Predicate<String> hasUpperCasePredicate1 = (p1) -> !p1.toLowerCase().equals(p1);

                return  hasNumberPredicate1.test(password) && hasLowerCasePredicate1.test(password) && isLongEnoughPredicate1.test(password) && hasUnderScorePredicate1.test(password) && hasUpperCasePredicate1.test(password) ;

            case STRONG:
                Predicate<String> hasNumberPredicate = (p) -> p.matches(".*\\d.*");
                Predicate<String> hasLowerCasePredicate = (p) -> !p.toUpperCase().equals(p);

                Predicate<String> isLongEnoughPredicate = (p) -> p.length() > 16;
                Predicate<String> hasUnderScorePredicate = (p) -> p.indexOf('_') != -1;

                Predicate<String> hasUpperCasePredicate = (p) -> !p.toLowerCase().equals(p);
                return hasNumberPredicate.test(password) && hasLowerCasePredicate.test(password) && isLongEnoughPredicate.test(password) && hasUnderScorePredicate.test(password) && hasUpperCasePredicate.test(password);
            default:
                return false;

        }


    }


}
