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
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer

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
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloat(radius)
    buffer.encodeInt32(x)
    buffer.encodeInt32(y)
    buffer.encodeFloat(z)
    buffer.encodeEnumValue(frame.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloat(radius)
    buffer.encodeInt32(x)
    buffer.encodeInt32(y)
    buffer.encodeFloat(z)
    buffer.encodeEnumValue(frame.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OrbitExecutionStatus> {
    public override val id: UInt = 360u

    public override val crcExtra: Byte = 11

    public override fun deserialize(bytes: ByteArray): OrbitExecutionStatus {
      val buffer = Buffer().write(bytes)

      val timeUsec = buffer.decodeUInt64()
      val radius = buffer.decodeFloat()
      val x = buffer.decodeInt32()
      val y = buffer.decodeInt32()
      val z = buffer.decodeFloat()
      val frame = buffer.decodeEnumValue(1).let { value ->
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
