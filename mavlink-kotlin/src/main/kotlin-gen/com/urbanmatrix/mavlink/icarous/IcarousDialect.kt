package com.urbanmatrix.mavlink.icarous

import com.urbanmatrix.mavlink.api.AbstractMavDialect

public object IcarousDialect : AbstractMavDialect(
  emptySet(), 
  mapOf(
    IcarousHeartbeat.classMetadata.id to IcarousHeartbeat.classMetadata,
    IcarousKinematicBands.classMetadata.id to IcarousKinematicBands.classMetadata,
  )
)
