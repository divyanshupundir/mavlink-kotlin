package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * 2nd Battery status
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 181u,
  crcExtra = -82,
)
public data class Battery2(
  /**
   * Voltage.
   */
  @GeneratedMavField(type = "uint16_t")
  public val voltage: UShort = 0u,
  /**
   * Battery current, -1: autopilot does not measure the current.
   */
  @GeneratedMavField(type = "int16_t")
  public val currentBattery: Short = 0,
) : MavMessage<Battery2> {
  public override val instanceCompanion: MavMessage.MavCompanion<Battery2> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt16(voltage)
    encoder.encodeInt16(currentBattery)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt16(voltage)
    encoder.encodeInt16(currentBattery)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Battery2> {
    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 4

    public override val id: UInt = 181u

    public override val crcExtra: Byte = -82

    public override fun deserialize(bytes: ByteArray): Battery2 {
      val decoder = MavDataDecoder.wrap(bytes)

      val voltage = decoder.safeDecodeUInt16()
      val currentBattery = decoder.safeDecodeInt16()

      return Battery2(
        voltage = voltage,
        currentBattery = currentBattery,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Battery2 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var voltage: UShort = 0u

    public var currentBattery: Short = 0

    public fun build(): Battery2 = Battery2(
      voltage = voltage,
      currentBattery = currentBattery,
    )
  }
}
