package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertTrue;

import core.basesyntax.service.impl.ReportGeneratorImpl;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ReportGeneratorImplTest {
    @Test
    void getReport_ok() {
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("banana", 50);
        inventory.put("apple", 100);

        ReportGeneratorImpl generator = new ReportGeneratorImpl();
        String report = generator.getReport(inventory);

        assertTrue(report.contains("fruit,quantity"));
        assertTrue(report.contains("banana,50"));
        assertTrue(report.contains("apple,100"));
    }

}
