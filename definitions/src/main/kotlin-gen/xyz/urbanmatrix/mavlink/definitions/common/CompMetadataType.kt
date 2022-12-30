package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Supported component metadata types. These are used in the "general" metadata file returned by
 * COMPONENT_METADATA to provide information about supported metadata types. The types are not used
 * directly in MAVLink messages.
 */
@GeneratedMavEnum
public enum class CompMetadataType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * General information about the component. General metadata includes information about other
   * metadata types supported by the component. Files of this type must be supported, and must be
   * downloadable from vehicle using a MAVLink FTP URI.
   */
  @GeneratedMavEnumEntry
  GENERAL(0L),
  /**
   * Parameter meta data.
   */
  @GeneratedMavEnumEntry
  PARAMETER(1L),
  /**
   * Meta data that specifies which commands and command parameters the vehicle supports. (WIP)
   */
  @GeneratedMavEnumEntry
  COMMANDS(2L),
  /**
   * Meta data that specifies external non-MAVLink peripherals.
   */
  @GeneratedMavEnumEntry
  PERIPHERALS(3L),
  /**
   * Meta data for the events interface.
   */
  @GeneratedMavEnumEntry
  EVENTS(4L),
  /**
   * Meta data for actuator configuration (motors, servos and vehicle geometry) and testing.
   */
  @GeneratedMavEnumEntry
  ACTUATORS(5L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CompMetadataType? = when (v) {
      0L -> GENERAL
      1L -> PARAMETER
      2L -> COMMANDS
      3L -> PERIPHERALS
      4L -> EVENTS
      5L -> ACTUATORS
      else -> null
    }
  }
}
