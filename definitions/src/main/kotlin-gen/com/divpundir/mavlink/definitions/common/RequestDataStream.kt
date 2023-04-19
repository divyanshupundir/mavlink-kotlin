package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

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
  public override val instanceMetadata: MavMessage.Metadata<RequestDataStream> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(reqMessageRate)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(reqStreamId)
    outputBuffer.encodeUInt8(startStop)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(reqMessageRate)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(reqStreamId)
    outputBuffer.encodeUInt8(startStop)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 66u

    private const val CRC_EXTRA: Byte = -108

    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    private val DESERIALIZER: MavDeserializer<RequestDataStream> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val reqMessageRate = inputBuffer.decodeUInt16()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val reqStreamId = inputBuffer.decodeUInt8()
      val startStop = inputBuffer.decodeUInt8()

      RequestDataStream(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        reqStreamId = reqStreamId,
        reqMessageRate = reqMessageRate,
        startStop = startStop,
      )
    }


    private val METADATA: MavMessage.Metadata<RequestDataStream> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RequestDataStream> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): RequestDataStream =
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
