package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Airspeed auto-calibration.
 */
@GeneratedMavMessage(
  id = 174u,
  crcExtra = -89,
)
public data class AirspeedAutocal(
  /**
   * GPS velocity north.
   */
  @GeneratedMavField(type = "float")
  public val vx: Float = 0F,
  /**
   * GPS velocity east.
   */
  @GeneratedMavField(type = "float")
  public val vy: Float = 0F,
  /**
   * GPS velocity down.
   */
  @GeneratedMavField(type = "float")
  public val vz: Float = 0F,
  /**
   * Differential pressure.
   */
  @GeneratedMavField(type = "float")
  public val diffPressure: Float = 0F,
  /**
   * Estimated to true airspeed ratio.
   */
  @GeneratedMavField(type = "float")
  public val eas2tas: Float = 0F,
  /**
   * Airspeed ratio.
   */
  @GeneratedMavField(type = "float")
  public val ratio: Float = 0F,
  /**
   * EKF state x.
   */
  @GeneratedMavField(type = "float")
  public val stateX: Float = 0F,
  /**
   * EKF state y.
   */
  @GeneratedMavField(type = "float")
  public val stateY: Float = 0F,
  /**
   * EKF state z.
   */
  @GeneratedMavField(type = "float")
  public val stateZ: Float = 0F,
  /**
   * EKF Pax.
   */
  @GeneratedMavField(type = "float")
  public val pax: Float = 0F,
  /**
   * EKF Pby.
   */
  @GeneratedMavField(type = "float")
  public val pby: Float = 0F,
  /**
   * EKF Pcz.
   */
  @GeneratedMavField(type = "float")
  public val pcz: Float = 0F,
) : MavMessage<AirspeedAutocal> {
  public override val instanceCompanion: MavMessage.MavCompanion<AirspeedAutocal> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(vx)
    buffer.encodeFloat(vy)
    buffer.encodeFloat(vz)
    buffer.encodeFloat(diffPressure)
    buffer.encodeFloat(eas2tas)
    buffer.encodeFloat(ratio)
    buffer.encodeFloat(stateX)
    buffer.encodeFloat(stateY)
    buffer.encodeFloat(stateZ)
    buffer.encodeFloat(pax)
    buffer.encodeFloat(pby)
    buffer.encodeFloat(pcz)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(vx)
    buffer.encodeFloat(vy)
    buffer.encodeFloat(vz)
    buffer.encodeFloat(diffPressure)
    buffer.encodeFloat(eas2tas)
    buffer.encodeFloat(ratio)
    buffer.encodeFloat(stateX)
    buffer.encodeFloat(stateY)
    buffer.encodeFloat(stateZ)
    buffer.encodeFloat(pax)
    buffer.encodeFloat(pby)
    buffer.encodeFloat(pcz)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AirspeedAutocal> {
    public override val id: UInt = 174u

    public override val crcExtra: Byte = -89

    public override fun deserialize(bytes: ByteArray): AirspeedAutocal {
      val buffer = Buffer().write(bytes)

      val vx = buffer.decodeFloat()
      val vy = buffer.decodeFloat()
      val vz = buffer.decodeFloat()
      val diffPressure = buffer.decodeFloat()
      val eas2tas = buffer.decodeFloat()
      val ratio = buffer.decodeFloat()
      val stateX = buffer.decodeFloat()
      val stateY = buffer.decodeFloat()
      val stateZ = buffer.decodeFloat()
      val pax = buffer.decodeFloat()
      val pby = buffer.decodeFloat()
      val pcz = buffer.decodeFloat()

      return AirspeedAutocal(
        vx = vx,
        vy = vy,
        vz = vz,
        diffPressure = diffPressure,
        eas2tas = eas2tas,
        ratio = ratio,
        stateX = stateX,
        stateY = stateY,
        stateZ = stateZ,
        pax = pax,
        pby = pby,
        pcz = pcz,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AirspeedAutocal =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var vx: Float = 0F

    public var vy: Float = 0F

    public var vz: Float = 0F

    public var diffPressure: Float = 0F

    public var eas2tas: Float = 0F

    public var ratio: Float = 0F

    public var stateX: Float = 0F

    public var stateY: Float = 0F

    public var stateZ: Float = 0F

    public var pax: Float = 0F

    public var pby: Float = 0F

    public var pcz: Float = 0F

    public fun build(): AirspeedAutocal = AirspeedAutocal(
      vx = vx,
      vy = vy,
      vz = vz,
      diffPressure = diffPressure,
      eas2tas = eas2tas,
      ratio = ratio,
      stateX = stateX,
      stateY = stateY,
      stateZ = stateZ,
      pax = pax,
      pby = pby,
      pcz = pcz,
    )
  }
}
