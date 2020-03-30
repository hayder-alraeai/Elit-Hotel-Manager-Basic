
package ExeptionHandler;
import MenuePackage.MainMenu;
import java.util.Scanner;

public class ExeptionClass {
    static Scanner in = new Scanner(System.in);
    //tryCatch methods
    public static int TryCatchInt(){
        boolean done = false;
        int num = 0;
        while (!done) {
            try {
                num = in.nextInt();
                in.nextLine();
                done = true;
            } catch (Exception e) {
                System.out.println("Wrong datatype! Please enter a number");
                in.nextLine();
            }
            
        }
        return num;
    }
    //overload tryCatch
    public static double TryCatchDouble(){
        boolean done = false;
        double num = 0;
        while (!done) {
            try {
                num = in.nextDouble();
                in.nextLine();
                done = true;
            } catch (Exception e) {
                System.out.println("Wrong datatype! Please enter a number");
                in.nextLine();
            }
            
        }
        return num;
    }
    //checking and begransa data
    public static int checkValue(int input, int start, int end){
        boolean done = false;
        int num = input;
        while (!done) {
            if (num < 0) {
                System.out.println("Please enter a value greater than 0");
                num = TryCatchInt();
            }else{
                if (num < start || num > end) {
                    System.out.println("Please enter a value between " + start + " and " + end + "!");
                    num = TryCatchInt();
                }
                else{
                    done = true;
                }
            } 
        }
        return num;
    }
    //overload check method
    public static double checkValue(double input, int start, int end){
        boolean done = false;
        double num = input;
        while (!done) {
            if (num < 0) {
                System.out.println("Please enter a value greater than 0");
                num = TryCatchDouble();
            }else{
                if (num < start || num > end) {
                    System.out.println("Please enter a value between " + start + " and " + end + "!");
                    num = TryCatchDouble();
                }
                else{
                    done = true;
                }
            } 
        }
        return num;
   }
    //scan a string
    public static String str(){
        return in.nextLine();
    }
    //password method
    public static boolean passwordGenerator(String password){
        boolean isRight = false;
        boolean loop = true;
        do { 
            System.out.println("Enter Password or 0 to Exit...");
            if(str().equals(password)){
                loop = false;
                isRight = true;
            }else if(str().equalsIgnoreCase("0")){
                isRight = false;
                loop = false;
            }
        } while (loop);
         return isRight;
    }
    
}
