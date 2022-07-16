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
 * Wind estimation.
 */
public data class Wind(
  /**
   * Wind direction (that wind is coming from).
   */
  public val direction: Float = 0F,
  /**
   * Wind speed in ground plane.
   */
  public val speed: Float = 0F,
  /**
   * Vertical wind speed.
   */
  public val speedZ: Float = 0F,
) : MavMessage<Wind> {
  public override val instanceMetadata: MavMessage.Metadata<Wind> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(direction)
    outputBuffer.encodeFloat(speed)
    outputBuffer.encodeFloat(speedZ)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 168

    private const val CRC: Int = 1

    private const val SIZE: Int = 12

    private val DESERIALIZER: MavDeserializer<Wind> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for Wind: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val direction = inputBuffer.decodeFloat()
      val speed = inputBuffer.decodeFloat()
      val speedZ = inputBuffer.decodeFloat()

      Wind(
        direction = direction,
        speed = speed,
        speedZ = speedZ,
      )
    }


    private val METADATA: MavMessage.Metadata<Wind> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Wind> = METADATA
  }
}
