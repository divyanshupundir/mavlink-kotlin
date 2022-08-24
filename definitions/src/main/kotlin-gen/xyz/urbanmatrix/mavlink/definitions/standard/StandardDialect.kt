package xyz.urbanmatrix.mavlink.definitions.standard

import xyz.urbanmatrix.mavlink.api.AbstractMavDialect
import xyz.urbanmatrix.mavlink.api.GeneratedMavDialect
import xyz.urbanmatrix.mavlink.definitions.common.CommonDialect

@GeneratedMavDialect
public object StandardDialect : AbstractMavDialect(
  setOf(
    CommonDialect,
  ), 
  emptyMap())
