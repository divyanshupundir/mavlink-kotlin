package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Request a current fence point from MAV.
 */
@GeneratedMavMessage(
  id = 161,
  crc = 68,
)
public data class FenceFetchPoint(
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
   * Point index (first point is 1, 0 is for return point).
   */
  @GeneratedMavField(type = "uint8_t")
  public val idx: Int = 0,
) : MavMessage<FenceFetchPoint> {
  public override val instanceMetadata: MavMessage.Metadata<FenceFetchPoint> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(idx)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(idx)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 161

    private const val CRC: Int = 68

    private const val SIZE: Int = 3

    private val DESERIALIZER: MavDeserializer<FenceFetchPoint> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val idx = inputBuffer.decodeUint8()

      FenceFetchPoint(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idx = idx,
      )
    }


    private val METADATA: MavMessage.Metadata<FenceFetchPoint> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FenceFetchPoint> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var idx: Int = 0

    public fun build(): FenceFetchPoint = FenceFetchPoint(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      idx = idx,
    )
  }
}
