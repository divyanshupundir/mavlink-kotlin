package com.urbanmatrix.mavlink.AVSSUAS

import com.urbanmatrix.mavlink.api.AbstractMavDialect
import com.urbanmatrix.mavlink.common.CommonDialect

public object AvssuasDialect : AbstractMavDialect(
  setOf(
    CommonDialect
  ), 
  mapOf(
    AvssPrsSysStatus.classMetadata.id to AvssPrsSysStatus.classMetadata,
    AvssDronePosition.classMetadata.id to AvssDronePosition.classMetadata,
    AvssDroneImu.classMetadata.id to AvssDroneImu.classMetadata,
    AvssDroneOperationMode.classMetadata.id to AvssDroneOperationMode.classMetadata,
  )
)
