package com.urbanmatrix.mavlink.ualberta

import com.urbanmatrix.mavlink.api.AbstractMavDialect
import com.urbanmatrix.mavlink.common.CommonDialect

public object UalbertaDialect : AbstractMavDialect(
  setOf(
    CommonDialect
  ), 
  mapOf(
    NavFilterBias.classMetadata.id to NavFilterBias.classMetadata,
    RadioCalibration.classMetadata.id to RadioCalibration.classMetadata,
    UalbertaSysStatus.classMetadata.id to UalbertaSysStatus.classMetadata,
  )
)
