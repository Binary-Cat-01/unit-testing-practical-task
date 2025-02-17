package com.walking.lesson125_unit_testing.service;

import com.walking.lesson125_unit_testing.model.FullName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class FullNameParsingServiceTest {
    private FullNameParsingService fullNameParsingService;
    static private FullNameValidationService fullNameValidationService;

    @BeforeAll
    static void beforeAll() {
        fullNameValidationService = Mockito.mock(FullNameValidationService.class);
    }

    @BeforeEach
    void setUp() {
        fullNameParsingService = new FullNameParsingService(fullNameValidationService);
    }

    @Test
    void parse_success() {
//        given
        Mockito.doNothing().when(fullNameValidationService).validateFullName(Mockito.any());
        Mockito.doNothing().when(fullNameValidationService).validateName(Mockito.any());
        Mockito.doNothing().when(fullNameValidationService).validateSurname(Mockito.any());
        Mockito.doNothing().when(fullNameValidationService).validatePatronymic(Mockito.any());

        String testFullNameString = "Иванов Иван Иванович";
        FullName validFullName = new FullName("Иван", "Иванов", "Иванович");
//        when
        FullName parsedFullName = fullNameParsingService.parseFullName(testFullNameString);
//        then
        assertEquals(validFullName, parsedFullName);
    }
}