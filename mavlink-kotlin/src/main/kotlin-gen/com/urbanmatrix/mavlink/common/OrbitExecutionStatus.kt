package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeUint64
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Vehicle status report that is sent out while orbit execution is in progress (see
 * MAV_CMD_DO_ORBIT).
 */
public data class OrbitExecutionStatus(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Radius of the orbit circle. Positive values orbit clockwise, negative values orbit
   * counter-clockwise.
   */
  public val radius: Float = 0F,
  /**
   * X coordinate of center point. Coordinate system depends on frame field: local = x position in
   * meters * 1e4, global = latitude in degrees * 1e7.
   */
  public val x: Int = 0,
  /**
   * Y coordinate of center point.  Coordinate system depends on frame field: local = x position in
   * meters * 1e4, global = latitude in degrees * 1e7.
   */
  public val y: Int = 0,
  /**
   * Altitude of center point. Coordinate system depends on frame field.
   */
  public val z: Float = 0F,
  /**
   * The coordinate system of the fields: x, y, z.
   */
  public val frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0),
) : MavMessage<OrbitExecutionStatus> {
  public override val instanceMetadata: MavMessage.Metadata<OrbitExecutionStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloat(radius)
    outputBuffer.encodeInt32(x)
    outputBuffer.encodeInt32(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeEnumValue(frame.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 360

    private const val CRC: Int = 11

    private val DESERIALIZER: MavDeserializer<OrbitExecutionStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
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
        x = x,
        y = y,
        z = z,
        frame = frame,
      )
    }


    private val METADATA: MavMessage.Metadata<OrbitExecutionStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OrbitExecutionStatus> = METADATA
  }
}
