package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array

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
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * Data length
   */
  public val len: Int = 0,
  /**
   * Raw data (110 is enough for 12 satellites of RTCMv2)
   */
  public val `data`: List<Int> = emptyList(),
) : MavMessage<GpsInjectData> {
  public override val instanceMetadata: MavMessage.Metadata<GpsInjectData> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(len)
    outputBuffer.encodeUint8Array(data, 110)
    return outputBuffer.array()
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
  }
}
