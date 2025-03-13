package com.walking.lesson125_unit_testing.service;

import com.walking.lesson125_unit_testing.exception.RegexValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FullNameValidationServiceTest {
    private final FullNameValidationService fullNameValidationService =
            new FullNameValidationService();

    @ParameterizedTest
    @MethodSource("sourceValidFullName")
    void validateFullName_success(String validFullName) {
//        when
        Executable actual = () -> fullNameValidationService.validateFullName(validFullName);

//        then
        assertDoesNotThrow(actual);
    }

    @ParameterizedTest
    @MethodSource("sourceInvalidFullNames")
    void validateFullName_failed_with_invalidFullName(String invalidFullName) {
//        when
        Executable actual = () -> fullNameValidationService.validateFullName(invalidFullName);

//        then
        assertThrows(RegexValidationException.class, actual);
    }

    @Test
    void validateFullName_failed_with_null() {
//        when
        Executable actual = () -> fullNameValidationService.validateFullName(null);

//        then
        assertThrows(NullPointerException.class, actual);
    }

    @ParameterizedTest
    @MethodSource("sourceValidNames")
    void validateName_success(String validName) {
//        when
        Executable actual = () -> fullNameValidationService.validateName(validName);

//        then
        assertDoesNotThrow(actual);
    }

    @ParameterizedTest
    @MethodSource("sourceInvalidNames")
    void validateName_failed_with_invalidName(String invalidName) {
//        when
        Executable actual = () -> fullNameValidationService.validateName(invalidName);

//        then
        assertThrows(RegexValidationException.class, actual);
    }

    @Test
    void validateName_failed_with_null() {
//        when
        Executable actual = () -> fullNameValidationService.validateName(null);

//        then
        assertThrows(NullPointerException.class, actual);
    }

    @ParameterizedTest
    @MethodSource("sourceValidDoubleSurnames")
    void validateSurName_success(String validSurname) {
//        when
        Executable actual = () -> fullNameValidationService.validateSurname(validSurname);

//        then
        assertDoesNotThrow(actual);
    }

    @ParameterizedTest
    @MethodSource("sourceInvalidDoubleSurnames")
    void validateSurname_failed_with_invalidSurname(String invalidSurname) {
//        when
        Executable actual = () -> fullNameValidationService.validateSurname(invalidSurname);

//        then
        assertThrows(RegexValidationException.class, actual);
    }

    @Test
    void validateSurname_failed_with_null() {
//        when
        Executable actual = () -> fullNameValidationService.validateSurname(null);

//        then
        assertThrows(NullPointerException.class, actual);
    }

    @ParameterizedTest
    @MethodSource("sourceValidPatronymics")
    void validatePatronymic_success(String validPatronymic) {
//        when
        Executable actual = () -> fullNameValidationService.validatePatronymic(validPatronymic);

//        then
        assertDoesNotThrow(actual);
    }

    @ParameterizedTest
    @MethodSource("sourceInvalidPatronymics")
    void validatePatronymic_failed_with_invalidPatronymic(String invalidPatronymic) {
//        when
        Executable actual = () -> fullNameValidationService.validatePatronymic(invalidPatronymic);

//        then
        assertThrows(RegexValidationException.class, actual);
    }

    @Test
    void validatePatronymic_failed_with_null() {
//        when
        Executable actual = () -> fullNameValidationService.validatePatronymic(null);

//        then
        assertThrows(NullPointerException.class, actual);
    }

    static List<String> sourceValidFullName() {
        return List.of("Иванов Иван Иванович", "Иванов-Иванов Иван Иванович",
                "Иванов-Иванов И Иванович", "И-Иванов И Иванович");
    }

    static List<String> sourceInvalidFullNames() {
        return List.of("", "иванов Иван Иванович", "Иванов иван Иванович", "Иванов Иван иванович",
                "Иванов Иван", "Ivanov Ivan");
    }

    static List<String> sourceValidNames() {
        return List.of("Иван");
    }

    static List<String> sourceInvalidNames() {
        return List.of("", "иван", "Ivan", "Иван-иван");
    }

    static List<String> sourceValidDoubleSurnames() {
        return List.of("Иванов-Иванов", "И-Иванов");
    }

    static List<String> sourceInvalidDoubleSurnames() {
        return List.of("", "И-иванов", "иванов-И", "Иванов-И-Иванов", "Ivanov-I");
    }

    static List<String> sourceValidPatronymics() {
        return List.of("Иванович");
    }

    static List<String> sourceInvalidPatronymics() {
        return List.of("", "иванович", "Ivanovich", "И", "Иванович-Степанович");
    }
}
