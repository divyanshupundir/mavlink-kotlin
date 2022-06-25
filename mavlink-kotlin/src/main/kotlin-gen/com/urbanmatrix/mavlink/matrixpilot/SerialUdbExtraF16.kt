package com.urbanmatrix.mavlink.matrixpilot

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F16 format
 */
public data class SerialUdbExtraF16(
  /**
   * Serial UDB Extra Name of Expected Lead Pilot
   */
  public val sueIdLeadPilot: List<Int> = emptyList(),
  /**
   * Serial UDB Extra URL of Lead Pilot or Team
   */
  public val sueIdDiyDronesUrl: List<Int> = emptyList(),
) : MavMessage<SerialUdbExtraF16> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF16> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(110).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8Array(sueIdLeadPilot, 40)
    outputBuffer.encodeUint8Array(sueIdDiyDronesUrl, 70)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 180

    private const val CRC: Int = 9

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF16> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueIdLeadPilot = inputBuffer.decodeUint8Array(40)
      val sueIdDiyDronesUrl = inputBuffer.decodeUint8Array(70)
      SerialUdbExtraF16(
        sueIdLeadPilot = sueIdLeadPilot,
        sueIdDiyDronesUrl = sueIdDiyDronesUrl,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF16> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF16> = METADATA
  }
}
