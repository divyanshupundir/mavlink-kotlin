package com.urbanmatrix.mavlink.adapters.rxjava2

import com.urbanmatrix.mavlink.api.MavFrame
import com.urbanmatrix.mavlink.api.MavMessage
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.annotations.CheckReturnValue
import java.lang.Exception

interface Rx2MavConnection {

    @Throws(Exception::class)
    fun blockingConnect()

    @Throws(Exception::class)
    fun blockingClose()

    @Throws(Exception::class)
    fun <T : MavMessage<T>> blockingSendV2(systemId: Int, componentId: Int, payload: T)

    @Throws(Exception::class)
    fun <T : MavMessage<T>> blockingSendV2(message: MavFrame<T>)

    @CheckReturnValue
    fun connect(): Completable

    @CheckReturnValue
    fun close(): Completable

    @CheckReturnValue
    fun <T : MavMessage<T>> sendV2(systemId: Int, componentId: Int, payload: T): Completable

    @CheckReturnValue
    fun <T : MavMessage<T>> sendV2(message: MavFrame<T>): Completable

    @get:CheckReturnValue
    val mavlinkFrame: Flowable<MavFrame<out MavMessage<*>>>

    val state: State

    enum class State {
        /** Object has been created. The MavLink connection is `null`.  */
        INITIALIZED,

        /** Attempting to connect. The MavLink connection is still `null`.  */
        CONNECTING,

        /** Connection is open. The Mavlink connection is not `null` and will stay the same.  */
        OPEN,

        /** Attempting to close the connection.  */
        CLOSING,

        /** Connection has been closed. The same connection cannot be reopened.  */
        CLOSED,

        /** Connection has faced an error. Procession is stopped and will not resume again.  */
        ERROR
    }
}