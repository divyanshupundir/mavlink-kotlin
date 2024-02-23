package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Play vehicle tone/tune (buzzer). Supersedes message PLAY_TUNE.
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param format Tune format
 * @param tune Tune definition as a NULL-terminated string.
 */
@GeneratedMavMessage(
  id = 400u,
  crcExtra = 110,
)
public data class PlayTuneV2(
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
   * Tune format
   */
  @GeneratedMavField(type = "uint32_t")
  public val format: MavEnumValue<TuneFormat> = MavEnumValue.fromValue(0u),
  /**
   * Tune definition as a NULL-terminated string.
   */
  @GeneratedMavField(type = "char[248]")
  public val tune: String = "",
) : MavMessage<PlayTuneV2> {
  override val instanceCompanion: MavMessage.MavCompanion<PlayTuneV2> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeEnumValue(format.value, 4)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeString(tune, 248)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeEnumValue(format.value, 4)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeString(tune, 248)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<PlayTuneV2> {
    private const val SIZE_V1: Int = 254

    private const val SIZE_V2: Int = 254

    override val id: UInt = 400u

    override val crcExtra: Byte = 110

    override fun deserialize(bytes: ByteArray): PlayTuneV2 {
      val decoder = MavDataDecoder(bytes)

      val format = decoder.safeDecodeEnumValue(4).let { value ->
        val entry = TuneFormat.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val tune = decoder.safeDecodeString(248)

      return PlayTuneV2(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        format = format,
        tune = tune,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): PlayTuneV2 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var format: MavEnumValue<TuneFormat> = MavEnumValue.fromValue(0u)

    public var tune: String = ""

    public fun build(): PlayTuneV2 = PlayTuneV2(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      format = format,
      tune = tune,
    )
  }
}
