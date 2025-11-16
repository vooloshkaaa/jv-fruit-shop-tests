package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.PurchaseOperation;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class PurchaseOperationTest {
    @Test
    void apply_purchase_ok() {
        PurchaseOperation purchaseOperation = new PurchaseOperation();
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("banana", 20);

        FruitTransaction tr = new FruitTransaction(
                FruitTransaction.Operation.PURCHASE, "banana", 5);

        purchaseOperation.apply(tr, inventory);

        assertEquals(15, inventory.get("banana"));
    }

    @Test
    void apply_notEnough_exception() {
        PurchaseOperation op = new PurchaseOperation();
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("banana", 2);

        FruitTransaction tr = new FruitTransaction(
                FruitTransaction.Operation.PURCHASE, "banana", 5);

        assertThrows(RuntimeException.class, () -> op.apply(tr, inventory));
    }
}
