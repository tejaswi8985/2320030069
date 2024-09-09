package project;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class UserManagerTest {
    private static final String TEST_FILE_NAME = "test_users.txt";
    private UserManager userManager;

    @Before
    public void setUp() {
        // Initialize UserManager with a test file
        userManager = new UserManager(TEST_FILE_NAME);
    }

    @After
    public void tearDown() {
        // Clean up test file
        File testFile = new File(TEST_FILE_NAME);
        if (testFile.exists()) {
            boolean deleted = testFile.delete();
            if (!deleted) {
                System.out.println("Failed to delete test file: " + TEST_FILE_NAME);
            }
        }
    }

    @Test
    public void testRegisterUser() {
        boolean result = userManager.registerUser("user1", "pass1");
        assertTrue("User registration should succeed", result);
        
        result = userManager.registerUser("user1", "pass1"); // Attempt to register duplicate user
        assertFalse("User registration should fail for duplicate user", result);
    }

    @Test
    public void testLoginUser() {
        userManager.registerUser("user2", "pass2");
        
        assertTrue("User login should succeed with correct credentials", userManager.loginUser("user2", "pass2"));
        assertFalse("User login should fail with incorrect password", userManager.loginUser("user2", "wrongpass"));
        assertFalse("Login should fail for non-existent user", userManager.loginUser("nonexistent", "pass"));
    }

    @Test
    public void testRecoverPassword() {
        userManager.registerUser("user3", "pass3");
        
        assertTrue("Password recovery should succeed", userManager.recoverPassword("user3", "newpass3"));
        assertTrue("User login should succeed with new password", userManager.loginUser("user3", "newpass3"));
        assertFalse("Old password should no longer work", userManager.loginUser("user3", "pass3"));
        assertFalse("Password recovery should fail for non-existent user", userManager.recoverPassword("nonexistent", "pass"));
    }

    @Test
    public void testRegisterAndLogin() {
        assertTrue("User registration should succeed", userManager.registerUser("user4", "pass4"));
        assertTrue("User login should succeed with correct credentials", userManager.loginUser("user4", "pass4"));
    }
}
