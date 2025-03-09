package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Request messages.
 *
 * @param reqmessageid Message ID to request. Supports any message in this 10000-10099 range
 */
@GeneratedMavMessage(
  id = 10_006u,
  crcExtra = -63,
)
public data class UavionixAdsbGet(
  /**
   * Message ID to request. Supports any message in this 10000-10099 range
   */
  @GeneratedMavField(type = "uint32_t")
  public val reqmessageid: UInt = 0u,
) : MavMessage<UavionixAdsbGet> {
  override val instanceCompanion: MavMessage.MavCompanion<UavionixAdsbGet> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(reqmessageid)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(reqmessageid)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<UavionixAdsbGet> {
    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 4

    override val id: UInt = 10_006u

    override val crcExtra: Byte = -63

    override fun deserialize(bytes: ByteArray): UavionixAdsbGet {
      val decoder = MavDataDecoder(bytes)

      val reqmessageid = decoder.safeDecodeUInt32()

      return UavionixAdsbGet(
        reqmessageid = reqmessageid,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): UavionixAdsbGet =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var reqmessageid: UInt = 0u

    public fun build(): UavionixAdsbGet = UavionixAdsbGet(
      reqmessageid = reqmessageid,
    )
  }
}
