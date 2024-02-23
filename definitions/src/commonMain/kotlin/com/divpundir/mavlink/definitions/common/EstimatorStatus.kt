package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

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
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param flags Bitmap indicating which EKF outputs are valid.
 * @param velRatio Velocity innovation test ratio
 * @param posHorizRatio Horizontal position innovation test ratio
 * @param posVertRatio Vertical position innovation test ratio
 * @param magRatio Magnetometer innovation test ratio
 * @param haglRatio Height above terrain innovation test ratio
 * @param tasRatio True airspeed innovation test ratio
 * @param posHorizAccuracy Horizontal position 1-STD accuracy relative to the EKF local origin
 * units = m
 * @param posVertAccuracy Vertical position 1-STD accuracy relative to the EKF local origin
 * units = m
 */
@GeneratedMavMessage(
  id = 230u,
  crcExtra = -93,
)
public data class EstimatorStatus(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
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
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val posHorizAccuracy: Float = 0F,
  /**
   * Vertical position 1-STD accuracy relative to the EKF local origin
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val posVertAccuracy: Float = 0F,
) : MavMessage<EstimatorStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<EstimatorStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(velRatio)
    encoder.encodeFloat(posHorizRatio)
    encoder.encodeFloat(posVertRatio)
    encoder.encodeFloat(magRatio)
    encoder.encodeFloat(haglRatio)
    encoder.encodeFloat(tasRatio)
    encoder.encodeFloat(posHorizAccuracy)
    encoder.encodeFloat(posVertAccuracy)
    encoder.encodeBitmaskValue(flags.value, 2)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(velRatio)
    encoder.encodeFloat(posHorizRatio)
    encoder.encodeFloat(posVertRatio)
    encoder.encodeFloat(magRatio)
    encoder.encodeFloat(haglRatio)
    encoder.encodeFloat(tasRatio)
    encoder.encodeFloat(posHorizAccuracy)
    encoder.encodeFloat(posVertAccuracy)
    encoder.encodeBitmaskValue(flags.value, 2)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<EstimatorStatus> {
    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    override val id: UInt = 230u

    override val crcExtra: Byte = -93

    override fun deserialize(bytes: ByteArray): EstimatorStatus {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val velRatio = decoder.safeDecodeFloat()
      val posHorizRatio = decoder.safeDecodeFloat()
      val posVertRatio = decoder.safeDecodeFloat()
      val magRatio = decoder.safeDecodeFloat()
      val haglRatio = decoder.safeDecodeFloat()
      val tasRatio = decoder.safeDecodeFloat()
      val posHorizAccuracy = decoder.safeDecodeFloat()
      val posVertAccuracy = decoder.safeDecodeFloat()
      val flags = decoder.safeDecodeBitmaskValue(2).let { value ->
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
