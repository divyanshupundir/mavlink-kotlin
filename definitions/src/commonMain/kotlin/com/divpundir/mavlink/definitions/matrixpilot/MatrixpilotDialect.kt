package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect
import com.divpundir.mavlink.definitions.common.CommonDialect

@GeneratedMavDialect
public data object MatrixpilotDialect : AbstractMavDialect(
  setOf(
    CommonDialect,
  ), 
  mapOf(
    FlexifunctionSet.id to FlexifunctionSet,
    FlexifunctionReadReq.id to FlexifunctionReadReq,
    FlexifunctionBufferFunction.id to FlexifunctionBufferFunction,
    FlexifunctionBufferFunctionAck.id to FlexifunctionBufferFunctionAck,
    FlexifunctionDirectory.id to FlexifunctionDirectory,
    FlexifunctionDirectoryAck.id to FlexifunctionDirectoryAck,
    FlexifunctionCommand.id to FlexifunctionCommand,
    FlexifunctionCommandAck.id to FlexifunctionCommandAck,
    SerialUdbExtraF2A.id to SerialUdbExtraF2A,
    SerialUdbExtraF2B.id to SerialUdbExtraF2B,
    SerialUdbExtraF4.id to SerialUdbExtraF4,
    SerialUdbExtraF5.id to SerialUdbExtraF5,
    SerialUdbExtraF6.id to SerialUdbExtraF6,
    SerialUdbExtraF7.id to SerialUdbExtraF7,
    SerialUdbExtraF8.id to SerialUdbExtraF8,
    SerialUdbExtraF13.id to SerialUdbExtraF13,
    SerialUdbExtraF14.id to SerialUdbExtraF14,
    SerialUdbExtraF15.id to SerialUdbExtraF15,
    SerialUdbExtraF16.id to SerialUdbExtraF16,
    Altitudes.id to Altitudes,
    Airspeeds.id to Airspeeds,
    SerialUdbExtraF17.id to SerialUdbExtraF17,
    SerialUdbExtraF18.id to SerialUdbExtraF18,
    SerialUdbExtraF19.id to SerialUdbExtraF19,
    SerialUdbExtraF20.id to SerialUdbExtraF20,
    SerialUdbExtraF21.id to SerialUdbExtraF21,
    SerialUdbExtraF22.id to SerialUdbExtraF22,
  )
)
