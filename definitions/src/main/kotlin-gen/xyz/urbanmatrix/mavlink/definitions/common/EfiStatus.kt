package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * EFI status output
 */
@GeneratedMavMessage(
  id = 225,
  crc = 208,
)
public data class EfiStatus(
  /**
   * EFI health status
   */
  @GeneratedMavField(type = "uint8_t")
  public val health: Int = 0,
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
  public override val instanceMetadata: MavMessage.Metadata<EfiStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(ecuIndex)
    outputBuffer.encodeFloat(rpm)
    outputBuffer.encodeFloat(fuelConsumed)
    outputBuffer.encodeFloat(fuelFlow)
    outputBuffer.encodeFloat(engineLoad)
    outputBuffer.encodeFloat(throttlePosition)
    outputBuffer.encodeFloat(sparkDwellTime)
    outputBuffer.encodeFloat(barometricPressure)
    outputBuffer.encodeFloat(intakeManifoldPressure)
    outputBuffer.encodeFloat(intakeManifoldTemperature)
    outputBuffer.encodeFloat(cylinderHeadTemperature)
    outputBuffer.encodeFloat(ignitionTiming)
    outputBuffer.encodeFloat(injectionTime)
    outputBuffer.encodeFloat(exhaustGasTemperature)
    outputBuffer.encodeFloat(throttleOut)
    outputBuffer.encodeFloat(ptCompensation)
    outputBuffer.encodeUint8(health)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(ecuIndex)
    outputBuffer.encodeFloat(rpm)
    outputBuffer.encodeFloat(fuelConsumed)
    outputBuffer.encodeFloat(fuelFlow)
    outputBuffer.encodeFloat(engineLoad)
    outputBuffer.encodeFloat(throttlePosition)
    outputBuffer.encodeFloat(sparkDwellTime)
    outputBuffer.encodeFloat(barometricPressure)
    outputBuffer.encodeFloat(intakeManifoldPressure)
    outputBuffer.encodeFloat(intakeManifoldTemperature)
    outputBuffer.encodeFloat(cylinderHeadTemperature)
    outputBuffer.encodeFloat(ignitionTiming)
    outputBuffer.encodeFloat(injectionTime)
    outputBuffer.encodeFloat(exhaustGasTemperature)
    outputBuffer.encodeFloat(throttleOut)
    outputBuffer.encodeFloat(ptCompensation)
    outputBuffer.encodeUint8(health)
    outputBuffer.encodeFloat(ignitionVoltage)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 225

    private const val CRC: Int = 208

    private const val SIZE_V1: Int = 65

    private const val SIZE_V2: Int = 69

    private val DESERIALIZER: MavDeserializer<EfiStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val ecuIndex = inputBuffer.decodeFloat()
      val rpm = inputBuffer.decodeFloat()
      val fuelConsumed = inputBuffer.decodeFloat()
      val fuelFlow = inputBuffer.decodeFloat()
      val engineLoad = inputBuffer.decodeFloat()
      val throttlePosition = inputBuffer.decodeFloat()
      val sparkDwellTime = inputBuffer.decodeFloat()
      val barometricPressure = inputBuffer.decodeFloat()
      val intakeManifoldPressure = inputBuffer.decodeFloat()
      val intakeManifoldTemperature = inputBuffer.decodeFloat()
      val cylinderHeadTemperature = inputBuffer.decodeFloat()
      val ignitionTiming = inputBuffer.decodeFloat()
      val injectionTime = inputBuffer.decodeFloat()
      val exhaustGasTemperature = inputBuffer.decodeFloat()
      val throttleOut = inputBuffer.decodeFloat()
      val ptCompensation = inputBuffer.decodeFloat()
      val health = inputBuffer.decodeUint8()
      val ignitionVoltage = inputBuffer.decodeFloat()

      EfiStatus(
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


    private val METADATA: MavMessage.Metadata<EfiStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<EfiStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): EfiStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var health: Int = 0

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
