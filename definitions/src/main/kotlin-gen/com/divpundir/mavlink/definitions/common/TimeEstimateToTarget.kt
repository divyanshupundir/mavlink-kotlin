package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

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
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(safeReturn)
    outputBuffer.encodeInt32(land)
    outputBuffer.encodeInt32(missionNextItem)
    outputBuffer.encodeInt32(missionEnd)
    outputBuffer.encodeInt32(commandedAction)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(safeReturn)
    outputBuffer.encodeInt32(land)
    outputBuffer.encodeInt32(missionNextItem)
    outputBuffer.encodeInt32(missionEnd)
    outputBuffer.encodeInt32(commandedAction)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<TimeEstimateToTarget> {
    private const val SIZE_V1: Int = 20

    private const val SIZE_V2: Int = 20

    public override val id: UInt = 380u

    public override val crcExtra: Byte = -24

    public override fun deserialize(bytes: ByteArray): TimeEstimateToTarget {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val safeReturn = inputBuffer.decodeInt32()
      val land = inputBuffer.decodeInt32()
      val missionNextItem = inputBuffer.decodeInt32()
      val missionEnd = inputBuffer.decodeInt32()
      val commandedAction = inputBuffer.decodeInt32()

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
