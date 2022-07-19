/// @author: Bertan Berker
/// This program finds the password of a user by using the backtracking algorithm
/// The password is all numerical and it is 4 characters long ex: 1234, 5667
/// This is accomplished by finding one number at a time


import java.net.SocketPermission;
import java.util.Random;

public class passwordCracker {


    /// Backtrackiing algo to crack the password
    /// When correct a window pops up saying, the password has been cracked and it is: 
    /// A random number generator creates a number and we try to find it


    /// random 4 digit number generator: THE PASSWORD

    public static Random rand = new Random();
    public static int rand_int = rand.nextInt(9000) + 1000;

    public static String password = String.valueOf(rand_int);

    public static String solution = "";

    static boolean passwordFinder(int place) {
        
        /// Checking if the place equals four, which means there is not need for further backtracking
        
        if (place == 4) {
            return true;
        }

        /// Checking if the digit is at the correct place

        for (int i = 0; i < 10; i++) {

            if (isPassword(String.valueOf(i), place)) {
                
                solution += String.valueOf(i);

                if (passwordFinder(place+1)) {
                    return true;
                }
            }
        }
        
        return false;
    }



    /// Checks whether the given number is the right one or not

    static boolean isPassword(String number, int place) {
        return number.equals(Character.toString(password.charAt(place)));
    }



    /// Prints the passwords that I generated

    static void print(int one, int two, int three, int four) {
        System.out.println(String.valueOf(one) + String.valueOf(two) + 
        String.valueOf(three) + String.valueOf(four));
    }


    /// Starts the program 
    public static void main(String [] args){
        System.out.println();
        System.out.println("The Secret password is: " + password);
        System.out.println("Welcome to Password Finder!");
        System.out.println("Cracking the Password...");

        passwordFinder(0);

        System.out.println("The Password has been cracked!");
        System.out.println("It is: ");
        System.out.println(solution);
        System.out.println();
    }
}
