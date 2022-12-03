package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Play vehicle tone/tune (buzzer). Supersedes message PLAY_TUNE.
 */
@GeneratedMavMessage(
  id = 400,
  crc = 110,
)
public data class PlayTuneV2(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * Tune format
   */
  @GeneratedMavField(type = "uint32_t")
  public val format: MavEnumValue<TuneFormat> = MavEnumValue.fromValue(0),
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
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeString(tune, 248)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(format.value, 4)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeString(tune, 248)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 400

    private const val CRC: Int = 110

    private const val SIZE_V1: Int = 254

    private const val SIZE_V2: Int = 254

    private val DESERIALIZER: MavDeserializer<PlayTuneV2> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val format = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = TuneFormat.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val tune = inputBuffer.decodeString(248)

      PlayTuneV2(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        format = format,
        tune = tune,
      )
    }


    private val METADATA: MavMessage.Metadata<PlayTuneV2> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<PlayTuneV2> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): PlayTuneV2 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var format: MavEnumValue<TuneFormat> = MavEnumValue.fromValue(0)

    public var tune: String = ""

    public fun build(): PlayTuneV2 = PlayTuneV2(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      format = format,
      tune = tune,
    )
  }
}
