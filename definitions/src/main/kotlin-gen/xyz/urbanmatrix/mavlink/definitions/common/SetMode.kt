package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Set the system mode, as defined by enum MAV_MODE. There is no target component id as the mode is
 * by definition for the overall aircraft, not only for one component.
 */
@Deprecated(message = "Use COMMAND_LONG with MAV_CMD_DO_SET_MODE instead")
@GeneratedMavMessage(
  id = 11,
  crc = 89,
)
public data class SetMode(
  /**
   * The system setting the mode
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * The new base mode.
   */
  @GeneratedMavField(type = "uint8_t")
  public val baseMode: MavEnumValue<MavMode> = MavEnumValue.fromValue(0),
  /**
   * The new autopilot-specific mode. This field can be ignored by an autopilot.
   */
  @GeneratedMavField(type = "uint32_t")
  public val customMode: Long = 0L,
) : MavMessage<SetMode> {
  public override val instanceMetadata: MavMessage.Metadata<SetMode> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(customMode)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeEnumValue(baseMode.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(customMode)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeEnumValue(baseMode.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 11

    private const val CRC: Int = 89

    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    private val DESERIALIZER: MavDeserializer<SetMode> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val customMode = inputBuffer.decodeUint32()
      val targetSystem = inputBuffer.decodeUint8()
      val baseMode = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      SetMode(
        targetSystem = targetSystem,
        baseMode = baseMode,
        customMode = customMode,
      )
    }


    private val METADATA: MavMessage.Metadata<SetMode> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SetMode> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SetMode =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var baseMode: MavEnumValue<MavMode> = MavEnumValue.fromValue(0)

    public var customMode: Long = 0L

    public fun build(): SetMode = SetMode(
      targetSystem = targetSystem,
      baseMode = baseMode,
      customMode = customMode,
    )
  }
}
