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
 * Control message for rate gimbal.
 */
@GeneratedMavMessage(
  id = 201u,
  crcExtra = -51,
)
public data class GimbalControl(
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
   * Demanded angular rate X.
   */
  @GeneratedMavField(type = "float")
  public val demandedRateX: Float = 0F,
  /**
   * Demanded angular rate Y.
   */
  @GeneratedMavField(type = "float")
  public val demandedRateY: Float = 0F,
  /**
   * Demanded angular rate Z.
   */
  @GeneratedMavField(type = "float")
  public val demandedRateZ: Float = 0F,
) : MavMessage<GimbalControl> {
  public override val instanceCompanion: MavMessage.MavCompanion<GimbalControl> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(demandedRateX)
    buffer.encodeFloat(demandedRateY)
    buffer.encodeFloat(demandedRateZ)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(demandedRateX)
    buffer.encodeFloat(demandedRateY)
    buffer.encodeFloat(demandedRateZ)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GimbalControl> {
    public override val id: UInt = 201u

    public override val crcExtra: Byte = -51

    public override fun deserialize(bytes: ByteArray): GimbalControl {
      val buffer = Buffer().write(bytes)

      val demandedRateX = buffer.decodeFloat()
      val demandedRateY = buffer.decodeFloat()
      val demandedRateZ = buffer.decodeFloat()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()

      return GimbalControl(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        demandedRateX = demandedRateX,
        demandedRateY = demandedRateY,
        demandedRateZ = demandedRateZ,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GimbalControl =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var demandedRateX: Float = 0F

    public var demandedRateY: Float = 0F

    public var demandedRateZ: Float = 0F

    public fun build(): GimbalControl = GimbalControl(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      demandedRateX = demandedRateX,
      demandedRateY = demandedRateY,
      demandedRateZ = demandedRateZ,
    )
  }
}
