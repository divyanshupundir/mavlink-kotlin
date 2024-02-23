package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * SERIAL_CONTROL device types
 */
@GeneratedMavEnum
public enum class SerialControlDev(
  override val `value`: UInt,
) : MavEnum {
  /**
   * First telemetry port
   */
  @GeneratedMavEnumEntry
  TELEM1(0u),
  /**
   * Second telemetry port
   */
  @GeneratedMavEnumEntry
  TELEM2(1u),
  /**
   * First GPS port
   */
  @GeneratedMavEnumEntry
  GPS1(2u),
  /**
   * Second GPS port
   */
  @GeneratedMavEnumEntry
  GPS2(3u),
  /**
   * system shell
   */
  @GeneratedMavEnumEntry
  SHELL(10u),
  /**
   * SERIAL0
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL0(100u),
  /**
   * SERIAL1
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL1(101u),
  /**
   * SERIAL2
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL2(102u),
  /**
   * SERIAL3
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL3(103u),
  /**
   * SERIAL4
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL4(104u),
  /**
   * SERIAL5
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL5(105u),
  /**
   * SERIAL6
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL6(106u),
  /**
   * SERIAL7
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL7(107u),
  /**
   * SERIAL8
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL8(108u),
  /**
   * SERIAL9
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL9(109u),
  ;

  public companion object : MavEnum.MavCompanion<SerialControlDev> {
    override fun getEntryFromValueOrNull(v: UInt): SerialControlDev? = when (v) {
      0u -> TELEM1
      1u -> TELEM2
      2u -> GPS1
      3u -> GPS2
      10u -> SHELL
      100u -> SERIAL_CONTROL_SERIAL0
      101u -> SERIAL_CONTROL_SERIAL1
      102u -> SERIAL_CONTROL_SERIAL2
      103u -> SERIAL_CONTROL_SERIAL3
      104u -> SERIAL_CONTROL_SERIAL4
      105u -> SERIAL_CONTROL_SERIAL5
      106u -> SERIAL_CONTROL_SERIAL6
      107u -> SERIAL_CONTROL_SERIAL7
      108u -> SERIAL_CONTROL_SERIAL8
      109u -> SERIAL_CONTROL_SERIAL9
      else -> null
    }
  }
}
