package com.divpundir.mavlink.definitions.minimal

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * The heartbeat message shows that a system or component is present and responding. The type and
 * autopilot fields (along with the message component id), allow the receiving system to treat further
 * messages from this system appropriately (e.g. by laying out the user interface based on the
 * autopilot). This microservice is documented at https://mavlink.io/en/services/heartbeat.html
 */
@GeneratedMavMessage(
  id = 0u,
  crcExtra = 50,
)
public data class Heartbeat(
  /**
   * Vehicle or component type. For a flight controller component the vehicle type (quadrotor,
   * helicopter, etc.). For other components the component type (e.g. camera, gimbal, etc.). This
   * should be used in preference to component id for identifying the component type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: MavEnumValue<MavType> = MavEnumValue.fromValue(0u),
  /**
   * Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight
   * controllers.
   */
  @GeneratedMavField(type = "uint8_t")
  public val autopilot: MavEnumValue<MavAutopilot> = MavEnumValue.fromValue(0u),
  /**
   * System mode bitmap.
   */
  @GeneratedMavField(type = "uint8_t")
  public val baseMode: MavBitmaskValue<MavModeFlag> = MavBitmaskValue.fromValue(0u),
  /**
   * A bitfield for use for autopilot-specific flags
   */
  @GeneratedMavField(type = "uint32_t")
  public val customMode: UInt = 0u,
  /**
   * System status flag.
   */
  @GeneratedMavField(type = "uint8_t")
  public val systemStatus: MavEnumValue<MavState> = MavEnumValue.fromValue(0u),
  /**
   * MAVLink version, not writable by user, gets added by protocol because of magic data type:
   * uint8_t_mavlink_version
   */
  @GeneratedMavField(type = "uint8_t_mavlink_version")
  public val mavlinkVersion: UByte = 0u,
) : MavMessage<Heartbeat> {
  public override val instanceMetadata: MavMessage.Metadata<Heartbeat> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(customMode)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeEnumValue(autopilot.value, 1)
    outputBuffer.encodeBitmaskValue(baseMode.value, 1)
    outputBuffer.encodeEnumValue(systemStatus.value, 1)
    outputBuffer.encodeUInt8(mavlinkVersion)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(customMode)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeEnumValue(autopilot.value, 1)
    outputBuffer.encodeBitmaskValue(baseMode.value, 1)
    outputBuffer.encodeEnumValue(systemStatus.value, 1)
    outputBuffer.encodeUInt8(mavlinkVersion)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 0u

    private const val CRC_EXTRA: Byte = 50

    private const val SIZE_V1: Int = 9

    private const val SIZE_V2: Int = 9

    private val DESERIALIZER: MavDeserializer<Heartbeat> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val customMode = inputBuffer.decodeUInt32()
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
      val mavlinkVersion = inputBuffer.decodeUInt8()

      Heartbeat(
        type = type,
        autopilot = autopilot,
        baseMode = baseMode,
        customMode = customMode,
        systemStatus = systemStatus,
        mavlinkVersion = mavlinkVersion,
      )
    }


    private val METADATA: MavMessage.Metadata<Heartbeat> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Heartbeat> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Heartbeat =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var type: MavEnumValue<MavType> = MavEnumValue.fromValue(0u)

    public var autopilot: MavEnumValue<MavAutopilot> = MavEnumValue.fromValue(0u)

    public var baseMode: MavBitmaskValue<MavModeFlag> = MavBitmaskValue.fromValue(0u)

    public var customMode: UInt = 0u

    public var systemStatus: MavEnumValue<MavState> = MavEnumValue.fromValue(0u)

    public var mavlinkVersion: UByte = 0u

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
