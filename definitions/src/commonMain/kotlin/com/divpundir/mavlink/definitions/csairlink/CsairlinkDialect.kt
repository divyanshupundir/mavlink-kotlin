package com.divpundir.mavlink.definitions.csairlink

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect

@GeneratedMavDialect
public data object CsairlinkDialect : AbstractMavDialect(
  emptySet(), 
  mapOf(
    AirlinkAuth.id to AirlinkAuth,
    AirlinkAuthResponse.id to AirlinkAuthResponse,
  )
)
