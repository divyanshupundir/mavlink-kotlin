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
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Request the information of the mission item with the sequence number seq. The response of the
 * system to this message should be a MISSION_ITEM_INT message.
 * https://mavlink.io/en/services/mission.html
 */
@GeneratedMavMessage(
  id = 51,
  crc = 196,
)
public data class MissionRequestInt(
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * Sequence
   */
  public val seq: Int = 0,
  /**
   * Mission type.
   */
  public val missionType: MavEnumValue<MavMissionType> = MavEnumValue.fromValue(0),
) : MavMessage<MissionRequestInt> {
  public override val instanceMetadata: MavMessage.Metadata<MissionRequestInt> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(seq)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeEnumValue(missionType.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 51

    private const val CRC: Int = 196

    private const val SIZE: Int = 5

    private val DESERIALIZER: MavDeserializer<MissionRequestInt> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val seq = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val missionType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavMissionType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      MissionRequestInt(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        seq = seq,
        missionType = missionType,
      )
    }


    private val METADATA: MavMessage.Metadata<MissionRequestInt> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<MissionRequestInt> = METADATA
  }
}
