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
 * Initializing the TURN protocol
 *
 */
@GeneratedMavMessage(
  id = 52_005u,
  crcExtra = -111,
)
public data class AirlinkEyeTurnInit(
  /**
   * Turn init type
   */
  @GeneratedMavField(type = "uint8_t")
  public val respType: MavEnumValue<AirlinkEyeTurnInitType> = MavEnumValue.fromValue(0u),
) : MavMessage<AirlinkEyeTurnInit> {
  override val instanceCompanion: MavMessage.MavCompanion<AirlinkEyeTurnInit> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeEnumValue(respType.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeEnumValue(respType.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AirlinkEyeTurnInit> {
    private const val SIZE_V1: Int = 1

    private const val SIZE_V2: Int = 1

    override val id: UInt = 52_005u

    override val crcExtra: Byte = -111

    override fun deserialize(bytes: ByteArray): AirlinkEyeTurnInit {
      val decoder = MavDataDecoder(bytes)

      val respType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = AirlinkEyeTurnInitType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return AirlinkEyeTurnInit(
        respType = respType,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AirlinkEyeTurnInit =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var respType: MavEnumValue<AirlinkEyeTurnInitType> = MavEnumValue.fromValue(0u)

    public fun build(): AirlinkEyeTurnInit = AirlinkEyeTurnInit(
      respType = respType,
    )
  }
}
