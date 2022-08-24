package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Deprecated
import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Co-ordinate frames used by MAVLink. Not all frames are supported by all commands, messages, or
 * vehicles.
 *       
 *       Global frames use the following naming conventions:
 *       - "GLOBAL": Global co-ordinate frame with WGS84 latitude/longitude and altitude positive
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
  public override val `value`: Long,
) : MavEnum {
  /**
   * Global (WGS84) coordinate frame + MSL altitude. First value / x: latitude, second value / y:
   * longitude, third value / z: positive altitude over mean sea level (MSL).
   */
  MAV_FRAME_GLOBAL(0L),
  /**
   * NED local tangent frame (x: North, y: East, z: Down) with origin fixed relative to earth.
   */
  MAV_FRAME_LOCAL_NED(1L),
  /**
   * NOT a coordinate frame, indicates a mission command.
   */
  MAV_FRAME_MISSION(2L),
  /**
   *
   *           Global (WGS84) coordinate frame + altitude relative to the home position.
   *           First value / x: latitude, second value / y: longitude, third value / z: positive
   * altitude with 0 being at the altitude of the home position.
   *         
   */
  MAV_FRAME_GLOBAL_RELATIVE_ALT(3L),
  /**
   * ENU local tangent frame (x: East, y: North, z: Up) with origin fixed relative to earth.
   */
  MAV_FRAME_LOCAL_ENU(4L),
  /**
   * Global (WGS84) coordinate frame (scaled) + MSL altitude. First value / x: latitude in
   * degrees*1E7, second value / y: longitude in degrees*1E7, third value / z: positive altitude over
   * mean sea level (MSL).
   */
  MAV_FRAME_GLOBAL_INT(5L),
  /**
   *
   *           Global (WGS84) coordinate frame (scaled) + altitude relative to the home position.
   *           First value / x: latitude in degrees*1E7, second value / y: longitude in degrees*1E7,
   * third value / z: positive altitude with 0 being at the altitude of the home position.
   *         
   */
  MAV_FRAME_GLOBAL_RELATIVE_ALT_INT(6L),
  /**
   * NED local tangent frame (x: North, y: East, z: Down) with origin that travels with the vehicle.
   */
  MAV_FRAME_LOCAL_OFFSET_NED(7L),
  /**
   * Same as MAV_FRAME_LOCAL_NED when used to represent position values. Same as MAV_FRAME_BODY_FRD
   * when used with velocity/accelaration values.
   */
  @Deprecated(message = "")
  MAV_FRAME_BODY_NED(8L),
  /**
   * This is the same as MAV_FRAME_BODY_FRD.
   */
  @Deprecated(message = "")
  MAV_FRAME_BODY_OFFSET_NED(9L),
  /**
   * Global (WGS84) coordinate frame with AGL altitude (at the waypoint coordinate). First value /
   * x: latitude in degrees, second value / y: longitude in degrees, third value / z: positive altitude
   * in meters with 0 being at ground level in terrain model.
   */
  MAV_FRAME_GLOBAL_TERRAIN_ALT(10L),
  /**
   * Global (WGS84) coordinate frame (scaled) with AGL altitude (at the waypoint coordinate). First
   * value / x: latitude in degrees*1E7, second value / y: longitude in degrees*1E7, third value / z:
   * positive altitude in meters with 0 being at ground level in terrain model.
   */
  MAV_FRAME_GLOBAL_TERRAIN_ALT_INT(11L),
  /**
   * FRD local tangent frame (x: Forward, y: Right, z: Down) with origin that travels with vehicle.
   * The forward axis is aligned to the front of the vehicle in the horizontal plane.
   */
  MAV_FRAME_BODY_FRD(12L),
  /**
   * MAV_FRAME_BODY_FLU - Body fixed frame of reference, Z-up (x: Forward, y: Left, z: Up).
   */
  @Deprecated(message = "")
  MAV_FRAME_RESERVED_13(13L),
  /**
   * MAV_FRAME_MOCAP_NED - Odometry local coordinate frame of data given by a motion capture system,
   * Z-down (x: North, y: East, z: Down).
   */
  @Deprecated(message = "")
  MAV_FRAME_RESERVED_14(14L),
  /**
   * MAV_FRAME_MOCAP_ENU - Odometry local coordinate frame of data given by a motion capture system,
   * Z-up (x: East, y: North, z: Up).
   */
  @Deprecated(message = "")
  MAV_FRAME_RESERVED_15(15L),
  /**
   * MAV_FRAME_VISION_NED - Odometry local coordinate frame of data given by a vision estimation
   * system, Z-down (x: North, y: East, z: Down).
   */
  @Deprecated(message = "")
  MAV_FRAME_RESERVED_16(16L),
  /**
   * MAV_FRAME_VISION_ENU - Odometry local coordinate frame of data given by a vision estimation
   * system, Z-up (x: East, y: North, z: Up).
   */
  @Deprecated(message = "")
  MAV_FRAME_RESERVED_17(17L),
  /**
   * MAV_FRAME_ESTIM_NED - Odometry local coordinate frame of data given by an estimator running
   * onboard the vehicle, Z-down (x: North, y: East, z: Down).
   */
  @Deprecated(message = "")
  MAV_FRAME_RESERVED_18(18L),
  /**
   * MAV_FRAME_ESTIM_ENU - Odometry local coordinate frame of data given by an estimator running
   * onboard the vehicle, Z-up (x: East, y: North, z: Up).
   */
  @Deprecated(message = "")
  MAV_FRAME_RESERVED_19(19L),
  /**
   * FRD local tangent frame (x: Forward, y: Right, z: Down) with origin fixed relative to earth.
   * The forward axis is aligned to the front of the vehicle in the horizontal plane.
   */
  MAV_FRAME_LOCAL_FRD(20L),
  /**
   * FLU local tangent frame (x: Forward, y: Left, z: Up) with origin fixed relative to earth. The
   * forward axis is aligned to the front of the vehicle in the horizontal plane.
   */
  MAV_FRAME_LOCAL_FLU(21L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavFrame? = when (v) {
      0L -> MAV_FRAME_GLOBAL
      1L -> MAV_FRAME_LOCAL_NED
      2L -> MAV_FRAME_MISSION
      3L -> MAV_FRAME_GLOBAL_RELATIVE_ALT
      4L -> MAV_FRAME_LOCAL_ENU
      5L -> MAV_FRAME_GLOBAL_INT
      6L -> MAV_FRAME_GLOBAL_RELATIVE_ALT_INT
      7L -> MAV_FRAME_LOCAL_OFFSET_NED
      8L -> MAV_FRAME_BODY_NED
      9L -> MAV_FRAME_BODY_OFFSET_NED
      10L -> MAV_FRAME_GLOBAL_TERRAIN_ALT
      11L -> MAV_FRAME_GLOBAL_TERRAIN_ALT_INT
      12L -> MAV_FRAME_BODY_FRD
      13L -> MAV_FRAME_RESERVED_13
      14L -> MAV_FRAME_RESERVED_14
      15L -> MAV_FRAME_RESERVED_15
      16L -> MAV_FRAME_RESERVED_16
      17L -> MAV_FRAME_RESERVED_17
      18L -> MAV_FRAME_RESERVED_18
      19L -> MAV_FRAME_RESERVED_19
      20L -> MAV_FRAME_LOCAL_FRD
      21L -> MAV_FRAME_LOCAL_FLU
      else -> null
    }
  }
}
