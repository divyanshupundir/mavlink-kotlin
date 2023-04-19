package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Result from a MAVLink command (MAV_CMD)
 */
@GeneratedMavEnum
public enum class MavResult(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Command is valid (is supported and has valid parameters), and was executed.
   */
  @GeneratedMavEnumEntry
  ACCEPTED(0u),
  /**
   * Command is valid, but cannot be executed at this time. This is used to indicate a problem that
   * should be fixed just by waiting (e.g. a state machine is busy, can't arm because have not got GPS
   * lock, etc.). Retrying later should work.
   */
  @GeneratedMavEnumEntry
  TEMPORARILY_REJECTED(1u),
  /**
   * Command is invalid (is supported but has invalid parameters). Retrying same command and
   * parameters will not work.
   */
  @GeneratedMavEnumEntry
  DENIED(2u),
  /**
   * Command is not supported (unknown).
   */
  @GeneratedMavEnumEntry
  UNSUPPORTED(3u),
  /**
   * Command is valid, but execution has failed. This is used to indicate any non-temporary or
   * unexpected problem, i.e. any problem that must be fixed before the command can succeed/be retried.
   * For example, attempting to write a file when out of memory, attempting to arm when sensors are not
   * calibrated, etc.
   */
  @GeneratedMavEnumEntry
  FAILED(4u),
  /**
   * Command is valid and is being executed. This will be followed by further progress updates, i.e.
   * the component may send further COMMAND_ACK messages with result MAV_RESULT_IN_PROGRESS (at a rate
   * decided by the implementation), and must terminate by sending a COMMAND_ACK message with final
   * result of the operation. The COMMAND_ACK.progress field can be used to indicate the progress of
   * the operation.
   */
  @GeneratedMavEnumEntry
  IN_PROGRESS(5u),
  /**
   * Command has been cancelled (as a result of receiving a COMMAND_CANCEL message).
   */
  @GeneratedMavEnumEntry
  CANCELLED(6u),
  ;

  public companion object : MavEnum.Companion<MavResult> {
    public override fun getEntryFromValueOrNull(v: UInt): MavResult? = when (v) {
      0u -> ACCEPTED
      1u -> TEMPORARILY_REJECTED
      2u -> DENIED
      3u -> UNSUPPORTED
      4u -> FAILED
      5u -> IN_PROGRESS
      6u -> CANCELLED
      else -> null
    }
  }
}
