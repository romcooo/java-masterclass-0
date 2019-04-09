package com.roman.chapter11.packages;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public class MyWindow extends Frame {

        public MyWindow(String title) {
            super(title);
            setSize(500,140);
            addWindowListener(new WindowAdapter() {
                /**
                 * Invoked when a window has been closed.
                 * @param e
                 */
                @Override
                public void windowClosed(final WindowEvent e) {
                    System.exit(0);
                }
            });
        }



    }

}
