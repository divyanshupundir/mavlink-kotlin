package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Play vehicle tone/tune (buzzer). Supersedes message PLAY_TUNE.
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
  public override val instanceCompanion: MavMessage.MavCompanion<PlayTuneV2> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeEnumValue(format.value, 4)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeString(tune, 248)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeEnumValue(format.value, 4)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeString(tune, 248)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<PlayTuneV2> {
    private const val SIZE_V1: Int = 254

    private const val SIZE_V2: Int = 254

    public override val id: UInt = 400u

    public override val crcExtra: Byte = 110

    public override fun deserialize(source: BufferedSource): PlayTuneV2 {
      val format = source.decodeEnumValue(4).let { value ->
        val entry = TuneFormat.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val tune = source.decodeString(248)

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
