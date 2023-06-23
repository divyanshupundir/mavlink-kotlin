package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Request a current rally point from MAV. MAV should respond with a RALLY_POINT message. MAV should
 * not respond if the request is invalid.
 */
@GeneratedMavMessage(
  id = 176u,
  crcExtra = -22,
)
public data class RallyFetchPoint(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Point index (first point is 0).
   */
  @GeneratedMavField(type = "uint8_t")
  public val idx: UByte = 0u,
) : MavMessage<RallyFetchPoint> {
  public override val instanceCompanion: MavMessage.MavCompanion<RallyFetchPoint> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(idx)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(idx)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<RallyFetchPoint> {
    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 3

    public override val id: UInt = 176u

    public override val crcExtra: Byte = -22

    public override fun deserialize(source: BufferedSource): RallyFetchPoint {
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val idx = source.decodeUInt8()

      return RallyFetchPoint(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idx = idx,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): RallyFetchPoint =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var idx: UByte = 0u

    public fun build(): RallyFetchPoint = RallyFetchPoint(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      idx = idx,
    )
  }
}
