package com.urbanmatrix.mavlink.asluav

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * ASL-fixed-wing controller data
 */
public data class AslctrlData(
  /**
   *  Timestamp
   */
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   *  ASLCTRL control-mode (manual, stabilized, auto, etc...)
   */
  public val aslctrlMode: Int = 0,
  /**
   *  See sourcecode for a description of these values... 
   */
  public val h: Float = 0F,
  public val href: Float = 0F,
  public val hrefT: Float = 0F,
  /**
   * Pitch angle
   */
  public val pitchangle: Float = 0F,
  /**
   * Pitch angle reference
   */
  public val pitchangleref: Float = 0F,
  public val q: Float = 0F,
  public val qref: Float = 0F,
  public val uelev: Float = 0F,
  public val uthrot: Float = 0F,
  public val uthrot2: Float = 0F,
  public val nz: Float = 0F,
  /**
   * Airspeed reference
   */
  public val airspeedref: Float = 0F,
  public val spoilersengaged: Int = 0,
  /**
   * Yaw angle
   */
  public val yawangle: Float = 0F,
  /**
   * Yaw angle reference
   */
  public val yawangleref: Float = 0F,
  /**
   * Roll angle
   */
  public val rollangle: Float = 0F,
  /**
   * Roll angle reference
   */
  public val rollangleref: Float = 0F,
  public val p: Float = 0F,
  public val pref: Float = 0F,
  public val r: Float = 0F,
  public val rref: Float = 0F,
  public val uail: Float = 0F,
  public val urud: Float = 0F,
) : MavMessage<AslctrlData> {
  public override val instanceMetadata: MavMessage.Metadata<AslctrlData> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(98).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeFloat(h)
    outputBuffer.encodeFloat(href)
    outputBuffer.encodeFloat(hrefT)
    outputBuffer.encodeFloat(pitchangle)
    outputBuffer.encodeFloat(pitchangleref)
    outputBuffer.encodeFloat(q)
    outputBuffer.encodeFloat(qref)
    outputBuffer.encodeFloat(uelev)
    outputBuffer.encodeFloat(uthrot)
    outputBuffer.encodeFloat(uthrot2)
    outputBuffer.encodeFloat(nz)
    outputBuffer.encodeFloat(airspeedref)
    outputBuffer.encodeFloat(yawangle)
    outputBuffer.encodeFloat(yawangleref)
    outputBuffer.encodeFloat(rollangle)
    outputBuffer.encodeFloat(rollangleref)
    outputBuffer.encodeFloat(p)
    outputBuffer.encodeFloat(pref)
    outputBuffer.encodeFloat(r)
    outputBuffer.encodeFloat(rref)
    outputBuffer.encodeFloat(uail)
    outputBuffer.encodeFloat(urud)
    outputBuffer.encodeUint8(aslctrlMode)
    outputBuffer.encodeUint8(spoilersengaged)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 8004

    private const val CRC: Int = 172

    private val DESERIALIZER: MavDeserializer<AslctrlData> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUint64()
      val h = inputBuffer.decodeFloat()
      val href = inputBuffer.decodeFloat()
      val hrefT = inputBuffer.decodeFloat()
      val pitchangle = inputBuffer.decodeFloat()
      val pitchangleref = inputBuffer.decodeFloat()
      val q = inputBuffer.decodeFloat()
      val qref = inputBuffer.decodeFloat()
      val uelev = inputBuffer.decodeFloat()
      val uthrot = inputBuffer.decodeFloat()
      val uthrot2 = inputBuffer.decodeFloat()
      val nz = inputBuffer.decodeFloat()
      val airspeedref = inputBuffer.decodeFloat()
      val yawangle = inputBuffer.decodeFloat()
      val yawangleref = inputBuffer.decodeFloat()
      val rollangle = inputBuffer.decodeFloat()
      val rollangleref = inputBuffer.decodeFloat()
      val p = inputBuffer.decodeFloat()
      val pref = inputBuffer.decodeFloat()
      val r = inputBuffer.decodeFloat()
      val rref = inputBuffer.decodeFloat()
      val uail = inputBuffer.decodeFloat()
      val urud = inputBuffer.decodeFloat()
      val aslctrlMode = inputBuffer.decodeUint8()
      val spoilersengaged = inputBuffer.decodeUint8()
      AslctrlData(
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


    private val METADATA: MavMessage.Metadata<AslctrlData> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AslctrlData> = METADATA
  }
}
