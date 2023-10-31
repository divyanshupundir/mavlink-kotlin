package com.divpundir.mavlink.definitions.csairlink

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Response to the authorization request
 */
@GeneratedMavMessage(
  id = 52_001u,
  crcExtra = -17,
)
public data class AirlinkAuthResponse(
  /**
   * Response type
   */
  @GeneratedMavField(type = "uint8_t")
  public val respType: MavEnumValue<AirlinkAuthResponseType> = MavEnumValue.fromValue(0u),
) : MavMessage<AirlinkAuthResponse> {
  public override val instanceCompanion: MavMessage.MavCompanion<AirlinkAuthResponse> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeEnumValue(respType.value, 1)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeEnumValue(respType.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AirlinkAuthResponse> {
    private const val SIZE_V1: Int = 1

    private const val SIZE_V2: Int = 1

    public override val id: UInt = 52_001u

    public override val crcExtra: Byte = -17

    public override fun deserialize(bytes: ByteArray): AirlinkAuthResponse {
      val decoder = MavDataDecoder.wrap(bytes)

      val respType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = AirlinkAuthResponseType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return AirlinkAuthResponse(
        respType = respType,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AirlinkAuthResponse =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var respType: MavEnumValue<AirlinkAuthResponseType> = MavEnumValue.fromValue(0u)

    public fun build(): AirlinkAuthResponse = AirlinkAuthResponse(
      respType = respType,
    )
  }
}
