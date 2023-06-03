package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Status of key hardware.
 */
@GeneratedMavMessage(
  id = 165u,
  crcExtra = 21,
)
public data class Hwstatus(
  /**
   * Board voltage.
   */
  @GeneratedMavField(type = "uint16_t")
  public val vcc: UShort = 0u,
  /**
   * I2C error count.
   */
  @GeneratedMavField(type = "uint8_t")
  public val i2cerr: UByte = 0u,
) : MavMessage<Hwstatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<Hwstatus> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(vcc)
    outputBuffer.encodeUInt8(i2cerr)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(vcc)
    outputBuffer.encodeUInt8(i2cerr)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Hwstatus> {
    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 3

    public override val id: UInt = 165u

    public override val crcExtra: Byte = 21

    public override fun deserialize(bytes: ByteArray): Hwstatus {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val vcc = inputBuffer.decodeUInt16()
      val i2cerr = inputBuffer.decodeUInt8()

      return Hwstatus(
        vcc = vcc,
        i2cerr = i2cerr,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Hwstatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var vcc: UShort = 0u

    public var i2cerr: UByte = 0u

    public fun build(): Hwstatus = Hwstatus(
      vcc = vcc,
      i2cerr = i2cerr,
    )
  }
}
