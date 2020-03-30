
package ManagementClasses;
import HotelClasses.Customer;
import HotelClasses.Rooms;
import static HotelClasses.Rooms.RoomsTypeList;
import java.util.ArrayList;
import java.util.List;

public class RoomManagement extends Rooms{
    public static List<Rooms> total_room_list = createArrayList();
    public static List<Rooms> available_room_list = new ArrayList<>(total_room_list);

    private static <T> List<T> createArrayList() {
        List<T> myMap = new ArrayList<>();
        myMap.add((T) new Rooms(Rooms.RoomsTypeList.get(1), 1));
        myMap.add((T) new Rooms(Rooms.RoomsTypeList.get(1), 2));
        myMap.add((T) new Rooms(Rooms.RoomsTypeList.get(1), 3));
        myMap.add((T) new Rooms(Rooms.RoomsTypeList.get(1), 4));
        myMap.add((T) new Rooms(Rooms.RoomsTypeList.get(2), 5));
        myMap.add((T) new Rooms(Rooms.RoomsTypeList.get(2), 6));
        myMap.add((T) new Rooms(Rooms.RoomsTypeList.get(2), 7));
        myMap.add((T) new Rooms(Rooms.RoomsTypeList.get(2), 8));
        myMap.add((T) new Rooms(Rooms.RoomsTypeList.get(3), 9));
        myMap.add((T) new Rooms(Rooms.RoomsTypeList.get(3), 10));
        myMap.add((T) new Rooms(Rooms.RoomsTypeList.get(4), 11));
        myMap.add((T) new Rooms(Rooms.RoomsTypeList.get(4), 12)); 
        return myMap;
    }
    public static void availabelList(){
        available_room_list.forEach(System.out::println);
    }
    public static boolean checkIfBuzy(Rooms r){
        for (Rooms room : total_room_list) {
            for (Customer c : CustomerManagement.customerList) {
                if (room.getRoomNumber() == c.getRoomNumber()) {
                    return false;
                }
            }
        }
        return true;
    }
    //this method return customers index in customers list by rumnumber
    public static int indexOfCustomersRoomNumber(int rumNum){
        for (int i = 0; i < available_room_list.size(); i++) {
            if (available_room_list.get(i).getRoomNumber() == rumNum) {
                return i;
            }
        }
        return -1;
    }
    public static int getIndexTotalList(int roomNumber){
        for (int i = 0; i < total_room_list.size(); i++) {
            if (total_room_list.get(i).getRoomNumber() == roomNumber) {
                return i;
            }
        }
        return -1;
    }
    public static Customer getAnCustomerInCustomerListByRoomNumber(int roomnum){
        for (Customer customer : CustomerManagement.customerList) {
            if (customer.getRoomNumber() == roomnum) {
                return customer;
            }
        }
        return null;
    }
    public static boolean checkAvailableRoom(String rum){
        return available_room_list.stream().noneMatch(o -> o.getRumType().equals(rum));  
    }
    //to get a room from totalRoomList
    public static Rooms getRoomFromTotalRoomListByRoomNumber(int roomNumber){
        return total_room_list.stream().filter(o -> o.getRoomNumber() == roomNumber).findAny().get();
    }
    public void roomDetails() {
        System.out.println("Single Lux : " + RoomsTypeList.get(1) + "\nBeds: One bed\nTv: " + hasTv(RoomsTypeList.get(1)) + "\nPrice: 500 SEK\n---------------------------");
        System.out.println("Single Delux : " + RoomsTypeList.get(2) + "\nBeds: Two beds\nTv: " + hasTv(RoomsTypeList.get(2)) + "\nPrice: 700 SEK\n---------------------------");
        System.out.println("Duble Lux : " + RoomsTypeList.get(3) + "\nBeds: One bed\nTv: " + hasTv(RoomsTypeList.get(3)) + "\nPrice: 1000 SEK\n---------------------------");
        System.out.println("Duble Delux : " + RoomsTypeList.get(4) + "\nBeds: One bed\nTv: " + hasTv(RoomsTypeList.get(4)) + "\nPrice: 1300 SEK\n---------------------------");
    }
    
}
