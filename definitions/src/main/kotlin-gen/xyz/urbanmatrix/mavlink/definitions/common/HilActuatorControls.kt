package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.definitions.minimal.MavModeFlag
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Sent from autopilot to simulation. Hardware in the loop control outputs (replacement for
 * HIL_CONTROLS)
 */
@GeneratedMavMessage(
  id = 93,
  crc = 47,
)
public data class HilActuatorControls(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Control outputs -1 .. 1. Channel assignment depends on the simulated hardware.
   */
  @GeneratedMavField(type = "float[16]")
  public val controls: List<Float> = emptyList(),
  /**
   * System mode. Includes arming state.
   */
  @GeneratedMavField(type = "uint8_t")
  public val mode: MavEnumValue<MavModeFlag> = MavEnumValue.fromValue(0),
  /**
   * Flags as bitfield, 1: indicate simulation using lockstep.
   */
  @GeneratedMavField(type = "uint64_t")
  public val flags: BigInteger = BigInteger.ZERO,
) : MavMessage<HilActuatorControls> {
  public override val instanceMetadata: MavMessage.Metadata<HilActuatorControls> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint64(flags)
    outputBuffer.encodeFloatArray(controls, 64)
    outputBuffer.encodeEnumValue(mode.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint64(flags)
    outputBuffer.encodeFloatArray(controls, 64)
    outputBuffer.encodeEnumValue(mode.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 93

    private const val CRC: Int = 47

    private const val SIZE_V1: Int = 81

    private const val SIZE_V2: Int = 81

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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: BigInteger = BigInteger.ZERO

    public var controls: List<Float> = emptyList()

    public var mode: MavEnumValue<MavModeFlag> = MavEnumValue.fromValue(0)

    public var flags: BigInteger = BigInteger.ZERO

    public fun build(): HilActuatorControls = HilActuatorControls(
      timeUsec = timeUsec,
      controls = controls,
      mode = mode,
      flags = flags,
    )
  }
}
