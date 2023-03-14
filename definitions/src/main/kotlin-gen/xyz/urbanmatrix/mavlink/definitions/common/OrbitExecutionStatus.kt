package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.api.WorkInProgress
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt64
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt64
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  public override val instanceMetadata: MavMessage.Metadata<OrbitExecutionStatus> = METADATA

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

  public companion object {
    private const val ID: UInt = 360u

    private const val CRC_EXTRA: Byte = 11

    private const val SIZE_V1: Int = 25

    private const val SIZE_V2: Int = 25

    private val DESERIALIZER: MavDeserializer<OrbitExecutionStatus> = MavDeserializer { bytes ->
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

      OrbitExecutionStatus(
        timeUsec = timeUsec,
        radius = radius,
        frame = frame,
        x = x,
        y = y,
        z = z,
      )
    }


    private val METADATA: MavMessage.Metadata<OrbitExecutionStatus> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OrbitExecutionStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): OrbitExecutionStatus =
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
