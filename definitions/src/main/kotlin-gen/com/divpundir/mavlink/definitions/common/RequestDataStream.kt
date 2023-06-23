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
import kotlin.Deprecated
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(reqMessageRate)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(reqStreamId)
    output.encodeUInt8(startStop)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(reqMessageRate)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(reqStreamId)
    output.encodeUInt8(startStop)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<RequestDataStream> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    public override val id: UInt = 66u

    public override val crcExtra: Byte = -108

    public override fun deserialize(source: BufferedSource): RequestDataStream {
      val reqMessageRate = source.decodeUInt16()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val reqStreamId = source.decodeUInt8()
      val startStop = source.decodeUInt8()

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
