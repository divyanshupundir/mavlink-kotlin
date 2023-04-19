package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F15 format
 */
@GeneratedMavMessage(
  id = 179u,
  crcExtra = 7,
)
public data class SerialUdbExtraF15(
  /**
   * Serial UDB Extra Model Name Of Vehicle
   */
  @GeneratedMavField(type = "uint8_t[40]")
  public val sueIdVehicleModelName: List<UByte> = emptyList(),
  /**
   * Serial UDB Extra Registraton Number of Vehicle
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val sueIdVehicleRegistration: List<UByte> = emptyList(),
) : MavMessage<SerialUdbExtraF15> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF15> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8Array(sueIdVehicleModelName, 40)
    outputBuffer.encodeUInt8Array(sueIdVehicleRegistration, 20)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8Array(sueIdVehicleModelName, 40)
    outputBuffer.encodeUInt8Array(sueIdVehicleRegistration, 20)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 179u

    private const val CRC_EXTRA: Byte = 7

    private const val SIZE_V1: Int = 60

    private const val SIZE_V2: Int = 60

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF15> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueIdVehicleModelName = inputBuffer.decodeUInt8Array(40)
      val sueIdVehicleRegistration = inputBuffer.decodeUInt8Array(20)

      SerialUdbExtraF15(
        sueIdVehicleModelName = sueIdVehicleModelName,
        sueIdVehicleRegistration = sueIdVehicleRegistration,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF15> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF15> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SerialUdbExtraF15 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueIdVehicleModelName: List<UByte> = emptyList()

    public var sueIdVehicleRegistration: List<UByte> = emptyList()

    public fun build(): SerialUdbExtraF15 = SerialUdbExtraF15(
      sueIdVehicleModelName = sueIdVehicleModelName,
      sueIdVehicleRegistration = sueIdVehicleRegistration,
    )
  }
}