package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproRequestStatus(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * The write message with ID indicated succeeded.
   */
  @GeneratedMavEnumEntry
  GOPRO_REQUEST_SUCCESS(0u),
  /**
   * The write message with ID indicated failed.
   */
  @GeneratedMavEnumEntry
  GOPRO_REQUEST_FAILED(1u),
  ;

  public companion object : MavEnum.Companion<GoproRequestStatus> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproRequestStatus? = when (v) {
      0u -> GOPRO_REQUEST_SUCCESS
      1u -> GOPRO_REQUEST_FAILED
      else -> null
    }
  }
}
