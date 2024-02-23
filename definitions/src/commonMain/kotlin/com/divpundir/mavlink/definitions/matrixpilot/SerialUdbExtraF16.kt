package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F16 format
 *
 * @param sueIdLeadPilot Serial UDB Extra Name of Expected Lead Pilot
 * @param sueIdDiyDronesUrl Serial UDB Extra URL of Lead Pilot or Team
 */
@GeneratedMavMessage(
  id = 180u,
  crcExtra = -34,
)
public data class SerialUdbExtraF16(
  /**
   * Serial UDB Extra Name of Expected Lead Pilot
   */
  @GeneratedMavField(type = "uint8_t[40]")
  public val sueIdLeadPilot: List<UByte> = emptyList(),
  /**
   * Serial UDB Extra URL of Lead Pilot or Team
   */
  @GeneratedMavField(type = "uint8_t[70]")
  public val sueIdDiyDronesUrl: List<UByte> = emptyList(),
) : MavMessage<SerialUdbExtraF16> {
  override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF16> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8Array(sueIdLeadPilot, 40)
    encoder.encodeUInt8Array(sueIdDiyDronesUrl, 70)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8Array(sueIdLeadPilot, 40)
    encoder.encodeUInt8Array(sueIdDiyDronesUrl, 70)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF16> {
    private const val SIZE_V1: Int = 110

    private const val SIZE_V2: Int = 110

    override val id: UInt = 180u

    override val crcExtra: Byte = -34

    override fun deserialize(bytes: ByteArray): SerialUdbExtraF16 {
      val decoder = MavDataDecoder(bytes)

      val sueIdLeadPilot = decoder.safeDecodeUInt8Array(40)
      val sueIdDiyDronesUrl = decoder.safeDecodeUInt8Array(70)

      return SerialUdbExtraF16(
        sueIdLeadPilot = sueIdLeadPilot,
        sueIdDiyDronesUrl = sueIdDiyDronesUrl,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SerialUdbExtraF16 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueIdLeadPilot: List<UByte> = emptyList()

    public var sueIdDiyDronesUrl: List<UByte> = emptyList()

    public fun build(): SerialUdbExtraF16 = SerialUdbExtraF16(
      sueIdLeadPilot = sueIdLeadPilot,
      sueIdDiyDronesUrl = sueIdDiyDronesUrl,
    )
  }
}
