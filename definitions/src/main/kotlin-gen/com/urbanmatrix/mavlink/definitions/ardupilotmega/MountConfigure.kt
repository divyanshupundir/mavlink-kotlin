package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.definitions.common.MavMountMode
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Message to configure a camera mount, directional antenna, etc.
 */
public data class MountConfigure(
  /**
   * System ID.
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  public val targetComponent: Int = 0,
  /**
   * Mount operating mode.
   */
  public val mountMode: MavEnumValue<MavMountMode> = MavEnumValue.fromValue(0),
  /**
   * (1 = yes, 0 = no).
   */
  public val stabRoll: Int = 0,
  /**
   * (1 = yes, 0 = no).
   */
  public val stabPitch: Int = 0,
  /**
   * (1 = yes, 0 = no).
   */
  public val stabYaw: Int = 0,
) : MavMessage<MountConfigure> {
  public override val instanceMetadata: MavMessage.Metadata<MountConfigure> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeEnumValue(mountMode.value, 1)
    outputBuffer.encodeUint8(stabRoll)
    outputBuffer.encodeUint8(stabPitch)
    outputBuffer.encodeUint8(stabYaw)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 156

    private const val CRC: Int = 19

    private const val SIZE: Int = 6

    private val DESERIALIZER: MavDeserializer<MountConfigure> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val mountMode = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavMountMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val stabRoll = inputBuffer.decodeUint8()
      val stabPitch = inputBuffer.decodeUint8()
      val stabYaw = inputBuffer.decodeUint8()

      MountConfigure(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        mountMode = mountMode,
        stabRoll = stabRoll,
        stabPitch = stabPitch,
        stabYaw = stabYaw,
      )
    }


    private val METADATA: MavMessage.Metadata<MountConfigure> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<MountConfigure> = METADATA
  }
}
