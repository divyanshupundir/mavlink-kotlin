package com.urbanmatrix.mavlink.definitions.minimal

import com.urbanmatrix.mavlink.api.AbstractMavDialect
import com.urbanmatrix.mavlink.api.GeneratedMavDialect

@GeneratedMavDialect
public object MinimalDialect : AbstractMavDialect(
  emptySet(), 
  mapOf(
    Heartbeat.classMetadata.id to Heartbeat.classMetadata,
    ProtocolVersion.classMetadata.id to ProtocolVersion.classMetadata,
  )
)
