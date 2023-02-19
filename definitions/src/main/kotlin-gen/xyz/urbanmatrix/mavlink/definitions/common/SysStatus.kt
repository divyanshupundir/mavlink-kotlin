package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
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
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeInt8
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16
import xyz.urbanmatrix.mavlink.serialization.encodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeInt8
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  public override val instanceMetadata: MavMessage.Metadata<SysStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeBitmaskValue(onboardControlSensorsPresent.value, 4)
    outputBuffer.encodeBitmaskValue(onboardControlSensorsEnabled.value, 4)
    outputBuffer.encodeBitmaskValue(onboardControlSensorsHealth.value, 4)
    outputBuffer.encodeUInt16(load)
    outputBuffer.encodeUInt16(voltageBattery)
    outputBuffer.encodeInt16(currentBattery)
    outputBuffer.encodeUInt16(dropRateComm)
    outputBuffer.encodeUInt16(errorsComm)
    outputBuffer.encodeUInt16(errorsCount1)
    outputBuffer.encodeUInt16(errorsCount2)
    outputBuffer.encodeUInt16(errorsCount3)
    outputBuffer.encodeUInt16(errorsCount4)
    outputBuffer.encodeInt8(batteryRemaining)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeBitmaskValue(onboardControlSensorsPresent.value, 4)
    outputBuffer.encodeBitmaskValue(onboardControlSensorsEnabled.value, 4)
    outputBuffer.encodeBitmaskValue(onboardControlSensorsHealth.value, 4)
    outputBuffer.encodeUInt16(load)
    outputBuffer.encodeUInt16(voltageBattery)
    outputBuffer.encodeInt16(currentBattery)
    outputBuffer.encodeUInt16(dropRateComm)
    outputBuffer.encodeUInt16(errorsComm)
    outputBuffer.encodeUInt16(errorsCount1)
    outputBuffer.encodeUInt16(errorsCount2)
    outputBuffer.encodeUInt16(errorsCount3)
    outputBuffer.encodeUInt16(errorsCount4)
    outputBuffer.encodeInt8(batteryRemaining)
    outputBuffer.encodeBitmaskValue(onboardControlSensorsPresentExtended.value, 4)
    outputBuffer.encodeBitmaskValue(onboardControlSensorsEnabledExtended.value, 4)
    outputBuffer.encodeBitmaskValue(onboardControlSensorsHealthExtended.value, 4)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 1u

    private const val CRC_EXTRA: Byte = 124

    private const val SIZE_V1: Int = 31

    private const val SIZE_V2: Int = 43

    private val DESERIALIZER: MavDeserializer<SysStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val onboardControlSensorsPresent = inputBuffer.decodeBitmaskValue(4).let { value ->
        val flags = MavSysStatusSensor.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val onboardControlSensorsEnabled = inputBuffer.decodeBitmaskValue(4).let { value ->
        val flags = MavSysStatusSensor.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val onboardControlSensorsHealth = inputBuffer.decodeBitmaskValue(4).let { value ->
        val flags = MavSysStatusSensor.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val load = inputBuffer.decodeUInt16()
      val voltageBattery = inputBuffer.decodeUInt16()
      val currentBattery = inputBuffer.decodeInt16()
      val dropRateComm = inputBuffer.decodeUInt16()
      val errorsComm = inputBuffer.decodeUInt16()
      val errorsCount1 = inputBuffer.decodeUInt16()
      val errorsCount2 = inputBuffer.decodeUInt16()
      val errorsCount3 = inputBuffer.decodeUInt16()
      val errorsCount4 = inputBuffer.decodeUInt16()
      val batteryRemaining = inputBuffer.decodeInt8()
      val onboardControlSensorsPresentExtended = inputBuffer.decodeBitmaskValue(4).let { value ->
        val flags = MavSysStatusSensorExtended.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val onboardControlSensorsEnabledExtended = inputBuffer.decodeBitmaskValue(4).let { value ->
        val flags = MavSysStatusSensorExtended.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val onboardControlSensorsHealthExtended = inputBuffer.decodeBitmaskValue(4).let { value ->
        val flags = MavSysStatusSensorExtended.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      SysStatus(
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


    private val METADATA: MavMessage.Metadata<SysStatus> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SysStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SysStatus =
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
