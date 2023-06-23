package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * The RAW pressure readings for the typical setup of one absolute pressure and one differential
 * pressure sensor. The sensor values should be the raw, UNSCALED ADC values.
 */
@GeneratedMavMessage(
  id = 28u,
  crcExtra = 67,
)
public data class RawPressure(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
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
  public override val instanceCompanion: MavMessage.MavCompanion<RawPressure> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeInt16(pressAbs)
    output.encodeInt16(pressDiff1)
    output.encodeInt16(pressDiff2)
    output.encodeInt16(temperature)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeInt16(pressAbs)
    output.encodeInt16(pressDiff1)
    output.encodeInt16(pressDiff2)
    output.encodeInt16(temperature)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<RawPressure> {
    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 16

    public override val id: UInt = 28u

    public override val crcExtra: Byte = 67

    public override fun deserialize(source: BufferedSource): RawPressure {
      val timeUsec = source.decodeUInt64()
      val pressAbs = source.decodeInt16()
      val pressDiff1 = source.decodeInt16()
      val pressDiff2 = source.decodeInt16()
      val temperature = source.decodeInt16()

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
