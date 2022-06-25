package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint64
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Angle of Attack and Side Slip Angle.
 */
public data class AoaSsa(
  /**
   * Timestamp (since boot or Unix epoch).
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Angle of Attack.
   */
  public val aoa: Float = 0F,
  /**
   * Side Slip Angle.
   */
  public val ssa: Float = 0F,
) : MavMessage<AoaSsa> {
  public override val instanceMetadata: MavMessage.Metadata<AoaSsa> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(16).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloat(aoa)
    outputBuffer.encodeFloat(ssa)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 11020

    private const val CRC: Int = 205

    private val DESERIALIZER: MavDeserializer<AoaSsa> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val aoa = inputBuffer.decodeFloat()
      val ssa = inputBuffer.decodeFloat()
      AoaSsa(
        timeUsec = timeUsec,
        aoa = aoa,
        ssa = ssa,
      )
    }


    private val METADATA: MavMessage.Metadata<AoaSsa> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AoaSsa> = METADATA
  }
}
