package com.kata;

import java.util.List;
import java.util.function.Predicate;

public class ValidationFactory {

    private ValidatorType validator;

    private ValidationFactory(ValidatorType validator) {
        this.validator = validator;
    }


    public static ValidationFactory createPasswordRulesFactory(ValidatorType validator) {
        return new ValidationFactory(validator);
    }

    protected List<Predicate> createRules() {

        List<Predicate> rules;
        switch (validator) {
            case EASY:
                Predicate<String> hasNumberPredicate2 = (p2) -> p2.matches(".*\\d.*");
                Predicate<String> hasLowerCasePredicate2 = (p2) -> !p2.toUpperCase().equals(p2);
                Predicate<String> isLongEnoughPredicate2 = (p2) -> p2.length() > 6;
                Predicate<String> hasUpperCasePredicate2 = (p2) -> !p2.toLowerCase().equals(p2);
                rules = List.of(hasNumberPredicate2, hasLowerCasePredicate2, isLongEnoughPredicate2, hasUpperCasePredicate2);
                break;
            case MEDIUM:
                Predicate<String> hasNumberPredicate1 = (p1) -> p1.matches(".*\\d.*");
                Predicate<String> hasLowerCasePredicate1 = (p1) -> !p1.toUpperCase().equals(p1);

                Predicate<String> isLongEnoughPredicate1 = (p1) -> p1.length() > 8;
                Predicate<String> hasUnderScorePredicate1 = (p1) -> p1.indexOf('_') != -1;

                Predicate<String> hasUpperCasePredicate1 = (p1) -> !p1.toLowerCase().equals(p1);

                rules = List.of(hasNumberPredicate1, hasLowerCasePredicate1, isLongEnoughPredicate1, hasUnderScorePredicate1, hasUpperCasePredicate1);
                break;
            case STRONG:
                Predicate<String> hasNumberPredicate = (p) -> p.matches(".*\\d.*");
                Predicate<String> hasLowerCasePredicate = (p) -> !p.toUpperCase().equals(p);

                Predicate<String> isLongEnoughPredicate = (p) -> p.length() > 16;
                Predicate<String> hasUnderScorePredicate = (p) -> p.indexOf('_') != -1;

                Predicate<String> hasUpperCasePredicate = (p) -> !p.toLowerCase().equals(p);
                rules = List.of(hasNumberPredicate, hasLowerCasePredicate, isLongEnoughPredicate, hasUnderScorePredicate, hasUpperCasePredicate);
                break;

            default:
                return null;
        }
        return rules;
    }
}