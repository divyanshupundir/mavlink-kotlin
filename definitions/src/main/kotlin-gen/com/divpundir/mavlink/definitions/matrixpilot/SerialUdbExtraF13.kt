package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.Unit

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
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(sueLatOrigin)
    outputBuffer.encodeInt32(sueLonOrigin)
    outputBuffer.encodeInt32(sueAltOrigin)
    outputBuffer.encodeInt16(sueWeekNo)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(sueLatOrigin)
    outputBuffer.encodeInt32(sueLonOrigin)
    outputBuffer.encodeInt32(sueAltOrigin)
    outputBuffer.encodeInt16(sueWeekNo)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF13> {
    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 14

    public override val id: UInt = 177u

    public override val crcExtra: Byte = -7

    public override fun deserialize(bytes: ByteArray): SerialUdbExtraF13 {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueLatOrigin = inputBuffer.decodeInt32()
      val sueLonOrigin = inputBuffer.decodeInt32()
      val sueAltOrigin = inputBuffer.decodeInt32()
      val sueWeekNo = inputBuffer.decodeInt16()

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
