package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
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
  DEVICE_OP_BUSTYPE_I2C(0L),
  /**
   * SPI Device operation.
   */
  DEVICE_OP_BUSTYPE_SPI(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): DeviceOpBustype? = when (v) {
      0L -> DEVICE_OP_BUSTYPE_I2C
      1L -> DEVICE_OP_BUSTYPE_SPI
      else -> null
    }
  }
}
