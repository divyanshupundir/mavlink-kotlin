package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * STorM32 gimbal prearm check flags.
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavStorm32GimbalPrearmFlags(
  public override val `value`: UInt,
) : MavBitmask {
  /**
   * STorM32 gimbal is in normal state.
   */
  @GeneratedMavEnumEntry
  IS_NORMAL(1u),
  /**
   * The IMUs are healthy and working normally.
   */
  @GeneratedMavEnumEntry
  IMUS_WORKING(2u),
  /**
   * The motors are active and working normally.
   */
  @GeneratedMavEnumEntry
  MOTORS_WORKING(4u),
  /**
   * The encoders are healthy and working normally.
   */
  @GeneratedMavEnumEntry
  ENCODERS_WORKING(8u),
  /**
   * A battery voltage is applied and is in range.
   */
  @GeneratedMavEnumEntry
  VOLTAGE_OK(16u),
  /**
   * Virtual input channels are receiving data.
   */
  @GeneratedMavEnumEntry
  VIRTUALCHANNELS_RECEIVING(32u),
  /**
   * Mavlink messages are being received.
   */
  @GeneratedMavEnumEntry
  MAVLINK_RECEIVING(64u),
  /**
   * The STorM32Link data indicates QFix.
   */
  @GeneratedMavEnumEntry
  STORM32LINK_QFIX(128u),
  /**
   * The STorM32Link is working.
   */
  @GeneratedMavEnumEntry
  STORM32LINK_WORKING(256u),
  /**
   * The camera has been found and is connected.
   */
  @GeneratedMavEnumEntry
  CAMERA_CONNECTED(512u),
  /**
   * The signal on the AUX0 input pin is low.
   */
  @GeneratedMavEnumEntry
  AUX0_LOW(1_024u),
  /**
   * The signal on the AUX1 input pin is low.
   */
  @GeneratedMavEnumEntry
  AUX1_LOW(2_048u),
  /**
   * The NTLogger is working normally.
   */
  @GeneratedMavEnumEntry
  NTLOGGER_WORKING(4_096u),
  ;

  public companion object : MavBitmask.MavCompanion<MavStorm32GimbalPrearmFlags> {
    public override fun getEntryFromValueOrNull(v: UInt): MavStorm32GimbalPrearmFlags? = when (v) {
      1u -> IS_NORMAL
      2u -> IMUS_WORKING
      4u -> MOTORS_WORKING
      8u -> ENCODERS_WORKING
      16u -> VOLTAGE_OK
      32u -> VIRTUALCHANNELS_RECEIVING
      64u -> MAVLINK_RECEIVING
      128u -> STORM32LINK_QFIX
      256u -> STORM32LINK_WORKING
      512u -> CAMERA_CONNECTED
      1024u -> AUX0_LOW
      2048u -> AUX1_LOW
      4096u -> NTLOGGER_WORKING
      else -> null
    }

    public override fun getFlagsFromValue(v: UInt): List<MavStorm32GimbalPrearmFlags> = buildList {
      if (v and 1u == 1u) add(IS_NORMAL)
      if (v and 2u == 2u) add(IMUS_WORKING)
      if (v and 4u == 4u) add(MOTORS_WORKING)
      if (v and 8u == 8u) add(ENCODERS_WORKING)
      if (v and 16u == 16u) add(VOLTAGE_OK)
      if (v and 32u == 32u) add(VIRTUALCHANNELS_RECEIVING)
      if (v and 64u == 64u) add(MAVLINK_RECEIVING)
      if (v and 128u == 128u) add(STORM32LINK_QFIX)
      if (v and 256u == 256u) add(STORM32LINK_WORKING)
      if (v and 512u == 512u) add(CAMERA_CONNECTED)
      if (v and 1024u == 1024u) add(AUX0_LOW)
      if (v and 2048u == 2048u) add(AUX1_LOW)
      if (v and 4096u == 4096u) add(NTLOGGER_WORKING)
    }
  }
}
