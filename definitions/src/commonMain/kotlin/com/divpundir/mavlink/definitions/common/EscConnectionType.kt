package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Indicates the ESC connection type.
 */
@GeneratedMavEnum
public enum class EscConnectionType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Traditional PPM ESC.
   */
  @GeneratedMavEnumEntry
  PPM(0u),
  /**
   * Serial Bus connected ESC.
   */
  @GeneratedMavEnumEntry
  SERIAL(1u),
  /**
   * One Shot PPM ESC.
   */
  @GeneratedMavEnumEntry
  ONESHOT(2u),
  /**
   * I2C ESC.
   */
  @GeneratedMavEnumEntry
  I2C(3u),
  /**
   * CAN-Bus ESC.
   */
  @GeneratedMavEnumEntry
  CAN(4u),
  /**
   * DShot ESC.
   */
  @GeneratedMavEnumEntry
  DSHOT(5u),
  ;

  public companion object : MavEnum.MavCompanion<EscConnectionType> {
    override fun getEntryFromValueOrNull(v: UInt): EscConnectionType? = when (v) {
      0u -> PPM
      1u -> SERIAL
      2u -> ONESHOT
      3u -> I2C
      4u -> CAN
      5u -> DSHOT
      else -> null
    }
  }
}
