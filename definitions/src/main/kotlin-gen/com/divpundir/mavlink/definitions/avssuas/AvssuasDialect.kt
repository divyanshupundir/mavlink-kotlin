package com.divpundir.mavlink.definitions.avssuas

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect
import com.divpundir.mavlink.definitions.common.CommonDialect

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
