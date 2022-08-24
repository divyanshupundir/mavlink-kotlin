package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Deprecated
import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum
import xyz.urbanmatrix.mavlink.api.WorkInProgress

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
  public override val `value`: Long,
) : MavEnum {
  /**
   * Navigate to waypoint.
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
  MAV_CMD_NAV_WAYPOINT(16L),
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
  MAV_CMD_NAV_LOITER_UNLIM(17L),
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
  MAV_CMD_NAV_LOITER_TURNS(18L),
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
  MAV_CMD_NAV_LOITER_TIME(19L),
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
  MAV_CMD_NAV_RETURN_TO_LAUNCH(20L),
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
  MAV_CMD_NAV_LAND(21L),
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
  MAV_CMD_NAV_TAKEOFF(22L),
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
  MAV_CMD_NAV_LAND_LOCAL(23L),
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
  MAV_CMD_NAV_TAKEOFF_LOCAL(24L),
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
  MAV_CMD_NAV_FOLLOW(25L),
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
  MAV_CMD_NAV_CONTINUE_AND_CHANGE_ALT(30L),
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
  MAV_CMD_NAV_LOITER_TO_ALT(31L),
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
  MAV_CMD_DO_FOLLOW(32L),
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
  MAV_CMD_DO_FOLLOW_REPOSITION(33L),
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
  MAV_CMD_DO_ORBIT(34L),
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
  MAV_CMD_NAV_ROI(80L),
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
  MAV_CMD_NAV_PATHPLANNING(81L),
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
  MAV_CMD_NAV_SPLINE_WAYPOINT(82L),
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
  MAV_CMD_NAV_VTOL_TAKEOFF(84L),
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
  MAV_CMD_NAV_VTOL_LAND(85L),
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
  MAV_CMD_NAV_GUIDED_ENABLE(92L),
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
  MAV_CMD_NAV_DELAY(93L),
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
  MAV_CMD_NAV_PAYLOAD_PLACE(94L),
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
  MAV_CMD_NAV_LAST(95L),
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
  MAV_CMD_CONDITION_DELAY(112L),
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
  MAV_CMD_CONDITION_CHANGE_ALT(113L),
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
  MAV_CMD_CONDITION_DISTANCE(114L),
  /**
   * Reach a certain target angle.
   *
   * index = 1; label = Angle; units = deg; 
   * target angle, 0 is north
   *
   * index = 2; label = Angular Speed; units = deg/s; 
   * angular speed
   *
   * index = 3; label = Direction; 
   * direction: -1: counter clockwise, 1: clockwise
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
  MAV_CMD_CONDITION_YAW(115L),
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
  MAV_CMD_CONDITION_LAST(159L),
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
  MAV_CMD_DO_SET_MODE(176L),
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
  MAV_CMD_DO_JUMP(177L),
  /**
   * Change speed and/or throttle set points.
   *
   * index = 1; label = Speed Type; 
   * Speed type (0=Airspeed, 1=Ground Speed, 2=Climb Speed, 3=Descent Speed)
   *
   * index = 2; label = Speed; units = m/s; 
   * Speed (-1 indicates no change)
   *
   * index = 3; label = Throttle; units = %; 
   * Throttle (-1 indicates no change)
   *
   * index = 4; index = 5; index = 6; index = 7; 
   */
  MAV_CMD_DO_CHANGE_SPEED(178L),
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
   * index = 2; 
   * Empty
   *
   * index = 3; 
   * Empty
   *
   * index = 4; label = Yaw; units = deg; 
   * Yaw angle. NaN to use default heading
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
  MAV_CMD_DO_SET_HOME(179L),
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
  MAV_CMD_DO_SET_PARAMETER(180L),
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
  MAV_CMD_DO_SET_RELAY(181L),
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
  MAV_CMD_DO_REPEAT_RELAY(182L),
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
  MAV_CMD_DO_SET_SERVO(183L),
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
  MAV_CMD_DO_REPEAT_SERVO(184L),
  /**
   * Terminate flight immediately.
   *           Flight termination immediately and irreversably terminates the current flight,
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
  MAV_CMD_DO_FLIGHTTERMINATION(185L),
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
  MAV_CMD_DO_CHANGE_ALTITUDE(186L),
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
  MAV_CMD_DO_SET_ACTUATOR(187L),
  /**
   * Mission command to perform a landing. This is used as a marker in a mission to tell the
   * autopilot where a sequence of mission items that represents a landing starts. It may also be sent
   * via a COMMAND_LONG to trigger a landing, in which case the nearest (geographically) landing
   * sequence in the mission will be used. The Latitude/Longitude is optional, and may be set to 0 if
   * not needed. If specified then it will be used to help find the closest landing sequence.
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
   * index = 7; 
   * Empty
   */
  MAV_CMD_DO_LAND_START(189L),
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
  MAV_CMD_DO_RALLY_LAND(190L),
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
  MAV_CMD_DO_GO_AROUND(191L),
  /**
   * Reposition the vehicle to a specific WGS84 global position.
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
  MAV_CMD_DO_REPOSITION(192L),
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
  MAV_CMD_DO_PAUSE_CONTINUE(193L),
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
  MAV_CMD_DO_SET_REVERSE(194L),
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
  MAV_CMD_DO_SET_ROI_LOCATION(195L),
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
   * index = 5; label = Pitch Offset; 
   * Pitch offset from next waypoint, positive pitching up
   *
   * index = 6; label = Roll Offset; 
   * Roll offset from next waypoint, positive rolling to the right
   *
   * index = 7; label = Yaw Offset; 
   * Yaw offset from next waypoint, positive yawing to the right
   */
  MAV_CMD_DO_SET_ROI_WPNEXT_OFFSET(196L),
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
  MAV_CMD_DO_SET_ROI_NONE(197L),
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
  MAV_CMD_DO_SET_ROI_SYSID(198L),
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
  MAV_CMD_DO_CONTROL_VIDEO(200L),
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
  MAV_CMD_DO_SET_ROI(201L),
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
  MAV_CMD_DO_DIGICAM_CONFIGURE(202L),
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
  MAV_CMD_DO_DIGICAM_CONTROL(203L),
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
  MAV_CMD_DO_MOUNT_CONFIGURE(204L),
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
  MAV_CMD_DO_MOUNT_CONTROL(205L),
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
  MAV_CMD_DO_SET_CAM_TRIGG_DIST(206L),
  /**
   * Mission command to enable the geofence
   *
   * index = 1; label = Enable; 
   * enable? (0=disable, 1=enable, 2=disable_floor_only)
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
  MAV_CMD_DO_FENCE_ENABLE(207L),
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
  MAV_CMD_DO_PARACHUTE(208L),
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
  MAV_CMD_DO_MOTOR_TEST(209L),
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
  MAV_CMD_DO_INVERTED_FLIGHT(210L),
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
  MAV_CMD_DO_GRIPPER(211L),
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
  MAV_CMD_DO_AUTOTUNE_ENABLE(212L),
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
  MAV_CMD_NAV_SET_YAW_SPEED(213L),
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
  MAV_CMD_DO_SET_CAM_TRIGG_INTERVAL(214L),
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
  MAV_CMD_DO_MOUNT_CONTROL_QUAT(220L),
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
  MAV_CMD_DO_GUIDED_MASTER(221L),
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
  MAV_CMD_DO_GUIDED_LIMITS(222L),
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
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  MAV_CMD_DO_ENGINE_CONTROL(223L),
  /**
   * Set the mission item with sequence number seq as current item. This means that the MAV will
   * continue to this mission item on the shortest path (not following the mission items in-between).
   *
   * index = 1; label = Number; 
   * Mission sequence value to set
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
   * index = 5; 
   * Empty
   *
   * index = 6; 
   * Empty
   *
   * index = 7; 
   * Empty
   */
  MAV_CMD_DO_SET_MISSION_CURRENT(224L),
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
  MAV_CMD_DO_LAST(240L),
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
  MAV_CMD_PREFLIGHT_CALIBRATION(241L),
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
  MAV_CMD_PREFLIGHT_SET_SENSOR_OFFSETS(242L),
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
  MAV_CMD_PREFLIGHT_UAVCAN(243L),
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
  MAV_CMD_PREFLIGHT_STORAGE(245L),
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
  MAV_CMD_PREFLIGHT_REBOOT_SHUTDOWN(246L),
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
  MAV_CMD_OVERRIDE_GOTO(252L),
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
  MAV_CMD_OBLIQUE_SURVEY(260L),
  /**
   * start running a mission
   *
   * index = 1; label = First Item; 
   * first_item: the first mission item to run
   *
   * index = 2; label = Last Item; 
   * last_item:  the last mission item to run (after this item is run, the mission ends)
   */
  MAV_CMD_MISSION_START(300L),
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
  MAV_CMD_ACTUATOR_TEST(310L),
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
  MAV_CMD_CONFIGURE_ACTUATOR(311L),
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
  MAV_CMD_COMPONENT_ARM_DISARM(400L),
  /**
   * Instructs system to run pre-arm checks. This command should return
   * MAV_RESULT_TEMPORARILY_REJECTED in the case the system is armed, otherwise MAV_RESULT_ACCEPTED.
   * Note that the return value from executing this command does not indicate whether the vehicle is
   * armable or not, just whether the system has successfully run/is currently running the checks.  The
   * result of the checks is reflected in the SYS_STATUS message.
   */
  MAV_CMD_RUN_PREARM_CHECKS(401L),
  /**
   * Turns illuminators ON/OFF. An illuminator is a light source that is used for lighting up dark
   * areas external to the sytstem: e.g. a torch or searchlight (as opposed to a light source for
   * illuminating the system itself, e.g. an indicator light).
   *
   * index = 1; label = Enable; 
   * 0: Illuminators OFF, 1: Illuminators ON
   */
  @WorkInProgress
  MAV_CMD_ILLUMINATOR_ON_OFF(405L),
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
  MAV_CMD_GET_HOME_POSITION(410L),
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
  MAV_CMD_INJECT_FAILURE(420L),
  /**
   * Starts receiver pairing.
   *
   * index = 1; label = Spektrum; 
   * 0:Spektrum.
   *
   * index = 2; label = RC Type; 
   * RC type.
   */
  MAV_CMD_START_RX_PAIR(500L),
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
  MAV_CMD_GET_MESSAGE_INTERVAL(510L),
  /**
   * Set the interval between messages for a particular MAVLink message ID. This interface replaces
   * REQUEST_DATA_STREAM.
   *
   * index = 1; label = Message ID; 
   * The MAVLink message ID
   *
   * index = 2; label = Interval; units = us; 
   * The interval between two messages. Set to -1 to disable and 0 to request default rate.
   *
   * index = 7; label = Response Target; 
   * Target address of message stream (if message has target address fields). 0: Flight-stack
   * default (recommended), 1: address of requestor, 2: broadcast.
   */
  MAV_CMD_SET_MESSAGE_INTERVAL(511L),
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
  MAV_CMD_REQUEST_MESSAGE(512L),
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
  MAV_CMD_REQUEST_PROTOCOL_VERSION(519L),
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
  MAV_CMD_REQUEST_AUTOPILOT_CAPABILITIES(520L),
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
  MAV_CMD_REQUEST_CAMERA_INFORMATION(521L),
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
  MAV_CMD_REQUEST_CAMERA_SETTINGS(522L),
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
  MAV_CMD_REQUEST_STORAGE_INFORMATION(525L),
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
  MAV_CMD_STORAGE_FORMAT(526L),
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
  MAV_CMD_REQUEST_CAMERA_CAPTURE_STATUS(527L),
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
  MAV_CMD_REQUEST_FLIGHT_INFORMATION(528L),
  /**
   * Reset all camera settings to Factory Default
   *
   * index = 1; label = Reset; 
   * 0: No Action 1: Reset all settings
   *
   * index = 2; 
   * Reserved (all remaining params)
   */
  MAV_CMD_RESET_CAMERA_SETTINGS(529L),
  /**
   * Set camera running mode. Use NaN for reserved values. GCS will send a
   * MAV_CMD_REQUEST_VIDEO_STREAM_STATUS command after a mode change if the camera supports video
   * streaming.
   *
   * index = 1; 
   * Reserved (Set to 0)
   *
   * index = 2; label = Camera Mode; 
   * Camera mode
   *
   * index = 3; index = 4; index = 7; 
   */
  MAV_CMD_SET_CAMERA_MODE(530L),
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
  MAV_CMD_SET_CAMERA_ZOOM(531L),
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
  MAV_CMD_SET_CAMERA_FOCUS(532L),
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
  MAV_CMD_SET_STORAGE_USAGE(533L),
  /**
   * Tagged jump target. Can be jumped to with MAV_CMD_DO_JUMP_TAG.
   *
   * index = 1; label = Tag; 
   * Tag.
   */
  MAV_CMD_JUMP_TAG(600L),
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
  MAV_CMD_DO_JUMP_TAG(601L),
  /**
   * High level setpoint to be sent to a gimbal manager to set a gimbal attitude. It is possible to
   * set combinations of the values below. E.g. an angle as well as a desired angular rate can be used
   * to get to this angle at a certain angular rate, or an angular rate only will result in continuous
   * turning. NaN is to be used to signal unset. Note: a gimbal is never to react to this command but
   * only the gimbal manager.
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
  @WorkInProgress
  MAV_CMD_DO_GIMBAL_MANAGER_PITCHYAW(1000L),
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
  @WorkInProgress
  MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE(1001L),
  /**
   * Start image capture sequence. Sends CAMERA_IMAGE_CAPTURED after each capture. Use NaN for
   * reserved values.
   *
   * index = 1; 
   * Reserved (Set to 0)
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
  MAV_CMD_IMAGE_START_CAPTURE(2000L),
  /**
   * Stop image capture sequence Use NaN for reserved values.
   *
   * index = 1; 
   * Reserved (Set to 0)
   *
   * index = 2; index = 3; index = 4; index = 7; 
   */
  MAV_CMD_IMAGE_STOP_CAPTURE(2001L),
  /**
   * Re-request a CAMERA_IMAGE_CAPTURED message.
   *
   * index = 1; label = Number; 
   * Sequence number for missing CAMERA_IMAGE_CAPTURED message
   *
   * index = 2; index = 3; index = 4; index = 7; 
   */
  @Deprecated(message = "")
  MAV_CMD_REQUEST_CAMERA_IMAGE_CAPTURE(2002L),
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
  MAV_CMD_DO_TRIGGER_CONTROL(2003L),
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
   * Point radius (normalized 0..1, 0 is image left, 1 is image right).
   */
  @WorkInProgress
  MAV_CMD_CAMERA_TRACK_POINT(2004L),
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
  @WorkInProgress
  MAV_CMD_CAMERA_TRACK_RECTANGLE(2005L),
  /**
   * Stops ongoing tracking.
   */
  @WorkInProgress
  MAV_CMD_CAMERA_STOP_TRACKING(2010L),
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
  MAV_CMD_VIDEO_START_CAPTURE(2500L),
  /**
   * Stop the current video capture (recording).
   *
   * index = 1; label = Stream ID; 
   * Video Stream ID (0 for all streams)
   *
   * index = 2; index = 3; index = 4; index = 5; index = 6; index = 7; 
   */
  MAV_CMD_VIDEO_STOP_CAPTURE(2501L),
  /**
   * Start video streaming
   *
   * index = 1; label = Stream ID; 
   * Video Stream ID (0 for all streams, 1 for first, 2 for second, etc.)
   */
  MAV_CMD_VIDEO_START_STREAMING(2502L),
  /**
   * Stop the given video stream
   *
   * index = 1; label = Stream ID; 
   * Video Stream ID (0 for all streams, 1 for first, 2 for second, etc.)
   */
  MAV_CMD_VIDEO_STOP_STREAMING(2503L),
  /**
   * Request video stream information (VIDEO_STREAM_INFORMATION)
   *
   * index = 1; label = Stream ID; 
   * Video Stream ID (0 for all streams, 1 for first, 2 for second, etc.)
   */
  @Deprecated(message = "")
  MAV_CMD_REQUEST_VIDEO_STREAM_INFORMATION(2504L),
  /**
   * Request video stream status (VIDEO_STREAM_STATUS)
   *
   * index = 1; label = Stream ID; 
   * Video Stream ID (0 for all streams, 1 for first, 2 for second, etc.)
   */
  @Deprecated(message = "")
  MAV_CMD_REQUEST_VIDEO_STREAM_STATUS(2505L),
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
  MAV_CMD_LOGGING_START(2510L),
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
  MAV_CMD_LOGGING_STOP(2511L),
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
  MAV_CMD_AIRFRAME_CONFIGURATION(2520L),
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
  MAV_CMD_CONTROL_HIGH_LATENCY(2600L),
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
  MAV_CMD_PANORAMA_CREATE(2800L),
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
  MAV_CMD_DO_VTOL_TRANSITION(3000L),
  /**
   * Request authorization to arm the vehicle to a external entity, the arm authorizer is
   * responsible to request all data that is needs from the vehicle before authorize or deny the
   * request. If approved the progress of command_ack message should be set with period of time that
   * this authorization is valid in seconds or in case it was denied it should be set with one of the
   * reasons in ARM_AUTH_DENIED_REASON.
   *         
   *
   * index = 1; label = System ID; 
   * Vehicle system id, this way ground station can request arm authorization on behalf of any
   * vehicle
   */
  MAV_CMD_ARM_AUTHORIZATION_REQUEST(3001L),
  /**
   * This command sets the submode to standard guided when vehicle is in guided mode. The vehicle
   * holds position and altitude and the user can input the desired velocities along all three axes.
   *                   
   */
  MAV_CMD_SET_GUIDED_SUBMODE_STANDARD(4000L),
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
  MAV_CMD_SET_GUIDED_SUBMODE_CIRCLE(4001L),
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
  MAV_CMD_CONDITION_GATE(4501L),
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
  MAV_CMD_NAV_FENCE_RETURN_POINT(5000L),
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
  MAV_CMD_NAV_FENCE_POLYGON_VERTEX_INCLUSION(5001L),
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
  MAV_CMD_NAV_FENCE_POLYGON_VERTEX_EXCLUSION(5002L),
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
  MAV_CMD_NAV_FENCE_CIRCLE_INCLUSION(5003L),
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
  MAV_CMD_NAV_FENCE_CIRCLE_EXCLUSION(5004L),
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
  MAV_CMD_NAV_RALLY_POINT(5100L),
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
  MAV_CMD_UAVCAN_GET_NODE_INFO(5200L),
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
  MAV_CMD_DO_ADSB_OUT_IDENT(10001L),
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
   * Latitude. Note, if used in MISSION_ITEM (deprecated) the units are degrees (unscaled)
   *
   * index = 6; label = Longitude; units = degE7; 
   * Longitude. Note, if used in MISSION_ITEM (deprecated) the units are degrees (unscaled)
   *
   * index = 7; label = Altitude; units = m; 
   * Altitude (MSL)
   */
  @Deprecated(message = "")
  MAV_CMD_PAYLOAD_PREPARE_DEPLOY(30001L),
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
  MAV_CMD_PAYLOAD_CONTROL_DEPLOY(30002L),
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
  MAV_CMD_FIXED_MAG_CAL_YAW(42006L),
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
  MAV_CMD_DO_WINCH(42600L),
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
  MAV_CMD_WAYPOINT_USER_1(31000L),
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
  MAV_CMD_WAYPOINT_USER_2(31001L),
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
  MAV_CMD_WAYPOINT_USER_3(31002L),
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
  MAV_CMD_WAYPOINT_USER_4(31003L),
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
  MAV_CMD_WAYPOINT_USER_5(31004L),
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
  MAV_CMD_SPATIAL_USER_1(31005L),
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
  MAV_CMD_SPATIAL_USER_2(31006L),
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
  MAV_CMD_SPATIAL_USER_3(31007L),
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
  MAV_CMD_SPATIAL_USER_4(31008L),
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
  MAV_CMD_SPATIAL_USER_5(31009L),
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
  MAV_CMD_USER_1(31010L),
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
  MAV_CMD_USER_2(31011L),
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
  MAV_CMD_USER_3(31012L),
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
  MAV_CMD_USER_4(31013L),
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
  MAV_CMD_USER_5(31014L),
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
  MAV_CMD_CAN_FORWARD(32000L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavCmd? = when (v) {
      16L -> MAV_CMD_NAV_WAYPOINT
      17L -> MAV_CMD_NAV_LOITER_UNLIM
      18L -> MAV_CMD_NAV_LOITER_TURNS
      19L -> MAV_CMD_NAV_LOITER_TIME
      20L -> MAV_CMD_NAV_RETURN_TO_LAUNCH
      21L -> MAV_CMD_NAV_LAND
      22L -> MAV_CMD_NAV_TAKEOFF
      23L -> MAV_CMD_NAV_LAND_LOCAL
      24L -> MAV_CMD_NAV_TAKEOFF_LOCAL
      25L -> MAV_CMD_NAV_FOLLOW
      30L -> MAV_CMD_NAV_CONTINUE_AND_CHANGE_ALT
      31L -> MAV_CMD_NAV_LOITER_TO_ALT
      32L -> MAV_CMD_DO_FOLLOW
      33L -> MAV_CMD_DO_FOLLOW_REPOSITION
      34L -> MAV_CMD_DO_ORBIT
      80L -> MAV_CMD_NAV_ROI
      81L -> MAV_CMD_NAV_PATHPLANNING
      82L -> MAV_CMD_NAV_SPLINE_WAYPOINT
      84L -> MAV_CMD_NAV_VTOL_TAKEOFF
      85L -> MAV_CMD_NAV_VTOL_LAND
      92L -> MAV_CMD_NAV_GUIDED_ENABLE
      93L -> MAV_CMD_NAV_DELAY
      94L -> MAV_CMD_NAV_PAYLOAD_PLACE
      95L -> MAV_CMD_NAV_LAST
      112L -> MAV_CMD_CONDITION_DELAY
      113L -> MAV_CMD_CONDITION_CHANGE_ALT
      114L -> MAV_CMD_CONDITION_DISTANCE
      115L -> MAV_CMD_CONDITION_YAW
      159L -> MAV_CMD_CONDITION_LAST
      176L -> MAV_CMD_DO_SET_MODE
      177L -> MAV_CMD_DO_JUMP
      178L -> MAV_CMD_DO_CHANGE_SPEED
      179L -> MAV_CMD_DO_SET_HOME
      180L -> MAV_CMD_DO_SET_PARAMETER
      181L -> MAV_CMD_DO_SET_RELAY
      182L -> MAV_CMD_DO_REPEAT_RELAY
      183L -> MAV_CMD_DO_SET_SERVO
      184L -> MAV_CMD_DO_REPEAT_SERVO
      185L -> MAV_CMD_DO_FLIGHTTERMINATION
      186L -> MAV_CMD_DO_CHANGE_ALTITUDE
      187L -> MAV_CMD_DO_SET_ACTUATOR
      189L -> MAV_CMD_DO_LAND_START
      190L -> MAV_CMD_DO_RALLY_LAND
      191L -> MAV_CMD_DO_GO_AROUND
      192L -> MAV_CMD_DO_REPOSITION
      193L -> MAV_CMD_DO_PAUSE_CONTINUE
      194L -> MAV_CMD_DO_SET_REVERSE
      195L -> MAV_CMD_DO_SET_ROI_LOCATION
      196L -> MAV_CMD_DO_SET_ROI_WPNEXT_OFFSET
      197L -> MAV_CMD_DO_SET_ROI_NONE
      198L -> MAV_CMD_DO_SET_ROI_SYSID
      200L -> MAV_CMD_DO_CONTROL_VIDEO
      201L -> MAV_CMD_DO_SET_ROI
      202L -> MAV_CMD_DO_DIGICAM_CONFIGURE
      203L -> MAV_CMD_DO_DIGICAM_CONTROL
      204L -> MAV_CMD_DO_MOUNT_CONFIGURE
      205L -> MAV_CMD_DO_MOUNT_CONTROL
      206L -> MAV_CMD_DO_SET_CAM_TRIGG_DIST
      207L -> MAV_CMD_DO_FENCE_ENABLE
      208L -> MAV_CMD_DO_PARACHUTE
      209L -> MAV_CMD_DO_MOTOR_TEST
      210L -> MAV_CMD_DO_INVERTED_FLIGHT
      211L -> MAV_CMD_DO_GRIPPER
      212L -> MAV_CMD_DO_AUTOTUNE_ENABLE
      213L -> MAV_CMD_NAV_SET_YAW_SPEED
      214L -> MAV_CMD_DO_SET_CAM_TRIGG_INTERVAL
      220L -> MAV_CMD_DO_MOUNT_CONTROL_QUAT
      221L -> MAV_CMD_DO_GUIDED_MASTER
      222L -> MAV_CMD_DO_GUIDED_LIMITS
      223L -> MAV_CMD_DO_ENGINE_CONTROL
      224L -> MAV_CMD_DO_SET_MISSION_CURRENT
      240L -> MAV_CMD_DO_LAST
      241L -> MAV_CMD_PREFLIGHT_CALIBRATION
      242L -> MAV_CMD_PREFLIGHT_SET_SENSOR_OFFSETS
      243L -> MAV_CMD_PREFLIGHT_UAVCAN
      245L -> MAV_CMD_PREFLIGHT_STORAGE
      246L -> MAV_CMD_PREFLIGHT_REBOOT_SHUTDOWN
      252L -> MAV_CMD_OVERRIDE_GOTO
      260L -> MAV_CMD_OBLIQUE_SURVEY
      300L -> MAV_CMD_MISSION_START
      310L -> MAV_CMD_ACTUATOR_TEST
      311L -> MAV_CMD_CONFIGURE_ACTUATOR
      400L -> MAV_CMD_COMPONENT_ARM_DISARM
      401L -> MAV_CMD_RUN_PREARM_CHECKS
      405L -> MAV_CMD_ILLUMINATOR_ON_OFF
      410L -> MAV_CMD_GET_HOME_POSITION
      420L -> MAV_CMD_INJECT_FAILURE
      500L -> MAV_CMD_START_RX_PAIR
      510L -> MAV_CMD_GET_MESSAGE_INTERVAL
      511L -> MAV_CMD_SET_MESSAGE_INTERVAL
      512L -> MAV_CMD_REQUEST_MESSAGE
      519L -> MAV_CMD_REQUEST_PROTOCOL_VERSION
      520L -> MAV_CMD_REQUEST_AUTOPILOT_CAPABILITIES
      521L -> MAV_CMD_REQUEST_CAMERA_INFORMATION
      522L -> MAV_CMD_REQUEST_CAMERA_SETTINGS
      525L -> MAV_CMD_REQUEST_STORAGE_INFORMATION
      526L -> MAV_CMD_STORAGE_FORMAT
      527L -> MAV_CMD_REQUEST_CAMERA_CAPTURE_STATUS
      528L -> MAV_CMD_REQUEST_FLIGHT_INFORMATION
      529L -> MAV_CMD_RESET_CAMERA_SETTINGS
      530L -> MAV_CMD_SET_CAMERA_MODE
      531L -> MAV_CMD_SET_CAMERA_ZOOM
      532L -> MAV_CMD_SET_CAMERA_FOCUS
      533L -> MAV_CMD_SET_STORAGE_USAGE
      600L -> MAV_CMD_JUMP_TAG
      601L -> MAV_CMD_DO_JUMP_TAG
      1000L -> MAV_CMD_DO_GIMBAL_MANAGER_PITCHYAW
      1001L -> MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE
      2000L -> MAV_CMD_IMAGE_START_CAPTURE
      2001L -> MAV_CMD_IMAGE_STOP_CAPTURE
      2002L -> MAV_CMD_REQUEST_CAMERA_IMAGE_CAPTURE
      2003L -> MAV_CMD_DO_TRIGGER_CONTROL
      2004L -> MAV_CMD_CAMERA_TRACK_POINT
      2005L -> MAV_CMD_CAMERA_TRACK_RECTANGLE
      2010L -> MAV_CMD_CAMERA_STOP_TRACKING
      2500L -> MAV_CMD_VIDEO_START_CAPTURE
      2501L -> MAV_CMD_VIDEO_STOP_CAPTURE
      2502L -> MAV_CMD_VIDEO_START_STREAMING
      2503L -> MAV_CMD_VIDEO_STOP_STREAMING
      2504L -> MAV_CMD_REQUEST_VIDEO_STREAM_INFORMATION
      2505L -> MAV_CMD_REQUEST_VIDEO_STREAM_STATUS
      2510L -> MAV_CMD_LOGGING_START
      2511L -> MAV_CMD_LOGGING_STOP
      2520L -> MAV_CMD_AIRFRAME_CONFIGURATION
      2600L -> MAV_CMD_CONTROL_HIGH_LATENCY
      2800L -> MAV_CMD_PANORAMA_CREATE
      3000L -> MAV_CMD_DO_VTOL_TRANSITION
      3001L -> MAV_CMD_ARM_AUTHORIZATION_REQUEST
      4000L -> MAV_CMD_SET_GUIDED_SUBMODE_STANDARD
      4001L -> MAV_CMD_SET_GUIDED_SUBMODE_CIRCLE
      4501L -> MAV_CMD_CONDITION_GATE
      5000L -> MAV_CMD_NAV_FENCE_RETURN_POINT
      5001L -> MAV_CMD_NAV_FENCE_POLYGON_VERTEX_INCLUSION
      5002L -> MAV_CMD_NAV_FENCE_POLYGON_VERTEX_EXCLUSION
      5003L -> MAV_CMD_NAV_FENCE_CIRCLE_INCLUSION
      5004L -> MAV_CMD_NAV_FENCE_CIRCLE_EXCLUSION
      5100L -> MAV_CMD_NAV_RALLY_POINT
      5200L -> MAV_CMD_UAVCAN_GET_NODE_INFO
      10001L -> MAV_CMD_DO_ADSB_OUT_IDENT
      30001L -> MAV_CMD_PAYLOAD_PREPARE_DEPLOY
      30002L -> MAV_CMD_PAYLOAD_CONTROL_DEPLOY
      42006L -> MAV_CMD_FIXED_MAG_CAL_YAW
      42600L -> MAV_CMD_DO_WINCH
      31000L -> MAV_CMD_WAYPOINT_USER_1
      31001L -> MAV_CMD_WAYPOINT_USER_2
      31002L -> MAV_CMD_WAYPOINT_USER_3
      31003L -> MAV_CMD_WAYPOINT_USER_4
      31004L -> MAV_CMD_WAYPOINT_USER_5
      31005L -> MAV_CMD_SPATIAL_USER_1
      31006L -> MAV_CMD_SPATIAL_USER_2
      31007L -> MAV_CMD_SPATIAL_USER_3
      31008L -> MAV_CMD_SPATIAL_USER_4
      31009L -> MAV_CMD_SPATIAL_USER_5
      31010L -> MAV_CMD_USER_1
      31011L -> MAV_CMD_USER_2
      31012L -> MAV_CMD_USER_3
      31013L -> MAV_CMD_USER_4
      31014L -> MAV_CMD_USER_5
      32000L -> MAV_CMD_CAN_FORWARD
      else -> null
    }
  }
}
