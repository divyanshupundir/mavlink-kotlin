package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Time/duration estimates for various events and actions given the current vehicle state and
 * position.
 *
 * @param safeReturn Estimated time to complete the vehicle's configured "safe return" action from
 * its current position (e.g. RTL, Smart RTL, etc.). -1 indicates that the vehicle is landed, or that
 * no time estimate available.
 * units = s
 * @param land Estimated time for vehicle to complete the LAND action from its current position. -1
 * indicates that the vehicle is landed, or that no time estimate available.
 * units = s
 * @param missionNextItem Estimated time for reaching/completing the currently active mission
 * item. -1 means no time estimate available.
 * units = s
 * @param missionEnd Estimated time for completing the current mission. -1 means no mission active
 * and/or no estimate available.
 * units = s
 * @param commandedAction Estimated time for completing the current commanded action (i.e. Go To,
 * Takeoff, Land, etc.). -1 means no action active and/or no estimate available.
 * units = s
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 380u,
  crcExtra = -24,
)
public data class TimeEstimateToTarget(
  /**
   * Estimated time to complete the vehicle's configured "safe return" action from its current
   * position (e.g. RTL, Smart RTL, etc.). -1 indicates that the vehicle is landed, or that no time
   * estimate available.
   * units = s
   */
  @GeneratedMavField(type = "int32_t")
  public val safeReturn: Int = 0,
  /**
   * Estimated time for vehicle to complete the LAND action from its current position. -1 indicates
   * that the vehicle is landed, or that no time estimate available.
   * units = s
   */
  @GeneratedMavField(type = "int32_t")
  public val land: Int = 0,
  /**
   * Estimated time for reaching/completing the currently active mission item. -1 means no time
   * estimate available.
   * units = s
   */
  @GeneratedMavField(type = "int32_t")
  public val missionNextItem: Int = 0,
  /**
   * Estimated time for completing the current mission. -1 means no mission active and/or no
   * estimate available.
   * units = s
   */
  @GeneratedMavField(type = "int32_t")
  public val missionEnd: Int = 0,
  /**
   * Estimated time for completing the current commanded action (i.e. Go To, Takeoff, Land,
   * etc.). -1 means no action active and/or no estimate available.
   * units = s
   */
  @GeneratedMavField(type = "int32_t")
  public val commandedAction: Int = 0,
) : MavMessage<TimeEstimateToTarget> {
  override val instanceCompanion: MavMessage.MavCompanion<TimeEstimateToTarget> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt32(safeReturn)
    encoder.encodeInt32(land)
    encoder.encodeInt32(missionNextItem)
    encoder.encodeInt32(missionEnd)
    encoder.encodeInt32(commandedAction)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt32(safeReturn)
    encoder.encodeInt32(land)
    encoder.encodeInt32(missionNextItem)
    encoder.encodeInt32(missionEnd)
    encoder.encodeInt32(commandedAction)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<TimeEstimateToTarget> {
    private const val SIZE_V1: Int = 20

    private const val SIZE_V2: Int = 20

    override val id: UInt = 380u

    override val crcExtra: Byte = -24

    override fun deserialize(bytes: ByteArray): TimeEstimateToTarget {
      val decoder = MavDataDecoder(bytes)

      val safeReturn = decoder.safeDecodeInt32()
      val land = decoder.safeDecodeInt32()
      val missionNextItem = decoder.safeDecodeInt32()
      val missionEnd = decoder.safeDecodeInt32()
      val commandedAction = decoder.safeDecodeInt32()

      return TimeEstimateToTarget(
        safeReturn = safeReturn,
        land = land,
        missionNextItem = missionNextItem,
        missionEnd = missionEnd,
        commandedAction = commandedAction,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): TimeEstimateToTarget =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var safeReturn: Int = 0

    public var land: Int = 0

    public var missionNextItem: Int = 0

    public var missionEnd: Int = 0

    public var commandedAction: Int = 0

    public fun build(): TimeEstimateToTarget = TimeEstimateToTarget(
      safeReturn = safeReturn,
      land = land,
      missionNextItem = missionNextItem,
      missionEnd = missionEnd,
      commandedAction = commandedAction,
    )
  }
}
