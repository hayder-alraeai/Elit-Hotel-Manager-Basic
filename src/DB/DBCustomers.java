
package DB;
import HotelClasses.Customer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import DB.DBRooms;
public class DBCustomers {
    static Scanner x;
    static String Path = "customers.txt";
    public static int idGenerator(){
        int id = 0;
        try {
            x = new Scanner(new File(Path));
            x.useDelimiter("[\n]");
            while (x.hasNext()) {
                id ++;  
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erorr in idGenerator method " + ex);
        }
        return  id + 1;
    }
    public static void addCustomer(Customer obj){
        try {
            FileWriter fw = new FileWriter(Path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(obj);
            pw.flush();
            pw.close();
            //adding the room to rooms.txt
            FileWriter fwr = new FileWriter("rooms.txt", true);
            BufferedWriter bwr = new BufferedWriter(fwr);
            PrintWriter pwr = new PrintWriter(bwr);
            pwr.println(obj.getRoomNumber());
            pwr.flush();
            pwr.close();
            System.out.println("Customer is added... ");
        } catch (IOException ex) {
            System.err.println("Erorr in adding method!" + ex);
        }
        
    }
    public static List<Customer> showCustomers(){
        List<Customer> myList = new ArrayList<>();
        try {
           int id = 0; String name = ""; int contact_number = 0; int bookingsDays = 0; int room = 0;
            x = new Scanner(new File(Path));
            x.useDelimiter("[,\n]");
            while(x.hasNext()){
                id = x.nextInt(); name = x.next(); contact_number = x.nextInt(); bookingsDays = x.nextInt(); room = x.nextInt();
                myList.add(new Customer(name, contact_number, bookingsDays, room));
            }
            x.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Erorr in showCustomer..." + ex);
        }
        return myList;
    }
    public static void searchCustomers(){
        
    }
    public static void deleteCustomer(){
        
    }
    public static void updateCustomer(){
        
    }
    
}
