package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Estimator status message including flags, innovation test ratios and estimated accuracies. The
 * flags message is an integer bitmask containing information on which EKF outputs are valid. See the
 * ESTIMATOR_STATUS_FLAGS enum definition for further information. The innovation test ratios show the
 * magnitude of the sensor innovation divided by the innovation check threshold. Under normal operation
 * the innovation test ratios should be below 0.5 with occasional values up to 1.0. Values greater than
 * 1.0 should be rare under normal operation and indicate that a measurement has been rejected by the
 * filter. The user should be notified if an innovation test ratio greater than 1.0 is recorded.
 * Notifications for values in the range between 0.5 and 1.0 should be optional and controllable by the
 * user.
 */
@GeneratedMavMessage(
  id = 230u,
  crcExtra = -93,
)
public data class EstimatorStatus(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Bitmap indicating which EKF outputs are valid.
   */
  @GeneratedMavField(type = "uint16_t")
  public val flags: MavBitmaskValue<EstimatorStatusFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Velocity innovation test ratio
   */
  @GeneratedMavField(type = "float")
  public val velRatio: Float = 0F,
  /**
   * Horizontal position innovation test ratio
   */
  @GeneratedMavField(type = "float")
  public val posHorizRatio: Float = 0F,
  /**
   * Vertical position innovation test ratio
   */
  @GeneratedMavField(type = "float")
  public val posVertRatio: Float = 0F,
  /**
   * Magnetometer innovation test ratio
   */
  @GeneratedMavField(type = "float")
  public val magRatio: Float = 0F,
  /**
   * Height above terrain innovation test ratio
   */
  @GeneratedMavField(type = "float")
  public val haglRatio: Float = 0F,
  /**
   * True airspeed innovation test ratio
   */
  @GeneratedMavField(type = "float")
  public val tasRatio: Float = 0F,
  /**
   * Horizontal position 1-STD accuracy relative to the EKF local origin
   */
  @GeneratedMavField(type = "float")
  public val posHorizAccuracy: Float = 0F,
  /**
   * Vertical position 1-STD accuracy relative to the EKF local origin
   */
  @GeneratedMavField(type = "float")
  public val posVertAccuracy: Float = 0F,
) : MavMessage<EstimatorStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<EstimatorStatus> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloat(velRatio)
    output.encodeFloat(posHorizRatio)
    output.encodeFloat(posVertRatio)
    output.encodeFloat(magRatio)
    output.encodeFloat(haglRatio)
    output.encodeFloat(tasRatio)
    output.encodeFloat(posHorizAccuracy)
    output.encodeFloat(posVertAccuracy)
    output.encodeBitmaskValue(flags.value, 2)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloat(velRatio)
    output.encodeFloat(posHorizRatio)
    output.encodeFloat(posVertRatio)
    output.encodeFloat(magRatio)
    output.encodeFloat(haglRatio)
    output.encodeFloat(tasRatio)
    output.encodeFloat(posHorizAccuracy)
    output.encodeFloat(posVertAccuracy)
    output.encodeBitmaskValue(flags.value, 2)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<EstimatorStatus> {
    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    public override val id: UInt = 230u

    public override val crcExtra: Byte = -93

    public override fun deserialize(source: BufferedSource): EstimatorStatus {
      val timeUsec = source.decodeUInt64()
      val velRatio = source.decodeFloat()
      val posHorizRatio = source.decodeFloat()
      val posVertRatio = source.decodeFloat()
      val magRatio = source.decodeFloat()
      val haglRatio = source.decodeFloat()
      val tasRatio = source.decodeFloat()
      val posHorizAccuracy = source.decodeFloat()
      val posVertAccuracy = source.decodeFloat()
      val flags = source.decodeBitmaskValue(2).let { value ->
        val flags = EstimatorStatusFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      return EstimatorStatus(
        timeUsec = timeUsec,
        flags = flags,
        velRatio = velRatio,
        posHorizRatio = posHorizRatio,
        posVertRatio = posVertRatio,
        magRatio = magRatio,
        haglRatio = haglRatio,
        tasRatio = tasRatio,
        posHorizAccuracy = posHorizAccuracy,
        posVertAccuracy = posVertAccuracy,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): EstimatorStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var flags: MavBitmaskValue<EstimatorStatusFlags> = MavBitmaskValue.fromValue(0u)

    public var velRatio: Float = 0F

    public var posHorizRatio: Float = 0F

    public var posVertRatio: Float = 0F

    public var magRatio: Float = 0F

    public var haglRatio: Float = 0F

    public var tasRatio: Float = 0F

    public var posHorizAccuracy: Float = 0F

    public var posVertAccuracy: Float = 0F

    public fun build(): EstimatorStatus = EstimatorStatus(
      timeUsec = timeUsec,
      flags = flags,
      velRatio = velRatio,
      posHorizRatio = posHorizRatio,
      posVertRatio = posVertRatio,
      magRatio = magRatio,
      haglRatio = haglRatio,
      tasRatio = tasRatio,
      posHorizAccuracy = posHorizAccuracy,
      posVertAccuracy = posVertAccuracy,
    )
  }
}
