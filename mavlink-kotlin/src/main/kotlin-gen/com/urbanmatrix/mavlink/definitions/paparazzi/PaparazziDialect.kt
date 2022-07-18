package com.urbanmatrix.mavlink.definitions.paparazzi

import com.urbanmatrix.mavlink.api.AbstractMavDialect
import com.urbanmatrix.mavlink.definitions.common.CommonDialect

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
