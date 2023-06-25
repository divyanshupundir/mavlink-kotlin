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
import kotlin.ByteArray
import kotlin.Float
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timestamp)
    buffer.encodeFloat(h)
    buffer.encodeFloat(href)
    buffer.encodeFloat(hrefT)
    buffer.encodeFloat(pitchangle)
    buffer.encodeFloat(pitchangleref)
    buffer.encodeFloat(q)
    buffer.encodeFloat(qref)
    buffer.encodeFloat(uelev)
    buffer.encodeFloat(uthrot)
    buffer.encodeFloat(uthrot2)
    buffer.encodeFloat(nz)
    buffer.encodeFloat(airspeedref)
    buffer.encodeFloat(yawangle)
    buffer.encodeFloat(yawangleref)
    buffer.encodeFloat(rollangle)
    buffer.encodeFloat(rollangleref)
    buffer.encodeFloat(p)
    buffer.encodeFloat(pref)
    buffer.encodeFloat(r)
    buffer.encodeFloat(rref)
    buffer.encodeFloat(uail)
    buffer.encodeFloat(urud)
    buffer.encodeUInt8(aslctrlMode)
    buffer.encodeUInt8(spoilersengaged)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timestamp)
    buffer.encodeFloat(h)
    buffer.encodeFloat(href)
    buffer.encodeFloat(hrefT)
    buffer.encodeFloat(pitchangle)
    buffer.encodeFloat(pitchangleref)
    buffer.encodeFloat(q)
    buffer.encodeFloat(qref)
    buffer.encodeFloat(uelev)
    buffer.encodeFloat(uthrot)
    buffer.encodeFloat(uthrot2)
    buffer.encodeFloat(nz)
    buffer.encodeFloat(airspeedref)
    buffer.encodeFloat(yawangle)
    buffer.encodeFloat(yawangleref)
    buffer.encodeFloat(rollangle)
    buffer.encodeFloat(rollangleref)
    buffer.encodeFloat(p)
    buffer.encodeFloat(pref)
    buffer.encodeFloat(r)
    buffer.encodeFloat(rref)
    buffer.encodeFloat(uail)
    buffer.encodeFloat(urud)
    buffer.encodeUInt8(aslctrlMode)
    buffer.encodeUInt8(spoilersengaged)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AslctrlData> {
    public override val id: UInt = 8_004u

    public override val crcExtra: Byte = -84

    public override fun deserialize(bytes: ByteArray): AslctrlData {
      val buffer = Buffer().write(bytes)

      val timestamp = buffer.decodeUInt64()
      val h = buffer.decodeFloat()
      val href = buffer.decodeFloat()
      val hrefT = buffer.decodeFloat()
      val pitchangle = buffer.decodeFloat()
      val pitchangleref = buffer.decodeFloat()
      val q = buffer.decodeFloat()
      val qref = buffer.decodeFloat()
      val uelev = buffer.decodeFloat()
      val uthrot = buffer.decodeFloat()
      val uthrot2 = buffer.decodeFloat()
      val nz = buffer.decodeFloat()
      val airspeedref = buffer.decodeFloat()
      val yawangle = buffer.decodeFloat()
      val yawangleref = buffer.decodeFloat()
      val rollangle = buffer.decodeFloat()
      val rollangleref = buffer.decodeFloat()
      val p = buffer.decodeFloat()
      val pref = buffer.decodeFloat()
      val r = buffer.decodeFloat()
      val rref = buffer.decodeFloat()
      val uail = buffer.decodeFloat()
      val urud = buffer.decodeFloat()
      val aslctrlMode = buffer.decodeUInt8()
      val spoilersengaged = buffer.decodeUInt8()

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
