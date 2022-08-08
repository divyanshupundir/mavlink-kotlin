package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

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
  SERIAL_CONTROL_DEV_TELEM1(0L),
  /**
   * Second telemetry port
   */
  SERIAL_CONTROL_DEV_TELEM2(1L),
  /**
   * First GPS port
   */
  SERIAL_CONTROL_DEV_GPS1(2L),
  /**
   * Second GPS port
   */
  SERIAL_CONTROL_DEV_GPS2(3L),
  /**
   * system shell
   */
  SERIAL_CONTROL_DEV_SHELL(10L),
  /**
   * SERIAL0
   */
  SERIAL_CONTROL_SERIAL0(100L),
  /**
   * SERIAL1
   */
  SERIAL_CONTROL_SERIAL1(101L),
  /**
   * SERIAL2
   */
  SERIAL_CONTROL_SERIAL2(102L),
  /**
   * SERIAL3
   */
  SERIAL_CONTROL_SERIAL3(103L),
  /**
   * SERIAL4
   */
  SERIAL_CONTROL_SERIAL4(104L),
  /**
   * SERIAL5
   */
  SERIAL_CONTROL_SERIAL5(105L),
  /**
   * SERIAL6
   */
  SERIAL_CONTROL_SERIAL6(106L),
  /**
   * SERIAL7
   */
  SERIAL_CONTROL_SERIAL7(107L),
  /**
   * SERIAL8
   */
  SERIAL_CONTROL_SERIAL8(108L),
  /**
   * SERIAL9
   */
  SERIAL_CONTROL_SERIAL9(109L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): SerialControlDev? = when (v) {
      0L -> SERIAL_CONTROL_DEV_TELEM1
      1L -> SERIAL_CONTROL_DEV_TELEM2
      2L -> SERIAL_CONTROL_DEV_GPS1
      3L -> SERIAL_CONTROL_DEV_GPS2
      10L -> SERIAL_CONTROL_DEV_SHELL
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
