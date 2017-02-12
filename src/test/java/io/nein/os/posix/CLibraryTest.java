// This file is licensed under the EUPL v1.1 or later.
// Original Licensor: Stefan Paletta <stefanp at nein.io>, Berlin, Germany.

package io.nein.os.posix;

import org.junit.Test;

import static org.junit.Assert.*;

public class CLibraryTest
{
    @Test
    public void uname() throws Exception
    {
        try
            {
            final utsname uname = new utsname();
            final int ret = CLibrary.INSTANCE.uname( uname );
            assertEquals( 0, ret );
            System.out.println( uname );
            }
        catch ( UnsatisfiedLinkError ignored )
            {
            }
    }
}
