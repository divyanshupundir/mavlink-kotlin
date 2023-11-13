package com.divpundir.mavlink.definitions.minimal

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect

@GeneratedMavDialect
public data object MinimalDialect : AbstractMavDialect(
  emptySet(), 
  mapOf(
    Heartbeat.id to Heartbeat,
    ProtocolVersion.id to ProtocolVersion,
  )
)
