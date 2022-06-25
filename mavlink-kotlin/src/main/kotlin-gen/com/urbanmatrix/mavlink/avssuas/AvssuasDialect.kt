package com.urbanmatrix.mavlink.avssuas

import com.urbanmatrix.mavlink.AVSSUAS.AvssDroneImu
import com.urbanmatrix.mavlink.AVSSUAS.AvssDroneOperationMode
import com.urbanmatrix.mavlink.AVSSUAS.AvssDronePosition
import com.urbanmatrix.mavlink.AVSSUAS.AvssPrsSysStatus
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
