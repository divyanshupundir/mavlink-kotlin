package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Short
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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
    val buffer = Buffer()
    buffer.encodeInt16(sueAccelXOffset)
    buffer.encodeInt16(sueAccelYOffset)
    buffer.encodeInt16(sueAccelZOffset)
    buffer.encodeInt16(sueGyroXOffset)
    buffer.encodeInt16(sueGyroYOffset)
    buffer.encodeInt16(sueGyroZOffset)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt16(sueAccelXOffset)
    buffer.encodeInt16(sueAccelYOffset)
    buffer.encodeInt16(sueAccelZOffset)
    buffer.encodeInt16(sueGyroXOffset)
    buffer.encodeInt16(sueGyroYOffset)
    buffer.encodeInt16(sueGyroZOffset)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF21> {
    public override val id: UInt = 187u

    public override val crcExtra: Byte = -122

    public override fun deserialize(bytes: ByteArray): SerialUdbExtraF21 {
      val buffer = Buffer().write(bytes)

      val sueAccelXOffset = buffer.decodeInt16()
      val sueAccelYOffset = buffer.decodeInt16()
      val sueAccelZOffset = buffer.decodeInt16()
      val sueGyroXOffset = buffer.decodeInt16()
      val sueGyroYOffset = buffer.decodeInt16()
      val sueGyroZOffset = buffer.decodeInt16()

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
