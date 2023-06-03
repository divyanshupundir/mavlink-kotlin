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
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

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
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(vcc)
    outputBuffer.encodeUInt16(vservo)
    outputBuffer.encodeBitmaskValue(flags.value, 2)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(vcc)
    outputBuffer.encodeUInt16(vservo)
    outputBuffer.encodeBitmaskValue(flags.value, 2)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<PowerStatus> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    public override val id: UInt = 125u

    public override val crcExtra: Byte = -53

    public override fun deserialize(bytes: ByteArray): PowerStatus {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val vcc = inputBuffer.decodeUInt16()
      val vservo = inputBuffer.decodeUInt16()
      val flags = inputBuffer.decodeBitmaskValue(2).let { value ->
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
