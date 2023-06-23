package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(requestId)
    output.encodeEnumValue(result.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(requestId)
    output.encodeEnumValue(result.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<OsdParamConfigReply> {
    private const val SIZE_V1: Int = 5

    private const val SIZE_V2: Int = 5

    public override val id: UInt = 11_034u

    public override val crcExtra: Byte = 79

    public override fun deserialize(source: BufferedSource): OsdParamConfigReply {
      val requestId = source.decodeUInt32()
      val result = source.decodeEnumValue(1).let { value ->
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
