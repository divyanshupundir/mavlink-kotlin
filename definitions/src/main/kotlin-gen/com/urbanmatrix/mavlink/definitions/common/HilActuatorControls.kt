package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.definitions.minimal.MavModeFlag
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloatArray
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloatArray
import com.urbanmatrix.mavlink.serialization.encodeUint64
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.collections.List

/**
 * Sent from autopilot to simulation. Hardware in the loop control outputs (replacement for
 * HIL_CONTROLS)
 */
public data class HilActuatorControls(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Control outputs -1 .. 1. Channel assignment depends on the simulated hardware.
   */
  public val controls: List<Float> = emptyList(),
  /**
   * System mode. Includes arming state.
   */
  public val mode: MavEnumValue<MavModeFlag> = MavEnumValue.fromValue(0),
  /**
   * Flags as bitfield, 1: indicate simulation using lockstep.
   */
  public val flags: BigInteger = BigInteger.ZERO,
) : MavMessage<HilActuatorControls> {
  public override val instanceMetadata: MavMessage.Metadata<HilActuatorControls> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint64(flags)
    outputBuffer.encodeFloatArray(controls, 64)
    outputBuffer.encodeEnumValue(mode.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 93

    private const val CRC: Int = 47

    private const val SIZE: Int = 81

    private val DESERIALIZER: MavDeserializer<HilActuatorControls> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val flags = inputBuffer.decodeUint64()
      val controls = inputBuffer.decodeFloatArray(64)
      val mode = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavModeFlag.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      HilActuatorControls(
        timeUsec = timeUsec,
        controls = controls,
        mode = mode,
        flags = flags,
      )
    }


    private val METADATA: MavMessage.Metadata<HilActuatorControls> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<HilActuatorControls> = METADATA
  }
}
