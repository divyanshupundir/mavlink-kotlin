package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.definitions.common.MavMountMode
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Message to configure a camera mount, directional antenna, etc.
 */
@GeneratedMavMessage(
  id = 156,
  crc = 19,
)
public data class MountConfigure(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * Mount operating mode.
   */
  @GeneratedMavField(type = "uint8_t")
  public val mountMode: MavEnumValue<MavMountMode> = MavEnumValue.fromValue(0),
  /**
   * (1 = yes, 0 = no).
   */
  @GeneratedMavField(type = "uint8_t")
  public val stabRoll: Int = 0,
  /**
   * (1 = yes, 0 = no).
   */
  @GeneratedMavField(type = "uint8_t")
  public val stabPitch: Int = 0,
  /**
   * (1 = yes, 0 = no).
   */
  @GeneratedMavField(type = "uint8_t")
  public val stabYaw: Int = 0,
) : MavMessage<MountConfigure> {
  public override val instanceMetadata: MavMessage.Metadata<MountConfigure> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeEnumValue(mountMode.value, 1)
    outputBuffer.encodeUint8(stabRoll)
    outputBuffer.encodeUint8(stabPitch)
    outputBuffer.encodeUint8(stabYaw)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeEnumValue(mountMode.value, 1)
    outputBuffer.encodeUint8(stabRoll)
    outputBuffer.encodeUint8(stabPitch)
    outputBuffer.encodeUint8(stabYaw)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 156

    private const val CRC: Int = 19

    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

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

    public fun builder(builderAction: Builder.() -> Unit): MountConfigure =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var mountMode: MavEnumValue<MavMountMode> = MavEnumValue.fromValue(0)

    public var stabRoll: Int = 0

    public var stabPitch: Int = 0

    public var stabYaw: Int = 0

    public fun build(): MountConfigure = MountConfigure(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      mountMode = mountMode,
      stabRoll = stabRoll,
      stabPitch = stabPitch,
      stabYaw = stabYaw,
    )
  }
}
