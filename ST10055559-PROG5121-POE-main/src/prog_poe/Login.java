package prog_poe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Login 
{
    static String username, password, savedPassword, savedUsername, firstName, lastName;

    //This method checks that the username meets complexity requirements.
    public static boolean checkUsername(String username) 
    {
        String regex = "^(?=.*[_])"
                + "(?=\\S+$).{2,5}$";

        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(username);

    return m.matches();
    //Srivastava, P. 2020. How to validate a Password using Regular Expressions in Java. [Java Code] 
    //https://www.geeksforgeeks.org/how-to-validate-a-password-using-regular-expressions-in-java/ (Accessed 10 May 2022)
    
    }
    
    //This method checks that the password meets the complexity requirements.
    public static boolean checkPasswordComplexity(String password) 
    {
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
        
        Pattern p = Pattern.compile(regex);
   
        Matcher m = p.matcher(password);
        
    return m.matches();
    //Srivastava, P. 2020. How to validate a Password using Regular Expressions in Java. [Java Code] 
    //https://www.geeksforgeeks.org/how-to-validate-a-password-using-regular-expressions-in-java/ (Accessed 10 May 2022)
    
    }

    //This method takes the boolean from the username complexity checker method and displays a message according to what the answer was (true or false).
    public static String registerUserUsername(String username) 
    {
        String result = "";

        if (checkUsername(username) == true) 
        {
            result = "Username captured successfully.";
        } 
        else if(checkUsername(username) == false) 
        {
            result = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length. ";
        }

    return result;
    }
    
    //This method takes the boolean from the password complexity checker method and displays a message according to what the answer was (true or false).
    public static String registerUserPassword(String password)
    {
        String result = "";
        
        if(checkPasswordComplexity(password) == true)
        {
            result = "Password captured successfully. ";
        }
        else if(checkPasswordComplexity(password) == false)
        {
            result = "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character. ";        
        }
        
    return result;
    }
    
    //This method checks to see if both the register methods for the username and password, display the "captured successfully" messages and then displays either registration successfull. Iff they do not both display captures successfully then registration will fail.
    public static String registerUserSuccessfull()
    {
        String result = "";
        
        if("Username captured successfully. ".equals(registerUserUsername(username)) && "Password captured successfully. ".equals(registerUserPassword(password)))
        {
            result = "Registration successfull. ";
        }
        else
        {
            result = "Registration failed. ";
        }    
        
    return result;
    }
    
    //This method checks to see wether the entered username and password matches the created username and password from before, and then sends a boolean value to the next method.
    public static boolean loginUser(String savedUsername, String savedPassword)
    {
        boolean result;
        
        if(savedUsername.matches(username) && savedPassword.matches(password))
        {
           result = true;         
        }
        else
        {
            result = false;
        }

    return result;
    }
    
    //This method takes that boolean value from the loginUser method and then dsiplays a success or failed message. If it was a success it will also call the saved first and last name of the user to use in a welcome message.
    public static String returnLoginStatus()
    {
        String result = "";
        
        if(loginUser(savedUsername, savedPassword) == true)
        {
            result = "Welcome  " + firstName + " " + lastName + " it is great to see you. " ;
        }
        else if(loginUser(savedUsername, savedPassword) == false)
        {
            result = "Login failed. ";
        }
        
    return result;
    }
}
