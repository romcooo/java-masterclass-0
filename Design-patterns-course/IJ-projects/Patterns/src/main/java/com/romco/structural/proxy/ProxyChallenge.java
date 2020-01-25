package com.romco.structural.proxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface IConnect {
    void connect(String host);
}

class RealConnection implements IConnect  {
    @Override
    public void connect(String host) {
        System.out.println("Connecting to the internet.");
    }
}

class ProxyConnection implements IConnect {
    public static final List<String> BANNED_HOSTS = new ArrayList<>(Arrays.asList("blacksite", "graysite", "bannedsite"));
    private RealConnection realConnection;

    @Override
    public void connect(String host) {
        if (realConnection == null) {
            realConnection = new RealConnection();
        }
        if (BANNED_HOSTS.contains(host)) {
            System.out.println("Trying to access banned site!");
        } else {
            realConnection.connect(host);
        }
    }
}

public class ProxyChallenge {
    public static void main(String[] args) {
        IConnect connection = new ProxyConnection();
        connection.connect("blacksite");
        connection.connect("udemy");
        connection.connect("gmail");
    }
}
