package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit

/**
 * Transmitter (remote ID system) is enabled and ready to start sending location and other required
 * information. This is streamed by transmitter. A flight controller uses it as a condition to arm.
 *
 * @param status Status level indicating if arming is allowed.
 * @param error Text error message, should be empty if status is good to arm. Fill with nulls in
 * unused portion.
 */
@GeneratedMavMessage(
  id = 12_918u,
  crcExtra = -117,
)
public data class OpenDroneIdArmStatus(
  /**
   * Status level indicating if arming is allowed.
   */
  @GeneratedMavField(type = "uint8_t")
  public val status: MavEnumValue<MavOdidArmStatus> = MavEnumValue.fromValue(0u),
  /**
   * Text error message, should be empty if status is good to arm. Fill with nulls in unused
   * portion.
   */
  @GeneratedMavField(type = "char[50]")
  public val error: String = "",
) : MavMessage<OpenDroneIdArmStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<OpenDroneIdArmStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeEnumValue(status.value, 1)
    encoder.encodeString(error, 50)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeEnumValue(status.value, 1)
    encoder.encodeString(error, 50)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OpenDroneIdArmStatus> {
    private const val SIZE_V1: Int = 51

    private const val SIZE_V2: Int = 51

    override val id: UInt = 12_918u

    override val crcExtra: Byte = -117

    override fun deserialize(bytes: ByteArray): OpenDroneIdArmStatus {
      val decoder = MavDataDecoder(bytes)

      val status = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavOdidArmStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val error = decoder.safeDecodeString(50)

      return OpenDroneIdArmStatus(
        status = status,
        error = error,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): OpenDroneIdArmStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var status: MavEnumValue<MavOdidArmStatus> = MavEnumValue.fromValue(0u)

    public var error: String = ""

    public fun build(): OpenDroneIdArmStatus = OpenDroneIdArmStatus(
      status = status,
      error = error,
    )
  }
}
