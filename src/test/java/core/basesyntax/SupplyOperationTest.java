package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class SupplyOperationTest {
    @Test
    void apply_purchase_ok() {
        SupplyOperation supplyOperation = new SupplyOperation();
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("banana", 20);

        FruitTransaction tr = new FruitTransaction(
                FruitTransaction.Operation.SUPPLY, "banana", 5);

        supplyOperation.apply(tr, inventory);

        assertEquals(25, inventory.get("banana"));
    }
}
