package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * RPM sensor data message.
 */
public data class RawRpm(
  /**
   * Index of this RPM sensor (0-indexed)
   */
  public val index: Int = 0,
  /**
   * Indicated rate
   */
  public val frequency: Float = 0F,
) : MavMessage<RawRpm> {
  public override val instanceMetadata: MavMessage.Metadata<RawRpm> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(frequency)
    outputBuffer.encodeUint8(index)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 339

    private const val CRC: Int = 199

    private const val SIZE: Int = 5

    private val DESERIALIZER: MavDeserializer<RawRpm> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for RawRpm: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val frequency = inputBuffer.decodeFloat()
      val index = inputBuffer.decodeUint8()

      RawRpm(
        index = index,
        frequency = frequency,
      )
    }


    private val METADATA: MavMessage.Metadata<RawRpm> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RawRpm> = METADATA
  }
}
