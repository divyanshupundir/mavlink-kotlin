package xyz.urbanmatrix.mavlink.definitions.avssuas

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavAvssCommandFailureReason(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * AVSS defined command failure reason. PRS not steady.
   */
  @GeneratedMavEnumEntry
  PRS_NOT_STEADY(1u),
  /**
   * AVSS defined command failure reason. PRS DTM not armed.
   */
  @GeneratedMavEnumEntry
  PRS_DTM_NOT_ARMED(2u),
  /**
   * AVSS defined command failure reason. PRS OTM not armed.
   */
  @GeneratedMavEnumEntry
  PRS_OTM_NOT_ARMED(3u),
  ;

  public companion object : MavEnum.Companion<MavAvssCommandFailureReason> {
    public override fun getEntryFromValueOrNull(v: UInt): MavAvssCommandFailureReason? = when (v) {
      1u -> PRS_NOT_STEADY
      2u -> PRS_DTM_NOT_ARMED
      3u -> PRS_OTM_NOT_ARMED
      else -> null
    }
  }
}
