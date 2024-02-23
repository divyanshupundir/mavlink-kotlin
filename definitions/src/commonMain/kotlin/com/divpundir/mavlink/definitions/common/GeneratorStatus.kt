package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Telemetry of power generation system. Alternator or mechanical generator.
 *
 * @param status Status flags.
 * @param generatorSpeed Speed of electrical generator or alternator. UINT16_MAX: field not
 * provided.
 * units = rpm
 * @param batteryCurrent Current into/out of battery. Positive for out. Negative for in. NaN: field
 * not provided.
 * units = A
 * @param loadCurrent Current going to the UAV. If battery current not available this is the DC
 * current from the generator. Positive for out. Negative for in. NaN: field not provided
 * units = A
 * @param powerGenerated The power being generated. NaN: field not provided
 * units = W
 * @param busVoltage Voltage of the bus seen at the generator, or battery bus if battery bus is
 * controlled by generator and at a different voltage to main bus.
 * units = V
 * @param rectifierTemperature The temperature of the rectifier or power converter. INT16_MAX: field
 * not provided.
 * units = degC
 * @param batCurrentSetpoint The target battery current. Positive for out. Negative for in. NaN:
 * field not provided
 * units = A
 * @param generatorTemperature The temperature of the mechanical motor, fuel cell core or generator.
 * INT16_MAX: field not provided.
 * units = degC
 * @param runtime Seconds this generator has run since it was rebooted. UINT32_MAX: field not
 * provided.
 * units = s
 * @param timeUntilMaintenance Seconds until this generator requires maintenance.  A negative value
 * indicates maintenance is past-due. INT32_MAX: field not provided.
 * units = s
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
   * units = rpm
   */
  @GeneratedMavField(type = "uint16_t")
  public val generatorSpeed: UShort = 0u,
  /**
   * Current into/out of battery. Positive for out. Negative for in. NaN: field not provided.
   * units = A
   */
  @GeneratedMavField(type = "float")
  public val batteryCurrent: Float = 0F,
  /**
   * Current going to the UAV. If battery current not available this is the DC current from the
   * generator. Positive for out. Negative for in. NaN: field not provided
   * units = A
   */
  @GeneratedMavField(type = "float")
  public val loadCurrent: Float = 0F,
  /**
   * The power being generated. NaN: field not provided
   * units = W
   */
  @GeneratedMavField(type = "float")
  public val powerGenerated: Float = 0F,
  /**
   * Voltage of the bus seen at the generator, or battery bus if battery bus is controlled by
   * generator and at a different voltage to main bus.
   * units = V
   */
  @GeneratedMavField(type = "float")
  public val busVoltage: Float = 0F,
  /**
   * The temperature of the rectifier or power converter. INT16_MAX: field not provided.
   * units = degC
   */
  @GeneratedMavField(type = "int16_t")
  public val rectifierTemperature: Short = 0,
  /**
   * The target battery current. Positive for out. Negative for in. NaN: field not provided
   * units = A
   */
  @GeneratedMavField(type = "float")
  public val batCurrentSetpoint: Float = 0F,
  /**
   * The temperature of the mechanical motor, fuel cell core or generator. INT16_MAX: field not
   * provided.
   * units = degC
   */
  @GeneratedMavField(type = "int16_t")
  public val generatorTemperature: Short = 0,
  /**
   * Seconds this generator has run since it was rebooted. UINT32_MAX: field not provided.
   * units = s
   */
  @GeneratedMavField(type = "uint32_t")
  public val runtime: UInt = 0u,
  /**
   * Seconds until this generator requires maintenance.  A negative value indicates maintenance is
   * past-due. INT32_MAX: field not provided.
   * units = s
   */
  @GeneratedMavField(type = "int32_t")
  public val timeUntilMaintenance: Int = 0,
) : MavMessage<GeneratorStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<GeneratorStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeBitmaskValue(status.value, 8)
    encoder.encodeFloat(batteryCurrent)
    encoder.encodeFloat(loadCurrent)
    encoder.encodeFloat(powerGenerated)
    encoder.encodeFloat(busVoltage)
    encoder.encodeFloat(batCurrentSetpoint)
    encoder.encodeUInt32(runtime)
    encoder.encodeInt32(timeUntilMaintenance)
    encoder.encodeUInt16(generatorSpeed)
    encoder.encodeInt16(rectifierTemperature)
    encoder.encodeInt16(generatorTemperature)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeBitmaskValue(status.value, 8)
    encoder.encodeFloat(batteryCurrent)
    encoder.encodeFloat(loadCurrent)
    encoder.encodeFloat(powerGenerated)
    encoder.encodeFloat(busVoltage)
    encoder.encodeFloat(batCurrentSetpoint)
    encoder.encodeUInt32(runtime)
    encoder.encodeInt32(timeUntilMaintenance)
    encoder.encodeUInt16(generatorSpeed)
    encoder.encodeInt16(rectifierTemperature)
    encoder.encodeInt16(generatorTemperature)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GeneratorStatus> {
    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    override val id: UInt = 373u

    override val crcExtra: Byte = 117

    override fun deserialize(bytes: ByteArray): GeneratorStatus {
      val decoder = MavDataDecoder(bytes)

      val status = decoder.safeDecodeBitmaskValue(8).let { value ->
        val flags = MavGeneratorStatusFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val batteryCurrent = decoder.safeDecodeFloat()
      val loadCurrent = decoder.safeDecodeFloat()
      val powerGenerated = decoder.safeDecodeFloat()
      val busVoltage = decoder.safeDecodeFloat()
      val batCurrentSetpoint = decoder.safeDecodeFloat()
      val runtime = decoder.safeDecodeUInt32()
      val timeUntilMaintenance = decoder.safeDecodeInt32()
      val generatorSpeed = decoder.safeDecodeUInt16()
      val rectifierTemperature = decoder.safeDecodeInt16()
      val generatorTemperature = decoder.safeDecodeInt16()

      return GeneratorStatus(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): GeneratorStatus =
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
