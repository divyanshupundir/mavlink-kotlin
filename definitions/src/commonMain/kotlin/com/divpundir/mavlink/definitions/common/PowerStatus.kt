package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Power supply status
 *
 * @param vcc 5V rail voltage.
 * units = mV
 * @param vservo Servo rail voltage.
 * units = mV
 * @param flags Bitmap of power supply status flags.
 */
@GeneratedMavMessage(
  id = 125u,
  crcExtra = -53,
)
public data class PowerStatus(
  /**
   * 5V rail voltage.
   * units = mV
   */
  @GeneratedMavField(type = "uint16_t")
  public val vcc: UShort = 0u,
  /**
   * Servo rail voltage.
   * units = mV
   */
  @GeneratedMavField(type = "uint16_t")
  public val vservo: UShort = 0u,
  /**
   * Bitmap of power supply status flags.
   */
  @GeneratedMavField(type = "uint16_t")
  public val flags: MavBitmaskValue<MavPowerStatus> = MavBitmaskValue.fromValue(0u),
) : MavMessage<PowerStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<PowerStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(vcc)
    encoder.encodeUInt16(vservo)
    encoder.encodeBitmaskValue(flags.value, 2)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(vcc)
    encoder.encodeUInt16(vservo)
    encoder.encodeBitmaskValue(flags.value, 2)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<PowerStatus> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    override val id: UInt = 125u

    override val crcExtra: Byte = -53

    override fun deserialize(bytes: ByteArray): PowerStatus {
      val decoder = MavDataDecoder(bytes)

      val vcc = decoder.safeDecodeUInt16()
      val vservo = decoder.safeDecodeUInt16()
      val flags = decoder.safeDecodeBitmaskValue(2).let { value ->
        val flags = MavPowerStatus.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      return PowerStatus(
        vcc = vcc,
        vservo = vservo,
        flags = flags,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): PowerStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var vcc: UShort = 0u

    public var vservo: UShort = 0u

    public var flags: MavBitmaskValue<MavPowerStatus> = MavBitmaskValue.fromValue(0u)

    public fun build(): PowerStatus = PowerStatus(
      vcc = vcc,
      vservo = vservo,
      flags = flags,
    )
  }
}
