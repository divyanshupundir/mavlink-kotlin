package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.encodeFloat
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Rangefinder reporting.
 */
public data class Rangefinder(
  /**
   * Distance.
   */
  public val distance: Float = 0F,
  /**
   * Raw voltage if available, zero otherwise.
   */
  public val voltage: Float = 0F,
) : MavMessage<Rangefinder> {
  public override val instanceMetadata: MavMessage.Metadata<Rangefinder> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(distance)
    outputBuffer.encodeFloat(voltage)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 173

    private const val CRC: Int = 83

    private const val SIZE: Int = 8

    private val DESERIALIZER: MavDeserializer<Rangefinder> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for Rangefinder: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val distance = inputBuffer.decodeFloat()
      val voltage = inputBuffer.decodeFloat()

      Rangefinder(
        distance = distance,
        voltage = voltage,
      )
    }


    private val METADATA: MavMessage.Metadata<Rangefinder> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Rangefinder> = METADATA
  }
}
