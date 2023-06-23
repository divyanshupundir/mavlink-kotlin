package com.divpundir.mavlink.definitions.ualberta

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
 * System status specific to ualberta uav
 */
@GeneratedMavMessage(
  id = 222u,
  crcExtra = 15,
)
public data class UalbertaSysStatus(
  /**
   * System mode, see UALBERTA_AUTOPILOT_MODE ENUM
   */
  @GeneratedMavField(type = "uint8_t")
  public val mode: UByte = 0u,
  /**
   * Navigation mode, see UALBERTA_NAV_MODE ENUM
   */
  @GeneratedMavField(type = "uint8_t")
  public val navMode: UByte = 0u,
  /**
   * Pilot mode, see UALBERTA_PILOT_MODE
   */
  @GeneratedMavField(type = "uint8_t")
  public val pilot: UByte = 0u,
) : MavMessage<UalbertaSysStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<UalbertaSysStatus> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(mode)
    output.encodeUInt8(navMode)
    output.encodeUInt8(pilot)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(mode)
    output.encodeUInt8(navMode)
    output.encodeUInt8(pilot)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<UalbertaSysStatus> {
    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 3

    public override val id: UInt = 222u

    public override val crcExtra: Byte = 15

    public override fun deserialize(source: BufferedSource): UalbertaSysStatus {
      val mode = source.decodeUInt8()
      val navMode = source.decodeUInt8()
      val pilot = source.decodeUInt8()

      return UalbertaSysStatus(
        mode = mode,
        navMode = navMode,
        pilot = pilot,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): UalbertaSysStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var mode: UByte = 0u

    public var navMode: UByte = 0u

    public var pilot: UByte = 0u

    public fun build(): UalbertaSysStatus = UalbertaSysStatus(
      mode = mode,
      navMode = navMode,
      pilot = pilot,
    )
  }
}
