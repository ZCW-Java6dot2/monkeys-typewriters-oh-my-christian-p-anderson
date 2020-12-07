package io.zipcoder;

import java.util.concurrent.locks.*;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier {

    private Lock lock = new ReentrantLock(); // ReentrantLock() method allows you to call the lock method multiple times


    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    /**
     * https://howtodoinjava.com/java/multi-threading/how-to-use-locks-in-java-java-util-concurrent-locks-lock-tutorial-and-example/
     *
     * First a Lock is created as a private field. Then we call this.lock and it's lock() method. Now the Lock instance
     * is locked. Any other thread calling lock() will be blocked until the thread that locked the lock calls unlock().
     * Finally unlock() is called, and the Lock is now unlocked so other threads can lock it.
     */
    @Override
    public void run() {
        this.lock.lock();

        try {
            while(this.stringIterator.hasNext()) {
                this.copied += stringIterator.next() + " ";
            }
        } finally {
            this.lock.unlock();
        }
    }
    // https://www.youtube.com/watch?v=ahBC69_iyk4 explains why try and finally were used
}
