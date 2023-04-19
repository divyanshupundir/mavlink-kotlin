package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * Data for injecting into the onboard GPS (used for DGPS)
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 123u,
  crcExtra = -6,
)
public data class GpsInjectData(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Data length
   */
  @GeneratedMavField(type = "uint8_t")
  public val len: UByte = 0u,
  /**
   * Raw data (110 is enough for 12 satellites of RTCMv2)
   */
  @GeneratedMavField(type = "uint8_t[110]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<GpsInjectData> {
  public override val instanceMetadata: MavMessage.Metadata<GpsInjectData> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(len)
    outputBuffer.encodeUInt8Array(data, 110)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(len)
    outputBuffer.encodeUInt8Array(data, 110)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 123u

    private const val CRC_EXTRA: Byte = -6

    private const val SIZE_V1: Int = 113

    private const val SIZE_V2: Int = 113

    private val DESERIALIZER: MavDeserializer<GpsInjectData> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val len = inputBuffer.decodeUInt8()
      val data = inputBuffer.decodeUInt8Array(110)

      GpsInjectData(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        len = len,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<GpsInjectData> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GpsInjectData> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GpsInjectData =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var len: UByte = 0u

    public var `data`: List<UByte> = emptyList()

    public fun build(): GpsInjectData = GpsInjectData(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      len = len,
      data = data,
    )
  }
}
