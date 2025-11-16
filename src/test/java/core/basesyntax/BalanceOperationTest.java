package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.BalanceOperation;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class BalanceOperationTest {
    @Test
    void apply_balance_ok() {
        BalanceOperation balanceOperation = new BalanceOperation();
        Map<String, Integer> inventory = new HashMap<>();
        FruitTransaction fruitTransaction = new FruitTransaction(FruitTransaction.Operation.BALANCE,
                "banana", 50);
        balanceOperation.apply(fruitTransaction, inventory);
        assertEquals(50, inventory.get("banana"));
    }
}
