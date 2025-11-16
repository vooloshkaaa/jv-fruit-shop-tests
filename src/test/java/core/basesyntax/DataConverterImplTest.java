package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.impl.DataConverterImpl;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataConverterImplTest {
    private final DataConverter converter = new DataConverterImpl();

    @Test
    void convert_validData_ok() {
        List<String> data = Arrays.asList("type,fruit,quantity", "b,banana,20", "p,apple,5");
        List<FruitTransaction> result = converter.convertToTransaction(data);
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(FruitTransaction.Operation.BALANCE, result.get(0).getOperation());
        Assertions.assertEquals("banana", result.get(0).getFruit());
        Assertions.assertEquals(20, result.get(0).getQuantity());
    }

    @Test
    void convert_invalidColumns_exception() {
        List<String> data = Arrays.asList("type,fruit,quantity", "b,banana");
        Assertions.assertThrows(RuntimeException.class, () -> converter.convertToTransaction(data));
    }

    @Test
    void convert_unknownOperation_exception() {
        List<String> data = Arrays.asList("type,fruit,quantity", "x,banana,20");
        Assertions.assertThrows(RuntimeException.class, () -> converter.convertToTransaction(data));
    }
}
