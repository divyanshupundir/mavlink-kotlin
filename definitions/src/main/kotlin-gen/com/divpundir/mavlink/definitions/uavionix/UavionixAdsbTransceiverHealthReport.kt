package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Transceiver heartbeat with health report (updated every 10s)
 */
@GeneratedMavMessage(
  id = 10003u,
  crcExtra = 4,
)
public data class UavionixAdsbTransceiverHealthReport(
  /**
   * ADS-B transponder messages
   */
  @GeneratedMavField(type = "uint8_t")
  public val rfhealth: MavBitmaskValue<UavionixAdsbRfHealth> = MavBitmaskValue.fromValue(0u),
) : MavMessage<UavionixAdsbTransceiverHealthReport> {
  public override val instanceMetadata: MavMessage.Metadata<UavionixAdsbTransceiverHealthReport> =
      METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeBitmaskValue(rfhealth.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeBitmaskValue(rfhealth.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 10003u

    private const val CRC_EXTRA: Byte = 4

    private const val SIZE_V1: Int = 1

    private const val SIZE_V2: Int = 1

    private val DESERIALIZER: MavDeserializer<UavionixAdsbTransceiverHealthReport> =
        MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val rfhealth = inputBuffer.decodeBitmaskValue(1).let { value ->
        val flags = UavionixAdsbRfHealth.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      UavionixAdsbTransceiverHealthReport(
        rfhealth = rfhealth,
      )
    }


    private val METADATA: MavMessage.Metadata<UavionixAdsbTransceiverHealthReport> =
        MavMessage.Metadata(ID, CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<UavionixAdsbTransceiverHealthReport> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): UavionixAdsbTransceiverHealthReport =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var rfhealth: MavBitmaskValue<UavionixAdsbRfHealth> = MavBitmaskValue.fromValue(0u)

    public fun build(): UavionixAdsbTransceiverHealthReport = UavionixAdsbTransceiverHealthReport(
      rfhealth = rfhealth,
    )
  }
}
