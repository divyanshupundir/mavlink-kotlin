package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * SERIAL_CONTROL flags (bitmask)
 */
@GeneratedMavEnum(bitmask = true)
public enum class SerialControlFlag(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * Set if this is a reply
   */
  @GeneratedMavEnumEntry
  REPLY(1L),
  /**
   * Set if the sender wants the receiver to send a response as another SERIAL_CONTROL message
   */
  @GeneratedMavEnumEntry
  RESPOND(2L),
  /**
   * Set if access to the serial port should be removed from whatever driver is currently using it,
   * giving exclusive access to the SERIAL_CONTROL protocol. The port can be handed back by sending a
   * request without this flag set
   */
  @GeneratedMavEnumEntry
  EXCLUSIVE(4L),
  /**
   * Block on writes to the serial port
   */
  @GeneratedMavEnumEntry
  BLOCKING(8L),
  /**
   * Send multiple replies until port is drained
   */
  @GeneratedMavEnumEntry
  MULTI(16L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): SerialControlFlag? = when (v) {
      1L -> REPLY
      2L -> RESPOND
      4L -> EXCLUSIVE
      8L -> BLOCKING
      16L -> MULTI
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<SerialControlFlag> = buildList {
      if (v and 1L == 1L) add(REPLY)
      if (v and 2L == 2L) add(RESPOND)
      if (v and 4L == 4L) add(EXCLUSIVE)
      if (v and 8L == 8L) add(BLOCKING)
      if (v and 16L == 16L) add(MULTI)
    }
  }
}
