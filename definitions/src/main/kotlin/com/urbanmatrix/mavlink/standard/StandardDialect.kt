package com.urbanmatrix.mavlink.standard

import com.urbanmatrix.mavlink.api.AbstractMavDialect
import com.urbanmatrix.mavlink.common.CommonDialect

public object StandardDialect : AbstractMavDialect(
  setOf(
    CommonDialect
  ), 
  emptyMap())
