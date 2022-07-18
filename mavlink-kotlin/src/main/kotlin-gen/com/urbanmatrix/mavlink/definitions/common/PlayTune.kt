package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeString
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeString
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.String

/**
 * Control vehicle tone generation (buzzer).
 */
@Deprecated(message = "New version explicitly defines format. More interoperable.")
public data class PlayTune(
  /**
   * tune extension (appended to tune)
   */
  public val tune2: String = "",
  /**
   * tune in board specific format
   */
  public val tune: String = "",
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
) : MavMessage<PlayTune> {
  public override val instanceMetadata: MavMessage.Metadata<PlayTune> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeString(tune2, 200)
    outputBuffer.encodeString(tune, 30)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(targetSystem)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 258

    private const val CRC: Int = 240

    private const val SIZE: Int = 232

    private val DESERIALIZER: MavDeserializer<PlayTune> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val tune2 = inputBuffer.decodeString(200)
      val tune = inputBuffer.decodeString(30)
      val targetComponent = inputBuffer.decodeUint8()
      val targetSystem = inputBuffer.decodeUint8()

      PlayTune(
        tune2 = tune2,
        tune = tune,
        targetComponent = targetComponent,
        targetSystem = targetSystem,
      )
    }


    private val METADATA: MavMessage.Metadata<PlayTune> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<PlayTune> = METADATA
  }
}
