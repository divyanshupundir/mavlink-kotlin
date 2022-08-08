package com.urbanmatrix.mavlink.definitions.standard

import com.urbanmatrix.mavlink.api.AbstractMavDialect
import com.urbanmatrix.mavlink.api.GeneratedMavDialect
import com.urbanmatrix.mavlink.definitions.common.CommonDialect

@GeneratedMavDialect
public object StandardDialect : AbstractMavDialect(
  setOf(
    CommonDialect,
  ), 
  emptyMap())
