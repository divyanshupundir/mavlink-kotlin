package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Bus types for device operations.
 */
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
