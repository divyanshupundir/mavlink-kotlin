package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproHeartbeatStatus(
  public override val `value`: Long,
) : MavEnum {
  /**
   * No GoPro connected.
   */
  @GeneratedMavEnumEntry
  DISCONNECTED(0L),
  /**
   * The detected GoPro is not HeroBus compatible.
   */
  @GeneratedMavEnumEntry
  INCOMPATIBLE(1L),
  /**
   * A HeroBus compatible GoPro is connected.
   */
  @GeneratedMavEnumEntry
  CONNECTED(2L),
  /**
   * An unrecoverable error was encountered with the connected GoPro, it may require a power cycle.
   */
  @GeneratedMavEnumEntry
  ERROR(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproHeartbeatStatus? = when (v) {
      0L -> DISCONNECTED
      1L -> INCOMPATIBLE
      2L -> CONNECTED
      3L -> ERROR
      else -> null
    }
  }
}
