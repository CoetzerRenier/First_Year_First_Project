package prog_poe;

import javax.swing.JOptionPane;

public class ST10055559 {

    public static void main(String[] args) 
    {
        //Prompts user for their first name and last name and saves them in variables.
        Login.firstName = JOptionPane.showInputDialog("Please enter your first name: ");
        Login.lastName = JOptionPane.showInputDialog("Please enter your last name: ");
        
        //Prompts user for a username, then sends it to the usernameComplexity checker method, then the registerUsername method checks if it complys with the rules and displays a message accordingly.
        Login.username = JOptionPane.showInputDialog("Please enter your desired username: ");
        Login.checkUsername(Login.username);
        JOptionPane.showMessageDialog(null, Login.registerUserUsername(Login.username));
        
        //Prompts user for a password, then sends it to the passwordComplexity checker method, then the registerPassword method checks if it complys with the rules and displays a message accordingly.
        Login.password = JOptionPane.showInputDialog("Please enter your desired password: ");
        Login.checkPasswordComplexity(Login.password);
        JOptionPane.showMessageDialog(null, Login.registerUserPassword(Login.password));
        
        //The registerSuccessfull method checks if both previous register methods where successfull, and displays a message accordingly.
        JOptionPane.showMessageDialog(null, Login.registerUserSuccessfull());
        
        //Prompts the user to enter the username and password that they used to register, the sends it to the loginUser method to check if they where valid.
        Login.savedUsername = JOptionPane.showInputDialog("Please login using your username: ");
        Login.savedPassword = JOptionPane.showInputDialog("Please login using your password: ");
        Login.loginUser(Login.savedUsername, Login.savedPassword);
        
        //This method displays a message based off of what the boolean result from the previous method was. 
        JOptionPane.showMessageDialog(null, Login.returnLoginStatus());
    }
    
}
