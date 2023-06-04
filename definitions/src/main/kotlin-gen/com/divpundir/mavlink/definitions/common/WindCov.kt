package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * Wind estimate from vehicle. Note that despite the name, this message does not actually contain
 * any covariances but instead variability and accuracy fields in terms of standard deviation (1-STD).
 */
@GeneratedMavMessage(
  id = 231u,
  crcExtra = 105,
)
public data class WindCov(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Wind in North (NED) direction (NAN if unknown)
   */
  @GeneratedMavField(type = "float")
  public val windX: Float = 0F,
  /**
   * Wind in East (NED) direction (NAN if unknown)
   */
  @GeneratedMavField(type = "float")
  public val windY: Float = 0F,
  /**
   * Wind in down (NED) direction (NAN if unknown)
   */
  @GeneratedMavField(type = "float")
  public val windZ: Float = 0F,
  /**
   * Variability of wind in XY, 1-STD estimated from a 1 Hz lowpassed wind estimate (NAN if unknown)
   */
  @GeneratedMavField(type = "float")
  public val varHoriz: Float = 0F,
  /**
   * Variability of wind in Z, 1-STD estimated from a 1 Hz lowpassed wind estimate (NAN if unknown)
   */
  @GeneratedMavField(type = "float")
  public val varVert: Float = 0F,
  /**
   * Altitude (MSL) that this measurement was taken at (NAN if unknown)
   */
  @GeneratedMavField(type = "float")
  public val windAlt: Float = 0F,
  /**
   * Horizontal speed 1-STD accuracy (0 if unknown)
   */
  @GeneratedMavField(type = "float")
  public val horizAccuracy: Float = 0F,
  /**
   * Vertical speed 1-STD accuracy (0 if unknown)
   */
  @GeneratedMavField(type = "float")
  public val vertAccuracy: Float = 0F,
) : MavMessage<WindCov> {
  public override val instanceCompanion: MavMessage.MavCompanion<WindCov> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(windX)
    outputBuffer.encodeFloat(windY)
    outputBuffer.encodeFloat(windZ)
    outputBuffer.encodeFloat(varHoriz)
    outputBuffer.encodeFloat(varVert)
    outputBuffer.encodeFloat(windAlt)
    outputBuffer.encodeFloat(horizAccuracy)
    outputBuffer.encodeFloat(vertAccuracy)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(windX)
    outputBuffer.encodeFloat(windY)
    outputBuffer.encodeFloat(windZ)
    outputBuffer.encodeFloat(varHoriz)
    outputBuffer.encodeFloat(varVert)
    outputBuffer.encodeFloat(windAlt)
    outputBuffer.encodeFloat(horizAccuracy)
    outputBuffer.encodeFloat(vertAccuracy)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<WindCov> {
    private const val SIZE_V1: Int = 40

    private const val SIZE_V2: Int = 40

    public override val id: UInt = 231u

    public override val crcExtra: Byte = 105

    public override fun deserialize(bytes: ByteArray): WindCov {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val windX = inputBuffer.decodeFloat()
      val windY = inputBuffer.decodeFloat()
      val windZ = inputBuffer.decodeFloat()
      val varHoriz = inputBuffer.decodeFloat()
      val varVert = inputBuffer.decodeFloat()
      val windAlt = inputBuffer.decodeFloat()
      val horizAccuracy = inputBuffer.decodeFloat()
      val vertAccuracy = inputBuffer.decodeFloat()

      return WindCov(
        timeUsec = timeUsec,
        windX = windX,
        windY = windY,
        windZ = windZ,
        varHoriz = varHoriz,
        varVert = varVert,
        windAlt = windAlt,
        horizAccuracy = horizAccuracy,
        vertAccuracy = vertAccuracy,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): WindCov =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var windX: Float = 0F

    public var windY: Float = 0F

    public var windZ: Float = 0F

    public var varHoriz: Float = 0F

    public var varVert: Float = 0F

    public var windAlt: Float = 0F

    public var horizAccuracy: Float = 0F

    public var vertAccuracy: Float = 0F

    public fun build(): WindCov = WindCov(
      timeUsec = timeUsec,
      windX = windX,
      windY = windY,
      windZ = windZ,
      varHoriz = varHoriz,
      varVert = varVert,
      windAlt = windAlt,
      horizAccuracy = horizAccuracy,
      vertAccuracy = vertAccuracy,
    )
  }
}
