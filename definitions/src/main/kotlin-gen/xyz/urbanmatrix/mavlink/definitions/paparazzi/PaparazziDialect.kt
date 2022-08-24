package xyz.urbanmatrix.mavlink.definitions.paparazzi

import xyz.urbanmatrix.mavlink.api.AbstractMavDialect
import xyz.urbanmatrix.mavlink.api.GeneratedMavDialect
import xyz.urbanmatrix.mavlink.definitions.common.CommonDialect

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
