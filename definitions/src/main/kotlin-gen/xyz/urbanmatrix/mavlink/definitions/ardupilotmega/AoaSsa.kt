package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint64

/**
 * Angle of Attack and Side Slip Angle.
 */
@GeneratedMavMessage(
  id = 11020,
  crc = 205,
)
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
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloat(aoa)
    outputBuffer.encodeFloat(ssa)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 11020

    private const val CRC: Int = 205

    private const val SIZE: Int = 16

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
