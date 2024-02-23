package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * The RAW pressure readings for the typical setup of one absolute pressure and one differential
 * pressure sensor. The sensor values should be the raw, UNSCALED ADC values.
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param pressAbs Absolute pressure (raw)
 * @param pressDiff1 Differential pressure 1 (raw, 0 if nonexistent)
 * @param pressDiff2 Differential pressure 2 (raw, 0 if nonexistent)
 * @param temperature Raw Temperature measurement (raw)
 */
@GeneratedMavMessage(
  id = 28u,
  crcExtra = 67,
)
public data class RawPressure(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Absolute pressure (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val pressAbs: Short = 0,
  /**
   * Differential pressure 1 (raw, 0 if nonexistent)
   */
  @GeneratedMavField(type = "int16_t")
  public val pressDiff1: Short = 0,
  /**
   * Differential pressure 2 (raw, 0 if nonexistent)
   */
  @GeneratedMavField(type = "int16_t")
  public val pressDiff2: Short = 0,
  /**
   * Raw Temperature measurement (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val temperature: Short = 0,
) : MavMessage<RawPressure> {
  override val instanceCompanion: MavMessage.MavCompanion<RawPressure> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeInt16(pressAbs)
    encoder.encodeInt16(pressDiff1)
    encoder.encodeInt16(pressDiff2)
    encoder.encodeInt16(temperature)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeInt16(pressAbs)
    encoder.encodeInt16(pressDiff1)
    encoder.encodeInt16(pressDiff2)
    encoder.encodeInt16(temperature)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RawPressure> {
    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 16

    override val id: UInt = 28u

    override val crcExtra: Byte = 67

    override fun deserialize(bytes: ByteArray): RawPressure {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val pressAbs = decoder.safeDecodeInt16()
      val pressDiff1 = decoder.safeDecodeInt16()
      val pressDiff2 = decoder.safeDecodeInt16()
      val temperature = decoder.safeDecodeInt16()

      return RawPressure(
        timeUsec = timeUsec,
        pressAbs = pressAbs,
        pressDiff1 = pressDiff1,
        pressDiff2 = pressDiff2,
        temperature = temperature,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): RawPressure =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var pressAbs: Short = 0

    public var pressDiff1: Short = 0

    public var pressDiff2: Short = 0

    public var temperature: Short = 0

    public fun build(): RawPressure = RawPressure(
      timeUsec = timeUsec,
      pressAbs = pressAbs,
      pressDiff1 = pressDiff1,
      pressDiff2 = pressDiff2,
      temperature = temperature,
    )
  }
}
