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
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * Set the vehicle attitude and body angular rates.
 */
@GeneratedMavMessage(
  id = 139u,
  crcExtra = -88,
)
public data class SetActuatorControlTarget(
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
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for single rotation
   * direction motors is 0..1, negative range for reverse direction. Standard mapping for attitude
   * controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, airbrakes, landing
   * gear. Load a pass-through mixer to repurpose them as generic outputs.
   */
  @GeneratedMavField(type = "float[8]")
  public val controls: List<Float> = emptyList(),
) : MavMessage<SetActuatorControlTarget> {
  public override val instanceCompanion: MavMessage.MavCompanion<SetActuatorControlTarget> =
      Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloatArray(controls, 32)
    output.encodeUInt8(groupMlx)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloatArray(controls, 32)
    output.encodeUInt8(groupMlx)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SetActuatorControlTarget> {
    private const val SIZE_V1: Int = 43

    private const val SIZE_V2: Int = 43

    public override val id: UInt = 139u

    public override val crcExtra: Byte = -88

    public override fun deserialize(source: BufferedSource): SetActuatorControlTarget {
      val timeUsec = source.decodeUInt64()
      val controls = source.decodeFloatArray(32)
      val groupMlx = source.decodeUInt8()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()

      return SetActuatorControlTarget(
        timeUsec = timeUsec,
        groupMlx = groupMlx,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        controls = controls,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SetActuatorControlTarget =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var groupMlx: UByte = 0u

    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var controls: List<Float> = emptyList()

    public fun build(): SetActuatorControlTarget = SetActuatorControlTarget(
      timeUsec = timeUsec,
      groupMlx = groupMlx,
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      controls = controls,
    )
  }
}
