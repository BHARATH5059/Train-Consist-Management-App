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

    public void displayQueue() {
        System.out.println("Booking Requests in Queue:");
        for (Reservation r : queue) {
            System.out.println(r.getGuestName() + " requested " + r.getRoomType());
        }
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("=== Book My Stay App ===");

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        bookingQueue.addRequest(new Reservation("Alice", "Single"));
        bookingQueue.addRequest(new Reservation("Bob", "Suite"));
        bookingQueue.addRequest(new Reservation("Charlie", "Double"));

        bookingQueue.displayQueue();
    }
}