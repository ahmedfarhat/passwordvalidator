package com.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {
    private PasswordValidator passwordMediumValidator;
    private PasswordValidator passwordEasyValidator;

    private PasswordValidator passwordStrongValidator;


    @BeforeEach
    public void before() {
        passwordMediumValidator = new PasswordValidator(ValidatorType.MEDIUM);
        passwordEasyValidator  = new PasswordValidator(ValidatorType.EASY);
        passwordStrongValidator  = new PasswordValidator(ValidatorType.STRONG);
    }

    @Test
    public void valid_password_Medium_Validator() {
        assertTrue(passwordMediumValidator.isValid("Aa_123456"));
    }

    @Test
    public void invalid_when_no_capital_letter() {
        assertFalse(passwordMediumValidator.isValid("111aa_123456"));
    }

    @Test
    public void invalid_when_no_lower_case_letter() {
        assertFalse(passwordMediumValidator.isValid("AA_123456"));
    }

    @Test
    public void invalid_when_no_underscore_character() {
        assertFalse(passwordMediumValidator.isValid("Aa0123456"));
    }

    @Test
    public void invalid_when_no_long_enough() {
        assertFalse(passwordMediumValidator.isValid("Aa_12345"));
    }
    @Test
    public void invalid_when_no_Number() {
        assertFalse(passwordMediumValidator.isValid("Aa_bdfereee"));
    }

    @Test
    public void valid_password_Easy_Validator() {
        assertTrue(passwordEasyValidator.isValid("Aa12344"));
    }
    @Test
    public void valid_when_no_underscore_character() {
        assertTrue(passwordEasyValidator.isValid("Aa12344"));
    }
    @Test
    public void valid_when_exist_underscore_character() {
        assertTrue(passwordEasyValidator.isValid("Aa_12344"));
    }
    @Test
    public void invalid_password_easy_validator_when_no_long_enough() {
        assertFalse(passwordEasyValidator.isValid("Aa345"));
    }
    @Test
    public void invalid_password_easy_validator_when_no_Number() {
        assertFalse(passwordEasyValidator.isValid("Aafbdee"));
    }

    // Strong

    @Test
    public void valid_password_strong_validator_password() {
        assertTrue(passwordStrongValidator.isValid("123456789sqdDS__Aa_123456"));
    }

    @Test
    public void invalid_password_strong_validator_when_no_capital_letter() {
        assertFalse(passwordStrongValidator.isValid("111aa_123ccccccccccccccvv456"));
    }

    @Test
    public void invalid_password_strong_validator_when_no_lower_case_letter() {
        assertFalse(passwordStrongValidator.isValid("AA_1234AAZZZZZZZZZZZZZZ56"));
    }

    @Test
    public void invalid_password_strong_validator_when_no_underscore_character() {
        assertFalse(passwordStrongValidator.isValid("Aa012qqqqqqqqqqPPPPPPPPKJJJ3456"));
    }

    @Test
    public void invalid_password_strong_validator_when_no_long_enough() {
        assertFalse(passwordStrongValidator.isValid("Aa_12iiiiii345"));
    }
    @Test
    public void invalid_password_strong_validator_when_no_Number() {
        assertFalse(passwordStrongValidator.isValid("Aa_bdfe_____________fgfhreee"));
    }
}