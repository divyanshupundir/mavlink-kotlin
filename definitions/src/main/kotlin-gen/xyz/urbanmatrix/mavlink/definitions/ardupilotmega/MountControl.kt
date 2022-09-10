package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Message to control a camera mount, directional antenna, etc.
 */
@GeneratedMavMessage(
  id = 157,
  crc = 21,
)
public data class MountControl(
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
   * Pitch (centi-degrees) or lat (degE7), depending on mount mode.
   */
  @GeneratedMavField(type = "int32_t")
  public val inputA: Int = 0,
  /**
   * Roll (centi-degrees) or lon (degE7) depending on mount mode.
   */
  @GeneratedMavField(type = "int32_t")
  public val inputB: Int = 0,
  /**
   * Yaw (centi-degrees) or alt (cm) depending on mount mode.
   */
  @GeneratedMavField(type = "int32_t")
  public val inputC: Int = 0,
  /**
   * If "1" it will save current trimmed position on EEPROM (just valid for NEUTRAL and LANDING).
   */
  @GeneratedMavField(type = "uint8_t")
  public val savePosition: Int = 0,
) : MavMessage<MountControl> {
  public override val instanceMetadata: MavMessage.Metadata<MountControl> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(inputA)
    outputBuffer.encodeInt32(inputB)
    outputBuffer.encodeInt32(inputC)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(savePosition)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(inputA)
    outputBuffer.encodeInt32(inputB)
    outputBuffer.encodeInt32(inputC)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(savePosition)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 157

    private const val CRC: Int = 21

    private const val SIZE: Int = 15

    private val DESERIALIZER: MavDeserializer<MountControl> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val inputA = inputBuffer.decodeInt32()
      val inputB = inputBuffer.decodeInt32()
      val inputC = inputBuffer.decodeInt32()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val savePosition = inputBuffer.decodeUint8()

      MountControl(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        inputA = inputA,
        inputB = inputB,
        inputC = inputC,
        savePosition = savePosition,
      )
    }


    private val METADATA: MavMessage.Metadata<MountControl> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<MountControl> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var inputA: Int = 0

    public var inputB: Int = 0

    public var inputC: Int = 0

    public var savePosition: Int = 0

    public fun build(): MountControl = MountControl(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      inputA = inputA,
      inputB = inputB,
      inputC = inputC,
      savePosition = savePosition,
    )
  }
}
