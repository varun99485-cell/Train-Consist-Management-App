import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTestCase {


    @Test
    void testFilterSimple() {
        List<TrainConsistManagementApp.Bogie> list = Arrays.asList(
                new TrainConsistManagementApp.Bogie("A", 80),
                new TrainConsistManagementApp.Bogie("B", 60)
        );

        List<TrainConsistManagementApp.Bogie> result =
                list.stream().filter(b -> b.getCapacity() > 70).toList();

        assertEquals(1, result.size());
    }


    @Test
    void testGroupingSimple() {
        List<TrainConsistManagementApp.Bogie> list = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("Sleeper", 80)
        );

        Map<String, List<TrainConsistManagementApp.Bogie>> result =
                list.stream().collect(Collectors.groupingBy(b -> b.getName()));

        assertTrue(result.containsKey("Sleeper"));
    }


    @Test
    void testReduceSimple() {
        List<TrainConsistManagementApp.Bogie> list = Arrays.asList(
                new TrainConsistManagementApp.Bogie("A", 50),
                new TrainConsistManagementApp.Bogie("B", 60)
        );

        int total = list.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        assertEquals(110, total);
    }
}
