package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Power supply status flags (bitmask)
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavPowerStatus(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * main brick power supply valid
   */
  @GeneratedMavEnumEntry
  BRICK_VALID(1u),
  /**
   * main servo power supply valid for FMU
   */
  @GeneratedMavEnumEntry
  SERVO_VALID(2u),
  /**
   * USB power is connected
   */
  @GeneratedMavEnumEntry
  USB_CONNECTED(4u),
  /**
   * peripheral supply is in over-current state
   */
  @GeneratedMavEnumEntry
  PERIPH_OVERCURRENT(8u),
  /**
   * hi-power peripheral supply is in over-current state
   */
  @GeneratedMavEnumEntry
  PERIPH_HIPOWER_OVERCURRENT(16u),
  /**
   * Power status has changed since boot
   */
  @GeneratedMavEnumEntry
  CHANGED(32u),
  ;

  public companion object : MavBitmask.MavCompanion<MavPowerStatus> {
    override fun getEntryFromValueOrNull(v: UInt): MavPowerStatus? = when (v) {
      1u -> BRICK_VALID
      2u -> SERVO_VALID
      4u -> USB_CONNECTED
      8u -> PERIPH_OVERCURRENT
      16u -> PERIPH_HIPOWER_OVERCURRENT
      32u -> CHANGED
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<MavPowerStatus> = buildList {
      if (v and 1u == 1u) add(BRICK_VALID)
      if (v and 2u == 2u) add(SERVO_VALID)
      if (v and 4u == 4u) add(USB_CONNECTED)
      if (v and 8u == 8u) add(PERIPH_OVERCURRENT)
      if (v and 16u == 16u) add(PERIPH_HIPOWER_OVERCURRENT)
      if (v and 32u == 32u) add(CHANGED)
    }
  }
}
