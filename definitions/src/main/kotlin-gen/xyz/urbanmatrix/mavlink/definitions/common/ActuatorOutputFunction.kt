package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Actuator output function. Values greater or equal to 1000 are autopilot-specific.
 */
@GeneratedMavEnum
public enum class ActuatorOutputFunction(
  public override val `value`: Long,
) : MavEnum {
  /**
   * No function (disabled).
   */
  @GeneratedMavEnumEntry
  NONE(0L),
  /**
   * Motor 1
   */
  @GeneratedMavEnumEntry
  MOTOR1(1L),
  /**
   * Motor 2
   */
  @GeneratedMavEnumEntry
  MOTOR2(2L),
  /**
   * Motor 3
   */
  @GeneratedMavEnumEntry
  MOTOR3(3L),
  /**
   * Motor 4
   */
  @GeneratedMavEnumEntry
  MOTOR4(4L),
  /**
   * Motor 5
   */
  @GeneratedMavEnumEntry
  MOTOR5(5L),
  /**
   * Motor 6
   */
  @GeneratedMavEnumEntry
  MOTOR6(6L),
  /**
   * Motor 7
   */
  @GeneratedMavEnumEntry
  MOTOR7(7L),
  /**
   * Motor 8
   */
  @GeneratedMavEnumEntry
  MOTOR8(8L),
  /**
   * Motor 9
   */
  @GeneratedMavEnumEntry
  MOTOR9(9L),
  /**
   * Motor 10
   */
  @GeneratedMavEnumEntry
  MOTOR10(10L),
  /**
   * Motor 11
   */
  @GeneratedMavEnumEntry
  MOTOR11(11L),
  /**
   * Motor 12
   */
  @GeneratedMavEnumEntry
  MOTOR12(12L),
  /**
   * Motor 13
   */
  @GeneratedMavEnumEntry
  MOTOR13(13L),
  /**
   * Motor 14
   */
  @GeneratedMavEnumEntry
  MOTOR14(14L),
  /**
   * Motor 15
   */
  @GeneratedMavEnumEntry
  MOTOR15(15L),
  /**
   * Motor 16
   */
  @GeneratedMavEnumEntry
  MOTOR16(16L),
  /**
   * Servo 1
   */
  @GeneratedMavEnumEntry
  SERVO1(33L),
  /**
   * Servo 2
   */
  @GeneratedMavEnumEntry
  SERVO2(34L),
  /**
   * Servo 3
   */
  @GeneratedMavEnumEntry
  SERVO3(35L),
  /**
   * Servo 4
   */
  @GeneratedMavEnumEntry
  SERVO4(36L),
  /**
   * Servo 5
   */
  @GeneratedMavEnumEntry
  SERVO5(37L),
  /**
   * Servo 6
   */
  @GeneratedMavEnumEntry
  SERVO6(38L),
  /**
   * Servo 7
   */
  @GeneratedMavEnumEntry
  SERVO7(39L),
  /**
   * Servo 8
   */
  @GeneratedMavEnumEntry
  SERVO8(40L),
  /**
   * Servo 9
   */
  @GeneratedMavEnumEntry
  SERVO9(41L),
  /**
   * Servo 10
   */
  @GeneratedMavEnumEntry
  SERVO10(42L),
  /**
   * Servo 11
   */
  @GeneratedMavEnumEntry
  SERVO11(43L),
  /**
   * Servo 12
   */
  @GeneratedMavEnumEntry
  SERVO12(44L),
  /**
   * Servo 13
   */
  @GeneratedMavEnumEntry
  SERVO13(45L),
  /**
   * Servo 14
   */
  @GeneratedMavEnumEntry
  SERVO14(46L),
  /**
   * Servo 15
   */
  @GeneratedMavEnumEntry
  SERVO15(47L),
  /**
   * Servo 16
   */
  @GeneratedMavEnumEntry
  SERVO16(48L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): ActuatorOutputFunction? = when (v) {
      0L -> NONE
      1L -> MOTOR1
      2L -> MOTOR2
      3L -> MOTOR3
      4L -> MOTOR4
      5L -> MOTOR5
      6L -> MOTOR6
      7L -> MOTOR7
      8L -> MOTOR8
      9L -> MOTOR9
      10L -> MOTOR10
      11L -> MOTOR11
      12L -> MOTOR12
      13L -> MOTOR13
      14L -> MOTOR14
      15L -> MOTOR15
      16L -> MOTOR16
      33L -> SERVO1
      34L -> SERVO2
      35L -> SERVO3
      36L -> SERVO4
      37L -> SERVO5
      38L -> SERVO6
      39L -> SERVO7
      40L -> SERVO8
      41L -> SERVO9
      42L -> SERVO10
      43L -> SERVO11
      44L -> SERVO12
      45L -> SERVO13
      46L -> SERVO14
      47L -> SERVO15
      48L -> SERVO16
      else -> null
    }
  }
}
