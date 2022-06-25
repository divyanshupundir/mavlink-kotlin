package com.urbanmatrix.mavlink.ASLUAV

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class GsmModemType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * not specified
   */
  GSM_MODEM_TYPE_UNKNOWN(0L),
  /**
   * HUAWEI LTE USB Stick E3372
   */
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
