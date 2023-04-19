package com.divpundir.mavlink.definitions.standard

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect
import com.divpundir.mavlink.definitions.common.CommonDialect

@GeneratedMavDialect
public object StandardDialect : AbstractMavDialect(
  setOf(
    CommonDialect,
  ), 
  emptyMap())
