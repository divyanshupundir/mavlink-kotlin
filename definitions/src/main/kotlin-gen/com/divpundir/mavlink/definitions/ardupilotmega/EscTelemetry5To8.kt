package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16Array
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt16Array
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * ESC Telemetry Data for ESCs 5 to 8, matching data sent by BLHeli ESCs.
 */
@GeneratedMavMessage(
  id = 11_031u,
  crcExtra = -123,
)
public data class EscTelemetry5To8(
  /**
   * Temperature.
   */
  @GeneratedMavField(type = "uint8_t[4]")
  public val temperature: List<UByte> = emptyList(),
  /**
   * Voltage.
   */
  @GeneratedMavField(type = "uint16_t[4]")
  public val voltage: List<UShort> = emptyList(),
  /**
   * Current.
   */
  @GeneratedMavField(type = "uint16_t[4]")
  public val current: List<UShort> = emptyList(),
  /**
   * Total current.
   */
  @GeneratedMavField(type = "uint16_t[4]")
  public val totalcurrent: List<UShort> = emptyList(),
  /**
   * RPM (eRPM).
   */
  @GeneratedMavField(type = "uint16_t[4]")
  public val rpm: List<UShort> = emptyList(),
  /**
   * count of telemetry packets received (wraps at 65535).
   */
  @GeneratedMavField(type = "uint16_t[4]")
  public val count: List<UShort> = emptyList(),
) : MavMessage<EscTelemetry5To8> {
  public override val instanceMetadata: MavMessage.Metadata<EscTelemetry5To8> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16Array(voltage, 8)
    outputBuffer.encodeUInt16Array(current, 8)
    outputBuffer.encodeUInt16Array(totalcurrent, 8)
    outputBuffer.encodeUInt16Array(rpm, 8)
    outputBuffer.encodeUInt16Array(count, 8)
    outputBuffer.encodeUInt8Array(temperature, 4)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16Array(voltage, 8)
    outputBuffer.encodeUInt16Array(current, 8)
    outputBuffer.encodeUInt16Array(totalcurrent, 8)
    outputBuffer.encodeUInt16Array(rpm, 8)
    outputBuffer.encodeUInt16Array(count, 8)
    outputBuffer.encodeUInt8Array(temperature, 4)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 11_031u

    private const val CRC_EXTRA: Byte = -123

    private const val SIZE_V1: Int = 44

    private const val SIZE_V2: Int = 44

    private val DESERIALIZER: MavDeserializer<EscTelemetry5To8> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val voltage = inputBuffer.decodeUInt16Array(8)
      val current = inputBuffer.decodeUInt16Array(8)
      val totalcurrent = inputBuffer.decodeUInt16Array(8)
      val rpm = inputBuffer.decodeUInt16Array(8)
      val count = inputBuffer.decodeUInt16Array(8)
      val temperature = inputBuffer.decodeUInt8Array(4)

      EscTelemetry5To8(
        temperature = temperature,
        voltage = voltage,
        current = current,
        totalcurrent = totalcurrent,
        rpm = rpm,
        count = count,
      )
    }


    private val METADATA: MavMessage.Metadata<EscTelemetry5To8> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<EscTelemetry5To8> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): EscTelemetry5To8 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var temperature: List<UByte> = emptyList()

    public var voltage: List<UShort> = emptyList()

    public var current: List<UShort> = emptyList()

    public var totalcurrent: List<UShort> = emptyList()

    public var rpm: List<UShort> = emptyList()

    public var count: List<UShort> = emptyList()

    public fun build(): EscTelemetry5To8 = EscTelemetry5To8(
      temperature = temperature,
      voltage = voltage,
      current = current,
      totalcurrent = totalcurrent,
      rpm = rpm,
      count = count,
    )
  }
}
