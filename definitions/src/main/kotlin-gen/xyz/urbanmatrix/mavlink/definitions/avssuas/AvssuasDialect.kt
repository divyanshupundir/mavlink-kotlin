package xyz.urbanmatrix.mavlink.definitions.avssuas

import xyz.urbanmatrix.mavlink.api.AbstractMavDialect
import xyz.urbanmatrix.mavlink.api.GeneratedMavDialect
import xyz.urbanmatrix.mavlink.definitions.common.CommonDialect

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
