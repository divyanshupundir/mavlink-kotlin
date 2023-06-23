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
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(sueLatOrigin)
    output.encodeInt32(sueLonOrigin)
    output.encodeInt32(sueAltOrigin)
    output.encodeInt16(sueWeekNo)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(sueLatOrigin)
    output.encodeInt32(sueLonOrigin)
    output.encodeInt32(sueAltOrigin)
    output.encodeInt16(sueWeekNo)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF13> {
    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 14

    public override val id: UInt = 177u

    public override val crcExtra: Byte = -7

    public override fun deserialize(source: BufferedSource): SerialUdbExtraF13 {
      val sueLatOrigin = source.decodeInt32()
      val sueLonOrigin = source.decodeInt32()
      val sueAltOrigin = source.decodeInt32()
      val sueWeekNo = source.decodeInt16()

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
