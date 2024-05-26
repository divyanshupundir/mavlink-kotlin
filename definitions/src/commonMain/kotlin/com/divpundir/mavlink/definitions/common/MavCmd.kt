package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import com.divpundir.mavlink.api.WorkInProgress
import kotlin.Deprecated
import kotlin.UInt

/**
 * Commands to be executed by the MAV. They can be executed on user request, or as part of a mission
 * script. If the action is used in a mission, the parameter mapping to the waypoint/mission message is
 * as follows: Param 1, Param 2, Param 3, Param 4, X: Param 5, Y:Param 6, Z:Param 7. This command list
 * is similar what ARINC 424 is for commercial aircraft: A data format how to interpret
 * waypoint/mission data. NaN and INT32_MAX may be used in float/integer params (respectively) to
 * indicate optional/default values (e.g. to use the component's current yaw or latitude rather than a
 * specific value). See https://mavlink.io/en/guide/xml_schema.html#MAV_CMD for information about the
 * structure of the MAV_CMD entries
 */
@GeneratedMavEnum
public enum class MavCmd(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Navigate to waypoint. This is intended for use in missions (for guided commands outside of
   * missions use MAV_CMD_DO_REPOSITION).
   *
   * index = 1; label = Hold; units = s; 
   * Hold time. (ignored by fixed wing, time to stay at waypoint for rotary wing)
   *
   * index = 2; label = Accept Radius; units = m; 
   * Acceptance radius (if the sphere with this radius is hit, the waypoint counts as reached)
   *
   * index = 3; label = Pass Radius; units = m; 
   * 0 to pass through the WP, if > 0 radius to pass by WP. Positive value for clockwise orbit,
   * negative value for counter-clockwise orbit. Allows trajectory control.
   *
   * index = 4; label = Yaw; units = deg; 
   * Desired yaw angle at waypoint (rotary wing). NaN to use the current system yaw heading mode
   * (e.g. yaw towards next waypoint, yaw to home, etc.).
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude
   */
  @GeneratedMavEnumEntry
  NAV_WAYPOINT(16u),
  /**
   * Loiter around this waypoint an unlimited amount of time
   *
   * index = 1; 
   * Empty
   *
   * index = 2; 
   * Empty
   *
   * index = 3; label = Radius; units = m; 
   * Loiter radius around waypoint for forward-only moving vehicles (not multicopters). If positive
   * loiter clockwise, else counter-clockwise
   *
   * index = 4; label = Yaw; units = deg; 
   * Desired yaw angle. NaN to use the current system yaw heading mode (e.g. yaw towards next
   * waypoint, yaw to home, etc.).
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude
   */
  @GeneratedMavEnumEntry
  NAV_LOITER_UNLIM(17u),
  /**
   * Loiter around this waypoint for X turns
   *
   * index = 1; label = Turns; 
   * Number of turns.
   *
   * index = 2; label = Heading Required; 
   * Leave loiter circle only once heading towards the next waypoint (0 = False)
   *
   * index = 3; label = Radius; units = m; 
   * Loiter radius around waypoint for forward-only moving vehicles (not multicopters). If positive
   * loiter clockwise, else counter-clockwise
   *
   * index = 4; label = Xtrack Location; 
   * Loiter circle exit location and/or path to next waypoint ("xtrack") for forward-only moving
   * vehicles (not multicopters). 0 for the vehicle to converge towards the center xtrack when it
   * leaves the loiter (the line between the centers of the current and next waypoint), 1 to converge
   * to the direct line between the location that the vehicle exits the loiter radius and the next
   * waypoint. Otherwise the angle (in degrees) between the tangent of the loiter circle and the center
   * xtrack at which the vehicle must leave the loiter (and converge to the center xtrack). NaN to use
   * the current system default xtrack behaviour.
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude
   */
  @GeneratedMavEnumEntry
  NAV_LOITER_TURNS(18u),
  /**
   * Loiter at the specified latitude, longitude and altitude for a certain amount of time.
   * Multicopter vehicles stop at the point (within a vehicle-specific acceptance radius). Forward-only
   * moving vehicles (e.g. fixed-wing) circle the point with the specified radius/direction. If the
   * Heading Required parameter (2) is non-zero forward moving aircraft will only leave the loiter
   * circle once heading towards the next waypoint.
   *
   * index = 1; label = Time; units = s; 
   * Loiter time (only starts once Lat, Lon and Alt is reached).
   *
   * index = 2; label = Heading Required; 
   * Leave loiter circle only once heading towards the next waypoint (0 = False)
   *
   * index = 3; label = Radius; units = m; 
   * Loiter radius around waypoint for forward-only moving vehicles (not multicopters). If positive
   * loiter clockwise, else counter-clockwise.
   *
   * index = 4; label = Xtrack Location; 
   * Loiter circle exit location and/or path to next waypoint ("xtrack") for forward-only moving
   * vehicles (not multicopters). 0 for the vehicle to converge towards the center xtrack when it
   * leaves the loiter (the line between the centers of the current and next waypoint), 1 to converge
   * to the direct line between the location that the vehicle exits the loiter radius and the next
   * waypoint. Otherwise the angle (in degrees) between the tangent of the loiter circle and the center
   * xtrack at which the vehicle must leave the loiter (and converge to the center xtrack). NaN to use
   * the current system default xtrack behaviour.
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude
   */
  @GeneratedMavEnumEntry
  NAV_LOITER_TIME(19u),
  /**
   * Return to launch location
   *
   * index = 1; 
   * Empty
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  NAV_RETURN_TO_LAUNCH(20u),
  /**
   * Land at location.
   *
   * index = 1; label = Abort Alt; units = m; 
   * Minimum target altitude if landing is aborted (0 = undefined/use system default).
   *
   * index = 2; label = Land Mode; 
   * Precision land mode.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; label = Yaw Angle; units = deg; 
   * Desired yaw angle. NaN to use the current system yaw heading mode (e.g. yaw towards next
   * waypoint, yaw to home, etc.).
   *
   * index = 5; label = Latitude; 
   * Latitude.
   *
   * index = 6; label = Longitude; 
   * Longitude.
   *
   * index = 7; label = Altitude; units = m; 
   * Landing altitude (ground level in current frame).
   */
  @GeneratedMavEnumEntry
  NAV_LAND(21u),
  /**
   * Takeoff from ground / hand. Vehicles that support multiple takeoff modes (e.g. VTOL quadplane)
   * should take off using the currently configured mode.
   *
   * index = 1; label = Pitch; units = deg; 
   * Minimum pitch (if airspeed sensor present), desired pitch without sensor
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; label = Yaw; units = deg; 
   * Yaw angle (if magnetometer present), ignored without magnetometer. NaN to use the current
   * system yaw heading mode (e.g. yaw towards next waypoint, yaw to home, etc.).
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude
   */
  @GeneratedMavEnumEntry
  NAV_TAKEOFF(22u),
  /**
   * Land at local position (local frame only)
   *
   * index = 1; label = Target; 
   * Landing target number (if available)
   *
   * index = 2; label = Offset; units = m; 
   * Maximum accepted offset from desired landing position - computed magnitude from spherical
   * coordinates: d = sqrt(x^2 + y^2 + z^2), which gives the maximum accepted distance between the
   * desired landing position and the position where the vehicle is about to land
   *
   * index = 3; label = Descend Rate; units = m/s; 
   * Landing descend rate
   *
   * index = 4; label = Yaw; units = rad; 
   * Desired yaw angle
   *
   * index = 5; label = Y Position; units = m; 
   * Y-axis position
   *
   * index = 6; label = X Position; units = m; 
   * X-axis position
   *
   * index = 7; label = Z Position; units = m; 
   * Z-axis / ground level position
   */
  @GeneratedMavEnumEntry
  NAV_LAND_LOCAL(23u),
  /**
   * Takeoff from local position (local frame only)
   *
   * index = 1; label = Pitch; units = rad; 
   * Minimum pitch (if airspeed sensor present), desired pitch without sensor
   *
   * index = 2; 
   * Empty
   *
   * index = 3; label = Ascend Rate; units = m/s; 
   * Takeoff ascend rate
   *
   * index = 4; label = Yaw; units = rad; 
   * Yaw angle (if magnetometer or another yaw estimation source present), ignored without one of
   * these
   *
   * index = 5; label = Y Position; units = m; 
   * Y-axis position
   *
   * index = 6; label = X Position; units = m; 
   * X-axis position
   *
   * index = 7; label = Z Position; units = m; 
   * Z-axis position
   */
  @GeneratedMavEnumEntry
  NAV_TAKEOFF_LOCAL(24u),
  /**
   * Vehicle following, i.e. this waypoint represents the position of a moving vehicle
   *
   * index = 1; label = Following; 
   * Following logic to use (e.g. loitering or sinusoidal following) - depends on specific autopilot
   * implementation
   *
   * index = 2; label = Ground Speed; units = m/s; 
   * Ground speed of vehicle to be followed
   *
   * index = 3; label = Radius; units = m; 
   * Radius around waypoint. If positive loiter clockwise, else counter-clockwise
   *
   * index = 4; label = Yaw; units = deg; 
   * Desired yaw angle.
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude
   */
  @GeneratedMavEnumEntry
  NAV_FOLLOW(25u),
  /**
   * Continue on the current course and climb/descend to specified altitude.  When the altitude is
   * reached continue to the next command (i.e., don't proceed to the next command until the desired
   * altitude is reached.
   *
   * index = 1; label = Action; 
   * Climb or Descend (0 = Neutral, command completes when within 5m of this command's altitude, 1 =
   * Climbing, command completes when at or above this command's altitude, 2 = Descending, command
   * completes when at or below this command's altitude.
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; label = Altitude; units = m; 
   * Desired altitude
   */
  @GeneratedMavEnumEntry
  NAV_CONTINUE_AND_CHANGE_ALT(30u),
  /**
   * Begin loiter at the specified Latitude and Longitude.  If Lat=Lon=0, then loiter at the current
   * position.  Don't consider the navigation command complete (don't leave loiter) until the altitude
   * has been reached. Additionally, if the Heading Required parameter is non-zero the aircraft will
   * not leave the loiter until heading toward the next waypoint.
   *
   * index = 1; label = Heading Required; 
   * Leave loiter circle only once heading towards the next waypoint (0 = False)
   *
   * index = 2; label = Radius; units = m; 
   * Loiter radius around waypoint for forward-only moving vehicles (not multicopters). If positive
   * loiter clockwise, negative counter-clockwise, 0 means no change to standard loiter.
   *
   * index = 3; 
   * Empty
   *
   * index = 4; label = Xtrack Location; 
   * Loiter circle exit location and/or path to next waypoint ("xtrack") for forward-only moving
   * vehicles (not multicopters). 0 for the vehicle to converge towards the center xtrack when it
   * leaves the loiter (the line between the centers of the current and next waypoint), 1 to converge
   * to the direct line between the location that the vehicle exits the loiter radius and the next
   * waypoint. Otherwise the angle (in degrees) between the tangent of the loiter circle and the center
   * xtrack at which the vehicle must leave the loiter (and converge to the center xtrack). NaN to use
   * the current system default xtrack behaviour.
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude
   */
  @GeneratedMavEnumEntry
  NAV_LOITER_TO_ALT(31u),
  /**
   * Begin following a target
   *
   * index = 1; label = System ID; 
   * System ID (of the FOLLOW_TARGET beacon). Send 0 to disable follow-me and return to the default
   * position hold mode.
   *
   * index = 2; 
   * Reserved
   *
   * index = 3; 
   * Reserved
   *
   * index = 4; label = Altitude Mode; 
   * Altitude mode: 0: Keep current altitude, 1: keep altitude difference to target, 2: go to a
   * fixed altitude above home.
   *
   * index = 5; label = Altitude; units = m; 
   * Altitude above home. (used if mode=2)
   *
   * index = 6; 
   * Reserved
   *
   * index = 7; label = Time to Land; units = s; 
   * Time to land in which the MAV should go to the default position hold mode after a message RX
   * timeout.
   */
  @GeneratedMavEnumEntry
  DO_FOLLOW(32u),
  /**
   * Reposition the MAV after a follow target command has been sent
   *
   * index = 1; label = Camera Q1; 
   * Camera q1 (where 0 is on the ray from the camera to the tracking device)
   *
   * index = 2; label = Camera Q2; 
   * Camera q2
   *
   * index = 3; label = Camera Q3; 
   * Camera q3
   *
   * index = 4; label = Camera Q4; 
   * Camera q4
   *
   * index = 5; label = Altitude Offset; units = m; 
   * altitude offset from target
   *
   * index = 6; label = X Offset; units = m; 
   * X offset from target
   *
   * index = 7; label = Y Offset; units = m; 
   * Y offset from target
   */
  @GeneratedMavEnumEntry
  DO_FOLLOW_REPOSITION(33u),
  /**
   * Start orbiting on the circumference of a circle defined by the parameters. Setting values to
   * NaN/INT32_MAX (as appropriate) results in using defaults.
   *
   * index = 1; label = Radius; units = m; 
   * Radius of the circle. Positive: orbit clockwise. Negative: orbit counter-clockwise. NaN: Use
   * vehicle default radius, or current radius if already orbiting.
   *
   * index = 2; label = Velocity; units = m/s; 
   * Tangential Velocity. NaN: Use vehicle default velocity, or current velocity if already
   * orbiting.
   *
   * index = 3; label = Yaw Behavior; 
   * Yaw behavior of the vehicle.
   *
   * index = 4; label = Orbits; units = rad; 
   * Orbit around the centre point for this many radians (i.e. for a three-quarter orbit set
   * 270*Pi/180). 0: Orbit forever. NaN: Use vehicle default, or current value if already orbiting.
   *
   * index = 5; label = Latitude/X; 
   * Center point latitude (if no MAV_FRAME specified) / X coordinate according to MAV_FRAME.
   * INT32_MAX (or NaN if sent in COMMAND_LONG): Use current vehicle position, or current center if
   * already orbiting.
   *
   * index = 6; label = Longitude/Y; 
   * Center point longitude (if no MAV_FRAME specified) / Y coordinate according to MAV_FRAME.
   * INT32_MAX (or NaN if sent in COMMAND_LONG): Use current vehicle position, or current center if
   * already orbiting.
   *
   * index = 7; label = Altitude/Z; 
   * Center point altitude (MSL) (if no MAV_FRAME specified) / Z coordinate according to MAV_FRAME.
   * NaN: Use current vehicle altitude.
   */
  @WorkInProgress
  @GeneratedMavEnumEntry
  DO_ORBIT(34u),
  /**
   * Sets the region of interest (ROI) for a sensor set or the vehicle itself. This can then be used
   * by the vehicle's control system to control the vehicle attitude and the attitude of various
   * sensors such as cameras.
   *
   * index = 1; label = ROI Mode; 
   * Region of interest mode.
   *
   * index = 2; label = WP Index; 
   * Waypoint index/ target ID. (see MAV_ROI enum)
   *
   * index = 3; label = ROI Index; 
   * ROI index (allows a vehicle to manage multiple ROI's)
   *
   * index = 4; 
   * Empty
   *
   * index = 5; label = X; 
   * x the location of the fixed ROI (see MAV_FRAME)
   *
   * index = 6; label = Y; 
   * y
   *
   * index = 7; label = Z; 
   * z
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  NAV_ROI(80u),
  /**
   * Control autonomous path planning on the MAV.
   *
   * index = 1; label = Local Ctrl; 
   * 0: Disable local obstacle avoidance / local path planning (without resetting map), 1: Enable
   * local path planning, 2: Enable and reset local path planning
   *
   * index = 2; label = Global Ctrl; 
   * 0: Disable full path planning (without resetting map), 1: Enable, 2: Enable and reset
   * map/occupancy grid, 3: Enable and reset planned route, but not occupancy grid
   *
   * index = 3; 
   * Empty
   *
   * index = 4; label = Yaw; units = deg; 
   * Yaw angle at goal
   *
   * index = 5; label = Latitude/X; 
   * Latitude/X of goal
   *
   * index = 6; label = Longitude/Y; 
   * Longitude/Y of goal
   *
   * index = 7; label = Altitude/Z; 
   * Altitude/Z of goal
   */
  @GeneratedMavEnumEntry
  NAV_PATHPLANNING(81u),
  /**
   * Navigate to waypoint using a spline path.
   *
   * index = 1; label = Hold; units = s; 
   * Hold time. (ignored by fixed wing, time to stay at waypoint for rotary wing)
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; label = Latitude/X; 
   * Latitude/X of goal
   *
   * index = 6; label = Longitude/Y; 
   * Longitude/Y of goal
   *
   * index = 7; label = Altitude/Z; 
   * Altitude/Z of goal
   */
  @GeneratedMavEnumEntry
  NAV_SPLINE_WAYPOINT(82u),
  /**
   * Takeoff from ground using VTOL mode, and transition to forward flight with specified heading.
   * The command should be ignored by vehicles that dont support both VTOL and fixed-wing flight
   * (multicopters, boats,etc.).
   *
   * index = 1; 
   * Empty
   *
   * index = 2; label = Transition Heading; 
   * Front transition heading.
   *
   * index = 3; 
   * Empty
   *
   * index = 4; label = Yaw Angle; units = deg; 
   * Yaw angle. NaN to use the current system yaw heading mode (e.g. yaw towards next waypoint, yaw
   * to home, etc.).
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude
   */
  @GeneratedMavEnumEntry
  NAV_VTOL_TAKEOFF(84u),
  /**
   * Land using VTOL mode
   *
   * index = 1; label = Land Options; 
   * Landing behaviour.
   *
   * index = 2; 
   * Empty
   *
   * index = 3; label = Approach Altitude; units = m; 
   * Approach altitude (with the same reference as the Altitude field). NaN if unspecified.
   *
   * index = 4; label = Yaw; units = deg; 
   * Yaw angle. NaN to use the current system yaw heading mode (e.g. yaw towards next waypoint, yaw
   * to home, etc.).
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; label = Ground Altitude; units = m; 
   * Altitude (ground level) relative to the current coordinate frame. NaN to use system default
   * landing altitude (ignore value).
   */
  @GeneratedMavEnumEntry
  NAV_VTOL_LAND(85u),
  /**
   * hand control over to an external controller
   *
   * index = 1; label = Enable; 
   * On / Off (> 0.5f on)
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  NAV_GUIDED_ENABLE(92u),
  /**
   * Delay the next navigation command a number of seconds or until a specified time
   *
   * index = 1; label = Delay; units = s; 
   * Delay (-1 to enable time-of-day fields)
   *
   * index = 2; label = Hour; 
   * hour (24h format, UTC, -1 to ignore)
   *
   * index = 3; label = Minute; 
   * minute (24h format, UTC, -1 to ignore)
   *
   * index = 4; label = Second; 
   * second (24h format, UTC, -1 to ignore)
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  NAV_DELAY(93u),
  /**
   * Descend and place payload. Vehicle moves to specified location, descends until it detects a
   * hanging payload has reached the ground, and then releases the payload. If ground is not detected
   * before the reaching the maximum descent value (param1), the command will complete without
   * releasing the payload.
   *
   * index = 1; label = Max Descent; units = m; 
   * Maximum distance to descend.
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude
   */
  @GeneratedMavEnumEntry
  NAV_PAYLOAD_PLACE(94u),
  /**
   * NOP - This command is only used to mark the upper limit of the NAV/ACTION commands in the
   * enumeration
   *
   * index = 1; 
   * Empty
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  NAV_LAST(95u),
  /**
   * Delay mission state machine.
   *
   * index = 1; label = Delay; units = s; 
   * Delay
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  CONDITION_DELAY(112u),
  /**
   * Ascend/descend to target altitude at specified rate. Delay mission state machine until desired
   * altitude reached.
   *
   * index = 1; label = Rate; units = m/s; 
   * Descent / Ascend rate.
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; label = Altitude; units = m; 
   * Target Altitude
   */
  @GeneratedMavEnumEntry
  CONDITION_CHANGE_ALT(113u),
  /**
   * Delay mission state machine until within desired distance of next NAV point.
   *
   * index = 1; label = Distance; units = m; 
   * Distance.
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  CONDITION_DISTANCE(114u),
  /**
   * Reach a certain target angle.
   *
   * index = 1; label = Angle; units = deg; 
   * target angle [0-360]. Absolute angles: 0 is north. Relative angle: 0 is initial yaw. Direction
   * set by param3.
   *
   * index = 2; label = Angular Speed; units = deg/s; 
   * angular speed
   *
   * index = 3; label = Direction; 
   * direction: -1: counter clockwise, 0: shortest direction, 1: clockwise
   *
   * index = 4; label = Relative; 
   * 0: absolute angle, 1: relative offset
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  CONDITION_YAW(115u),
  /**
   * NOP - This command is only used to mark the upper limit of the CONDITION commands in the
   * enumeration
   *
   * index = 1; 
   * Empty
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  CONDITION_LAST(159u),
  /**
   * Set system mode.
   *
   * index = 1; label = Mode; 
   * Mode
   *
   * index = 2; label = Custom Mode; 
   * Custom mode - this is system specific, please refer to the individual autopilot specifications
   * for details.
   *
   * index = 3; label = Custom Submode; 
   * Custom sub mode - this is system specific, please refer to the individual autopilot
   * specifications for details.
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_SET_MODE(176u),
  /**
   * Jump to the desired command in the mission list.  Repeat this action only the specified number
   * of times
   *
   * index = 1; label = Number; 
   * Sequence number
   *
   * index = 2; label = Repeat; 
   * Repeat count
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_JUMP(177u),
  /**
   * Change speed and/or throttle set points. The value persists until it is overridden or there is
   * a mode change
   *
   * index = 1; label = Speed Type; 
   * Speed type of value set in param2 (such as airspeed, ground speed, and so on)
   *
   * index = 2; label = Speed; units = m/s; 
   * Speed (-1 indicates no change, -2 indicates return to default vehicle speed)
   *
   * index = 3; label = Throttle; units = %; 
   * Throttle (-1 indicates no change, -2 indicates return to default vehicle throttle value)
   *
   * index = 4; index = 5; index = 6; index = 7; 
   */
  @GeneratedMavEnumEntry
  DO_CHANGE_SPEED(178u),
  /**
   *
   *           Sets the home position to either to the current position or a specified position.
   *           The home position is the default position that the system will return to and land on.
   *           The position is set automatically by the system during the takeoff (and may also be
   * set using this command).
   *           Note: the current home position may be emitted in a HOME_POSITION message on request
   * (using MAV_CMD_REQUEST_MESSAGE with param1=242).
   *         
   *
   * index = 1; label = Use Current; 
   * Use current (1=use current location, 0=use specified location)
   *
   * index = 2; label = Roll; units = deg; 
   * Roll angle (of surface). Range: -180..180 degrees. NAN or 0 means value not set. 0.01 indicates
   * zero roll.
   *
   * index = 3; label = Pitch; units = deg; 
   * Pitch angle (of surface). Range: -90..90 degrees. NAN or 0 means value not set. 0.01 means zero
   * pitch.
   *
   * index = 4; label = Yaw; units = deg; 
   * Yaw angle. NaN to use default heading. Range: -180..180 degrees.
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude
   */
  @GeneratedMavEnumEntry
  DO_SET_HOME(179u),
  /**
   * Set a system parameter.  Caution!  Use of this command requires knowledge of the numeric
   * enumeration value of the parameter.
   *
   * index = 1; label = Number; 
   * Parameter number
   *
   * index = 2; label = Value; 
   * Parameter value
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  DO_SET_PARAMETER(180u),
  /**
   * Set a relay to a condition.
   *
   * index = 1; label = Instance; 
   * Relay instance number.
   *
   * index = 2; label = Setting; 
   * Setting. (1=on, 0=off, others possible depending on system hardware)
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_SET_RELAY(181u),
  /**
   * Cycle a relay on and off for a desired number of cycles with a desired period.
   *
   * index = 1; label = Instance; 
   * Relay instance number.
   *
   * index = 2; label = Count; 
   * Cycle count.
   *
   * index = 3; label = Time; units = s; 
   * Cycle time.
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_REPEAT_RELAY(182u),
  /**
   * Set a servo to a desired PWM value.
   *
   * index = 1; label = Instance; 
   * Servo instance number.
   *
   * index = 2; label = PWM; units = us; 
   * Pulse Width Modulation.
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_SET_SERVO(183u),
  /**
   * Cycle a between its nominal setting and a desired PWM for a desired number of cycles with a
   * desired period.
   *
   * index = 1; label = Instance; 
   * Servo instance number.
   *
   * index = 2; label = PWM; units = us; 
   * Pulse Width Modulation.
   *
   * index = 3; label = Count; 
   * Cycle count.
   *
   * index = 4; label = Time; units = s; 
   * Cycle time.
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_REPEAT_SERVO(184u),
  /**
   * Terminate flight immediately.
   *           Flight termination immediately and irreversibly terminates the current flight,
   * returning the vehicle to ground.
   *           The vehicle will ignore RC or other input until it has been power-cycled.
   *           Termination may trigger safety measures, including: disabling motors and deployment
   * of parachute on multicopters, and setting flight surfaces to initiate a landing pattern on
   * fixed-wing).
   *           On multicopters without a parachute it may trigger a crash landing.
   *           Support for this command can be tested using the protocol bit:
   * MAV_PROTOCOL_CAPABILITY_FLIGHT_TERMINATION.
   *           Support for this command can also be tested by sending the command with param1=0 (<
   * 0.5); the ACK should be either MAV_RESULT_FAILED or MAV_RESULT_UNSUPPORTED.
   *         
   *
   * index = 1; label = Terminate; 
   * Flight termination activated if > 0.5. Otherwise not activated and ACK with MAV_RESULT_FAILED.
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_FLIGHTTERMINATION(185u),
  /**
   * Change altitude set point.
   *
   * index = 1; label = Altitude; units = m; 
   * Altitude.
   *
   * index = 2; label = Frame; 
   * Frame of new altitude.
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_CHANGE_ALTITUDE(186u),
  /**
   * Sets actuators (e.g. servos) to a desired value. The actuator numbers are mapped to specific
   * outputs (e.g. on any MAIN or AUX PWM or UAVCAN) using a flight-stack specific mechanism (i.e. a
   * parameter).
   *
   * index = 1; label = Actuator 1; 
   * Actuator 1 value, scaled from [-1 to 1]. NaN to ignore.
   *
   * index = 2; label = Actuator 2; 
   * Actuator 2 value, scaled from [-1 to 1]. NaN to ignore.
   *
   * index = 3; label = Actuator 3; 
   * Actuator 3 value, scaled from [-1 to 1]. NaN to ignore.
   *
   * index = 4; label = Actuator 4; 
   * Actuator 4 value, scaled from [-1 to 1]. NaN to ignore.
   *
   * index = 5; label = Actuator 5; 
   * Actuator 5 value, scaled from [-1 to 1]. NaN to ignore.
   *
   * index = 6; label = Actuator 6; 
   * Actuator 6 value, scaled from [-1 to 1]. NaN to ignore.
   *
   * index = 7; label = Index; 
   * Index of actuator set (i.e if set to 1, Actuator 1 becomes Actuator 7)
   */
  @GeneratedMavEnumEntry
  DO_SET_ACTUATOR(187u),
  /**
   * Mission item to specify the start of a failsafe/landing return-path segment (the end of the
   * segment is the next MAV_CMD_DO_LAND_START item).
   *           A vehicle that is using missions for landing (e.g. in a return mode) will join the
   * mission on the closest path of the return-path segment (instead of MAV_CMD_DO_LAND_START or the
   * nearest waypoint).
   *           The main use case is to minimize the failsafe flight path in corridor missions, where
   * the inbound/outbound paths are constrained (by geofences) to the same particular path.
   *           The MAV_CMD_NAV_RETURN_PATH_START would be placed at the start of the return path.
   *           If a failsafe occurs on the outbound path the vehicle will move to the nearest point
   * on the return path (which is parallel for this kind of mission), effectively turning round and
   * following the shortest path to landing.
   *           If a failsafe occurs on the inbound path the vehicle is already on the return segment
   * and will continue to landing.
   *           The Latitude/Longitude/Altitude are optional, and may be set to 0 if not needed.
   *           If specified, the item defines the waypoint at which the return segment starts.
   *           If sent using as a command, the vehicle will perform a mission landing (using the
   * land segment if defined) or reject the command if mission landings are not supported, or no
   * mission landing is defined. When used as a command any position information in the command is
   * ignored.
   *         
   *
   * index = 1; 
   * Empty
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; label = Latitude; 
   * Latitudee. 0: not used.
   *
   * index = 6; label = Longitude; 
   * Longitudee. 0: not used.
   *
   * index = 7; label = Altitude; units = m; 
   * Altitudee. 0: not used.
   */
  @WorkInProgress
  @GeneratedMavEnumEntry
  DO_RETURN_PATH_START(188u),
  /**
   * Mission command to perform a landing. This is used as a marker in a mission to tell the
   * autopilot where a sequence of mission items that represents a landing starts.
   * 	  It may also be sent via a COMMAND_LONG to trigger a landing, in which case the nearest
   * (geographically) landing sequence in the mission will be used.
   * 	  The Latitude/Longitude/Altitude is optional, and may be set to 0 if not needed. If specified
   * then it will be used to help find the closest landing sequence.
   * 	
   *
   * index = 1; 
   * Empty
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude
   */
  @GeneratedMavEnumEntry
  DO_LAND_START(189u),
  /**
   * Mission command to perform a landing from a rally point.
   *
   * index = 1; label = Altitude; units = m; 
   * Break altitude
   *
   * index = 2; label = Speed; units = m/s; 
   * Landing speed
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_RALLY_LAND(190u),
  /**
   * Mission command to safely abort an autonomous landing.
   *
   * index = 1; label = Altitude; units = m; 
   * Altitude
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_GO_AROUND(191u),
  /**
   * Reposition the vehicle to a specific WGS84 global position. This command is intended for guided
   * commands (for missions use MAV_CMD_NAV_WAYPOINT instead).
   *
   * index = 1; label = Speed; units = m/s; 
   * Ground speed, less than 0 (-1) for default
   *
   * index = 2; label = Bitmask; 
   * Bitmask of option flags.
   *
   * index = 3; label = Radius; units = m; 
   * Loiter radius for planes. Positive values only, direction is controlled by Yaw value. A value
   * of zero or NaN is ignored. 
   *
   * index = 4; label = Yaw; units = deg; 
   * Yaw heading. NaN to use the current system yaw heading mode (e.g. yaw towards next waypoint,
   * yaw to home, etc.). For planes indicates loiter direction (0: clockwise, 1: counter clockwise)
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude
   */
  @GeneratedMavEnumEntry
  DO_REPOSITION(192u),
  /**
   * If in a GPS controlled position mode, hold the current position or continue.
   *
   * index = 1; label = Continue; 
   * 0: Pause current mission or reposition command, hold current position. 1: Continue mission. A
   * VTOL capable vehicle should enter hover mode (multicopter and VTOL planes). A plane should loiter
   * with the default loiter radius.
   *
   * index = 2; 
   * Reserved
   *
   * index = 3; 
   * Reserved
   *
   * index = 4; 
   * Reserved
   *
   * index = 5; 
   * Reserved
   *
   * index = 6; 
   * Reserved
   *
   * index = 7; 
   * Reserved
   */
  @GeneratedMavEnumEntry
  DO_PAUSE_CONTINUE(193u),
  /**
   * Set moving direction to forward or reverse.
   *
   * index = 1; label = Reverse; 
   * Direction (0=Forward, 1=Reverse)
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_SET_REVERSE(194u),
  /**
   * Sets the region of interest (ROI) to a location. This can then be used by the vehicle's control
   * system to control the vehicle attitude and the attitude of various sensors such as cameras. This
   * command can be sent to a gimbal manager but not to a gimbal device. A gimbal is not to react to
   * this message.
   *
   * index = 1; label = Gimbal device ID; 
   * Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal
   * device components. Send command multiple times for more than one gimbal (but not all gimbals).
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; label = Latitude; units = degE7; 
   * Latitude of ROI location
   *
   * index = 6; label = Longitude; units = degE7; 
   * Longitude of ROI location
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude of ROI location
   */
  @GeneratedMavEnumEntry
  DO_SET_ROI_LOCATION(195u),
  /**
   * Sets the region of interest (ROI) to be toward next waypoint, with optional pitch/roll/yaw
   * offset. This can then be used by the vehicle's control system to control the vehicle attitude and
   * the attitude of various sensors such as cameras. This command can be sent to a gimbal manager but
   * not to a gimbal device. A gimbal device is not to react to this message.
   *
   * index = 1; label = Gimbal device ID; 
   * Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal
   * device components. Send command multiple times for more than one gimbal (but not all gimbals).
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; label = Pitch Offset; units = deg; 
   * Pitch offset from next waypoint, positive pitching up
   *
   * index = 6; label = Roll Offset; units = deg; 
   * Roll offset from next waypoint, positive rolling to the right
   *
   * index = 7; label = Yaw Offset; units = deg; 
   * Yaw offset from next waypoint, positive yawing to the right
   */
  @GeneratedMavEnumEntry
  DO_SET_ROI_WPNEXT_OFFSET(196u),
  /**
   * Cancels any previous ROI command returning the vehicle/sensors to default flight
   * characteristics. This can then be used by the vehicle's control system to control the vehicle
   * attitude and the attitude of various sensors such as cameras. This command can be sent to a gimbal
   * manager but not to a gimbal device. A gimbal device is not to react to this message. After this
   * command the gimbal manager should go back to manual input if available, and otherwise assume a
   * neutral position.
   *
   * index = 1; label = Gimbal device ID; 
   * Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal
   * device components. Send command multiple times for more than one gimbal (but not all gimbals).
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_SET_ROI_NONE(197u),
  /**
   * Mount tracks system with specified system ID. Determination of target vehicle position may be
   * done with GLOBAL_POSITION_INT or any other means. This command can be sent to a gimbal manager but
   * not to a gimbal device. A gimbal device is not to react to this message.
   *
   * index = 1; label = System ID; 
   * System ID
   *
   * index = 2; label = Gimbal device ID; 
   * Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal
   * device components. Send command multiple times for more than one gimbal (but not all gimbals).
   */
  @GeneratedMavEnumEntry
  DO_SET_ROI_SYSID(198u),
  /**
   * Control onboard camera system.
   *
   * index = 1; label = ID; 
   * Camera ID (-1 for all)
   *
   * index = 2; label = Transmission; 
   * Transmission: 0: disabled, 1: enabled compressed, 2: enabled raw
   *
   * index = 3; label = Interval; units = s; 
   * Transmission mode: 0: video stream, >0: single images every n seconds
   *
   * index = 4; label = Recording; 
   * Recording: 0: disabled, 1: enabled compressed, 2: enabled raw
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_CONTROL_VIDEO(200u),
  /**
   * Sets the region of interest (ROI) for a sensor set or the vehicle itself. This can then be used
   * by the vehicle's control system to control the vehicle attitude and the attitude of various
   * sensors such as cameras.
   *
   * index = 1; label = ROI Mode; 
   * Region of interest mode.
   *
   * index = 2; label = WP Index; 
   * Waypoint index/ target ID (depends on param 1).
   *
   * index = 3; label = ROI Index; 
   * Region of interest index. (allows a vehicle to manage multiple ROI's)
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * MAV_ROI_WPNEXT: pitch offset from next waypoint, MAV_ROI_LOCATION: latitude
   *
   * index = 6; 
   * MAV_ROI_WPNEXT: roll offset from next waypoint, MAV_ROI_LOCATION: longitude
   *
   * index = 7; 
   * MAV_ROI_WPNEXT: yaw offset from next waypoint, MAV_ROI_LOCATION: altitude
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  DO_SET_ROI(201u),
  /**
   * Configure digital camera. This is a fallback message for systems that have not yet implemented
   * PARAM_EXT_XXX messages and camera definition files (see
   * https://mavlink.io/en/services/camera_def.html ).
   *
   * index = 1; label = Mode; 
   * Modes: P, TV, AV, M, Etc.
   *
   * index = 2; label = Shutter Speed; 
   * Shutter speed: Divisor number for one second.
   *
   * index = 3; label = Aperture; 
   * Aperture: F stop number.
   *
   * index = 4; label = ISO; 
   * ISO number e.g. 80, 100, 200, Etc.
   *
   * index = 5; label = Exposure; 
   * Exposure type enumerator.
   *
   * index = 6; label = Command Identity; 
   * Command Identity.
   *
   * index = 7; label = Engine Cut-off; units = ds; 
   * Main engine cut-off time before camera trigger. (0 means no cut-off)
   */
  @GeneratedMavEnumEntry
  DO_DIGICAM_CONFIGURE(202u),
  /**
   * Control digital camera. This is a fallback message for systems that have not yet implemented
   * PARAM_EXT_XXX messages and camera definition files (see
   * https://mavlink.io/en/services/camera_def.html ).
   *
   * index = 1; label = Session Control; 
   * Session control e.g. show/hide lens
   *
   * index = 2; label = Zoom Absolute; 
   * Zoom's absolute position
   *
   * index = 3; label = Zoom Relative; 
   * Zooming step value to offset zoom from the current position
   *
   * index = 4; label = Focus; 
   * Focus Locking, Unlocking or Re-locking
   *
   * index = 5; label = Shoot Command; 
   * Shooting Command
   *
   * index = 6; label = Command Identity; 
   * Command Identity
   *
   * index = 7; label = Shot ID; 
   * Test shot identifier. If set to 1, image will only be captured, but not counted towards
   * internal frame count.
   */
  @GeneratedMavEnumEntry
  DO_DIGICAM_CONTROL(203u),
  /**
   * Mission command to configure a camera or antenna mount
   *
   * index = 1; label = Mode; 
   * Mount operation mode
   *
   * index = 2; label = Stabilize Roll; 
   * stabilize roll? (1 = yes, 0 = no)
   *
   * index = 3; label = Stabilize Pitch; 
   * stabilize pitch? (1 = yes, 0 = no)
   *
   * index = 4; label = Stabilize Yaw; 
   * stabilize yaw? (1 = yes, 0 = no)
   *
   * index = 5; label = Roll Input Mode; 
   * roll input (0 = angle body frame, 1 = angular rate, 2 = angle absolute frame)
   *
   * index = 6; label = Pitch Input Mode; 
   * pitch input (0 = angle body frame, 1 = angular rate, 2 = angle absolute frame)
   *
   * index = 7; label = Yaw Input Mode; 
   * yaw input (0 = angle body frame, 1 = angular rate, 2 = angle absolute frame)
   */
  @Deprecated(message =
      "This message has been superseded by MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE. The message can still be used to communicate with legacy gimbals implementing it.")
  @GeneratedMavEnumEntry
  DO_MOUNT_CONFIGURE(204u),
  /**
   * Mission command to control a camera or antenna mount
   *
   * index = 1; label = Pitch; 
   * pitch depending on mount mode (degrees or degrees/second depending on pitch input).
   *
   * index = 2; label = Roll; 
   * roll depending on mount mode (degrees or degrees/second depending on roll input).
   *
   * index = 3; label = Yaw; 
   * yaw depending on mount mode (degrees or degrees/second depending on yaw input).
   *
   * index = 4; label = Altitude; units = m; 
   * altitude depending on mount mode.
   *
   * index = 5; label = Latitude; 
   * latitude, set if appropriate mount mode.
   *
   * index = 6; label = Longitude; 
   * longitude, set if appropriate mount mode.
   *
   * index = 7; label = Mode; 
   * Mount mode.
   */
  @Deprecated(message =
      "This message is ambiguous and inconsistent. It has been superseded by MAV_CMD_DO_GIMBAL_MANAGER_PITCHYAW and MAV_CMD_DO_SET_ROI_*. The message can still be used to communicate with legacy gimbals implementing it.")
  @GeneratedMavEnumEntry
  DO_MOUNT_CONTROL(205u),
  /**
   * Mission command to set camera trigger distance for this flight. The camera is triggered each
   * time this distance is exceeded. This command can also be used to set the shutter integration time
   * for the camera.
   *
   * index = 1; label = Distance; units = m; 
   * Camera trigger distance. 0 to stop triggering.
   *
   * index = 2; label = Shutter; units = ms; 
   * Camera shutter integration time. -1 or 0 to ignore
   *
   * index = 3; label = Trigger; 
   * Trigger camera once immediately. (0 = no trigger, 1 = trigger)
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_SET_CAM_TRIGG_DIST(206u),
  /**
   *
   *           Enable the geofence.
   *           This can be used in a mission or via the command protocol.
   *           The persistence/lifetime of the setting is undefined.
   *           Depending on flight stack implementation it may persist until superseded, or it may
   * revert to a system default at the end of a mission.
   *           Flight stacks typically reset the setting to system defaults on reboot.
   * 	
   *
   * index = 1; label = Enable; 
   * enable? (0=disable, 1=enable, 2=disable_floor_only)
   *
   * index = 2; label = Types; 
   * Fence types to enable or disable as a bitmask. A value of 0 indicates that all fences should be
   * enabled or disabled. This parameter is ignored if param 1 has the value 2
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_FENCE_ENABLE(207u),
  /**
   * Mission item/command to release a parachute or enable/disable auto release.
   *
   * index = 1; label = Action; 
   * Action
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_PARACHUTE(208u),
  /**
   * Command to perform motor test.
   *
   * index = 1; label = Instance; 
   * Motor instance number (from 1 to max number of motors on the vehicle).
   *
   * index = 2; label = Throttle Type; 
   * Throttle type (whether the Throttle Value in param3 is a percentage, PWM value, etc.)
   *
   * index = 3; label = Throttle; 
   * Throttle value.
   *
   * index = 4; label = Timeout; units = s; 
   * Timeout between tests that are run in sequence.
   *
   * index = 5; label = Motor Count; 
   * Motor count. Number of motors to test in sequence: 0/1=one motor, 2= two motors, etc. The
   * Timeout (param4) is used between tests.
   *
   * index = 6; label = Test Order; 
   * Motor test order.
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_MOTOR_TEST(209u),
  /**
   * Change to/from inverted flight.
   *
   * index = 1; label = Inverted; 
   * Inverted flight. (0=normal, 1=inverted)
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_INVERTED_FLIGHT(210u),
  /**
   * Mission command to operate a gripper.
   *
   * index = 1; label = Instance; 
   * Gripper instance number.
   *
   * index = 2; label = Action; 
   * Gripper action to perform.
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_GRIPPER(211u),
  /**
   * Enable/disable autotune.
   *
   * index = 1; label = Enable; 
   * Enable (1: enable, 0:disable).
   *
   * index = 2; label = Axis; 
   * Specify which axis are autotuned. 0 indicates autopilot default settings.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  @GeneratedMavEnumEntry
  DO_AUTOTUNE_ENABLE(212u),
  /**
   * Sets a desired vehicle turn angle and speed change.
   *
   * index = 1; label = Yaw; units = deg; 
   * Yaw angle to adjust steering by.
   *
   * index = 2; label = Speed; units = m/s; 
   * Speed.
   *
   * index = 3; label = Angle; 
   * Final angle. (0=absolute, 1=relative)
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  NAV_SET_YAW_SPEED(213u),
  /**
   * Mission command to set camera trigger interval for this flight. If triggering is enabled, the
   * camera is triggered each time this interval expires. This command can also be used to set the
   * shutter integration time for the camera.
   *
   * index = 1; label = Trigger Cycle; units = ms; 
   * Camera trigger cycle time. -1 or 0 to ignore.
   *
   * index = 2; label = Shutter Integration; units = ms; 
   * Camera shutter integration time. Should be less than trigger cycle time. -1 or 0 to ignore.
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_SET_CAM_TRIGG_INTERVAL(214u),
  /**
   * Mission command to control a camera or antenna mount, using a quaternion as reference.
   *
   * index = 1; label = Q1; 
   * quaternion param q1, w (1 in null-rotation)
   *
   * index = 2; label = Q2; 
   * quaternion param q2, x (0 in null-rotation)
   *
   * index = 3; label = Q3; 
   * quaternion param q3, y (0 in null-rotation)
   *
   * index = 4; label = Q4; 
   * quaternion param q4, z (0 in null-rotation)
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  DO_MOUNT_CONTROL_QUAT(220u),
  /**
   * set id of master controller
   *
   * index = 1; label = System ID; 
   * System ID
   *
   * index = 2; label = Component ID; 
   * Component ID
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_GUIDED_MASTER(221u),
  /**
   * Set limits for external control
   *
   * index = 1; label = Timeout; units = s; 
   * Timeout - maximum time that external controller will be allowed to control vehicle. 0 means no
   * timeout.
   *
   * index = 2; label = Min Altitude; units = m; 
   * Altitude (MSL) min - if vehicle moves below this alt, the command will be aborted and the
   * mission will continue. 0 means no lower altitude limit.
   *
   * index = 3; label = Max Altitude; units = m; 
   * Altitude (MSL) max - if vehicle moves above this alt, the command will be aborted and the
   * mission will continue. 0 means no upper altitude limit.
   *
   * index = 4; label = Horiz. Move Limit; units = m; 
   * Horizontal move limit - if vehicle moves more than this distance from its location at the
   * moment the command was executed, the command will be aborted and the mission will continue. 0
   * means no horizontal move limit.
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_GUIDED_LIMITS(222u),
  /**
   * Control vehicle engine. This is interpreted by the vehicles engine controller to change the
   * target engine state. It is intended for vehicles with internal combustion engines
   *
   * index = 1; label = Start Engine; 
   * 0: Stop engine, 1:Start Engine
   *
   * index = 2; label = Cold Start; 
   * 0: Warm start, 1:Cold start. Controls use of choke where applicable
   *
   * index = 3; label = Height Delay; units = m; 
   * Height delay. This is for commanding engine start only after the vehicle has gained the
   * specified height. Used in VTOL vehicles during takeoff to start engine after the aircraft is off
   * the ground. Zero for no delay.
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_ENGINE_CONTROL(223u),
  /**
   *
   *           Set the mission item with sequence number seq as the current item and emit
   * MISSION_CURRENT (whether or not the mission number changed).
   *           If a mission is currently being executed, the system will continue to this new
   * mission item on the shortest path, skipping any intermediate mission items.
   * 	  Note that mission jump repeat counters are not reset unless param2 is set (see
   * MAV_CMD_DO_JUMP param2).
   *
   *           This command may trigger a mission state-machine change on some systems: for example
   * from MISSION_STATE_NOT_STARTED or MISSION_STATE_PAUSED to MISSION_STATE_ACTIVE.
   *           If the system is in mission mode, on those systems this command might therefore
   * start, restart or resume the mission.
   *           If the system is not in mission mode this command must not trigger a switch to
   * mission mode.
   *
   *           The mission may be "reset" using param2.
   *           Resetting sets jump counters to initial values (to reset counters without changing
   * the current mission item set the param1 to `-1`).
   *           Resetting also explicitly changes a mission state of MISSION_STATE_COMPLETE to
   * MISSION_STATE_PAUSED or MISSION_STATE_ACTIVE, potentially allowing it to resume when it is (next)
   * in a mission mode.
   *
   * 	  The command will ACK with MAV_RESULT_FAILED if the sequence number is out of range
   * (including if there is no mission item).
   *         
   *
   * index = 1; label = Number; 
   * Mission sequence value to set. -1 for the current mission item (use to reset mission without
   * changing current mission item).
   *
   * index = 2; label = Reset Mission; 
   * Resets mission. 1: true, 0: false. Resets jump counters to initial values and changes mission
   * state "completed" to be "active" or "paused".
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_SET_MISSION_CURRENT(224u),
  /**
   * NOP - This command is only used to mark the upper limit of the DO commands in the enumeration
   *
   * index = 1; 
   * Empty
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  DO_LAST(240u),
  /**
   * Trigger calibration. This command will be only accepted if in pre-flight mode. Except for
   * Temperature Calibration, only one sensor should be set in a single message and all others should
   * be zero.
   *
   * index = 1; label = Gyro Temperature; 
   * 1: gyro calibration, 3: gyro temperature calibration
   *
   * index = 2; label = Magnetometer; 
   * 1: magnetometer calibration
   *
   * index = 3; label = Ground Pressure; 
   * 1: ground pressure calibration
   *
   * index = 4; label = Remote Control; 
   * 1: radio RC calibration, 2: RC trim calibration
   *
   * index = 5; label = Accelerometer; 
   * 1: accelerometer calibration, 2: board level calibration, 3: accelerometer temperature
   * calibration, 4: simple accelerometer calibration
   *
   * index = 6; label = Compmot or Airspeed; 
   * 1: APM: compass/motor interference calibration (PX4: airspeed calibration, deprecated), 2:
   * airspeed calibration
   *
   * index = 7; label = ESC or Baro; 
   * 1: ESC calibration, 3: barometer temperature calibration
   */
  @GeneratedMavEnumEntry
  PREFLIGHT_CALIBRATION(241u),
  /**
   * Set sensor offsets. This command will be only accepted if in pre-flight mode.
   *
   * index = 1; label = Sensor Type; 
   * Sensor to adjust the offsets for: 0: gyros, 1: accelerometer, 2: magnetometer, 3: barometer, 4:
   * optical flow, 5: second magnetometer, 6: third magnetometer
   *
   * index = 2; label = X Offset; 
   * X axis offset (or generic dimension 1), in the sensor's raw units
   *
   * index = 3; label = Y Offset; 
   * Y axis offset (or generic dimension 2), in the sensor's raw units
   *
   * index = 4; label = Z Offset; 
   * Z axis offset (or generic dimension 3), in the sensor's raw units
   *
   * index = 5; label = 4th Dimension; 
   * Generic dimension 4, in the sensor's raw units
   *
   * index = 6; label = 5th Dimension; 
   * Generic dimension 5, in the sensor's raw units
   *
   * index = 7; label = 6th Dimension; 
   * Generic dimension 6, in the sensor's raw units
   */
  @GeneratedMavEnumEntry
  PREFLIGHT_SET_SENSOR_OFFSETS(242u),
  /**
   * Trigger UAVCAN configuration (actuator ID assignment and direction mapping). Note that this
   * maps to the legacy UAVCAN v0 function UAVCAN_ENUMERATE, which is intended to be executed just once
   * during initial vehicle configuration (it is not a normal pre-flight command and has been poorly
   * named).
   *
   * index = 1; label = Actuator ID; 
   * 1: Trigger actuator ID assignment and direction mapping. 0: Cancel command.
   *
   * index = 2; 
   * Reserved
   *
   * index = 3; 
   * Reserved
   *
   * index = 4; 
   * Reserved
   *
   * index = 5; 
   * Reserved
   *
   * index = 6; 
   * Reserved
   *
   * index = 7; 
   * Reserved
   */
  @GeneratedMavEnumEntry
  PREFLIGHT_UAVCAN(243u),
  /**
   * Request storage of different parameter values and logs. This command will be only accepted if
   * in pre-flight mode.
   *
   * index = 1; label = Parameter Storage; 
   * Action to perform on the persistent parameter storage
   *
   * index = 2; label = Mission Storage; 
   * Action to perform on the persistent mission storage
   *
   * index = 3; label = Logging Rate; units = Hz; 
   * Onboard logging: 0: Ignore, 1: Start default rate logging, -1: Stop logging, > 1: logging rate
   * (e.g. set to 1000 for 1000 Hz logging)
   *
   * index = 4; 
   * Reserved
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  PREFLIGHT_STORAGE(245u),
  /**
   * Request the reboot or shutdown of system components.
   *
   * index = 1; label = Autopilot; 
   * 0: Do nothing for autopilot, 1: Reboot autopilot, 2: Shutdown autopilot, 3: Reboot autopilot
   * and keep it in the bootloader until upgraded.
   *
   * index = 2; label = Companion; 
   * 0: Do nothing for onboard computer, 1: Reboot onboard computer, 2: Shutdown onboard computer,
   * 3: Reboot onboard computer and keep it in the bootloader until upgraded.
   *
   * index = 3; label = Component action; 
   * 0: Do nothing for component, 1: Reboot component, 2: Shutdown component, 3: Reboot component
   * and keep it in the bootloader until upgraded
   *
   * index = 4; label = Component ID; 
   * MAVLink Component ID targeted in param3 (0 for all components).
   *
   * index = 5; 
   * Reserved (set to 0)
   *
   * index = 6; 
   * Reserved (set to 0)
   *
   * index = 7; 
   * WIP: ID (e.g. camera ID -1 for all IDs)
   */
  @GeneratedMavEnumEntry
  PREFLIGHT_REBOOT_SHUTDOWN(246u),
  /**
   * Override current mission with command to pause mission, pause mission and move to position,
   * continue/resume mission. When param 1 indicates that the mission is paused (MAV_GOTO_DO_HOLD),
   * param 2 defines whether it holds in place or moves to another position.
   *
   * index = 1; label = Continue; 
   * MAV_GOTO_DO_HOLD: pause mission and either hold or move to specified position (depending on
   * param2), MAV_GOTO_DO_CONTINUE: resume mission.
   *
   * index = 2; label = Position; 
   * MAV_GOTO_HOLD_AT_CURRENT_POSITION: hold at current position,
   * MAV_GOTO_HOLD_AT_SPECIFIED_POSITION: hold at specified position.
   *
   * index = 3; label = Frame; 
   * Coordinate frame of hold point.
   *
   * index = 4; label = Yaw; units = deg; 
   * Desired yaw angle.
   *
   * index = 5; label = Latitude/X; 
   * Latitude/X position.
   *
   * index = 6; label = Longitude/Y; 
   * Longitude/Y position.
   *
   * index = 7; label = Altitude/Z; 
   * Altitude/Z position.
   */
  @GeneratedMavEnumEntry
  OVERRIDE_GOTO(252u),
  /**
   * Mission command to set a Camera Auto Mount Pivoting Oblique Survey (Replaces CAM_TRIGG_DIST for
   * this purpose). The camera is triggered each time this distance is exceeded, then the mount moves
   * to the next position. Params 4~6 set-up the angle limits and number of positions for oblique
   * survey, where mount-enabled vehicles automatically roll the camera between shots to emulate an
   * oblique camera setup (providing an increased HFOV). This command can also be used to set the
   * shutter integration time for the camera.
   *
   * index = 1; label = Distance; units = m; 
   * Camera trigger distance. 0 to stop triggering.
   *
   * index = 2; label = Shutter; units = ms; 
   * Camera shutter integration time. 0 to ignore
   *
   * index = 3; label = Min Interval; units = ms; 
   * The minimum interval in which the camera is capable of taking subsequent pictures repeatedly. 0
   * to ignore.
   *
   * index = 4; label = Positions; 
   * Total number of roll positions at which the camera will capture photos (images captures spread
   * evenly across the limits defined by param5).
   *
   * index = 5; label = Roll Angle; units = deg; 
   * Angle limits that the camera can be rolled to left and right of center.
   *
   * index = 6; label = Pitch Angle; units = deg; 
   * Fixed pitch angle that the camera will hold in oblique mode if the mount is actuated in the
   * pitch axis.
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  OBLIQUE_SURVEY(260u),
  /**
   * start running a mission
   *
   * index = 1; label = First Item; 
   * first_item: the first mission item to run
   *
   * index = 2; label = Last Item; 
   * last_item:  the last mission item to run (after this item is run, the mission ends)
   */
  @GeneratedMavEnumEntry
  MISSION_START(300u),
  /**
   * Actuator testing command. This is similar to MAV_CMD_DO_MOTOR_TEST but operates on the level of
   * output functions, i.e. it is possible to test Motor1 independent from which output it is
   * configured on. Autopilots typically refuse this command while armed.
   *
   * index = 1; label = Value; 
   * Output value: 1 means maximum positive output, 0 to center servos or minimum motor thrust
   * (expected to spin), -1 for maximum negative (if not supported by the motors, i.e. motor is not
   * reversible, smaller than 0 maps to NaN). And NaN maps to disarmed (stop the motors).
   *
   * index = 2; label = Timeout; units = s; 
   * Timeout after which the test command expires and the output is restored to the previous value.
   * A timeout has to be set for safety reasons. A timeout of 0 means to restore the previous value
   * immediately.
   *
   * index = 3; index = 4; index = 5; label = Output Function; 
   * Actuator Output function
   *
   * index = 6; index = 7; 
   */
  @GeneratedMavEnumEntry
  ACTUATOR_TEST(310u),
  /**
   * Actuator configuration command.
   *
   * index = 1; label = Configuration; 
   * Actuator configuration action
   *
   * index = 2; index = 3; index = 4; index = 5; label = Output Function; 
   * Actuator Output function
   *
   * index = 6; index = 7; 
   */
  @GeneratedMavEnumEntry
  CONFIGURE_ACTUATOR(311u),
  /**
   * Arms / Disarms a component
   *
   * index = 1; label = Arm; 
   * 0: disarm, 1: arm
   *
   * index = 2; label = Force; 
   * 0: arm-disarm unless prevented by safety checks (i.e. when landed), 21196: force
   * arming/disarming (e.g. allow arming to override preflight checks and disarming in flight)
   */
  @GeneratedMavEnumEntry
  COMPONENT_ARM_DISARM(400u),
  /**
   * Instructs a target system to run pre-arm checks.
   *           This allows preflight checks to be run on demand, which may be useful on systems that
   * normally run them at low rate, or which do not trigger checks when the armable state might have
   * changed.
   *           This command should return MAV_RESULT_ACCEPTED if it will run the checks.
   *           The results of the checks are usually then reported in SYS_STATUS messages (this is
   * system-specific).
   *           The command should return MAV_RESULT_TEMPORARILY_REJECTED if the system is already
   * armed.
   *         
   */
  @GeneratedMavEnumEntry
  RUN_PREARM_CHECKS(401u),
  /**
   * Turns illuminators ON/OFF. An illuminator is a light source that is used for lighting up dark
   * areas external to the system: e.g. a torch or searchlight (as opposed to a light source for
   * illuminating the system itself, e.g. an indicator light).
   *
   * index = 1; label = Enable; 
   * 0: Illuminators OFF, 1: Illuminators ON
   */
  @GeneratedMavEnumEntry
  ILLUMINATOR_ON_OFF(405u),
  /**
   * Configures illuminator settings. An illuminator is a light source that is used for lighting up
   * dark areas external to the system: e.g. a torch or searchlight (as opposed to a light source for
   * illuminating the system itself, e.g. an indicator light).
   *
   * index = 1; label = Mode; 
   * Mode
   *
   * index = 2; label = Brightness; units = %; 
   * 0%: Off, 100%: Max Brightness
   *
   * index = 3; label = Strobe Period; units = s; 
   * Strobe period in seconds where 0 means strobing is not used
   *
   * index = 4; label = Strobe Duty; units = %; 
   * Strobe duty cycle where 100% means it is on constantly and 0 means strobing is not used
   */
  @GeneratedMavEnumEntry
  DO_ILLUMINATOR_CONFIGURE(406u),
  /**
   * Request the home position from the vehicle.
   * 	  The vehicle will ACK the command and then emit the HOME_POSITION message.
   *
   * index = 1; 
   * Reserved
   *
   * index = 2; 
   * Reserved
   *
   * index = 3; 
   * Reserved
   *
   * index = 4; 
   * Reserved
   *
   * index = 5; 
   * Reserved
   *
   * index = 6; 
   * Reserved
   *
   * index = 7; 
   * Reserved
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  GET_HOME_POSITION(410u),
  /**
   * Inject artificial failure for testing purposes. Note that autopilots should implement an
   * additional protection before accepting this command such as a specific param setting.
   *
   * index = 1; label = Failure unit; 
   * The unit which is affected by the failure.
   *
   * index = 2; label = Failure type; 
   * The type how the failure manifests itself.
   *
   * index = 3; label = Instance; 
   * Instance affected by failure (0 to signal all).
   */
  @GeneratedMavEnumEntry
  INJECT_FAILURE(420u),
  /**
   * Starts receiver pairing.
   *
   * index = 1; label = Spektrum; 
   * 0:Spektrum.
   *
   * index = 2; label = RC Type; 
   * RC type.
   */
  @GeneratedMavEnumEntry
  START_RX_PAIR(500u),
  /**
   *
   *           Request the interval between messages for a particular MAVLink message ID.
   *           The receiver should ACK the command and then emit its response in a MESSAGE_INTERVAL
   * message.
   *         
   *
   * index = 1; label = Message ID; 
   * The MAVLink message ID
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  GET_MESSAGE_INTERVAL(510u),
  /**
   * Set the interval between messages for a particular MAVLink message ID. This interface replaces
   * REQUEST_DATA_STREAM.
   *
   * index = 1; label = Message ID; 
   * The MAVLink message ID
   *
   * index = 2; label = Interval; units = us; 
   * The interval between two messages. -1: disable. 0: request default rate (which may be zero).
   *
   * index = 7; label = Response Target; 
   * Target address of message stream (if message has target address fields). 0: Flight-stack
   * default (recommended), 1: address of requestor, 2: broadcast.
   */
  @GeneratedMavEnumEntry
  SET_MESSAGE_INTERVAL(511u),
  /**
   * Request the target system(s) emit a single instance of a specified message (i.e. a "one-shot"
   * version of MAV_CMD_SET_MESSAGE_INTERVAL).
   *
   * index = 1; label = Message ID; 
   * The MAVLink message ID of the requested message.
   *
   * index = 2; label = Req Param 1; 
   * Use for index ID, if required. Otherwise, the use of this parameter (if any) must be defined in
   * the requested message. By default assumed not used (0).
   *
   * index = 3; label = Req Param 2; 
   * The use of this parameter (if any), must be defined in the requested message. By default
   * assumed not used (0).
   *
   * index = 4; label = Req Param 3; 
   * The use of this parameter (if any), must be defined in the requested message. By default
   * assumed not used (0).
   *
   * index = 5; label = Req Param 4; 
   * The use of this parameter (if any), must be defined in the requested message. By default
   * assumed not used (0).
   *
   * index = 6; label = Req Param 5; 
   * The use of this parameter (if any), must be defined in the requested message. By default
   * assumed not used (0).
   *
   * index = 7; label = Response Target; 
   * Target address for requested message (if message has target address fields). 0: Flight-stack
   * default, 1: address of requestor, 2: broadcast.
   */
  @GeneratedMavEnumEntry
  REQUEST_MESSAGE(512u),
  /**
   * Request MAVLink protocol version compatibility. All receivers should ACK the command and then
   * emit their capabilities in an PROTOCOL_VERSION message
   *
   * index = 1; label = Protocol; 
   * 1: Request supported protocol versions by all nodes on the network
   *
   * index = 2; 
   * Reserved (all remaining params)
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  REQUEST_PROTOCOL_VERSION(519u),
  /**
   * Request autopilot capabilities. The receiver should ACK the command and then emit its
   * capabilities in an AUTOPILOT_VERSION message
   *
   * index = 1; label = Version; 
   * 1: Request autopilot version
   *
   * index = 2; 
   * Reserved (all remaining params)
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  REQUEST_AUTOPILOT_CAPABILITIES(520u),
  /**
   * Request camera information (CAMERA_INFORMATION).
   *
   * index = 1; label = Capabilities; 
   * 0: No action 1: Request camera capabilities
   *
   * index = 2; 
   * Reserved (all remaining params)
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  REQUEST_CAMERA_INFORMATION(521u),
  /**
   * Request camera settings (CAMERA_SETTINGS).
   *
   * index = 1; label = Settings; 
   * 0: No Action 1: Request camera settings
   *
   * index = 2; 
   * Reserved (all remaining params)
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  REQUEST_CAMERA_SETTINGS(522u),
  /**
   * Request storage information (STORAGE_INFORMATION). Use the command's target_component to target
   * a specific component's storage.
   *
   * index = 1; label = Storage ID; 
   * Storage ID (0 for all, 1 for first, 2 for second, etc.)
   *
   * index = 2; label = Information; 
   * 0: No Action 1: Request storage information
   *
   * index = 3; 
   * Reserved (all remaining params)
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  REQUEST_STORAGE_INFORMATION(525u),
  /**
   * Format a storage medium. Once format is complete, a STORAGE_INFORMATION message is sent. Use
   * the command's target_component to target a specific component's storage.
   *
   * index = 1; label = Storage ID; 
   * Storage ID (1 for first, 2 for second, etc.)
   *
   * index = 2; label = Format; 
   * Format storage (and reset image log). 0: No action 1: Format storage
   *
   * index = 3; label = Reset Image Log; 
   * Reset Image Log (without formatting storage medium). This will reset
   * CAMERA_CAPTURE_STATUS.image_count and CAMERA_IMAGE_CAPTURED.image_index. 0: No action 1: Reset
   * Image Log
   *
   * index = 4; 
   * Reserved (all remaining params)
   */
  @GeneratedMavEnumEntry
  STORAGE_FORMAT(526u),
  /**
   * Request camera capture status (CAMERA_CAPTURE_STATUS)
   *
   * index = 1; label = Capture Status; 
   * 0: No Action 1: Request camera capture status
   *
   * index = 2; 
   * Reserved (all remaining params)
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  REQUEST_CAMERA_CAPTURE_STATUS(527u),
  /**
   * Request flight information (FLIGHT_INFORMATION)
   *
   * index = 1; label = Flight Information; 
   * 1: Request flight information
   *
   * index = 2; 
   * Reserved (all remaining params)
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  REQUEST_FLIGHT_INFORMATION(528u),
  /**
   * Reset all camera settings to Factory Default
   *
   * index = 1; label = Reset; 
   * 0: No Action 1: Reset all settings
   *
   * index = 2; 
   * Reserved (all remaining params)
   */
  @GeneratedMavEnumEntry
  RESET_CAMERA_SETTINGS(529u),
  /**
   * Set camera running mode. Use NaN for reserved values. GCS will send a
   * MAV_CMD_REQUEST_VIDEO_STREAM_STATUS command after a mode change if the camera supports video
   * streaming.
   *
   * index = 1; label = id; 
   * Target camera ID. 7 to 255: MAVLink camera component id. 1 to 6 for cameras that don't have a
   * distinct component id (such as autopilot-attached cameras). 0: all cameras. This is used to
   * specifically target autopilot-connected cameras or individual sensors in a multi-sensor MAVLink
   * camera. It is also used to target specific cameras when the MAV_CMD is used in a mission
   *
   * index = 2; label = Camera Mode; 
   * Camera mode
   *
   * index = 3; index = 4; index = 7; 
   */
  @GeneratedMavEnumEntry
  SET_CAMERA_MODE(530u),
  /**
   * Set camera zoom. Camera must respond with a CAMERA_SETTINGS message (on success).
   *
   * index = 1; label = Zoom Type; 
   * Zoom type
   *
   * index = 2; label = Zoom Value; 
   * Zoom value. The range of valid values depend on the zoom type.
   *
   * index = 3; index = 4; index = 7; 
   */
  @GeneratedMavEnumEntry
  SET_CAMERA_ZOOM(531u),
  /**
   * Set camera focus. Camera must respond with a CAMERA_SETTINGS message (on success).
   *
   * index = 1; label = Focus Type; 
   * Focus type
   *
   * index = 2; label = Focus Value; 
   * Focus value
   *
   * index = 3; index = 4; index = 7; 
   */
  @GeneratedMavEnumEntry
  SET_CAMERA_FOCUS(532u),
  /**
   * Set that a particular storage is the preferred location for saving photos, videos, and/or other
   * media (e.g. to set that an SD card is used for storing videos).
   *           There can only be one preferred save location for each particular media type: setting
   * a media usage flag will clear/reset that same flag if set on any other storage.
   *           If no flag is set the system should use its default storage.
   *           A target system can choose to always use default storage, in which case it should ACK
   * the command with MAV_RESULT_UNSUPPORTED.
   *           A target system can choose to not allow a particular storage to be set as preferred
   * storage, in which case it should ACK the command with MAV_RESULT_DENIED.
   *
   * index = 1; label = Storage ID; 
   * Storage ID (1 for first, 2 for second, etc.)
   *
   * index = 2; label = Usage; 
   * Usage flags
   */
  @GeneratedMavEnumEntry
  SET_STORAGE_USAGE(533u),
  /**
   * Set camera source. Changes the camera's active sources on cameras with multiple image sensors.
   *
   * index = 1; label = device id; 
   * Component Id of camera to address or 1-6 for non-MAVLink cameras, 0 for all cameras.
   *
   * index = 2; label = primary source; 
   * Primary Source
   *
   * index = 3; label = secondary source; 
   * Secondary Source. If non-zero the second source will be displayed as picture-in-picture.
   */
  @GeneratedMavEnumEntry
  SET_CAMERA_SOURCE(534u),
  /**
   * Tagged jump target. Can be jumped to with MAV_CMD_DO_JUMP_TAG.
   *
   * index = 1; label = Tag; 
   * Tag.
   */
  @GeneratedMavEnumEntry
  JUMP_TAG(600u),
  /**
   * Jump to the matching tag in the mission list. Repeat this action for the specified number of
   * times. A mission should contain a single matching tag for each jump. If this is not the case then
   * a jump to a missing tag should complete the mission, and a jump where there are multiple matching
   * tags should always select the one with the lowest mission sequence number.
   *
   * index = 1; label = Tag; 
   * Target tag to jump to.
   *
   * index = 2; label = Repeat; 
   * Repeat count.
   */
  @GeneratedMavEnumEntry
  DO_JUMP_TAG(601u),
  /**
   * Set gimbal manager pitch/yaw setpoints (low rate command). It is possible to set combinations
   * of the values below. E.g. an angle as well as a desired angular rate can be used to get to this
   * angle at a certain angular rate, or an angular rate only will result in continuous turning. NaN is
   * to be used to signal unset. Note: only the gimbal manager will react to this command - it will be
   * ignored by a gimbal device. Use GIMBAL_MANAGER_SET_PITCHYAW if you need to stream pitch/yaw
   * setpoints at higher rate. 
   *
   * index = 1; label = Pitch angle; units = deg; 
   * Pitch angle (positive to pitch up, relative to vehicle for FOLLOW mode, relative to world
   * horizon for LOCK mode).
   *
   * index = 2; label = Yaw angle; units = deg; 
   * Yaw angle (positive to yaw to the right, relative to vehicle for FOLLOW mode, absolute to North
   * for LOCK mode).
   *
   * index = 3; label = Pitch rate; units = deg/s; 
   * Pitch rate (positive to pitch up).
   *
   * index = 4; label = Yaw rate; units = deg/s; 
   * Yaw rate (positive to yaw to the right).
   *
   * index = 5; label = Gimbal manager flags; 
   * Gimbal manager flags to use.
   *
   * index = 7; label = Gimbal device ID; 
   * Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal
   * device components. Send command multiple times for more than one gimbal (but not all gimbals).
   */
  @GeneratedMavEnumEntry
  DO_GIMBAL_MANAGER_PITCHYAW(1_000u),
  /**
   * Gimbal configuration to set which sysid/compid is in primary and secondary control.
   *
   * index = 1; label = sysid primary control; 
   * Sysid for primary control (0: no one in control, -1: leave unchanged, -2: set itself in control
   * (for missions where the own sysid is still unknown), -3: remove control if currently in control).
   *
   * index = 2; label = compid primary control; 
   * Compid for primary control (0: no one in control, -1: leave unchanged, -2: set itself in
   * control (for missions where the own sysid is still unknown), -3: remove control if currently in
   * control).
   *
   * index = 3; label = sysid secondary control; 
   * Sysid for secondary control (0: no one in control, -1: leave unchanged, -2: set itself in
   * control (for missions where the own sysid is still unknown), -3: remove control if currently in
   * control).
   *
   * index = 4; label = compid secondary control; 
   * Compid for secondary control (0: no one in control, -1: leave unchanged, -2: set itself in
   * control (for missions where the own sysid is still unknown), -3: remove control if currently in
   * control).
   *
   * index = 7; label = Gimbal device ID; 
   * Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal
   * device components. Send command multiple times for more than one gimbal (but not all gimbals).
   */
  @GeneratedMavEnumEntry
  DO_GIMBAL_MANAGER_CONFIGURE(1_001u),
  /**
   * Start image capture sequence. CAMERA_IMAGE_CAPTURED must be emitted after each capture.
   *
   *           Param1 (id) may be used to specify the target camera: 0: all cameras, 1 to 6:
   * autopilot-connected cameras, 7-255: MAVLink camera component ID.
   *           It is needed in order to target specific cameras connected to the autopilot, or
   * specific sensors in a multi-sensor camera (neither of which have a distinct MAVLink component ID).
   *           It is also needed to specify the target camera in missions.
   *
   *           When used in a mission, an autopilot should execute the MAV_CMD for a specified local
   * camera (param1 = 1-6), or resend it as a command if it is intended for a MAVLink camera (param1 =
   * 7 - 255), setting the command's target_component as the param1 value (and setting param1 in the
   * command to zero).
   *           If the param1 is 0 the autopilot should do both.
   *
   *           When sent in a command the target MAVLink address is set using target_component.
   *           If addressed specifically to an autopilot: param1 should be used in the same way as
   * it is for missions (though command should NACK with MAV_RESULT_DENIED if a specified local camera
   * does not exist).
   *           If addressed to a MAVLink camera, param 1 can be used to address all cameras (0), or
   * to separately address 1 to 7 individual sensors. Other values should be NACKed with
   * MAV_RESULT_DENIED.
   *           If the command is broadcast (target_component is 0) then param 1 should be set to 0
   * (any other value should be NACKED with MAV_RESULT_DENIED). An autopilot would trigger any local
   * cameras and forward the command to all channels.
   *         
   *
   * index = 1; label = id; 
   * Target camera ID. 7 to 255: MAVLink camera component id. 1 to 6 for cameras that don't have a
   * distinct component id (such as autopilot-attached cameras). 0: all cameras. This is used to
   * specifically target autopilot-connected cameras or individual sensors in a multi-sensor MAVLink
   * camera. It is also used to target specific cameras when the MAV_CMD is used in a mission
   *
   * index = 2; label = Interval; units = s; 
   * Desired elapsed time between two consecutive pictures (in seconds). Minimum values depend on
   * hardware (typically greater than 2 seconds).
   *
   * index = 3; label = Total Images; 
   * Total number of images to capture. 0 to capture forever/until MAV_CMD_IMAGE_STOP_CAPTURE.
   *
   * index = 4; label = Sequence Number; 
   * Capture sequence number starting from 1. This is only valid for single-capture (param3 == 1),
   * otherwise set to 0. Increment the capture ID for each capture command to prevent double captures
   * when a command is re-transmitted.
   *
   * index = 5; index = 6; index = 7; 
   */
  @GeneratedMavEnumEntry
  IMAGE_START_CAPTURE(2_000u),
  /**
   * Stop image capture sequence.
   *
   *           Param1 (id) may be used to specify the target camera: 0: all cameras, 1 to 6:
   * autopilot-connected cameras, 7-255: MAVLink camera component ID.
   *           It is needed in order to target specific cameras connected to the autopilot, or
   * specific sensors in a multi-sensor camera (neither of which have a distinct MAVLink component ID).
   *           It is also needed to specify the target camera in missions.
   *
   *           When used in a mission, an autopilot should execute the MAV_CMD for a specified local
   * camera (param1 = 1-6), or resend it as a command if it is intended for a MAVLink camera (param1 =
   * 7 - 255), setting the command's target_component as the param1 value (and setting param1 in the
   * command to zero).
   *           If the param1 is 0 the autopilot should do both.
   *
   *           When sent in a command the target MAVLink address is set using target_component.
   *           If addressed specifically to an autopilot: param1 should be used in the same way as
   * it is for missions (though command should NACK with MAV_RESULT_DENIED if a specified local camera
   * does not exist).
   *           If addressed to a MAVLink camera, param1 can be used to address all cameras (0), or
   * to separately address 1 to 7 individual sensors. Other values should be NACKed with
   * MAV_RESULT_DENIED.
   *           If the command is broadcast (target_component is 0) then param 1 should be set to 0
   * (any other value should be NACKED with MAV_RESULT_DENIED). An autopilot would trigger any local
   * cameras and forward the command to all channels.
   *         
   *
   * index = 1; label = id; 
   * Target camera ID. 7 to 255: MAVLink camera component id. 1 to 6 for cameras that don't have a
   * distinct component id (such as autopilot-attached cameras). 0: all cameras. This is used to
   * specifically target autopilot-connected cameras or individual sensors in a multi-sensor MAVLink
   * camera. It is also used to target specific cameras when the MAV_CMD is used in a mission
   *
   * index = 2; index = 3; index = 4; index = 5; index = 6; index = 7; 
   */
  @GeneratedMavEnumEntry
  IMAGE_STOP_CAPTURE(2_001u),
  /**
   * Re-request a CAMERA_IMAGE_CAPTURED message.
   *
   * index = 1; label = Number; 
   * Sequence number for missing CAMERA_IMAGE_CAPTURED message
   *
   * index = 2; index = 3; index = 4; index = 5; index = 6; index = 7; 
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  REQUEST_CAMERA_IMAGE_CAPTURE(2_002u),
  /**
   * Enable or disable on-board camera triggering system.
   *
   * index = 1; label = Enable; 
   * Trigger enable/disable (0 for disable, 1 for start), -1 to ignore
   *
   * index = 2; label = Reset; 
   * 1 to reset the trigger sequence, -1 or 0 to ignore
   *
   * index = 3; label = Pause; 
   * 1 to pause triggering, but without switching the camera off or retracting it. -1 to ignore
   */
  @GeneratedMavEnumEntry
  DO_TRIGGER_CONTROL(2_003u),
  /**
   * If the camera supports point visual tracking (CAMERA_CAP_FLAGS_HAS_TRACKING_POINT is set), this
   * command allows to initiate the tracking.
   *
   * index = 1; label = Point x; 
   * Point to track x value (normalized 0..1, 0 is left, 1 is right).
   *
   * index = 2; label = Point y; 
   * Point to track y value (normalized 0..1, 0 is top, 1 is bottom).
   *
   * index = 3; label = Radius; 
   * Point radius (normalized 0..1, 0 is one pixel, 1 is full image width).
   */
  @GeneratedMavEnumEntry
  CAMERA_TRACK_POINT(2_004u),
  /**
   * If the camera supports rectangle visual tracking (CAMERA_CAP_FLAGS_HAS_TRACKING_RECTANGLE is
   * set), this command allows to initiate the tracking.
   *
   * index = 1; label = Top left corner x; 
   * Top left corner of rectangle x value (normalized 0..1, 0 is left, 1 is right).
   *
   * index = 2; label = Top left corner y; 
   * Top left corner of rectangle y value (normalized 0..1, 0 is top, 1 is bottom).
   *
   * index = 3; label = Bottom right corner x; 
   * Bottom right corner of rectangle x value (normalized 0..1, 0 is left, 1 is right).
   *
   * index = 4; label = Bottom right corner y; 
   * Bottom right corner of rectangle y value (normalized 0..1, 0 is top, 1 is bottom).
   */
  @GeneratedMavEnumEntry
  CAMERA_TRACK_RECTANGLE(2_005u),
  /**
   * Stops ongoing tracking.
   */
  @GeneratedMavEnumEntry
  CAMERA_STOP_TRACKING(2_010u),
  /**
   * Starts video capture (recording).
   *
   * index = 1; label = Stream ID; 
   * Video Stream ID (0 for all streams)
   *
   * index = 2; label = Status Frequency; units = Hz; 
   * Frequency CAMERA_CAPTURE_STATUS messages should be sent while recording (0 for no messages,
   * otherwise frequency)
   *
   * index = 3; index = 4; index = 5; index = 6; index = 7; 
   */
  @GeneratedMavEnumEntry
  VIDEO_START_CAPTURE(2_500u),
  /**
   * Stop the current video capture (recording).
   *
   * index = 1; label = Stream ID; 
   * Video Stream ID (0 for all streams)
   *
   * index = 2; index = 3; index = 4; index = 5; index = 6; index = 7; 
   */
  @GeneratedMavEnumEntry
  VIDEO_STOP_CAPTURE(2_501u),
  /**
   * Start video streaming
   *
   * index = 1; label = Stream ID; 
   * Video Stream ID (0 for all streams, 1 for first, 2 for second, etc.)
   */
  @GeneratedMavEnumEntry
  VIDEO_START_STREAMING(2_502u),
  /**
   * Stop the given video stream
   *
   * index = 1; label = Stream ID; 
   * Video Stream ID (0 for all streams, 1 for first, 2 for second, etc.)
   */
  @GeneratedMavEnumEntry
  VIDEO_STOP_STREAMING(2_503u),
  /**
   * Request video stream information (VIDEO_STREAM_INFORMATION)
   *
   * index = 1; label = Stream ID; 
   * Video Stream ID (0 for all streams, 1 for first, 2 for second, etc.)
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  REQUEST_VIDEO_STREAM_INFORMATION(2_504u),
  /**
   * Request video stream status (VIDEO_STREAM_STATUS)
   *
   * index = 1; label = Stream ID; 
   * Video Stream ID (0 for all streams, 1 for first, 2 for second, etc.)
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  REQUEST_VIDEO_STREAM_STATUS(2_505u),
  /**
   * Request to start streaming logging data over MAVLink (see also LOGGING_DATA message)
   *
   * index = 1; label = Format; 
   * Format: 0: ULog
   *
   * index = 2; 
   * Reserved (set to 0)
   *
   * index = 3; 
   * Reserved (set to 0)
   *
   * index = 4; 
   * Reserved (set to 0)
   *
   * index = 5; 
   * Reserved (set to 0)
   *
   * index = 6; 
   * Reserved (set to 0)
   *
   * index = 7; 
   * Reserved (set to 0)
   */
  @GeneratedMavEnumEntry
  LOGGING_START(2_510u),
  /**
   * Request to stop streaming log data over MAVLink
   *
   * index = 1; 
   * Reserved (set to 0)
   *
   * index = 2; 
   * Reserved (set to 0)
   *
   * index = 3; 
   * Reserved (set to 0)
   *
   * index = 4; 
   * Reserved (set to 0)
   *
   * index = 5; 
   * Reserved (set to 0)
   *
   * index = 6; 
   * Reserved (set to 0)
   *
   * index = 7; 
   * Reserved (set to 0)
   */
  @GeneratedMavEnumEntry
  LOGGING_STOP(2_511u),
  /**
   *
   *
   * index = 1; label = Landing Gear ID; 
   * Landing gear ID (default: 0, -1 for all)
   *
   * index = 2; label = Landing Gear Position; 
   * Landing gear position (Down: 0, Up: 1, NaN for no change)
   *
   * index = 3; index = 4; index = 5; index = 6; index = 7; 
   */
  @GeneratedMavEnumEntry
  AIRFRAME_CONFIGURATION(2_520u),
  /**
   * Request to start/stop transmitting over the high latency telemetry
   *
   * index = 1; label = Enable; 
   * Control transmission over high latency telemetry (0: stop, 1: start)
   *
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  @GeneratedMavEnumEntry
  CONTROL_HIGH_LATENCY(2_600u),
  /**
   * Create a panorama at the current position
   *
   * index = 1; label = Horizontal Angle; units = deg; 
   * Viewing angle horizontal of the panorama (+- 0.5 the total angle)
   *
   * index = 2; label = Vertical Angle; units = deg; 
   * Viewing angle vertical of panorama.
   *
   * index = 3; label = Horizontal Speed; units = deg/s; 
   * Speed of the horizontal rotation.
   *
   * index = 4; label = Vertical Speed; units = deg/s; 
   * Speed of the vertical rotation.
   */
  @GeneratedMavEnumEntry
  PANORAMA_CREATE(2_800u),
  /**
   * Request VTOL transition
   *
   * index = 1; label = State; 
   * The target VTOL state. For normal transitions, only MAV_VTOL_STATE_MC and MAV_VTOL_STATE_FW can
   * be used.
   *
   * index = 2; label = Immediate; 
   * Force immediate transition to the specified MAV_VTOL_STATE. 1: Force immediate, 0: normal
   * transition. Can be used, for example, to trigger an emergency "Quadchute". Caution: Can be
   * dangerous/damage vehicle, depending on autopilot implementation of this command.
   */
  @GeneratedMavEnumEntry
  DO_VTOL_TRANSITION(3_000u),
  /**
   * Request authorization to arm the vehicle to a external entity, the arm authorizer is
   * responsible to request all data that is needs from the vehicle before authorize or deny the
   * request.
   * 		If approved the COMMAND_ACK message progress field should be set with period of time that
   * this authorization is valid in seconds.
   * 		If the authorization is denied COMMAND_ACK.result_param2 should be set with one of the
   * reasons in ARM_AUTH_DENIED_REASON.
   *         
   *
   * index = 1; label = System ID; 
   * Vehicle system id, this way ground station can request arm authorization on behalf of any
   * vehicle
   */
  @GeneratedMavEnumEntry
  ARM_AUTHORIZATION_REQUEST(3_001u),
  /**
   * This command sets the submode to standard guided when vehicle is in guided mode. The vehicle
   * holds position and altitude and the user can input the desired velocities along all three axes.
   *                   
   */
  @GeneratedMavEnumEntry
  SET_GUIDED_SUBMODE_STANDARD(4_000u),
  /**
   * This command sets submode circle when vehicle is in guided mode. Vehicle flies along a circle
   * facing the center of the circle. The user can input the velocity along the circle and change the
   * radius. If no input is given the vehicle will hold position.
   *                   
   *
   * index = 1; label = Radius; units = m; 
   * Radius of desired circle in CIRCLE_MODE
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; label = Latitude; units = degE7; 
   * Target latitude of center of circle in CIRCLE_MODE
   *
   * index = 6; label = Longitude; units = degE7; 
   * Target longitude of center of circle in CIRCLE_MODE
   */
  @GeneratedMavEnumEntry
  SET_GUIDED_SUBMODE_CIRCLE(4_001u),
  /**
   * Delay mission state machine until gate has been reached.
   *
   * index = 1; label = Geometry; 
   * Geometry: 0: orthogonal to path between previous and next waypoint.
   *
   * index = 2; label = UseAltitude; 
   * Altitude: 0: ignore altitude
   *
   * index = 3; 
   * Empty
   *
   * index = 4; 
   * Empty
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude
   */
  @WorkInProgress
  @GeneratedMavEnumEntry
  CONDITION_GATE(4_501u),
  /**
   * Fence return point (there can only be one such point in a geofence definition). If rally points
   * are supported they should be used instead.
   *
   * index = 1; 
   * Reserved
   *
   * index = 2; 
   * Reserved
   *
   * index = 3; 
   * Reserved
   *
   * index = 4; 
   * Reserved
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude
   */
  @GeneratedMavEnumEntry
  NAV_FENCE_RETURN_POINT(5_000u),
  /**
   * Fence vertex for an inclusion polygon (the polygon must not be self-intersecting). The vehicle
   * must stay within this area. Minimum of 3 vertices required.
   *         
   *
   * index = 1; label = Vertex Count; 
   * Polygon vertex count
   *
   * index = 2; label = Inclusion Group; 
   * Vehicle must be inside ALL inclusion zones in a single group, vehicle must be inside at least
   * one group, must be the same for all points in each polygon
   *
   * index = 3; 
   * Reserved
   *
   * index = 4; 
   * Reserved
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; 
   * Reserved
   */
  @GeneratedMavEnumEntry
  NAV_FENCE_POLYGON_VERTEX_INCLUSION(5_001u),
  /**
   * Fence vertex for an exclusion polygon (the polygon must not be self-intersecting). The vehicle
   * must stay outside this area. Minimum of 3 vertices required.
   *         
   *
   * index = 1; label = Vertex Count; 
   * Polygon vertex count
   *
   * index = 2; 
   * Reserved
   *
   * index = 3; 
   * Reserved
   *
   * index = 4; 
   * Reserved
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; 
   * Reserved
   */
  @GeneratedMavEnumEntry
  NAV_FENCE_POLYGON_VERTEX_EXCLUSION(5_002u),
  /**
   * Circular fence area. The vehicle must stay inside this area.
   *         
   *
   * index = 1; label = Radius; units = m; 
   * Radius.
   *
   * index = 2; label = Inclusion Group; 
   * Vehicle must be inside ALL inclusion zones in a single group, vehicle must be inside at least
   * one group
   *
   * index = 3; 
   * Reserved
   *
   * index = 4; 
   * Reserved
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; 
   * Reserved
   */
  @GeneratedMavEnumEntry
  NAV_FENCE_CIRCLE_INCLUSION(5_003u),
  /**
   * Circular fence area. The vehicle must stay outside this area.
   *         
   *
   * index = 1; label = Radius; units = m; 
   * Radius.
   *
   * index = 2; 
   * Reserved
   *
   * index = 3; 
   * Reserved
   *
   * index = 4; 
   * Reserved
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; 
   * Reserved
   */
  @GeneratedMavEnumEntry
  NAV_FENCE_CIRCLE_EXCLUSION(5_004u),
  /**
   * Rally point. You can have multiple rally points defined.
   *         
   *
   * index = 1; 
   * Reserved
   *
   * index = 2; 
   * Reserved
   *
   * index = 3; 
   * Reserved
   *
   * index = 4; 
   * Reserved
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude
   */
  @GeneratedMavEnumEntry
  NAV_RALLY_POINT(5_100u),
  /**
   * Commands the vehicle to respond with a sequence of messages UAVCAN_NODE_INFO, one message per
   * every UAVCAN node that is online. Note that some of the response messages can be lost, which the
   * receiver can detect easily by checking whether every received UAVCAN_NODE_STATUS has a matching
   * message UAVCAN_NODE_INFO received earlier; if not, this command should be sent again in order to
   * request re-transmission of the node information messages.
   *
   * index = 1; 
   * Reserved (set to 0)
   *
   * index = 2; 
   * Reserved (set to 0)
   *
   * index = 3; 
   * Reserved (set to 0)
   *
   * index = 4; 
   * Reserved (set to 0)
   *
   * index = 5; 
   * Reserved (set to 0)
   *
   * index = 6; 
   * Reserved (set to 0)
   *
   * index = 7; 
   * Reserved (set to 0)
   */
  @GeneratedMavEnumEntry
  UAVCAN_GET_NODE_INFO(5_200u),
  /**
   * Change state of safety switch.
   *
   * index = 1; label = Desired State; 
   * New safety switch state.
   *
   * index = 2; 
   * Empty.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; 
   * Empty
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  @GeneratedMavEnumEntry
  DO_SET_SAFETY_SWITCH_STATE(5_300u),
  /**
   * Trigger the start of an ADSB-out IDENT. This should only be used when requested to do so by an
   * Air Traffic Controller in controlled airspace. This starts the IDENT which is then typically held
   * for 18 seconds by the hardware per the Mode A, C, and S transponder spec.
   *
   * index = 1; 
   * Reserved (set to 0)
   *
   * index = 2; 
   * Reserved (set to 0)
   *
   * index = 3; 
   * Reserved (set to 0)
   *
   * index = 4; 
   * Reserved (set to 0)
   *
   * index = 5; 
   * Reserved (set to 0)
   *
   * index = 6; 
   * Reserved (set to 0)
   *
   * index = 7; 
   * Reserved (set to 0)
   */
  @GeneratedMavEnumEntry
  DO_ADSB_OUT_IDENT(10_001u),
  /**
   * Deploy payload on a Lat / Lon / Alt position. This includes the navigation to reach the
   * required release position and velocity.
   *
   * index = 1; label = Operation Mode; 
   * Operation mode. 0: prepare single payload deploy (overwriting previous requests), but do not
   * execute it. 1: execute payload deploy immediately (rejecting further deploy commands during
   * execution, but allowing abort). 2: add payload deploy to existing deployment list.
   *
   * index = 2; label = Approach Vector; units = deg; 
   * Desired approach vector in compass heading. A negative value indicates the system can define
   * the approach vector at will.
   *
   * index = 3; label = Ground Speed; 
   * Desired ground speed at release time. This can be overridden by the airframe in case it needs
   * to meet minimum airspeed. A negative value indicates the system can define the ground speed at
   * will.
   *
   * index = 4; label = Altitude Clearance; units = m; 
   * Minimum altitude clearance to the release position. A negative value indicates the system can
   * define the clearance at will.
   *
   * index = 5; label = Latitude; units = degE7; 
   * Latitude.
   *
   * index = 6; label = Longitude; units = degE7; 
   * Longitude.
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude (MSL)
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  PAYLOAD_PREPARE_DEPLOY(30_001u),
  /**
   * Control the payload deployment.
   *
   * index = 1; label = Operation Mode; 
   * Operation mode. 0: Abort deployment, continue normal mission. 1: switch to payload deployment
   * mode. 100: delete first payload deployment request. 101: delete all payload deployment requests.
   *
   * index = 2; 
   * Reserved
   *
   * index = 3; 
   * Reserved
   *
   * index = 4; 
   * Reserved
   *
   * index = 5; 
   * Reserved
   *
   * index = 6; 
   * Reserved
   *
   * index = 7; 
   * Reserved
   */
  @Deprecated(message = "")
  @GeneratedMavEnumEntry
  PAYLOAD_CONTROL_DEPLOY(30_002u),
  /**
   * Magnetometer calibration based on provided known yaw. This allows for fast calibration using
   * WMM field tables in the vehicle, given only the known yaw of the vehicle. If Latitude and
   * longitude are both zero then use the current vehicle location.
   *
   * index = 1; label = Yaw; units = deg; 
   * Yaw of vehicle in earth frame.
   *
   * index = 2; label = CompassMask; 
   * CompassMask, 0 for all.
   *
   * index = 3; label = Latitude; units = deg; 
   * Latitude.
   *
   * index = 4; label = Longitude; units = deg; 
   * Longitude.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  @GeneratedMavEnumEntry
  FIXED_MAG_CAL_YAW(42_006u),
  /**
   * Command to operate winch.
   *
   * index = 1; label = Instance; 
   * Winch instance number.
   *
   * index = 2; label = Action; 
   * Action to perform.
   *
   * index = 3; label = Length; units = m; 
   * Length of line to release (negative to wind).
   *
   * index = 4; label = Rate; units = m/s; 
   * Release rate (negative to wind).
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  @GeneratedMavEnumEntry
  DO_WINCH(42_600u),
  /**
   * Provide an external position estimate for use when dead-reckoning. This is meant to be used for
   * occasional position resets that may be provided by a external system such as a remote pilot using
   * landmarks over a video link.
   *
   * index = 1; label = transmission_time; units = s; 
   * Timestamp that this message was sent as a time in the transmitters time domain. The sender
   * should wrap this time back to zero based on required timing accuracy for the application and the
   * limitations of a 32 bit float. For example, wrapping at 10 hours would give approximately 1ms
   * accuracy. Recipient must handle time wrap in any timing jitter correction applied to this field.
   * Wrap rollover time should not be at not more than 250 seconds, which would give approximately 10
   * microsecond accuracy.
   *
   * index = 2; label = processing_time; units = s; 
   * The time spent in processing the sensor data that is the basis for this position. The recipient
   * can use this to improve time alignment of the data. Set to zero if not known.
   *
   * index = 3; label = accuracy; 
   * estimated one standard deviation accuracy of the measurement. Set to NaN if not known.
   *
   * index = 4; 
   * Empty
   *
   * index = 5; label = Latitude; 
   * Latitude
   *
   * index = 6; label = Longitude; 
   * Longitude
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude, not used. Should be sent as NaN. May be supported in a future version of this
   * message.
   */
  @GeneratedMavEnumEntry
  EXTERNAL_POSITION_ESTIMATE(43_003u),
  /**
   * User defined waypoint item. Ground Station will show the Vehicle as flying through this item.
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; label = Latitude; 
   * Latitude unscaled
   *
   * index = 6; label = Longitude; 
   * Longitude unscaled
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude (MSL)
   */
  @GeneratedMavEnumEntry
  WAYPOINT_USER_1(31_000u),
  /**
   * User defined waypoint item. Ground Station will show the Vehicle as flying through this item.
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; label = Latitude; 
   * Latitude unscaled
   *
   * index = 6; label = Longitude; 
   * Longitude unscaled
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude (MSL)
   */
  @GeneratedMavEnumEntry
  WAYPOINT_USER_2(31_001u),
  /**
   * User defined waypoint item. Ground Station will show the Vehicle as flying through this item.
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; label = Latitude; 
   * Latitude unscaled
   *
   * index = 6; label = Longitude; 
   * Longitude unscaled
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude (MSL)
   */
  @GeneratedMavEnumEntry
  WAYPOINT_USER_3(31_002u),
  /**
   * User defined waypoint item. Ground Station will show the Vehicle as flying through this item.
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; label = Latitude; 
   * Latitude unscaled
   *
   * index = 6; label = Longitude; 
   * Longitude unscaled
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude (MSL)
   */
  @GeneratedMavEnumEntry
  WAYPOINT_USER_4(31_003u),
  /**
   * User defined waypoint item. Ground Station will show the Vehicle as flying through this item.
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; label = Latitude; 
   * Latitude unscaled
   *
   * index = 6; label = Longitude; 
   * Longitude unscaled
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude (MSL)
   */
  @GeneratedMavEnumEntry
  WAYPOINT_USER_5(31_004u),
  /**
   * User defined spatial item. Ground Station will not show the Vehicle as flying through this
   * item. Example: ROI item.
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; label = Latitude; 
   * Latitude unscaled
   *
   * index = 6; label = Longitude; 
   * Longitude unscaled
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude (MSL)
   */
  @GeneratedMavEnumEntry
  SPATIAL_USER_1(31_005u),
  /**
   * User defined spatial item. Ground Station will not show the Vehicle as flying through this
   * item. Example: ROI item.
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; label = Latitude; 
   * Latitude unscaled
   *
   * index = 6; label = Longitude; 
   * Longitude unscaled
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude (MSL)
   */
  @GeneratedMavEnumEntry
  SPATIAL_USER_2(31_006u),
  /**
   * User defined spatial item. Ground Station will not show the Vehicle as flying through this
   * item. Example: ROI item.
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; label = Latitude; 
   * Latitude unscaled
   *
   * index = 6; label = Longitude; 
   * Longitude unscaled
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude (MSL)
   */
  @GeneratedMavEnumEntry
  SPATIAL_USER_3(31_007u),
  /**
   * User defined spatial item. Ground Station will not show the Vehicle as flying through this
   * item. Example: ROI item.
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; label = Latitude; 
   * Latitude unscaled
   *
   * index = 6; label = Longitude; 
   * Longitude unscaled
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude (MSL)
   */
  @GeneratedMavEnumEntry
  SPATIAL_USER_4(31_008u),
  /**
   * User defined spatial item. Ground Station will not show the Vehicle as flying through this
   * item. Example: ROI item.
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; label = Latitude; 
   * Latitude unscaled
   *
   * index = 6; label = Longitude; 
   * Longitude unscaled
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude (MSL)
   */
  @GeneratedMavEnumEntry
  SPATIAL_USER_5(31_009u),
  /**
   * User defined command. Ground Station will not show the Vehicle as flying through this item.
   * Example: MAV_CMD_DO_SET_PARAMETER item.
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; 
   * User defined
   *
   * index = 6; 
   * User defined
   *
   * index = 7; 
   * User defined
   */
  @GeneratedMavEnumEntry
  USER_1(31_010u),
  /**
   * User defined command. Ground Station will not show the Vehicle as flying through this item.
   * Example: MAV_CMD_DO_SET_PARAMETER item.
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; 
   * User defined
   *
   * index = 6; 
   * User defined
   *
   * index = 7; 
   * User defined
   */
  @GeneratedMavEnumEntry
  USER_2(31_011u),
  /**
   * User defined command. Ground Station will not show the Vehicle as flying through this item.
   * Example: MAV_CMD_DO_SET_PARAMETER item.
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; 
   * User defined
   *
   * index = 6; 
   * User defined
   *
   * index = 7; 
   * User defined
   */
  @GeneratedMavEnumEntry
  USER_3(31_012u),
  /**
   * User defined command. Ground Station will not show the Vehicle as flying through this item.
   * Example: MAV_CMD_DO_SET_PARAMETER item.
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; 
   * User defined
   *
   * index = 6; 
   * User defined
   *
   * index = 7; 
   * User defined
   */
  @GeneratedMavEnumEntry
  USER_4(31_013u),
  /**
   * User defined command. Ground Station will not show the Vehicle as flying through this item.
   * Example: MAV_CMD_DO_SET_PARAMETER item.
   *
   * index = 1; 
   * User defined
   *
   * index = 2; 
   * User defined
   *
   * index = 3; 
   * User defined
   *
   * index = 4; 
   * User defined
   *
   * index = 5; 
   * User defined
   *
   * index = 6; 
   * User defined
   *
   * index = 7; 
   * User defined
   */
  @GeneratedMavEnumEntry
  USER_5(31_014u),
  /**
   * Request forwarding of CAN packets from the given CAN bus to this component. CAN Frames are sent
   * using CAN_FRAME and CANFD_FRAME messages
   *
   * index = 1; label = bus; 
   * Bus number (0 to disable forwarding, 1 for first bus, 2 for 2nd bus, 3 for 3rd bus).
   *
   * index = 2; 
   * Empty.
   *
   * index = 3; 
   * Empty.
   *
   * index = 4; 
   * Empty.
   *
   * index = 5; 
   * Empty.
   *
   * index = 6; 
   * Empty.
   *
   * index = 7; 
   * Empty.
   */
  @GeneratedMavEnumEntry
  CAN_FORWARD(32_000u),
  ;

  public companion object : MavEnum.MavCompanion<MavCmd> {
    override fun getEntryFromValueOrNull(v: UInt): MavCmd? = when (v) {
      16u -> NAV_WAYPOINT
      17u -> NAV_LOITER_UNLIM
      18u -> NAV_LOITER_TURNS
      19u -> NAV_LOITER_TIME
      20u -> NAV_RETURN_TO_LAUNCH
      21u -> NAV_LAND
      22u -> NAV_TAKEOFF
      23u -> NAV_LAND_LOCAL
      24u -> NAV_TAKEOFF_LOCAL
      25u -> NAV_FOLLOW
      30u -> NAV_CONTINUE_AND_CHANGE_ALT
      31u -> NAV_LOITER_TO_ALT
      32u -> DO_FOLLOW
      33u -> DO_FOLLOW_REPOSITION
      34u -> DO_ORBIT
      80u -> NAV_ROI
      81u -> NAV_PATHPLANNING
      82u -> NAV_SPLINE_WAYPOINT
      84u -> NAV_VTOL_TAKEOFF
      85u -> NAV_VTOL_LAND
      92u -> NAV_GUIDED_ENABLE
      93u -> NAV_DELAY
      94u -> NAV_PAYLOAD_PLACE
      95u -> NAV_LAST
      112u -> CONDITION_DELAY
      113u -> CONDITION_CHANGE_ALT
      114u -> CONDITION_DISTANCE
      115u -> CONDITION_YAW
      159u -> CONDITION_LAST
      176u -> DO_SET_MODE
      177u -> DO_JUMP
      178u -> DO_CHANGE_SPEED
      179u -> DO_SET_HOME
      180u -> DO_SET_PARAMETER
      181u -> DO_SET_RELAY
      182u -> DO_REPEAT_RELAY
      183u -> DO_SET_SERVO
      184u -> DO_REPEAT_SERVO
      185u -> DO_FLIGHTTERMINATION
      186u -> DO_CHANGE_ALTITUDE
      187u -> DO_SET_ACTUATOR
      188u -> DO_RETURN_PATH_START
      189u -> DO_LAND_START
      190u -> DO_RALLY_LAND
      191u -> DO_GO_AROUND
      192u -> DO_REPOSITION
      193u -> DO_PAUSE_CONTINUE
      194u -> DO_SET_REVERSE
      195u -> DO_SET_ROI_LOCATION
      196u -> DO_SET_ROI_WPNEXT_OFFSET
      197u -> DO_SET_ROI_NONE
      198u -> DO_SET_ROI_SYSID
      200u -> DO_CONTROL_VIDEO
      201u -> DO_SET_ROI
      202u -> DO_DIGICAM_CONFIGURE
      203u -> DO_DIGICAM_CONTROL
      204u -> DO_MOUNT_CONFIGURE
      205u -> DO_MOUNT_CONTROL
      206u -> DO_SET_CAM_TRIGG_DIST
      207u -> DO_FENCE_ENABLE
      208u -> DO_PARACHUTE
      209u -> DO_MOTOR_TEST
      210u -> DO_INVERTED_FLIGHT
      211u -> DO_GRIPPER
      212u -> DO_AUTOTUNE_ENABLE
      213u -> NAV_SET_YAW_SPEED
      214u -> DO_SET_CAM_TRIGG_INTERVAL
      220u -> DO_MOUNT_CONTROL_QUAT
      221u -> DO_GUIDED_MASTER
      222u -> DO_GUIDED_LIMITS
      223u -> DO_ENGINE_CONTROL
      224u -> DO_SET_MISSION_CURRENT
      240u -> DO_LAST
      241u -> PREFLIGHT_CALIBRATION
      242u -> PREFLIGHT_SET_SENSOR_OFFSETS
      243u -> PREFLIGHT_UAVCAN
      245u -> PREFLIGHT_STORAGE
      246u -> PREFLIGHT_REBOOT_SHUTDOWN
      252u -> OVERRIDE_GOTO
      260u -> OBLIQUE_SURVEY
      300u -> MISSION_START
      310u -> ACTUATOR_TEST
      311u -> CONFIGURE_ACTUATOR
      400u -> COMPONENT_ARM_DISARM
      401u -> RUN_PREARM_CHECKS
      405u -> ILLUMINATOR_ON_OFF
      406u -> DO_ILLUMINATOR_CONFIGURE
      410u -> GET_HOME_POSITION
      420u -> INJECT_FAILURE
      500u -> START_RX_PAIR
      510u -> GET_MESSAGE_INTERVAL
      511u -> SET_MESSAGE_INTERVAL
      512u -> REQUEST_MESSAGE
      519u -> REQUEST_PROTOCOL_VERSION
      520u -> REQUEST_AUTOPILOT_CAPABILITIES
      521u -> REQUEST_CAMERA_INFORMATION
      522u -> REQUEST_CAMERA_SETTINGS
      525u -> REQUEST_STORAGE_INFORMATION
      526u -> STORAGE_FORMAT
      527u -> REQUEST_CAMERA_CAPTURE_STATUS
      528u -> REQUEST_FLIGHT_INFORMATION
      529u -> RESET_CAMERA_SETTINGS
      530u -> SET_CAMERA_MODE
      531u -> SET_CAMERA_ZOOM
      532u -> SET_CAMERA_FOCUS
      533u -> SET_STORAGE_USAGE
      534u -> SET_CAMERA_SOURCE
      600u -> JUMP_TAG
      601u -> DO_JUMP_TAG
      1000u -> DO_GIMBAL_MANAGER_PITCHYAW
      1001u -> DO_GIMBAL_MANAGER_CONFIGURE
      2000u -> IMAGE_START_CAPTURE
      2001u -> IMAGE_STOP_CAPTURE
      2002u -> REQUEST_CAMERA_IMAGE_CAPTURE
      2003u -> DO_TRIGGER_CONTROL
      2004u -> CAMERA_TRACK_POINT
      2005u -> CAMERA_TRACK_RECTANGLE
      2010u -> CAMERA_STOP_TRACKING
      2500u -> VIDEO_START_CAPTURE
      2501u -> VIDEO_STOP_CAPTURE
      2502u -> VIDEO_START_STREAMING
      2503u -> VIDEO_STOP_STREAMING
      2504u -> REQUEST_VIDEO_STREAM_INFORMATION
      2505u -> REQUEST_VIDEO_STREAM_STATUS
      2510u -> LOGGING_START
      2511u -> LOGGING_STOP
      2520u -> AIRFRAME_CONFIGURATION
      2600u -> CONTROL_HIGH_LATENCY
      2800u -> PANORAMA_CREATE
      3000u -> DO_VTOL_TRANSITION
      3001u -> ARM_AUTHORIZATION_REQUEST
      4000u -> SET_GUIDED_SUBMODE_STANDARD
      4001u -> SET_GUIDED_SUBMODE_CIRCLE
      4501u -> CONDITION_GATE
      5000u -> NAV_FENCE_RETURN_POINT
      5001u -> NAV_FENCE_POLYGON_VERTEX_INCLUSION
      5002u -> NAV_FENCE_POLYGON_VERTEX_EXCLUSION
      5003u -> NAV_FENCE_CIRCLE_INCLUSION
      5004u -> NAV_FENCE_CIRCLE_EXCLUSION
      5100u -> NAV_RALLY_POINT
      5200u -> UAVCAN_GET_NODE_INFO
      5300u -> DO_SET_SAFETY_SWITCH_STATE
      10001u -> DO_ADSB_OUT_IDENT
      30001u -> PAYLOAD_PREPARE_DEPLOY
      30002u -> PAYLOAD_CONTROL_DEPLOY
      42006u -> FIXED_MAG_CAL_YAW
      42600u -> DO_WINCH
      43003u -> EXTERNAL_POSITION_ESTIMATE
      31000u -> WAYPOINT_USER_1
      31001u -> WAYPOINT_USER_2
      31002u -> WAYPOINT_USER_3
      31003u -> WAYPOINT_USER_4
      31004u -> WAYPOINT_USER_5
      31005u -> SPATIAL_USER_1
      31006u -> SPATIAL_USER_2
      31007u -> SPATIAL_USER_3
      31008u -> SPATIAL_USER_4
      31009u -> SPATIAL_USER_5
      31010u -> USER_1
      31011u -> USER_2
      31012u -> USER_3
      31013u -> USER_4
      31014u -> USER_5
      32000u -> CAN_FORWARD
      else -> null
    }
  }
}
