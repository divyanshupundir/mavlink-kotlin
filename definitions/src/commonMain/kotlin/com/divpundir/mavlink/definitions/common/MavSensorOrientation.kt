package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Enumeration of sensor orientation, according to its rotations
 */
@GeneratedMavEnum
public enum class MavSensorOrientation(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Roll: 0, Pitch: 0, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_NONE(0u),
  /**
   * Roll: 0, Pitch: 0, Yaw: 45
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_YAW_45(1u),
  /**
   * Roll: 0, Pitch: 0, Yaw: 90
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_YAW_90(2u),
  /**
   * Roll: 0, Pitch: 0, Yaw: 135
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_YAW_135(3u),
  /**
   * Roll: 0, Pitch: 0, Yaw: 180
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_YAW_180(4u),
  /**
   * Roll: 0, Pitch: 0, Yaw: 225
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_YAW_225(5u),
  /**
   * Roll: 0, Pitch: 0, Yaw: 270
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_YAW_270(6u),
  /**
   * Roll: 0, Pitch: 0, Yaw: 315
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_YAW_315(7u),
  /**
   * Roll: 180, Pitch: 0, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_180(8u),
  /**
   * Roll: 180, Pitch: 0, Yaw: 45
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_180_YAW_45(9u),
  /**
   * Roll: 180, Pitch: 0, Yaw: 90
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_180_YAW_90(10u),
  /**
   * Roll: 180, Pitch: 0, Yaw: 135
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_180_YAW_135(11u),
  /**
   * Roll: 0, Pitch: 180, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_PITCH_180(12u),
  /**
   * Roll: 180, Pitch: 0, Yaw: 225
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_180_YAW_225(13u),
  /**
   * Roll: 180, Pitch: 0, Yaw: 270
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_180_YAW_270(14u),
  /**
   * Roll: 180, Pitch: 0, Yaw: 315
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_180_YAW_315(15u),
  /**
   * Roll: 90, Pitch: 0, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90(16u),
  /**
   * Roll: 90, Pitch: 0, Yaw: 45
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_YAW_45(17u),
  /**
   * Roll: 90, Pitch: 0, Yaw: 90
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_YAW_90(18u),
  /**
   * Roll: 90, Pitch: 0, Yaw: 135
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_YAW_135(19u),
  /**
   * Roll: 270, Pitch: 0, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_270(20u),
  /**
   * Roll: 270, Pitch: 0, Yaw: 45
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_270_YAW_45(21u),
  /**
   * Roll: 270, Pitch: 0, Yaw: 90
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_270_YAW_90(22u),
  /**
   * Roll: 270, Pitch: 0, Yaw: 135
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_270_YAW_135(23u),
  /**
   * Roll: 0, Pitch: 90, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_PITCH_90(24u),
  /**
   * Roll: 0, Pitch: 270, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_PITCH_270(25u),
  /**
   * Roll: 0, Pitch: 180, Yaw: 90
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_PITCH_180_YAW_90(26u),
  /**
   * Roll: 0, Pitch: 180, Yaw: 270
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_PITCH_180_YAW_270(27u),
  /**
   * Roll: 90, Pitch: 90, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_PITCH_90(28u),
  /**
   * Roll: 180, Pitch: 90, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_180_PITCH_90(29u),
  /**
   * Roll: 270, Pitch: 90, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_270_PITCH_90(30u),
  /**
   * Roll: 90, Pitch: 180, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_PITCH_180(31u),
  /**
   * Roll: 270, Pitch: 180, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_270_PITCH_180(32u),
  /**
   * Roll: 90, Pitch: 270, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_PITCH_270(33u),
  /**
   * Roll: 180, Pitch: 270, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_180_PITCH_270(34u),
  /**
   * Roll: 270, Pitch: 270, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_270_PITCH_270(35u),
  /**
   * Roll: 90, Pitch: 180, Yaw: 90
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_PITCH_180_YAW_90(36u),
  /**
   * Roll: 90, Pitch: 0, Yaw: 270
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_YAW_270(37u),
  /**
   * Roll: 90, Pitch: 68, Yaw: 293
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_PITCH_68_YAW_293(38u),
  /**
   * Pitch: 315
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_PITCH_315(39u),
  /**
   * Roll: 90, Pitch: 315
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_PITCH_315(40u),
  /**
   * Custom orientation
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_CUSTOM(100u),
  ;

  public companion object : MavEnum.MavCompanion<MavSensorOrientation> {
    override fun getEntryFromValueOrNull(v: UInt): MavSensorOrientation? = when (v) {
      0u -> MAV_SENSOR_ROTATION_NONE
      1u -> MAV_SENSOR_ROTATION_YAW_45
      2u -> MAV_SENSOR_ROTATION_YAW_90
      3u -> MAV_SENSOR_ROTATION_YAW_135
      4u -> MAV_SENSOR_ROTATION_YAW_180
      5u -> MAV_SENSOR_ROTATION_YAW_225
      6u -> MAV_SENSOR_ROTATION_YAW_270
      7u -> MAV_SENSOR_ROTATION_YAW_315
      8u -> MAV_SENSOR_ROTATION_ROLL_180
      9u -> MAV_SENSOR_ROTATION_ROLL_180_YAW_45
      10u -> MAV_SENSOR_ROTATION_ROLL_180_YAW_90
      11u -> MAV_SENSOR_ROTATION_ROLL_180_YAW_135
      12u -> MAV_SENSOR_ROTATION_PITCH_180
      13u -> MAV_SENSOR_ROTATION_ROLL_180_YAW_225
      14u -> MAV_SENSOR_ROTATION_ROLL_180_YAW_270
      15u -> MAV_SENSOR_ROTATION_ROLL_180_YAW_315
      16u -> MAV_SENSOR_ROTATION_ROLL_90
      17u -> MAV_SENSOR_ROTATION_ROLL_90_YAW_45
      18u -> MAV_SENSOR_ROTATION_ROLL_90_YAW_90
      19u -> MAV_SENSOR_ROTATION_ROLL_90_YAW_135
      20u -> MAV_SENSOR_ROTATION_ROLL_270
      21u -> MAV_SENSOR_ROTATION_ROLL_270_YAW_45
      22u -> MAV_SENSOR_ROTATION_ROLL_270_YAW_90
      23u -> MAV_SENSOR_ROTATION_ROLL_270_YAW_135
      24u -> MAV_SENSOR_ROTATION_PITCH_90
      25u -> MAV_SENSOR_ROTATION_PITCH_270
      26u -> MAV_SENSOR_ROTATION_PITCH_180_YAW_90
      27u -> MAV_SENSOR_ROTATION_PITCH_180_YAW_270
      28u -> MAV_SENSOR_ROTATION_ROLL_90_PITCH_90
      29u -> MAV_SENSOR_ROTATION_ROLL_180_PITCH_90
      30u -> MAV_SENSOR_ROTATION_ROLL_270_PITCH_90
      31u -> MAV_SENSOR_ROTATION_ROLL_90_PITCH_180
      32u -> MAV_SENSOR_ROTATION_ROLL_270_PITCH_180
      33u -> MAV_SENSOR_ROTATION_ROLL_90_PITCH_270
      34u -> MAV_SENSOR_ROTATION_ROLL_180_PITCH_270
      35u -> MAV_SENSOR_ROTATION_ROLL_270_PITCH_270
      36u -> MAV_SENSOR_ROTATION_ROLL_90_PITCH_180_YAW_90
      37u -> MAV_SENSOR_ROTATION_ROLL_90_YAW_270
      38u -> MAV_SENSOR_ROTATION_ROLL_90_PITCH_68_YAW_293
      39u -> MAV_SENSOR_ROTATION_PITCH_315
      40u -> MAV_SENSOR_ROTATION_ROLL_90_PITCH_315
      100u -> MAV_SENSOR_ROTATION_CUSTOM
      else -> null
    }
  }
}
