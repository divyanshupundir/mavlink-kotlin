package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * The MCU status, giving MCU temperature and voltage. The min and max voltages are to allow for
 * detecting power supply instability.
 *
 */
@GeneratedMavMessage(
  id = 11_039u,
  crcExtra = -114,
)
public data class McuStatus(
  /**
   * MCU instance
   */
  @GeneratedMavField(type = "uint8_t")
  public val id: UByte = 0u,
  /**
   * MCU Internal temperature
   */
  @GeneratedMavField(type = "int16_t")
  public val mcuTemperature: Short = 0,
  /**
   * MCU voltage
   */
  @GeneratedMavField(type = "uint16_t")
  public val mcuVoltage: UShort = 0u,
  /**
   * MCU voltage minimum
   */
  @GeneratedMavField(type = "uint16_t")
  public val mcuVoltageMin: UShort = 0u,
  /**
   * MCU voltage maximum
   */
  @GeneratedMavField(type = "uint16_t")
  public val mcuVoltageMax: UShort = 0u,
) : MavMessage<McuStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<McuStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt16(mcuTemperature)
    encoder.encodeUInt16(mcuVoltage)
    encoder.encodeUInt16(mcuVoltageMin)
    encoder.encodeUInt16(mcuVoltageMax)
    encoder.encodeUInt8(id)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt16(mcuTemperature)
    encoder.encodeUInt16(mcuVoltage)
    encoder.encodeUInt16(mcuVoltageMin)
    encoder.encodeUInt16(mcuVoltageMax)
    encoder.encodeUInt8(id)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<McuStatus> {
    private const val SIZE_V1: Int = 9

    private const val SIZE_V2: Int = 9

    override val id: UInt = 11_039u

    override val crcExtra: Byte = -114

    override fun deserialize(bytes: ByteArray): McuStatus {
      val decoder = MavDataDecoder(bytes)

      val mcuTemperature = decoder.safeDecodeInt16()
      val mcuVoltage = decoder.safeDecodeUInt16()
      val mcuVoltageMin = decoder.safeDecodeUInt16()
      val mcuVoltageMax = decoder.safeDecodeUInt16()
      val id = decoder.safeDecodeUInt8()

      return McuStatus(
        id = id,
        mcuTemperature = mcuTemperature,
        mcuVoltage = mcuVoltage,
        mcuVoltageMin = mcuVoltageMin,
        mcuVoltageMax = mcuVoltageMax,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): McuStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var id: UByte = 0u

    public var mcuTemperature: Short = 0

    public var mcuVoltage: UShort = 0u

    public var mcuVoltageMin: UShort = 0u

    public var mcuVoltageMax: UShort = 0u

    public fun build(): McuStatus = McuStatus(
      id = id,
      mcuTemperature = mcuTemperature,
      mcuVoltage = mcuVoltage,
      mcuVoltageMin = mcuVoltageMin,
      mcuVoltageMax = mcuVoltageMax,
    )
  }
}
