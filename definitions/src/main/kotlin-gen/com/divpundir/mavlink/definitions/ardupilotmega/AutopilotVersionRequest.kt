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
 * Request the autopilot version from the system/component.
 */
@GeneratedMavMessage(
  id = 183u,
  crcExtra = 85,
)
public data class AutopilotVersionRequest(
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
) : MavMessage<AutopilotVersionRequest> {
  public override val instanceCompanion: MavMessage.MavCompanion<AutopilotVersionRequest> =
      Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AutopilotVersionRequest> {
    public override val id: UInt = 183u

    public override val crcExtra: Byte = 85

    public override fun deserialize(bytes: ByteArray): AutopilotVersionRequest {
      val buffer = Buffer().write(bytes)

      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()

      return AutopilotVersionRequest(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AutopilotVersionRequest =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public fun build(): AutopilotVersionRequest = AutopilotVersionRequest(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
    )
  }
}
