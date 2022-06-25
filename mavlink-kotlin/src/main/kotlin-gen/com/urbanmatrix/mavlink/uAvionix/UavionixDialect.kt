package com.urbanmatrix.mavlink.uAvionix

import com.urbanmatrix.mavlink.api.AbstractMavDialect
import com.urbanmatrix.mavlink.common.CommonDialect

public object UavionixDialect : AbstractMavDialect(
  setOf(
    CommonDialect
  ), 
  mapOf(
    UavionixAdsbOutCfg.classMetadata.id to UavionixAdsbOutCfg.classMetadata,
    UavionixAdsbOutDynamic.classMetadata.id to UavionixAdsbOutDynamic.classMetadata,
    UavionixAdsbTransceiverHealthReport.classMetadata.id to
        UavionixAdsbTransceiverHealthReport.classMetadata,
  )
)
