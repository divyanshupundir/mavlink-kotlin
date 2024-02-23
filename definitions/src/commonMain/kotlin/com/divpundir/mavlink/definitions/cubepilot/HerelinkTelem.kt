package com.divpundir.mavlink.definitions.cubepilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Herelink Telemetry
 */
@GeneratedMavMessage(
  id = 50_003u,
  crcExtra = 62,
)
public data class HerelinkTelem(
  @GeneratedMavField(type = "uint8_t")
  public val rssi: UByte = 0u,
  @GeneratedMavField(type = "int16_t")
  public val snr: Short = 0,
  @GeneratedMavField(type = "uint32_t")
  public val rfFreq: UInt = 0u,
  @GeneratedMavField(type = "uint32_t")
  public val linkBw: UInt = 0u,
  @GeneratedMavField(type = "uint32_t")
  public val linkRate: UInt = 0u,
  @GeneratedMavField(type = "int16_t")
  public val cpuTemp: Short = 0,
  @GeneratedMavField(type = "int16_t")
  public val boardTemp: Short = 0,
) : MavMessage<HerelinkTelem> {
  override val instanceCompanion: MavMessage.MavCompanion<HerelinkTelem> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(rfFreq)
    encoder.encodeUInt32(linkBw)
    encoder.encodeUInt32(linkRate)
    encoder.encodeInt16(snr)
    encoder.encodeInt16(cpuTemp)
    encoder.encodeInt16(boardTemp)
    encoder.encodeUInt8(rssi)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(rfFreq)
    encoder.encodeUInt32(linkBw)
    encoder.encodeUInt32(linkRate)
    encoder.encodeInt16(snr)
    encoder.encodeInt16(cpuTemp)
    encoder.encodeInt16(boardTemp)
    encoder.encodeUInt8(rssi)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<HerelinkTelem> {
    private const val SIZE_V1: Int = 19

    private const val SIZE_V2: Int = 19

    override val id: UInt = 50_003u

    override val crcExtra: Byte = 62

    override fun deserialize(bytes: ByteArray): HerelinkTelem {
      val decoder = MavDataDecoder(bytes)

      val rfFreq = decoder.safeDecodeUInt32()
      val linkBw = decoder.safeDecodeUInt32()
      val linkRate = decoder.safeDecodeUInt32()
      val snr = decoder.safeDecodeInt16()
      val cpuTemp = decoder.safeDecodeInt16()
      val boardTemp = decoder.safeDecodeInt16()
      val rssi = decoder.safeDecodeUInt8()

      return HerelinkTelem(
        rssi = rssi,
        snr = snr,
        rfFreq = rfFreq,
        linkBw = linkBw,
        linkRate = linkRate,
        cpuTemp = cpuTemp,
        boardTemp = boardTemp,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): HerelinkTelem =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var rssi: UByte = 0u

    public var snr: Short = 0

    public var rfFreq: UInt = 0u

    public var linkBw: UInt = 0u

    public var linkRate: UInt = 0u

    public var cpuTemp: Short = 0

    public var boardTemp: Short = 0

    public fun build(): HerelinkTelem = HerelinkTelem(
      rssi = rssi,
      snr = snr,
      rfFreq = rfFreq,
      linkBw = linkBw,
      linkRate = linkRate,
      cpuTemp = cpuTemp,
      boardTemp = boardTemp,
    )
  }
}
