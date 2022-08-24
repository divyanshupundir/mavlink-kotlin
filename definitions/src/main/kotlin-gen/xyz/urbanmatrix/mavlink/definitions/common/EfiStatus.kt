package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

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
  public val health: Int = 0,
  /**
   * ECU index
   */
  public val ecuIndex: Float = 0F,
  /**
   * RPM
   */
  public val rpm: Float = 0F,
  /**
   * Fuel consumed
   */
  public val fuelConsumed: Float = 0F,
  /**
   * Fuel flow rate
   */
  public val fuelFlow: Float = 0F,
  /**
   * Engine load
   */
  public val engineLoad: Float = 0F,
  /**
   * Throttle position
   */
  public val throttlePosition: Float = 0F,
  /**
   * Spark dwell time
   */
  public val sparkDwellTime: Float = 0F,
  /**
   * Barometric pressure
   */
  public val barometricPressure: Float = 0F,
  /**
   * Intake manifold pressure(
   */
  public val intakeManifoldPressure: Float = 0F,
  /**
   * Intake manifold temperature
   */
  public val intakeManifoldTemperature: Float = 0F,
  /**
   * Cylinder head temperature
   */
  public val cylinderHeadTemperature: Float = 0F,
  /**
   * Ignition timing (Crank angle degrees)
   */
  public val ignitionTiming: Float = 0F,
  /**
   * Injection time
   */
  public val injectionTime: Float = 0F,
  /**
   * Exhaust gas temperature
   */
  public val exhaustGasTemperature: Float = 0F,
  /**
   * Output throttle
   */
  public val throttleOut: Float = 0F,
  /**
   * Pressure/temperature compensation
   */
  public val ptCompensation: Float = 0F,
  /**
   * Supply voltage to EFI sparking system.  Zero in this value means "unknown", so if the supply
   * voltage really is zero volts use 0.0001 instead.
   */
  public val ignitionVoltage: Float = 0F,
) : MavMessage<EfiStatus> {
  public override val instanceMetadata: MavMessage.Metadata<EfiStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
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
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 225

    private const val CRC: Int = 208

    private const val SIZE: Int = 69

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
  }
}
