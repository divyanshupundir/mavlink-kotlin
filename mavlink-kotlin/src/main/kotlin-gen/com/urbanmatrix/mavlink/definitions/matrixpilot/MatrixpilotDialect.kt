package com.urbanmatrix.mavlink.definitions.matrixpilot

import com.urbanmatrix.mavlink.api.AbstractMavDialect
import com.urbanmatrix.mavlink.definitions.common.CommonDialect

public object MatrixpilotDialect : AbstractMavDialect(
  setOf(
    CommonDialect,
  ), 
  mapOf(
    FlexifunctionSet.classMetadata.id to FlexifunctionSet.classMetadata,
    FlexifunctionReadReq.classMetadata.id to FlexifunctionReadReq.classMetadata,
    FlexifunctionBufferFunction.classMetadata.id to FlexifunctionBufferFunction.classMetadata,
    FlexifunctionBufferFunctionAck.classMetadata.id to FlexifunctionBufferFunctionAck.classMetadata,
    FlexifunctionDirectory.classMetadata.id to FlexifunctionDirectory.classMetadata,
    FlexifunctionDirectoryAck.classMetadata.id to FlexifunctionDirectoryAck.classMetadata,
    FlexifunctionCommand.classMetadata.id to FlexifunctionCommand.classMetadata,
    FlexifunctionCommandAck.classMetadata.id to FlexifunctionCommandAck.classMetadata,
    SerialUdbExtraF2A.classMetadata.id to SerialUdbExtraF2A.classMetadata,
    SerialUdbExtraF2B.classMetadata.id to SerialUdbExtraF2B.classMetadata,
    SerialUdbExtraF4.classMetadata.id to SerialUdbExtraF4.classMetadata,
    SerialUdbExtraF5.classMetadata.id to SerialUdbExtraF5.classMetadata,
    SerialUdbExtraF6.classMetadata.id to SerialUdbExtraF6.classMetadata,
    SerialUdbExtraF7.classMetadata.id to SerialUdbExtraF7.classMetadata,
    SerialUdbExtraF8.classMetadata.id to SerialUdbExtraF8.classMetadata,
    SerialUdbExtraF13.classMetadata.id to SerialUdbExtraF13.classMetadata,
    SerialUdbExtraF14.classMetadata.id to SerialUdbExtraF14.classMetadata,
    SerialUdbExtraF15.classMetadata.id to SerialUdbExtraF15.classMetadata,
    SerialUdbExtraF16.classMetadata.id to SerialUdbExtraF16.classMetadata,
    Altitudes.classMetadata.id to Altitudes.classMetadata,
    Airspeeds.classMetadata.id to Airspeeds.classMetadata,
    SerialUdbExtraF17.classMetadata.id to SerialUdbExtraF17.classMetadata,
    SerialUdbExtraF18.classMetadata.id to SerialUdbExtraF18.classMetadata,
    SerialUdbExtraF19.classMetadata.id to SerialUdbExtraF19.classMetadata,
    SerialUdbExtraF20.classMetadata.id to SerialUdbExtraF20.classMetadata,
    SerialUdbExtraF21.classMetadata.id to SerialUdbExtraF21.classMetadata,
    SerialUdbExtraF22.classMetadata.id to SerialUdbExtraF22.classMetadata,
  )
)
