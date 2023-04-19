package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

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
