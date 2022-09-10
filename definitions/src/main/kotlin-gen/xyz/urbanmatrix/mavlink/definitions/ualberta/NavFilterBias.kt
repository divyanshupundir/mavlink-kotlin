package xyz.urbanmatrix.mavlink.definitions.ualberta

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Accelerometer and Gyro biases from the navigation filter
 */
@GeneratedMavMessage(
  id = 220,
  crc = 34,
)
public data class NavFilterBias(
  /**
   * Timestamp (microseconds)
   */
  @GeneratedMavField(type = "uint64_t")
  public val usec: BigInteger = BigInteger.ZERO,
  /**
   * b_f[0]
   */
  @GeneratedMavField(type = "float")
  public val accel0: Float = 0F,
  /**
   * b_f[1]
   */
  @GeneratedMavField(type = "float")
  public val accel1: Float = 0F,
  /**
   * b_f[2]
   */
  @GeneratedMavField(type = "float")
  public val accel2: Float = 0F,
  /**
   * b_f[0]
   */
  @GeneratedMavField(type = "float")
  public val gyro0: Float = 0F,
  /**
   * b_f[1]
   */
  @GeneratedMavField(type = "float")
  public val gyro1: Float = 0F,
  /**
   * b_f[2]
   */
  @GeneratedMavField(type = "float")
  public val gyro2: Float = 0F,
) : MavMessage<NavFilterBias> {
  public override val instanceMetadata: MavMessage.Metadata<NavFilterBias> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(usec)
    outputBuffer.encodeFloat(accel0)
    outputBuffer.encodeFloat(accel1)
    outputBuffer.encodeFloat(accel2)
    outputBuffer.encodeFloat(gyro0)
    outputBuffer.encodeFloat(gyro1)
    outputBuffer.encodeFloat(gyro2)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(usec)
    outputBuffer.encodeFloat(accel0)
    outputBuffer.encodeFloat(accel1)
    outputBuffer.encodeFloat(accel2)
    outputBuffer.encodeFloat(gyro0)
    outputBuffer.encodeFloat(gyro1)
    outputBuffer.encodeFloat(gyro2)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 220

    private const val CRC: Int = 34

    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 32

    private val DESERIALIZER: MavDeserializer<NavFilterBias> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val usec = inputBuffer.decodeUint64()
      val accel0 = inputBuffer.decodeFloat()
      val accel1 = inputBuffer.decodeFloat()
      val accel2 = inputBuffer.decodeFloat()
      val gyro0 = inputBuffer.decodeFloat()
      val gyro1 = inputBuffer.decodeFloat()
      val gyro2 = inputBuffer.decodeFloat()

      NavFilterBias(
        usec = usec,
        accel0 = accel0,
        accel1 = accel1,
        accel2 = accel2,
        gyro0 = gyro0,
        gyro1 = gyro1,
        gyro2 = gyro2,
      )
    }


    private val METADATA: MavMessage.Metadata<NavFilterBias> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<NavFilterBias> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var usec: BigInteger = BigInteger.ZERO

    public var accel0: Float = 0F

    public var accel1: Float = 0F

    public var accel2: Float = 0F

    public var gyro0: Float = 0F

    public var gyro1: Float = 0F

    public var gyro2: Float = 0F

    public fun build(): NavFilterBias = NavFilterBias(
      usec = usec,
      accel0 = accel0,
      accel1 = accel1,
      accel2 = accel2,
      gyro0 = gyro0,
      gyro1 = gyro1,
      gyro2 = gyro2,
    )
  }
}
