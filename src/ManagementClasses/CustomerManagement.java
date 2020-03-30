
package ManagementClasses;
import ExeptionHandler.ExeptionClass;
import HotelClasses.Customer;
import HotelClasses.Rooms;
import java.util.ArrayList;
import java.util.List;
import DB.DBCustomers;

public class CustomerManagement {
//    public static List<Customer> customerList = new ArrayList<>(); //works without database
    public static List<Customer> customerList = DBCustomers.showCustomers();
    public void addNewCustomer(){
        if (RoomManagement.available_room_list.isEmpty()) {
                System.out.println("There are no rooms to book! ");
        }else{
            System.out.println("Enter Name: ");
            String name = ExeptionClass.str();
            System.out.println("Enter your contact number: ");
            int contact = ExeptionClass.TryCatchInt();
            System.out.println("How Many days you plain to stay: ");
            int days = ExeptionClass.TryCatchInt();
            boolean loopRoom = false;
             do{
                loopRoom = false;
                Rooms.RoomsTypeList.forEach((i,v) -> System.out.println(i +") " + v));
                int choice = ExeptionClass.checkValue(ExeptionClass.TryCatchInt(), 0, Rooms.RoomsTypeList.size());
                String roomTy = Rooms.RoomsTypeList.get(choice);
                if (RoomManagement.available_room_list.stream().filter(o -> o.getRumType().equals(roomTy)).count() > 0) {
                //getting roomnumber based on choice number
                int roomNumber = RoomManagement.available_room_list.stream()
                                        .filter(o -> o.getRumType().equals(Rooms.RoomsTypeList.get(choice))).findAny().get().getRoomNumber();
                            Customer c = new Customer(name, contact, days, roomNumber); 
//                           customerList.add(c);
                            DBCustomers.addCustomer(c);
                           RoomManagement.available_room_list.remove(RoomManagement.indexOfCustomersRoomNumber(c.getRoomNumber()));
                           System.out.println("Booking is successfull....\nYour roomNumber is: " + roomNumber);                            
                }else{
                            System.out.println("This room type is not availabel! Please choose another type!");
                            loopRoom = true;                    
                }
            }while (loopRoom);           
        }
    }
}
