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
 * Flight Identification for ADSB-Out vehicles.
 *
 * @param flightId Flight Identification: 8 ASCII characters, '0' through '9', 'A' through 'Z' or
 * space. Spaces (0x20) used as a trailing pad character, or when call sign is unavailable. Reflects
 * Control message setting. This is null-terminated.
 */
@GeneratedMavMessage(
  id = 10_005u,
  crcExtra = 103,
)
public data class UavionixAdsbOutCfgFlightid(
  /**
   * Flight Identification: 8 ASCII characters, '0' through '9', 'A' through 'Z' or space. Spaces
   * (0x20) used as a trailing pad character, or when call sign is unavailable. Reflects Control
   * message setting. This is null-terminated.
   */
  @GeneratedMavField(type = "char[9]")
  public val flightId: String = "",
) : MavMessage<UavionixAdsbOutCfgFlightid> {
  override val instanceCompanion: MavMessage.MavCompanion<UavionixAdsbOutCfgFlightid> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeString(flightId, 9)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeString(flightId, 9)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<UavionixAdsbOutCfgFlightid> {
    private const val SIZE_V1: Int = 9

    private const val SIZE_V2: Int = 9

    override val id: UInt = 10_005u

    override val crcExtra: Byte = 103

    override fun deserialize(bytes: ByteArray): UavionixAdsbOutCfgFlightid {
      val decoder = MavDataDecoder(bytes)

      val flightId = decoder.safeDecodeString(9)

      return UavionixAdsbOutCfgFlightid(
        flightId = flightId,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): UavionixAdsbOutCfgFlightid =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var flightId: String = ""

    public fun build(): UavionixAdsbOutCfgFlightid = UavionixAdsbOutCfgFlightid(
      flightId = flightId,
    )
  }
}
