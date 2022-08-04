package com.urbanmatrix.mavlink.definitions.standard

import com.urbanmatrix.mavlink.api.AbstractMavDialect
import com.urbanmatrix.mavlink.definitions.common.CommonDialect

public object StandardDialect : AbstractMavDialect(
  setOf(
    CommonDialect,
  ), 
  emptyMap())
