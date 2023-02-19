package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * The MCU status, giving MCU temperature and voltage. The min and max voltages are to allow for
 * detecting power supply instability.
 */
@GeneratedMavMessage(
  id = 11039u,
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
  public override val instanceMetadata: MavMessage.Metadata<McuStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(mcuTemperature)
    outputBuffer.encodeUInt16(mcuVoltage)
    outputBuffer.encodeUInt16(mcuVoltageMin)
    outputBuffer.encodeUInt16(mcuVoltageMax)
    outputBuffer.encodeUInt8(id)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(mcuTemperature)
    outputBuffer.encodeUInt16(mcuVoltage)
    outputBuffer.encodeUInt16(mcuVoltageMin)
    outputBuffer.encodeUInt16(mcuVoltageMax)
    outputBuffer.encodeUInt8(id)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 11039u

    private const val CRC_EXTRA: Byte = -114

    private const val SIZE_V1: Int = 9

    private const val SIZE_V2: Int = 9

    private val DESERIALIZER: MavDeserializer<McuStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val mcuTemperature = inputBuffer.decodeInt16()
      val mcuVoltage = inputBuffer.decodeUInt16()
      val mcuVoltageMin = inputBuffer.decodeUInt16()
      val mcuVoltageMax = inputBuffer.decodeUInt16()
      val id = inputBuffer.decodeUInt8()

      McuStatus(
        id = id,
        mcuTemperature = mcuTemperature,
        mcuVoltage = mcuVoltage,
        mcuVoltageMin = mcuVoltageMin,
        mcuVoltageMax = mcuVoltageMax,
      )
    }


    private val METADATA: MavMessage.Metadata<McuStatus> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<McuStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): McuStatus =
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
