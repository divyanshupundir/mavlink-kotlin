package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F19 format
 */
@GeneratedMavMessage(
  id = 185u,
  crcExtra = 87,
)
public data class SerialUdbExtraF19(
  /**
   * SUE aileron output channel
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueAileronOutputChannel: UByte = 0u,
  /**
   * SUE aileron reversed
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueAileronReversed: UByte = 0u,
  /**
   * SUE elevator output channel
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueElevatorOutputChannel: UByte = 0u,
  /**
   * SUE elevator reversed
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueElevatorReversed: UByte = 0u,
  /**
   * SUE throttle output channel
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueThrottleOutputChannel: UByte = 0u,
  /**
   * SUE throttle reversed
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueThrottleReversed: UByte = 0u,
  /**
   * SUE rudder output channel
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueRudderOutputChannel: UByte = 0u,
  /**
   * SUE rudder reversed
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueRudderReversed: UByte = 0u,
) : MavMessage<SerialUdbExtraF19> {
  public override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF19> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(sueAileronOutputChannel)
    output.encodeUInt8(sueAileronReversed)
    output.encodeUInt8(sueElevatorOutputChannel)
    output.encodeUInt8(sueElevatorReversed)
    output.encodeUInt8(sueThrottleOutputChannel)
    output.encodeUInt8(sueThrottleReversed)
    output.encodeUInt8(sueRudderOutputChannel)
    output.encodeUInt8(sueRudderReversed)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(sueAileronOutputChannel)
    output.encodeUInt8(sueAileronReversed)
    output.encodeUInt8(sueElevatorOutputChannel)
    output.encodeUInt8(sueElevatorReversed)
    output.encodeUInt8(sueThrottleOutputChannel)
    output.encodeUInt8(sueThrottleReversed)
    output.encodeUInt8(sueRudderOutputChannel)
    output.encodeUInt8(sueRudderReversed)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF19> {
    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 8

    public override val id: UInt = 185u

    public override val crcExtra: Byte = 87

    public override fun deserialize(source: BufferedSource): SerialUdbExtraF19 {
      val sueAileronOutputChannel = source.decodeUInt8()
      val sueAileronReversed = source.decodeUInt8()
      val sueElevatorOutputChannel = source.decodeUInt8()
      val sueElevatorReversed = source.decodeUInt8()
      val sueThrottleOutputChannel = source.decodeUInt8()
      val sueThrottleReversed = source.decodeUInt8()
      val sueRudderOutputChannel = source.decodeUInt8()
      val sueRudderReversed = source.decodeUInt8()

      return SerialUdbExtraF19(
        sueAileronOutputChannel = sueAileronOutputChannel,
        sueAileronReversed = sueAileronReversed,
        sueElevatorOutputChannel = sueElevatorOutputChannel,
        sueElevatorReversed = sueElevatorReversed,
        sueThrottleOutputChannel = sueThrottleOutputChannel,
        sueThrottleReversed = sueThrottleReversed,
        sueRudderOutputChannel = sueRudderOutputChannel,
        sueRudderReversed = sueRudderReversed,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SerialUdbExtraF19 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueAileronOutputChannel: UByte = 0u

    public var sueAileronReversed: UByte = 0u

    public var sueElevatorOutputChannel: UByte = 0u

    public var sueElevatorReversed: UByte = 0u

    public var sueThrottleOutputChannel: UByte = 0u

    public var sueThrottleReversed: UByte = 0u

    public var sueRudderOutputChannel: UByte = 0u

    public var sueRudderReversed: UByte = 0u

    public fun build(): SerialUdbExtraF19 = SerialUdbExtraF19(
      sueAileronOutputChannel = sueAileronOutputChannel,
      sueAileronReversed = sueAileronReversed,
      sueElevatorOutputChannel = sueElevatorOutputChannel,
      sueElevatorReversed = sueElevatorReversed,
      sueThrottleOutputChannel = sueThrottleOutputChannel,
      sueThrottleReversed = sueThrottleReversed,
      sueRudderOutputChannel = sueRudderOutputChannel,
      sueRudderReversed = sueRudderReversed,
    )
  }
}
