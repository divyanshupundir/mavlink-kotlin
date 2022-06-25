package com.urbanmatrix.mavlink.minimal

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * The heartbeat message shows that a system or component is present and responding. The type and
 * autopilot fields (along with the message component id), allow the receiving system to treat further
 * messages from this system appropriately (e.g. by laying out the user interface based on the
 * autopilot). This microservice is documented at https://mavlink.io/en/services/heartbeat.html
 */
public data class Heartbeat(
  /**
   * Vehicle or component type. For a flight controller component the vehicle type (quadrotor,
   * helicopter, etc.). For other components the component type (e.g. camera, gimbal, etc.). This
   * should be used in preference to component id for identifying the component type.
   */
  public val type: MavEnumValue<MavType> = MavEnumValue.fromValue(0),
  /**
   * Autopilot type / class. Use MAV_AUTOPILOT_INVALID for components that are not flight
   * controllers.
   */
  public val autopilot: MavEnumValue<MavAutopilot> = MavEnumValue.fromValue(0),
  /**
   * System mode bitmap.
   */
  public val baseMode: MavEnumValue<MavModeFlag> = MavEnumValue.fromValue(0),
  /**
   * A bitfield for use for autopilot-specific flags
   */
  public val customMode: Long = 0L,
  /**
   * System status flag.
   */
  public val systemStatus: MavEnumValue<MavState> = MavEnumValue.fromValue(0),
  /**
   * MAVLink version, not writable by user, gets added by protocol because of magic data type:
   * uint8_t_mavlink_version
   */
  public val mavlinkVersion: Int = 0,
) : MavMessage<Heartbeat> {
  public override val instanceMetadata: MavMessage.Metadata<Heartbeat> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(9).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(customMode)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeEnumValue(autopilot.value, 1)
    outputBuffer.encodeEnumValue(baseMode.value, 1)
    outputBuffer.encodeEnumValue(systemStatus.value, 1)
    outputBuffer.encodeUint8(mavlinkVersion)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 0

    private const val CRC: Int = 239

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
      val baseMode = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavModeFlag.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
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
  }
}
