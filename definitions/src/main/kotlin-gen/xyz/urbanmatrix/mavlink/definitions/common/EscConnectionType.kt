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
  PPM(0L),
  /**
   * Serial Bus connected ESC.
   */
  @GeneratedMavEnumEntry
  SERIAL(1L),
  /**
   * One Shot PPM ESC.
   */
  @GeneratedMavEnumEntry
  ONESHOT(2L),
  /**
   * I2C ESC.
   */
  @GeneratedMavEnumEntry
  I2C(3L),
  /**
   * CAN-Bus ESC.
   */
  @GeneratedMavEnumEntry
  CAN(4L),
  /**
   * DShot ESC.
   */
  @GeneratedMavEnumEntry
  DSHOT(5L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): EscConnectionType? = when (v) {
      0L -> PPM
      1L -> SERIAL
      2L -> ONESHOT
      3L -> I2C
      4L -> CAN
      5L -> DSHOT
      else -> null
    }
  }
}
