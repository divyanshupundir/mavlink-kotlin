package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * The MCU status, giving MCU temperature and voltage. The min and max voltages are to allow for
 * detecting power supply instability.
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
  public override val instanceCompanion: MavMessage.MavCompanion<McuStatus> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeInt16(mcuTemperature)
    output.encodeUInt16(mcuVoltage)
    output.encodeUInt16(mcuVoltageMin)
    output.encodeUInt16(mcuVoltageMax)
    output.encodeUInt8(id)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeInt16(mcuTemperature)
    output.encodeUInt16(mcuVoltage)
    output.encodeUInt16(mcuVoltageMin)
    output.encodeUInt16(mcuVoltageMax)
    output.encodeUInt8(id)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<McuStatus> {
    private const val SIZE_V1: Int = 9

    private const val SIZE_V2: Int = 9

    public override val id: UInt = 11_039u

    public override val crcExtra: Byte = -114

    public override fun deserialize(source: BufferedSource): McuStatus {
      val mcuTemperature = source.decodeInt16()
      val mcuVoltage = source.decodeUInt16()
      val mcuVoltageMin = source.decodeUInt16()
      val mcuVoltageMax = source.decodeUInt16()
      val id = source.decodeUInt8()

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
