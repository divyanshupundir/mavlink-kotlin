package com.divpundir.mavlink.definitions.matrixpilot

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
    val buffer = Buffer()
    buffer.encodeFloat(angleOfAttackNormal)
    buffer.encodeFloat(angleOfAttackInverted)
    buffer.encodeFloat(elevatorTrimNormal)
    buffer.encodeFloat(elevatorTrimInverted)
    buffer.encodeFloat(referenceSpeed)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(angleOfAttackNormal)
    buffer.encodeFloat(angleOfAttackInverted)
    buffer.encodeFloat(elevatorTrimNormal)
    buffer.encodeFloat(elevatorTrimInverted)
    buffer.encodeFloat(referenceSpeed)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF18> {
    public override val id: UInt = 184u

    public override val crcExtra: Byte = 41

    public override fun deserialize(bytes: ByteArray): SerialUdbExtraF18 {
      val buffer = Buffer().write(bytes)

      val angleOfAttackNormal = buffer.decodeFloat()
      val angleOfAttackInverted = buffer.decodeFloat()
      val elevatorTrimNormal = buffer.decodeFloat()
      val elevatorTrimInverted = buffer.decodeFloat()
      val referenceSpeed = buffer.decodeFloat()

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
