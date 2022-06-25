package com.urbanmatrix.mavlink.uavionix

import com.urbanmatrix.mavlink.api.AbstractMavDialect
import com.urbanmatrix.mavlink.common.CommonDialect
import com.urbanmatrix.mavlink.uAvionix.UavionixAdsbOutCfg
import com.urbanmatrix.mavlink.uAvionix.UavionixAdsbOutDynamic
import com.urbanmatrix.mavlink.uAvionix.UavionixAdsbTransceiverHealthReport

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
