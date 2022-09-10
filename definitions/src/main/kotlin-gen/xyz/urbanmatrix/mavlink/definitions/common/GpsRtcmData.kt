package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
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
 * RTCM message for injecting into the onboard GPS (used for DGPS)
 */
@GeneratedMavMessage(
  id = 233,
  crc = 35,
)
public data class GpsRtcmData(
  /**
   * LSB: 1 means message is fragmented, next 2 bits are the fragment ID, the remaining 5 bits are
   * used for the sequence ID. Messages are only to be flushed to the GPS when the entire message has
   * been reconstructed on the autopilot. The fragment ID specifies which order the fragments should be
   * assembled into a buffer, while the sequence ID is used to detect a mismatch between different
   * buffers. The buffer is considered fully reconstructed when either all 4 fragments are present, or
   * all the fragments before the first fragment with a non full payload is received. This management
   * is used to ensure that normal GPS operation doesn't corrupt RTCM data, and to recover from a
   * unreliable transport delivery order.
   */
  @GeneratedMavField(type = "uint8_t")
  public val flags: Int = 0,
  /**
   * data length
   */
  @GeneratedMavField(type = "uint8_t")
  public val len: Int = 0,
  /**
   * RTCM message (may be fragmented)
   */
  @GeneratedMavField(type = "uint8_t[180]")
  public val `data`: List<Int> = emptyList(),
) : MavMessage<GpsRtcmData> {
  public override val instanceMetadata: MavMessage.Metadata<GpsRtcmData> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(flags)
    outputBuffer.encodeUint8(len)
    outputBuffer.encodeUint8Array(data, 180)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(flags)
    outputBuffer.encodeUint8(len)
    outputBuffer.encodeUint8Array(data, 180)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 233

    private const val CRC: Int = 35

    private const val SIZE: Int = 182

    private val DESERIALIZER: MavDeserializer<GpsRtcmData> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val flags = inputBuffer.decodeUint8()
      val len = inputBuffer.decodeUint8()
      val data = inputBuffer.decodeUint8Array(180)

      GpsRtcmData(
        flags = flags,
        len = len,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<GpsRtcmData> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GpsRtcmData> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var flags: Int = 0

    public var len: Int = 0

    public var `data`: List<Int> = emptyList()

    public fun build(): GpsRtcmData = GpsRtcmData(
      flags = flags,
      len = len,
      data = data,
    )
  }
}
