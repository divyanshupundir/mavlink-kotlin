package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F13: format
 */
@GeneratedMavMessage(
  id = 177u,
  crcExtra = -7,
)
public data class SerialUdbExtraF13(
  /**
   * Serial UDB Extra GPS Week Number
   */
  @GeneratedMavField(type = "int16_t")
  public val sueWeekNo: Short = 0,
  /**
   * Serial UDB Extra MP Origin Latitude
   */
  @GeneratedMavField(type = "int32_t")
  public val sueLatOrigin: Int = 0,
  /**
   * Serial UDB Extra MP Origin Longitude
   */
  @GeneratedMavField(type = "int32_t")
  public val sueLonOrigin: Int = 0,
  /**
   * Serial UDB Extra MP Origin Altitude Above Sea Level
   */
  @GeneratedMavField(type = "int32_t")
  public val sueAltOrigin: Int = 0,
) : MavMessage<SerialUdbExtraF13> {
  public override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF13> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt32(sueLatOrigin)
    buffer.encodeInt32(sueLonOrigin)
    buffer.encodeInt32(sueAltOrigin)
    buffer.encodeInt16(sueWeekNo)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt32(sueLatOrigin)
    buffer.encodeInt32(sueLonOrigin)
    buffer.encodeInt32(sueAltOrigin)
    buffer.encodeInt16(sueWeekNo)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF13> {
    public override val id: UInt = 177u

    public override val crcExtra: Byte = -7

    public override fun deserialize(bytes: ByteArray): SerialUdbExtraF13 {
      val buffer = Buffer().write(bytes)

      val sueLatOrigin = buffer.decodeInt32()
      val sueLonOrigin = buffer.decodeInt32()
      val sueAltOrigin = buffer.decodeInt32()
      val sueWeekNo = buffer.decodeInt16()

      return SerialUdbExtraF13(
        sueWeekNo = sueWeekNo,
        sueLatOrigin = sueLatOrigin,
        sueLonOrigin = sueLonOrigin,
        sueAltOrigin = sueAltOrigin,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SerialUdbExtraF13 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueWeekNo: Short = 0

    public var sueLatOrigin: Int = 0

    public var sueLonOrigin: Int = 0

    public var sueAltOrigin: Int = 0

    public fun build(): SerialUdbExtraF13 = SerialUdbExtraF13(
      sueWeekNo = sueWeekNo,
      sueLatOrigin = sueLatOrigin,
      sueLonOrigin = sueLonOrigin,
      sueAltOrigin = sueAltOrigin,
    )
  }
}
