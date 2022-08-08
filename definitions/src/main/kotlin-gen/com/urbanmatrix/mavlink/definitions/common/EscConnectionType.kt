package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Indicates the ESC connection type.
 */
@GeneratedMavEnum
public enum class EscConnectionType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Traditional PPM ESC.
   */
  ESC_CONNECTION_TYPE_PPM(0L),
  /**
   * Serial Bus connected ESC.
   */
  ESC_CONNECTION_TYPE_SERIAL(1L),
  /**
   * One Shot PPM ESC.
   */
  ESC_CONNECTION_TYPE_ONESHOT(2L),
  /**
   * I2C ESC.
   */
  ESC_CONNECTION_TYPE_I2C(3L),
  /**
   * CAN-Bus ESC.
   */
  ESC_CONNECTION_TYPE_CAN(4L),
  /**
   * DShot ESC.
   */
  ESC_CONNECTION_TYPE_DSHOT(5L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): EscConnectionType? = when (v) {
      0L -> ESC_CONNECTION_TYPE_PPM
      1L -> ESC_CONNECTION_TYPE_SERIAL
      2L -> ESC_CONNECTION_TYPE_ONESHOT
      3L -> ESC_CONNECTION_TYPE_I2C
      4L -> ESC_CONNECTION_TYPE_CAN
      5L -> ESC_CONNECTION_TYPE_DSHOT
      else -> null
    }
  }
}
