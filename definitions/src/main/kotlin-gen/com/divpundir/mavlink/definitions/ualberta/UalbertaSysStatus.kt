package com.divpundir.mavlink.definitions.ualberta

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

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

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(mode)
    outputBuffer.encodeUInt8(navMode)
    outputBuffer.encodeUInt8(pilot)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(mode)
    outputBuffer.encodeUInt8(navMode)
    outputBuffer.encodeUInt8(pilot)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<UalbertaSysStatus> {
    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 3

    public override val id: UInt = 222u

    public override val crcExtra: Byte = 15

    public override fun deserialize(bytes: ByteArray): UalbertaSysStatus {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val mode = inputBuffer.decodeUInt8()
      val navMode = inputBuffer.decodeUInt8()
      val pilot = inputBuffer.decodeUInt8()

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
