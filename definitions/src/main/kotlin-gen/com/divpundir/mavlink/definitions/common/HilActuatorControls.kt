package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.minimal.MavModeFlag
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

/**
 * Sent from autopilot to simulation. Hardware in the loop control outputs (replacement for
 * HIL_CONTROLS)
 */
@GeneratedMavMessage(
  id = 93u,
  crcExtra = 47,
)
public data class HilActuatorControls(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Control outputs -1 .. 1. Channel assignment depends on the simulated hardware.
   */
  @GeneratedMavField(type = "float[16]")
  public val controls: List<Float> = emptyList(),
  /**
   * System mode. Includes arming state.
   */
  @GeneratedMavField(type = "uint8_t")
  public val mode: MavBitmaskValue<MavModeFlag> = MavBitmaskValue.fromValue(0u),
  /**
   * Flags as bitfield, 1: indicate simulation using lockstep.
   */
  @GeneratedMavField(type = "uint64_t")
  public val flags: ULong = 0uL,
) : MavMessage<HilActuatorControls> {
  public override val instanceCompanion: MavMessage.MavCompanion<HilActuatorControls> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeUInt64(flags)
    buffer.encodeFloatArray(controls, 64)
    buffer.encodeBitmaskValue(mode.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeUInt64(flags)
    buffer.encodeFloatArray(controls, 64)
    buffer.encodeBitmaskValue(mode.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<HilActuatorControls> {
    public override val id: UInt = 93u

    public override val crcExtra: Byte = 47

    public override fun deserialize(bytes: ByteArray): HilActuatorControls {
      val buffer = Buffer().write(bytes)

      val timeUsec = buffer.decodeUInt64()
      val flags = buffer.decodeUInt64()
      val controls = buffer.decodeFloatArray(64)
      val mode = buffer.decodeBitmaskValue(1).let { value ->
        val flags = MavModeFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      return HilActuatorControls(
        timeUsec = timeUsec,
        controls = controls,
        mode = mode,
        flags = flags,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): HilActuatorControls =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var controls: List<Float> = emptyList()

    public var mode: MavBitmaskValue<MavModeFlag> = MavBitmaskValue.fromValue(0u)

    public var flags: ULong = 0uL

    public fun build(): HilActuatorControls = HilActuatorControls(
      timeUsec = timeUsec,
      controls = controls,
      mode = mode,
      flags = flags,
    )
  }
}
