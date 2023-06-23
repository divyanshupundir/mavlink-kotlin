package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * Data packet for images sent using the Image Transmission Protocol:
 * https://mavlink.io/en/services/image_transmission.html.
 */
@GeneratedMavMessage(
  id = 131u,
  crcExtra = -33,
)
public data class EncapsulatedData(
  /**
   * sequence number (starting with 0 on every transmission)
   */
  @GeneratedMavField(type = "uint16_t")
  public val seqnr: UShort = 0u,
  /**
   * image data bytes
   */
  @GeneratedMavField(type = "uint8_t[253]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<EncapsulatedData> {
  public override val instanceCompanion: MavMessage.MavCompanion<EncapsulatedData> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(seqnr)
    output.encodeUInt8Array(data, 253)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(seqnr)
    output.encodeUInt8Array(data, 253)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<EncapsulatedData> {
    private const val SIZE_V1: Int = 255

    private const val SIZE_V2: Int = 255

    public override val id: UInt = 131u

    public override val crcExtra: Byte = -33

    public override fun deserialize(source: BufferedSource): EncapsulatedData {
      val seqnr = source.decodeUInt16()
      val data = source.decodeUInt8Array(253)

      return EncapsulatedData(
        seqnr = seqnr,
        data = data,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): EncapsulatedData =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var seqnr: UShort = 0u

    public var `data`: List<UByte> = emptyList()

    public fun build(): EncapsulatedData = EncapsulatedData(
      seqnr = seqnr,
      data = data,
    )
  }
}
