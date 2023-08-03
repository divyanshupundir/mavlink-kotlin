package com.divpundir.mavlink.definitions.icarous

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect

@GeneratedMavDialect
public data object IcarousDialect : AbstractMavDialect(
  emptySet(), 
  mapOf(
    IcarousHeartbeat.id to IcarousHeartbeat,
    IcarousKinematicBands.id to IcarousKinematicBands,
  )
)
