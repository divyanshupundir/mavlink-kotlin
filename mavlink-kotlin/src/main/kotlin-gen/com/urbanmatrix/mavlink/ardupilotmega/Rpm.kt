package com.urbanmatrix.mavlink.ardupilotmega

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
 * RPM sensor output.
 */
public data class Rpm(
  /**
   * RPM Sensor1.
   */
  public val rpm1: Float = 0F,
  /**
   * RPM Sensor2.
   */
  public val rpm2: Float = 0F,
) : MavMessage<Rpm> {
  public override val instanceMetadata: MavMessage.Metadata<Rpm> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(rpm1)
    outputBuffer.encodeFloat(rpm2)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 226

    private const val CRC: Int = 207

    private val DESERIALIZER: MavDeserializer<Rpm> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val rpm1 = inputBuffer.decodeFloat()
      val rpm2 = inputBuffer.decodeFloat()
      Rpm(
        rpm1 = rpm1,
        rpm2 = rpm2,
      )
    }


    private val METADATA: MavMessage.Metadata<Rpm> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Rpm> = METADATA
  }
}
