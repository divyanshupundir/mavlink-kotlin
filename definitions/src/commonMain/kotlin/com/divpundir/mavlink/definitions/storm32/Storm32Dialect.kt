package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect
import com.divpundir.mavlink.definitions.ardupilotmega.ArdupilotmegaDialect

@GeneratedMavDialect
public data object Storm32Dialect : AbstractMavDialect(
  setOf(
    ArdupilotmegaDialect,
  ), 
  mapOf(
    Storm32GimbalManagerInformation.id to Storm32GimbalManagerInformation,
    Storm32GimbalManagerStatus.id to Storm32GimbalManagerStatus,
    Storm32GimbalManagerControl.id to Storm32GimbalManagerControl,
    Storm32GimbalManagerControlPitchyaw.id to Storm32GimbalManagerControlPitchyaw,
    Storm32GimbalManagerCorrectRoll.id to Storm32GimbalManagerCorrectRoll,
    QshotStatus.id to QshotStatus,
    FrskyPassthroughArray.id to FrskyPassthroughArray,
    ParamValueArray.id to ParamValueArray,
  )
)
