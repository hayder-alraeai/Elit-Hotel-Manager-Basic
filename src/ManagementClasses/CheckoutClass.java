
package ManagementClasses;

import HotelClasses.Customer;
import HotelClasses.Rooms;

public class CheckoutClass {
    private static int roomNumber;
    private static Rooms room;
    public static void checkout(){
        boolean loop = false;
        do {            
            System.out.println("Enter room number please: ");
            roomNumber = ExeptionHandler.ExeptionClass.TryCatchInt();
            if (CustomerManagement.customerList.stream().anyMatch(o -> o.getRoomNumber() == roomNumber)) {
                Customer obj = RoomManagement.getAnCustomerInCustomerListByRoomNumber(roomNumber);
                showBill(obj);
                removeRoomFromCustomer(roomNumber);                
            }else{
                System.out.println("The room " + roomNumber + " is not found! Continue?Y/N ");
                loop = !ExeptionHandler.ExeptionClass.str().equalsIgnoreCase("n");  
            }
        } while (loop);  
    }
    public static void removeRoomFromCustomer(int roomNum){
        Customer obj = RoomManagement.getAnCustomerInCustomerListByRoomNumber(roomNum);//Get the object from customer list
        room = RoomManagement.total_room_list.get(RoomManagement.getIndexTotalList(roomNum));//get the room to add it to the available list
        CustomerManagement.customerList.remove(obj);//remove the object from Customer list 
        RoomManagement.available_room_list.add(room);//add the room to the available room list.
    }
    public static void showBill(Customer obj){
        room = RoomManagement.total_room_list.get(RoomManagement.getIndexTotalList(obj.getRoomNumber()));//get the room to add it to the available list
        System.out.println("Name: " + obj.getName() + "\nContact number: " + obj.getContact_number() + "\nRoom number: " + obj.getRoomNumber() + "\nBookings Days: " + obj.getBookingsDays() 
                            + "\nFood ordered: " + obj.getFoods() + "\nPrice for food: " + obj.getFoodPrice() + "SEK" + "\nRoom Price for " + room.getRumType() + " a day: "
                            + RoomManagement.total_room_list.get(RoomManagement.getIndexTotalList(obj.getRoomNumber())).getPrice() + "SEK" + "\nTotal room Price: " 
                            + (obj.getBookingsDays() * RoomManagement.total_room_list.get(RoomManagement.getIndexTotalList(obj.getRoomNumber())).getPrice()) 
                            + "SEK" + "\nTotal Price: " + obj.totalPrice() + "SEK" + "\n----------------------------------------");
                            
    }
}
