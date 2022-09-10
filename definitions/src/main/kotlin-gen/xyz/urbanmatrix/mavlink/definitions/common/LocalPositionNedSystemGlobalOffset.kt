package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * The offset in X, Y, Z and yaw between the LOCAL_POSITION_NED messages of MAV X and the global
 * coordinate frame in NED coordinates. Coordinate frame is right-handed, Z-axis down (aeronautical
 * frame, NED / north-east-down convention)
 */
@GeneratedMavMessage(
  id = 89,
  crc = 231,
)
public data class LocalPositionNedSystemGlobalOffset(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: Long = 0L,
  /**
   * X Position
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * Y Position
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * Z Position
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
  /**
   * Roll
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Pitch
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Yaw
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
) : MavMessage<LocalPositionNedSystemGlobalOffset> {
  public override val instanceMetadata: MavMessage.Metadata<LocalPositionNedSystemGlobalOffset> =
      METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 89

    private const val CRC: Int = 231

    private const val SIZE: Int = 28

    private val DESERIALIZER: MavDeserializer<LocalPositionNedSystemGlobalOffset> =
        MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val x = inputBuffer.decodeFloat()
      val y = inputBuffer.decodeFloat()
      val z = inputBuffer.decodeFloat()
      val roll = inputBuffer.decodeFloat()
      val pitch = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()

      LocalPositionNedSystemGlobalOffset(
        timeBootMs = timeBootMs,
        x = x,
        y = y,
        z = z,
        roll = roll,
        pitch = pitch,
        yaw = yaw,
      )
    }


    private val METADATA: MavMessage.Metadata<LocalPositionNedSystemGlobalOffset> =
        MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<LocalPositionNedSystemGlobalOffset> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: Long = 0L

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public fun build(): LocalPositionNedSystemGlobalOffset = LocalPositionNedSystemGlobalOffset(
      timeBootMs = timeBootMs,
      x = x,
      y = y,
      z = z,
      roll = roll,
      pitch = pitch,
      yaw = yaw,
    )
  }
}
