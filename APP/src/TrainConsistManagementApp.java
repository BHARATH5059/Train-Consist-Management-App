import java.util.*;

class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

class BookingRequestQueue {
    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    public void addRequest(Reservation reservation) {
        queue.add(reservation);
    }

    public Reservation getNextRequest() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

class RoomInventory {
    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single", 2);
        inventory.put("Double", 1);
        inventory.put("Suite", 1);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public void decrement(String type) {
        inventory.put(type, inventory.get(type) - 1);
    }
}

class BookingService {
    private RoomInventory inventory;
    private HashMap<String, Set<String>> allocatedRooms;
    private Set<String> allRoomIds;
    private int counter;

    public BookingService(RoomInventory inventory) {
        this.inventory = inventory;
        allocatedRooms = new HashMap<>();
        allRoomIds = new HashSet<>();
        counter = 1;
    }

    public void processRequest(Reservation reservation) {
        String type = reservation.getRoomType();

        if (inventory.getAvailability(type) > 0) {
            String roomId;
            do {
                roomId = type.substring(0, 1).toUpperCase() + counter++;
            } while (allRoomIds.contains(roomId));

            allRoomIds.add(roomId);

            allocatedRooms.putIfAbsent(type, new HashSet<>());
            allocatedRooms.get(type).add(roomId);

            inventory.decrement(type);

            System.out.println("Booking Confirmed for " + reservation.getGuestName() + " | Room ID: " + roomId);
        } else {
            System.out.println("Booking Failed for " + reservation.getGuestName() + " | No rooms available");
        }
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("=== Book My Stay App ===");

        BookingRequestQueue queue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        BookingService service = new BookingService(inventory);

        queue.addRequest(new Reservation("Alice", "Single"));
        queue.addRequest(new Reservation("Bob", "Single"));
        queue.addRequest(new Reservation("Charlie", "Single"));
        queue.addRequest(new Reservation("David", "Suite"));

        while (!queue.isEmpty()) {
            Reservation r = queue.getNextRequest();
            service.processRequest(r);
        }
    }
}