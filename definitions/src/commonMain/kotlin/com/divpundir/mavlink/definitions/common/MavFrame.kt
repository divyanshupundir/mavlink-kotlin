package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.Deprecated
import kotlin.UInt

/**
 * Coordinate frames used by MAVLink. Not all frames are supported by all commands, messages, or
 * vehicles.
 *
 *       Global frames use the following naming conventions:
 *       - "GLOBAL": Global coordinate frame with WGS84 latitude/longitude and altitude positive
 * over mean sea level (MSL) by default.
 *         The following modifiers may be used with "GLOBAL":
 *         - "RELATIVE_ALT": Altitude is relative to the vehicle home position rather than MSL.
 *         - "TERRAIN_ALT": Altitude is relative to ground level rather than MSL.
 *         - "INT": Latitude/longitude (in degrees) are scaled by multiplying by 1E7.
 *
 *       Local frames use the following naming conventions:
 *       - "LOCAL": Origin of local frame is fixed relative to earth. Unless otherwise specified
 * this origin is the origin of the vehicle position-estimator ("EKF").
 *       - "BODY": Origin of local frame travels with the vehicle. NOTE, "BODY" does NOT indicate
 * alignment of frame axis with vehicle attitude.
 *       - "OFFSET": Deprecated synonym for "BODY" (origin travels with the vehicle). Not to be used
 * for new frames.
 *
 *       Some deprecated frames do not follow these conventions (e.g. MAV_FRAME_BODY_NED and
 * MAV_FRAME_BODY_OFFSET_NED).
 *  
 */
@GeneratedMavEnum
public enum class MavFrame(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Global (WGS84) coordinate frame + altitude relative to mean sea level (MSL).
   */
  @GeneratedMavEnumEntry
  GLOBAL(0u),
  /**
   * NED local tangent frame (x: North, y: East, z: Down) with origin fixed relative to earth.
   */
  @GeneratedMavEnumEntry
  LOCAL_NED(1u),
  /**
   * NOT a coordinate frame, indicates a mission command.
   */
  @GeneratedMavEnumEntry
  MISSION(2u),
  /**
   *
   *           Global (WGS84) coordinate frame + altitude relative to the home position.
   *         
   */
  @GeneratedMavEnumEntry
  GLOBAL_RELATIVE_ALT(3u),
  /**
   * ENU local tangent frame (x: East, y: North, z: Up) with origin fixed relative to earth.
   */
  @GeneratedMavEnumEntry
  LOCAL_ENU(4u),
  /**
   * Global (WGS84) coordinate frame (scaled) + altitude relative to mean sea level (MSL).
   */
  @Deprecated(message =
      "Use MAV_FRAME_GLOBAL in COMMAND_INT (and elsewhere) as a synonymous replacement.")
  @GeneratedMavEnumEntry
  GLOBAL_INT(5u),
  /**
   * Global (WGS84) coordinate frame (scaled) + altitude relative to the home position. 
   */
  @Deprecated(message =
      "Use MAV_FRAME_GLOBAL_RELATIVE_ALT in COMMAND_INT (and elsewhere) as a synonymous replacement.")
  @GeneratedMavEnumEntry
  GLOBAL_RELATIVE_ALT_INT(6u),
  /**
   * NED local tangent frame (x: North, y: East, z: Down) with origin that travels with the vehicle.
   */
  @GeneratedMavEnumEntry
  LOCAL_OFFSET_NED(7u),
  /**
   * Same as MAV_FRAME_LOCAL_NED when used to represent position values. Same as MAV_FRAME_BODY_FRD
   * when used with velocity/acceleration values.
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  BODY_NED(8u),
  /**
   * This is the same as MAV_FRAME_BODY_FRD.
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  BODY_OFFSET_NED(9u),
  /**
   * Global (WGS84) coordinate frame with AGL altitude (altitude at ground level).
   */
  @GeneratedMavEnumEntry
  GLOBAL_TERRAIN_ALT(10u),
  /**
   * Global (WGS84) coordinate frame (scaled) with AGL altitude (altitude at ground level).
   */
  @Deprecated(message =
      "Use MAV_FRAME_GLOBAL_TERRAIN_ALT in COMMAND_INT (and elsewhere) as a synonymous replacement.")
  @GeneratedMavEnumEntry
  GLOBAL_TERRAIN_ALT_INT(11u),
  /**
   * FRD local frame aligned to the vehicle's attitude (x: Forward, y: Right, z: Down) with an
   * origin that travels with vehicle.
   */
  @GeneratedMavEnumEntry
  BODY_FRD(12u),
  /**
   * MAV_FRAME_BODY_FLU - Body fixed frame of reference, Z-up (x: Forward, y: Left, z: Up).
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  RESERVED_13(13u),
  /**
   * MAV_FRAME_MOCAP_NED - Odometry local coordinate frame of data given by a motion capture system,
   * Z-down (x: North, y: East, z: Down).
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  RESERVED_14(14u),
  /**
   * MAV_FRAME_MOCAP_ENU - Odometry local coordinate frame of data given by a motion capture system,
   * Z-up (x: East, y: North, z: Up).
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  RESERVED_15(15u),
  /**
   * MAV_FRAME_VISION_NED - Odometry local coordinate frame of data given by a vision estimation
   * system, Z-down (x: North, y: East, z: Down).
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  RESERVED_16(16u),
  /**
   * MAV_FRAME_VISION_ENU - Odometry local coordinate frame of data given by a vision estimation
   * system, Z-up (x: East, y: North, z: Up).
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  RESERVED_17(17u),
  /**
   * MAV_FRAME_ESTIM_NED - Odometry local coordinate frame of data given by an estimator running
   * onboard the vehicle, Z-down (x: North, y: East, z: Down).
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  RESERVED_18(18u),
  /**
   * MAV_FRAME_ESTIM_ENU - Odometry local coordinate frame of data given by an estimator running
   * onboard the vehicle, Z-up (x: East, y: North, z: Up).
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  RESERVED_19(19u),
  /**
   * FRD local tangent frame (x: Forward, y: Right, z: Down) with origin fixed relative to earth.
   * The forward axis is aligned to the front of the vehicle in the horizontal plane.
   */
  @GeneratedMavEnumEntry
  LOCAL_FRD(20u),
  /**
   * FLU local tangent frame (x: Forward, y: Left, z: Up) with origin fixed relative to earth. The
   * forward axis is aligned to the front of the vehicle in the horizontal plane.
   */
  @GeneratedMavEnumEntry
  LOCAL_FLU(21u),
  ;

  public companion object : MavEnum.MavCompanion<MavFrame> {
    override fun getEntryFromValueOrNull(v: UInt): MavFrame? = when (v) {
      0u -> GLOBAL
      1u -> LOCAL_NED
      2u -> MISSION
      3u -> GLOBAL_RELATIVE_ALT
      4u -> LOCAL_ENU
      5u -> GLOBAL_INT
      6u -> GLOBAL_RELATIVE_ALT_INT
      7u -> LOCAL_OFFSET_NED
      8u -> BODY_NED
      9u -> BODY_OFFSET_NED
      10u -> GLOBAL_TERRAIN_ALT
      11u -> GLOBAL_TERRAIN_ALT_INT
      12u -> BODY_FRD
      13u -> RESERVED_13
      14u -> RESERVED_14
      15u -> RESERVED_15
      16u -> RESERVED_16
      17u -> RESERVED_17
      18u -> RESERVED_18
      19u -> RESERVED_19
      20u -> LOCAL_FRD
      21u -> LOCAL_FLU
      else -> null
    }
  }
}
