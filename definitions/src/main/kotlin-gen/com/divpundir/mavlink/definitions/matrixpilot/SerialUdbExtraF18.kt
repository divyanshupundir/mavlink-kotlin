package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F18 format
 */
@GeneratedMavMessage(
  id = 184u,
  crcExtra = 41,
)
public data class SerialUdbExtraF18(
  /**
   * SUE Angle of Attack Normal
   */
  @GeneratedMavField(type = "float")
  public val angleOfAttackNormal: Float = 0F,
  /**
   * SUE Angle of Attack Inverted
   */
  @GeneratedMavField(type = "float")
  public val angleOfAttackInverted: Float = 0F,
  /**
   * SUE Elevator Trim Normal
   */
  @GeneratedMavField(type = "float")
  public val elevatorTrimNormal: Float = 0F,
  /**
   * SUE Elevator Trim Inverted
   */
  @GeneratedMavField(type = "float")
  public val elevatorTrimInverted: Float = 0F,
  /**
   * SUE reference_speed
   */
  @GeneratedMavField(type = "float")
  public val referenceSpeed: Float = 0F,
) : MavMessage<SerialUdbExtraF18> {
  public override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF18> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(angleOfAttackNormal)
    outputBuffer.encodeFloat(angleOfAttackInverted)
    outputBuffer.encodeFloat(elevatorTrimNormal)
    outputBuffer.encodeFloat(elevatorTrimInverted)
    outputBuffer.encodeFloat(referenceSpeed)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(angleOfAttackNormal)
    outputBuffer.encodeFloat(angleOfAttackInverted)
    outputBuffer.encodeFloat(elevatorTrimNormal)
    outputBuffer.encodeFloat(elevatorTrimInverted)
    outputBuffer.encodeFloat(referenceSpeed)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF18> {
    private const val SIZE_V1: Int = 20

    private const val SIZE_V2: Int = 20

    public override val id: UInt = 184u

    public override val crcExtra: Byte = 41

    public override fun deserialize(bytes: ByteArray): SerialUdbExtraF18 {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val angleOfAttackNormal = inputBuffer.decodeFloat()
      val angleOfAttackInverted = inputBuffer.decodeFloat()
      val elevatorTrimNormal = inputBuffer.decodeFloat()
      val elevatorTrimInverted = inputBuffer.decodeFloat()
      val referenceSpeed = inputBuffer.decodeFloat()

      return SerialUdbExtraF18(
        angleOfAttackNormal = angleOfAttackNormal,
        angleOfAttackInverted = angleOfAttackInverted,
        elevatorTrimNormal = elevatorTrimNormal,
        elevatorTrimInverted = elevatorTrimInverted,
        referenceSpeed = referenceSpeed,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SerialUdbExtraF18 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var angleOfAttackNormal: Float = 0F

    public var angleOfAttackInverted: Float = 0F

    public var elevatorTrimNormal: Float = 0F

    public var elevatorTrimInverted: Float = 0F

    public var referenceSpeed: Float = 0F

    public fun build(): SerialUdbExtraF18 = SerialUdbExtraF18(
      angleOfAttackNormal = angleOfAttackNormal,
      angleOfAttackInverted = angleOfAttackInverted,
      elevatorTrimNormal = elevatorTrimNormal,
      elevatorTrimInverted = elevatorTrimInverted,
      referenceSpeed = referenceSpeed,
    )
  }
}
