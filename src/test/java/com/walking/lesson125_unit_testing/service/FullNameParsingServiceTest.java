package com.walking.lesson125_unit_testing.service;

import com.walking.lesson125_unit_testing.model.FullName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FullNameParsingServiceTest {
    @InjectMocks
    private FullNameParsingService fullNameParsingService;

    @Mock
    private FullNameValidationService fullNameValidationService;

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