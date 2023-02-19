package xyz.urbanmatrix.mavlink.definitions.asluav

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GsmModemType(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * not specified
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * HUAWEI LTE USB Stick E3372
   */
  @GeneratedMavEnumEntry
  HUAWEI_E3372(1u),
  ;

  public companion object : MavEnum.Companion<GsmModemType> {
    public override fun getEntryFromValueOrNull(v: UInt): GsmModemType? = when (v) {
      0u -> UNKNOWN
      1u -> HUAWEI_E3372
      else -> null
    }
  }
}
