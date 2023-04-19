package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

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
