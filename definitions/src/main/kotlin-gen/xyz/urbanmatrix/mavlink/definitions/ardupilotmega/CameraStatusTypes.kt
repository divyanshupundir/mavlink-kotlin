package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class CameraStatusTypes(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Camera heartbeat, announce camera component ID at 1Hz.
   */
  @GeneratedMavEnumEntry
  CAMERA_STATUS_TYPE_HEARTBEAT(0L),
  /**
   * Camera image triggered.
   */
  @GeneratedMavEnumEntry
  CAMERA_STATUS_TYPE_TRIGGER(1L),
  /**
   * Camera connection lost.
   */
  @GeneratedMavEnumEntry
  CAMERA_STATUS_TYPE_DISCONNECT(2L),
  /**
   * Camera unknown error.
   */
  @GeneratedMavEnumEntry
  CAMERA_STATUS_TYPE_ERROR(3L),
  /**
   * Camera battery low. Parameter p1 shows reported voltage.
   */
  @GeneratedMavEnumEntry
  CAMERA_STATUS_TYPE_LOWBATT(4L),
  /**
   * Camera storage low. Parameter p1 shows reported shots remaining.
   */
  @GeneratedMavEnumEntry
  CAMERA_STATUS_TYPE_LOWSTORE(5L),
  /**
   * Camera storage low. Parameter p1 shows reported video minutes remaining.
   */
  @GeneratedMavEnumEntry
  CAMERA_STATUS_TYPE_LOWSTOREV(6L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CameraStatusTypes? = when (v) {
      0L -> CAMERA_STATUS_TYPE_HEARTBEAT
      1L -> CAMERA_STATUS_TYPE_TRIGGER
      2L -> CAMERA_STATUS_TYPE_DISCONNECT
      3L -> CAMERA_STATUS_TYPE_ERROR
      4L -> CAMERA_STATUS_TYPE_LOWBATT
      5L -> CAMERA_STATUS_TYPE_LOWSTORE
      6L -> CAMERA_STATUS_TYPE_LOWSTOREV
      else -> null
    }
  }
}
