package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

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
import xyz.urbanmatrix.mavlink.serialization.decodeUint16Array
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint16Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * ESC Telemetry Data for ESCs 1 to 4, matching data sent by BLHeli ESCs.
 */
@GeneratedMavMessage(
  id = 11030,
  crc = 144,
)
public data class EscTelemetry1To4(
  /**
   * Temperature.
   */
  @GeneratedMavField(type = "uint8_t[4]")
  public val temperature: List<Int> = emptyList(),
  /**
   * Voltage.
   */
  @GeneratedMavField(type = "uint16_t[4]")
  public val voltage: List<Int> = emptyList(),
  /**
   * Current.
   */
  @GeneratedMavField(type = "uint16_t[4]")
  public val current: List<Int> = emptyList(),
  /**
   * Total current.
   */
  @GeneratedMavField(type = "uint16_t[4]")
  public val totalcurrent: List<Int> = emptyList(),
  /**
   * RPM (eRPM).
   */
  @GeneratedMavField(type = "uint16_t[4]")
  public val rpm: List<Int> = emptyList(),
  /**
   * count of telemetry packets received (wraps at 65535).
   */
  @GeneratedMavField(type = "uint16_t[4]")
  public val count: List<Int> = emptyList(),
) : MavMessage<EscTelemetry1To4> {
  public override val instanceMetadata: MavMessage.Metadata<EscTelemetry1To4> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16Array(voltage, 8)
    outputBuffer.encodeUint16Array(current, 8)
    outputBuffer.encodeUint16Array(totalcurrent, 8)
    outputBuffer.encodeUint16Array(rpm, 8)
    outputBuffer.encodeUint16Array(count, 8)
    outputBuffer.encodeUint8Array(temperature, 4)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16Array(voltage, 8)
    outputBuffer.encodeUint16Array(current, 8)
    outputBuffer.encodeUint16Array(totalcurrent, 8)
    outputBuffer.encodeUint16Array(rpm, 8)
    outputBuffer.encodeUint16Array(count, 8)
    outputBuffer.encodeUint8Array(temperature, 4)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 11030

    private const val CRC: Int = 144

    private const val SIZE_V1: Int = 44

    private const val SIZE_V2: Int = 44

    private val DESERIALIZER: MavDeserializer<EscTelemetry1To4> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val voltage = inputBuffer.decodeUint16Array(8)
      val current = inputBuffer.decodeUint16Array(8)
      val totalcurrent = inputBuffer.decodeUint16Array(8)
      val rpm = inputBuffer.decodeUint16Array(8)
      val count = inputBuffer.decodeUint16Array(8)
      val temperature = inputBuffer.decodeUint8Array(4)

      EscTelemetry1To4(
        temperature = temperature,
        voltage = voltage,
        current = current,
        totalcurrent = totalcurrent,
        rpm = rpm,
        count = count,
      )
    }


    private val METADATA: MavMessage.Metadata<EscTelemetry1To4> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<EscTelemetry1To4> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var temperature: List<Int> = emptyList()

    public var voltage: List<Int> = emptyList()

    public var current: List<Int> = emptyList()

    public var totalcurrent: List<Int> = emptyList()

    public var rpm: List<Int> = emptyList()

    public var count: List<Int> = emptyList()

    public fun build(): EscTelemetry1To4 = EscTelemetry1To4(
      temperature = temperature,
      voltage = voltage,
      current = current,
      totalcurrent = totalcurrent,
      rpm = rpm,
      count = count,
    )
  }
}
