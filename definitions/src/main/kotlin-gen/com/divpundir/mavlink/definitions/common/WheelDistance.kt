package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeDoubleArray
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeDoubleArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
 */
@GeneratedMavMessage(
  id = 9_000u,
  crcExtra = 113,
)
public data class WheelDistance(
  /**
   * Timestamp (synced to UNIX time or since system boot).
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
   */
  @GeneratedMavField(type = "double[16]")
  public val distance: List<Double> = emptyList(),
) : MavMessage<WheelDistance> {
  public override val instanceCompanion: MavMessage.MavCompanion<WheelDistance> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeDoubleArray(distance, 128)
    outputBuffer.encodeUInt8(count)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeDoubleArray(distance, 128)
    outputBuffer.encodeUInt8(count)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<WheelDistance> {
    private const val SIZE_V1: Int = 137

    private const val SIZE_V2: Int = 137

    public override val id: UInt = 9_000u

    public override val crcExtra: Byte = 113

    public override fun deserialize(bytes: ByteArray): WheelDistance {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val distance = inputBuffer.decodeDoubleArray(128)
      val count = inputBuffer.decodeUInt8()

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
