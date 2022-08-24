package xyz.urbanmatrix.mavlink.definitions.minimal

import xyz.urbanmatrix.mavlink.api.AbstractMavDialect
import xyz.urbanmatrix.mavlink.api.GeneratedMavDialect

@GeneratedMavDialect
public object MinimalDialect : AbstractMavDialect(
  emptySet(), 
  mapOf(
    Heartbeat.classMetadata.id to Heartbeat.classMetadata,
    ProtocolVersion.classMetadata.id to ProtocolVersion.classMetadata,
  )
)
