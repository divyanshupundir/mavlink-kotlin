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
  POWER(0L),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  CAPTURE_MODE(1L),
  /**
   * (___/Set).
   */
  @GeneratedMavEnumEntry
  SHUTTER(2L),
  /**
   * (Get/___).
   */
  @GeneratedMavEnumEntry
  BATTERY(3L),
  /**
   * (Get/___).
   */
  @GeneratedMavEnumEntry
  MODEL(4L),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  VIDEO_SETTINGS(5L),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  LOW_LIGHT(6L),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  PHOTO_RESOLUTION(7L),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  PHOTO_BURST_RATE(8L),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  PROTUNE(9L),
  /**
   * (Get/Set) Hero 3+ Only.
   */
  @GeneratedMavEnumEntry
  PROTUNE_WHITE_BALANCE(10L),
  /**
   * (Get/Set) Hero 3+ Only.
   */
  @GeneratedMavEnumEntry
  PROTUNE_COLOUR(11L),
  /**
   * (Get/Set) Hero 3+ Only.
   */
  @GeneratedMavEnumEntry
  PROTUNE_GAIN(12L),
  /**
   * (Get/Set) Hero 3+ Only.
   */
  @GeneratedMavEnumEntry
  PROTUNE_SHARPNESS(13L),
  /**
   * (Get/Set) Hero 3+ Only.
   */
  @GeneratedMavEnumEntry
  PROTUNE_EXPOSURE(14L),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  TIME(15L),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  CHARGING(16L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproCommand? = when (v) {
      0L -> POWER
      1L -> CAPTURE_MODE
      2L -> SHUTTER
      3L -> BATTERY
      4L -> MODEL
      5L -> VIDEO_SETTINGS
      6L -> LOW_LIGHT
      7L -> PHOTO_RESOLUTION
      8L -> PHOTO_BURST_RATE
      9L -> PROTUNE
      10L -> PROTUNE_WHITE_BALANCE
      11L -> PROTUNE_COLOUR
      12L -> PROTUNE_GAIN
      13L -> PROTUNE_SHARPNESS
      14L -> PROTUNE_EXPOSURE
      15L -> TIME
      16L -> CHARGING
      else -> null
    }
  }
}
