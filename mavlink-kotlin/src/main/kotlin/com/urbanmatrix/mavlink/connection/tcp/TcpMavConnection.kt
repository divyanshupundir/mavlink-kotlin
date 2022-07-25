package com.urbanmatrix.mavlink.connection.tcp

import com.urbanmatrix.mavlink.connection.MavConnection
import java.io.IOException

interface TcpMavConnection : MavConnection {

    @Throws(IOException::class)
    fun connect()
}
