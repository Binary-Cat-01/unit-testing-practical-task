package com.walking.lesson125_unit_testing.service;

import com.walking.lesson125_unit_testing.exception.RegexValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FullNameValidationServiceTest {
    private FullNameValidationService fullNameValidationService;

    private static final List<String> INVALID_FULL_NAMES = List.of(
            "иванов Иван Иванович",
            "Иванов иван Иванович",
            "Иванов Иван иванович",
            "Иванов Иван",
            "Ivanov Ivan");

    private static final List<String> VALID_FULL_NAMES = List.of(
            "Иванов Иван Иванович",
            "Иванов-Иванов Иван Иванович",
            "Иванов-Иванов И Иванович",
            "И-Иванов И Иванович");

    private static final List<String> INVALID_NAMES = List.of(
            "иван",
            "Ivan",
            "Иван-иван");

    private static final List<String> VALID_NAMES = List.of(
            "Иван");

    private static final List<String> INVALID_DOUBLE_SURNAMES = List.of(
            "И-иванов",
            "иванов-И",
            "Иванов-И-Иванов",
            "Ivanov-I");

    private static final List<String> VALID_DOUBLE_SURNAMES = List.of(
            "Иванов-Иванов",
            "И-Иванов");

    private static final List<String> INVALID_PATRONYMICS = List.of(
            "иванович",
            "Ivanovich",
            "И",
            "Иванович-Степанович");

    private static final List<String> VALID_PATRONYMICS = List.of(
            "Иванович");

    @BeforeEach
    void setUp() {
        fullNameValidationService = new FullNameValidationService();
    }

    @ParameterizedTest
    @EmptySource
    @FieldSource("INVALID_FULL_NAMES")
    void validateFullName_invalidFullNames_ThrowsException(String invalidFullName) {
//        when
        Executable actual = () -> fullNameValidationService.validateFullName(invalidFullName);
//        then
        assertThrows(RegexValidationException.class, actual);
    }

    @ParameterizedTest
    @FieldSource("VALID_FULL_NAMES")
    void validateFullName_validFullNames_DoesNotThrowException(String validFullName) {
//        when
        Executable actual = () -> fullNameValidationService.validateFullName(validFullName);
//        then
        assertDoesNotThrow(actual);
    }

    @ParameterizedTest
    @EmptySource
    @FieldSource("INVALID_NAMES")
    void validateName_invalidName_ThrowsException(String invalidName) {
//        when
        Executable actual = () -> fullNameValidationService.validateName(invalidName);
//        then
        assertThrows(RegexValidationException.class, actual);
    }

    @ParameterizedTest
    @FieldSource("VALID_NAMES")
    void validateName_validNames_DoesNotThrowException(String validName) {
//        when
        Executable actual = () -> fullNameValidationService.validateName(validName);
//        then
        assertDoesNotThrow(actual);
    }

    @ParameterizedTest
    @EmptySource
    @FieldSource("INVALID_DOUBLE_SURNAMES")
    void validateSurname_invalidSurNames_ThrowsException(String invalidSurName) {
//        when
        Executable actual = () -> fullNameValidationService.validateSurname(invalidSurName);
//        then
        assertThrows(RegexValidationException.class, actual);
    }

    @ParameterizedTest
    @FieldSource("VALID_DOUBLE_SURNAMES")
    void validateSurName_validSurNames_DoesNotThrowException(String validSurName) {
//        when
        Executable actual = () -> fullNameValidationService.validateSurname(validSurName);
//        then
        assertDoesNotThrow(actual);
    }

    @ParameterizedTest
    @EmptySource
    @FieldSource("INVALID_PATRONYMICS")
    void validatePatronymic_invalidPatronymics_ThrowsException(String invalidPatronymic) {
//        when
        Executable actual = () -> fullNameValidationService.validatePatronymic(invalidPatronymic);
//        then
        assertThrows(RegexValidationException.class, actual);
    }

    @ParameterizedTest
    @FieldSource("VALID_PATRONYMICS")
    void validatePatronymic_validPatronymics_DoesNotThrowException(String validPatronymic) {
//        when
        Executable actual = () -> fullNameValidationService.validatePatronymic(validPatronymic);
//        then
        assertDoesNotThrow(actual);
    }
}