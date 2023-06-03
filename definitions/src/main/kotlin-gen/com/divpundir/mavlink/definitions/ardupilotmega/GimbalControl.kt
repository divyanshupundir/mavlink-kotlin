package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

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
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(demandedRateX)
    outputBuffer.encodeFloat(demandedRateY)
    outputBuffer.encodeFloat(demandedRateZ)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(demandedRateX)
    outputBuffer.encodeFloat(demandedRateY)
    outputBuffer.encodeFloat(demandedRateZ)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GimbalControl> {
    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 14

    public override val id: UInt = 201u

    public override val crcExtra: Byte = -51

    public override fun deserialize(bytes: ByteArray): GimbalControl {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val demandedRateX = inputBuffer.decodeFloat()
      val demandedRateY = inputBuffer.decodeFloat()
      val demandedRateZ = inputBuffer.decodeFloat()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()

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
