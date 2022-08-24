package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class AccelcalVehiclePos(
  public override val `value`: Long,
) : MavEnum {
  ACCELCAL_VEHICLE_POS_LEVEL(1L),
  ACCELCAL_VEHICLE_POS_LEFT(2L),
  ACCELCAL_VEHICLE_POS_RIGHT(3L),
  ACCELCAL_VEHICLE_POS_NOSEDOWN(4L),
  ACCELCAL_VEHICLE_POS_NOSEUP(5L),
  ACCELCAL_VEHICLE_POS_BACK(6L),
  ACCELCAL_VEHICLE_POS_SUCCESS(16777215L),
  ACCELCAL_VEHICLE_POS_FAILED(16777216L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): AccelcalVehiclePos? = when (v) {
      1L -> ACCELCAL_VEHICLE_POS_LEVEL
      2L -> ACCELCAL_VEHICLE_POS_LEFT
      3L -> ACCELCAL_VEHICLE_POS_RIGHT
      4L -> ACCELCAL_VEHICLE_POS_NOSEDOWN
      5L -> ACCELCAL_VEHICLE_POS_NOSEUP
      6L -> ACCELCAL_VEHICLE_POS_BACK
      16777215L -> ACCELCAL_VEHICLE_POS_SUCCESS
      16777216L -> ACCELCAL_VEHICLE_POS_FAILED
      else -> null
    }
  }
}
