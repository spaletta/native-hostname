// This file is licensed under the EUPL v1.1 or later.
// Original Licensor: Stefan Paletta <stefanp at nein.io>, Berlin, Germany.

package io.nein.os;

import org.junit.Test;

import static org.junit.Assert.*;

public class HostnameTest
{
    @Test
    public void hostname() throws Exception
    {
        final String hostname = Hostname.get();
        assertNotNull( "hostname must not be null", hostname );
        assertNotEquals( "hostname must not be empty", "", hostname );
        System.out.println( hostname );
    }
}
