package fabs.util;

import java.io.IOException;

public abstract class AbstractCreator implements Runnable {
    @Override
    public void run() {
        try {
            this.create();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void create() throws IOException;
}
