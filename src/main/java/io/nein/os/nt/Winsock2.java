// This file is licensed under the EUPL v1.1 or later.
// Original Licensor: Stefan Paletta <stefanp at nein.io>, Berlin, Germany.

package io.nein.os.nt;

import com.sun.jna.*;

public interface Winsock2 extends Library
{
    Winsock2 INSTANCE = (Winsock2)Native.loadLibrary( "ws2_32", Winsock2.class );

    int gethostname( byte[] name, int len );
}
