package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Tune formats supported by vehicle. This should be emitted as response to MAV_CMD_REQUEST_MESSAGE.
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param format Bitfield of supported tune formats.
 */
@GeneratedMavMessage(
  id = 401u,
  crcExtra = -73,
)
public data class SupportedTunes(
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
   * Bitfield of supported tune formats.
   */
  @GeneratedMavField(type = "uint32_t")
  public val format: MavEnumValue<TuneFormat> = MavEnumValue.fromValue(0u),
) : MavMessage<SupportedTunes> {
  override val instanceCompanion: MavMessage.MavCompanion<SupportedTunes> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeEnumValue(format.value, 4)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeEnumValue(format.value, 4)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SupportedTunes> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    override val id: UInt = 401u

    override val crcExtra: Byte = -73

    override fun deserialize(bytes: ByteArray): SupportedTunes {
      val decoder = MavDataDecoder(bytes)

      val format = decoder.safeDecodeEnumValue(4).let { value ->
        val entry = TuneFormat.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

      return SupportedTunes(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        format = format,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SupportedTunes =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var format: MavEnumValue<TuneFormat> = MavEnumValue.fromValue(0u)

    public fun build(): SupportedTunes = SupportedTunes(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      format = format,
    )
  }
}
