package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
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
  public override val `value`: UInt,
) : MavEnum {
  /**
   * General information about the component. General metadata includes information about other
   * metadata types supported by the component. Files of this type must be supported, and must be
   * downloadable from vehicle using a MAVLink FTP URI.
   */
  @GeneratedMavEnumEntry
  GENERAL(0u),
  /**
   * Parameter meta data.
   */
  @GeneratedMavEnumEntry
  PARAMETER(1u),
  /**
   * Meta data that specifies which commands and command parameters the vehicle supports. (WIP)
   */
  @GeneratedMavEnumEntry
  COMMANDS(2u),
  /**
   * Meta data that specifies external non-MAVLink peripherals.
   */
  @GeneratedMavEnumEntry
  PERIPHERALS(3u),
  /**
   * Meta data for the events interface.
   */
  @GeneratedMavEnumEntry
  EVENTS(4u),
  /**
   * Meta data for actuator configuration (motors, servos and vehicle geometry) and testing.
   */
  @GeneratedMavEnumEntry
  ACTUATORS(5u),
  ;

  public companion object : MavEnum.Companion<CompMetadataType> {
    public override fun getEntryFromValueOrNull(v: UInt): CompMetadataType? = when (v) {
      0u -> GENERAL
      1u -> PARAMETER
      2u -> COMMANDS
      3u -> PERIPHERALS
      4u -> EVENTS
      5u -> ACTUATORS
      else -> null
    }
  }
}
