package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * A forwarded CAN frame as requested by MAV_CMD_CAN_FORWARD.
 */
@GeneratedMavMessage(
  id = 386,
  crc = 132,
)
public data class CanFrame(
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
   * Bus number
   */
  @GeneratedMavField(type = "uint8_t")
  public val bus: Int = 0,
  /**
   * Frame length
   */
  @GeneratedMavField(type = "uint8_t")
  public val len: Int = 0,
  /**
   * Frame ID
   */
  @GeneratedMavField(type = "uint32_t")
  public val id: Long = 0L,
  /**
   * Frame data
   */
  @GeneratedMavField(type = "uint8_t[8]")
  public val `data`: List<Int> = emptyList(),
) : MavMessage<CanFrame> {
  public override val instanceMetadata: MavMessage.Metadata<CanFrame> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(id)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(bus)
    outputBuffer.encodeUint8(len)
    outputBuffer.encodeUint8Array(data, 8)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(id)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(bus)
    outputBuffer.encodeUint8(len)
    outputBuffer.encodeUint8Array(data, 8)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 386

    private const val CRC: Int = 132

    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 16

    private val DESERIALIZER: MavDeserializer<CanFrame> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val id = inputBuffer.decodeUint32()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val bus = inputBuffer.decodeUint8()
      val len = inputBuffer.decodeUint8()
      val data = inputBuffer.decodeUint8Array(8)

      CanFrame(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        bus = bus,
        len = len,
        id = id,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<CanFrame> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CanFrame> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): CanFrame =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var bus: Int = 0

    public var len: Int = 0

    public var id: Long = 0L

    public var `data`: List<Int> = emptyList()

    public fun build(): CanFrame = CanFrame(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      bus = bus,
      len = len,
      id = id,
      data = data,
    )
  }
}
