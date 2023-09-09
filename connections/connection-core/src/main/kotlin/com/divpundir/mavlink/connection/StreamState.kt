package com.divpundir.mavlink.connection

public sealed interface StreamState {

    public data object Active : StreamState

    public sealed interface Inactive : StreamState {

        public data object Stopped : Inactive

        public data class Failed(val cause: Throwable) : Inactive
    }
}
