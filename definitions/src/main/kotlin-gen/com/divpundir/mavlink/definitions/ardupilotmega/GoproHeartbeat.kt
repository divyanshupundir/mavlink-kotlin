package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Heartbeat from a HeroBus attached GoPro.
 */
@GeneratedMavMessage(
  id = 215u,
  crcExtra = 101,
)
public data class GoproHeartbeat(
  /**
   * Status.
   */
  @GeneratedMavField(type = "uint8_t")
  public val status: MavEnumValue<GoproHeartbeatStatus> = MavEnumValue.fromValue(0u),
  /**
   * Current capture mode.
   */
  @GeneratedMavField(type = "uint8_t")
  public val captureMode: MavEnumValue<GoproCaptureMode> = MavEnumValue.fromValue(0u),
  /**
   * Additional status bits.
   */
  @GeneratedMavField(type = "uint8_t")
  public val flags: MavBitmaskValue<GoproHeartbeatFlags> = MavBitmaskValue.fromValue(0u),
) : MavMessage<GoproHeartbeat> {
  public override val instanceMetadata: MavMessage.Metadata<GoproHeartbeat> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(status.value, 1)
    outputBuffer.encodeEnumValue(captureMode.value, 1)
    outputBuffer.encodeBitmaskValue(flags.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(status.value, 1)
    outputBuffer.encodeEnumValue(captureMode.value, 1)
    outputBuffer.encodeBitmaskValue(flags.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 215u

    private const val CRC_EXTRA: Byte = 101

    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 3

    private val DESERIALIZER: MavDeserializer<GoproHeartbeat> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val status = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GoproHeartbeatStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val captureMode = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GoproCaptureMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val flags = inputBuffer.decodeBitmaskValue(1).let { value ->
        val flags = GoproHeartbeatFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      GoproHeartbeat(
        status = status,
        captureMode = captureMode,
        flags = flags,
      )
    }


    private val METADATA: MavMessage.Metadata<GoproHeartbeat> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GoproHeartbeat> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GoproHeartbeat =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var status: MavEnumValue<GoproHeartbeatStatus> = MavEnumValue.fromValue(0u)

    public var captureMode: MavEnumValue<GoproCaptureMode> = MavEnumValue.fromValue(0u)

    public var flags: MavBitmaskValue<GoproHeartbeatFlags> = MavBitmaskValue.fromValue(0u)

    public fun build(): GoproHeartbeat = GoproHeartbeat(
      status = status,
      captureMode = captureMode,
      flags = flags,
    )
  }
}
