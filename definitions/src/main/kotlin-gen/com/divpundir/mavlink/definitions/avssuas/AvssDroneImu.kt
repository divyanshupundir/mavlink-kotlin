package com.divpundir.mavlink.definitions.avssuas

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 *  Drone IMU data. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0
 * 0).
 */
@GeneratedMavMessage(
  id = 60_052u,
  crcExtra = 101,
)
public data class AvssDroneImu(
  /**
   * Timestamp (time since FC boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Quaternion component 1, w (1 in null-rotation)
   */
  @GeneratedMavField(type = "float")
  public val q1: Float = 0F,
  /**
   * Quaternion component 2, x (0 in null-rotation)
   */
  @GeneratedMavField(type = "float")
  public val q2: Float = 0F,
  /**
   * Quaternion component 3, y (0 in null-rotation)
   */
  @GeneratedMavField(type = "float")
  public val q3: Float = 0F,
  /**
   * Quaternion component 4, z (0 in null-rotation)
   */
  @GeneratedMavField(type = "float")
  public val q4: Float = 0F,
  /**
   * X acceleration
   */
  @GeneratedMavField(type = "float")
  public val xacc: Float = 0F,
  /**
   * Y acceleration
   */
  @GeneratedMavField(type = "float")
  public val yacc: Float = 0F,
  /**
   * Z acceleration
   */
  @GeneratedMavField(type = "float")
  public val zacc: Float = 0F,
  /**
   * Angular speed around X axis
   */
  @GeneratedMavField(type = "float")
  public val xgyro: Float = 0F,
  /**
   * Angular speed around Y axis
   */
  @GeneratedMavField(type = "float")
  public val ygyro: Float = 0F,
  /**
   * Angular speed around Z axis
   */
  @GeneratedMavField(type = "float")
  public val zgyro: Float = 0F,
) : MavMessage<AvssDroneImu> {
  public override val instanceCompanion: MavMessage.MavCompanion<AvssDroneImu> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeFloat(q1)
    buffer.encodeFloat(q2)
    buffer.encodeFloat(q3)
    buffer.encodeFloat(q4)
    buffer.encodeFloat(xacc)
    buffer.encodeFloat(yacc)
    buffer.encodeFloat(zacc)
    buffer.encodeFloat(xgyro)
    buffer.encodeFloat(ygyro)
    buffer.encodeFloat(zgyro)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeFloat(q1)
    buffer.encodeFloat(q2)
    buffer.encodeFloat(q3)
    buffer.encodeFloat(q4)
    buffer.encodeFloat(xacc)
    buffer.encodeFloat(yacc)
    buffer.encodeFloat(zacc)
    buffer.encodeFloat(xgyro)
    buffer.encodeFloat(ygyro)
    buffer.encodeFloat(zgyro)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AvssDroneImu> {
    public override val id: UInt = 60_052u

    public override val crcExtra: Byte = 101

    public override fun deserialize(bytes: ByteArray): AvssDroneImu {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val q1 = buffer.decodeFloat()
      val q2 = buffer.decodeFloat()
      val q3 = buffer.decodeFloat()
      val q4 = buffer.decodeFloat()
      val xacc = buffer.decodeFloat()
      val yacc = buffer.decodeFloat()
      val zacc = buffer.decodeFloat()
      val xgyro = buffer.decodeFloat()
      val ygyro = buffer.decodeFloat()
      val zgyro = buffer.decodeFloat()

      return AvssDroneImu(
        timeBootMs = timeBootMs,
        q1 = q1,
        q2 = q2,
        q3 = q3,
        q4 = q4,
        xacc = xacc,
        yacc = yacc,
        zacc = zacc,
        xgyro = xgyro,
        ygyro = ygyro,
        zgyro = zgyro,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AvssDroneImu =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var q1: Float = 0F

    public var q2: Float = 0F

    public var q3: Float = 0F

    public var q4: Float = 0F

    public var xacc: Float = 0F

    public var yacc: Float = 0F

    public var zacc: Float = 0F

    public var xgyro: Float = 0F

    public var ygyro: Float = 0F

    public var zgyro: Float = 0F

    public fun build(): AvssDroneImu = AvssDroneImu(
      timeBootMs = timeBootMs,
      q1 = q1,
      q2 = q2,
      q3 = q3,
      q4 = q4,
      xacc = xacc,
      yacc = yacc,
      zacc = zacc,
      xgyro = xgyro,
      ygyro = ygyro,
      zgyro = zgyro,
    )
  }
}
