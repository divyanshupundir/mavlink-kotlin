package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproHeartbeatFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * GoPro is currently recording.
   */
  @GeneratedMavEnumEntry
  GOPRO_FLAG_RECORDING(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproHeartbeatFlags? = when (v) {
      1L -> GOPRO_FLAG_RECORDING
      else -> null
    }
  }
}
