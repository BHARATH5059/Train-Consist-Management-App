import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 50)
        );

        int result = TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(182, result);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );

        int result = TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(210, result);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 75)
        );

        int result = TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(75, result);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int result = TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(0, result);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 50)
        );

        int result = TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(110, result);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 50),
                new Bogie("Sleeper", 80)
        );

        int result = TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(262, result);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));

        List<Bogie> originalCopy = new ArrayList<>(bogies);

        TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(originalCopy.size(), bogies.size());
        assertEquals(originalCopy.get(0).capacity, bogies.get(0).capacity);
    }
}