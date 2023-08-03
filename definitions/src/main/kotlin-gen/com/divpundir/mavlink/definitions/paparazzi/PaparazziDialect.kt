package com.divpundir.mavlink.definitions.paparazzi

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect
import com.divpundir.mavlink.definitions.common.CommonDialect

@GeneratedMavDialect
public data object PaparazziDialect : AbstractMavDialect(
  setOf(
    CommonDialect,
  ), 
  mapOf(
    ScriptItem.id to ScriptItem,
    ScriptRequest.id to ScriptRequest,
    ScriptRequestList.id to ScriptRequestList,
    ScriptCount.id to ScriptCount,
    ScriptCurrent.id to ScriptCurrent,
  )
)
