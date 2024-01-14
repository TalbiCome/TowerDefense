package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;
public class Testing extends JFrame {
    @Test
    void addition() {
        assertEquals(2, 1+1);
    }

    @Test
    void window(){
        setSize(400,400);
        setVisible(true);
    }
}
