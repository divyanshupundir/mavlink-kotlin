package com.divpundir.mavlink.definitions.icarous

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect

@GeneratedMavDialect
public object IcarousDialect : AbstractMavDialect(
  emptySet(), 
  mapOf(
    IcarousHeartbeat.classMetadata.id to IcarousHeartbeat.classMetadata,
    IcarousKinematicBands.classMetadata.id to IcarousKinematicBands.classMetadata,
  )
)
