package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16Array
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint16Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array

/**
 * ESC Telemetry Data for ESCs 5 to 8, matching data sent by BLHeli ESCs.
 */
@GeneratedMavMessage(
  id = 11031,
  crc = 133,
)
public data class EscTelemetry5To8(
  /**
   * Temperature.
   */
  public val temperature: List<Int> = emptyList(),
  /**
   * Voltage.
   */
  public val voltage: List<Int> = emptyList(),
  /**
   * Current.
   */
  public val current: List<Int> = emptyList(),
  /**
   * Total current.
   */
  public val totalcurrent: List<Int> = emptyList(),
  /**
   * RPM (eRPM).
   */
  public val rpm: List<Int> = emptyList(),
  /**
   * count of telemetry packets received (wraps at 65535).
   */
  public val count: List<Int> = emptyList(),
) : MavMessage<EscTelemetry5To8> {
  public override val instanceMetadata: MavMessage.Metadata<EscTelemetry5To8> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16Array(voltage, 8)
    outputBuffer.encodeUint16Array(current, 8)
    outputBuffer.encodeUint16Array(totalcurrent, 8)
    outputBuffer.encodeUint16Array(rpm, 8)
    outputBuffer.encodeUint16Array(count, 8)
    outputBuffer.encodeUint8Array(temperature, 4)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 11031

    private const val CRC: Int = 133

    private const val SIZE: Int = 44

    private val DESERIALIZER: MavDeserializer<EscTelemetry5To8> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val voltage = inputBuffer.decodeUint16Array(8)
      val current = inputBuffer.decodeUint16Array(8)
      val totalcurrent = inputBuffer.decodeUint16Array(8)
      val rpm = inputBuffer.decodeUint16Array(8)
      val count = inputBuffer.decodeUint16Array(8)
      val temperature = inputBuffer.decodeUint8Array(4)

      EscTelemetry5To8(
        temperature = temperature,
        voltage = voltage,
        current = current,
        totalcurrent = totalcurrent,
        rpm = rpm,
        count = count,
      )
    }


    private val METADATA: MavMessage.Metadata<EscTelemetry5To8> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<EscTelemetry5To8> = METADATA
  }
}
