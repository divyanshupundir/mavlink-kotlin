package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Flags used in HIL_ACTUATOR_CONTROLS message.
 */
@GeneratedMavEnum(bitmask = true)
public enum class HilActuatorControlsFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Simulation is using lockstep
   */
  @GeneratedMavEnumEntry
  LOCKSTEP(1u),
  ;

  public companion object : MavBitmask.MavCompanion<HilActuatorControlsFlags> {
    override fun getEntryFromValueOrNull(v: UInt): HilActuatorControlsFlags? = when (v) {
      1u -> LOCKSTEP
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<HilActuatorControlsFlags> = buildList {
      if (v and 1u == 1u) add(LOCKSTEP)
    }
  }
}
