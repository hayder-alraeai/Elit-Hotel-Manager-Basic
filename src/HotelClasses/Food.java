
package HotelClasses;

import static HotelClasses.Food.Food_Type.Sandwich;
import ManagementClasses.CustomerManagement;
import ManagementClasses.RoomManagement;
import java.util.Arrays;
import java.util.List;

public class Food {
    static int ID;
    private int id;
    public enum Food_Type{Sandwich, Pasta, Noodles, Drink };
    public static List<Food> foodMenuList = Arrays.asList(new Food(Food_Type.Sandwich, 50), new Food(Food_Type.Pasta, 90), new Food(Food_Type.Noodles, 90), new Food(Food_Type.Drink, 69));
    private Food_Type foodName;
    private double foodPrice;

    public Food(Food_Type foodName, double foodPrice) {
        this.id = ++ID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public int getId() {
        return id;
    }
    
    public Food_Type getFoodName() {
        return foodName;
    }

    public void setFoodName(Food_Type foodName) {
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }
    //this method is used in foodmanagement class to decide which food the user is choosed
    public static void foodChoice(int choice, int roomNumber){
        //this code brings the custom obj from the custom list by the room number
        int customerIndex = CustomerManagement.customerList.indexOf(RoomManagement.getAnCustomerInCustomerListByRoomNumber(roomNumber));
        Customer customerObj = CustomerManagement.customerList.get(customerIndex);
        switch (choice) {
            case 1:
                customerObj.setFoodPrice(50);
                customerObj.setFoods("Sandwich");
                break;
            case 2:
                customerObj.setFoodPrice(90);
                customerObj.setFoods("Pasta");
                break;
            case 3:
                customerObj.setFoodPrice(90);
                customerObj.setFoods("Noodles");
                break;                
            case 4:
                customerObj.setFoodPrice(70);
                customerObj.setFoods("Drink");
                break;
            default:
                break;
        }

    }
    @Override
    public String toString() {
        return  foodName + " " + foodPrice + " SEK"
                + "\n----------------------------------";
    }
    
}
