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
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF13> = METADATA

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

  public companion object {
    private const val ID: UInt = 177u

    private const val CRC_EXTRA: Byte = -7

    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 14

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF13> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueLatOrigin = inputBuffer.decodeInt32()
      val sueLonOrigin = inputBuffer.decodeInt32()
      val sueAltOrigin = inputBuffer.decodeInt32()
      val sueWeekNo = inputBuffer.decodeInt16()

      SerialUdbExtraF13(
        sueWeekNo = sueWeekNo,
        sueLatOrigin = sueLatOrigin,
        sueLonOrigin = sueLonOrigin,
        sueAltOrigin = sueAltOrigin,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF13> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF13> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SerialUdbExtraF13 =
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
