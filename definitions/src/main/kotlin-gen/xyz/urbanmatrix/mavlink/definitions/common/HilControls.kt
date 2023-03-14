package xyz.urbanmatrix.mavlink.definitions.common

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
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUInt64
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUInt64
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Sent from autopilot to simulation. Hardware in the loop control outputs
 */
@GeneratedMavMessage(
  id = 91u,
  crcExtra = 63,
)
public data class HilControls(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Control output -1 .. 1
   */
  @GeneratedMavField(type = "float")
  public val rollAilerons: Float = 0F,
  /**
   * Control output -1 .. 1
   */
  @GeneratedMavField(type = "float")
  public val pitchElevator: Float = 0F,
  /**
   * Control output -1 .. 1
   */
  @GeneratedMavField(type = "float")
  public val yawRudder: Float = 0F,
  /**
   * Throttle 0 .. 1
   */
  @GeneratedMavField(type = "float")
  public val throttle: Float = 0F,
  /**
   * Aux 1, -1 .. 1
   */
  @GeneratedMavField(type = "float")
  public val aux1: Float = 0F,
  /**
   * Aux 2, -1 .. 1
   */
  @GeneratedMavField(type = "float")
  public val aux2: Float = 0F,
  /**
   * Aux 3, -1 .. 1
   */
  @GeneratedMavField(type = "float")
  public val aux3: Float = 0F,
  /**
   * Aux 4, -1 .. 1
   */
  @GeneratedMavField(type = "float")
  public val aux4: Float = 0F,
  /**
   * System mode.
   */
  @GeneratedMavField(type = "uint8_t")
  public val mode: MavEnumValue<MavMode> = MavEnumValue.fromValue(0u),
  /**
   * Navigation mode (MAV_NAV_MODE)
   */
  @GeneratedMavField(type = "uint8_t")
  public val navMode: UByte = 0u,
) : MavMessage<HilControls> {
  public override val instanceMetadata: MavMessage.Metadata<HilControls> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(rollAilerons)
    outputBuffer.encodeFloat(pitchElevator)
    outputBuffer.encodeFloat(yawRudder)
    outputBuffer.encodeFloat(throttle)
    outputBuffer.encodeFloat(aux1)
    outputBuffer.encodeFloat(aux2)
    outputBuffer.encodeFloat(aux3)
    outputBuffer.encodeFloat(aux4)
    outputBuffer.encodeEnumValue(mode.value, 1)
    outputBuffer.encodeUInt8(navMode)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(rollAilerons)
    outputBuffer.encodeFloat(pitchElevator)
    outputBuffer.encodeFloat(yawRudder)
    outputBuffer.encodeFloat(throttle)
    outputBuffer.encodeFloat(aux1)
    outputBuffer.encodeFloat(aux2)
    outputBuffer.encodeFloat(aux3)
    outputBuffer.encodeFloat(aux4)
    outputBuffer.encodeEnumValue(mode.value, 1)
    outputBuffer.encodeUInt8(navMode)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 91u

    private const val CRC_EXTRA: Byte = 63

    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    private val DESERIALIZER: MavDeserializer<HilControls> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val rollAilerons = inputBuffer.decodeFloat()
      val pitchElevator = inputBuffer.decodeFloat()
      val yawRudder = inputBuffer.decodeFloat()
      val throttle = inputBuffer.decodeFloat()
      val aux1 = inputBuffer.decodeFloat()
      val aux2 = inputBuffer.decodeFloat()
      val aux3 = inputBuffer.decodeFloat()
      val aux4 = inputBuffer.decodeFloat()
      val mode = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val navMode = inputBuffer.decodeUInt8()

      HilControls(
        timeUsec = timeUsec,
        rollAilerons = rollAilerons,
        pitchElevator = pitchElevator,
        yawRudder = yawRudder,
        throttle = throttle,
        aux1 = aux1,
        aux2 = aux2,
        aux3 = aux3,
        aux4 = aux4,
        mode = mode,
        navMode = navMode,
      )
    }


    private val METADATA: MavMessage.Metadata<HilControls> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<HilControls> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): HilControls =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var rollAilerons: Float = 0F

    public var pitchElevator: Float = 0F

    public var yawRudder: Float = 0F

    public var throttle: Float = 0F

    public var aux1: Float = 0F

    public var aux2: Float = 0F

    public var aux3: Float = 0F

    public var aux4: Float = 0F

    public var mode: MavEnumValue<MavMode> = MavEnumValue.fromValue(0u)

    public var navMode: UByte = 0u

    public fun build(): HilControls = HilControls(
      timeUsec = timeUsec,
      rollAilerons = rollAilerons,
      pitchElevator = pitchElevator,
      yawRudder = yawRudder,
      throttle = throttle,
      aux1 = aux1,
      aux2 = aux2,
      aux3 = aux3,
      aux4 = aux4,
      mode = mode,
      navMode = navMode,
    )
  }
}
