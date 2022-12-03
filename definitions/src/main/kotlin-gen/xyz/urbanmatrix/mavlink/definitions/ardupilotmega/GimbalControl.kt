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
 * Control message for rate gimbal.
 */
@GeneratedMavMessage(
  id = 201,
  crc = 205,
)
public data class GimbalControl(
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
   * Demanded angular rate X.
   */
  @GeneratedMavField(type = "float")
  public val demandedRateX: Float = 0F,
  /**
   * Demanded angular rate Y.
   */
  @GeneratedMavField(type = "float")
  public val demandedRateY: Float = 0F,
  /**
   * Demanded angular rate Z.
   */
  @GeneratedMavField(type = "float")
  public val demandedRateZ: Float = 0F,
) : MavMessage<GimbalControl> {
  public override val instanceMetadata: MavMessage.Metadata<GimbalControl> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(demandedRateX)
    outputBuffer.encodeFloat(demandedRateY)
    outputBuffer.encodeFloat(demandedRateZ)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(demandedRateX)
    outputBuffer.encodeFloat(demandedRateY)
    outputBuffer.encodeFloat(demandedRateZ)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 201

    private const val CRC: Int = 205

    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 14

    private val DESERIALIZER: MavDeserializer<GimbalControl> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val demandedRateX = inputBuffer.decodeFloat()
      val demandedRateY = inputBuffer.decodeFloat()
      val demandedRateZ = inputBuffer.decodeFloat()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()

      GimbalControl(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        demandedRateX = demandedRateX,
        demandedRateY = demandedRateY,
        demandedRateZ = demandedRateZ,
      )
    }


    private val METADATA: MavMessage.Metadata<GimbalControl> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GimbalControl> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GimbalControl =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var demandedRateX: Float = 0F

    public var demandedRateY: Float = 0F

    public var demandedRateZ: Float = 0F

    public fun build(): GimbalControl = GimbalControl(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      demandedRateX = demandedRateX,
      demandedRateY = demandedRateY,
      demandedRateZ = demandedRateZ,
    )
  }
}
