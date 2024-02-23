package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeDoubleArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeDoubleArray
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Double
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List

/**
 * Cumulative distance traveled for each reported wheel.
 *
 * @param timeUsec Timestamp (synced to UNIX time or since system boot).
 * units = us
 * @param count Number of wheels reported.
 * @param distance Distance reported by individual wheel encoders. Forward rotations increase
 * values, reverse rotations decrease them. Not all wheels will necessarily have wheel encoders; the
 * mapping of encoders to wheel positions must be agreed/understood by the endpoints.
 * units = m
 */
@GeneratedMavMessage(
  id = 9_000u,
  crcExtra = 113,
)
public data class WheelDistance(
  /**
   * Timestamp (synced to UNIX time or since system boot).
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Number of wheels reported.
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: UByte = 0u,
  /**
   * Distance reported by individual wheel encoders. Forward rotations increase values, reverse
   * rotations decrease them. Not all wheels will necessarily have wheel encoders; the mapping of
   * encoders to wheel positions must be agreed/understood by the endpoints.
   * units = m
   */
  @GeneratedMavField(type = "double[16]")
  public val distance: List<Double> = emptyList(),
) : MavMessage<WheelDistance> {
  override val instanceCompanion: MavMessage.MavCompanion<WheelDistance> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeDoubleArray(distance, 128)
    encoder.encodeUInt8(count)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeDoubleArray(distance, 128)
    encoder.encodeUInt8(count)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<WheelDistance> {
    private const val SIZE_V1: Int = 137

    private const val SIZE_V2: Int = 137

    override val id: UInt = 9_000u

    override val crcExtra: Byte = 113

    override fun deserialize(bytes: ByteArray): WheelDistance {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val distance = decoder.safeDecodeDoubleArray(128)
      val count = decoder.safeDecodeUInt8()

      return WheelDistance(
        timeUsec = timeUsec,
        count = count,
        distance = distance,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): WheelDistance =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var count: UByte = 0u

    public var distance: List<Double> = emptyList()

    public fun build(): WheelDistance = WheelDistance(
      timeUsec = timeUsec,
      count = count,
      distance = distance,
    )
  }
}
