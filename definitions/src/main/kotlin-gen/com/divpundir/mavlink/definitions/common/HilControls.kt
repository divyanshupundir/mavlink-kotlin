package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
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
import okio.Buffer
import okio.BufferedSource

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
  public override val instanceCompanion: MavMessage.MavCompanion<HilControls> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloat(rollAilerons)
    output.encodeFloat(pitchElevator)
    output.encodeFloat(yawRudder)
    output.encodeFloat(throttle)
    output.encodeFloat(aux1)
    output.encodeFloat(aux2)
    output.encodeFloat(aux3)
    output.encodeFloat(aux4)
    output.encodeEnumValue(mode.value, 1)
    output.encodeUInt8(navMode)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloat(rollAilerons)
    output.encodeFloat(pitchElevator)
    output.encodeFloat(yawRudder)
    output.encodeFloat(throttle)
    output.encodeFloat(aux1)
    output.encodeFloat(aux2)
    output.encodeFloat(aux3)
    output.encodeFloat(aux4)
    output.encodeEnumValue(mode.value, 1)
    output.encodeUInt8(navMode)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<HilControls> {
    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    public override val id: UInt = 91u

    public override val crcExtra: Byte = 63

    public override fun deserialize(source: BufferedSource): HilControls {
      val timeUsec = source.decodeUInt64()
      val rollAilerons = source.decodeFloat()
      val pitchElevator = source.decodeFloat()
      val yawRudder = source.decodeFloat()
      val throttle = source.decodeFloat()
      val aux1 = source.decodeFloat()
      val aux2 = source.decodeFloat()
      val aux3 = source.decodeFloat()
      val aux4 = source.decodeFloat()
      val mode = source.decodeEnumValue(1).let { value ->
        val entry = MavMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val navMode = source.decodeUInt8()

      return HilControls(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): HilControls =
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
