package xyz.urbanmatrix.mavlink.definitions.uavionix

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavBitmaskValue
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.encodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Transceiver heartbeat with health report (updated every 10s)
 */
@GeneratedMavMessage(
  id = 10003,
  crc = 4,
)
public data class UavionixAdsbTransceiverHealthReport(
  /**
   * ADS-B transponder messages
   */
  @GeneratedMavField(type = "uint8_t")
  public val rfhealth: MavBitmaskValue<UavionixAdsbRfHealth> = MavBitmaskValue.fromValue(0),
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
    private const val ID: Int = 10003

    private const val CRC: Int = 4

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
        MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<UavionixAdsbTransceiverHealthReport> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): UavionixAdsbTransceiverHealthReport =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var rfhealth: MavBitmaskValue<UavionixAdsbRfHealth> = MavBitmaskValue.fromValue(0)

    public fun build(): UavionixAdsbTransceiverHealthReport = UavionixAdsbTransceiverHealthReport(
      rfhealth = rfhealth,
    )
  }
}
