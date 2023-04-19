package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.minimal.MavModeFlag
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
  public override val instanceMetadata: MavMessage.Metadata<HilActuatorControls> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeUInt64(flags)
    outputBuffer.encodeFloatArray(controls, 64)
    outputBuffer.encodeBitmaskValue(mode.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeUInt64(flags)
    outputBuffer.encodeFloatArray(controls, 64)
    outputBuffer.encodeBitmaskValue(mode.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 93u

    private const val CRC_EXTRA: Byte = 47

    private const val SIZE_V1: Int = 81

    private const val SIZE_V2: Int = 81

    private val DESERIALIZER: MavDeserializer<HilActuatorControls> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val flags = inputBuffer.decodeUInt64()
      val controls = inputBuffer.decodeFloatArray(64)
      val mode = inputBuffer.decodeBitmaskValue(1).let { value ->
        val flags = MavModeFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      HilActuatorControls(
        timeUsec = timeUsec,
        controls = controls,
        mode = mode,
        flags = flags,
      )
    }


    private val METADATA: MavMessage.Metadata<HilActuatorControls> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<HilActuatorControls> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): HilActuatorControls =
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
