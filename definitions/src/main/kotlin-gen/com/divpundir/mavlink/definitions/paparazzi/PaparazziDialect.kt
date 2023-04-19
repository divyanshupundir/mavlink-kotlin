package com.divpundir.mavlink.definitions.paparazzi

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect
import com.divpundir.mavlink.definitions.common.CommonDialect

@GeneratedMavDialect
public object PaparazziDialect : AbstractMavDialect(
  setOf(
    CommonDialect,
  ), 
  mapOf(
    ScriptItem.classMetadata.id to ScriptItem.classMetadata,
    ScriptRequest.classMetadata.id to ScriptRequest.classMetadata,
    ScriptRequestList.classMetadata.id to ScriptRequestList.classMetadata,
    ScriptCount.classMetadata.id to ScriptCount.classMetadata,
    ScriptCurrent.classMetadata.id to ScriptCurrent.classMetadata,
  )
)
