package com.divpundir.mavlink.definitions.loweheiser

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Composite EFI and Governor data from Loweheiser equipment.  This message is created by the EFI
 * unit based on its own data and data received from a governor attached to that EFI unit.
 *
 * @param voltBatt Generator Battery voltage.
 * units = V
 * @param currBatt Generator Battery current.
 * units = A
 * @param currGen Current being produced by generator.
 * units = A
 * @param currRot Load current being consumed by the UAV (sum of curr_gen and curr_batt)
 * units = A
 * @param fuelLevel Generator fuel remaining in litres.
 * units = l
 * @param throttle Throttle Output.
 * units = %
 * @param runtime Seconds this generator has run since it was rebooted.
 * units = s
 * @param untilMaintenance Seconds until this generator requires maintenance.  A negative value
 * indicates maintenance is past due.
 * units = s
 * @param rectifierTemp The Temperature of the rectifier.
 * units = degC
 * @param generatorTemp The temperature of the mechanical motor, fuel cell core or generator.
 * units = degC
 * @param efiBatt  EFI Supply Voltage.
 * units = V
 * @param efiRpm Motor RPM.
 * units = rpm
 * @param efiPw Injector pulse-width in milliseconds.
 * units = ms
 * @param efiFuelFlow Fuel flow rate in litres/hour.
 * @param efiFuelConsumed Fuel consumed.
 * units = l
 * @param efiBaro Atmospheric pressure.
 * units = kPa
 * @param efiMat Manifold Air Temperature.
 * units = degC
 * @param efiClt Cylinder Head Temperature.
 * units = degC
 * @param efiTps Throttle Position.
 * units = %
 * @param efiExhaustGasTemperature Exhaust gas temperature.
 * units = degC
 * @param efiIndex EFI index.
 * @param generatorStatus Generator status.
 * @param efiStatus EFI status.
 */
@GeneratedMavMessage(
  id = 10_151u,
  crcExtra = -61,
)
public data class LoweheiserGovEfi(
  /**
   * Generator Battery voltage.
   * units = V
   */
  @GeneratedMavField(type = "float")
  public val voltBatt: Float = 0F,
  /**
   * Generator Battery current.
   * units = A
   */
  @GeneratedMavField(type = "float")
  public val currBatt: Float = 0F,
  /**
   * Current being produced by generator.
   * units = A
   */
  @GeneratedMavField(type = "float")
  public val currGen: Float = 0F,
  /**
   * Load current being consumed by the UAV (sum of curr_gen and curr_batt)
   * units = A
   */
  @GeneratedMavField(type = "float")
  public val currRot: Float = 0F,
  /**
   * Generator fuel remaining in litres.
   * units = l
   */
  @GeneratedMavField(type = "float")
  public val fuelLevel: Float = 0F,
  /**
   * Throttle Output.
   * units = %
   */
  @GeneratedMavField(type = "float")
  public val throttle: Float = 0F,
  /**
   * Seconds this generator has run since it was rebooted.
   * units = s
   */
  @GeneratedMavField(type = "uint32_t")
  public val runtime: UInt = 0u,
  /**
   * Seconds until this generator requires maintenance.  A negative value indicates maintenance is
   * past due.
   * units = s
   */
  @GeneratedMavField(type = "int32_t")
  public val untilMaintenance: Int = 0,
  /**
   * The Temperature of the rectifier.
   * units = degC
   */
  @GeneratedMavField(type = "float")
  public val rectifierTemp: Float = 0F,
  /**
   * The temperature of the mechanical motor, fuel cell core or generator.
   * units = degC
   */
  @GeneratedMavField(type = "float")
  public val generatorTemp: Float = 0F,
  /**
   *  EFI Supply Voltage.
   * units = V
   */
  @GeneratedMavField(type = "float")
  public val efiBatt: Float = 0F,
  /**
   * Motor RPM.
   * units = rpm
   */
  @GeneratedMavField(type = "float")
  public val efiRpm: Float = 0F,
  /**
   * Injector pulse-width in milliseconds.
   * units = ms
   */
  @GeneratedMavField(type = "float")
  public val efiPw: Float = 0F,
  /**
   * Fuel flow rate in litres/hour.
   */
  @GeneratedMavField(type = "float")
  public val efiFuelFlow: Float = 0F,
  /**
   * Fuel consumed.
   * units = l
   */
  @GeneratedMavField(type = "float")
  public val efiFuelConsumed: Float = 0F,
  /**
   * Atmospheric pressure.
   * units = kPa
   */
  @GeneratedMavField(type = "float")
  public val efiBaro: Float = 0F,
  /**
   * Manifold Air Temperature.
   * units = degC
   */
  @GeneratedMavField(type = "float")
  public val efiMat: Float = 0F,
  /**
   * Cylinder Head Temperature.
   * units = degC
   */
  @GeneratedMavField(type = "float")
  public val efiClt: Float = 0F,
  /**
   * Throttle Position.
   * units = %
   */
  @GeneratedMavField(type = "float")
  public val efiTps: Float = 0F,
  /**
   * Exhaust gas temperature.
   * units = degC
   */
  @GeneratedMavField(type = "float")
  public val efiExhaustGasTemperature: Float = 0F,
  /**
   * EFI index.
   */
  @GeneratedMavField(type = "uint8_t")
  public val efiIndex: UByte = 0u,
  /**
   * Generator status.
   */
  @GeneratedMavField(type = "uint16_t")
  public val generatorStatus: UShort = 0u,
  /**
   * EFI status.
   */
  @GeneratedMavField(type = "uint16_t")
  public val efiStatus: UShort = 0u,
) : MavMessage<LoweheiserGovEfi> {
  override val instanceCompanion: MavMessage.MavCompanion<LoweheiserGovEfi> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(voltBatt)
    encoder.encodeFloat(currBatt)
    encoder.encodeFloat(currGen)
    encoder.encodeFloat(currRot)
    encoder.encodeFloat(fuelLevel)
    encoder.encodeFloat(throttle)
    encoder.encodeUInt32(runtime)
    encoder.encodeInt32(untilMaintenance)
    encoder.encodeFloat(rectifierTemp)
    encoder.encodeFloat(generatorTemp)
    encoder.encodeFloat(efiBatt)
    encoder.encodeFloat(efiRpm)
    encoder.encodeFloat(efiPw)
    encoder.encodeFloat(efiFuelFlow)
    encoder.encodeFloat(efiFuelConsumed)
    encoder.encodeFloat(efiBaro)
    encoder.encodeFloat(efiMat)
    encoder.encodeFloat(efiClt)
    encoder.encodeFloat(efiTps)
    encoder.encodeFloat(efiExhaustGasTemperature)
    encoder.encodeUInt16(generatorStatus)
    encoder.encodeUInt16(efiStatus)
    encoder.encodeUInt8(efiIndex)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(voltBatt)
    encoder.encodeFloat(currBatt)
    encoder.encodeFloat(currGen)
    encoder.encodeFloat(currRot)
    encoder.encodeFloat(fuelLevel)
    encoder.encodeFloat(throttle)
    encoder.encodeUInt32(runtime)
    encoder.encodeInt32(untilMaintenance)
    encoder.encodeFloat(rectifierTemp)
    encoder.encodeFloat(generatorTemp)
    encoder.encodeFloat(efiBatt)
    encoder.encodeFloat(efiRpm)
    encoder.encodeFloat(efiPw)
    encoder.encodeFloat(efiFuelFlow)
    encoder.encodeFloat(efiFuelConsumed)
    encoder.encodeFloat(efiBaro)
    encoder.encodeFloat(efiMat)
    encoder.encodeFloat(efiClt)
    encoder.encodeFloat(efiTps)
    encoder.encodeFloat(efiExhaustGasTemperature)
    encoder.encodeUInt16(generatorStatus)
    encoder.encodeUInt16(efiStatus)
    encoder.encodeUInt8(efiIndex)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LoweheiserGovEfi> {
    private const val SIZE_V1: Int = 85

    private const val SIZE_V2: Int = 85

    override val id: UInt = 10_151u

    override val crcExtra: Byte = -61

    override fun deserialize(bytes: ByteArray): LoweheiserGovEfi {
      val decoder = MavDataDecoder(bytes)

      val voltBatt = decoder.safeDecodeFloat()
      val currBatt = decoder.safeDecodeFloat()
      val currGen = decoder.safeDecodeFloat()
      val currRot = decoder.safeDecodeFloat()
      val fuelLevel = decoder.safeDecodeFloat()
      val throttle = decoder.safeDecodeFloat()
      val runtime = decoder.safeDecodeUInt32()
      val untilMaintenance = decoder.safeDecodeInt32()
      val rectifierTemp = decoder.safeDecodeFloat()
      val generatorTemp = decoder.safeDecodeFloat()
      val efiBatt = decoder.safeDecodeFloat()
      val efiRpm = decoder.safeDecodeFloat()
      val efiPw = decoder.safeDecodeFloat()
      val efiFuelFlow = decoder.safeDecodeFloat()
      val efiFuelConsumed = decoder.safeDecodeFloat()
      val efiBaro = decoder.safeDecodeFloat()
      val efiMat = decoder.safeDecodeFloat()
      val efiClt = decoder.safeDecodeFloat()
      val efiTps = decoder.safeDecodeFloat()
      val efiExhaustGasTemperature = decoder.safeDecodeFloat()
      val generatorStatus = decoder.safeDecodeUInt16()
      val efiStatus = decoder.safeDecodeUInt16()
      val efiIndex = decoder.safeDecodeUInt8()

      return LoweheiserGovEfi(
        voltBatt = voltBatt,
        currBatt = currBatt,
        currGen = currGen,
        currRot = currRot,
        fuelLevel = fuelLevel,
        throttle = throttle,
        runtime = runtime,
        untilMaintenance = untilMaintenance,
        rectifierTemp = rectifierTemp,
        generatorTemp = generatorTemp,
        efiBatt = efiBatt,
        efiRpm = efiRpm,
        efiPw = efiPw,
        efiFuelFlow = efiFuelFlow,
        efiFuelConsumed = efiFuelConsumed,
        efiBaro = efiBaro,
        efiMat = efiMat,
        efiClt = efiClt,
        efiTps = efiTps,
        efiExhaustGasTemperature = efiExhaustGasTemperature,
        efiIndex = efiIndex,
        generatorStatus = generatorStatus,
        efiStatus = efiStatus,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): LoweheiserGovEfi =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var voltBatt: Float = 0F

    public var currBatt: Float = 0F

    public var currGen: Float = 0F

    public var currRot: Float = 0F

    public var fuelLevel: Float = 0F

    public var throttle: Float = 0F

    public var runtime: UInt = 0u

    public var untilMaintenance: Int = 0

    public var rectifierTemp: Float = 0F

    public var generatorTemp: Float = 0F

    public var efiBatt: Float = 0F

    public var efiRpm: Float = 0F

    public var efiPw: Float = 0F

    public var efiFuelFlow: Float = 0F

    public var efiFuelConsumed: Float = 0F

    public var efiBaro: Float = 0F

    public var efiMat: Float = 0F

    public var efiClt: Float = 0F

    public var efiTps: Float = 0F

    public var efiExhaustGasTemperature: Float = 0F

    public var efiIndex: UByte = 0u

    public var generatorStatus: UShort = 0u

    public var efiStatus: UShort = 0u

    public fun build(): LoweheiserGovEfi = LoweheiserGovEfi(
      voltBatt = voltBatt,
      currBatt = currBatt,
      currGen = currGen,
      currRot = currRot,
      fuelLevel = fuelLevel,
      throttle = throttle,
      runtime = runtime,
      untilMaintenance = untilMaintenance,
      rectifierTemp = rectifierTemp,
      generatorTemp = generatorTemp,
      efiBatt = efiBatt,
      efiRpm = efiRpm,
      efiPw = efiPw,
      efiFuelFlow = efiFuelFlow,
      efiFuelConsumed = efiFuelConsumed,
      efiBaro = efiBaro,
      efiMat = efiMat,
      efiClt = efiClt,
      efiTps = efiTps,
      efiExhaustGasTemperature = efiExhaustGasTemperature,
      efiIndex = efiIndex,
      generatorStatus = generatorStatus,
      efiStatus = efiStatus,
    )
  }
}
