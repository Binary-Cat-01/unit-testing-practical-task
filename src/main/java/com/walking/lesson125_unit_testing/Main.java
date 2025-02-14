package com.walking.lesson125_unit_testing;

import com.walking.lesson125_unit_testing.service.FullNameValidationService;

/**
 * На базе представленного решения
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson30_regex/task2/Main.java">задачи 2 урока 30</a>
 * произведите декомпозицию решения с учетом объектной модели и покройте получившееся решение юнит-тестами.
 */
public class Main {

    public static void main(String[] args) {
        FullNameValidationService fullNameValidationService = new FullNameValidationService();

        fullNameValidationService.validateFullName(null);
    }
}
