package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Bus types for device operations.
 */
@GeneratedMavEnum
public enum class DeviceOpBustype(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * I2C Device operation.
   */
  @GeneratedMavEnumEntry
  I2C(0u),
  /**
   * SPI Device operation.
   */
  @GeneratedMavEnumEntry
  SPI(1u),
  ;

  public companion object : MavEnum.MavCompanion<DeviceOpBustype> {
    public override fun getEntryFromValueOrNull(v: UInt): DeviceOpBustype? = when (v) {
      0u -> I2C
      1u -> SPI
      else -> null
    }
  }
}
