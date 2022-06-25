package com.urbanmatrix.mavlink.uavionix

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.uAvionix.UavionixAdsbRfHealth
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Transceiver heartbeat with health report (updated every 10s)
 */
public data class UavionixAdsbTransceiverHealthReport(
  /**
   * ADS-B transponder messages
   */
  public val rfhealth: MavEnumValue<UavionixAdsbRfHealth> = MavEnumValue.fromValue(0),
) : MavMessage<UavionixAdsbTransceiverHealthReport> {
  public override val instanceMetadata: MavMessage.Metadata<UavionixAdsbTransceiverHealthReport> =
      METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(rfhealth.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 10003

    private const val CRC: Int = 4

    private val DESERIALIZER: MavDeserializer<UavionixAdsbTransceiverHealthReport> = MavDeserializer
        { bytes ->
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
  }
}
