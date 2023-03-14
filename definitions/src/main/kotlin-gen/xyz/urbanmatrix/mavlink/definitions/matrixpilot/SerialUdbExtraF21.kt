package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F21 format
 */
@GeneratedMavMessage(
  id = 187u,
  crcExtra = -122,
)
public data class SerialUdbExtraF21(
  /**
   * SUE X accelerometer offset
   */
  @GeneratedMavField(type = "int16_t")
  public val sueAccelXOffset: Short = 0,
  /**
   * SUE Y accelerometer offset
   */
  @GeneratedMavField(type = "int16_t")
  public val sueAccelYOffset: Short = 0,
  /**
   * SUE Z accelerometer offset
   */
  @GeneratedMavField(type = "int16_t")
  public val sueAccelZOffset: Short = 0,
  /**
   * SUE X gyro offset
   */
  @GeneratedMavField(type = "int16_t")
  public val sueGyroXOffset: Short = 0,
  /**
   * SUE Y gyro offset
   */
  @GeneratedMavField(type = "int16_t")
  public val sueGyroYOffset: Short = 0,
  /**
   * SUE Z gyro offset
   */
  @GeneratedMavField(type = "int16_t")
  public val sueGyroZOffset: Short = 0,
) : MavMessage<SerialUdbExtraF21> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF21> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(sueAccelXOffset)
    outputBuffer.encodeInt16(sueAccelYOffset)
    outputBuffer.encodeInt16(sueAccelZOffset)
    outputBuffer.encodeInt16(sueGyroXOffset)
    outputBuffer.encodeInt16(sueGyroYOffset)
    outputBuffer.encodeInt16(sueGyroZOffset)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(sueAccelXOffset)
    outputBuffer.encodeInt16(sueAccelYOffset)
    outputBuffer.encodeInt16(sueAccelZOffset)
    outputBuffer.encodeInt16(sueGyroXOffset)
    outputBuffer.encodeInt16(sueGyroYOffset)
    outputBuffer.encodeInt16(sueGyroZOffset)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 187u

    private const val CRC_EXTRA: Byte = -122

    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF21> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueAccelXOffset = inputBuffer.decodeInt16()
      val sueAccelYOffset = inputBuffer.decodeInt16()
      val sueAccelZOffset = inputBuffer.decodeInt16()
      val sueGyroXOffset = inputBuffer.decodeInt16()
      val sueGyroYOffset = inputBuffer.decodeInt16()
      val sueGyroZOffset = inputBuffer.decodeInt16()

      SerialUdbExtraF21(
        sueAccelXOffset = sueAccelXOffset,
        sueAccelYOffset = sueAccelYOffset,
        sueAccelZOffset = sueAccelZOffset,
        sueGyroXOffset = sueGyroXOffset,
        sueGyroYOffset = sueGyroYOffset,
        sueGyroZOffset = sueGyroZOffset,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF21> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF21> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SerialUdbExtraF21 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueAccelXOffset: Short = 0

    public var sueAccelYOffset: Short = 0

    public var sueAccelZOffset: Short = 0

    public var sueGyroXOffset: Short = 0

    public var sueGyroYOffset: Short = 0

    public var sueGyroZOffset: Short = 0

    public fun build(): SerialUdbExtraF21 = SerialUdbExtraF21(
      sueAccelXOffset = sueAccelXOffset,
      sueAccelYOffset = sueAccelYOffset,
      sueAccelZOffset = sueAccelZOffset,
      sueGyroXOffset = sueGyroXOffset,
      sueGyroYOffset = sueGyroYOffset,
      sueGyroZOffset = sueGyroZOffset,
    )
  }
}
