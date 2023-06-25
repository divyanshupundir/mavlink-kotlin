package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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
    val buffer = Buffer()
    buffer.encodeFloat(deltaTime)
    buffer.encodeFloat(deltaAngleX)
    buffer.encodeFloat(deltaAngleY)
    buffer.encodeFloat(deltaAngleZ)
    buffer.encodeFloat(deltaVelocityX)
    buffer.encodeFloat(deltaVelocityY)
    buffer.encodeFloat(deltaVelocityZ)
    buffer.encodeFloat(jointRoll)
    buffer.encodeFloat(jointEl)
    buffer.encodeFloat(jointAz)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(deltaTime)
    buffer.encodeFloat(deltaAngleX)
    buffer.encodeFloat(deltaAngleY)
    buffer.encodeFloat(deltaAngleZ)
    buffer.encodeFloat(deltaVelocityX)
    buffer.encodeFloat(deltaVelocityY)
    buffer.encodeFloat(deltaVelocityZ)
    buffer.encodeFloat(jointRoll)
    buffer.encodeFloat(jointEl)
    buffer.encodeFloat(jointAz)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GimbalReport> {
    public override val id: UInt = 200u

    public override val crcExtra: Byte = -122

    public override fun deserialize(bytes: ByteArray): GimbalReport {
      val buffer = Buffer().write(bytes)

      val deltaTime = buffer.decodeFloat()
      val deltaAngleX = buffer.decodeFloat()
      val deltaAngleY = buffer.decodeFloat()
      val deltaAngleZ = buffer.decodeFloat()
      val deltaVelocityX = buffer.decodeFloat()
      val deltaVelocityY = buffer.decodeFloat()
      val deltaVelocityZ = buffer.decodeFloat()
      val jointRoll = buffer.decodeFloat()
      val jointEl = buffer.decodeFloat()
      val jointAz = buffer.decodeFloat()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()

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
