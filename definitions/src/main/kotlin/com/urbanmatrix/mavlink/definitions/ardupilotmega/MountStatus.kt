package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.definitions.common.MavMountMode
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Message with some status from autopilot to GCS about camera or antenna mount.
 */
public data class MountStatus(
  /**
   * System ID.
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  public val targetComponent: Int = 0,
  /**
   * Pitch.
   */
  public val pointingA: Int = 0,
  /**
   * Roll.
   */
  public val pointingB: Int = 0,
  /**
   * Yaw.
   */
  public val pointingC: Int = 0,
  /**
   * Mount operating mode.
   */
  public val mountMode: MavEnumValue<MavMountMode> = MavEnumValue.fromValue(0),
) : MavMessage<MountStatus> {
  public override val instanceMetadata: MavMessage.Metadata<MountStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(pointingA)
    outputBuffer.encodeInt32(pointingB)
    outputBuffer.encodeInt32(pointingC)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeEnumValue(mountMode.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 158

    private const val CRC: Int = 134

    private const val SIZE: Int = 15

    private val DESERIALIZER: MavDeserializer<MountStatus> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for MountStatus: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val pointingA = inputBuffer.decodeInt32()
      val pointingB = inputBuffer.decodeInt32()
      val pointingC = inputBuffer.decodeInt32()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val mountMode = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavMountMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      MountStatus(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        pointingA = pointingA,
        pointingB = pointingB,
        pointingC = pointingC,
        mountMode = mountMode,
      )
    }


    private val METADATA: MavMessage.Metadata<MountStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<MountStatus> = METADATA
  }
}
