package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeInt8
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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
   */
  @GeneratedMavField(type = "uint16_t")
  public val load: UShort = 0u,
  /**
   * Battery voltage, UINT16_MAX: Voltage not sent by autopilot
   */
  @GeneratedMavField(type = "uint16_t")
  public val voltageBattery: UShort = 0u,
  /**
   * Battery current, -1: Current not sent by autopilot
   */
  @GeneratedMavField(type = "int16_t")
  public val currentBattery: Short = 0,
  /**
   * Battery energy remaining, -1: Battery remaining energy not sent by autopilot
   */
  @GeneratedMavField(type = "int8_t")
  public val batteryRemaining: Byte = 0,
  /**
   * Communication drop rate, (UART, I2C, SPI, CAN), dropped packets on all links (packets that were
   * corrupted on reception on the MAV)
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
  public override val instanceCompanion: MavMessage.MavCompanion<SysStatus> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeBitmaskValue(onboardControlSensorsPresent.value, 4)
    output.encodeBitmaskValue(onboardControlSensorsEnabled.value, 4)
    output.encodeBitmaskValue(onboardControlSensorsHealth.value, 4)
    output.encodeUInt16(load)
    output.encodeUInt16(voltageBattery)
    output.encodeInt16(currentBattery)
    output.encodeUInt16(dropRateComm)
    output.encodeUInt16(errorsComm)
    output.encodeUInt16(errorsCount1)
    output.encodeUInt16(errorsCount2)
    output.encodeUInt16(errorsCount3)
    output.encodeUInt16(errorsCount4)
    output.encodeInt8(batteryRemaining)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeBitmaskValue(onboardControlSensorsPresent.value, 4)
    output.encodeBitmaskValue(onboardControlSensorsEnabled.value, 4)
    output.encodeBitmaskValue(onboardControlSensorsHealth.value, 4)
    output.encodeUInt16(load)
    output.encodeUInt16(voltageBattery)
    output.encodeInt16(currentBattery)
    output.encodeUInt16(dropRateComm)
    output.encodeUInt16(errorsComm)
    output.encodeUInt16(errorsCount1)
    output.encodeUInt16(errorsCount2)
    output.encodeUInt16(errorsCount3)
    output.encodeUInt16(errorsCount4)
    output.encodeInt8(batteryRemaining)
    output.encodeBitmaskValue(onboardControlSensorsPresentExtended.value, 4)
    output.encodeBitmaskValue(onboardControlSensorsEnabledExtended.value, 4)
    output.encodeBitmaskValue(onboardControlSensorsHealthExtended.value, 4)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SysStatus> {
    private const val SIZE_V1: Int = 31

    private const val SIZE_V2: Int = 43

    public override val id: UInt = 1u

    public override val crcExtra: Byte = 124

    public override fun deserialize(source: BufferedSource): SysStatus {
      val onboardControlSensorsPresent = source.decodeBitmaskValue(4).let { value ->
        val flags = MavSysStatusSensor.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val onboardControlSensorsEnabled = source.decodeBitmaskValue(4).let { value ->
        val flags = MavSysStatusSensor.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val onboardControlSensorsHealth = source.decodeBitmaskValue(4).let { value ->
        val flags = MavSysStatusSensor.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val load = source.decodeUInt16()
      val voltageBattery = source.decodeUInt16()
      val currentBattery = source.decodeInt16()
      val dropRateComm = source.decodeUInt16()
      val errorsComm = source.decodeUInt16()
      val errorsCount1 = source.decodeUInt16()
      val errorsCount2 = source.decodeUInt16()
      val errorsCount3 = source.decodeUInt16()
      val errorsCount4 = source.decodeUInt16()
      val batteryRemaining = source.decodeInt8()
      val onboardControlSensorsPresentExtended = source.decodeBitmaskValue(4).let { value ->
        val flags = MavSysStatusSensorExtended.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val onboardControlSensorsEnabledExtended = source.decodeBitmaskValue(4).let { value ->
        val flags = MavSysStatusSensorExtended.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val onboardControlSensorsHealthExtended = source.decodeBitmaskValue(4).let { value ->
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
