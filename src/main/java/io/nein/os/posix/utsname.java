/*
 * Copyright 2016 higherfrequencytrading.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.nein.os.posix;

import com.sun.jna.Structure;
import io.nein.os.Hostname;

import java.util.Arrays;
import java.util.List;

public class utsname extends Structure
{

    public static final int _UTSNAME_LENGTH = 65;

    static List<String> FIELD_ORDER = Arrays.asList(
            "sysname",
            "nodename",
            "release",
            "version",
            "machine",
            "domainname"
    );

    /**
     * Name of the implementation of the operating system.
     */
    public byte[] sysname = new byte[ _UTSNAME_LENGTH ];

    /**
     * Name of this node on the network.
     */
    public byte[] nodename = new byte[ _UTSNAME_LENGTH ];

    /**
     * Current release level of this implementation.
     */
    public byte[] release = new byte[ _UTSNAME_LENGTH ];

    /**
     * Current version level of this release.
     */
    public byte[] version = new byte[ _UTSNAME_LENGTH ];

    /**
     * Name of the hardware type the system is running on.
     */
    public byte[] machine = new byte[ _UTSNAME_LENGTH ];

    /**
     * NIS or YP domain name
     */
    public byte[] domainname = new byte[ _UTSNAME_LENGTH ];

    @Override
    protected List getFieldOrder()
    {
        return FIELD_ORDER;
    }

    public String getSysname()
    {
        return new String( sysname, 0, Hostname.strlen( sysname ) );
    }

    public String getNodename()
    {
        return new String( nodename, 0, Hostname.strlen( nodename ) );
    }

    public String getRelease()
    {
        return new String( release, 0, Hostname.strlen( release ) );
    }

    public String getReleaseVersion()
    {
        final String release = getRelease();
        final int releaseLen = release.length();
        int len = 0;
        for ( ; len < releaseLen ; len++ )
            {
            final char c = release.charAt( len );
            if ( Character.isDigit( c ) || c == '.' )
                {
                continue;
                }
            break;
            }
        return release.substring( 0, len );
    }

    public String getVersion()
    {
        return new String( version, 0, Hostname.strlen( version ) );
    }

    public String getMachine()
    {
        return new String( machine, 0, Hostname.strlen( machine ) );
    }

    public String getDomainname()
    {
        return new String( domainname, 0, Hostname.strlen( domainname ) );
    }

    @Override
    public String toString()
    {
        return getSysname() + " " + getNodename() + " " + getRelease() + " " +
                       getVersion() + " " + getMachine();
    }

}
