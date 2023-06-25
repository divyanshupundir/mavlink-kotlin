package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Time/duration estimates for various events and actions given the current vehicle state and
 * position.
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
   */
  @GeneratedMavField(type = "int32_t")
  public val safeReturn: Int = 0,
  /**
   * Estimated time for vehicle to complete the LAND action from its current position. -1 indicates
   * that the vehicle is landed, or that no time estimate available.
   */
  @GeneratedMavField(type = "int32_t")
  public val land: Int = 0,
  /**
   * Estimated time for reaching/completing the currently active mission item. -1 means no time
   * estimate available.
   */
  @GeneratedMavField(type = "int32_t")
  public val missionNextItem: Int = 0,
  /**
   * Estimated time for completing the current mission. -1 means no mission active and/or no
   * estimate available.
   */
  @GeneratedMavField(type = "int32_t")
  public val missionEnd: Int = 0,
  /**
   * Estimated time for completing the current commanded action (i.e. Go To, Takeoff, Land,
   * etc.). -1 means no action active and/or no estimate available.
   */
  @GeneratedMavField(type = "int32_t")
  public val commandedAction: Int = 0,
) : MavMessage<TimeEstimateToTarget> {
  public override val instanceCompanion: MavMessage.MavCompanion<TimeEstimateToTarget> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt32(safeReturn)
    buffer.encodeInt32(land)
    buffer.encodeInt32(missionNextItem)
    buffer.encodeInt32(missionEnd)
    buffer.encodeInt32(commandedAction)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt32(safeReturn)
    buffer.encodeInt32(land)
    buffer.encodeInt32(missionNextItem)
    buffer.encodeInt32(missionEnd)
    buffer.encodeInt32(commandedAction)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<TimeEstimateToTarget> {
    public override val id: UInt = 380u

    public override val crcExtra: Byte = -24

    public override fun deserialize(bytes: ByteArray): TimeEstimateToTarget {
      val buffer = Buffer().write(bytes)

      val safeReturn = buffer.decodeInt32()
      val land = buffer.decodeInt32()
      val missionNextItem = buffer.decodeInt32()
      val missionEnd = buffer.decodeInt32()
      val commandedAction = buffer.decodeInt32()

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
