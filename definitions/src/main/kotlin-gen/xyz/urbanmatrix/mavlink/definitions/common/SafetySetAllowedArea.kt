package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Set a safety zone (volume), which is defined by two corners of a cube. This message can be used
 * to tell the MAV which setpoints/waypoints to accept and which to reject. Safety areas are often
 * enforced by national or competition regulations.
 */
@GeneratedMavMessage(
  id = 54u,
  crcExtra = 15,
)
public data class SafetySetAllowedArea(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Coordinate frame. Can be either global, GPS, right-handed with Z axis up or local, right
   * handed, Z axis down.
   */
  @GeneratedMavField(type = "uint8_t")
  public val frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u),
  /**
   * x position 1 / Latitude 1
   */
  @GeneratedMavField(type = "float")
  public val p1x: Float = 0F,
  /**
   * y position 1 / Longitude 1
   */
  @GeneratedMavField(type = "float")
  public val p1y: Float = 0F,
  /**
   * z position 1 / Altitude 1
   */
  @GeneratedMavField(type = "float")
  public val p1z: Float = 0F,
  /**
   * x position 2 / Latitude 2
   */
  @GeneratedMavField(type = "float")
  public val p2x: Float = 0F,
  /**
   * y position 2 / Longitude 2
   */
  @GeneratedMavField(type = "float")
  public val p2y: Float = 0F,
  /**
   * z position 2 / Altitude 2
   */
  @GeneratedMavField(type = "float")
  public val p2z: Float = 0F,
) : MavMessage<SafetySetAllowedArea> {
  public override val instanceMetadata: MavMessage.Metadata<SafetySetAllowedArea> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(p1x)
    outputBuffer.encodeFloat(p1y)
    outputBuffer.encodeFloat(p1z)
    outputBuffer.encodeFloat(p2x)
    outputBuffer.encodeFloat(p2y)
    outputBuffer.encodeFloat(p2z)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeEnumValue(frame.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(p1x)
    outputBuffer.encodeFloat(p1y)
    outputBuffer.encodeFloat(p1z)
    outputBuffer.encodeFloat(p2x)
    outputBuffer.encodeFloat(p2y)
    outputBuffer.encodeFloat(p2z)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeEnumValue(frame.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 54u

    private const val CRC_EXTRA: Byte = 15

    private const val SIZE_V1: Int = 27

    private const val SIZE_V2: Int = 27

    private val DESERIALIZER: MavDeserializer<SafetySetAllowedArea> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val p1x = inputBuffer.decodeFloat()
      val p1y = inputBuffer.decodeFloat()
      val p1z = inputBuffer.decodeFloat()
      val p2x = inputBuffer.decodeFloat()
      val p2y = inputBuffer.decodeFloat()
      val p2z = inputBuffer.decodeFloat()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val frame = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      SafetySetAllowedArea(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        frame = frame,
        p1x = p1x,
        p1y = p1y,
        p1z = p1z,
        p2x = p2x,
        p2y = p2y,
        p2z = p2z,
      )
    }


    private val METADATA: MavMessage.Metadata<SafetySetAllowedArea> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SafetySetAllowedArea> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SafetySetAllowedArea =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u)

    public var p1x: Float = 0F

    public var p1y: Float = 0F

    public var p1z: Float = 0F

    public var p2x: Float = 0F

    public var p2y: Float = 0F

    public var p2z: Float = 0F

    public fun build(): SafetySetAllowedArea = SafetySetAllowedArea(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      frame = frame,
      p1x = p1x,
      p1y = p1y,
      p1z = p1z,
      p2x = p2x,
      p2y = p2y,
      p2z = p2z,
    )
  }
}
