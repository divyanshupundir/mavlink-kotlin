package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class GoproHeartbeatStatus(
  override val `value`: UInt,
) : MavEnum {
  /**
   * No GoPro connected.
   */
  @GeneratedMavEnumEntry
  DISCONNECTED(0u),
  /**
   * The detected GoPro is not HeroBus compatible.
   */
  @GeneratedMavEnumEntry
  INCOMPATIBLE(1u),
  /**
   * A HeroBus compatible GoPro is connected.
   */
  @GeneratedMavEnumEntry
  CONNECTED(2u),
  /**
   * An unrecoverable error was encountered with the connected GoPro, it may require a power cycle.
   */
  @GeneratedMavEnumEntry
  ERROR(3u),
  ;

  public companion object : MavEnum.MavCompanion<GoproHeartbeatStatus> {
    override fun getEntryFromValueOrNull(v: UInt): GoproHeartbeatStatus? = when (v) {
      0u -> DISCONNECTED
      1u -> INCOMPATIBLE
      2u -> CONNECTED
      3u -> ERROR
      else -> null
    }
  }
}
