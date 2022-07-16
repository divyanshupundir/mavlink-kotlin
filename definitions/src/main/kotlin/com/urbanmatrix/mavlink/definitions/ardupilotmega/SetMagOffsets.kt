package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int

/**
 * Set the magnetometer offsets
 */
@Deprecated(message = "")
public data class SetMagOffsets(
  /**
   * Magnetometer Z offset.
   */
  public val magOfsZ: Int = 0,
  /**
   * Magnetometer Y offset.
   */
  public val magOfsY: Int = 0,
  /**
   * Magnetometer X offset.
   */
  public val magOfsX: Int = 0,
  /**
   * Component ID.
   */
  public val targetComponent: Int = 0,
  /**
   * System ID.
   */
  public val targetSystem: Int = 0,
) : MavMessage<SetMagOffsets> {
  public override val instanceMetadata: MavMessage.Metadata<SetMagOffsets> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(magOfsZ)
    outputBuffer.encodeInt16(magOfsY)
    outputBuffer.encodeInt16(magOfsX)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(targetSystem)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 151

    private const val CRC: Int = 163

    private const val SIZE: Int = 8

    private val DESERIALIZER: MavDeserializer<SetMagOffsets> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for SetMagOffsets: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val magOfsZ = inputBuffer.decodeInt16()
      val magOfsY = inputBuffer.decodeInt16()
      val magOfsX = inputBuffer.decodeInt16()
      val targetComponent = inputBuffer.decodeUint8()
      val targetSystem = inputBuffer.decodeUint8()

      SetMagOffsets(
        magOfsZ = magOfsZ,
        magOfsY = magOfsY,
        magOfsX = magOfsX,
        targetComponent = targetComponent,
        targetSystem = targetSystem,
      )
    }


    private val METADATA: MavMessage.Metadata<SetMagOffsets> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SetMagOffsets> = METADATA
  }
}
