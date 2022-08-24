package xyz.urbanmatrix.mavlink.definitions.icarous

import xyz.urbanmatrix.mavlink.api.AbstractMavDialect
import xyz.urbanmatrix.mavlink.api.GeneratedMavDialect

@GeneratedMavDialect
public object IcarousDialect : AbstractMavDialect(
  emptySet(), 
  mapOf(
    IcarousHeartbeat.classMetadata.id to IcarousHeartbeat.classMetadata,
    IcarousKinematicBands.classMetadata.id to IcarousKinematicBands.classMetadata,
  )
)
