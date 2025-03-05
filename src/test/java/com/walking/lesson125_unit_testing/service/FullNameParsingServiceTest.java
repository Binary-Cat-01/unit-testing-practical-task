package com.walking.lesson125_unit_testing.service;

import com.walking.lesson125_unit_testing.exception.RegexValidationException;
import com.walking.lesson125_unit_testing.model.FullName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
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
    void parseFullName_success() {
//        given
        String testFullNameString = "Иванов Иван Иванович";
        FullName validFullName = new FullName("Иван", "Иванов", "Иванович");
//        when
        FullName parsedFullName = fullNameParsingService.parseFullName(testFullNameString);
//        then
        assertEquals(validFullName, parsedFullName);
    }

    @Test
    void parseFullName_fail() {
        //        given
        Mockito.doThrow(RegexValidationException.class)
               .when(fullNameValidationService)
               .validateFullName(Mockito.anyString());
        //        when
        Executable actual = () -> fullNameParsingService.parseFullName(Mockito.any());
        //        then
        assertThrows(RuntimeException.class, actual);
    }
}