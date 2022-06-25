package com.urbanmatrix.mavlink.minimal

import com.urbanmatrix.mavlink.api.AbstractMavDialect

public object MinimalDialect : AbstractMavDialect(
  emptySet(), 
  mapOf(
    Heartbeat.classMetadata.id to Heartbeat.classMetadata,
    ProtocolVersion.classMetadata.id to ProtocolVersion.classMetadata,
  )
)
