package xyz.urbanmatrix.mavlink.definitions.uavionix

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
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
  public val rfhealth: MavEnumValue<UavionixAdsbRfHealth> = MavEnumValue.fromValue(0),
) : MavMessage<UavionixAdsbTransceiverHealthReport> {
  public override val instanceMetadata: MavMessage.Metadata<UavionixAdsbTransceiverHealthReport> =
      METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(rfhealth.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(rfhealth.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 10003

    private const val CRC: Int = 4

    private const val SIZE: Int = 1

    private val DESERIALIZER: MavDeserializer<UavionixAdsbTransceiverHealthReport> =
        MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val rfhealth = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = UavionixAdsbRfHealth.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      UavionixAdsbTransceiverHealthReport(
        rfhealth = rfhealth,
      )
    }


    private val METADATA: MavMessage.Metadata<UavionixAdsbTransceiverHealthReport> =
        MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<UavionixAdsbTransceiverHealthReport> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var rfhealth: MavEnumValue<UavionixAdsbRfHealth> = MavEnumValue.fromValue(0)

    public fun build(): UavionixAdsbTransceiverHealthReport = UavionixAdsbTransceiverHealthReport(
      rfhealth = rfhealth,
    )
  }
}
