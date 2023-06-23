package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * The raw values of the actuator outputs (e.g. on Pixhawk, from MAIN, AUX ports). This message
 * supersedes SERVO_OUTPUT_RAW.
 */
@GeneratedMavMessage(
  id = 375u,
  crcExtra = -5,
)
public data class ActuatorOutputStatus(
  /**
   * Timestamp (since system boot).
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Active outputs
   */
  @GeneratedMavField(type = "uint32_t")
  public val active: UInt = 0u,
  /**
   * Servo / motor output array values. Zero values indicate unused channels.
   */
  @GeneratedMavField(type = "float[32]")
  public val actuator: List<Float> = emptyList(),
) : MavMessage<ActuatorOutputStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<ActuatorOutputStatus> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeUInt32(active)
    output.encodeFloatArray(actuator, 128)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeUInt32(active)
    output.encodeFloatArray(actuator, 128)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<ActuatorOutputStatus> {
    private const val SIZE_V1: Int = 140

    private const val SIZE_V2: Int = 140

    public override val id: UInt = 375u

    public override val crcExtra: Byte = -5

    public override fun deserialize(source: BufferedSource): ActuatorOutputStatus {
      val timeUsec = source.decodeUInt64()
      val active = source.decodeUInt32()
      val actuator = source.decodeFloatArray(128)

      return ActuatorOutputStatus(
        timeUsec = timeUsec,
        active = active,
        actuator = actuator,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ActuatorOutputStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var active: UInt = 0u

    public var actuator: List<Float> = emptyList()

    public fun build(): ActuatorOutputStatus = ActuatorOutputStatus(
      timeUsec = timeUsec,
      active = active,
      actuator = actuator,
    )
  }
}
