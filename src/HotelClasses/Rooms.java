
package HotelClasses;

import java.util.Map;
import java.util.TreeMap;

public class Rooms implements Interfaces.RoomTypesInterface{
    public static Map<Integer,String> RoomsTypeList = createMap();
    private  String roomType;
    private double price;
    private int roomNumber;

    public Rooms() {
    }
    
    public Rooms(String roomType, int roomNumber) {
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        if (roomType.equals("Single Lux")) {
            price = 500;
        }else if (roomType.equals("Single Delux")) {
            price = 700;
        }else if (roomType.equals("Duble Lux")) {
            price = 1000;
        }else if (roomType.equals("Duble Delux")) {
            price = 1300;
        }
    }
    
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    public String getRumType() {
        return roomType;
    }

    public void setRumType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }
    private static Map<Integer, String> createMap() {
        Map<Integer,String> myMap = new TreeMap<Integer,String>();
        myMap.put(1, "Single Lux");
        myMap.put(2, "Single Delux");
        myMap.put(3, "Duble Lux");
        myMap.put(4, "Duble Delux");
        return myMap;
    }

    @Override
    public String toString() {
        return "Room Type: " + roomType + "\nRoom number: " + roomNumber + "\nPrice: " + price + "\n------------------------";
    }
    @Override
    public  String hasTv(String roomType) {
        String single = RoomsTypeList.get(2);
        if (roomType.equalsIgnoreCase(RoomsTypeList.get(2)) || roomType.equalsIgnoreCase(RoomsTypeList.get(4))) 
            return "Yes";
 
        else return "No";
    }
    
}
