import java.util.ArrayList;
import java.util.List;
public class HotelReservationSystem{
    private List<Room> rooms=new ArrayList<>();
    public void seedRooms(){
        rooms.add(new Room(101,"Standard",80.00));
        rooms.add(new Room(102,"Standard",80.00));
        rooms.add(new Room(201,"Deluxe",150.00));
        rooms.add(new Room(301,"Suite",300.00));
    }
    public void searchAvailableRooms(String category){
        System.out.println("\nAvailable"+category +"Rooms:");
        for(Room room:rooms){
            if(room.getCategory().equalsIgnoreCase(category)&&!room.isReserved()) 
                {
                   System.out.println("Room "+room.getRoomNumber()+"-$"+room.getPrice()+"/night");
            }
        }
    }
    public void makeReservation(int roomNumber){
        for(Room room:rooms){
            if(room.getRoomNumber()==roomNumber){
                if(!room.isReserved()){
                    room.setReserved(true);
                    System.out.println("Booking Confirmed for Room "+roomNumber+"!");
                    simulatePayment(room.getPrice());
                    return;
                } 
                else 
                {
                    System.out.println("Room is already occupied!");
                    return;
                }
            }
        }
        System.out.println("Invalid Room Number!");
    }

    private void simulatePayment(double amount){
        System.out.println("Processing simulated payment of $"+amount+"...");
        System.out.println("Payment Successful Transaction Token: TXN"+(int)(Math.random()*100000));
    }
}