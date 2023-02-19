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
 * Backwards compatible version of SERIAL_UDB_EXTRA F22 format
 */
@GeneratedMavMessage(
  id = 188u,
  crcExtra = 91,
)
public data class SerialUdbExtraF22(
  /**
   * SUE X accelerometer at calibration time
   */
  @GeneratedMavField(type = "int16_t")
  public val sueAccelXAtCalibration: Short = 0,
  /**
   * SUE Y accelerometer at calibration time
   */
  @GeneratedMavField(type = "int16_t")
  public val sueAccelYAtCalibration: Short = 0,
  /**
   * SUE Z accelerometer at calibration time
   */
  @GeneratedMavField(type = "int16_t")
  public val sueAccelZAtCalibration: Short = 0,
  /**
   * SUE X gyro at calibration time
   */
  @GeneratedMavField(type = "int16_t")
  public val sueGyroXAtCalibration: Short = 0,
  /**
   * SUE Y gyro at calibration time
   */
  @GeneratedMavField(type = "int16_t")
  public val sueGyroYAtCalibration: Short = 0,
  /**
   * SUE Z gyro at calibration time
   */
  @GeneratedMavField(type = "int16_t")
  public val sueGyroZAtCalibration: Short = 0,
) : MavMessage<SerialUdbExtraF22> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF22> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(sueAccelXAtCalibration)
    outputBuffer.encodeInt16(sueAccelYAtCalibration)
    outputBuffer.encodeInt16(sueAccelZAtCalibration)
    outputBuffer.encodeInt16(sueGyroXAtCalibration)
    outputBuffer.encodeInt16(sueGyroYAtCalibration)
    outputBuffer.encodeInt16(sueGyroZAtCalibration)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(sueAccelXAtCalibration)
    outputBuffer.encodeInt16(sueAccelYAtCalibration)
    outputBuffer.encodeInt16(sueAccelZAtCalibration)
    outputBuffer.encodeInt16(sueGyroXAtCalibration)
    outputBuffer.encodeInt16(sueGyroYAtCalibration)
    outputBuffer.encodeInt16(sueGyroZAtCalibration)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 188u

    private const val CRC_EXTRA: Byte = 91

    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF22> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueAccelXAtCalibration = inputBuffer.decodeInt16()
      val sueAccelYAtCalibration = inputBuffer.decodeInt16()
      val sueAccelZAtCalibration = inputBuffer.decodeInt16()
      val sueGyroXAtCalibration = inputBuffer.decodeInt16()
      val sueGyroYAtCalibration = inputBuffer.decodeInt16()
      val sueGyroZAtCalibration = inputBuffer.decodeInt16()

      SerialUdbExtraF22(
        sueAccelXAtCalibration = sueAccelXAtCalibration,
        sueAccelYAtCalibration = sueAccelYAtCalibration,
        sueAccelZAtCalibration = sueAccelZAtCalibration,
        sueGyroXAtCalibration = sueGyroXAtCalibration,
        sueGyroYAtCalibration = sueGyroYAtCalibration,
        sueGyroZAtCalibration = sueGyroZAtCalibration,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF22> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF22> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SerialUdbExtraF22 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueAccelXAtCalibration: Short = 0

    public var sueAccelYAtCalibration: Short = 0

    public var sueAccelZAtCalibration: Short = 0

    public var sueGyroXAtCalibration: Short = 0

    public var sueGyroYAtCalibration: Short = 0

    public var sueGyroZAtCalibration: Short = 0

    public fun build(): SerialUdbExtraF22 = SerialUdbExtraF22(
      sueAccelXAtCalibration = sueAccelXAtCalibration,
      sueAccelYAtCalibration = sueAccelYAtCalibration,
      sueAccelZAtCalibration = sueAccelZAtCalibration,
      sueGyroXAtCalibration = sueGyroXAtCalibration,
      sueGyroYAtCalibration = sueGyroYAtCalibration,
      sueGyroZAtCalibration = sueGyroZAtCalibration,
    )
  }
}
