package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

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
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  public val targetComponent: Int = 0,
  /**
   * Demanded angular rate X.
   */
  public val demandedRateX: Float = 0F,
  /**
   * Demanded angular rate Y.
   */
  public val demandedRateY: Float = 0F,
  /**
   * Demanded angular rate Z.
   */
  public val demandedRateZ: Float = 0F,
) : MavMessage<GimbalControl> {
  public override val instanceMetadata: MavMessage.Metadata<GimbalControl> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(demandedRateX)
    outputBuffer.encodeFloat(demandedRateY)
    outputBuffer.encodeFloat(demandedRateZ)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 201

    private const val CRC: Int = 205

    private const val SIZE: Int = 14

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
  }
}
