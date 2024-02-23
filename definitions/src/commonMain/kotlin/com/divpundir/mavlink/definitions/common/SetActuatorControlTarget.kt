package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
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
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param groupMlx Actuator group. The "_mlx" indicates this is a multi-instance message and a
 * MAVLink parser should use this field to difference between instances.
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param controls Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for
 * single rotation direction motors is 0..1, negative range for reverse direction. Standard mapping for
 * attitude controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, airbrakes,
 * landing gear. Load a pass-through mixer to repurpose them as generic outputs.
 */
@GeneratedMavMessage(
  id = 139u,
  crcExtra = -88,
)
public data class SetActuatorControlTarget(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
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
  override val instanceCompanion: MavMessage.MavCompanion<SetActuatorControlTarget> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloatArray(controls, 32)
    encoder.encodeUInt8(groupMlx)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloatArray(controls, 32)
    encoder.encodeUInt8(groupMlx)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SetActuatorControlTarget> {
    private const val SIZE_V1: Int = 43

    private const val SIZE_V2: Int = 43

    override val id: UInt = 139u

    override val crcExtra: Byte = -88

    override fun deserialize(bytes: ByteArray): SetActuatorControlTarget {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val controls = decoder.safeDecodeFloatArray(32)
      val groupMlx = decoder.safeDecodeUInt8()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

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
