package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Engine control options
 */
@GeneratedMavEnum(bitmask = true)
public enum class EngineControlOptions(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Allow starting the engine while disarmed (without changing the vehicle's armed state). This effectively arms just the ICE, without arming the vehicle to start other motors or propellers.
   */
  @GeneratedMavEnumEntry
  ALLOW_START_WHILE_DISARMED(1u),
  ;

  public companion object : MavBitmask.MavCompanion<EngineControlOptions> {
    override fun getEntryFromValueOrNull(v: UInt): EngineControlOptions? = when (v) {
      1u -> ALLOW_START_WHILE_DISARMED
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<EngineControlOptions> = buildList {
      if (v and 1u == 1u) add(ALLOW_START_WHILE_DISARMED)
    }
  }
}
