package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16Array
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt16Array
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * ESC Telemetry Data for ESCs 1 to 4, matching data sent by BLHeli ESCs.
 *
 */
@GeneratedMavMessage(
  id = 11_030u,
  crcExtra = -112,
)
public data class EscTelemetry1To4(
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
) : MavMessage<EscTelemetry1To4> {
  override val instanceCompanion: MavMessage.MavCompanion<EscTelemetry1To4> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16Array(voltage, 8)
    encoder.encodeUInt16Array(current, 8)
    encoder.encodeUInt16Array(totalcurrent, 8)
    encoder.encodeUInt16Array(rpm, 8)
    encoder.encodeUInt16Array(count, 8)
    encoder.encodeUInt8Array(temperature, 4)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16Array(voltage, 8)
    encoder.encodeUInt16Array(current, 8)
    encoder.encodeUInt16Array(totalcurrent, 8)
    encoder.encodeUInt16Array(rpm, 8)
    encoder.encodeUInt16Array(count, 8)
    encoder.encodeUInt8Array(temperature, 4)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<EscTelemetry1To4> {
    private const val SIZE_V1: Int = 44

    private const val SIZE_V2: Int = 44

    override val id: UInt = 11_030u

    override val crcExtra: Byte = -112

    override fun deserialize(bytes: ByteArray): EscTelemetry1To4 {
      val decoder = MavDataDecoder(bytes)

      val voltage = decoder.safeDecodeUInt16Array(8)
      val current = decoder.safeDecodeUInt16Array(8)
      val totalcurrent = decoder.safeDecodeUInt16Array(8)
      val rpm = decoder.safeDecodeUInt16Array(8)
      val count = decoder.safeDecodeUInt16Array(8)
      val temperature = decoder.safeDecodeUInt8Array(4)

      return EscTelemetry1To4(
        temperature = temperature,
        voltage = voltage,
        current = current,
        totalcurrent = totalcurrent,
        rpm = rpm,
        count = count,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): EscTelemetry1To4 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var temperature: List<UByte> = emptyList()

    public var voltage: List<UShort> = emptyList()

    public var current: List<UShort> = emptyList()

    public var totalcurrent: List<UShort> = emptyList()

    public var rpm: List<UShort> = emptyList()

    public var count: List<UShort> = emptyList()

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
