package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Status of compassmot calibration.
 */
@GeneratedMavMessage(
  id = 177u,
  crcExtra = -16,
)
public data class CompassmotStatus(
  /**
   * Throttle.
   */
  @GeneratedMavField(type = "uint16_t")
  public val throttle: UShort = 0u,
  /**
   * Current.
   */
  @GeneratedMavField(type = "float")
  public val current: Float = 0F,
  /**
   * Interference.
   */
  @GeneratedMavField(type = "uint16_t")
  public val interference: UShort = 0u,
  /**
   * Motor Compensation X.
   */
  @GeneratedMavField(type = "float")
  public val compensationx: Float = 0F,
  /**
   * Motor Compensation Y.
   */
  @GeneratedMavField(type = "float")
  public val compensationy: Float = 0F,
  /**
   * Motor Compensation Z.
   */
  @GeneratedMavField(type = "float")
  public val compensationz: Float = 0F,
) : MavMessage<CompassmotStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<CompassmotStatus> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(current)
    outputBuffer.encodeFloat(compensationx)
    outputBuffer.encodeFloat(compensationy)
    outputBuffer.encodeFloat(compensationz)
    outputBuffer.encodeUInt16(throttle)
    outputBuffer.encodeUInt16(interference)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(current)
    outputBuffer.encodeFloat(compensationx)
    outputBuffer.encodeFloat(compensationy)
    outputBuffer.encodeFloat(compensationz)
    outputBuffer.encodeUInt16(throttle)
    outputBuffer.encodeUInt16(interference)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CompassmotStatus> {
    private const val SIZE_V1: Int = 20

    private const val SIZE_V2: Int = 20

    public override val id: UInt = 177u

    public override val crcExtra: Byte = -16

    public override fun deserialize(bytes: ByteArray): CompassmotStatus {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val current = inputBuffer.decodeFloat()
      val compensationx = inputBuffer.decodeFloat()
      val compensationy = inputBuffer.decodeFloat()
      val compensationz = inputBuffer.decodeFloat()
      val throttle = inputBuffer.decodeUInt16()
      val interference = inputBuffer.decodeUInt16()

      return CompassmotStatus(
        throttle = throttle,
        current = current,
        interference = interference,
        compensationx = compensationx,
        compensationy = compensationy,
        compensationz = compensationz,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CompassmotStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var throttle: UShort = 0u

    public var current: Float = 0F

    public var interference: UShort = 0u

    public var compensationx: Float = 0F

    public var compensationy: Float = 0F

    public var compensationz: Float = 0F

    public fun build(): CompassmotStatus = CompassmotStatus(
      throttle = throttle,
      current = current,
      interference = interference,
      compensationx = compensationx,
      compensationy = compensationy,
      compensationz = compensationz,
    )
  }
}
