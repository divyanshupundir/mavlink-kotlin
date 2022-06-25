package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Float
import kotlin.Int

/**
 * Message encoding a mission item. This message is emitted to announce
 *                 the presence of a mission item and to set a mission item on the system. The
 * mission item can be either in x, y, z meters (type: LOCAL) or x:lat, y:lon, z:altitude. Local frame
 * is Z-down, right handed (NED), global frame is Z-up, right handed (ENU). NaN may be used to indicate
 * an optional/default value (e.g. to use the system's current latitude or yaw rather than a specific
 * value). See also https://mavlink.io/en/services/mission.html.
 */
@Deprecated(message = "")
public data class MissionItem(
  /**
   * Mission type.
   */
  public val missionType: MavEnumValue<MavMissionType> = MavEnumValue.fromValue(0),
  /**
   * PARAM7 / local: Z coordinate, global: altitude (relative or absolute, depending on frame).
   */
  public val z: Float = 0F,
  /**
   * PARAM6 / local: Y coordinate, global: longitude
   */
  public val y: Float = 0F,
  /**
   * PARAM5 / local: X coordinate, global: latitude
   */
  public val x: Float = 0F,
  /**
   * PARAM4, see MAV_CMD enum
   */
  public val param4: Float = 0F,
  /**
   * PARAM3, see MAV_CMD enum
   */
  public val param3: Float = 0F,
  /**
   * PARAM2, see MAV_CMD enum
   */
  public val param2: Float = 0F,
  /**
   * PARAM1, see MAV_CMD enum
   */
  public val param1: Float = 0F,
  /**
   * Autocontinue to next waypoint
   */
  public val autocontinue: Int = 0,
  /**
   * false:0, true:1
   */
  public val current: Int = 0,
  /**
   * The scheduled action for the waypoint.
   */
  public val command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0),
  /**
   * The coordinate system of the waypoint.
   */
  public val frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0),
  /**
   * Sequence
   */
  public val seq: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
) : MavMessage<MissionItem> {
  public override val instanceMetadata: MavMessage.Metadata<MissionItem> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(38).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(missionType.value, 1)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(param4)
    outputBuffer.encodeFloat(param3)
    outputBuffer.encodeFloat(param2)
    outputBuffer.encodeFloat(param1)
    outputBuffer.encodeUint8(autocontinue)
    outputBuffer.encodeUint8(current)
    outputBuffer.encodeEnumValue(command.value, 2)
    outputBuffer.encodeEnumValue(frame.value, 1)
    outputBuffer.encodeUint16(seq)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(targetSystem)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 39

    private const val CRC: Int = 48

    private val DESERIALIZER: MavDeserializer<MissionItem> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val missionType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavMissionType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val z = inputBuffer.decodeFloat()
      val y = inputBuffer.decodeFloat()
      val x = inputBuffer.decodeFloat()
      val param4 = inputBuffer.decodeFloat()
      val param3 = inputBuffer.decodeFloat()
      val param2 = inputBuffer.decodeFloat()
      val param1 = inputBuffer.decodeFloat()
      val autocontinue = inputBuffer.decodeUint8()
      val current = inputBuffer.decodeUint8()
      val command = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = MavCmd.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val frame = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val seq = inputBuffer.decodeUint16()
      val targetComponent = inputBuffer.decodeUint8()
      val targetSystem = inputBuffer.decodeUint8()
      MissionItem(
        missionType = missionType,
        z = z,
        y = y,
        x = x,
        param4 = param4,
        param3 = param3,
        param2 = param2,
        param1 = param1,
        autocontinue = autocontinue,
        current = current,
        command = command,
        frame = frame,
        seq = seq,
        targetComponent = targetComponent,
        targetSystem = targetSystem,
      )
    }


    private val METADATA: MavMessage.Metadata<MissionItem> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<MissionItem> = METADATA
  }
}
