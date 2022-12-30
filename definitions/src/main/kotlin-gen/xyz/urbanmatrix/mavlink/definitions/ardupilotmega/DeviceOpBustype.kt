package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Bus types for device operations.
 */
@GeneratedMavEnum
public enum class DeviceOpBustype(
  public override val `value`: Long,
) : MavEnum {
  /**
   * I2C Device operation.
   */
  @GeneratedMavEnumEntry
  I2C(0L),
  /**
   * SPI Device operation.
   */
  @GeneratedMavEnumEntry
  SPI(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): DeviceOpBustype? = when (v) {
      0L -> I2C
      1L -> SPI
      else -> null
    }
  }
}
