package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
  public override val instanceMetadata: MavMessage.Metadata<ActuatorControlTarget> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloatArray(controls, 32)
    outputBuffer.encodeUInt8(groupMlx)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloatArray(controls, 32)
    outputBuffer.encodeUInt8(groupMlx)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 140u

    private const val CRC_EXTRA: Byte = -75

    private const val SIZE_V1: Int = 41

    private const val SIZE_V2: Int = 41

    private val DESERIALIZER: MavDeserializer<ActuatorControlTarget> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val controls = inputBuffer.decodeFloatArray(32)
      val groupMlx = inputBuffer.decodeUInt8()

      ActuatorControlTarget(
        timeUsec = timeUsec,
        groupMlx = groupMlx,
        controls = controls,
      )
    }


    private val METADATA: MavMessage.Metadata<ActuatorControlTarget> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ActuatorControlTarget> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): ActuatorControlTarget =
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
