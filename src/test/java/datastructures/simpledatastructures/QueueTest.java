package datastructures.simpledatastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTest {
    private final Queue<Integer> queue = new Queue<>();

    @BeforeEach
    public void setup() {
        for (int i = 0; i < 10; i++) {
            this.queue.enqueue(i);
        }
    }


    @Test
    public void someNotVeryTestyPrintTest() {
        this.queue.print();
    }
}
