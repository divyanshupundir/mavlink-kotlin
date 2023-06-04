package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * Vehicle status report that is sent out while orbit execution is in progress (see
 * MAV_CMD_DO_ORBIT).
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 360u,
  crcExtra = 11,
)
public data class OrbitExecutionStatus(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Radius of the orbit circle. Positive values orbit clockwise, negative values orbit
   * counter-clockwise.
   */
  @GeneratedMavField(type = "float")
  public val radius: Float = 0F,
  /**
   * The coordinate system of the fields: x, y, z.
   */
  @GeneratedMavField(type = "uint8_t")
  public val frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u),
  /**
   * X coordinate of center point. Coordinate system depends on frame field: local = x position in
   * meters * 1e4, global = latitude in degrees * 1e7.
   */
  @GeneratedMavField(type = "int32_t")
  public val x: Int = 0,
  /**
   * Y coordinate of center point.  Coordinate system depends on frame field: local = x position in
   * meters * 1e4, global = latitude in degrees * 1e7.
   */
  @GeneratedMavField(type = "int32_t")
  public val y: Int = 0,
  /**
   * Altitude of center point. Coordinate system depends on frame field.
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
) : MavMessage<OrbitExecutionStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<OrbitExecutionStatus> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(radius)
    outputBuffer.encodeInt32(x)
    outputBuffer.encodeInt32(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeEnumValue(frame.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(radius)
    outputBuffer.encodeInt32(x)
    outputBuffer.encodeInt32(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeEnumValue(frame.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OrbitExecutionStatus> {
    private const val SIZE_V1: Int = 25

    private const val SIZE_V2: Int = 25

    public override val id: UInt = 360u

    public override val crcExtra: Byte = 11

    public override fun deserialize(bytes: ByteArray): OrbitExecutionStatus {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val radius = inputBuffer.decodeFloat()
      val x = inputBuffer.decodeInt32()
      val y = inputBuffer.decodeInt32()
      val z = inputBuffer.decodeFloat()
      val frame = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return OrbitExecutionStatus(
        timeUsec = timeUsec,
        radius = radius,
        frame = frame,
        x = x,
        y = y,
        z = z,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): OrbitExecutionStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var radius: Float = 0F

    public var frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u)

    public var x: Int = 0

    public var y: Int = 0

    public var z: Float = 0F

    public fun build(): OrbitExecutionStatus = OrbitExecutionStatus(
      timeUsec = timeUsec,
      radius = radius,
      frame = frame,
      x = x,
      y = y,
      z = z,
    )
  }
}
