package io.zipcoder;



/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }


    /**
     *
     * Since there is an iterator we can see if stringIterator hasNext(). If there is another word, we add it to
     * copied using .next() with a space.
     *
     */

    @Override
    public void run() {
        while(this.stringIterator.hasNext()) {
            this.copied += stringIterator.next() + " ";
        }
    }
}
