package com.etisalat.etisalatsaastest;

class TestUtil {

    static String createURLWithPort(String uri, int port) {
        return "http://localhost:" + port + uri;
    }
}
