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
import kotlin.ByteArray
import kotlin.Float
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeEnumValue(modeId.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeEnumValue(modeId.value, 1)
    buffer.encodeFloat(zoomlevel)
    buffer.encodeFloat(focuslevel)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CameraSettings> {
    public override val id: UInt = 260u

    public override val crcExtra: Byte = -110

    public override fun deserialize(bytes: ByteArray): CameraSettings {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val modeId = buffer.decodeEnumValue(1).let { value ->
        val entry = CameraMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val zoomlevel = buffer.decodeFloat()
      val focuslevel = buffer.decodeFloat()

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
