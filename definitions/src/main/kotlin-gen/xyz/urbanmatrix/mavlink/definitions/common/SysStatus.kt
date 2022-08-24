package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeInt8
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeInt8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16

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
  id = 1,
  crc = 124,
)
public data class SysStatus(
  /**
   * Bitmap showing which onboard controllers and sensors are present. Value of 0: not present.
   * Value of 1: present.
   */
  public val onboardControlSensorsPresent: MavEnumValue<MavSysStatusSensor> =
      MavEnumValue.fromValue(0),
  /**
   * Bitmap showing which onboard controllers and sensors are enabled:  Value of 0: not enabled.
   * Value of 1: enabled.
   */
  public val onboardControlSensorsEnabled: MavEnumValue<MavSysStatusSensor> =
      MavEnumValue.fromValue(0),
  /**
   * Bitmap showing which onboard controllers and sensors have an error (or are operational). Value
   * of 0: error. Value of 1: healthy.
   */
  public val onboardControlSensorsHealth: MavEnumValue<MavSysStatusSensor> =
      MavEnumValue.fromValue(0),
  /**
   * Maximum usage in percent of the mainloop time. Values: [0-1000] - should always be below 1000
   */
  public val load: Int = 0,
  /**
   * Battery voltage, UINT16_MAX: Voltage not sent by autopilot
   */
  public val voltageBattery: Int = 0,
  /**
   * Battery current, -1: Current not sent by autopilot
   */
  public val currentBattery: Int = 0,
  /**
   * Battery energy remaining, -1: Battery remaining energy not sent by autopilot
   */
  public val batteryRemaining: Int = 0,
  /**
   * Communication drop rate, (UART, I2C, SPI, CAN), dropped packets on all links (packets that were
   * corrupted on reception on the MAV)
   */
  public val dropRateComm: Int = 0,
  /**
   * Communication errors (UART, I2C, SPI, CAN), dropped packets on all links (packets that were
   * corrupted on reception on the MAV)
   */
  public val errorsComm: Int = 0,
  /**
   * Autopilot-specific errors
   */
  public val errorsCount1: Int = 0,
  /**
   * Autopilot-specific errors
   */
  public val errorsCount2: Int = 0,
  /**
   * Autopilot-specific errors
   */
  public val errorsCount3: Int = 0,
  /**
   * Autopilot-specific errors
   */
  public val errorsCount4: Int = 0,
  /**
   * Bitmap showing which onboard controllers and sensors are present. Value of 0: not present.
   * Value of 1: present.
   */
  public val onboardControlSensorsPresentExtended: MavEnumValue<MavSysStatusSensorExtended> =
      MavEnumValue.fromValue(0),
  /**
   * Bitmap showing which onboard controllers and sensors are enabled:  Value of 0: not enabled.
   * Value of 1: enabled.
   */
  public val onboardControlSensorsEnabledExtended: MavEnumValue<MavSysStatusSensorExtended> =
      MavEnumValue.fromValue(0),
  /**
   * Bitmap showing which onboard controllers and sensors have an error (or are operational). Value
   * of 0: error. Value of 1: healthy.
   */
  public val onboardControlSensorsHealthExtended: MavEnumValue<MavSysStatusSensorExtended> =
      MavEnumValue.fromValue(0),
) : MavMessage<SysStatus> {
  public override val instanceMetadata: MavMessage.Metadata<SysStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(onboardControlSensorsPresent.value, 4)
    outputBuffer.encodeEnumValue(onboardControlSensorsEnabled.value, 4)
    outputBuffer.encodeEnumValue(onboardControlSensorsHealth.value, 4)
    outputBuffer.encodeUint16(load)
    outputBuffer.encodeUint16(voltageBattery)
    outputBuffer.encodeInt16(currentBattery)
    outputBuffer.encodeUint16(dropRateComm)
    outputBuffer.encodeUint16(errorsComm)
    outputBuffer.encodeUint16(errorsCount1)
    outputBuffer.encodeUint16(errorsCount2)
    outputBuffer.encodeUint16(errorsCount3)
    outputBuffer.encodeUint16(errorsCount4)
    outputBuffer.encodeInt8(batteryRemaining)
    outputBuffer.encodeEnumValue(onboardControlSensorsPresentExtended.value, 4)
    outputBuffer.encodeEnumValue(onboardControlSensorsEnabledExtended.value, 4)
    outputBuffer.encodeEnumValue(onboardControlSensorsHealthExtended.value, 4)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 1

    private const val CRC: Int = 124

    private const val SIZE: Int = 43

    private val DESERIALIZER: MavDeserializer<SysStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val onboardControlSensorsPresent = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = MavSysStatusSensor.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val onboardControlSensorsEnabled = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = MavSysStatusSensor.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val onboardControlSensorsHealth = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = MavSysStatusSensor.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val load = inputBuffer.decodeUint16()
      val voltageBattery = inputBuffer.decodeUint16()
      val currentBattery = inputBuffer.decodeInt16()
      val dropRateComm = inputBuffer.decodeUint16()
      val errorsComm = inputBuffer.decodeUint16()
      val errorsCount1 = inputBuffer.decodeUint16()
      val errorsCount2 = inputBuffer.decodeUint16()
      val errorsCount3 = inputBuffer.decodeUint16()
      val errorsCount4 = inputBuffer.decodeUint16()
      val batteryRemaining = inputBuffer.decodeInt8()
      val onboardControlSensorsPresentExtended = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = MavSysStatusSensorExtended.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val onboardControlSensorsEnabledExtended = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = MavSysStatusSensorExtended.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val onboardControlSensorsHealthExtended = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = MavSysStatusSensorExtended.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
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


    private val METADATA: MavMessage.Metadata<SysStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SysStatus> = METADATA
  }
}
