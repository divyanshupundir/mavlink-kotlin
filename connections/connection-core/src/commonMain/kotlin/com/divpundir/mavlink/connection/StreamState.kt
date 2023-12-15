package com.divpundir.mavlink.connection

/**
 * Represents the state of a [MavConnection] stream.
 */
public sealed interface StreamState {

    /**
     * Represents the active state of the [MavConnection] stream.
     *
     * The connection is in the opened state and data is being read.
     */
    public data object Active : StreamState

    /**
     * Represents the inactive state of the [MavConnection] stream.
     */
    public sealed interface Inactive : StreamState {

        /**
         * The connection is in the closed state. Either it was not opened or was closed safely by the user.
         */
        public data object Stopped : Inactive

        /**
         * The connection failed after it was opened.
         */
        public data class Failed(val cause: Throwable) : Inactive
    }
}
