package com.urbanmatrix.mavlink.definitions.ualberta

import com.urbanmatrix.mavlink.api.AbstractMavDialect
import com.urbanmatrix.mavlink.api.GeneratedMavDialect
import com.urbanmatrix.mavlink.definitions.common.CommonDialect

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
