package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
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
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param radius Radius of the orbit circle. Positive values orbit clockwise, negative values orbit
 * counter-clockwise.
 * units = m
 * @param frame The coordinate system of the fields: x, y, z.
 * @param x X coordinate of center point. Coordinate system depends on frame field: local = x
 * position in meters * 1e4, global = latitude in degrees * 1e7.
 * @param y Y coordinate of center point.  Coordinate system depends on frame field: local = x
 * position in meters * 1e4, global = latitude in degrees * 1e7.
 * @param z Altitude of center point. Coordinate system depends on frame field.
 * units = m
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
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Radius of the orbit circle. Positive values orbit clockwise, negative values orbit
   * counter-clockwise.
   * units = m
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
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
) : MavMessage<OrbitExecutionStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<OrbitExecutionStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(radius)
    encoder.encodeInt32(x)
    encoder.encodeInt32(y)
    encoder.encodeFloat(z)
    encoder.encodeEnumValue(frame.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(radius)
    encoder.encodeInt32(x)
    encoder.encodeInt32(y)
    encoder.encodeFloat(z)
    encoder.encodeEnumValue(frame.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OrbitExecutionStatus> {
    private const val SIZE_V1: Int = 25

    private const val SIZE_V2: Int = 25

    override val id: UInt = 360u

    override val crcExtra: Byte = 11

    override fun deserialize(bytes: ByteArray): OrbitExecutionStatus {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val radius = decoder.safeDecodeFloat()
      val x = decoder.safeDecodeInt32()
      val y = decoder.safeDecodeInt32()
      val z = decoder.safeDecodeFloat()
      val frame = decoder.safeDecodeEnumValue(1).let { value ->
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
