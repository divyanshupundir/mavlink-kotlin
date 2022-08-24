package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint64

/**
 * Camera-IMU triggering and synchronisation message.
 */
@GeneratedMavMessage(
  id = 112,
  crc = 174,
)
public data class CameraTrigger(
  /**
   * Timestamp for image frame (UNIX Epoch time or time since system boot). The receiving end can
   * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
   * number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Image frame sequence
   */
  public val seq: Long = 0L,
) : MavMessage<CameraTrigger> {
  public override val instanceMetadata: MavMessage.Metadata<CameraTrigger> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint32(seq)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 112

    private const val CRC: Int = 174

    private const val SIZE: Int = 12

    private val DESERIALIZER: MavDeserializer<CameraTrigger> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val seq = inputBuffer.decodeUint32()

      CameraTrigger(
        timeUsec = timeUsec,
        seq = seq,
      )
    }


    private val METADATA: MavMessage.Metadata<CameraTrigger> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CameraTrigger> = METADATA
  }
}
