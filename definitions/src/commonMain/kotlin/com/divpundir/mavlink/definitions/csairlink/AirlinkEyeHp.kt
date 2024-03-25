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
 * A package with information about the hole punching status. It is used for constant sending to
 * avoid NAT closing timeout.
 *
 * @param respType Hole push response type
 */
@GeneratedMavMessage(
  id = 52_004u,
  crcExtra = 39,
)
public data class AirlinkEyeHp(
  /**
   * Hole push response type
   */
  @GeneratedMavField(type = "uint8_t")
  public val respType: MavEnumValue<AirlinkEyeHolePushType> = MavEnumValue.fromValue(0u),
) : MavMessage<AirlinkEyeHp> {
  override val instanceCompanion: MavMessage.MavCompanion<AirlinkEyeHp> = Companion

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

  public companion object : MavMessage.MavCompanion<AirlinkEyeHp> {
    private const val SIZE_V1: Int = 1

    private const val SIZE_V2: Int = 1

    override val id: UInt = 52_004u

    override val crcExtra: Byte = 39

    override fun deserialize(bytes: ByteArray): AirlinkEyeHp {
      val decoder = MavDataDecoder(bytes)

      val respType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = AirlinkEyeHolePushType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return AirlinkEyeHp(
        respType = respType,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AirlinkEyeHp =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var respType: MavEnumValue<AirlinkEyeHolePushType> = MavEnumValue.fromValue(0u)

    public fun build(): AirlinkEyeHp = AirlinkEyeHp(
      respType = respType,
    )
  }
}
