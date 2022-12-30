package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Cellular network radio type
 */
@GeneratedMavEnum
public enum class CellularNetworkRadioType(
  public override val `value`: Long,
) : MavEnum {
  @GeneratedMavEnumEntry
  NONE(0L),
  @GeneratedMavEnumEntry
  GSM(1L),
  @GeneratedMavEnumEntry
  CDMA(2L),
  @GeneratedMavEnumEntry
  WCDMA(3L),
  @GeneratedMavEnumEntry
  LTE(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CellularNetworkRadioType? = when (v) {
      0L -> NONE
      1L -> GSM
      2L -> CDMA
      3L -> WCDMA
      4L -> LTE
      else -> null
    }
  }
}
