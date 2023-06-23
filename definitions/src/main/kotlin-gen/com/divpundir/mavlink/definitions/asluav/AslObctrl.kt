package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Off-board controls/commands for ASLUAVs
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
  public override val instanceCompanion: MavMessage.MavCompanion<AslObctrl> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timestamp)
    output.encodeFloat(uelev)
    output.encodeFloat(uthrot)
    output.encodeFloat(uthrot2)
    output.encodeFloat(uaill)
    output.encodeFloat(uailr)
    output.encodeFloat(urud)
    output.encodeUInt8(obctrlStatus)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timestamp)
    output.encodeFloat(uelev)
    output.encodeFloat(uthrot)
    output.encodeFloat(uthrot2)
    output.encodeFloat(uaill)
    output.encodeFloat(uailr)
    output.encodeFloat(urud)
    output.encodeUInt8(obctrlStatus)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<AslObctrl> {
    private const val SIZE_V1: Int = 33

    private const val SIZE_V2: Int = 33

    public override val id: UInt = 8_008u

    public override val crcExtra: Byte = -22

    public override fun deserialize(source: BufferedSource): AslObctrl {
      val timestamp = source.decodeUInt64()
      val uelev = source.decodeFloat()
      val uthrot = source.decodeFloat()
      val uthrot2 = source.decodeFloat()
      val uaill = source.decodeFloat()
      val uailr = source.decodeFloat()
      val urud = source.decodeFloat()
      val obctrlStatus = source.decodeUInt8()

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
