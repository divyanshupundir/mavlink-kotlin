package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * The general system state. If the system is following the MAVLink standard, the system state is
 * mainly defined by three orthogonal states/modes: The system mode, which is either LOCKED (motors
 * shut down and locked), MANUAL (system under RC control), GUIDED (system with autonomous position
 * control, position setpoint controlled manually) or AUTO (system guided by path/waypoint planner).
 * The NAV_MODE defined the current flight state: LIFTOFF (often an open-loop maneuver), LANDING,
 * WAYPOINTS or VECTOR. This represents the internal navigation state machine. The system status shows
 * whether the system is currently active or not and if an emergency occurred. During the CRITICAL and
 * EMERGENCY states the MAV is still considered to be active, but should start emergency procedures
 * autonomously. After a failure occurred it should first move from active to critical to allow manual
 * intervention and then move to emergency after a certain timeout.
 *
 * @param onboardControlSensorsPresent Bitmap showing which onboard controllers and sensors are
 * present. Value of 0: not present. Value of 1: present.
 * @param onboardControlSensorsEnabled Bitmap showing which onboard controllers and sensors are
 * enabled:  Value of 0: not enabled. Value of 1: enabled.
 * @param onboardControlSensorsHealth Bitmap showing which onboard controllers and sensors have an
 * error (or are operational). Value of 0: error. Value of 1: healthy.
 * @param load Maximum usage in percent of the mainloop time. Values: [0-1000] - should always be
 * below 1000
 * units = d%
 * @param voltageBattery Battery voltage, UINT16_MAX: Voltage not sent by autopilot
 * units = mV
 * @param currentBattery Battery current, -1: Current not sent by autopilot
 * units = cA
 * @param batteryRemaining Battery energy remaining, -1: Battery remaining energy not sent by
 * autopilot
 * units = %
 * @param dropRateComm Communication drop rate, (UART, I2C, SPI, CAN), dropped packets on all links
 * (packets that were corrupted on reception on the MAV)
 * units = c%
 * @param errorsComm Communication errors (UART, I2C, SPI, CAN), dropped packets on all links
 * (packets that were corrupted on reception on the MAV)
 * @param errorsCount1 Autopilot-specific errors
 * @param errorsCount2 Autopilot-specific errors
 * @param errorsCount3 Autopilot-specific errors
 * @param errorsCount4 Autopilot-specific errors
 * @param onboardControlSensorsPresentExtended Bitmap showing which onboard controllers and sensors
 * are present. Value of 0: not present. Value of 1: present.
 * @param onboardControlSensorsEnabledExtended Bitmap showing which onboard controllers and sensors
 * are enabled:  Value of 0: not enabled. Value of 1: enabled.
 * @param onboardControlSensorsHealthExtended Bitmap showing which onboard controllers and sensors
 * have an error (or are operational). Value of 0: error. Value of 1: healthy.
 */
@GeneratedMavMessage(
  id = 1u,
  crcExtra = 124,
)
public data class SysStatus(
  /**
   * Bitmap showing which onboard controllers and sensors are present. Value of 0: not present.
   * Value of 1: present.
   */
  @GeneratedMavField(type = "uint32_t")
  public val onboardControlSensorsPresent: MavBitmaskValue<MavSysStatusSensor> =
      MavBitmaskValue.fromValue(0u),
  /**
   * Bitmap showing which onboard controllers and sensors are enabled:  Value of 0: not enabled.
   * Value of 1: enabled.
   */
  @GeneratedMavField(type = "uint32_t")
  public val onboardControlSensorsEnabled: MavBitmaskValue<MavSysStatusSensor> =
      MavBitmaskValue.fromValue(0u),
  /**
   * Bitmap showing which onboard controllers and sensors have an error (or are operational). Value
   * of 0: error. Value of 1: healthy.
   */
  @GeneratedMavField(type = "uint32_t")
  public val onboardControlSensorsHealth: MavBitmaskValue<MavSysStatusSensor> =
      MavBitmaskValue.fromValue(0u),
  /**
   * Maximum usage in percent of the mainloop time. Values: [0-1000] - should always be below 1000
   * units = d%
   */
  @GeneratedMavField(type = "uint16_t")
  public val load: UShort = 0u,
  /**
   * Battery voltage, UINT16_MAX: Voltage not sent by autopilot
   * units = mV
   */
  @GeneratedMavField(type = "uint16_t")
  public val voltageBattery: UShort = 0u,
  /**
   * Battery current, -1: Current not sent by autopilot
   * units = cA
   */
  @GeneratedMavField(type = "int16_t")
  public val currentBattery: Short = 0,
  /**
   * Battery energy remaining, -1: Battery remaining energy not sent by autopilot
   * units = %
   */
  @GeneratedMavField(type = "int8_t")
  public val batteryRemaining: Byte = 0,
  /**
   * Communication drop rate, (UART, I2C, SPI, CAN), dropped packets on all links (packets that were
   * corrupted on reception on the MAV)
   * units = c%
   */
  @GeneratedMavField(type = "uint16_t")
  public val dropRateComm: UShort = 0u,
  /**
   * Communication errors (UART, I2C, SPI, CAN), dropped packets on all links (packets that were
   * corrupted on reception on the MAV)
   */
  @GeneratedMavField(type = "uint16_t")
  public val errorsComm: UShort = 0u,
  /**
   * Autopilot-specific errors
   */
  @GeneratedMavField(type = "uint16_t")
  public val errorsCount1: UShort = 0u,
  /**
   * Autopilot-specific errors
   */
  @GeneratedMavField(type = "uint16_t")
  public val errorsCount2: UShort = 0u,
  /**
   * Autopilot-specific errors
   */
  @GeneratedMavField(type = "uint16_t")
  public val errorsCount3: UShort = 0u,
  /**
   * Autopilot-specific errors
   */
  @GeneratedMavField(type = "uint16_t")
  public val errorsCount4: UShort = 0u,
  /**
   * Bitmap showing which onboard controllers and sensors are present. Value of 0: not present.
   * Value of 1: present.
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val onboardControlSensorsPresentExtended: MavBitmaskValue<MavSysStatusSensorExtended> =
      MavBitmaskValue.fromValue(0u),
  /**
   * Bitmap showing which onboard controllers and sensors are enabled:  Value of 0: not enabled.
   * Value of 1: enabled.
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val onboardControlSensorsEnabledExtended: MavBitmaskValue<MavSysStatusSensorExtended> =
      MavBitmaskValue.fromValue(0u),
  /**
   * Bitmap showing which onboard controllers and sensors have an error (or are operational). Value
   * of 0: error. Value of 1: healthy.
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val onboardControlSensorsHealthExtended: MavBitmaskValue<MavSysStatusSensorExtended> =
      MavBitmaskValue.fromValue(0u),
) : MavMessage<SysStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<SysStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeBitmaskValue(onboardControlSensorsPresent.value, 4)
    encoder.encodeBitmaskValue(onboardControlSensorsEnabled.value, 4)
    encoder.encodeBitmaskValue(onboardControlSensorsHealth.value, 4)
    encoder.encodeUInt16(load)
    encoder.encodeUInt16(voltageBattery)
    encoder.encodeInt16(currentBattery)
    encoder.encodeUInt16(dropRateComm)
    encoder.encodeUInt16(errorsComm)
    encoder.encodeUInt16(errorsCount1)
    encoder.encodeUInt16(errorsCount2)
    encoder.encodeUInt16(errorsCount3)
    encoder.encodeUInt16(errorsCount4)
    encoder.encodeInt8(batteryRemaining)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeBitmaskValue(onboardControlSensorsPresent.value, 4)
    encoder.encodeBitmaskValue(onboardControlSensorsEnabled.value, 4)
    encoder.encodeBitmaskValue(onboardControlSensorsHealth.value, 4)
    encoder.encodeUInt16(load)
    encoder.encodeUInt16(voltageBattery)
    encoder.encodeInt16(currentBattery)
    encoder.encodeUInt16(dropRateComm)
    encoder.encodeUInt16(errorsComm)
    encoder.encodeUInt16(errorsCount1)
    encoder.encodeUInt16(errorsCount2)
    encoder.encodeUInt16(errorsCount3)
    encoder.encodeUInt16(errorsCount4)
    encoder.encodeInt8(batteryRemaining)
    encoder.encodeBitmaskValue(onboardControlSensorsPresentExtended.value, 4)
    encoder.encodeBitmaskValue(onboardControlSensorsEnabledExtended.value, 4)
    encoder.encodeBitmaskValue(onboardControlSensorsHealthExtended.value, 4)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SysStatus> {
    private const val SIZE_V1: Int = 31

    private const val SIZE_V2: Int = 43

    override val id: UInt = 1u

    override val crcExtra: Byte = 124

    override fun deserialize(bytes: ByteArray): SysStatus {
      val decoder = MavDataDecoder(bytes)

      val onboardControlSensorsPresent = decoder.safeDecodeBitmaskValue(4).let { value ->
        val flags = MavSysStatusSensor.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val onboardControlSensorsEnabled = decoder.safeDecodeBitmaskValue(4).let { value ->
        val flags = MavSysStatusSensor.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val onboardControlSensorsHealth = decoder.safeDecodeBitmaskValue(4).let { value ->
        val flags = MavSysStatusSensor.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val load = decoder.safeDecodeUInt16()
      val voltageBattery = decoder.safeDecodeUInt16()
      val currentBattery = decoder.safeDecodeInt16()
      val dropRateComm = decoder.safeDecodeUInt16()
      val errorsComm = decoder.safeDecodeUInt16()
      val errorsCount1 = decoder.safeDecodeUInt16()
      val errorsCount2 = decoder.safeDecodeUInt16()
      val errorsCount3 = decoder.safeDecodeUInt16()
      val errorsCount4 = decoder.safeDecodeUInt16()
      val batteryRemaining = decoder.safeDecodeInt8()
      val onboardControlSensorsPresentExtended = decoder.safeDecodeBitmaskValue(4).let { value ->
        val flags = MavSysStatusSensorExtended.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val onboardControlSensorsEnabledExtended = decoder.safeDecodeBitmaskValue(4).let { value ->
        val flags = MavSysStatusSensorExtended.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val onboardControlSensorsHealthExtended = decoder.safeDecodeBitmaskValue(4).let { value ->
        val flags = MavSysStatusSensorExtended.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      return SysStatus(
        onboardControlSensorsPresent = onboardControlSensorsPresent,
        onboardControlSensorsEnabled = onboardControlSensorsEnabled,
        onboardControlSensorsHealth = onboardControlSensorsHealth,
        load = load,
        voltageBattery = voltageBattery,
        currentBattery = currentBattery,
        batteryRemaining = batteryRemaining,
        dropRateComm = dropRateComm,
        errorsComm = errorsComm,
        errorsCount1 = errorsCount1,
        errorsCount2 = errorsCount2,
        errorsCount3 = errorsCount3,
        errorsCount4 = errorsCount4,
        onboardControlSensorsPresentExtended = onboardControlSensorsPresentExtended,
        onboardControlSensorsEnabledExtended = onboardControlSensorsEnabledExtended,
        onboardControlSensorsHealthExtended = onboardControlSensorsHealthExtended,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SysStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var onboardControlSensorsPresent: MavBitmaskValue<MavSysStatusSensor> =
        MavBitmaskValue.fromValue(0u)

    public var onboardControlSensorsEnabled: MavBitmaskValue<MavSysStatusSensor> =
        MavBitmaskValue.fromValue(0u)

    public var onboardControlSensorsHealth: MavBitmaskValue<MavSysStatusSensor> =
        MavBitmaskValue.fromValue(0u)

    public var load: UShort = 0u

    public var voltageBattery: UShort = 0u

    public var currentBattery: Short = 0

    public var batteryRemaining: Byte = 0

    public var dropRateComm: UShort = 0u

    public var errorsComm: UShort = 0u

    public var errorsCount1: UShort = 0u

    public var errorsCount2: UShort = 0u

    public var errorsCount3: UShort = 0u

    public var errorsCount4: UShort = 0u

    public var onboardControlSensorsPresentExtended: MavBitmaskValue<MavSysStatusSensorExtended> =
        MavBitmaskValue.fromValue(0u)

    public var onboardControlSensorsEnabledExtended: MavBitmaskValue<MavSysStatusSensorExtended> =
        MavBitmaskValue.fromValue(0u)

    public var onboardControlSensorsHealthExtended: MavBitmaskValue<MavSysStatusSensorExtended> =
        MavBitmaskValue.fromValue(0u)

    public fun build(): SysStatus = SysStatus(
      onboardControlSensorsPresent = onboardControlSensorsPresent,
      onboardControlSensorsEnabled = onboardControlSensorsEnabled,
      onboardControlSensorsHealth = onboardControlSensorsHealth,
      load = load,
      voltageBattery = voltageBattery,
      currentBattery = currentBattery,
      batteryRemaining = batteryRemaining,
      dropRateComm = dropRateComm,
      errorsComm = errorsComm,
      errorsCount1 = errorsCount1,
      errorsCount2 = errorsCount2,
      errorsCount3 = errorsCount3,
      errorsCount4 = errorsCount4,
      onboardControlSensorsPresentExtended = onboardControlSensorsPresentExtended,
      onboardControlSensorsEnabledExtended = onboardControlSensorsEnabledExtended,
      onboardControlSensorsHealthExtended = onboardControlSensorsHealthExtended,
    )
  }
}
