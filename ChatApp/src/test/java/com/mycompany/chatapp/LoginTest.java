/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chatapp; // Change this to your actual package name

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Login class.
 */
public class LoginTest {

    // Create an instance of the class we want to test
    Login login = new Login();

    @Test
    public void testCheckUserNameFormat() {
        // Test a valid username: contains "_" and is <= 5 chars
        assertTrue(login.checkUserName("ky_lo"), "Username should be valid");
        
        // Test an invalid username: no underscore
        assertFalse(login.checkUserName("kyle"), "Username should fail (no underscore)");
        
        // Test an invalid username: too long
        assertFalse(login.checkUserName("kyle_doe"), "Username should fail (too long)");
    }

    @Test
    public void testPasswordComplexity() {
        // Test a valid password
        assertTrue(login.checkPasswordComplexity("Ch@tt3r1"), "Password should meet complexity");
        
        // Test invalid passwords
        assertFalse(login.checkPasswordComplexity("short"), "Should fail (too short)");
        assertFalse(login.checkPasswordComplexity("lowercase1!"), "Should fail (no capital)");
        assertFalse(login.checkPasswordComplexity("NoNumber!"), "Should fail (no digit)");
    }

    @Test
    public void testLoginLogic() {
        // First, register a user to set the stored credentials
        login.registerUser("ky_lo", "Ch@tt3r1", "+27812345678", "Kyle", "Doe");
        
        // Test successful login
        assertTrue(login.loginUser("ky_lo", "Ch@tt3r1"), "Login should succeed with correct details");
        
        // Test failed login (wrong password)
        assertFalse(login.loginUser("ky_lo", "wrongpass"), "Login should fail with wrong password");
    }
}