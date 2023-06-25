package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Request a data stream.
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 66u,
  crcExtra = -108,
)
public data class RequestDataStream(
  /**
   * The target requested to send the message stream.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * The target requested to send the message stream.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * The ID of the requested data stream
   */
  @GeneratedMavField(type = "uint8_t")
  public val reqStreamId: UByte = 0u,
  /**
   * The requested message rate
   */
  @GeneratedMavField(type = "uint16_t")
  public val reqMessageRate: UShort = 0u,
  /**
   * 1 to start sending, 0 to stop sending.
   */
  @GeneratedMavField(type = "uint8_t")
  public val startStop: UByte = 0u,
) : MavMessage<RequestDataStream> {
  public override val instanceCompanion: MavMessage.MavCompanion<RequestDataStream> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(reqMessageRate)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(reqStreamId)
    buffer.encodeUInt8(startStop)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(reqMessageRate)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(reqStreamId)
    buffer.encodeUInt8(startStop)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RequestDataStream> {
    public override val id: UInt = 66u

    public override val crcExtra: Byte = -108

    public override fun deserialize(bytes: ByteArray): RequestDataStream {
      val buffer = Buffer().write(bytes)

      val reqMessageRate = buffer.decodeUInt16()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val reqStreamId = buffer.decodeUInt8()
      val startStop = buffer.decodeUInt8()

      return RequestDataStream(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        reqStreamId = reqStreamId,
        reqMessageRate = reqMessageRate,
        startStop = startStop,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): RequestDataStream =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var reqStreamId: UByte = 0u

    public var reqMessageRate: UShort = 0u

    public var startStop: UByte = 0u

    public fun build(): RequestDataStream = RequestDataStream(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      reqStreamId = reqStreamId,
      reqMessageRate = reqMessageRate,
      startStop = startStop,
    )
  }
}
