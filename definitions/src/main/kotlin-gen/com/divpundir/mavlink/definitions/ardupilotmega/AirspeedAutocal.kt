package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

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
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeFloat(vx)
    encoder.encodeFloat(vy)
    encoder.encodeFloat(vz)
    encoder.encodeFloat(diffPressure)
    encoder.encodeFloat(eas2tas)
    encoder.encodeFloat(ratio)
    encoder.encodeFloat(stateX)
    encoder.encodeFloat(stateY)
    encoder.encodeFloat(stateZ)
    encoder.encodeFloat(pax)
    encoder.encodeFloat(pby)
    encoder.encodeFloat(pcz)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeFloat(vx)
    encoder.encodeFloat(vy)
    encoder.encodeFloat(vz)
    encoder.encodeFloat(diffPressure)
    encoder.encodeFloat(eas2tas)
    encoder.encodeFloat(ratio)
    encoder.encodeFloat(stateX)
    encoder.encodeFloat(stateY)
    encoder.encodeFloat(stateZ)
    encoder.encodeFloat(pax)
    encoder.encodeFloat(pby)
    encoder.encodeFloat(pcz)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AirspeedAutocal> {
    private const val SIZE_V1: Int = 48

    private const val SIZE_V2: Int = 48

    public override val id: UInt = 174u

    public override val crcExtra: Byte = -89

    public override fun deserialize(bytes: ByteArray): AirspeedAutocal {
      val decoder = MavDataDecoder.wrap(bytes)

      val vx = decoder.safeDecodeFloat()
      val vy = decoder.safeDecodeFloat()
      val vz = decoder.safeDecodeFloat()
      val diffPressure = decoder.safeDecodeFloat()
      val eas2tas = decoder.safeDecodeFloat()
      val ratio = decoder.safeDecodeFloat()
      val stateX = decoder.safeDecodeFloat()
      val stateY = decoder.safeDecodeFloat()
      val stateZ = decoder.safeDecodeFloat()
      val pax = decoder.safeDecodeFloat()
      val pby = decoder.safeDecodeFloat()
      val pcz = decoder.safeDecodeFloat()

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
