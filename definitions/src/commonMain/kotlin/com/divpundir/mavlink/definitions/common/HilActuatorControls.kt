package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.minimal.MavModeFlag
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List

/**
 * Sent from autopilot to simulation. Hardware in the loop control outputs (replacement for
 * HIL_CONTROLS)
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param controls Control outputs -1 .. 1. Channel assignment depends on the simulated hardware.
 * @param mode System mode. Includes arming state.
 * @param flags Flags as bitfield, 1: indicate simulation using lockstep.
 */
@GeneratedMavMessage(
  id = 93u,
  crcExtra = 47,
)
public data class HilActuatorControls(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
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
  override val instanceCompanion: MavMessage.MavCompanion<HilActuatorControls> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt64(flags)
    encoder.encodeFloatArray(controls, 64)
    encoder.encodeBitmaskValue(mode.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt64(flags)
    encoder.encodeFloatArray(controls, 64)
    encoder.encodeBitmaskValue(mode.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<HilActuatorControls> {
    private const val SIZE_V1: Int = 81

    private const val SIZE_V2: Int = 81

    override val id: UInt = 93u

    override val crcExtra: Byte = 47

    override fun deserialize(bytes: ByteArray): HilActuatorControls {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val flags = decoder.safeDecodeUInt64()
      val controls = decoder.safeDecodeFloatArray(64)
      val mode = decoder.safeDecodeBitmaskValue(1).let { value ->
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
