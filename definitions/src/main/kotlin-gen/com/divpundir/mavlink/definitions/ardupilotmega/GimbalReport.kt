package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * 3 axis gimbal measurements.
 */
@GeneratedMavMessage(
  id = 200u,
  crcExtra = -122,
)
public data class GimbalReport(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Time since last update.
   */
  @GeneratedMavField(type = "float")
  public val deltaTime: Float = 0F,
  /**
   * Delta angle X.
   */
  @GeneratedMavField(type = "float")
  public val deltaAngleX: Float = 0F,
  /**
   * Delta angle Y.
   */
  @GeneratedMavField(type = "float")
  public val deltaAngleY: Float = 0F,
  /**
   * Delta angle X.
   */
  @GeneratedMavField(type = "float")
  public val deltaAngleZ: Float = 0F,
  /**
   * Delta velocity X.
   */
  @GeneratedMavField(type = "float")
  public val deltaVelocityX: Float = 0F,
  /**
   * Delta velocity Y.
   */
  @GeneratedMavField(type = "float")
  public val deltaVelocityY: Float = 0F,
  /**
   * Delta velocity Z.
   */
  @GeneratedMavField(type = "float")
  public val deltaVelocityZ: Float = 0F,
  /**
   * Joint ROLL.
   */
  @GeneratedMavField(type = "float")
  public val jointRoll: Float = 0F,
  /**
   * Joint EL.
   */
  @GeneratedMavField(type = "float")
  public val jointEl: Float = 0F,
  /**
   * Joint AZ.
   */
  @GeneratedMavField(type = "float")
  public val jointAz: Float = 0F,
) : MavMessage<GimbalReport> {
  public override val instanceCompanion: MavMessage.MavCompanion<GimbalReport> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeFloat(deltaTime)
    encoder.encodeFloat(deltaAngleX)
    encoder.encodeFloat(deltaAngleY)
    encoder.encodeFloat(deltaAngleZ)
    encoder.encodeFloat(deltaVelocityX)
    encoder.encodeFloat(deltaVelocityY)
    encoder.encodeFloat(deltaVelocityZ)
    encoder.encodeFloat(jointRoll)
    encoder.encodeFloat(jointEl)
    encoder.encodeFloat(jointAz)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeFloat(deltaTime)
    encoder.encodeFloat(deltaAngleX)
    encoder.encodeFloat(deltaAngleY)
    encoder.encodeFloat(deltaAngleZ)
    encoder.encodeFloat(deltaVelocityX)
    encoder.encodeFloat(deltaVelocityY)
    encoder.encodeFloat(deltaVelocityZ)
    encoder.encodeFloat(jointRoll)
    encoder.encodeFloat(jointEl)
    encoder.encodeFloat(jointAz)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GimbalReport> {
    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    public override val id: UInt = 200u

    public override val crcExtra: Byte = -122

    public override fun deserialize(bytes: ByteArray): GimbalReport {
      val decoder = MavDataDecoder.wrap(bytes)

      val deltaTime = decoder.safeDecodeFloat()
      val deltaAngleX = decoder.safeDecodeFloat()
      val deltaAngleY = decoder.safeDecodeFloat()
      val deltaAngleZ = decoder.safeDecodeFloat()
      val deltaVelocityX = decoder.safeDecodeFloat()
      val deltaVelocityY = decoder.safeDecodeFloat()
      val deltaVelocityZ = decoder.safeDecodeFloat()
      val jointRoll = decoder.safeDecodeFloat()
      val jointEl = decoder.safeDecodeFloat()
      val jointAz = decoder.safeDecodeFloat()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

      return GimbalReport(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        deltaTime = deltaTime,
        deltaAngleX = deltaAngleX,
        deltaAngleY = deltaAngleY,
        deltaAngleZ = deltaAngleZ,
        deltaVelocityX = deltaVelocityX,
        deltaVelocityY = deltaVelocityY,
        deltaVelocityZ = deltaVelocityZ,
        jointRoll = jointRoll,
        jointEl = jointEl,
        jointAz = jointAz,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GimbalReport =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var deltaTime: Float = 0F

    public var deltaAngleX: Float = 0F

    public var deltaAngleY: Float = 0F

    public var deltaAngleZ: Float = 0F

    public var deltaVelocityX: Float = 0F

    public var deltaVelocityY: Float = 0F

    public var deltaVelocityZ: Float = 0F

    public var jointRoll: Float = 0F

    public var jointEl: Float = 0F

    public var jointAz: Float = 0F

    public fun build(): GimbalReport = GimbalReport(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      deltaTime = deltaTime,
      deltaAngleX = deltaAngleX,
      deltaAngleY = deltaAngleY,
      deltaAngleZ = deltaAngleZ,
      deltaVelocityX = deltaVelocityX,
      deltaVelocityY = deltaVelocityY,
      deltaVelocityZ = deltaVelocityZ,
      jointRoll = jointRoll,
      jointEl = jointEl,
      jointAz = jointAz,
    )
  }
}
