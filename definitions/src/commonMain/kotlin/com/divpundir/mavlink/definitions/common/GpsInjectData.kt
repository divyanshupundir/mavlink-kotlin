package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
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
  public override val instanceCompanion: MavMessage.MavCompanion<GpsInjectData> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(len)
    encoder.encodeUInt8Array(data, 110)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(len)
    encoder.encodeUInt8Array(data, 110)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GpsInjectData> {
    private const val SIZE_V1: Int = 113

    private const val SIZE_V2: Int = 113

    public override val id: UInt = 123u

    public override val crcExtra: Byte = -6

    public override fun deserialize(bytes: ByteArray): GpsInjectData {
      val decoder = MavDataDecoder(bytes)

      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val len = decoder.safeDecodeUInt8()
      val data = decoder.safeDecodeUInt8Array(110)

      return GpsInjectData(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        len = len,
        data = data,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GpsInjectData =
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
