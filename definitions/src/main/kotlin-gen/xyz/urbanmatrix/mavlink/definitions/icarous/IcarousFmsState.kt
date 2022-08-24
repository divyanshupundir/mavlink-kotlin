package xyz.urbanmatrix.mavlink.definitions.icarous

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class IcarousFmsState(
  public override val `value`: Long,
) : MavEnum {
  ICAROUS_FMS_STATE_IDLE(0L),
  ICAROUS_FMS_STATE_TAKEOFF(1L),
  ICAROUS_FMS_STATE_CLIMB(2L),
  ICAROUS_FMS_STATE_CRUISE(3L),
  ICAROUS_FMS_STATE_APPROACH(4L),
  ICAROUS_FMS_STATE_LAND(5L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): IcarousFmsState? = when (v) {
      0L -> ICAROUS_FMS_STATE_IDLE
      1L -> ICAROUS_FMS_STATE_TAKEOFF
      2L -> ICAROUS_FMS_STATE_CLIMB
      3L -> ICAROUS_FMS_STATE_CRUISE
      4L -> ICAROUS_FMS_STATE_APPROACH
      5L -> ICAROUS_FMS_STATE_LAND
      else -> null
    }
  }
}
