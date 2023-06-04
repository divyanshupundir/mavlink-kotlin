package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class CameraStatusTypes(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Camera heartbeat, announce camera component ID at 1Hz.
   */
  @GeneratedMavEnumEntry
  CAMERA_STATUS_TYPE_HEARTBEAT(0u),
  /**
   * Camera image triggered.
   */
  @GeneratedMavEnumEntry
  CAMERA_STATUS_TYPE_TRIGGER(1u),
  /**
   * Camera connection lost.
   */
  @GeneratedMavEnumEntry
  CAMERA_STATUS_TYPE_DISCONNECT(2u),
  /**
   * Camera unknown error.
   */
  @GeneratedMavEnumEntry
  CAMERA_STATUS_TYPE_ERROR(3u),
  /**
   * Camera battery low. Parameter p1 shows reported voltage.
   */
  @GeneratedMavEnumEntry
  CAMERA_STATUS_TYPE_LOWBATT(4u),
  /**
   * Camera storage low. Parameter p1 shows reported shots remaining.
   */
  @GeneratedMavEnumEntry
  CAMERA_STATUS_TYPE_LOWSTORE(5u),
  /**
   * Camera storage low. Parameter p1 shows reported video minutes remaining.
   */
  @GeneratedMavEnumEntry
  CAMERA_STATUS_TYPE_LOWSTOREV(6u),
  ;

  public companion object : MavEnum.MavCompanion<CameraStatusTypes> {
    public override fun getEntryFromValueOrNull(v: UInt): CameraStatusTypes? = when (v) {
      0u -> CAMERA_STATUS_TYPE_HEARTBEAT
      1u -> CAMERA_STATUS_TYPE_TRIGGER
      2u -> CAMERA_STATUS_TYPE_DISCONNECT
      3u -> CAMERA_STATUS_TYPE_ERROR
      4u -> CAMERA_STATUS_TYPE_LOWBATT
      5u -> CAMERA_STATUS_TYPE_LOWSTORE
      6u -> CAMERA_STATUS_TYPE_LOWSTOREV
      else -> null
    }
  }
}
