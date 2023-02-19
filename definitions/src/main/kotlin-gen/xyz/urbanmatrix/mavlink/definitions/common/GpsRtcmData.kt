package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * RTCM message for injecting into the onboard GPS (used for DGPS)
 */
@GeneratedMavMessage(
  id = 233u,
  crcExtra = 35,
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
  public val flags: UByte = 0u,
  /**
   * data length
   */
  @GeneratedMavField(type = "uint8_t")
  public val len: UByte = 0u,
  /**
   * RTCM message (may be fragmented)
   */
  @GeneratedMavField(type = "uint8_t[180]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<GpsRtcmData> {
  public override val instanceMetadata: MavMessage.Metadata<GpsRtcmData> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(flags)
    outputBuffer.encodeUInt8(len)
    outputBuffer.encodeUInt8Array(data, 180)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(flags)
    outputBuffer.encodeUInt8(len)
    outputBuffer.encodeUInt8Array(data, 180)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 233u

    private const val CRC_EXTRA: Byte = 35

    private const val SIZE_V1: Int = 182

    private const val SIZE_V2: Int = 182

    private val DESERIALIZER: MavDeserializer<GpsRtcmData> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val flags = inputBuffer.decodeUInt8()
      val len = inputBuffer.decodeUInt8()
      val data = inputBuffer.decodeUInt8Array(180)

      GpsRtcmData(
        flags = flags,
        len = len,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<GpsRtcmData> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GpsRtcmData> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GpsRtcmData =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var flags: UByte = 0u

    public var len: UByte = 0u

    public var `data`: List<UByte> = emptyList()

    public fun build(): GpsRtcmData = GpsRtcmData(
      flags = flags,
      len = len,
      data = data,
    )
  }
}
