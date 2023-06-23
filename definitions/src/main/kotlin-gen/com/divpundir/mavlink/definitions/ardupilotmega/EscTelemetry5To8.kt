package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16Array
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt16Array
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

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
  public override val instanceCompanion: MavMessage.MavCompanion<EscTelemetry5To8> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16Array(voltage, 8)
    output.encodeUInt16Array(current, 8)
    output.encodeUInt16Array(totalcurrent, 8)
    output.encodeUInt16Array(rpm, 8)
    output.encodeUInt16Array(count, 8)
    output.encodeUInt8Array(temperature, 4)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16Array(voltage, 8)
    output.encodeUInt16Array(current, 8)
    output.encodeUInt16Array(totalcurrent, 8)
    output.encodeUInt16Array(rpm, 8)
    output.encodeUInt16Array(count, 8)
    output.encodeUInt8Array(temperature, 4)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<EscTelemetry5To8> {
    private const val SIZE_V1: Int = 44

    private const val SIZE_V2: Int = 44

    public override val id: UInt = 11_031u

    public override val crcExtra: Byte = -123

    public override fun deserialize(source: BufferedSource): EscTelemetry5To8 {
      val voltage = source.decodeUInt16Array(8)
      val current = source.decodeUInt16Array(8)
      val totalcurrent = source.decodeUInt16Array(8)
      val rpm = source.decodeUInt16Array(8)
      val count = source.decodeUInt16Array(8)
      val temperature = source.decodeUInt8Array(4)

      return EscTelemetry5To8(
        temperature = temperature,
        voltage = voltage,
        current = current,
        totalcurrent = totalcurrent,
        rpm = rpm,
        count = count,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): EscTelemetry5To8 =
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
