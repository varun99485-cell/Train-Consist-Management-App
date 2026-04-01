import java.util.ArrayList;

public class TrainConsistManagemantApp {
    public static void main(String[] args) {


        ArrayList<String> passengerBogies = new ArrayList<>();


        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");


        System.out.println("Passenger Bogies after addition:");
        System.out.println(passengerBogies);


        passengerBogies.remove("AC Chair");


        System.out.println("\nAfter removing AC Chair:");
        System.out.println(passengerBogies);


        boolean exists = passengerBogies.contains("Sleeper");

        if (exists) {
            System.out.println("\nSleeper bogie exists in the train.");
        } else {
            System.out.println("\nSleeper bogie does not exist.");
        }


        System.out.println("\nFinal Passenger Bogies:");
        System.out.println(passengerBogies);
    }
}