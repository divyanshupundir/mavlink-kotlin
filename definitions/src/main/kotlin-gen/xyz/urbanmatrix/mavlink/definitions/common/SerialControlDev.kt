package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * SERIAL_CONTROL device types
 */
@GeneratedMavEnum
public enum class SerialControlDev(
  public override val `value`: Long,
) : MavEnum {
  /**
   * First telemetry port
   */
  @GeneratedMavEnumEntry
  TELEM1(0L),
  /**
   * Second telemetry port
   */
  @GeneratedMavEnumEntry
  TELEM2(1L),
  /**
   * First GPS port
   */
  @GeneratedMavEnumEntry
  GPS1(2L),
  /**
   * Second GPS port
   */
  @GeneratedMavEnumEntry
  GPS2(3L),
  /**
   * system shell
   */
  @GeneratedMavEnumEntry
  SHELL(10L),
  /**
   * SERIAL0
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL0(100L),
  /**
   * SERIAL1
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL1(101L),
  /**
   * SERIAL2
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL2(102L),
  /**
   * SERIAL3
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL3(103L),
  /**
   * SERIAL4
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL4(104L),
  /**
   * SERIAL5
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL5(105L),
  /**
   * SERIAL6
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL6(106L),
  /**
   * SERIAL7
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL7(107L),
  /**
   * SERIAL8
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL8(108L),
  /**
   * SERIAL9
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_SERIAL9(109L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): SerialControlDev? = when (v) {
      0L -> TELEM1
      1L -> TELEM2
      2L -> GPS1
      3L -> GPS2
      10L -> SHELL
      100L -> SERIAL_CONTROL_SERIAL0
      101L -> SERIAL_CONTROL_SERIAL1
      102L -> SERIAL_CONTROL_SERIAL2
      103L -> SERIAL_CONTROL_SERIAL3
      104L -> SERIAL_CONTROL_SERIAL4
      105L -> SERIAL_CONTROL_SERIAL5
      106L -> SERIAL_CONTROL_SERIAL6
      107L -> SERIAL_CONTROL_SERIAL7
      108L -> SERIAL_CONTROL_SERIAL8
      109L -> SERIAL_CONTROL_SERIAL9
      else -> null
    }
  }
}
