package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * EFI status output
 */
@GeneratedMavMessage(
  id = 225u,
  crcExtra = -48,
)
public data class EfiStatus(
  /**
   * EFI health status
   */
  @GeneratedMavField(type = "uint8_t")
  public val health: UByte = 0u,
  /**
   * ECU index
   */
  @GeneratedMavField(type = "float")
  public val ecuIndex: Float = 0F,
  /**
   * RPM
   */
  @GeneratedMavField(type = "float")
  public val rpm: Float = 0F,
  /**
   * Fuel consumed
   */
  @GeneratedMavField(type = "float")
  public val fuelConsumed: Float = 0F,
  /**
   * Fuel flow rate
   */
  @GeneratedMavField(type = "float")
  public val fuelFlow: Float = 0F,
  /**
   * Engine load
   */
  @GeneratedMavField(type = "float")
  public val engineLoad: Float = 0F,
  /**
   * Throttle position
   */
  @GeneratedMavField(type = "float")
  public val throttlePosition: Float = 0F,
  /**
   * Spark dwell time
   */
  @GeneratedMavField(type = "float")
  public val sparkDwellTime: Float = 0F,
  /**
   * Barometric pressure
   */
  @GeneratedMavField(type = "float")
  public val barometricPressure: Float = 0F,
  /**
   * Intake manifold pressure(
   */
  @GeneratedMavField(type = "float")
  public val intakeManifoldPressure: Float = 0F,
  /**
   * Intake manifold temperature
   */
  @GeneratedMavField(type = "float")
  public val intakeManifoldTemperature: Float = 0F,
  /**
   * Cylinder head temperature
   */
  @GeneratedMavField(type = "float")
  public val cylinderHeadTemperature: Float = 0F,
  /**
   * Ignition timing (Crank angle degrees)
   */
  @GeneratedMavField(type = "float")
  public val ignitionTiming: Float = 0F,
  /**
   * Injection time
   */
  @GeneratedMavField(type = "float")
  public val injectionTime: Float = 0F,
  /**
   * Exhaust gas temperature
   */
  @GeneratedMavField(type = "float")
  public val exhaustGasTemperature: Float = 0F,
  /**
   * Output throttle
   */
  @GeneratedMavField(type = "float")
  public val throttleOut: Float = 0F,
  /**
   * Pressure/temperature compensation
   */
  @GeneratedMavField(type = "float")
  public val ptCompensation: Float = 0F,
  /**
   * Supply voltage to EFI sparking system.  Zero in this value means "unknown", so if the supply
   * voltage really is zero volts use 0.0001 instead.
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val ignitionVoltage: Float = 0F,
) : MavMessage<EfiStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<EfiStatus> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(ecuIndex)
    output.encodeFloat(rpm)
    output.encodeFloat(fuelConsumed)
    output.encodeFloat(fuelFlow)
    output.encodeFloat(engineLoad)
    output.encodeFloat(throttlePosition)
    output.encodeFloat(sparkDwellTime)
    output.encodeFloat(barometricPressure)
    output.encodeFloat(intakeManifoldPressure)
    output.encodeFloat(intakeManifoldTemperature)
    output.encodeFloat(cylinderHeadTemperature)
    output.encodeFloat(ignitionTiming)
    output.encodeFloat(injectionTime)
    output.encodeFloat(exhaustGasTemperature)
    output.encodeFloat(throttleOut)
    output.encodeFloat(ptCompensation)
    output.encodeUInt8(health)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(ecuIndex)
    output.encodeFloat(rpm)
    output.encodeFloat(fuelConsumed)
    output.encodeFloat(fuelFlow)
    output.encodeFloat(engineLoad)
    output.encodeFloat(throttlePosition)
    output.encodeFloat(sparkDwellTime)
    output.encodeFloat(barometricPressure)
    output.encodeFloat(intakeManifoldPressure)
    output.encodeFloat(intakeManifoldTemperature)
    output.encodeFloat(cylinderHeadTemperature)
    output.encodeFloat(ignitionTiming)
    output.encodeFloat(injectionTime)
    output.encodeFloat(exhaustGasTemperature)
    output.encodeFloat(throttleOut)
    output.encodeFloat(ptCompensation)
    output.encodeUInt8(health)
    output.encodeFloat(ignitionVoltage)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<EfiStatus> {
    private const val SIZE_V1: Int = 65

    private const val SIZE_V2: Int = 69

    public override val id: UInt = 225u

    public override val crcExtra: Byte = -48

    public override fun deserialize(source: BufferedSource): EfiStatus {
      val ecuIndex = source.decodeFloat()
      val rpm = source.decodeFloat()
      val fuelConsumed = source.decodeFloat()
      val fuelFlow = source.decodeFloat()
      val engineLoad = source.decodeFloat()
      val throttlePosition = source.decodeFloat()
      val sparkDwellTime = source.decodeFloat()
      val barometricPressure = source.decodeFloat()
      val intakeManifoldPressure = source.decodeFloat()
      val intakeManifoldTemperature = source.decodeFloat()
      val cylinderHeadTemperature = source.decodeFloat()
      val ignitionTiming = source.decodeFloat()
      val injectionTime = source.decodeFloat()
      val exhaustGasTemperature = source.decodeFloat()
      val throttleOut = source.decodeFloat()
      val ptCompensation = source.decodeFloat()
      val health = source.decodeUInt8()
      val ignitionVoltage = source.decodeFloat()

      return EfiStatus(
        health = health,
        ecuIndex = ecuIndex,
        rpm = rpm,
        fuelConsumed = fuelConsumed,
        fuelFlow = fuelFlow,
        engineLoad = engineLoad,
        throttlePosition = throttlePosition,
        sparkDwellTime = sparkDwellTime,
        barometricPressure = barometricPressure,
        intakeManifoldPressure = intakeManifoldPressure,
        intakeManifoldTemperature = intakeManifoldTemperature,
        cylinderHeadTemperature = cylinderHeadTemperature,
        ignitionTiming = ignitionTiming,
        injectionTime = injectionTime,
        exhaustGasTemperature = exhaustGasTemperature,
        throttleOut = throttleOut,
        ptCompensation = ptCompensation,
        ignitionVoltage = ignitionVoltage,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): EfiStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var health: UByte = 0u

    public var ecuIndex: Float = 0F

    public var rpm: Float = 0F

    public var fuelConsumed: Float = 0F

    public var fuelFlow: Float = 0F

    public var engineLoad: Float = 0F

    public var throttlePosition: Float = 0F

    public var sparkDwellTime: Float = 0F

    public var barometricPressure: Float = 0F

    public var intakeManifoldPressure: Float = 0F

    public var intakeManifoldTemperature: Float = 0F

    public var cylinderHeadTemperature: Float = 0F

    public var ignitionTiming: Float = 0F

    public var injectionTime: Float = 0F

    public var exhaustGasTemperature: Float = 0F

    public var throttleOut: Float = 0F

    public var ptCompensation: Float = 0F

    public var ignitionVoltage: Float = 0F

    public fun build(): EfiStatus = EfiStatus(
      health = health,
      ecuIndex = ecuIndex,
      rpm = rpm,
      fuelConsumed = fuelConsumed,
      fuelFlow = fuelFlow,
      engineLoad = engineLoad,
      throttlePosition = throttlePosition,
      sparkDwellTime = sparkDwellTime,
      barometricPressure = barometricPressure,
      intakeManifoldPressure = intakeManifoldPressure,
      intakeManifoldTemperature = intakeManifoldTemperature,
      cylinderHeadTemperature = cylinderHeadTemperature,
      ignitionTiming = ignitionTiming,
      injectionTime = injectionTime,
      exhaustGasTemperature = exhaustGasTemperature,
      throttleOut = throttleOut,
      ptCompensation = ptCompensation,
      ignitionVoltage = ignitionVoltage,
    )
  }
}
