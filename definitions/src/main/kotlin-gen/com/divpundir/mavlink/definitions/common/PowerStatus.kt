package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Power supply status
 */
@GeneratedMavMessage(
  id = 125u,
  crcExtra = -53,
)
public data class PowerStatus(
  /**
   * 5V rail voltage.
   */
  @GeneratedMavField(type = "uint16_t")
  public val vcc: UShort = 0u,
  /**
   * Servo rail voltage.
   */
  @GeneratedMavField(type = "uint16_t")
  public val vservo: UShort = 0u,
  /**
   * Bitmap of power supply status flags.
   */
  @GeneratedMavField(type = "uint16_t")
  public val flags: MavBitmaskValue<MavPowerStatus> = MavBitmaskValue.fromValue(0u),
) : MavMessage<PowerStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<PowerStatus> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(vcc)
    buffer.encodeUInt16(vservo)
    buffer.encodeBitmaskValue(flags.value, 2)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(vcc)
    buffer.encodeUInt16(vservo)
    buffer.encodeBitmaskValue(flags.value, 2)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<PowerStatus> {
    public override val id: UInt = 125u

    public override val crcExtra: Byte = -53

    public override fun deserialize(bytes: ByteArray): PowerStatus {
      val buffer = Buffer().write(bytes)

      val vcc = buffer.decodeUInt16()
      val vservo = buffer.decodeUInt16()
      val flags = buffer.decodeBitmaskValue(2).let { value ->
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
