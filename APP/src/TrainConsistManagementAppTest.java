import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 60)
        );

        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_EmptyList() {
        List<Bogie> bogies = new ArrayList<>();

        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_DifferentTypes() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 50)
        );

        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(3, result.size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));

        List<Bogie> copy = new ArrayList<>(bogies);

        TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(copy.size(), bogies.size());
        assertEquals(copy.get(0).capacity, bogies.get(0).capacity);
    }

    @Test
    void testHashMap_DataStoredCorrectly() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Sleeper", 72);
        map.put("AC Chair", 56);

        assertEquals(72, map.get("Sleeper"));
        assertEquals(56, map.get("AC Chair"));
    }

    @Test
    void testLinkedHashSet_NoDuplicates() {
        LinkedHashSet<String> set = new LinkedHashSet<>();

        set.add("Engine");
        set.add("Sleeper");
        set.add("Sleeper"); // duplicate

        assertEquals(2, set.size());
    }
}
