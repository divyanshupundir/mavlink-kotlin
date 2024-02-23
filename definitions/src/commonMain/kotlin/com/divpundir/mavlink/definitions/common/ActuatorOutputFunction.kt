package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Actuator output function. Values greater or equal to 1000 are autopilot-specific.
 */
@GeneratedMavEnum
public enum class ActuatorOutputFunction(
  override val `value`: UInt,
) : MavEnum {
  /**
   * No function (disabled).
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Motor 1
   */
  @GeneratedMavEnumEntry
  MOTOR1(1u),
  /**
   * Motor 2
   */
  @GeneratedMavEnumEntry
  MOTOR2(2u),
  /**
   * Motor 3
   */
  @GeneratedMavEnumEntry
  MOTOR3(3u),
  /**
   * Motor 4
   */
  @GeneratedMavEnumEntry
  MOTOR4(4u),
  /**
   * Motor 5
   */
  @GeneratedMavEnumEntry
  MOTOR5(5u),
  /**
   * Motor 6
   */
  @GeneratedMavEnumEntry
  MOTOR6(6u),
  /**
   * Motor 7
   */
  @GeneratedMavEnumEntry
  MOTOR7(7u),
  /**
   * Motor 8
   */
  @GeneratedMavEnumEntry
  MOTOR8(8u),
  /**
   * Motor 9
   */
  @GeneratedMavEnumEntry
  MOTOR9(9u),
  /**
   * Motor 10
   */
  @GeneratedMavEnumEntry
  MOTOR10(10u),
  /**
   * Motor 11
   */
  @GeneratedMavEnumEntry
  MOTOR11(11u),
  /**
   * Motor 12
   */
  @GeneratedMavEnumEntry
  MOTOR12(12u),
  /**
   * Motor 13
   */
  @GeneratedMavEnumEntry
  MOTOR13(13u),
  /**
   * Motor 14
   */
  @GeneratedMavEnumEntry
  MOTOR14(14u),
  /**
   * Motor 15
   */
  @GeneratedMavEnumEntry
  MOTOR15(15u),
  /**
   * Motor 16
   */
  @GeneratedMavEnumEntry
  MOTOR16(16u),
  /**
   * Servo 1
   */
  @GeneratedMavEnumEntry
  SERVO1(33u),
  /**
   * Servo 2
   */
  @GeneratedMavEnumEntry
  SERVO2(34u),
  /**
   * Servo 3
   */
  @GeneratedMavEnumEntry
  SERVO3(35u),
  /**
   * Servo 4
   */
  @GeneratedMavEnumEntry
  SERVO4(36u),
  /**
   * Servo 5
   */
  @GeneratedMavEnumEntry
  SERVO5(37u),
  /**
   * Servo 6
   */
  @GeneratedMavEnumEntry
  SERVO6(38u),
  /**
   * Servo 7
   */
  @GeneratedMavEnumEntry
  SERVO7(39u),
  /**
   * Servo 8
   */
  @GeneratedMavEnumEntry
  SERVO8(40u),
  /**
   * Servo 9
   */
  @GeneratedMavEnumEntry
  SERVO9(41u),
  /**
   * Servo 10
   */
  @GeneratedMavEnumEntry
  SERVO10(42u),
  /**
   * Servo 11
   */
  @GeneratedMavEnumEntry
  SERVO11(43u),
  /**
   * Servo 12
   */
  @GeneratedMavEnumEntry
  SERVO12(44u),
  /**
   * Servo 13
   */
  @GeneratedMavEnumEntry
  SERVO13(45u),
  /**
   * Servo 14
   */
  @GeneratedMavEnumEntry
  SERVO14(46u),
  /**
   * Servo 15
   */
  @GeneratedMavEnumEntry
  SERVO15(47u),
  /**
   * Servo 16
   */
  @GeneratedMavEnumEntry
  SERVO16(48u),
  ;

  public companion object : MavEnum.MavCompanion<ActuatorOutputFunction> {
    override fun getEntryFromValueOrNull(v: UInt): ActuatorOutputFunction? = when (v) {
      0u -> NONE
      1u -> MOTOR1
      2u -> MOTOR2
      3u -> MOTOR3
      4u -> MOTOR4
      5u -> MOTOR5
      6u -> MOTOR6
      7u -> MOTOR7
      8u -> MOTOR8
      9u -> MOTOR9
      10u -> MOTOR10
      11u -> MOTOR11
      12u -> MOTOR12
      13u -> MOTOR13
      14u -> MOTOR14
      15u -> MOTOR15
      16u -> MOTOR16
      33u -> SERVO1
      34u -> SERVO2
      35u -> SERVO3
      36u -> SERVO4
      37u -> SERVO5
      38u -> SERVO6
      39u -> SERVO7
      40u -> SERVO8
      41u -> SERVO9
      42u -> SERVO10
      43u -> SERVO11
      44u -> SERVO12
      45u -> SERVO13
      46u -> SERVO14
      47u -> SERVO15
      48u -> SERVO16
      else -> null
    }
  }
}
