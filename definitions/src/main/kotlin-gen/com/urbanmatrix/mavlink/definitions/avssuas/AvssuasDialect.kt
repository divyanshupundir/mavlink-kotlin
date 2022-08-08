package com.urbanmatrix.mavlink.definitions.avssuas

import com.urbanmatrix.mavlink.api.AbstractMavDialect
import com.urbanmatrix.mavlink.api.GeneratedMavDialect
import com.urbanmatrix.mavlink.definitions.common.CommonDialect

@GeneratedMavDialect
public object AvssuasDialect : AbstractMavDialect(
  setOf(
    CommonDialect,
  ), 
  mapOf(
    AvssPrsSysStatus.classMetadata.id to AvssPrsSysStatus.classMetadata,
    AvssDronePosition.classMetadata.id to AvssDronePosition.classMetadata,
    AvssDroneImu.classMetadata.id to AvssDroneImu.classMetadata,
    AvssDroneOperationMode.classMetadata.id to AvssDroneOperationMode.classMetadata,
  )
)
