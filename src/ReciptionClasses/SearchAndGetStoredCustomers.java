
package ReciptionClasses;

import static ManagementClasses.CustomerManagement.customerList;
import ManagementClasses.RoomManagement;

public class SearchAndGetStoredCustomers {
    //get stored customers
    public static void storedCustomers(){
        if (customerList.isEmpty()) {
            System.out.println("No customers are found! ");
        }else{
        customerList.forEach(c -> System.out.println("--ID: " + c.getId() + "\nName: " + c.getName() + "\nContact Number: " + c.getContact_number() + "\nNumber of booking days: " + c.getBookingsDays() + 
                "\nOrdered food: " + c.getFoods() + " " + c.getFoodPrice() + " SEK\nRoom Number: " + c.getRoomNumber() +
                 "\nRoom Type: " + RoomManagement.getRoomFromTotalRoomListByRoomNumber(c.getRoomNumber()).getRumType() +
                " " + RoomManagement.getRoomFromTotalRoomListByRoomNumber(c.getRoomNumber()).getPrice() + "\nTotal price: " + c.totalPrice() + " SEK" +
                "\n-----------------------------------------------"));
        }
    }
    public static void searchingCustomer(){
        if (customerList.isEmpty()) {
            System.out.println("No customer are found!");
        }
        else{
            boolean loop = true;
            do { 
                System.out.println("1) Searching by name | 2) Searching by room number | 3) Searching by id | 0) Exit...");
                int choice = ExeptionHandler.ExeptionClass.checkValue(ExeptionHandler.ExeptionClass.TryCatchInt(), 0, 3);
                switch (choice) {
                    case 1:
                        searchByName();
                        break;
                    case 2:
                        searchByRoomNumber();
                        break;
                    case 3:
                        searchById();
                        break;
                    case 0:
                        loop = false;
                        break;
                    default:
                        throw new AssertionError();
                } 
            } while (loop);
        }
    } 
    private static void searchByName(){
        System.out.println("Enter Customer name: ");
        String name = ExeptionHandler.ExeptionClass.str();
        if (customerList.stream().anyMatch(o -> o.getName().equalsIgnoreCase(name)))
            customerList.stream().filter(o -> o.getName().equalsIgnoreCase(name)).forEach(System.out::println);
        else
            System.out.println("Customer " + name + " cannot be found! ");
    }
    private static void searchByRoomNumber(){
        System.out.println("Enter room number: ");
        int roomNumber = ExeptionHandler.ExeptionClass.TryCatchInt();
        if (customerList.stream().anyMatch(o -> o.getRoomNumber() == roomNumber))
            customerList.stream().filter(o -> o.getRoomNumber() == roomNumber).forEach(System.out::println);
        else
            System.out.println("Room number " + roomNumber + " cannot be found! ");        
    }
    private static void searchById(){
        System.out.println("Enter customer's id: ");
        int id = ExeptionHandler.ExeptionClass.TryCatchInt();
        if (customerList.stream().anyMatch(o -> o.getId()== id))
            customerList.stream().filter(o -> o.getId()== id).forEach(System.out::println);
        else
            System.out.println("Customer with id " + id + " cannot be found! "); 
    }
}
