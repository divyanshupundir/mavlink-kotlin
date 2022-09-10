package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Data for injecting into the onboard GPS (used for DGPS)
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 123,
  crc = 250,
)
public data class GpsInjectData(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * Data length
   */
  @GeneratedMavField(type = "uint8_t")
  public val len: Int = 0,
  /**
   * Raw data (110 is enough for 12 satellites of RTCMv2)
   */
  @GeneratedMavField(type = "uint8_t[110]")
  public val `data`: List<Int> = emptyList(),
) : MavMessage<GpsInjectData> {
  public override val instanceMetadata: MavMessage.Metadata<GpsInjectData> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(len)
    outputBuffer.encodeUint8Array(data, 110)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(len)
    outputBuffer.encodeUint8Array(data, 110)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 123

    private const val CRC: Int = 250

    private const val SIZE: Int = 113

    private val DESERIALIZER: MavDeserializer<GpsInjectData> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val len = inputBuffer.decodeUint8()
      val data = inputBuffer.decodeUint8Array(110)

      GpsInjectData(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        len = len,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<GpsInjectData> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GpsInjectData> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var len: Int = 0

    public var `data`: List<Int> = emptyList()

    public fun build(): GpsInjectData = GpsInjectData(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      len = len,
      data = data,
    )
  }
}
