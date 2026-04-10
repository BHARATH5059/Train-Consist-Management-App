import java.util.*;

class RoomInventory {
    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single", 10);
        inventory.put("Double", 5);
        inventory.put("Suite", 2);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public void displayInventory() {
        System.out.println("Current Room Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("=== Book My Stay App ===");

        RoomInventory inventory = new RoomInventory();

        inventory.displayInventory();

        inventory.updateAvailability("Single", 8);

        System.out.println("After Update:");
        inventory.displayInventory();

        System.out.println("Available Double Rooms: " + inventory.getAvailability("Double"));
    }
}