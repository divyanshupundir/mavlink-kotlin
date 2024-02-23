package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * Winch status.
 *
 * @param timeUsec Timestamp (synced to UNIX time or since system boot).
 * units = us
 * @param lineLength Length of line released. NaN if unknown
 * units = m
 * @param speed Speed line is being released or retracted. Positive values if being released,
 * negative values if being retracted, NaN if unknown
 * units = m/s
 * @param tension Tension on the line. NaN if unknown
 * units = kg
 * @param voltage Voltage of the battery supplying the winch. NaN if unknown
 * units = V
 * @param current Current draw from the winch. NaN if unknown
 * units = A
 * @param temperature Temperature of the motor. INT16_MAX if unknown
 * units = degC
 * @param status Status flags
 */
@GeneratedMavMessage(
  id = 9_005u,
  crcExtra = 117,
)
public data class WinchStatus(
  /**
   * Timestamp (synced to UNIX time or since system boot).
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Length of line released. NaN if unknown
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val lineLength: Float = 0F,
  /**
   * Speed line is being released or retracted. Positive values if being released, negative values
   * if being retracted, NaN if unknown
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val speed: Float = 0F,
  /**
   * Tension on the line. NaN if unknown
   * units = kg
   */
  @GeneratedMavField(type = "float")
  public val tension: Float = 0F,
  /**
   * Voltage of the battery supplying the winch. NaN if unknown
   * units = V
   */
  @GeneratedMavField(type = "float")
  public val voltage: Float = 0F,
  /**
   * Current draw from the winch. NaN if unknown
   * units = A
   */
  @GeneratedMavField(type = "float")
  public val current: Float = 0F,
  /**
   * Temperature of the motor. INT16_MAX if unknown
   * units = degC
   */
  @GeneratedMavField(type = "int16_t")
  public val temperature: Short = 0,
  /**
   * Status flags
   */
  @GeneratedMavField(type = "uint32_t")
  public val status: MavBitmaskValue<MavWinchStatusFlag> = MavBitmaskValue.fromValue(0u),
) : MavMessage<WinchStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<WinchStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(lineLength)
    encoder.encodeFloat(speed)
    encoder.encodeFloat(tension)
    encoder.encodeFloat(voltage)
    encoder.encodeFloat(current)
    encoder.encodeBitmaskValue(status.value, 4)
    encoder.encodeInt16(temperature)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(lineLength)
    encoder.encodeFloat(speed)
    encoder.encodeFloat(tension)
    encoder.encodeFloat(voltage)
    encoder.encodeFloat(current)
    encoder.encodeBitmaskValue(status.value, 4)
    encoder.encodeInt16(temperature)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<WinchStatus> {
    private const val SIZE_V1: Int = 34

    private const val SIZE_V2: Int = 34

    override val id: UInt = 9_005u

    override val crcExtra: Byte = 117

    override fun deserialize(bytes: ByteArray): WinchStatus {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val lineLength = decoder.safeDecodeFloat()
      val speed = decoder.safeDecodeFloat()
      val tension = decoder.safeDecodeFloat()
      val voltage = decoder.safeDecodeFloat()
      val current = decoder.safeDecodeFloat()
      val status = decoder.safeDecodeBitmaskValue(4).let { value ->
        val flags = MavWinchStatusFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val temperature = decoder.safeDecodeInt16()

      return WinchStatus(
        timeUsec = timeUsec,
        lineLength = lineLength,
        speed = speed,
        tension = tension,
        voltage = voltage,
        current = current,
        temperature = temperature,
        status = status,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): WinchStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var lineLength: Float = 0F

    public var speed: Float = 0F

    public var tension: Float = 0F

    public var voltage: Float = 0F

    public var current: Float = 0F

    public var temperature: Short = 0

    public var status: MavBitmaskValue<MavWinchStatusFlag> = MavBitmaskValue.fromValue(0u)

    public fun build(): WinchStatus = WinchStatus(
      timeUsec = timeUsec,
      lineLength = lineLength,
      speed = speed,
      tension = tension,
      voltage = voltage,
      current = current,
      temperature = temperature,
      status = status,
    )
  }
}
