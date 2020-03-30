
package ManagementClasses;

import HotelClasses.Customer;
import HotelClasses.Food;

public class FoodManagement {
    public static void order_Food(){
        boolean loop = true;
        do {            
            Food.foodMenuList.forEach(p -> System.out.println(p.getId() + ") " + p));
            int foodNumber = ExeptionHandler.ExeptionClass.checkValue(ExeptionHandler.ExeptionClass.TryCatchInt(),1, Food.foodMenuList.size());
            System.out.println("Enter room number: ");
            int roomNumber = ExeptionHandler.ExeptionClass.TryCatchInt();
            if (CustomerManagement.customerList.stream().anyMatch(o -> o.getRoomNumber() == roomNumber)) {
                Food.foodChoice(foodNumber, roomNumber);
                System.out.println("Your food is ordered....\nDo you like to order another think? Y/N");
                if (ExeptionHandler.ExeptionClass.str().equalsIgnoreCase("n")) {
                    loop = false;
                }                
            }else{
                System.out.println("The room is not found! Contineu? Y/N ");
                if (ExeptionHandler.ExeptionClass.str().equalsIgnoreCase("n")) {
                    loop = false;
                }else{
                  loop =true;  
                }   
            }

        } while (loop);
    }
    //overload the method to reuse it in reciption section
    public static void order_Food(Customer obj){
    boolean loop = true;
        do {            
            Food.foodMenuList.forEach(p -> System.out.println(p.getId() + ") " + p));
            int foodNumber = ExeptionHandler.ExeptionClass.checkValue(ExeptionHandler.ExeptionClass.TryCatchInt(),1, Food.foodMenuList.size());
            int roomNumber = obj.getRoomNumber();
                Food.foodChoice(foodNumber, roomNumber);
                System.out.println("Food is ordered....\nDo you like to order another think? Y/N");
                if (ExeptionHandler.ExeptionClass.str().equalsIgnoreCase("n")) {
                    loop = false;
                }                
        } while (loop);
    }



}
