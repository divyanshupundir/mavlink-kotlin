package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

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
  @GeneratedMavEnumEntry
  ESC_CONNECTION_TYPE_PPM(0L),
  /**
   * Serial Bus connected ESC.
   */
  @GeneratedMavEnumEntry
  ESC_CONNECTION_TYPE_SERIAL(1L),
  /**
   * One Shot PPM ESC.
   */
  @GeneratedMavEnumEntry
  ESC_CONNECTION_TYPE_ONESHOT(2L),
  /**
   * I2C ESC.
   */
  @GeneratedMavEnumEntry
  ESC_CONNECTION_TYPE_I2C(3L),
  /**
   * CAN-Bus ESC.
   */
  @GeneratedMavEnumEntry
  ESC_CONNECTION_TYPE_CAN(4L),
  /**
   * DShot ESC.
   */
  @GeneratedMavEnumEntry
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
