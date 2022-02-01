package com.example.wilspayoneer.core;

import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseHttpConnectionTest {

    BaseHttpConnection baseHttpConnection = new BaseHttpConnection();

    @Test(expected = IllegalArgumentException.class)
    public void buildUrl_nullInputString() throws MalformedURLException {
        baseHttpConnection.buildUrl(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void baseGetConnection_nullInputUrl() throws IOException {
        baseHttpConnection.baseGetConnection(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void readStream_nullInputHttpConnection() throws IOException {
        baseHttpConnection.readStream(null);
    }
}