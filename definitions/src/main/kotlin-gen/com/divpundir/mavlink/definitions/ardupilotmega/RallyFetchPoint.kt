package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(idx)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(idx)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RallyFetchPoint> {
    public override val id: UInt = 176u

    public override val crcExtra: Byte = -22

    public override fun deserialize(bytes: ByteArray): RallyFetchPoint {
      val buffer = Buffer().write(bytes)

      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val idx = buffer.decodeUInt8()

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
