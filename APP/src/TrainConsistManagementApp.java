import java.util.*;
import java.util.stream.*;

class Bogie {
    String type;
    int capacity;

    Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String toString() {
        return type + " | Capacity: " + capacity;
    }
}

public class TrainConsistManagementApp {

    public static List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 50));
        bogies.add(new Bogie("Sleeper", 80));
        bogies.add(new Bogie("AC Chair", 70));

        int threshold = 70;

        List<Bogie> filtered = filterBogies(bogies, threshold);

        System.out.println("Filtered Bogies (Capacity > " + threshold + "):");

        for (Bogie b : filtered) {
            System.out.println(b);
        }
    }
}