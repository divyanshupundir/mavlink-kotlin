package com.divpundir.mavlink.definitions.cubepilot

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect
import com.divpundir.mavlink.definitions.common.CommonDialect

@GeneratedMavDialect
public data object CubepilotDialect : AbstractMavDialect(
  setOf(
    CommonDialect,
  ), 
  mapOf(
    CubepilotRawRc.id to CubepilotRawRc,
    HerelinkVideoStreamInformation.id to HerelinkVideoStreamInformation,
    HerelinkTelem.id to HerelinkTelem,
    CubepilotFirmwareUpdateStart.id to CubepilotFirmwareUpdateStart,
    CubepilotFirmwareUpdateResp.id to CubepilotFirmwareUpdateResp,
  )
)
