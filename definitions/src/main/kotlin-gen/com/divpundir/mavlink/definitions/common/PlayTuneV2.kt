package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

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
  public override val instanceMetadata: MavMessage.Metadata<PlayTuneV2> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(format.value, 4)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeString(tune, 248)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(format.value, 4)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeString(tune, 248)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 400u

    private const val CRC_EXTRA: Byte = 110

    private const val SIZE_V1: Int = 254

    private const val SIZE_V2: Int = 254

    private val DESERIALIZER: MavDeserializer<PlayTuneV2> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val format = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = TuneFormat.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val tune = inputBuffer.decodeString(248)

      PlayTuneV2(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        format = format,
        tune = tune,
      )
    }


    private val METADATA: MavMessage.Metadata<PlayTuneV2> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<PlayTuneV2> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): PlayTuneV2 =
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
