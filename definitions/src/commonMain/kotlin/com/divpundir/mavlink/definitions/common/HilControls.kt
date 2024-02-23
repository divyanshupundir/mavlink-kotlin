package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
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

/**
 * Sent from autopilot to simulation. Hardware in the loop control outputs
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param rollAilerons Control output -1 .. 1
 * @param pitchElevator Control output -1 .. 1
 * @param yawRudder Control output -1 .. 1
 * @param throttle Throttle 0 .. 1
 * @param aux1 Aux 1, -1 .. 1
 * @param aux2 Aux 2, -1 .. 1
 * @param aux3 Aux 3, -1 .. 1
 * @param aux4 Aux 4, -1 .. 1
 * @param mode System mode.
 * @param navMode Navigation mode (MAV_NAV_MODE)
 */
@GeneratedMavMessage(
  id = 91u,
  crcExtra = 63,
)
public data class HilControls(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
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
  override val instanceCompanion: MavMessage.MavCompanion<HilControls> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(rollAilerons)
    encoder.encodeFloat(pitchElevator)
    encoder.encodeFloat(yawRudder)
    encoder.encodeFloat(throttle)
    encoder.encodeFloat(aux1)
    encoder.encodeFloat(aux2)
    encoder.encodeFloat(aux3)
    encoder.encodeFloat(aux4)
    encoder.encodeEnumValue(mode.value, 1)
    encoder.encodeUInt8(navMode)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(rollAilerons)
    encoder.encodeFloat(pitchElevator)
    encoder.encodeFloat(yawRudder)
    encoder.encodeFloat(throttle)
    encoder.encodeFloat(aux1)
    encoder.encodeFloat(aux2)
    encoder.encodeFloat(aux3)
    encoder.encodeFloat(aux4)
    encoder.encodeEnumValue(mode.value, 1)
    encoder.encodeUInt8(navMode)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<HilControls> {
    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    override val id: UInt = 91u

    override val crcExtra: Byte = 63

    override fun deserialize(bytes: ByteArray): HilControls {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val rollAilerons = decoder.safeDecodeFloat()
      val pitchElevator = decoder.safeDecodeFloat()
      val yawRudder = decoder.safeDecodeFloat()
      val throttle = decoder.safeDecodeFloat()
      val aux1 = decoder.safeDecodeFloat()
      val aux2 = decoder.safeDecodeFloat()
      val aux3 = decoder.safeDecodeFloat()
      val aux4 = decoder.safeDecodeFloat()
      val mode = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val navMode = decoder.safeDecodeUInt8()

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
