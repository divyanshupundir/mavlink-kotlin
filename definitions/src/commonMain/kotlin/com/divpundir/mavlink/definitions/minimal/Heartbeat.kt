package com.divpundir.mavlink.definitions.minimal

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
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
 *
 * @param type Vehicle or component type. For a flight controller component the vehicle type
 * (quadrotor, helicopter, etc.). For other components the component type (e.g. camera, gimbal, etc.).
 * This should be used in preference to component id for identifying the component type.
 * @param autopilot Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not
 * flight controllers.
 * @param baseMode System mode bitmap.
 * @param customMode A bitfield for use for autopilot-specific flags
 * @param systemStatus System status flag.
 * @param mavlinkVersion MAVLink version, not writable by user, gets added by protocol because of
 * magic data type: uint8_t_mavlink_version
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
  override val instanceCompanion: MavMessage.MavCompanion<Heartbeat> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(customMode)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeEnumValue(autopilot.value, 1)
    encoder.encodeBitmaskValue(baseMode.value, 1)
    encoder.encodeEnumValue(systemStatus.value, 1)
    encoder.encodeUInt8(mavlinkVersion)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(customMode)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeEnumValue(autopilot.value, 1)
    encoder.encodeBitmaskValue(baseMode.value, 1)
    encoder.encodeEnumValue(systemStatus.value, 1)
    encoder.encodeUInt8(mavlinkVersion)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Heartbeat> {
    private const val SIZE_V1: Int = 9

    private const val SIZE_V2: Int = 9

    override val id: UInt = 0u

    override val crcExtra: Byte = 50

    override fun deserialize(bytes: ByteArray): Heartbeat {
      val decoder = MavDataDecoder(bytes)

      val customMode = decoder.safeDecodeUInt32()
      val type = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val autopilot = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavAutopilot.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val baseMode = decoder.safeDecodeBitmaskValue(1).let { value ->
        val flags = MavModeFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val systemStatus = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val mavlinkVersion = decoder.safeDecodeUInt8()

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
