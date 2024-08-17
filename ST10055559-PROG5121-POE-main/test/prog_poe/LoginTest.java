package prog_poe;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    
    Login login = new Login();
    
    public LoginTest() 
    {}

    @Test
    public void testCheckUsernameCorrectlyFormatted() 
    {
        String expected = "Username captured successfully.";
        String actual = Login.registerUserUsername("kyl_1");
        
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckPasswordIncorrectlyFormatted() 
    {
       String expected = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length. ";
       String actual = Login.registerUserUsername("kyle!!!!!");
                
        assertEquals(expected, actual);
    }

    @Test
    public void testPasswordMeetsComplexityRequirements() 
    {
        String expected = "Password captured successfully. ";
        String actual = Login.registerUserPassword("Ch&&sec@ke99!");
        
        assertEquals(expected, actual);
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() 
    {
        String expected = "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character. "; 
        String actual = Login.registerUserPassword("password");
        
        assertEquals(expected, actual);
    }

    @Test
    public void testTrueLoginSuccessfull() 
    {
        Login.username = "kyl_1";
        Login.password = "Ch&&sec@ke99!";
        boolean actual = Login.loginUser(Login.username, Login.password);
        
        assertTrue(actual);
    }

    @Test
    public void testFalseLoginUnsuccessfull() 
    {
        Login.username = "kyle!!!!" ;
        Login.password = "password";
        Login.savedUsername = "kyle_1";
        Login.savedPassword = "Ch&&sec@ke99!";
        
        boolean actual = Login.loginUser(Login.savedUsername, Login.savedPassword);
        
        assertFalse(actual);
    }

    @Test
    public void testTrueUsernameCorrectlyFormatted() 
    {
        boolean actual = Login.checkUsername("kyl_1");
        
        assertTrue(actual);
    }
    
    @Test
    public void testFalseUsernameIncorrectlyFormatted() 
    {
        boolean actual = Login.checkUsername("kyl!!!!!");
        
        assertFalse(actual);
    }
    
    @Test
    public void testTruePasswordCorrectlyFormatted() 
    {
        boolean actual = Login.checkPasswordComplexity("Ch&&sec@ke99!");
        
        assertTrue(actual);
    }
    
    @Test
    public void testFalsePasswordIncorrectlyFormatted() 
    {
        boolean actual = Login.checkPasswordComplexity("password");
        
        assertFalse(actual);
    }
}
