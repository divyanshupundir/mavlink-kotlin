package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint32

/**
 * The filtered local position (e.g. fused computer vision and accelerometers). Coordinate frame is
 * right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention)
 */
@GeneratedMavMessage(
  id = 32,
  crc = 185,
)
public data class LocalPositionNed(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * X Position
   */
  public val x: Float = 0F,
  /**
   * Y Position
   */
  public val y: Float = 0F,
  /**
   * Z Position
   */
  public val z: Float = 0F,
  /**
   * X Speed
   */
  public val vx: Float = 0F,
  /**
   * Y Speed
   */
  public val vy: Float = 0F,
  /**
   * Z Speed
   */
  public val vz: Float = 0F,
) : MavMessage<LocalPositionNed> {
  public override val instanceMetadata: MavMessage.Metadata<LocalPositionNed> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloat(vx)
    outputBuffer.encodeFloat(vy)
    outputBuffer.encodeFloat(vz)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 32

    private const val CRC: Int = 185

    private const val SIZE: Int = 28

    private val DESERIALIZER: MavDeserializer<LocalPositionNed> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val x = inputBuffer.decodeFloat()
      val y = inputBuffer.decodeFloat()
      val z = inputBuffer.decodeFloat()
      val vx = inputBuffer.decodeFloat()
      val vy = inputBuffer.decodeFloat()
      val vz = inputBuffer.decodeFloat()

      LocalPositionNed(
        timeBootMs = timeBootMs,
        x = x,
        y = y,
        z = z,
        vx = vx,
        vy = vy,
        vz = vz,
      )
    }


    private val METADATA: MavMessage.Metadata<LocalPositionNed> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<LocalPositionNed> = METADATA
  }
}
