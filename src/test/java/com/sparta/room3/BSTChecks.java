package com.sparta.room3;

import com.sparta.room3.model.EmployeeFactory;
import org.junit.jupiter.api.*;
import java.io.IOException;

public class BSTChecks {

    @Test
    @DisplayName("Check data is being loaded from the csv and stored in a String array")
    void checkThatDataIsBeingLoadedFromTheCsvAndStoredInAStringArray() {
        try {
            Assertions.assertInstanceOf(String[].class, EmployeeFactory.getEmployees(1));
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }

    }
}