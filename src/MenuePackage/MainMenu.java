
package MenuePackage;
import ExeptionHandler.ExeptionClass;
import HotelClasses.Rooms;
import ManagementClasses.CheckoutClass;
import ManagementClasses.CustomerManagement;
import ManagementClasses.FoodManagement;
import ManagementClasses.RoomManagement;
import ReciptionClasses.SearchAndGetStoredCustomers;
import ReciptionClasses.UpgradeAndDelete;

public class MainMenu {

    private int choice;
    
    //main menu method
    public void menu(){
        boolean loop = true;
        do {   
            
            System.out.println("Make a choice:\n1) Costumer | 2) Reciptionist | 0) Exit: ");
            choice = ExeptionClass.checkValue(ExeptionClass.TryCatchInt(), 0, 2);
            switch (choice){
                case 1:
                    costumerMenu();
                    break;
                case 2:
                    reciptionistMenu();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    throw new AssertionError();
            }
        } while (loop);
    }
    //costumer menu method
    private void costumerMenu(){
        
        boolean loop = true;
        do {     
            loop = true;
            System.out.println("1) Display room details  \n2) Display room availability \n3) Book "
                    + "\n4) Order food \n5) Checkout\n0) Exit.....");
            choice = ExeptionClass.checkValue(ExeptionClass.TryCatchInt(), 0, 5);
            switch (choice) {
                case 1:
                    new RoomManagement().roomDetails();         
                    break;
                case 2:
                    if(RoomManagement.available_room_list.isEmpty())
                        System.out.println("No available rooms!");
                    else
                    System.out.println("Available rooms: " + RoomManagement.available_room_list.size() + " Rooms");
                    RoomManagement.available_room_list.stream().sorted((o1,o2) -> o1.getRoomNumber() - o2.getRoomNumber())
                            .forEach(System.out::println);
                    break;
                case 3:
                    new CustomerManagement().addNewCustomer();
                    break; 
                case 4:
                    FoodManagement.order_Food();
                    break;
                case 5:
                    CheckoutClass.checkout();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    throw new AssertionError();
            }            
        } while (loop);
    }
    //reciptionist method
    private void reciptionistMenu(){                        
        boolean loop = true;
        do {     
            loop = true;
            System.out.println("1) Storing customer details  \n2) Searching Customer Details"
                    + "\n3) Maintan details \n4) Book a room"
                    + "\n0) Exit....");
            choice = ExeptionClass.checkValue(ExeptionClass.TryCatchInt(), 0, 4);
            switch (choice) {
                case 1:
                     SearchAndGetStoredCustomers.storedCustomers();
                    break;
                case 2:
                    SearchAndGetStoredCustomers.searchingCustomer();
                    break;
                case 3:
                    UpgradeAndDelete.upgradeDeleteMenu();
                    break; 
                case 4:
                    new CustomerManagement().addNewCustomer();
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
