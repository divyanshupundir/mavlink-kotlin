package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Supported component metadata types. These are used in the "general" metadata file returned by
 * COMPONENT_METADATA to provide information about supported metadata types. The types are not used
 * directly in MAVLink messages.
 */
public enum class CompMetadataType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * General information about the component. General metadata includes information about other
   * metadata types supported by the component. Files of this type must be supported, and must be
   * downloadable from vehicle using a MAVLink FTP URI.
   */
  COMP_METADATA_TYPE_GENERAL(0L),
  /**
   * Parameter meta data.
   */
  COMP_METADATA_TYPE_PARAMETER(1L),
  /**
   * Meta data that specifies which commands and command parameters the vehicle supports. (WIP)
   */
  COMP_METADATA_TYPE_COMMANDS(2L),
  /**
   * Meta data that specifies external non-MAVLink peripherals.
   */
  COMP_METADATA_TYPE_PERIPHERALS(3L),
  /**
   * Meta data for the events interface.
   */
  COMP_METADATA_TYPE_EVENTS(4L),
  /**
   * Meta data for actuator configuration (motors, servos and vehicle geometry) and testing.
   */
  COMP_METADATA_TYPE_ACTUATORS(5L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CompMetadataType? = when (v) {
      0L -> COMP_METADATA_TYPE_GENERAL
      1L -> COMP_METADATA_TYPE_PARAMETER
      2L -> COMP_METADATA_TYPE_COMMANDS
      3L -> COMP_METADATA_TYPE_PERIPHERALS
      4L -> COMP_METADATA_TYPE_EVENTS
      5L -> COMP_METADATA_TYPE_ACTUATORS
      else -> null
    }
  }
}
