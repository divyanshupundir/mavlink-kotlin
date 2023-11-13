package com.divpundir.mavlink.definitions.ualberta

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect
import com.divpundir.mavlink.definitions.common.CommonDialect

@GeneratedMavDialect
public data object UalbertaDialect : AbstractMavDialect(
  setOf(
    CommonDialect,
  ), 
  mapOf(
    NavFilterBias.id to NavFilterBias,
    RadioCalibration.id to RadioCalibration,
    UalbertaSysStatus.id to UalbertaSysStatus,
  )
)
