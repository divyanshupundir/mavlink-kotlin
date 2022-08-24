package xyz.urbanmatrix.mavlink.definitions.ualberta

import xyz.urbanmatrix.mavlink.api.AbstractMavDialect
import xyz.urbanmatrix.mavlink.api.GeneratedMavDialect
import xyz.urbanmatrix.mavlink.definitions.common.CommonDialect

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
