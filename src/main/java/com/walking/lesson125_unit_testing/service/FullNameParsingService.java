package com.walking.lesson125_unit_testing.service;

import com.walking.lesson125_unit_testing.model.FullName;

public class FullNameParsingService {
    private final FullNameValidationService fullNameValidationService = new FullNameValidationService();

    public FullNameParsingService() {
    }

    private FullName parseName(String nameString) {
        fullNameValidationService.validateFullName(nameString);

        FullName fullName = new FullName();
        String[] splitNameString = nameString.split(" ");

        String surname = splitNameString[0];
        fullNameValidationService.validateSurname(surname);
        fullName.setSurname(surname);

        String name = splitNameString[1];
        fullNameValidationService.validateName(name);
        fullName.setName(name);

        String patronymic = splitNameString[2];
        fullNameValidationService.validatePatronymic(patronymic);
        fullName.setPatronymic(patronymic);

        return fullName;
    }
}
