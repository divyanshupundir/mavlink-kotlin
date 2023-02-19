package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproHeartbeatStatus(
  public override val `value`: UInt,
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

  public companion object : MavEnum.Companion<GoproHeartbeatStatus> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproHeartbeatStatus? = when (v) {
      0u -> DISCONNECTED
      1u -> INCOMPATIBLE
      2u -> CONNECTED
      3u -> ERROR
      else -> null
    }
  }
}
