package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
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
 *
 * @param targetSystem The target requested to send the message stream.
 * @param targetComponent The target requested to send the message stream.
 * @param reqStreamId The ID of the requested data stream
 * @param reqMessageRate The requested message rate
 * units = Hz
 * @param startStop 1 to start sending, 0 to stop sending.
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
   * units = Hz
   */
  @GeneratedMavField(type = "uint16_t")
  public val reqMessageRate: UShort = 0u,
  /**
   * 1 to start sending, 0 to stop sending.
   */
  @GeneratedMavField(type = "uint8_t")
  public val startStop: UByte = 0u,
) : MavMessage<RequestDataStream> {
  override val instanceCompanion: MavMessage.MavCompanion<RequestDataStream> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(reqMessageRate)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(reqStreamId)
    encoder.encodeUInt8(startStop)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(reqMessageRate)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(reqStreamId)
    encoder.encodeUInt8(startStop)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RequestDataStream> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    override val id: UInt = 66u

    override val crcExtra: Byte = -108

    override fun deserialize(bytes: ByteArray): RequestDataStream {
      val decoder = MavDataDecoder(bytes)

      val reqMessageRate = decoder.safeDecodeUInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val reqStreamId = decoder.safeDecodeUInt8()
      val startStop = decoder.safeDecodeUInt8()

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
