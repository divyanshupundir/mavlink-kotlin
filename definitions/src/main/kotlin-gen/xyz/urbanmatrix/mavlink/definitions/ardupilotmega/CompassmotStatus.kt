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
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Status of compassmot calibration.
 */
@GeneratedMavMessage(
  id = 177,
  crc = 240,
)
public data class CompassmotStatus(
  /**
   * Throttle.
   */
  @GeneratedMavField(type = "uint16_t")
  public val throttle: Int = 0,
  /**
   * Current.
   */
  @GeneratedMavField(type = "float")
  public val current: Float = 0F,
  /**
   * Interference.
   */
  @GeneratedMavField(type = "uint16_t")
  public val interference: Int = 0,
  /**
   * Motor Compensation X.
   */
  @GeneratedMavField(type = "float")
  public val compensationx: Float = 0F,
  /**
   * Motor Compensation Y.
   */
  @GeneratedMavField(type = "float")
  public val compensationy: Float = 0F,
  /**
   * Motor Compensation Z.
   */
  @GeneratedMavField(type = "float")
  public val compensationz: Float = 0F,
) : MavMessage<CompassmotStatus> {
  public override val instanceMetadata: MavMessage.Metadata<CompassmotStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(current)
    outputBuffer.encodeFloat(compensationx)
    outputBuffer.encodeFloat(compensationy)
    outputBuffer.encodeFloat(compensationz)
    outputBuffer.encodeUint16(throttle)
    outputBuffer.encodeUint16(interference)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(current)
    outputBuffer.encodeFloat(compensationx)
    outputBuffer.encodeFloat(compensationy)
    outputBuffer.encodeFloat(compensationz)
    outputBuffer.encodeUint16(throttle)
    outputBuffer.encodeUint16(interference)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 177

    private const val CRC: Int = 240

    private const val SIZE: Int = 20

    private val DESERIALIZER: MavDeserializer<CompassmotStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val current = inputBuffer.decodeFloat()
      val compensationx = inputBuffer.decodeFloat()
      val compensationy = inputBuffer.decodeFloat()
      val compensationz = inputBuffer.decodeFloat()
      val throttle = inputBuffer.decodeUint16()
      val interference = inputBuffer.decodeUint16()

      CompassmotStatus(
        throttle = throttle,
        current = current,
        interference = interference,
        compensationx = compensationx,
        compensationy = compensationy,
        compensationz = compensationz,
      )
    }


    private val METADATA: MavMessage.Metadata<CompassmotStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CompassmotStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var throttle: Int = 0

    public var current: Float = 0F

    public var interference: Int = 0

    public var compensationx: Float = 0F

    public var compensationy: Float = 0F

    public var compensationz: Float = 0F

    public fun build(): CompassmotStatus = CompassmotStatus(
      throttle = throttle,
      current = current,
      interference = interference,
      compensationx = compensationx,
      compensationy = compensationy,
      compensationz = compensationz,
    )
  }
}
