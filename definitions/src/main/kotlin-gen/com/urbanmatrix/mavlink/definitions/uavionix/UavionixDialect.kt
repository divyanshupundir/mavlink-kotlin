package com.urbanmatrix.mavlink.definitions.uavionix

import com.urbanmatrix.mavlink.api.AbstractMavDialect
import com.urbanmatrix.mavlink.api.GeneratedMavDialect
import com.urbanmatrix.mavlink.definitions.common.CommonDialect

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
