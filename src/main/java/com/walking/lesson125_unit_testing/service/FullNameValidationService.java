package com.walking.lesson125_unit_testing.service;

import com.walking.lesson125_unit_testing.exception.RegexValidationException;

public class FullNameValidationService {
    private static final String FULL_NAME_REGEX = "^[А-Я][А-Яа-я-]* [А-Я][а-я]* [А-Я][а-я]+$";
    private static final String DOUBLE_SURNAME_REGEX = "[А-Я][а-я]*-[А-Я][а-я]*";
    private static final String NAME_REGEX = "[А-Я][а-я]*";
    private static final String PATRONYMIC_REGEX = "[А-Я][а-я]+";

    public void validateFullName(String nameString) {
        if (!nameString.matches(FULL_NAME_REGEX)) {
            throw new RegexValidationException(nameString, FULL_NAME_REGEX);
        }
    }

    public void validateSurname(String surname) {
        if (surname.contains("-")) {
            if (!surname.matches(DOUBLE_SURNAME_REGEX)) {
                throw new RegexValidationException(surname, DOUBLE_SURNAME_REGEX);
            }
        } else {
            validateName(surname);
        }
    }

    public void validateName(String name) {
        if (!name.matches(NAME_REGEX)) {
            throw new RegexValidationException(name, NAME_REGEX);
        }
    }

    public void validatePatronymic(String name) {
        if (!name.matches(PATRONYMIC_REGEX)) {
            throw new RegexValidationException(name, PATRONYMIC_REGEX);
        }
    }
}
