package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * The MCU status, giving MCU temperature and voltage. The min and max voltages are to allow for
 * detecting power supply instability.
 */
@GeneratedMavMessage(
  id = 11039,
  crc = 142,
)
public data class McuStatus(
  /**
   * MCU instance
   */
  @GeneratedMavField(type = "uint8_t")
  public val id: Int = 0,
  /**
   * MCU Internal temperature
   */
  @GeneratedMavField(type = "int16_t")
  public val mcuTemperature: Int = 0,
  /**
   * MCU voltage
   */
  @GeneratedMavField(type = "uint16_t")
  public val mcuVoltage: Int = 0,
  /**
   * MCU voltage minimum
   */
  @GeneratedMavField(type = "uint16_t")
  public val mcuVoltageMin: Int = 0,
  /**
   * MCU voltage maximum
   */
  @GeneratedMavField(type = "uint16_t")
  public val mcuVoltageMax: Int = 0,
) : MavMessage<McuStatus> {
  public override val instanceMetadata: MavMessage.Metadata<McuStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(mcuTemperature)
    outputBuffer.encodeUint16(mcuVoltage)
    outputBuffer.encodeUint16(mcuVoltageMin)
    outputBuffer.encodeUint16(mcuVoltageMax)
    outputBuffer.encodeUint8(id)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(mcuTemperature)
    outputBuffer.encodeUint16(mcuVoltage)
    outputBuffer.encodeUint16(mcuVoltageMin)
    outputBuffer.encodeUint16(mcuVoltageMax)
    outputBuffer.encodeUint8(id)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 11039

    private const val CRC: Int = 142

    private const val SIZE_V1: Int = 9

    private const val SIZE_V2: Int = 9

    private val DESERIALIZER: MavDeserializer<McuStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val mcuTemperature = inputBuffer.decodeInt16()
      val mcuVoltage = inputBuffer.decodeUint16()
      val mcuVoltageMin = inputBuffer.decodeUint16()
      val mcuVoltageMax = inputBuffer.decodeUint16()
      val id = inputBuffer.decodeUint8()

      McuStatus(
        id = id,
        mcuTemperature = mcuTemperature,
        mcuVoltage = mcuVoltage,
        mcuVoltageMin = mcuVoltageMin,
        mcuVoltageMax = mcuVoltageMax,
      )
    }


    private val METADATA: MavMessage.Metadata<McuStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<McuStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var id: Int = 0

    public var mcuTemperature: Int = 0

    public var mcuVoltage: Int = 0

    public var mcuVoltageMin: Int = 0

    public var mcuVoltageMax: Int = 0

    public fun build(): McuStatus = McuStatus(
      id = id,
      mcuTemperature = mcuTemperature,
      mcuVoltage = mcuVoltage,
      mcuVoltageMin = mcuVoltageMin,
      mcuVoltageMax = mcuVoltageMax,
    )
  }
}
