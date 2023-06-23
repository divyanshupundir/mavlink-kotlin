package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Tune formats supported by vehicle. This should be emitted as response to MAV_CMD_REQUEST_MESSAGE.
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
  public override val instanceCompanion: MavMessage.MavCompanion<SupportedTunes> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeEnumValue(format.value, 4)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeEnumValue(format.value, 4)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SupportedTunes> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    public override val id: UInt = 401u

    public override val crcExtra: Byte = -73

    public override fun deserialize(source: BufferedSource): SupportedTunes {
      val format = source.decodeEnumValue(4).let { value ->
        val entry = TuneFormat.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()

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
