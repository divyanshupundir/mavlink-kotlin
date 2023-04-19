package com.divpundir.mavlink.definitions.minimal

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect

@GeneratedMavDialect
public object MinimalDialect : AbstractMavDialect(
  emptySet(), 
  mapOf(
    Heartbeat.classMetadata.id to Heartbeat.classMetadata,
    ProtocolVersion.classMetadata.id to ProtocolVersion.classMetadata,
  )
)
