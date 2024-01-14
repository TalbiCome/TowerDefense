package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class Testing {
    @Test
    @DisplayName("addition test")
    void addition() {
        assertEquals(2, 1+1);
    }
}
