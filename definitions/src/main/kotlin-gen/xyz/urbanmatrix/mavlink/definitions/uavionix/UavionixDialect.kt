package xyz.urbanmatrix.mavlink.definitions.uavionix

import xyz.urbanmatrix.mavlink.api.AbstractMavDialect
import xyz.urbanmatrix.mavlink.api.GeneratedMavDialect
import xyz.urbanmatrix.mavlink.definitions.common.CommonDialect

@GeneratedMavDialect
public object UavionixDialect : AbstractMavDialect(
  setOf(
    CommonDialect,
  ), 
  mapOf(
    UavionixAdsbOutCfg.classMetadata.id to UavionixAdsbOutCfg.classMetadata,
    UavionixAdsbOutDynamic.classMetadata.id to UavionixAdsbOutDynamic.classMetadata,
    UavionixAdsbTransceiverHealthReport.classMetadata.id to
        UavionixAdsbTransceiverHealthReport.classMetadata,
  )
)
