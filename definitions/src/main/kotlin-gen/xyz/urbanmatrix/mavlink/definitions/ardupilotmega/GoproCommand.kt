package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class GoproCommand(
  public override val `value`: Long,
) : MavEnum {
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  GOPRO_COMMAND_POWER(0L),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  GOPRO_COMMAND_CAPTURE_MODE(1L),
  /**
   * (___/Set).
   */
  @GeneratedMavEnumEntry
  GOPRO_COMMAND_SHUTTER(2L),
  /**
   * (Get/___).
   */
  @GeneratedMavEnumEntry
  GOPRO_COMMAND_BATTERY(3L),
  /**
   * (Get/___).
   */
  @GeneratedMavEnumEntry
  GOPRO_COMMAND_MODEL(4L),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  GOPRO_COMMAND_VIDEO_SETTINGS(5L),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  GOPRO_COMMAND_LOW_LIGHT(6L),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  GOPRO_COMMAND_PHOTO_RESOLUTION(7L),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  GOPRO_COMMAND_PHOTO_BURST_RATE(8L),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  GOPRO_COMMAND_PROTUNE(9L),
  /**
   * (Get/Set) Hero 3+ Only.
   */
  @GeneratedMavEnumEntry
  GOPRO_COMMAND_PROTUNE_WHITE_BALANCE(10L),
  /**
   * (Get/Set) Hero 3+ Only.
   */
  @GeneratedMavEnumEntry
  GOPRO_COMMAND_PROTUNE_COLOUR(11L),
  /**
   * (Get/Set) Hero 3+ Only.
   */
  @GeneratedMavEnumEntry
  GOPRO_COMMAND_PROTUNE_GAIN(12L),
  /**
   * (Get/Set) Hero 3+ Only.
   */
  @GeneratedMavEnumEntry
  GOPRO_COMMAND_PROTUNE_SHARPNESS(13L),
  /**
   * (Get/Set) Hero 3+ Only.
   */
  @GeneratedMavEnumEntry
  GOPRO_COMMAND_PROTUNE_EXPOSURE(14L),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  GOPRO_COMMAND_TIME(15L),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  GOPRO_COMMAND_CHARGING(16L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproCommand? = when (v) {
      0L -> GOPRO_COMMAND_POWER
      1L -> GOPRO_COMMAND_CAPTURE_MODE
      2L -> GOPRO_COMMAND_SHUTTER
      3L -> GOPRO_COMMAND_BATTERY
      4L -> GOPRO_COMMAND_MODEL
      5L -> GOPRO_COMMAND_VIDEO_SETTINGS
      6L -> GOPRO_COMMAND_LOW_LIGHT
      7L -> GOPRO_COMMAND_PHOTO_RESOLUTION
      8L -> GOPRO_COMMAND_PHOTO_BURST_RATE
      9L -> GOPRO_COMMAND_PROTUNE
      10L -> GOPRO_COMMAND_PROTUNE_WHITE_BALANCE
      11L -> GOPRO_COMMAND_PROTUNE_COLOUR
      12L -> GOPRO_COMMAND_PROTUNE_GAIN
      13L -> GOPRO_COMMAND_PROTUNE_SHARPNESS
      14L -> GOPRO_COMMAND_PROTUNE_EXPOSURE
      15L -> GOPRO_COMMAND_TIME
      16L -> GOPRO_COMMAND_CHARGING
      else -> null
    }
  }
}
