package com.urbanmatrix.mavlink.definitions.avssuas

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

@GeneratedMavEnum
public enum class MavAvssCommandFailureReason(
  public override val `value`: Long,
) : MavEnum {
  /**
   * AVSS defined command failure reason. PRS not steady.
   */
  PRS_NOT_STEADY(1L),
  /**
   * AVSS defined command failure reason. PRS DTM not armed.
   */
  PRS_DTM_NOT_ARMED(2L),
  /**
   * AVSS defined command failure reason. PRS OTM not armed.
   */
  PRS_OTM_NOT_ARMED(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavAvssCommandFailureReason? = when (v) {
      1L -> PRS_NOT_STEADY
      2L -> PRS_DTM_NOT_ARMED
      3L -> PRS_OTM_NOT_ARMED
      else -> null
    }
  }
}
