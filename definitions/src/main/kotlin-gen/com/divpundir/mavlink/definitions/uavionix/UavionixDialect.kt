package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect
import com.divpundir.mavlink.definitions.common.CommonDialect

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
