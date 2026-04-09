import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTestCase {

    // helper method
    private int totalCapacity(List<TrainConsistManagementApp.Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 56)
        );

        int result = totalCapacity(bogies);

        assertEquals(128, result);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("A", 50),
                new TrainConsistManagementApp.Bogie("B", 60),
                new TrainConsistManagementApp.Bogie("C", 70)
        );

        int result = totalCapacity(bogies);

        assertEquals(180, result);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72)
        );

        int result = totalCapacity(bogies);

        assertEquals(72, result);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        int result = totalCapacity(bogies);

        assertEquals(0, result);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("A", 30),
                new TrainConsistManagementApp.Bogie("B", 40)
        );

        int result = totalCapacity(bogies);

        assertEquals(70, result);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("A", 10),
                new TrainConsistManagementApp.Bogie("B", 20),
                new TrainConsistManagementApp.Bogie("C", 30)
        );

        int result = totalCapacity(bogies);

        assertEquals(60, result);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("A", 50));
        bogies.add(new TrainConsistManagementApp.Bogie("B", 60));

        int originalSize = bogies.size();

        int result = totalCapacity(bogies);

        assertEquals(originalSize, bogies.size());
    }
}