package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8Array
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
 * Backwards compatible version of SERIAL_UDB_EXTRA F16 format
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
  public override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF16> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8Array(sueIdLeadPilot, 40)
    output.encodeUInt8Array(sueIdDiyDronesUrl, 70)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8Array(sueIdLeadPilot, 40)
    output.encodeUInt8Array(sueIdDiyDronesUrl, 70)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF16> {
    private const val SIZE_V1: Int = 110

    private const val SIZE_V2: Int = 110

    public override val id: UInt = 180u

    public override val crcExtra: Byte = -34

    public override fun deserialize(source: BufferedSource): SerialUdbExtraF16 {
      val sueIdLeadPilot = source.decodeUInt8Array(40)
      val sueIdDiyDronesUrl = source.decodeUInt8Array(70)

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
