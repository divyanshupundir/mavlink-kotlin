package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

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
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * 3 axis gimbal measurements.
 */
@GeneratedMavMessage(
  id = 200,
  crc = 134,
)
public data class GimbalReport(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * Time since last update.
   */
  @GeneratedMavField(type = "float")
  public val deltaTime: Float = 0F,
  /**
   * Delta angle X.
   */
  @GeneratedMavField(type = "float")
  public val deltaAngleX: Float = 0F,
  /**
   * Delta angle Y.
   */
  @GeneratedMavField(type = "float")
  public val deltaAngleY: Float = 0F,
  /**
   * Delta angle X.
   */
  @GeneratedMavField(type = "float")
  public val deltaAngleZ: Float = 0F,
  /**
   * Delta velocity X.
   */
  @GeneratedMavField(type = "float")
  public val deltaVelocityX: Float = 0F,
  /**
   * Delta velocity Y.
   */
  @GeneratedMavField(type = "float")
  public val deltaVelocityY: Float = 0F,
  /**
   * Delta velocity Z.
   */
  @GeneratedMavField(type = "float")
  public val deltaVelocityZ: Float = 0F,
  /**
   * Joint ROLL.
   */
  @GeneratedMavField(type = "float")
  public val jointRoll: Float = 0F,
  /**
   * Joint EL.
   */
  @GeneratedMavField(type = "float")
  public val jointEl: Float = 0F,
  /**
   * Joint AZ.
   */
  @GeneratedMavField(type = "float")
  public val jointAz: Float = 0F,
) : MavMessage<GimbalReport> {
  public override val instanceMetadata: MavMessage.Metadata<GimbalReport> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(deltaTime)
    outputBuffer.encodeFloat(deltaAngleX)
    outputBuffer.encodeFloat(deltaAngleY)
    outputBuffer.encodeFloat(deltaAngleZ)
    outputBuffer.encodeFloat(deltaVelocityX)
    outputBuffer.encodeFloat(deltaVelocityY)
    outputBuffer.encodeFloat(deltaVelocityZ)
    outputBuffer.encodeFloat(jointRoll)
    outputBuffer.encodeFloat(jointEl)
    outputBuffer.encodeFloat(jointAz)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(deltaTime)
    outputBuffer.encodeFloat(deltaAngleX)
    outputBuffer.encodeFloat(deltaAngleY)
    outputBuffer.encodeFloat(deltaAngleZ)
    outputBuffer.encodeFloat(deltaVelocityX)
    outputBuffer.encodeFloat(deltaVelocityY)
    outputBuffer.encodeFloat(deltaVelocityZ)
    outputBuffer.encodeFloat(jointRoll)
    outputBuffer.encodeFloat(jointEl)
    outputBuffer.encodeFloat(jointAz)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 200

    private const val CRC: Int = 134

    private const val SIZE: Int = 42

    private val DESERIALIZER: MavDeserializer<GimbalReport> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val deltaTime = inputBuffer.decodeFloat()
      val deltaAngleX = inputBuffer.decodeFloat()
      val deltaAngleY = inputBuffer.decodeFloat()
      val deltaAngleZ = inputBuffer.decodeFloat()
      val deltaVelocityX = inputBuffer.decodeFloat()
      val deltaVelocityY = inputBuffer.decodeFloat()
      val deltaVelocityZ = inputBuffer.decodeFloat()
      val jointRoll = inputBuffer.decodeFloat()
      val jointEl = inputBuffer.decodeFloat()
      val jointAz = inputBuffer.decodeFloat()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()

      GimbalReport(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        deltaTime = deltaTime,
        deltaAngleX = deltaAngleX,
        deltaAngleY = deltaAngleY,
        deltaAngleZ = deltaAngleZ,
        deltaVelocityX = deltaVelocityX,
        deltaVelocityY = deltaVelocityY,
        deltaVelocityZ = deltaVelocityZ,
        jointRoll = jointRoll,
        jointEl = jointEl,
        jointAz = jointAz,
      )
    }


    private val METADATA: MavMessage.Metadata<GimbalReport> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GimbalReport> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var deltaTime: Float = 0F

    public var deltaAngleX: Float = 0F

    public var deltaAngleY: Float = 0F

    public var deltaAngleZ: Float = 0F

    public var deltaVelocityX: Float = 0F

    public var deltaVelocityY: Float = 0F

    public var deltaVelocityZ: Float = 0F

    public var jointRoll: Float = 0F

    public var jointEl: Float = 0F

    public var jointAz: Float = 0F

    public fun build(): GimbalReport = GimbalReport(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      deltaTime = deltaTime,
      deltaAngleX = deltaAngleX,
      deltaAngleY = deltaAngleY,
      deltaAngleZ = deltaAngleZ,
      deltaVelocityX = deltaVelocityX,
      deltaVelocityY = deltaVelocityY,
      deltaVelocityZ = deltaVelocityZ,
      jointRoll = jointRoll,
      jointEl = jointEl,
      jointAz = jointAz,
    )
  }
}
