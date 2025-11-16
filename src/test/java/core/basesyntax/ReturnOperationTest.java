package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.ReturnOperation;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ReturnOperationTest {
    @Test
    void apply_purchase_ok() {
        ReturnOperation returnOperation = new ReturnOperation();
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("banana", 20);

        FruitTransaction tr = new FruitTransaction(
                FruitTransaction.Operation.RETURN, "banana", 5);

        returnOperation.apply(tr, inventory);

        assertEquals(25, inventory.get("banana"));
    }
}
