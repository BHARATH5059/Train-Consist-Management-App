import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60)
        );

        List<Bogie> result = TrainConsistManagementApp.filterBogies(bogies, 70);

        assertEquals(1, result.size());
        assertTrue(result.get(0).capacity > 70);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("AC Chair", 70)
        );

        List<Bogie> result = TrainConsistManagementApp.filterBogies(bogies, 70);

        assertEquals(0, result.size());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("First Class", 50)
        );

        List<Bogie> result = TrainConsistManagementApp.filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 75),
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 60)
        );

        List<Bogie> result = TrainConsistManagementApp.filterBogies(bogies, 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 50)
        );

        List<Bogie> result = TrainConsistManagementApp.filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("Sleeper", 90)
        );

        List<Bogie> result = TrainConsistManagementApp.filterBogies(bogies, 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = TrainConsistManagementApp.filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));

        List<Bogie> originalCopy = new ArrayList<>(bogies);

        TrainConsistManagementApp.filterBogies(bogies, 70);

        assertEquals(originalCopy.size(), bogies.size());
        assertEquals(originalCopy.get(0).capacity, bogies.get(0).capacity);
    }
}