package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long

/**
 * Telemetry of power generation system. Alternator or mechanical generator.
 */
public data class GeneratorStatus(
  /**
   * Status flags.
   */
  public val status: MavEnumValue<MavGeneratorStatusFlag> = MavEnumValue.fromValue(0),
  /**
   * Speed of electrical generator or alternator. UINT16_MAX: field not provided.
   */
  public val generatorSpeed: Int = 0,
  /**
   * Current into/out of battery. Positive for out. Negative for in. NaN: field not provided.
   */
  public val batteryCurrent: Float = 0F,
  /**
   * Current going to the UAV. If battery current not available this is the DC current from the
   * generator. Positive for out. Negative for in. NaN: field not provided
   */
  public val loadCurrent: Float = 0F,
  /**
   * The power being generated. NaN: field not provided
   */
  public val powerGenerated: Float = 0F,
  /**
   * Voltage of the bus seen at the generator, or battery bus if battery bus is controlled by
   * generator and at a different voltage to main bus.
   */
  public val busVoltage: Float = 0F,
  /**
   * The temperature of the rectifier or power converter. INT16_MAX: field not provided.
   */
  public val rectifierTemperature: Int = 0,
  /**
   * The target battery current. Positive for out. Negative for in. NaN: field not provided
   */
  public val batCurrentSetpoint: Float = 0F,
  /**
   * The temperature of the mechanical motor, fuel cell core or generator. INT16_MAX: field not
   * provided.
   */
  public val generatorTemperature: Int = 0,
  /**
   * Seconds this generator has run since it was rebooted. UINT32_MAX: field not provided.
   */
  public val runtime: Long = 0L,
  /**
   * Seconds until this generator requires maintenance.  A negative value indicates maintenance is
   * past-due. INT32_MAX: field not provided.
   */
  public val timeUntilMaintenance: Int = 0,
) : MavMessage<GeneratorStatus> {
  public override val instanceMetadata: MavMessage.Metadata<GeneratorStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(42).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(status.value, 8)
    outputBuffer.encodeUint16(generatorSpeed)
    outputBuffer.encodeFloat(batteryCurrent)
    outputBuffer.encodeFloat(loadCurrent)
    outputBuffer.encodeFloat(powerGenerated)
    outputBuffer.encodeFloat(busVoltage)
    outputBuffer.encodeInt16(rectifierTemperature)
    outputBuffer.encodeFloat(batCurrentSetpoint)
    outputBuffer.encodeInt16(generatorTemperature)
    outputBuffer.encodeUint32(runtime)
    outputBuffer.encodeInt32(timeUntilMaintenance)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 373

    private const val CRC: Int = 87

    private val DESERIALIZER: MavDeserializer<GeneratorStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val status = inputBuffer.decodeEnumValue(8).let { value ->
        val entry = MavGeneratorStatusFlag.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val generatorSpeed = inputBuffer.decodeUint16()
      val batteryCurrent = inputBuffer.decodeFloat()
      val loadCurrent = inputBuffer.decodeFloat()
      val powerGenerated = inputBuffer.decodeFloat()
      val busVoltage = inputBuffer.decodeFloat()
      val rectifierTemperature = inputBuffer.decodeInt16()
      val batCurrentSetpoint = inputBuffer.decodeFloat()
      val generatorTemperature = inputBuffer.decodeInt16()
      val runtime = inputBuffer.decodeUint32()
      val timeUntilMaintenance = inputBuffer.decodeInt32()
      GeneratorStatus(
        status = status,
        generatorSpeed = generatorSpeed,
        batteryCurrent = batteryCurrent,
        loadCurrent = loadCurrent,
        powerGenerated = powerGenerated,
        busVoltage = busVoltage,
        rectifierTemperature = rectifierTemperature,
        batCurrentSetpoint = batCurrentSetpoint,
        generatorTemperature = generatorTemperature,
        runtime = runtime,
        timeUntilMaintenance = timeUntilMaintenance,
      )
    }


    private val METADATA: MavMessage.Metadata<GeneratorStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GeneratorStatus> = METADATA
  }
}
