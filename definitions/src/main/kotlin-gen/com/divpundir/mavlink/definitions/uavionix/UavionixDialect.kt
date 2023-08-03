package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect
import com.divpundir.mavlink.definitions.common.CommonDialect

@GeneratedMavDialect
public data object UavionixDialect : AbstractMavDialect(
  setOf(
    CommonDialect,
  ), 
  mapOf(
    UavionixAdsbOutCfg.id to UavionixAdsbOutCfg,
    UavionixAdsbOutDynamic.id to UavionixAdsbOutDynamic,
    UavionixAdsbTransceiverHealthReport.id to UavionixAdsbTransceiverHealthReport,
  )
)
