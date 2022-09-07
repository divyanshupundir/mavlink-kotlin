package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F16 format
 */
@GeneratedMavMessage(
  id = 180,
  crc = 222,
)
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
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8Array(sueIdLeadPilot, 40)
    outputBuffer.encodeUint8Array(sueIdDiyDronesUrl, 70)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 180

    private const val CRC: Int = 222

    private const val SIZE: Int = 110

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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueIdLeadPilot: List<Int> = emptyList()

    public var sueIdDiyDronesUrl: List<Int> = emptyList()

    public fun build(): SerialUdbExtraF16 = SerialUdbExtraF16(
      sueIdLeadPilot = sueIdLeadPilot,
      sueIdDiyDronesUrl = sueIdDiyDronesUrl,
    )
  }
}
