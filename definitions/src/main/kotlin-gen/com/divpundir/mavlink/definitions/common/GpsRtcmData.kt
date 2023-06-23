package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

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
  public override val instanceCompanion: MavMessage.MavCompanion<GpsRtcmData> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(flags)
    output.encodeUInt8(len)
    output.encodeUInt8Array(data, 180)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(flags)
    output.encodeUInt8(len)
    output.encodeUInt8Array(data, 180)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<GpsRtcmData> {
    private const val SIZE_V1: Int = 182

    private const val SIZE_V2: Int = 182

    public override val id: UInt = 233u

    public override val crcExtra: Byte = 35

    public override fun deserialize(source: BufferedSource): GpsRtcmData {
      val flags = source.decodeUInt8()
      val len = source.decodeUInt8()
      val data = source.decodeUInt8Array(180)

      return GpsRtcmData(
        flags = flags,
        len = len,
        data = data,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GpsRtcmData =
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
