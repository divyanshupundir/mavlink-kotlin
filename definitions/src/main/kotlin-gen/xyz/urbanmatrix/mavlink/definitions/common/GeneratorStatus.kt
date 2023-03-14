package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavBitmaskValue
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32
import xyz.urbanmatrix.mavlink.serialization.encodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Telemetry of power generation system. Alternator or mechanical generator.
 */
@GeneratedMavMessage(
  id = 373u,
  crcExtra = 117,
)
public data class GeneratorStatus(
  /**
   * Status flags.
   */
  @GeneratedMavField(type = "uint64_t")
  public val status: MavBitmaskValue<MavGeneratorStatusFlag> = MavBitmaskValue.fromValue(0u),
  /**
   * Speed of electrical generator or alternator. UINT16_MAX: field not provided.
   */
  @GeneratedMavField(type = "uint16_t")
  public val generatorSpeed: UShort = 0u,
  /**
   * Current into/out of battery. Positive for out. Negative for in. NaN: field not provided.
   */
  @GeneratedMavField(type = "float")
  public val batteryCurrent: Float = 0F,
  /**
   * Current going to the UAV. If battery current not available this is the DC current from the
   * generator. Positive for out. Negative for in. NaN: field not provided
   */
  @GeneratedMavField(type = "float")
  public val loadCurrent: Float = 0F,
  /**
   * The power being generated. NaN: field not provided
   */
  @GeneratedMavField(type = "float")
  public val powerGenerated: Float = 0F,
  /**
   * Voltage of the bus seen at the generator, or battery bus if battery bus is controlled by
   * generator and at a different voltage to main bus.
   */
  @GeneratedMavField(type = "float")
  public val busVoltage: Float = 0F,
  /**
   * The temperature of the rectifier or power converter. INT16_MAX: field not provided.
   */
  @GeneratedMavField(type = "int16_t")
  public val rectifierTemperature: Short = 0,
  /**
   * The target battery current. Positive for out. Negative for in. NaN: field not provided
   */
  @GeneratedMavField(type = "float")
  public val batCurrentSetpoint: Float = 0F,
  /**
   * The temperature of the mechanical motor, fuel cell core or generator. INT16_MAX: field not
   * provided.
   */
  @GeneratedMavField(type = "int16_t")
  public val generatorTemperature: Short = 0,
  /**
   * Seconds this generator has run since it was rebooted. UINT32_MAX: field not provided.
   */
  @GeneratedMavField(type = "uint32_t")
  public val runtime: UInt = 0u,
  /**
   * Seconds until this generator requires maintenance.  A negative value indicates maintenance is
   * past-due. INT32_MAX: field not provided.
   */
  @GeneratedMavField(type = "int32_t")
  public val timeUntilMaintenance: Int = 0,
) : MavMessage<GeneratorStatus> {
  public override val instanceMetadata: MavMessage.Metadata<GeneratorStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeBitmaskValue(status.value, 8)
    outputBuffer.encodeFloat(batteryCurrent)
    outputBuffer.encodeFloat(loadCurrent)
    outputBuffer.encodeFloat(powerGenerated)
    outputBuffer.encodeFloat(busVoltage)
    outputBuffer.encodeFloat(batCurrentSetpoint)
    outputBuffer.encodeUInt32(runtime)
    outputBuffer.encodeInt32(timeUntilMaintenance)
    outputBuffer.encodeUInt16(generatorSpeed)
    outputBuffer.encodeInt16(rectifierTemperature)
    outputBuffer.encodeInt16(generatorTemperature)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeBitmaskValue(status.value, 8)
    outputBuffer.encodeFloat(batteryCurrent)
    outputBuffer.encodeFloat(loadCurrent)
    outputBuffer.encodeFloat(powerGenerated)
    outputBuffer.encodeFloat(busVoltage)
    outputBuffer.encodeFloat(batCurrentSetpoint)
    outputBuffer.encodeUInt32(runtime)
    outputBuffer.encodeInt32(timeUntilMaintenance)
    outputBuffer.encodeUInt16(generatorSpeed)
    outputBuffer.encodeInt16(rectifierTemperature)
    outputBuffer.encodeInt16(generatorTemperature)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 373u

    private const val CRC_EXTRA: Byte = 117

    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    private val DESERIALIZER: MavDeserializer<GeneratorStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val status = inputBuffer.decodeBitmaskValue(8).let { value ->
        val flags = MavGeneratorStatusFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val batteryCurrent = inputBuffer.decodeFloat()
      val loadCurrent = inputBuffer.decodeFloat()
      val powerGenerated = inputBuffer.decodeFloat()
      val busVoltage = inputBuffer.decodeFloat()
      val batCurrentSetpoint = inputBuffer.decodeFloat()
      val runtime = inputBuffer.decodeUInt32()
      val timeUntilMaintenance = inputBuffer.decodeInt32()
      val generatorSpeed = inputBuffer.decodeUInt16()
      val rectifierTemperature = inputBuffer.decodeInt16()
      val generatorTemperature = inputBuffer.decodeInt16()

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


    private val METADATA: MavMessage.Metadata<GeneratorStatus> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GeneratorStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GeneratorStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var status: MavBitmaskValue<MavGeneratorStatusFlag> = MavBitmaskValue.fromValue(0u)

    public var generatorSpeed: UShort = 0u

    public var batteryCurrent: Float = 0F

    public var loadCurrent: Float = 0F

    public var powerGenerated: Float = 0F

    public var busVoltage: Float = 0F

    public var rectifierTemperature: Short = 0

    public var batCurrentSetpoint: Float = 0F

    public var generatorTemperature: Short = 0

    public var runtime: UInt = 0u

    public var timeUntilMaintenance: Int = 0

    public fun build(): GeneratorStatus = GeneratorStatus(
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
}
