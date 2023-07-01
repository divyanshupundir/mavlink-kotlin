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
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt64(timestamp)
    encoder.encodeFloat(h)
    encoder.encodeFloat(href)
    encoder.encodeFloat(hrefT)
    encoder.encodeFloat(pitchangle)
    encoder.encodeFloat(pitchangleref)
    encoder.encodeFloat(q)
    encoder.encodeFloat(qref)
    encoder.encodeFloat(uelev)
    encoder.encodeFloat(uthrot)
    encoder.encodeFloat(uthrot2)
    encoder.encodeFloat(nz)
    encoder.encodeFloat(airspeedref)
    encoder.encodeFloat(yawangle)
    encoder.encodeFloat(yawangleref)
    encoder.encodeFloat(rollangle)
    encoder.encodeFloat(rollangleref)
    encoder.encodeFloat(p)
    encoder.encodeFloat(pref)
    encoder.encodeFloat(r)
    encoder.encodeFloat(rref)
    encoder.encodeFloat(uail)
    encoder.encodeFloat(urud)
    encoder.encodeUInt8(aslctrlMode)
    encoder.encodeUInt8(spoilersengaged)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt64(timestamp)
    encoder.encodeFloat(h)
    encoder.encodeFloat(href)
    encoder.encodeFloat(hrefT)
    encoder.encodeFloat(pitchangle)
    encoder.encodeFloat(pitchangleref)
    encoder.encodeFloat(q)
    encoder.encodeFloat(qref)
    encoder.encodeFloat(uelev)
    encoder.encodeFloat(uthrot)
    encoder.encodeFloat(uthrot2)
    encoder.encodeFloat(nz)
    encoder.encodeFloat(airspeedref)
    encoder.encodeFloat(yawangle)
    encoder.encodeFloat(yawangleref)
    encoder.encodeFloat(rollangle)
    encoder.encodeFloat(rollangleref)
    encoder.encodeFloat(p)
    encoder.encodeFloat(pref)
    encoder.encodeFloat(r)
    encoder.encodeFloat(rref)
    encoder.encodeFloat(uail)
    encoder.encodeFloat(urud)
    encoder.encodeUInt8(aslctrlMode)
    encoder.encodeUInt8(spoilersengaged)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AslctrlData> {
    private const val SIZE_V1: Int = 98

    private const val SIZE_V2: Int = 98

    public override val id: UInt = 8_004u

    public override val crcExtra: Byte = -84

    public override fun deserialize(bytes: ByteArray): AslctrlData {
      val decoder = MavDataDecoder.wrap(bytes)

      val timestamp = decoder.safeDecodeUInt64()
      val h = decoder.safeDecodeFloat()
      val href = decoder.safeDecodeFloat()
      val hrefT = decoder.safeDecodeFloat()
      val pitchangle = decoder.safeDecodeFloat()
      val pitchangleref = decoder.safeDecodeFloat()
      val q = decoder.safeDecodeFloat()
      val qref = decoder.safeDecodeFloat()
      val uelev = decoder.safeDecodeFloat()
      val uthrot = decoder.safeDecodeFloat()
      val uthrot2 = decoder.safeDecodeFloat()
      val nz = decoder.safeDecodeFloat()
      val airspeedref = decoder.safeDecodeFloat()
      val yawangle = decoder.safeDecodeFloat()
      val yawangleref = decoder.safeDecodeFloat()
      val rollangle = decoder.safeDecodeFloat()
      val rollangleref = decoder.safeDecodeFloat()
      val p = decoder.safeDecodeFloat()
      val pref = decoder.safeDecodeFloat()
      val r = decoder.safeDecodeFloat()
      val rref = decoder.safeDecodeFloat()
      val uail = decoder.safeDecodeFloat()
      val urud = decoder.safeDecodeFloat()
      val aslctrlMode = decoder.safeDecodeUInt8()
      val spoilersengaged = decoder.safeDecodeUInt8()

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
