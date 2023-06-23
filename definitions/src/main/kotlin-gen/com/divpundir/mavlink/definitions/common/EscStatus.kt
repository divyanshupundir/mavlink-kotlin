package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeInt32Array
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeInt32Array
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * ESC information for higher rate streaming. Recommended streaming rate is ~10 Hz. Information that
 * changes more slowly is sent in ESC_INFO. It should typically only be streamed on high-bandwidth
 * links (i.e. to a companion computer).
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 291u,
  crcExtra = 10,
)
public data class EscStatus(
  /**
   * Index of the first ESC in this message. minValue = 0, maxValue = 60, increment = 4.
   */
  @GeneratedMavField(type = "uint8_t")
  public val index: UByte = 0u,
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Reported motor RPM from each ESC (negative for reverse rotation).
   */
  @GeneratedMavField(type = "int32_t[4]")
  public val rpm: List<Int> = emptyList(),
  /**
   * Voltage measured from each ESC.
   */
  @GeneratedMavField(type = "float[4]")
  public val voltage: List<Float> = emptyList(),
  /**
   * Current measured from each ESC.
   */
  @GeneratedMavField(type = "float[4]")
  public val current: List<Float> = emptyList(),
) : MavMessage<EscStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<EscStatus> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeInt32Array(rpm, 16)
    output.encodeFloatArray(voltage, 16)
    output.encodeFloatArray(current, 16)
    output.encodeUInt8(index)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeInt32Array(rpm, 16)
    output.encodeFloatArray(voltage, 16)
    output.encodeFloatArray(current, 16)
    output.encodeUInt8(index)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<EscStatus> {
    private const val SIZE_V1: Int = 57

    private const val SIZE_V2: Int = 57

    public override val id: UInt = 291u

    public override val crcExtra: Byte = 10

    public override fun deserialize(source: BufferedSource): EscStatus {
      val timeUsec = source.decodeUInt64()
      val rpm = source.decodeInt32Array(16)
      val voltage = source.decodeFloatArray(16)
      val current = source.decodeFloatArray(16)
      val index = source.decodeUInt8()

      return EscStatus(
        index = index,
        timeUsec = timeUsec,
        rpm = rpm,
        voltage = voltage,
        current = current,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): EscStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var index: UByte = 0u

    public var timeUsec: ULong = 0uL

    public var rpm: List<Int> = emptyList()

    public var voltage: List<Float> = emptyList()

    public var current: List<Float> = emptyList()

    public fun build(): EscStatus = EscStatus(
      index = index,
      timeUsec = timeUsec,
      rpm = rpm,
      voltage = voltage,
      current = current,
    )
  }
}
