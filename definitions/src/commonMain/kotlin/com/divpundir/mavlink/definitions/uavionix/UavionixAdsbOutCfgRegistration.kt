package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit

/**
 * Aircraft Registration.
 *
 * @param registration Aircraft Registration (ASCII string A-Z, 0-9 only), e.g. "N8644B ". Trailing
 * spaces (0x20) only. This is null-terminated.
 */
@GeneratedMavMessage(
  id = 10_004u,
  crcExtra = -123,
)
public data class UavionixAdsbOutCfgRegistration(
  /**
   * Aircraft Registration (ASCII string A-Z, 0-9 only), e.g. "N8644B ". Trailing spaces (0x20)
   * only. This is null-terminated.
   */
  @GeneratedMavField(type = "char[9]")
  public val registration: String = "",
) : MavMessage<UavionixAdsbOutCfgRegistration> {
  override val instanceCompanion: MavMessage.MavCompanion<UavionixAdsbOutCfgRegistration> =
      Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeString(registration, 9)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeString(registration, 9)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<UavionixAdsbOutCfgRegistration> {
    private const val SIZE_V1: Int = 9

    private const val SIZE_V2: Int = 9

    override val id: UInt = 10_004u

    override val crcExtra: Byte = -123

    override fun deserialize(bytes: ByteArray): UavionixAdsbOutCfgRegistration {
      val decoder = MavDataDecoder(bytes)

      val registration = decoder.safeDecodeString(9)

      return UavionixAdsbOutCfgRegistration(
        registration = registration,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): UavionixAdsbOutCfgRegistration =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var registration: String = ""

    public fun build(): UavionixAdsbOutCfgRegistration = UavionixAdsbOutCfgRegistration(
      registration = registration,
    )
  }
}
