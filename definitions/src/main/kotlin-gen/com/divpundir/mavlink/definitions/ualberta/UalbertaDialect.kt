package com.divpundir.mavlink.definitions.ualberta

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect
import com.divpundir.mavlink.definitions.common.CommonDialect

@GeneratedMavDialect
public object UalbertaDialect : AbstractMavDialect(
  setOf(
    CommonDialect,
  ), 
  mapOf(
    NavFilterBias.classMetadata.id to NavFilterBias.classMetadata,
    RadioCalibration.classMetadata.id to RadioCalibration.classMetadata,
    UalbertaSysStatus.classMetadata.id to UalbertaSysStatus.classMetadata,
  )
)
