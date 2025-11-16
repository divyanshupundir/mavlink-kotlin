package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
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
 *
 *         Vehicle status report that is sent out while figure eight execution is in progress (see
 * MAV_CMD_DO_FIGURE_EIGHT).
 *         This may typically send at low rates: of the order of 2Hz.
 *       
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param majorRadius Major axis radius of the figure eight. Positive: orbit the north circle
 * clockwise. Negative: orbit the north circle counter-clockwise.
 * units = m
 * @param minorRadius Minor axis radius of the figure eight. Defines the radius of two circles that
 * make up the figure.
 * units = m
 * @param orientation Orientation of the figure eight major axis with respect to true north in
 * [-pi,pi).
 * units = rad
 * @param frame The coordinate system of the fields: x, y, z.
 * @param x X coordinate of center point. Coordinate system depends on frame field.
 * @param y Y coordinate of center point. Coordinate system depends on frame field.
 * @param z Altitude of center point. Coordinate system depends on frame field.
 * units = m
 */
@GeneratedMavMessage(
  id = 361u,
  crcExtra = 93,
)
public data class FigureEightExecutionStatus(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Major axis radius of the figure eight. Positive: orbit the north circle clockwise. Negative:
   * orbit the north circle counter-clockwise.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val majorRadius: Float = 0F,
  /**
   * Minor axis radius of the figure eight. Defines the radius of two circles that make up the
   * figure.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val minorRadius: Float = 0F,
  /**
   * Orientation of the figure eight major axis with respect to true north in [-pi,pi).
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val orientation: Float = 0F,
  /**
   * The coordinate system of the fields: x, y, z.
   */
  @GeneratedMavField(type = "uint8_t")
  public val frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u),
  /**
   * X coordinate of center point. Coordinate system depends on frame field.
   */
  @GeneratedMavField(type = "int32_t")
  public val x: Int = 0,
  /**
   * Y coordinate of center point. Coordinate system depends on frame field.
   */
  @GeneratedMavField(type = "int32_t")
  public val y: Int = 0,
  /**
   * Altitude of center point. Coordinate system depends on frame field.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
) : MavMessage<FigureEightExecutionStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<FigureEightExecutionStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(majorRadius)
    encoder.encodeFloat(minorRadius)
    encoder.encodeFloat(orientation)
    encoder.encodeInt32(x)
    encoder.encodeInt32(y)
    encoder.encodeFloat(z)
    encoder.encodeEnumValue(frame.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(majorRadius)
    encoder.encodeFloat(minorRadius)
    encoder.encodeFloat(orientation)
    encoder.encodeInt32(x)
    encoder.encodeInt32(y)
    encoder.encodeFloat(z)
    encoder.encodeEnumValue(frame.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FigureEightExecutionStatus> {
    private const val SIZE_V1: Int = 33

    private const val SIZE_V2: Int = 33

    override val id: UInt = 361u

    override val crcExtra: Byte = 93

    override fun deserialize(bytes: ByteArray): FigureEightExecutionStatus {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val majorRadius = decoder.safeDecodeFloat()
      val minorRadius = decoder.safeDecodeFloat()
      val orientation = decoder.safeDecodeFloat()
      val x = decoder.safeDecodeInt32()
      val y = decoder.safeDecodeInt32()
      val z = decoder.safeDecodeFloat()
      val frame = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return FigureEightExecutionStatus(
        timeUsec = timeUsec,
        majorRadius = majorRadius,
        minorRadius = minorRadius,
        orientation = orientation,
        frame = frame,
        x = x,
        y = y,
        z = z,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FigureEightExecutionStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var majorRadius: Float = 0F

    public var minorRadius: Float = 0F

    public var orientation: Float = 0F

    public var frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u)

    public var x: Int = 0

    public var y: Int = 0

    public var z: Float = 0F

    public fun build(): FigureEightExecutionStatus = FigureEightExecutionStatus(
      timeUsec = timeUsec,
      majorRadius = majorRadius,
      minorRadius = minorRadius,
      orientation = orientation,
      frame = frame,
      x = x,
      y = y,
      z = z,
    )
  }
}
