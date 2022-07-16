package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * The MCU status, giving MCU temperature and voltage. The min and max voltages are to allow for
 * detecting power supply instability.
 */
public data class McuStatus(
  /**
   * MCU instance
   */
  public val id: Int = 0,
  /**
   * MCU Internal temperature
   */
  public val mcuTemperature: Int = 0,
  /**
   * MCU voltage
   */
  public val mcuVoltage: Int = 0,
  /**
   * MCU voltage minimum
   */
  public val mcuVoltageMin: Int = 0,
  /**
   * MCU voltage maximum
   */
  public val mcuVoltageMax: Int = 0,
) : MavMessage<McuStatus> {
  public override val instanceMetadata: MavMessage.Metadata<McuStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(mcuTemperature)
    outputBuffer.encodeUint16(mcuVoltage)
    outputBuffer.encodeUint16(mcuVoltageMin)
    outputBuffer.encodeUint16(mcuVoltageMax)
    outputBuffer.encodeUint8(id)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 11039

    private const val CRC: Int = 142

    private const val SIZE: Int = 9

    private val DESERIALIZER: MavDeserializer<McuStatus> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for McuStatus: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

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
  }
}
