package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeBitmaskValue(rfhealth.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeBitmaskValue(rfhealth.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<UavionixAdsbTransceiverHealthReport> {
    public override val id: UInt = 10_003u

    public override val crcExtra: Byte = 4

    public override fun deserialize(bytes: ByteArray): UavionixAdsbTransceiverHealthReport {
      val buffer = Buffer().write(bytes)

      val rfhealth = buffer.decodeBitmaskValue(1).let { value ->
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
