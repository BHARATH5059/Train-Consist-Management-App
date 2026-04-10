import java.util.*;

class Room {
    private String type;
    private double price;

    public Room(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}

class RoomInventory {
    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single", 10);
        inventory.put("Double", 0);
        inventory.put("Suite", 3);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public Set<String> getRoomTypes() {
        return inventory.keySet();
    }
}

class SearchService {
    private RoomInventory inventory;
    private HashMap<String, Room> roomDetails;

    public SearchService(RoomInventory inventory) {
        this.inventory = inventory;
        roomDetails = new HashMap<>();
        roomDetails.put("Single", new Room("Single", 2000));
        roomDetails.put("Double", new Room("Double", 3500));
        roomDetails.put("Suite", new Room("Suite", 5000));
    }

    public void searchAvailableRooms() {
        System.out.println("Available Rooms:");
        for (String type : inventory.getRoomTypes()) {
            int available = inventory.getAvailability(type);
            if (available > 0) {
                Room room = roomDetails.get(type);
                System.out.println(type + " | Price: " + room.getPrice() + " | Available: " + available);
            }
        }
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("=== Book My Stay App ===");

        RoomInventory inventory = new RoomInventory();
        SearchService searchService = new SearchService(inventory);

        searchService.searchAvailableRooms();
    }
}