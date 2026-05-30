import java.util.Scanner;
public class HotelApplication{
    public static void main(String[] args){
        HotelReservationSystem system=new HotelReservationSystem();
        system.seedRooms(); 
        Scanner scanner=new Scanner(System.in);
        boolean running=true;
        System.out.println("Welcome to the Grand Horizon Management Engine");
        while (running){
            System.out.println("\n--- MAIN CORE MENU ---");
            System.out.println("1.View Available Rooms by Category");
            System.out.println("2.Book a Room Suite");
            System.out.println("3.Exit System");
            System.out.print("Select operational vector:");
            String choice=scanner.nextLine().trim();
            switch (choice){
                case "1":
                    System.out.print("Enter tier category(Standard,Deluxe,Suite): ");
                    String tier=scanner.nextLine().trim();
                    system.searchAvailableRooms(tier);
                    break;
                case "2":
                    System.out.print("Enter target room number allocation: ");
                    try{
                        int roomNum=Integer.parseInt(scanner.nextLine().trim());
                        system.makeReservation(roomNum);
                    } catch (NumberFormatException e){
                        System.out.println("Room allocations must be valid integers.");
                    }
                    break;
                case "3":
                    running=false;
                    System.out.println("Terminating secure session connection. Goodbye.");
                    break;
                default:
                    System.out.println("Operation choice unmapped.Try again.");
            }
        }
        scanner.close();
    }
}