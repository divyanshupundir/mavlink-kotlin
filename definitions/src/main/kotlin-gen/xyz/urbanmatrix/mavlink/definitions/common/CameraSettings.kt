package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint32

/**
 * Settings of a camera. Can be requested with a MAV_CMD_REQUEST_MESSAGE command.
 */
@GeneratedMavMessage(
  id = 260,
  crc = 146,
)
public data class CameraSettings(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * Camera mode
   */
  public val modeId: MavEnumValue<CameraMode> = MavEnumValue.fromValue(0),
  /**
   * Current zoom level (0.0 to 100.0, NaN if not known)
   */
  public val zoomlevel: Float = 0F,
  /**
   * Current focus level (0.0 to 100.0, NaN if not known)
   */
  public val focuslevel: Float = 0F,
) : MavMessage<CameraSettings> {
  public override val instanceMetadata: MavMessage.Metadata<CameraSettings> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeEnumValue(modeId.value, 1)
    outputBuffer.encodeFloat(zoomlevel)
    outputBuffer.encodeFloat(focuslevel)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 260

    private const val CRC: Int = 146

    private const val SIZE: Int = 13

    private val DESERIALIZER: MavDeserializer<CameraSettings> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val modeId = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = CameraMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val zoomlevel = inputBuffer.decodeFloat()
      val focuslevel = inputBuffer.decodeFloat()

      CameraSettings(
        timeBootMs = timeBootMs,
        modeId = modeId,
        zoomlevel = zoomlevel,
        focuslevel = focuslevel,
      )
    }


    private val METADATA: MavMessage.Metadata<CameraSettings> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CameraSettings> = METADATA
  }
}
