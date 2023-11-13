package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Configure OSD parameter reply.
 */
@GeneratedMavMessage(
  id = 11_034u,
  crcExtra = 79,
)
public data class OsdParamConfigReply(
  /**
   * Request ID - copied from request.
   */
  @GeneratedMavField(type = "uint32_t")
  public val requestId: UInt = 0u,
  /**
   * Config error type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val result: MavEnumValue<OsdParamConfigError> = MavEnumValue.fromValue(0u),
) : MavMessage<OsdParamConfigReply> {
  public override val instanceCompanion: MavMessage.MavCompanion<OsdParamConfigReply> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(requestId)
    encoder.encodeEnumValue(result.value, 1)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(requestId)
    encoder.encodeEnumValue(result.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OsdParamConfigReply> {
    private const val SIZE_V1: Int = 5

    private const val SIZE_V2: Int = 5

    public override val id: UInt = 11_034u

    public override val crcExtra: Byte = 79

    public override fun deserialize(bytes: ByteArray): OsdParamConfigReply {
      val decoder = MavDataDecoder(bytes)

      val requestId = decoder.safeDecodeUInt32()
      val result = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = OsdParamConfigError.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return OsdParamConfigReply(
        requestId = requestId,
        result = result,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): OsdParamConfigReply =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var requestId: UInt = 0u

    public var result: MavEnumValue<OsdParamConfigError> = MavEnumValue.fromValue(0u)

    public fun build(): OsdParamConfigReply = OsdParamConfigReply(
      requestId = requestId,
      result = result,
    )
  }
}
