package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeString
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeString
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.String

/**
 * Play vehicle tone/tune (buzzer). Supersedes message PLAY_TUNE.
 */
public data class PlayTuneV2(
  /**
   * Tune format
   */
  public val format: MavEnumValue<TuneFormat> = MavEnumValue.fromValue(0),
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * Tune definition as a NULL-terminated string.
   */
  public val tune: String = "",
) : MavMessage<PlayTuneV2> {
  public override val instanceMetadata: MavMessage.Metadata<PlayTuneV2> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(254).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(format.value, 4)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeString(tune, 248)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 400

    private const val CRC: Int = 216

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
        format = format,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        tune = tune,
      )
    }


    private val METADATA: MavMessage.Metadata<PlayTuneV2> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<PlayTuneV2> = METADATA
  }
}
