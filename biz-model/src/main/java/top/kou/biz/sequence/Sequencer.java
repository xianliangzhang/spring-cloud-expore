package top.kou.biz.sequence;

import java.util.concurrent.atomic.AtomicInteger;

public final class Sequencer {
    private static final AtomicInteger sequence = new AtomicInteger(0);

    public static final int getNextSequence() {
        return sequence.incrementAndGet();
    }
}
