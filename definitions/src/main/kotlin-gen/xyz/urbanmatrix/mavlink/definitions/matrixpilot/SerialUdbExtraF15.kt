package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F15 format
 */
@GeneratedMavMessage(
  id = 179,
  crc = 7,
)
public data class SerialUdbExtraF15(
  /**
   * Serial UDB Extra Model Name Of Vehicle
   */
  @GeneratedMavField(type = "uint8_t[40]")
  public val sueIdVehicleModelName: List<Int> = emptyList(),
  /**
   * Serial UDB Extra Registraton Number of Vehicle
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val sueIdVehicleRegistration: List<Int> = emptyList(),
) : MavMessage<SerialUdbExtraF15> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF15> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8Array(sueIdVehicleModelName, 40)
    outputBuffer.encodeUint8Array(sueIdVehicleRegistration, 20)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8Array(sueIdVehicleModelName, 40)
    outputBuffer.encodeUint8Array(sueIdVehicleRegistration, 20)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 179

    private const val CRC: Int = 7

    private const val SIZE: Int = 60

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF15> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueIdVehicleModelName = inputBuffer.decodeUint8Array(40)
      val sueIdVehicleRegistration = inputBuffer.decodeUint8Array(20)

      SerialUdbExtraF15(
        sueIdVehicleModelName = sueIdVehicleModelName,
        sueIdVehicleRegistration = sueIdVehicleRegistration,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF15> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF15> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueIdVehicleModelName: List<Int> = emptyList()

    public var sueIdVehicleRegistration: List<Int> = emptyList()

    public fun build(): SerialUdbExtraF15 = SerialUdbExtraF15(
      sueIdVehicleModelName = sueIdVehicleModelName,
      sueIdVehicleRegistration = sueIdVehicleRegistration,
    )
  }
}
