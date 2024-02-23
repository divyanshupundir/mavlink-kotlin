package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Settings of a camera. Can be requested with a MAV_CMD_REQUEST_MESSAGE command.
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param modeId Camera mode
 * @param zoomlevel Current zoom level as a percentage of the full range (0.0 to 100.0, NaN if not
 * known)
 * @param focuslevel Current focus level as a percentage of the full range (0.0 to 100.0, NaN if not
 * known)
 */
@GeneratedMavMessage(
  id = 260u,
  crcExtra = -110,
)
public data class CameraSettings(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Camera mode
   */
  @GeneratedMavField(type = "uint8_t")
  public val modeId: MavEnumValue<CameraMode> = MavEnumValue.fromValue(0u),
  /**
   * Current zoom level as a percentage of the full range (0.0 to 100.0, NaN if not known)
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val zoomlevel: Float = 0F,
  /**
   * Current focus level as a percentage of the full range (0.0 to 100.0, NaN if not known)
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val focuslevel: Float = 0F,
) : MavMessage<CameraSettings> {
  override val instanceCompanion: MavMessage.MavCompanion<CameraSettings> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeEnumValue(modeId.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeEnumValue(modeId.value, 1)
    encoder.encodeFloat(zoomlevel)
    encoder.encodeFloat(focuslevel)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CameraSettings> {
    private const val SIZE_V1: Int = 5

    private const val SIZE_V2: Int = 13

    override val id: UInt = 260u

    override val crcExtra: Byte = -110

    override fun deserialize(bytes: ByteArray): CameraSettings {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val modeId = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = CameraMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val zoomlevel = decoder.safeDecodeFloat()
      val focuslevel = decoder.safeDecodeFloat()

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
