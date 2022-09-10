package xyz.urbanmatrix.mavlink.definitions.asluav

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GsmModemType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * not specified
   */
  @GeneratedMavEnumEntry
  GSM_MODEM_TYPE_UNKNOWN(0L),
  /**
   * HUAWEI LTE USB Stick E3372
   */
  @GeneratedMavEnumEntry
  GSM_MODEM_TYPE_HUAWEI_E3372(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GsmModemType? = when (v) {
      0L -> GSM_MODEM_TYPE_UNKNOWN
      1L -> GSM_MODEM_TYPE_HUAWEI_E3372
      else -> null
    }
  }
}
