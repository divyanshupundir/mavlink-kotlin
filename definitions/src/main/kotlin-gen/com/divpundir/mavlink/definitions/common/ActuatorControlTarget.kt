package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

/**
 * Set the vehicle attitude and body angular rates.
 */
@GeneratedMavMessage(
  id = 140u,
  crcExtra = -75,
)
public data class ActuatorControlTarget(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Actuator group. The "_mlx" indicates this is a multi-instance message and a MAVLink parser
   * should use this field to difference between instances.
   */
  @GeneratedMavField(type = "uint8_t")
  public val groupMlx: UByte = 0u,
  /**
   * Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for single rotation
   * direction motors is 0..1, negative range for reverse direction. Standard mapping for attitude
   * controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, airbrakes, landing
   * gear. Load a pass-through mixer to repurpose them as generic outputs.
   */
  @GeneratedMavField(type = "float[8]")
  public val controls: List<Float> = emptyList(),
) : MavMessage<ActuatorControlTarget> {
  public override val instanceCompanion: MavMessage.MavCompanion<ActuatorControlTarget> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloatArray(controls, 32)
    buffer.encodeUInt8(groupMlx)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloatArray(controls, 32)
    buffer.encodeUInt8(groupMlx)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ActuatorControlTarget> {
    public override val id: UInt = 140u

    public override val crcExtra: Byte = -75

    public override fun deserialize(bytes: ByteArray): ActuatorControlTarget {
      val buffer = Buffer().write(bytes)

      val timeUsec = buffer.decodeUInt64()
      val controls = buffer.decodeFloatArray(32)
      val groupMlx = buffer.decodeUInt8()

      return ActuatorControlTarget(
        timeUsec = timeUsec,
        groupMlx = groupMlx,
        controls = controls,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ActuatorControlTarget =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var groupMlx: UByte = 0u

    public var controls: List<Float> = emptyList()

    public fun build(): ActuatorControlTarget = ActuatorControlTarget(
      timeUsec = timeUsec,
      groupMlx = groupMlx,
      controls = controls,
    )
  }
}
