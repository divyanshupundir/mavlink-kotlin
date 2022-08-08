package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Read out the safety zone the MAV currently assumes.
 */
@GeneratedMavMessage(
  id = 55,
  crc = 3,
)
public data class SafetyAllowedArea(
  /**
   * Coordinate frame. Can be either global, GPS, right-handed with Z axis up or local, right
   * handed, Z axis down.
   */
  public val frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0),
  /**
   * x position 1 / Latitude 1
   */
  public val p1x: Float = 0F,
  /**
   * y position 1 / Longitude 1
   */
  public val p1y: Float = 0F,
  /**
   * z position 1 / Altitude 1
   */
  public val p1z: Float = 0F,
  /**
   * x position 2 / Latitude 2
   */
  public val p2x: Float = 0F,
  /**
   * y position 2 / Longitude 2
   */
  public val p2y: Float = 0F,
  /**
   * z position 2 / Altitude 2
   */
  public val p2z: Float = 0F,
) : MavMessage<SafetyAllowedArea> {
  public override val instanceMetadata: MavMessage.Metadata<SafetyAllowedArea> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(p1x)
    outputBuffer.encodeFloat(p1y)
    outputBuffer.encodeFloat(p1z)
    outputBuffer.encodeFloat(p2x)
    outputBuffer.encodeFloat(p2y)
    outputBuffer.encodeFloat(p2z)
    outputBuffer.encodeEnumValue(frame.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 55

    private const val CRC: Int = 3

    private const val SIZE: Int = 25

    private val DESERIALIZER: MavDeserializer<SafetyAllowedArea> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val p1x = inputBuffer.decodeFloat()
      val p1y = inputBuffer.decodeFloat()
      val p1z = inputBuffer.decodeFloat()
      val p2x = inputBuffer.decodeFloat()
      val p2y = inputBuffer.decodeFloat()
      val p2z = inputBuffer.decodeFloat()
      val frame = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      SafetyAllowedArea(
        frame = frame,
        p1x = p1x,
        p1y = p1y,
        p1z = p1z,
        p2x = p2x,
        p2y = p2y,
        p2z = p2z,
      )
    }


    private val METADATA: MavMessage.Metadata<SafetyAllowedArea> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SafetyAllowedArea> = METADATA
  }
}
