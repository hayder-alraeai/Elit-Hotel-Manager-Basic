
package HotelClasses;

import ManagementClasses.RoomManagement;
import java.util.ArrayList;
import java.util.List;
import DB.DBCustomers;
public class Customer {
    static int ID;
    private int id;
    private String name;
    private int contact_number;
    private int roomNumber;
    private int bookingsDays;
    private double foodPrice;
    private List<String> foods = new ArrayList<>();

    
    public Customer(String name, int contact_number, int bookingsDays, int room) {
        this.roomNumber = room;
        this.name = name;
        this.contact_number = contact_number;
        this.bookingsDays = bookingsDays;
        this.id = ++ID;
    }

    public int getId() {
        return id;
    }
    
    public List<String> getFoods() {
        return foods;
    }

    public void setFoods(String food) {
        this.foods.add(food);
    }
    public void resetFoodArr(){ //reset the arrray of foods
        this.foods.clear();
    }
    
    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice += foodPrice;
    }
    public void setFoodPriceReduced(double foodPrice ){ //to reduce the price of foods
        this.foodPrice = foodPrice;
    }
    
    public int getBookingsDays() {
        return bookingsDays;
    }

    public void setBookingsDays(int bookingsDays) {
        this.bookingsDays = bookingsDays;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContact_number() {
        return contact_number;
    }

    public void setContact_number(int contact_number) {
        this.contact_number = contact_number;
    }
    public double totalPrice(){
        return foodPrice + (bookingsDays * RoomManagement.total_room_list.get(RoomManagement.getIndexTotalList(roomNumber)).getPrice());
    }
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public String getRoomTyp(){
        return RoomManagement.getRoomFromTotalRoomListByRoomNumber(roomNumber).getRumType();
    }
    public double getRoomPrice(){
        return RoomManagement.getRoomFromTotalRoomListByRoomNumber(roomNumber).getPrice();
    }
    
//    @Override
//    public String toString() {
//        if(foodPrice > 0)
//            return "--ID: " + id + "\nName: " + name + 
//                "\nContact Number: " + contact_number + 
//                "\nRoom Number: " + getRoomNumber() + " " + getRoomType() + " "
//                     + getRoomPrice() +
//                "\nBooked Days: " + bookingsDays +
//                "\nFood: " + foods + " " + foodPrice + " SEK" +
//                "\nPrice: " + totalPrice() + " SEK\n"
//                + "------------------------------------------";
//        else
//        
//        return "--ID: " + id + "\nName: " + name + 
//                "\nContact Number: " + contact_number + 
//                "\nRoom Number: " + getRoomNumber() + " " + RoomManagement.getRoomFromTotalRoomListByRoomNumber(roomNumber).getRumType() + " "  
//                + RoomManagement.getRoomFromTotalRoomListByRoomNumber(roomNumber).getPrice() +
//                "\nBooked Days: " + bookingsDays +
//                "\nPrice: " + totalPrice() + " SEK\n"
//                + "------------------------------------------";
//    }

    @Override
    public String toString() {
        return id + "," + name + "," + contact_number + "," + roomNumber + "," + bookingsDays;
    }


    
}
