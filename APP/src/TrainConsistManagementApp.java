import java.util.*;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("Passenger Bogies: " + passengerBogies);

        passengerBogies.remove("AC Chair");

        System.out.println("After Removal: " + passengerBogies);

        System.out.println("Sleeper Exists: " + passengerBogies.contains("Sleeper"));

        System.out.println("Final Bogie List: " + passengerBogies);
    }
}