package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Transceiver heartbeat with health report (updated every 10s)
 */
@GeneratedMavMessage(
  id = 10_003u,
  crcExtra = 4,
)
public data class UavionixAdsbTransceiverHealthReport(
  /**
   * ADS-B transponder messages
   */
  @GeneratedMavField(type = "uint8_t")
  public val rfhealth: MavBitmaskValue<UavionixAdsbRfHealth> = MavBitmaskValue.fromValue(0u),
) : MavMessage<UavionixAdsbTransceiverHealthReport> {
  public override val instanceCompanion:
      MavMessage.MavCompanion<UavionixAdsbTransceiverHealthReport> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeBitmaskValue(rfhealth.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeBitmaskValue(rfhealth.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<UavionixAdsbTransceiverHealthReport> {
    private const val SIZE_V1: Int = 1

    private const val SIZE_V2: Int = 1

    public override val id: UInt = 10_003u

    public override val crcExtra: Byte = 4

    public override fun deserialize(source: BufferedSource): UavionixAdsbTransceiverHealthReport {
      val rfhealth = source.decodeBitmaskValue(1).let { value ->
        val flags = UavionixAdsbRfHealth.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      return UavionixAdsbTransceiverHealthReport(
        rfhealth = rfhealth,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit):
        UavionixAdsbTransceiverHealthReport = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var rfhealth: MavBitmaskValue<UavionixAdsbRfHealth> = MavBitmaskValue.fromValue(0u)

    public fun build(): UavionixAdsbTransceiverHealthReport = UavionixAdsbTransceiverHealthReport(
      rfhealth = rfhealth,
    )
  }
}
