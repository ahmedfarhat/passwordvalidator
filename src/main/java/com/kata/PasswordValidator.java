package com.kata;

import java.util.List;
import java.util.function.Predicate;

public class PasswordValidator {
    private final ValidationFactory passwordRulesFactory;
    private ValidatorType validatorType;

    public PasswordValidator(ValidatorType validatorType) {
        this.validatorType = validatorType;
        passwordRulesFactory = ValidationFactory.createPasswordRulesFactory(validatorType);
    }

    public Boolean isValid(String password) {
        List<Predicate> rules;
        rules = passwordRulesFactory.createRules();
        if (rules == null) return false;
        return rules.stream().allMatch(predicate -> predicate.test(password));

    }



}
