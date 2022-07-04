package com.urbanmatrix.mavlink.api

import java.lang.RuntimeException

class MavSerializationException(
    override val message: String?,
    override val cause: Throwable?
) : RuntimeException(
    message,
    cause
)
