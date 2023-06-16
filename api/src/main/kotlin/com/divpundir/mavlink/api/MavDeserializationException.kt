package com.divpundir.mavlink.api

import okio.IOException

public class MavDeserializationException(
    override val message: String? = null,
    override val cause: Throwable? = null,
) : IOException(message, cause)
