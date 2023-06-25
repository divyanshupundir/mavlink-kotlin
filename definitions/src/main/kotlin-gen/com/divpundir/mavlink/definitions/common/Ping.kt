package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer

/**
 * A ping message either requesting or responding to a ping. This allows to measure the system
 * latencies, including serial port, radio modem and UDP connections. The ping microservice is
 * documented at https://mavlink.io/en/services/ping.html
 */
@Deprecated(message = "to be removed / merged with SYSTEM_TIME")
@GeneratedMavMessage(
  id = 4u,
  crcExtra = -19,
)
public data class Ping(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * PING sequence
   */
  @GeneratedMavField(type = "uint32_t")
  public val seq: UInt = 0u,
  /**
   * 0: request ping from all receiving systems. If greater than 0: message is a ping response and
   * number is the system id of the requesting system
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * 0: request ping from all receiving components. If greater than 0: message is a ping response
   * and number is the component id of the requesting component.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
) : MavMessage<Ping> {
  public override val instanceCompanion: MavMessage.MavCompanion<Ping> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeUInt32(seq)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeUInt32(seq)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Ping> {
    public override val id: UInt = 4u

    public override val crcExtra: Byte = -19

    public override fun deserialize(bytes: ByteArray): Ping {
      val buffer = Buffer().write(bytes)

      val timeUsec = buffer.decodeUInt64()
      val seq = buffer.decodeUInt32()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()

      return Ping(
        timeUsec = timeUsec,
        seq = seq,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Ping =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var seq: UInt = 0u

    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public fun build(): Ping = Ping(
      timeUsec = timeUsec,
      seq = seq,
      targetSystem = targetSystem,
      targetComponent = targetComponent,
    )
  }
}
