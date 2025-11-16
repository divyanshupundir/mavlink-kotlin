package com.divpundir.mavlink.definitions.loweheiser

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect
import com.divpundir.mavlink.definitions.minimal.MinimalDialect

@GeneratedMavDialect
public data object LoweheiserDialect : AbstractMavDialect(
  setOf(
    MinimalDialect,
  ), 
  mapOf(
    LoweheiserGovEfi.id to LoweheiserGovEfi,
  )
)
