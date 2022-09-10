package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.String
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Control vehicle tone generation (buzzer).
 */
@Deprecated(message = "New version explicitly defines format. More interoperable.")
@GeneratedMavMessage(
  id = 258,
  crc = 240,
)
public data class PlayTune(
  /**
   * System ID
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val targetComponent: Int = 0,
  /**
   * tune in board specific format
   */
  @GeneratedMavField(
    type = "char[30]",
    extension = true,
  )
  public val tune: String = "",
  /**
   * tune extension (appended to tune)
   */
  @GeneratedMavField(type = "char[200]")
  public val tune2: String = "",
) : MavMessage<PlayTune> {
  public override val instanceMetadata: MavMessage.Metadata<PlayTune> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeString(tune2, 200)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeString(tune2, 200)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeString(tune, 30)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 258

    private const val CRC: Int = 240

    private const val SIZE: Int = 232

    private val DESERIALIZER: MavDeserializer<PlayTune> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val tune2 = inputBuffer.decodeString(200)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val tune = inputBuffer.decodeString(30)

      PlayTune(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        tune = tune,
        tune2 = tune2,
      )
    }


    private val METADATA: MavMessage.Metadata<PlayTune> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<PlayTune> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var tune: String = ""

    public var tune2: String = ""

    public fun build(): PlayTune = PlayTune(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      tune = tune,
      tune2 = tune2,
    )
  }
}
