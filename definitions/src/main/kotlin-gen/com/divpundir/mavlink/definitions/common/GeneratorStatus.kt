package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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
  public override val instanceCompanion: MavMessage.MavCompanion<GeneratorStatus> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeBitmaskValue(status.value, 8)
    output.encodeFloat(batteryCurrent)
    output.encodeFloat(loadCurrent)
    output.encodeFloat(powerGenerated)
    output.encodeFloat(busVoltage)
    output.encodeFloat(batCurrentSetpoint)
    output.encodeUInt32(runtime)
    output.encodeInt32(timeUntilMaintenance)
    output.encodeUInt16(generatorSpeed)
    output.encodeInt16(rectifierTemperature)
    output.encodeInt16(generatorTemperature)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeBitmaskValue(status.value, 8)
    output.encodeFloat(batteryCurrent)
    output.encodeFloat(loadCurrent)
    output.encodeFloat(powerGenerated)
    output.encodeFloat(busVoltage)
    output.encodeFloat(batCurrentSetpoint)
    output.encodeUInt32(runtime)
    output.encodeInt32(timeUntilMaintenance)
    output.encodeUInt16(generatorSpeed)
    output.encodeInt16(rectifierTemperature)
    output.encodeInt16(generatorTemperature)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<GeneratorStatus> {
    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    public override val id: UInt = 373u

    public override val crcExtra: Byte = 117

    public override fun deserialize(source: BufferedSource): GeneratorStatus {
      val status = source.decodeBitmaskValue(8).let { value ->
        val flags = MavGeneratorStatusFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val batteryCurrent = source.decodeFloat()
      val loadCurrent = source.decodeFloat()
      val powerGenerated = source.decodeFloat()
      val busVoltage = source.decodeFloat()
      val batCurrentSetpoint = source.decodeFloat()
      val runtime = source.decodeUInt32()
      val timeUntilMaintenance = source.decodeInt32()
      val generatorSpeed = source.decodeUInt16()
      val rectifierTemperature = source.decodeInt16()
      val generatorTemperature = source.decodeInt16()

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
