package com.divpundir.mavlink.definitions.standard

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect
import com.divpundir.mavlink.definitions.minimal.MinimalDialect

@GeneratedMavDialect
public data object StandardDialect : AbstractMavDialect(
  setOf(
    MinimalDialect,
  ), 
  emptyMap())
