package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

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
  public override val instanceMetadata: MavMessage.Metadata<CameraSettings> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeEnumValue(modeId.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeEnumValue(modeId.value, 1)
    outputBuffer.encodeFloat(zoomlevel)
    outputBuffer.encodeFloat(focuslevel)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 260u

    private const val CRC_EXTRA: Byte = -110

    private const val SIZE_V1: Int = 5

    private const val SIZE_V2: Int = 13

    private val DESERIALIZER: MavDeserializer<CameraSettings> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val modeId = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = CameraMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val zoomlevel = inputBuffer.decodeFloat()
      val focuslevel = inputBuffer.decodeFloat()

      CameraSettings(
        timeBootMs = timeBootMs,
        modeId = modeId,
        zoomlevel = zoomlevel,
        focuslevel = focuslevel,
      )
    }


    private val METADATA: MavMessage.Metadata<CameraSettings> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CameraSettings> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): CameraSettings =
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
