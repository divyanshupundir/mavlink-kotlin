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
 * ASL-fixed-wing controller data
 */
@GeneratedMavMessage(
  id = 8_004u,
  crcExtra = -84,
)
public data class AslctrlData(
  /**
   *  Timestamp
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   *  ASLCTRL control-mode (manual, stabilized, auto, etc...)
   */
  @GeneratedMavField(type = "uint8_t")
  public val aslctrlMode: UByte = 0u,
  /**
   *  See sourcecode for a description of these values... 
   */
  @GeneratedMavField(type = "float")
  public val h: Float = 0F,
  @GeneratedMavField(type = "float")
  public val href: Float = 0F,
  @GeneratedMavField(type = "float")
  public val hrefT: Float = 0F,
  /**
   * Pitch angle
   */
  @GeneratedMavField(type = "float")
  public val pitchangle: Float = 0F,
  /**
   * Pitch angle reference
   */
  @GeneratedMavField(type = "float")
  public val pitchangleref: Float = 0F,
  @GeneratedMavField(type = "float")
  public val q: Float = 0F,
  @GeneratedMavField(type = "float")
  public val qref: Float = 0F,
  @GeneratedMavField(type = "float")
  public val uelev: Float = 0F,
  @GeneratedMavField(type = "float")
  public val uthrot: Float = 0F,
  @GeneratedMavField(type = "float")
  public val uthrot2: Float = 0F,
  @GeneratedMavField(type = "float")
  public val nz: Float = 0F,
  /**
   * Airspeed reference
   */
  @GeneratedMavField(type = "float")
  public val airspeedref: Float = 0F,
  @GeneratedMavField(type = "uint8_t")
  public val spoilersengaged: UByte = 0u,
  /**
   * Yaw angle
   */
  @GeneratedMavField(type = "float")
  public val yawangle: Float = 0F,
  /**
   * Yaw angle reference
   */
  @GeneratedMavField(type = "float")
  public val yawangleref: Float = 0F,
  /**
   * Roll angle
   */
  @GeneratedMavField(type = "float")
  public val rollangle: Float = 0F,
  /**
   * Roll angle reference
   */
  @GeneratedMavField(type = "float")
  public val rollangleref: Float = 0F,
  @GeneratedMavField(type = "float")
  public val p: Float = 0F,
  @GeneratedMavField(type = "float")
  public val pref: Float = 0F,
  @GeneratedMavField(type = "float")
  public val r: Float = 0F,
  @GeneratedMavField(type = "float")
  public val rref: Float = 0F,
  @GeneratedMavField(type = "float")
  public val uail: Float = 0F,
  @GeneratedMavField(type = "float")
  public val urud: Float = 0F,
) : MavMessage<AslctrlData> {
  public override val instanceCompanion: MavMessage.MavCompanion<AslctrlData> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timestamp)
    output.encodeFloat(h)
    output.encodeFloat(href)
    output.encodeFloat(hrefT)
    output.encodeFloat(pitchangle)
    output.encodeFloat(pitchangleref)
    output.encodeFloat(q)
    output.encodeFloat(qref)
    output.encodeFloat(uelev)
    output.encodeFloat(uthrot)
    output.encodeFloat(uthrot2)
    output.encodeFloat(nz)
    output.encodeFloat(airspeedref)
    output.encodeFloat(yawangle)
    output.encodeFloat(yawangleref)
    output.encodeFloat(rollangle)
    output.encodeFloat(rollangleref)
    output.encodeFloat(p)
    output.encodeFloat(pref)
    output.encodeFloat(r)
    output.encodeFloat(rref)
    output.encodeFloat(uail)
    output.encodeFloat(urud)
    output.encodeUInt8(aslctrlMode)
    output.encodeUInt8(spoilersengaged)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timestamp)
    output.encodeFloat(h)
    output.encodeFloat(href)
    output.encodeFloat(hrefT)
    output.encodeFloat(pitchangle)
    output.encodeFloat(pitchangleref)
    output.encodeFloat(q)
    output.encodeFloat(qref)
    output.encodeFloat(uelev)
    output.encodeFloat(uthrot)
    output.encodeFloat(uthrot2)
    output.encodeFloat(nz)
    output.encodeFloat(airspeedref)
    output.encodeFloat(yawangle)
    output.encodeFloat(yawangleref)
    output.encodeFloat(rollangle)
    output.encodeFloat(rollangleref)
    output.encodeFloat(p)
    output.encodeFloat(pref)
    output.encodeFloat(r)
    output.encodeFloat(rref)
    output.encodeFloat(uail)
    output.encodeFloat(urud)
    output.encodeUInt8(aslctrlMode)
    output.encodeUInt8(spoilersengaged)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<AslctrlData> {
    private const val SIZE_V1: Int = 98

    private const val SIZE_V2: Int = 98

    public override val id: UInt = 8_004u

    public override val crcExtra: Byte = -84

    public override fun deserialize(source: BufferedSource): AslctrlData {
      val timestamp = source.decodeUInt64()
      val h = source.decodeFloat()
      val href = source.decodeFloat()
      val hrefT = source.decodeFloat()
      val pitchangle = source.decodeFloat()
      val pitchangleref = source.decodeFloat()
      val q = source.decodeFloat()
      val qref = source.decodeFloat()
      val uelev = source.decodeFloat()
      val uthrot = source.decodeFloat()
      val uthrot2 = source.decodeFloat()
      val nz = source.decodeFloat()
      val airspeedref = source.decodeFloat()
      val yawangle = source.decodeFloat()
      val yawangleref = source.decodeFloat()
      val rollangle = source.decodeFloat()
      val rollangleref = source.decodeFloat()
      val p = source.decodeFloat()
      val pref = source.decodeFloat()
      val r = source.decodeFloat()
      val rref = source.decodeFloat()
      val uail = source.decodeFloat()
      val urud = source.decodeFloat()
      val aslctrlMode = source.decodeUInt8()
      val spoilersengaged = source.decodeUInt8()

      return AslctrlData(
        timestamp = timestamp,
        aslctrlMode = aslctrlMode,
        h = h,
        href = href,
        hrefT = hrefT,
        pitchangle = pitchangle,
        pitchangleref = pitchangleref,
        q = q,
        qref = qref,
        uelev = uelev,
        uthrot = uthrot,
        uthrot2 = uthrot2,
        nz = nz,
        airspeedref = airspeedref,
        spoilersengaged = spoilersengaged,
        yawangle = yawangle,
        yawangleref = yawangleref,
        rollangle = rollangle,
        rollangleref = rollangleref,
        p = p,
        pref = pref,
        r = r,
        rref = rref,
        uail = uail,
        urud = urud,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AslctrlData =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: ULong = 0uL

    public var aslctrlMode: UByte = 0u

    public var h: Float = 0F

    public var href: Float = 0F

    public var hrefT: Float = 0F

    public var pitchangle: Float = 0F

    public var pitchangleref: Float = 0F

    public var q: Float = 0F

    public var qref: Float = 0F

    public var uelev: Float = 0F

    public var uthrot: Float = 0F

    public var uthrot2: Float = 0F

    public var nz: Float = 0F

    public var airspeedref: Float = 0F

    public var spoilersengaged: UByte = 0u

    public var yawangle: Float = 0F

    public var yawangleref: Float = 0F

    public var rollangle: Float = 0F

    public var rollangleref: Float = 0F

    public var p: Float = 0F

    public var pref: Float = 0F

    public var r: Float = 0F

    public var rref: Float = 0F

    public var uail: Float = 0F

    public var urud: Float = 0F

    public fun build(): AslctrlData = AslctrlData(
      timestamp = timestamp,
      aslctrlMode = aslctrlMode,
      h = h,
      href = href,
      hrefT = hrefT,
      pitchangle = pitchangle,
      pitchangleref = pitchangleref,
      q = q,
      qref = qref,
      uelev = uelev,
      uthrot = uthrot,
      uthrot2 = uthrot2,
      nz = nz,
      airspeedref = airspeedref,
      spoilersengaged = spoilersengaged,
      yawangle = yawangle,
      yawangleref = yawangleref,
      rollangle = rollangle,
      rollangleref = rollangleref,
      p = p,
      pref = pref,
      r = r,
      rref = rref,
      uail = uail,
      urud = urud,
    )
  }
}
