package xyz.urbanmatrix.mavlink.definitions.asluav

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Status of GSM modem (connected to onboard computer)
 */
@GeneratedMavMessage(
  id = 8014,
  crc = 200,
)
public data class GsmLinkStatus(
  /**
   * Timestamp (of OBC)
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   * GSM modem used
   */
  @GeneratedMavField(type = "uint8_t")
  public val gsmModemType: MavEnumValue<GsmModemType> = MavEnumValue.fromValue(0),
  /**
   * GSM link type
   */
  @GeneratedMavField(type = "uint8_t")
  public val gsmLinkType: MavEnumValue<GsmLinkType> = MavEnumValue.fromValue(0),
  /**
   * RSSI as reported by modem (unconverted)
   */
  @GeneratedMavField(type = "uint8_t")
  public val rssi: Int = 0,
  /**
   * RSRP (LTE) or RSCP (WCDMA) as reported by modem (unconverted)
   */
  @GeneratedMavField(type = "uint8_t")
  public val rsrpRscp: Int = 0,
  /**
   * SINR (LTE) or ECIO (WCDMA) as reported by modem (unconverted)
   */
  @GeneratedMavField(type = "uint8_t")
  public val sinrEcio: Int = 0,
  /**
   * RSRQ (LTE only) as reported by modem (unconverted)
   */
  @GeneratedMavField(type = "uint8_t")
  public val rsrq: Int = 0,
) : MavMessage<GsmLinkStatus> {
  public override val instanceMetadata: MavMessage.Metadata<GsmLinkStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeEnumValue(gsmModemType.value, 1)
    outputBuffer.encodeEnumValue(gsmLinkType.value, 1)
    outputBuffer.encodeUint8(rssi)
    outputBuffer.encodeUint8(rsrpRscp)
    outputBuffer.encodeUint8(sinrEcio)
    outputBuffer.encodeUint8(rsrq)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeEnumValue(gsmModemType.value, 1)
    outputBuffer.encodeEnumValue(gsmLinkType.value, 1)
    outputBuffer.encodeUint8(rssi)
    outputBuffer.encodeUint8(rsrpRscp)
    outputBuffer.encodeUint8(sinrEcio)
    outputBuffer.encodeUint8(rsrq)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 8014

    private const val CRC: Int = 200

    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 14

    private val DESERIALIZER: MavDeserializer<GsmLinkStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUint64()
      val gsmModemType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GsmModemType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val gsmLinkType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GsmLinkType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val rssi = inputBuffer.decodeUint8()
      val rsrpRscp = inputBuffer.decodeUint8()
      val sinrEcio = inputBuffer.decodeUint8()
      val rsrq = inputBuffer.decodeUint8()

      GsmLinkStatus(
        timestamp = timestamp,
        gsmModemType = gsmModemType,
        gsmLinkType = gsmLinkType,
        rssi = rssi,
        rsrpRscp = rsrpRscp,
        sinrEcio = sinrEcio,
        rsrq = rsrq,
      )
    }


    private val METADATA: MavMessage.Metadata<GsmLinkStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GsmLinkStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GsmLinkStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: BigInteger = BigInteger.ZERO

    public var gsmModemType: MavEnumValue<GsmModemType> = MavEnumValue.fromValue(0)

    public var gsmLinkType: MavEnumValue<GsmLinkType> = MavEnumValue.fromValue(0)

    public var rssi: Int = 0

    public var rsrpRscp: Int = 0

    public var sinrEcio: Int = 0

    public var rsrq: Int = 0

    public fun build(): GsmLinkStatus = GsmLinkStatus(
      timestamp = timestamp,
      gsmModemType = gsmModemType,
      gsmLinkType = gsmLinkType,
      rssi = rssi,
      rsrpRscp = rsrpRscp,
      sinrEcio = sinrEcio,
      rsrq = rsrq,
    )
  }
}
