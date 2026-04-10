import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testGroupBogiesByType_NormalCase() {
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
    void testGroupBogiesByType_EmptyList() {
        List<Bogie> bogies = new ArrayList<>();

        Map<String, List<Bogie>> result =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertTrue(result.isEmpty());
    }

    @Test
    void testGroupBogiesByType_AllDifferentTypes() {
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
    void testLinkedHashSet_NoDuplicates() {
        LinkedHashSet<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Sleeper"); // duplicate

        assertEquals(2, formation.size());
        assertTrue(formation.contains("Engine"));
        assertTrue(formation.contains("Sleeper"));
    }

    @Test
    void testLinkedHashSet_OrderMaintained() {
        LinkedHashSet<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");

        Iterator<String> it = formation.iterator();

        assertEquals("Engine", it.next());
        assertEquals("Sleeper", it.next());
        assertEquals("Cargo", it.next());
    }
}