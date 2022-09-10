package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Set the magnetometer offsets
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 151,
  crc = 219,
)
public data class SetMagOffsets(
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
   * Magnetometer X offset.
   */
  @GeneratedMavField(type = "int16_t")
  public val magOfsX: Int = 0,
  /**
   * Magnetometer Y offset.
   */
  @GeneratedMavField(type = "int16_t")
  public val magOfsY: Int = 0,
  /**
   * Magnetometer Z offset.
   */
  @GeneratedMavField(type = "int16_t")
  public val magOfsZ: Int = 0,
) : MavMessage<SetMagOffsets> {
  public override val instanceMetadata: MavMessage.Metadata<SetMagOffsets> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(magOfsX)
    outputBuffer.encodeInt16(magOfsY)
    outputBuffer.encodeInt16(magOfsZ)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(magOfsX)
    outputBuffer.encodeInt16(magOfsY)
    outputBuffer.encodeInt16(magOfsZ)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 151

    private const val CRC: Int = 219

    private const val SIZE: Int = 8

    private val DESERIALIZER: MavDeserializer<SetMagOffsets> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val magOfsX = inputBuffer.decodeInt16()
      val magOfsY = inputBuffer.decodeInt16()
      val magOfsZ = inputBuffer.decodeInt16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()

      SetMagOffsets(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        magOfsX = magOfsX,
        magOfsY = magOfsY,
        magOfsZ = magOfsZ,
      )
    }


    private val METADATA: MavMessage.Metadata<SetMagOffsets> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SetMagOffsets> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var magOfsX: Int = 0

    public var magOfsY: Int = 0

    public var magOfsZ: Int = 0

    public fun build(): SetMagOffsets = SetMagOffsets(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      magOfsX = magOfsX,
      magOfsY = magOfsY,
      magOfsZ = magOfsZ,
    )
  }
}
