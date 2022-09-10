package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * The smoothed, monotonic system state used to feed the control loops of the system.
 */
@GeneratedMavMessage(
  id = 146,
  crc = 103,
)
public data class ControlSystemState(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * X acceleration in body frame
   */
  @GeneratedMavField(type = "float")
  public val xAcc: Float = 0F,
  /**
   * Y acceleration in body frame
   */
  @GeneratedMavField(type = "float")
  public val yAcc: Float = 0F,
  /**
   * Z acceleration in body frame
   */
  @GeneratedMavField(type = "float")
  public val zAcc: Float = 0F,
  /**
   * X velocity in body frame
   */
  @GeneratedMavField(type = "float")
  public val xVel: Float = 0F,
  /**
   * Y velocity in body frame
   */
  @GeneratedMavField(type = "float")
  public val yVel: Float = 0F,
  /**
   * Z velocity in body frame
   */
  @GeneratedMavField(type = "float")
  public val zVel: Float = 0F,
  /**
   * X position in local frame
   */
  @GeneratedMavField(type = "float")
  public val xPos: Float = 0F,
  /**
   * Y position in local frame
   */
  @GeneratedMavField(type = "float")
  public val yPos: Float = 0F,
  /**
   * Z position in local frame
   */
  @GeneratedMavField(type = "float")
  public val zPos: Float = 0F,
  /**
   * Airspeed, set to -1 if unknown
   */
  @GeneratedMavField(type = "float")
  public val airspeed: Float = 0F,
  /**
   * Variance of body velocity estimate
   */
  @GeneratedMavField(type = "float[3]")
  public val velVariance: List<Float> = emptyList(),
  /**
   * Variance in local position
   */
  @GeneratedMavField(type = "float[3]")
  public val posVariance: List<Float> = emptyList(),
  /**
   * The attitude, represented as Quaternion
   */
  @GeneratedMavField(type = "float[4]")
  public val q: List<Float> = emptyList(),
  /**
   * Angular rate in roll axis
   */
  @GeneratedMavField(type = "float")
  public val rollRate: Float = 0F,
  /**
   * Angular rate in pitch axis
   */
  @GeneratedMavField(type = "float")
  public val pitchRate: Float = 0F,
  /**
   * Angular rate in yaw axis
   */
  @GeneratedMavField(type = "float")
  public val yawRate: Float = 0F,
) : MavMessage<ControlSystemState> {
  public override val instanceMetadata: MavMessage.Metadata<ControlSystemState> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloat(xAcc)
    outputBuffer.encodeFloat(yAcc)
    outputBuffer.encodeFloat(zAcc)
    outputBuffer.encodeFloat(xVel)
    outputBuffer.encodeFloat(yVel)
    outputBuffer.encodeFloat(zVel)
    outputBuffer.encodeFloat(xPos)
    outputBuffer.encodeFloat(yPos)
    outputBuffer.encodeFloat(zPos)
    outputBuffer.encodeFloat(airspeed)
    outputBuffer.encodeFloatArray(velVariance, 12)
    outputBuffer.encodeFloatArray(posVariance, 12)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeFloat(rollRate)
    outputBuffer.encodeFloat(pitchRate)
    outputBuffer.encodeFloat(yawRate)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloat(xAcc)
    outputBuffer.encodeFloat(yAcc)
    outputBuffer.encodeFloat(zAcc)
    outputBuffer.encodeFloat(xVel)
    outputBuffer.encodeFloat(yVel)
    outputBuffer.encodeFloat(zVel)
    outputBuffer.encodeFloat(xPos)
    outputBuffer.encodeFloat(yPos)
    outputBuffer.encodeFloat(zPos)
    outputBuffer.encodeFloat(airspeed)
    outputBuffer.encodeFloatArray(velVariance, 12)
    outputBuffer.encodeFloatArray(posVariance, 12)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeFloat(rollRate)
    outputBuffer.encodeFloat(pitchRate)
    outputBuffer.encodeFloat(yawRate)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 146

    private const val CRC: Int = 103

    private const val SIZE_V1: Int = 100

    private const val SIZE_V2: Int = 100

    private val DESERIALIZER: MavDeserializer<ControlSystemState> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val xAcc = inputBuffer.decodeFloat()
      val yAcc = inputBuffer.decodeFloat()
      val zAcc = inputBuffer.decodeFloat()
      val xVel = inputBuffer.decodeFloat()
      val yVel = inputBuffer.decodeFloat()
      val zVel = inputBuffer.decodeFloat()
      val xPos = inputBuffer.decodeFloat()
      val yPos = inputBuffer.decodeFloat()
      val zPos = inputBuffer.decodeFloat()
      val airspeed = inputBuffer.decodeFloat()
      val velVariance = inputBuffer.decodeFloatArray(12)
      val posVariance = inputBuffer.decodeFloatArray(12)
      val q = inputBuffer.decodeFloatArray(16)
      val rollRate = inputBuffer.decodeFloat()
      val pitchRate = inputBuffer.decodeFloat()
      val yawRate = inputBuffer.decodeFloat()

      ControlSystemState(
        timeUsec = timeUsec,
        xAcc = xAcc,
        yAcc = yAcc,
        zAcc = zAcc,
        xVel = xVel,
        yVel = yVel,
        zVel = zVel,
        xPos = xPos,
        yPos = yPos,
        zPos = zPos,
        airspeed = airspeed,
        velVariance = velVariance,
        posVariance = posVariance,
        q = q,
        rollRate = rollRate,
        pitchRate = pitchRate,
        yawRate = yawRate,
      )
    }


    private val METADATA: MavMessage.Metadata<ControlSystemState> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ControlSystemState> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: BigInteger = BigInteger.ZERO

    public var xAcc: Float = 0F

    public var yAcc: Float = 0F

    public var zAcc: Float = 0F

    public var xVel: Float = 0F

    public var yVel: Float = 0F

    public var zVel: Float = 0F

    public var xPos: Float = 0F

    public var yPos: Float = 0F

    public var zPos: Float = 0F

    public var airspeed: Float = 0F

    public var velVariance: List<Float> = emptyList()

    public var posVariance: List<Float> = emptyList()

    public var q: List<Float> = emptyList()

    public var rollRate: Float = 0F

    public var pitchRate: Float = 0F

    public var yawRate: Float = 0F

    public fun build(): ControlSystemState = ControlSystemState(
      timeUsec = timeUsec,
      xAcc = xAcc,
      yAcc = yAcc,
      zAcc = zAcc,
      xVel = xVel,
      yVel = yVel,
      zVel = zVel,
      xPos = xPos,
      yPos = yPos,
      zPos = zPos,
      airspeed = airspeed,
      velVariance = velVariance,
      posVariance = posVariance,
      q = q,
      rollRate = rollRate,
      pitchRate = pitchRate,
      yawRate = yawRate,
    )
  }
}
