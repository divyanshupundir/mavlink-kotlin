package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * SERIAL_CONTROL flags (bitmask)
 */
@GeneratedMavEnum(bitmask = true)
public enum class SerialControlFlag(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Set if this is a reply
   */
  @GeneratedMavEnumEntry
  REPLY(1u),
  /**
   * Set if the sender wants the receiver to send a response as another SERIAL_CONTROL message
   */
  @GeneratedMavEnumEntry
  RESPOND(2u),
  /**
   * Set if access to the serial port should be removed from whatever driver is currently using it,
   * giving exclusive access to the SERIAL_CONTROL protocol. The port can be handed back by sending a
   * request without this flag set
   */
  @GeneratedMavEnumEntry
  EXCLUSIVE(4u),
  /**
   * Block on writes to the serial port
   */
  @GeneratedMavEnumEntry
  BLOCKING(8u),
  /**
   * Send multiple replies until port is drained
   */
  @GeneratedMavEnumEntry
  MULTI(16u),
  ;

  public companion object : MavBitmask.MavCompanion<SerialControlFlag> {
    override fun getEntryFromValueOrNull(v: UInt): SerialControlFlag? = when (v) {
      1u -> REPLY
      2u -> RESPOND
      4u -> EXCLUSIVE
      8u -> BLOCKING
      16u -> MULTI
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<SerialControlFlag> = buildList {
      if (v and 1u == 1u) add(REPLY)
      if (v and 2u == 2u) add(RESPOND)
      if (v and 4u == 4u) add(EXCLUSIVE)
      if (v and 8u == 8u) add(BLOCKING)
      if (v and 16u == 16u) add(MULTI)
    }
  }
}
