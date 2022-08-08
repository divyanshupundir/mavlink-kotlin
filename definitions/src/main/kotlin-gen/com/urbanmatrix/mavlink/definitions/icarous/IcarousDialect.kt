package com.urbanmatrix.mavlink.definitions.icarous

import com.urbanmatrix.mavlink.api.AbstractMavDialect
import com.urbanmatrix.mavlink.api.GeneratedMavDialect

@GeneratedMavDialect
public object IcarousDialect : AbstractMavDialect(
  emptySet(), 
  mapOf(
    IcarousHeartbeat.classMetadata.id to IcarousHeartbeat.classMetadata,
    IcarousKinematicBands.classMetadata.id to IcarousKinematicBands.classMetadata,
  )
)
