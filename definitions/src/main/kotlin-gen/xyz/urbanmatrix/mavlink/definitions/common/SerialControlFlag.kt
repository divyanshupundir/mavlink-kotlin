package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * SERIAL_CONTROL flags (bitmask)
 */
@GeneratedMavEnum
public enum class SerialControlFlag(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Set if this is a reply
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_FLAG_REPLY(1L),
  /**
   * Set if the sender wants the receiver to send a response as another SERIAL_CONTROL message
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_FLAG_RESPOND(2L),
  /**
   * Set if access to the serial port should be removed from whatever driver is currently using it,
   * giving exclusive access to the SERIAL_CONTROL protocol. The port can be handed back by sending a
   * request without this flag set
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_FLAG_EXCLUSIVE(4L),
  /**
   * Block on writes to the serial port
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_FLAG_BLOCKING(8L),
  /**
   * Send multiple replies until port is drained
   */
  @GeneratedMavEnumEntry
  SERIAL_CONTROL_FLAG_MULTI(16L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): SerialControlFlag? = when (v) {
      1L -> SERIAL_CONTROL_FLAG_REPLY
      2L -> SERIAL_CONTROL_FLAG_RESPOND
      4L -> SERIAL_CONTROL_FLAG_EXCLUSIVE
      8L -> SERIAL_CONTROL_FLAG_BLOCKING
      16L -> SERIAL_CONTROL_FLAG_MULTI
      else -> null
    }
  }
}
