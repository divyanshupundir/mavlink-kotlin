package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.Unit

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
  public override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF21> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeInt16(sueAccelXOffset)
    encoder.encodeInt16(sueAccelYOffset)
    encoder.encodeInt16(sueAccelZOffset)
    encoder.encodeInt16(sueGyroXOffset)
    encoder.encodeInt16(sueGyroYOffset)
    encoder.encodeInt16(sueGyroZOffset)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeInt16(sueAccelXOffset)
    encoder.encodeInt16(sueAccelYOffset)
    encoder.encodeInt16(sueAccelZOffset)
    encoder.encodeInt16(sueGyroXOffset)
    encoder.encodeInt16(sueGyroYOffset)
    encoder.encodeInt16(sueGyroZOffset)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF21> {
    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    public override val id: UInt = 187u

    public override val crcExtra: Byte = -122

    public override fun deserialize(bytes: ByteArray): SerialUdbExtraF21 {
      val decoder = MavDataDecoder.wrap(bytes)

      val sueAccelXOffset = decoder.safeDecodeInt16()
      val sueAccelYOffset = decoder.safeDecodeInt16()
      val sueAccelZOffset = decoder.safeDecodeInt16()
      val sueGyroXOffset = decoder.safeDecodeInt16()
      val sueGyroYOffset = decoder.safeDecodeInt16()
      val sueGyroZOffset = decoder.safeDecodeInt16()

      return SerialUdbExtraF21(
        sueAccelXOffset = sueAccelXOffset,
        sueAccelYOffset = sueAccelYOffset,
        sueAccelZOffset = sueAccelZOffset,
        sueGyroXOffset = sueGyroXOffset,
        sueGyroYOffset = sueGyroYOffset,
        sueGyroZOffset = sueGyroZOffset,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SerialUdbExtraF21 =
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
