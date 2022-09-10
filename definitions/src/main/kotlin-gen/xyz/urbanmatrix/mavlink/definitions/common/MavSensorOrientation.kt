package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Enumeration of sensor orientation, according to its rotations
 */
@GeneratedMavEnum
public enum class MavSensorOrientation(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Roll: 0, Pitch: 0, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_NONE(0L),
  /**
   * Roll: 0, Pitch: 0, Yaw: 45
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_YAW_45(1L),
  /**
   * Roll: 0, Pitch: 0, Yaw: 90
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_YAW_90(2L),
  /**
   * Roll: 0, Pitch: 0, Yaw: 135
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_YAW_135(3L),
  /**
   * Roll: 0, Pitch: 0, Yaw: 180
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_YAW_180(4L),
  /**
   * Roll: 0, Pitch: 0, Yaw: 225
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_YAW_225(5L),
  /**
   * Roll: 0, Pitch: 0, Yaw: 270
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_YAW_270(6L),
  /**
   * Roll: 0, Pitch: 0, Yaw: 315
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_YAW_315(7L),
  /**
   * Roll: 180, Pitch: 0, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_180(8L),
  /**
   * Roll: 180, Pitch: 0, Yaw: 45
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_180_YAW_45(9L),
  /**
   * Roll: 180, Pitch: 0, Yaw: 90
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_180_YAW_90(10L),
  /**
   * Roll: 180, Pitch: 0, Yaw: 135
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_180_YAW_135(11L),
  /**
   * Roll: 0, Pitch: 180, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_PITCH_180(12L),
  /**
   * Roll: 180, Pitch: 0, Yaw: 225
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_180_YAW_225(13L),
  /**
   * Roll: 180, Pitch: 0, Yaw: 270
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_180_YAW_270(14L),
  /**
   * Roll: 180, Pitch: 0, Yaw: 315
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_180_YAW_315(15L),
  /**
   * Roll: 90, Pitch: 0, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90(16L),
  /**
   * Roll: 90, Pitch: 0, Yaw: 45
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_YAW_45(17L),
  /**
   * Roll: 90, Pitch: 0, Yaw: 90
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_YAW_90(18L),
  /**
   * Roll: 90, Pitch: 0, Yaw: 135
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_YAW_135(19L),
  /**
   * Roll: 270, Pitch: 0, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_270(20L),
  /**
   * Roll: 270, Pitch: 0, Yaw: 45
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_270_YAW_45(21L),
  /**
   * Roll: 270, Pitch: 0, Yaw: 90
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_270_YAW_90(22L),
  /**
   * Roll: 270, Pitch: 0, Yaw: 135
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_270_YAW_135(23L),
  /**
   * Roll: 0, Pitch: 90, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_PITCH_90(24L),
  /**
   * Roll: 0, Pitch: 270, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_PITCH_270(25L),
  /**
   * Roll: 0, Pitch: 180, Yaw: 90
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_PITCH_180_YAW_90(26L),
  /**
   * Roll: 0, Pitch: 180, Yaw: 270
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_PITCH_180_YAW_270(27L),
  /**
   * Roll: 90, Pitch: 90, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_PITCH_90(28L),
  /**
   * Roll: 180, Pitch: 90, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_180_PITCH_90(29L),
  /**
   * Roll: 270, Pitch: 90, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_270_PITCH_90(30L),
  /**
   * Roll: 90, Pitch: 180, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_PITCH_180(31L),
  /**
   * Roll: 270, Pitch: 180, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_270_PITCH_180(32L),
  /**
   * Roll: 90, Pitch: 270, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_PITCH_270(33L),
  /**
   * Roll: 180, Pitch: 270, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_180_PITCH_270(34L),
  /**
   * Roll: 270, Pitch: 270, Yaw: 0
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_270_PITCH_270(35L),
  /**
   * Roll: 90, Pitch: 180, Yaw: 90
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_PITCH_180_YAW_90(36L),
  /**
   * Roll: 90, Pitch: 0, Yaw: 270
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_YAW_270(37L),
  /**
   * Roll: 90, Pitch: 68, Yaw: 293
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_PITCH_68_YAW_293(38L),
  /**
   * Pitch: 315
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_PITCH_315(39L),
  /**
   * Roll: 90, Pitch: 315
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_ROLL_90_PITCH_315(40L),
  /**
   * Custom orientation
   */
  @GeneratedMavEnumEntry
  MAV_SENSOR_ROTATION_CUSTOM(100L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavSensorOrientation? = when (v) {
      0L -> MAV_SENSOR_ROTATION_NONE
      1L -> MAV_SENSOR_ROTATION_YAW_45
      2L -> MAV_SENSOR_ROTATION_YAW_90
      3L -> MAV_SENSOR_ROTATION_YAW_135
      4L -> MAV_SENSOR_ROTATION_YAW_180
      5L -> MAV_SENSOR_ROTATION_YAW_225
      6L -> MAV_SENSOR_ROTATION_YAW_270
      7L -> MAV_SENSOR_ROTATION_YAW_315
      8L -> MAV_SENSOR_ROTATION_ROLL_180
      9L -> MAV_SENSOR_ROTATION_ROLL_180_YAW_45
      10L -> MAV_SENSOR_ROTATION_ROLL_180_YAW_90
      11L -> MAV_SENSOR_ROTATION_ROLL_180_YAW_135
      12L -> MAV_SENSOR_ROTATION_PITCH_180
      13L -> MAV_SENSOR_ROTATION_ROLL_180_YAW_225
      14L -> MAV_SENSOR_ROTATION_ROLL_180_YAW_270
      15L -> MAV_SENSOR_ROTATION_ROLL_180_YAW_315
      16L -> MAV_SENSOR_ROTATION_ROLL_90
      17L -> MAV_SENSOR_ROTATION_ROLL_90_YAW_45
      18L -> MAV_SENSOR_ROTATION_ROLL_90_YAW_90
      19L -> MAV_SENSOR_ROTATION_ROLL_90_YAW_135
      20L -> MAV_SENSOR_ROTATION_ROLL_270
      21L -> MAV_SENSOR_ROTATION_ROLL_270_YAW_45
      22L -> MAV_SENSOR_ROTATION_ROLL_270_YAW_90
      23L -> MAV_SENSOR_ROTATION_ROLL_270_YAW_135
      24L -> MAV_SENSOR_ROTATION_PITCH_90
      25L -> MAV_SENSOR_ROTATION_PITCH_270
      26L -> MAV_SENSOR_ROTATION_PITCH_180_YAW_90
      27L -> MAV_SENSOR_ROTATION_PITCH_180_YAW_270
      28L -> MAV_SENSOR_ROTATION_ROLL_90_PITCH_90
      29L -> MAV_SENSOR_ROTATION_ROLL_180_PITCH_90
      30L -> MAV_SENSOR_ROTATION_ROLL_270_PITCH_90
      31L -> MAV_SENSOR_ROTATION_ROLL_90_PITCH_180
      32L -> MAV_SENSOR_ROTATION_ROLL_270_PITCH_180
      33L -> MAV_SENSOR_ROTATION_ROLL_90_PITCH_270
      34L -> MAV_SENSOR_ROTATION_ROLL_180_PITCH_270
      35L -> MAV_SENSOR_ROTATION_ROLL_270_PITCH_270
      36L -> MAV_SENSOR_ROTATION_ROLL_90_PITCH_180_YAW_90
      37L -> MAV_SENSOR_ROTATION_ROLL_90_YAW_270
      38L -> MAV_SENSOR_ROTATION_ROLL_90_PITCH_68_YAW_293
      39L -> MAV_SENSOR_ROTATION_PITCH_315
      40L -> MAV_SENSOR_ROTATION_ROLL_90_PITCH_315
      100L -> MAV_SENSOR_ROTATION_CUSTOM
      else -> null
    }
  }
}
