package com.romco;

class DaemonThread extends Thread {
    public DaemonThread() {
        super();
        super.setDaemon(true);
    }
    
    public DaemonThread(Runnable target) {
        super(target);
        super.setDaemon(true);
    }
    
    
}