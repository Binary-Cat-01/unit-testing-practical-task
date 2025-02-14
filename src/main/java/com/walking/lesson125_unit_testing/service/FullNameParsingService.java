package com.walking.lesson125_unit_testing.service;

import com.walking.lesson125_unit_testing.model.FullName;

public class FullNameParsingService {
    private final FullNameValidationService fullNameValidationService;

    public FullNameParsingService(FullNameValidationService fullNameValidationService) {
        this.fullNameValidationService = fullNameValidationService;
    }

    public FullName parseName(String nameString) {
        fullNameValidationService.validateFullName(nameString);

        String[] splitNameString = nameString.split(" ");

        String surname = splitNameString[0];
        fullNameValidationService.validateSurname(surname);

        String name = splitNameString[1];
        fullNameValidationService.validateName(name);

        String patronymic = splitNameString[2];
        fullNameValidationService.validatePatronymic(patronymic);

        return new FullName(name, surname, patronymic);
    }
}
