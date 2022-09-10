package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * To debug something using a named 3D vector.
 */
@GeneratedMavMessage(
  id = 250,
  crc = 49,
)
public data class DebugVect(
  /**
   * Name
   */
  @GeneratedMavField(type = "char[10]")
  public val name: String = "",
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * x
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * y
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * z
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
) : MavMessage<DebugVect> {
  public override val instanceMetadata: MavMessage.Metadata<DebugVect> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeString(name, 10)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeString(name, 10)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 250

    private const val CRC: Int = 49

    private const val SIZE: Int = 30

    private val DESERIALIZER: MavDeserializer<DebugVect> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val x = inputBuffer.decodeFloat()
      val y = inputBuffer.decodeFloat()
      val z = inputBuffer.decodeFloat()
      val name = inputBuffer.decodeString(10)

      DebugVect(
        name = name,
        timeUsec = timeUsec,
        x = x,
        y = y,
        z = z,
      )
    }


    private val METADATA: MavMessage.Metadata<DebugVect> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DebugVect> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var name: String = ""

    public var timeUsec: BigInteger = BigInteger.ZERO

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public fun build(): DebugVect = DebugVect(
      name = name,
      timeUsec = timeUsec,
      x = x,
      y = y,
      z = z,
    )
  }
}
