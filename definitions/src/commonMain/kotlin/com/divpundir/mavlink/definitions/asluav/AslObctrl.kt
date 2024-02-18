package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * Off-board controls/commands for ASLUAVs
 *
 */
@GeneratedMavMessage(
  id = 8_008u,
  crcExtra = -22,
)
public data class AslObctrl(
  /**
   *  Time since system start
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   *  Elevator command [~]
   */
  @GeneratedMavField(type = "float")
  public val uelev: Float = 0F,
  /**
   *  Throttle command [~]
   */
  @GeneratedMavField(type = "float")
  public val uthrot: Float = 0F,
  /**
   *  Throttle 2 command [~]
   */
  @GeneratedMavField(type = "float")
  public val uthrot2: Float = 0F,
  /**
   *  Left aileron command [~]
   */
  @GeneratedMavField(type = "float")
  public val uaill: Float = 0F,
  /**
   *  Right aileron command [~]
   */
  @GeneratedMavField(type = "float")
  public val uailr: Float = 0F,
  /**
   *  Rudder command [~]
   */
  @GeneratedMavField(type = "float")
  public val urud: Float = 0F,
  /**
   *  Off-board computer status
   */
  @GeneratedMavField(type = "uint8_t")
  public val obctrlStatus: UByte = 0u,
) : MavMessage<AslObctrl> {
  override val instanceCompanion: MavMessage.MavCompanion<AslObctrl> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timestamp)
    encoder.encodeFloat(uelev)
    encoder.encodeFloat(uthrot)
    encoder.encodeFloat(uthrot2)
    encoder.encodeFloat(uaill)
    encoder.encodeFloat(uailr)
    encoder.encodeFloat(urud)
    encoder.encodeUInt8(obctrlStatus)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timestamp)
    encoder.encodeFloat(uelev)
    encoder.encodeFloat(uthrot)
    encoder.encodeFloat(uthrot2)
    encoder.encodeFloat(uaill)
    encoder.encodeFloat(uailr)
    encoder.encodeFloat(urud)
    encoder.encodeUInt8(obctrlStatus)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AslObctrl> {
    private const val SIZE_V1: Int = 33

    private const val SIZE_V2: Int = 33

    override val id: UInt = 8_008u

    override val crcExtra: Byte = -22

    override fun deserialize(bytes: ByteArray): AslObctrl {
      val decoder = MavDataDecoder(bytes)

      val timestamp = decoder.safeDecodeUInt64()
      val uelev = decoder.safeDecodeFloat()
      val uthrot = decoder.safeDecodeFloat()
      val uthrot2 = decoder.safeDecodeFloat()
      val uaill = decoder.safeDecodeFloat()
      val uailr = decoder.safeDecodeFloat()
      val urud = decoder.safeDecodeFloat()
      val obctrlStatus = decoder.safeDecodeUInt8()

      return AslObctrl(
        timestamp = timestamp,
        uelev = uelev,
        uthrot = uthrot,
        uthrot2 = uthrot2,
        uaill = uaill,
        uailr = uailr,
        urud = urud,
        obctrlStatus = obctrlStatus,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AslObctrl =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: ULong = 0uL

    public var uelev: Float = 0F

    public var uthrot: Float = 0F

    public var uthrot2: Float = 0F

    public var uaill: Float = 0F

    public var uailr: Float = 0F

    public var urud: Float = 0F

    public var obctrlStatus: UByte = 0u

    public fun build(): AslObctrl = AslObctrl(
      timestamp = timestamp,
      uelev = uelev,
      uthrot = uthrot,
      uthrot2 = uthrot2,
      uaill = uaill,
      uailr = uailr,
      urud = urud,
      obctrlStatus = obctrlStatus,
    )
  }
}
