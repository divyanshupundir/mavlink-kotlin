package com.divpundir.mavlink.definitions.csairlink

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect

@GeneratedMavDialect
public data object CsairlinkDialect : AbstractMavDialect(
  emptySet(), 
  mapOf(
    AirlinkAuth.id to AirlinkAuth,
    AirlinkAuthResponse.id to AirlinkAuthResponse,
    AirlinkEyeGsHolePushRequest.id to AirlinkEyeGsHolePushRequest,
    AirlinkEyeGsHolePushResponse.id to AirlinkEyeGsHolePushResponse,
    AirlinkEyeHp.id to AirlinkEyeHp,
    AirlinkEyeTurnInit.id to AirlinkEyeTurnInit,
  )
)
