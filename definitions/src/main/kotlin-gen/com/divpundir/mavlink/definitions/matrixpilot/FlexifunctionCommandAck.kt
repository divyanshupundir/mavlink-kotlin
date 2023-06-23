package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Acknowldge sucess or failure of a flexifunction command
 */
@GeneratedMavMessage(
  id = 158u,
  crcExtra = -48,
)
public data class FlexifunctionCommandAck(
  /**
   * Command acknowledged
   */
  @GeneratedMavField(type = "uint16_t")
  public val commandType: UShort = 0u,
  /**
   * result of acknowledge
   */
  @GeneratedMavField(type = "uint16_t")
  public val result: UShort = 0u,
) : MavMessage<FlexifunctionCommandAck> {
  public override val instanceCompanion: MavMessage.MavCompanion<FlexifunctionCommandAck> =
      Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(commandType)
    output.encodeUInt16(result)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(commandType)
    output.encodeUInt16(result)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<FlexifunctionCommandAck> {
    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 4

    public override val id: UInt = 158u

    public override val crcExtra: Byte = -48

    public override fun deserialize(source: BufferedSource): FlexifunctionCommandAck {
      val commandType = source.decodeUInt16()
      val result = source.decodeUInt16()

      return FlexifunctionCommandAck(
        commandType = commandType,
        result = result,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FlexifunctionCommandAck =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var commandType: UShort = 0u

    public var result: UShort = 0u

    public fun build(): FlexifunctionCommandAck = FlexifunctionCommandAck(
      commandType = commandType,
      result = result,
    )
  }
}
