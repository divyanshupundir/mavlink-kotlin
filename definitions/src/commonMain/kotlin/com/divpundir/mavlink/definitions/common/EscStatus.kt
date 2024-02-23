package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeInt32Array
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeInt32Array
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List

/**
 * ESC information for higher rate streaming. Recommended streaming rate is ~10 Hz. Information that
 * changes more slowly is sent in ESC_INFO. It should typically only be streamed on high-bandwidth
 * links (i.e. to a companion computer).
 *
 * @param index Index of the first ESC in this message. minValue = 0, maxValue = 60, increment = 4.
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude the
 * number.
 * units = us
 * @param rpm Reported motor RPM from each ESC (negative for reverse rotation).
 * units = rpm
 * @param voltage Voltage measured from each ESC.
 * units = V
 * @param current Current measured from each ESC.
 * units = A
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
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Reported motor RPM from each ESC (negative for reverse rotation).
   * units = rpm
   */
  @GeneratedMavField(type = "int32_t[4]")
  public val rpm: List<Int> = emptyList(),
  /**
   * Voltage measured from each ESC.
   * units = V
   */
  @GeneratedMavField(type = "float[4]")
  public val voltage: List<Float> = emptyList(),
  /**
   * Current measured from each ESC.
   * units = A
   */
  @GeneratedMavField(type = "float[4]")
  public val current: List<Float> = emptyList(),
) : MavMessage<EscStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<EscStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeInt32Array(rpm, 16)
    encoder.encodeFloatArray(voltage, 16)
    encoder.encodeFloatArray(current, 16)
    encoder.encodeUInt8(index)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeInt32Array(rpm, 16)
    encoder.encodeFloatArray(voltage, 16)
    encoder.encodeFloatArray(current, 16)
    encoder.encodeUInt8(index)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<EscStatus> {
    private const val SIZE_V1: Int = 57

    private const val SIZE_V2: Int = 57

    override val id: UInt = 291u

    override val crcExtra: Byte = 10

    override fun deserialize(bytes: ByteArray): EscStatus {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val rpm = decoder.safeDecodeInt32Array(16)
      val voltage = decoder.safeDecodeFloatArray(16)
      val current = decoder.safeDecodeFloatArray(16)
      val index = decoder.safeDecodeUInt8()

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
