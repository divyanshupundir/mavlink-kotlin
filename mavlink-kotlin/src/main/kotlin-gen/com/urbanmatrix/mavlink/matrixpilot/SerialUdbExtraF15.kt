package com.urbanmatrix.mavlink.matrixpilot

import com.urbanmatrix.mavlink.api.MavDeserializationException
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
 * Backwards compatible version of SERIAL_UDB_EXTRA F15 format
 */
public data class SerialUdbExtraF15(
  /**
   * Serial UDB Extra Model Name Of Vehicle
   */
  public val sueIdVehicleModelName: List<Int> = emptyList(),
  /**
   * Serial UDB Extra Registraton Number of Vehicle
   */
  public val sueIdVehicleRegistration: List<Int> = emptyList(),
) : MavMessage<SerialUdbExtraF15> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF15> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8Array(sueIdVehicleModelName, 40)
    outputBuffer.encodeUint8Array(sueIdVehicleRegistration, 20)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 179

    private const val CRC: Int = 188

    private const val SIZE: Int = 60

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF15> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for SerialUdbExtraF15: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

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
  }
}
