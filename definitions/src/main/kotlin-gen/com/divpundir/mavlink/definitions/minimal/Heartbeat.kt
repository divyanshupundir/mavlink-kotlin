package com.divpundir.mavlink.definitions.minimal

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
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
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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
  public override val instanceCompanion: MavMessage.MavCompanion<Heartbeat> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(customMode)
    buffer.encodeEnumValue(type.value, 1)
    buffer.encodeEnumValue(autopilot.value, 1)
    buffer.encodeBitmaskValue(baseMode.value, 1)
    buffer.encodeEnumValue(systemStatus.value, 1)
    buffer.encodeUInt8(mavlinkVersion)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(customMode)
    buffer.encodeEnumValue(type.value, 1)
    buffer.encodeEnumValue(autopilot.value, 1)
    buffer.encodeBitmaskValue(baseMode.value, 1)
    buffer.encodeEnumValue(systemStatus.value, 1)
    buffer.encodeUInt8(mavlinkVersion)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Heartbeat> {
    public override val id: UInt = 0u

    public override val crcExtra: Byte = 50

    public override fun deserialize(bytes: ByteArray): Heartbeat {
      val buffer = Buffer().write(bytes)

      val customMode = buffer.decodeUInt32()
      val type = buffer.decodeEnumValue(1).let { value ->
        val entry = MavType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val autopilot = buffer.decodeEnumValue(1).let { value ->
        val entry = MavAutopilot.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val baseMode = buffer.decodeBitmaskValue(1).let { value ->
        val flags = MavModeFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val systemStatus = buffer.decodeEnumValue(1).let { value ->
        val entry = MavState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val mavlinkVersion = buffer.decodeUInt8()

      return Heartbeat(
        type = type,
        autopilot = autopilot,
        baseMode = baseMode,
        customMode = customMode,
        systemStatus = systemStatus,
        mavlinkVersion = mavlinkVersion,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Heartbeat =
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
