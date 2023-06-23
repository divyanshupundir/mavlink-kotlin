package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Settings of a camera. Can be requested with a MAV_CMD_REQUEST_MESSAGE command.
 */
@GeneratedMavMessage(
  id = 260u,
  crcExtra = -110,
)
public data class CameraSettings(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Camera mode
   */
  @GeneratedMavField(type = "uint8_t")
  public val modeId: MavEnumValue<CameraMode> = MavEnumValue.fromValue(0u),
  /**
   * Current zoom level (0.0 to 100.0, NaN if not known)
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val zoomlevel: Float = 0F,
  /**
   * Current focus level (0.0 to 100.0, NaN if not known)
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val focuslevel: Float = 0F,
) : MavMessage<CameraSettings> {
  public override val instanceCompanion: MavMessage.MavCompanion<CameraSettings> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeEnumValue(modeId.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeEnumValue(modeId.value, 1)
    output.encodeFloat(zoomlevel)
    output.encodeFloat(focuslevel)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<CameraSettings> {
    private const val SIZE_V1: Int = 5

    private const val SIZE_V2: Int = 13

    public override val id: UInt = 260u

    public override val crcExtra: Byte = -110

    public override fun deserialize(source: BufferedSource): CameraSettings {
      val timeBootMs = source.decodeUInt32()
      val modeId = source.decodeEnumValue(1).let { value ->
        val entry = CameraMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val zoomlevel = source.decodeFloat()
      val focuslevel = source.decodeFloat()

      return CameraSettings(
        timeBootMs = timeBootMs,
        modeId = modeId,
        zoomlevel = zoomlevel,
        focuslevel = focuslevel,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CameraSettings =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var modeId: MavEnumValue<CameraMode> = MavEnumValue.fromValue(0u)

    public var zoomlevel: Float = 0F

    public var focuslevel: Float = 0F

    public fun build(): CameraSettings = CameraSettings(
      timeBootMs = timeBootMs,
      modeId = modeId,
      zoomlevel = zoomlevel,
      focuslevel = focuslevel,
    )
  }
}
