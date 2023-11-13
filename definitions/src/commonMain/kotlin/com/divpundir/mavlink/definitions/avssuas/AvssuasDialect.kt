package com.divpundir.mavlink.definitions.avssuas

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect
import com.divpundir.mavlink.definitions.common.CommonDialect

@GeneratedMavDialect
public data object AvssuasDialect : AbstractMavDialect(
  setOf(
    CommonDialect,
  ), 
  mapOf(
    AvssPrsSysStatus.id to AvssPrsSysStatus,
    AvssDronePosition.id to AvssDronePosition,
    AvssDroneImu.id to AvssDroneImu,
    AvssDroneOperationMode.id to AvssDroneOperationMode,
  )
)
