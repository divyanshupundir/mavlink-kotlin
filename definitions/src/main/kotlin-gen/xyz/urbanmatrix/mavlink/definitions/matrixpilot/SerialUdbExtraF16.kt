package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF16> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8Array(sueIdLeadPilot, 40)
    outputBuffer.encodeUInt8Array(sueIdDiyDronesUrl, 70)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8Array(sueIdLeadPilot, 40)
    outputBuffer.encodeUInt8Array(sueIdDiyDronesUrl, 70)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 180u

    private const val CRC_EXTRA: Byte = -34

    private const val SIZE_V1: Int = 110

    private const val SIZE_V2: Int = 110

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF16> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueIdLeadPilot = inputBuffer.decodeUInt8Array(40)
      val sueIdDiyDronesUrl = inputBuffer.decodeUInt8Array(70)

      SerialUdbExtraF16(
        sueIdLeadPilot = sueIdLeadPilot,
        sueIdDiyDronesUrl = sueIdDiyDronesUrl,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF16> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF16> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SerialUdbExtraF16 =
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
