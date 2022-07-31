package com.urbanmatrix.mavlink.adapters.rxjava2

import com.urbanmatrix.mavlink.connection.MavConnection

fun MavConnection.asRx2(): Rx2MavConnection = Rx2MavConnectionImpl(this)
