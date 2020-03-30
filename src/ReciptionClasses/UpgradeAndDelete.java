package ReciptionClasses;
import ExeptionHandler.ExeptionClass;
import ManagementClasses.*;
import HotelClasses.*;
public class UpgradeAndDelete {
    private static  Customer obj;
    private static int roomNumber;
    private static Rooms currentRoom;
    public static void upgradeDeleteMenu(){
        if (CustomerManagement.customerList.isEmpty()) {
            System.out.println("No Customers are found!");
        }else{
                boolean loop = true;
                do {  
                    loop = true;
                    System.out.println("Enter room number or press 0 to Exite ");
                    roomNumber = ExeptionClass.TryCatchInt();
                    if (roomNumber == 0){
                        loop = false;
                    }
                    else {  
                        obj = CustomerManagement.customerList.stream().filter(o -> o.getRoomNumber() == roomNumber).findAny().get();//geting the customer object in customer list
                        if (CustomerManagement.customerList.stream().anyMatch(o -> o.getRoomNumber() == roomNumber)) {
                            boolean loop1 = true;
                            do {                        
                                System.out.println("1) Show bill: | 2) Update Customer details: | 3) Order food | 4) Checkout a customer 0) Exit...");
                                int choice = ExeptionClass.checkValue(ExeptionClass.TryCatchInt(), 0, 4);
                                switch (choice) {
                                    case 1:
                                        CheckoutClass.showBill(obj);
                                        break;
                                    case 2:
                                        UpdateCustomerDetails.Update(obj);
                                        break;
                                    case 3:
                                        FoodManagement.order_Food(obj);
                                        break;
                                    case 4:
                                        CheckoutClass.removeRoomFromCustomer(obj.getRoomNumber());
                                        CheckoutClass.showBill(obj);
                                        System.out.println("Customer " + obj.getName() + " is outchecked! ");
                                        break;
                                    default:
                                        loop1 = false;
                                        break;
                                }
                                    loop = false;
                            } while (loop1);
                        }else{
                            System.out.println("Room number " + roomNumber + " is not found! ");
                        }
                    }
            } while (loop);
        }
    }
    public static void upgradeRoomType(){
            currentRoom = RoomManagement.total_room_list.stream().filter(o -> o.getRoomNumber() == obj.getRoomNumber()).findAny().get();// getting currently room type
            System.out.println("The current room type is (" + currentRoom.getRumType() + ").");
            Rooms.RoomsTypeList.forEach((i,v) -> System.out.println(i +") " + v));
            int choice = ExeptionClass.checkValue(ExeptionClass.TryCatchInt(), 0, Rooms.RoomsTypeList.size());
            String roomTy = Rooms.RoomsTypeList.get(choice);
            if (RoomManagement.available_room_list.stream().filter(o -> o.getRumType().equals(roomTy)).count() > 0){
                RoomManagement.available_room_list.add(RoomManagement.total_room_list.get(RoomManagement.getIndexTotalList(roomNumber)));//add the old room to the available list
                obj.setRoomNumber(RoomManagement.available_room_list.stream().filter(o -> o.getRumType().equalsIgnoreCase(Rooms.RoomsTypeList.get(choice))).findAny().get().getRoomNumber());
                RoomManagement.available_room_list.remove(RoomManagement.indexOfCustomersRoomNumber(obj.getRoomNumber()));
                System.out.println("Room is Changed! The new room number is (" + obj.getRoomNumber() + ").");   
            }else{
                System.out.println("This room type is not availabel! Please choose another type!");
            }

    }

}
