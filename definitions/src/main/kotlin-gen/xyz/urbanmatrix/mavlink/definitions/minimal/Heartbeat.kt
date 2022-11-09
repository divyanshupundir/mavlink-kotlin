package xyz.urbanmatrix.mavlink.definitions.minimal

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavBitmaskValue
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * The heartbeat message shows that a system or component is present and responding. The type and
 * autopilot fields (along with the message component id), allow the receiving system to treat further
 * messages from this system appropriately (e.g. by laying out the user interface based on the
 * autopilot). This microservice is documented at https://mavlink.io/en/services/heartbeat.html
 */
@GeneratedMavMessage(
  id = 0,
  crc = 50,
)
public data class Heartbeat(
  /**
   * Vehicle or component type. For a flight controller component the vehicle type (quadrotor,
   * helicopter, etc.). For other components the component type (e.g. camera, gimbal, etc.). This
   * should be used in preference to component id for identifying the component type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: MavEnumValue<MavType> = MavEnumValue.fromValue(0),
  /**
   * Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight
   * controllers.
   */
  @GeneratedMavField(type = "uint8_t")
  public val autopilot: MavEnumValue<MavAutopilot> = MavEnumValue.fromValue(0),
  /**
   * System mode bitmap.
   */
  @GeneratedMavField(type = "uint8_t")
  public val baseMode: MavBitmaskValue<MavModeFlag> = MavBitmaskValue.fromValue(0),
  /**
   * A bitfield for use for autopilot-specific flags
   */
  @GeneratedMavField(type = "uint32_t")
  public val customMode: Long = 0L,
  /**
   * System status flag.
   */
  @GeneratedMavField(type = "uint8_t")
  public val systemStatus: MavEnumValue<MavState> = MavEnumValue.fromValue(0),
  /**
   * MAVLink version, not writable by user, gets added by protocol because of magic data type:
   * uint8_t_mavlink_version
   */
  @GeneratedMavField(type = "uint8_t_mavlink_version")
  public val mavlinkVersion: Int = 0,
) : MavMessage<Heartbeat> {
  public override val instanceMetadata: MavMessage.Metadata<Heartbeat> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(customMode)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeEnumValue(autopilot.value, 1)
    outputBuffer.encodeBitmaskValue(baseMode.value, 1)
    outputBuffer.encodeEnumValue(systemStatus.value, 1)
    outputBuffer.encodeUint8(mavlinkVersion)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(customMode)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeEnumValue(autopilot.value, 1)
    outputBuffer.encodeBitmaskValue(baseMode.value, 1)
    outputBuffer.encodeEnumValue(systemStatus.value, 1)
    outputBuffer.encodeUint8(mavlinkVersion)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 0

    private const val CRC: Int = 50

    private const val SIZE_V1: Int = 9

    private const val SIZE_V2: Int = 9

    private val DESERIALIZER: MavDeserializer<Heartbeat> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val customMode = inputBuffer.decodeUint32()
      val type = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val autopilot = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavAutopilot.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val baseMode = inputBuffer.decodeBitmaskValue(1).let { value ->
        val flags = MavModeFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val systemStatus = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val mavlinkVersion = inputBuffer.decodeUint8()

      Heartbeat(
        type = type,
        autopilot = autopilot,
        baseMode = baseMode,
        customMode = customMode,
        systemStatus = systemStatus,
        mavlinkVersion = mavlinkVersion,
      )
    }


    private val METADATA: MavMessage.Metadata<Heartbeat> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Heartbeat> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var type: MavEnumValue<MavType> = MavEnumValue.fromValue(0)

    public var autopilot: MavEnumValue<MavAutopilot> = MavEnumValue.fromValue(0)

    public var baseMode: MavBitmaskValue<MavModeFlag> = MavBitmaskValue.fromValue(0)

    public var customMode: Long = 0L

    public var systemStatus: MavEnumValue<MavState> = MavEnumValue.fromValue(0)

    public var mavlinkVersion: Int = 0

    public fun build(): Heartbeat = Heartbeat(
      type = type,
      autopilot = autopilot,
      baseMode = baseMode,
      customMode = customMode,
      systemStatus = systemStatus,
      mavlinkVersion = mavlinkVersion,
    )
  }
}
