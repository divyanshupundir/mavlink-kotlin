package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class GoproCommand(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  POWER(0u),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  CAPTURE_MODE(1u),
  /**
   * (___/Set).
   */
  @GeneratedMavEnumEntry
  SHUTTER(2u),
  /**
   * (Get/___).
   */
  @GeneratedMavEnumEntry
  BATTERY(3u),
  /**
   * (Get/___).
   */
  @GeneratedMavEnumEntry
  MODEL(4u),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  VIDEO_SETTINGS(5u),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  LOW_LIGHT(6u),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  PHOTO_RESOLUTION(7u),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  PHOTO_BURST_RATE(8u),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  PROTUNE(9u),
  /**
   * (Get/Set) Hero 3+ Only.
   */
  @GeneratedMavEnumEntry
  PROTUNE_WHITE_BALANCE(10u),
  /**
   * (Get/Set) Hero 3+ Only.
   */
  @GeneratedMavEnumEntry
  PROTUNE_COLOUR(11u),
  /**
   * (Get/Set) Hero 3+ Only.
   */
  @GeneratedMavEnumEntry
  PROTUNE_GAIN(12u),
  /**
   * (Get/Set) Hero 3+ Only.
   */
  @GeneratedMavEnumEntry
  PROTUNE_SHARPNESS(13u),
  /**
   * (Get/Set) Hero 3+ Only.
   */
  @GeneratedMavEnumEntry
  PROTUNE_EXPOSURE(14u),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  TIME(15u),
  /**
   * (Get/Set).
   */
  @GeneratedMavEnumEntry
  CHARGING(16u),
  ;

  public companion object : MavEnum.Companion<GoproCommand> {
    public override fun getEntryFromValueOrNull(v: UInt): GoproCommand? = when (v) {
      0u -> POWER
      1u -> CAPTURE_MODE
      2u -> SHUTTER
      3u -> BATTERY
      4u -> MODEL
      5u -> VIDEO_SETTINGS
      6u -> LOW_LIGHT
      7u -> PHOTO_RESOLUTION
      8u -> PHOTO_BURST_RATE
      9u -> PROTUNE
      10u -> PROTUNE_WHITE_BALANCE
      11u -> PROTUNE_COLOUR
      12u -> PROTUNE_GAIN
      13u -> PROTUNE_SHARPNESS
      14u -> PROTUNE_EXPOSURE
      15u -> TIME
      16u -> CHARGING
      else -> null
    }
  }
}
