// This file is licensed under the EUPL v1.1 or later.
// Original Licensor: Stefan Paletta <stefanp at nein.io>, Berlin, Germany.

package io.nein.os;

import com.sun.jna.Platform;
import io.nein.os.nt.Winsock2;
import io.nein.os.posix.CLibrary;
import io.nein.os.posix.utsname;

public class Hostname
{
    public static String get()
    {
        if ( Platform.isWindows() )
            {
            try
                {
                byte[] name = new byte[ 256 ];
                if ( Winsock2.INSTANCE.gethostname( name, name.length ) == 0 )
                    {
                    return new String( name, 0, strlen( name ) );
                    }
                }
            catch ( Throwable ignored )
                {
                return null;
                }
            }
        else
            {
            try
                {
                final utsname uname = new utsname();
                if ( CLibrary.INSTANCE.uname( uname ) == 0 )
                    {
                    return uname.getNodename();
                    }
                }
            catch ( Throwable ignored )
                {
                return null;
                }
            }
        return null;
    }

    public static int strlen( final byte[] data )
    {
        int len = 0;
        final int datalen = data.length;
        while ( len < datalen && data[ len ] != 0 )
            len++;
        return len;
    }
}
