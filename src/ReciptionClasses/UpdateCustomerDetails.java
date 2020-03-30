
package ReciptionClasses;

import HotelClasses.Customer;
import ExeptionHandler.ExeptionClass;
public class UpdateCustomerDetails {
    public static void Update(Customer obj){
        boolean loop = true;
        do {
            System.out.println(obj);
            System.out.println("1) update name: | 2) update contact number: | 3) Update room: | 4) Update Days to stay | 0) Exit..");
            int choice = ExeptionClass.checkValue(ExeptionClass.TryCatchInt(), 0, 4);
            switch (choice) {
                case 1:
                    System.out.println("Current name is " + obj.getName() + "\nEnter a new name: ");
                    obj.setName(ExeptionClass.str());
                    System.out.println("Name is updated! ");
                    break;
                case 2:
                    System.out.println("Current contact number is " + obj.getContact_number() + "\nEnter a new number: ");
                    obj.setContact_number(ExeptionClass.TryCatchInt());
                    System.out.println("Contact number is updated! ");
                    break;
                case 3: 
                    UpgradeAndDelete.upgradeRoomType();
                    break;
                case 4:
                    System.out.println("Current booked days are " + obj.getBookingsDays() + "\nEnter the new days to stay: ");
                    obj.setBookingsDays(ExeptionClass.TryCatchInt());
                    System.out.println("Your booked days is updated! ");
                    break;
                case 0:
                    loop = false;
                    break;
            }
        } while (loop);
    }
}
