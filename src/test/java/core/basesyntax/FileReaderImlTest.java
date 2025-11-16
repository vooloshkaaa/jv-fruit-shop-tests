package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.service.FileReader;
import core.basesyntax.service.impl.FileReaderImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FileReaderImlTest {
    @Test
    void read_validFile_ok() throws IOException {
        Path temp = Files.createTempFile("test", ".csv");
        Files.write(temp, List.of("a", "b", "c"));

        FileReader reader = new FileReaderImpl();
        List<String> result = reader.read(temp.toString());

        assertEquals(3, result.size());
    }

    @Test
    void read_missingFile_throws() {
        FileReader reader = new FileReaderImpl();
        assertThrows(RuntimeException.class,
                () -> reader.read("missing_file.csv"));
    }
}
