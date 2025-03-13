package com.walking.lesson125_unit_testing.service;

import com.walking.lesson125_unit_testing.exception.RegexValidationException;
import com.walking.lesson125_unit_testing.model.FullName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FullNameParsingServiceTest {
    @InjectMocks
    private FullNameParsingService fullNameParsingService;

    @Mock
    private FullNameValidationService fullNameValidationService;

    @Test
    void parseFullName_success() {
//        given
        FullName expected = new FullName("Иван", "Иванов", "Иванович");

//        when
        FullName result = fullNameParsingService.parseFullName("Иванов Иван Иванович");

//        then
        assertEquals(expected, result);

        verify(fullNameValidationService).validateFullName(anyString());
        verify(fullNameValidationService).validateSurname(anyString());
        verify(fullNameValidationService).validateName(anyString());
        verify(fullNameValidationService).validatePatronymic(anyString());
    }

    @Test
    void parseFullName_failed_with_invalidFullName() {
//        given
        doThrow(RegexValidationException.class).when(fullNameValidationService)
                                               .validateFullName(anyString());

//        when
        Executable actual = () -> fullNameParsingService.parseFullName(anyString());

//        then
        assertThrows(RegexValidationException.class, actual);

        verify(fullNameValidationService).validateFullName(anyString());

        verify(fullNameValidationService, never()).validateSurname(anyString());
        verify(fullNameValidationService, never()).validateName(anyString());
        verify(fullNameValidationService, never()).validatePatronymic(anyString());
    }

    @Test
    void parseFullName_failed_with_null() {
//        when
        Executable actual = () -> fullNameParsingService.parseFullName(null);

//        then
        assertThrows(IllegalArgumentException.class, actual);

        verify(fullNameValidationService, never()).validateFullName(anyString());
        verify(fullNameValidationService, never()).validateSurname(anyString());
        verify(fullNameValidationService, never()).validateName(anyString());
        verify(fullNameValidationService, never()).validatePatronymic(anyString());
    }
}
