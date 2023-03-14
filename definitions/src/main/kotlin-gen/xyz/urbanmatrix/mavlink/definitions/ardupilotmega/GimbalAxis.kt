package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GimbalAxis(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Gimbal yaw axis.
   */
  @GeneratedMavEnumEntry
  YAW(0u),
  /**
   * Gimbal pitch axis.
   */
  @GeneratedMavEnumEntry
  PITCH(1u),
  /**
   * Gimbal roll axis.
   */
  @GeneratedMavEnumEntry
  ROLL(2u),
  ;

  public companion object : MavEnum.Companion<GimbalAxis> {
    public override fun getEntryFromValueOrNull(v: UInt): GimbalAxis? = when (v) {
      0u -> YAW
      1u -> PITCH
      2u -> ROLL
      else -> null
    }
  }
}
