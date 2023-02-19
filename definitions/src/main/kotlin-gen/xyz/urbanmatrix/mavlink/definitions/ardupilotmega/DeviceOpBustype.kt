package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

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

  public companion object : MavEnum.Companion<DeviceOpBustype> {
    public override fun getEntryFromValueOrNull(v: UInt): DeviceOpBustype? = when (v) {
      0u -> I2C
      1u -> SPI
      else -> null
    }
  }
}
