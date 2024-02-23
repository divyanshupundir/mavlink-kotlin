package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Message to a gimbal manager to correct the gimbal roll angle. This message is typically used to
 * manually correct for a tilted horizon in operation. A gimbal device is never to react to this
 * message.
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param gimbalId Gimbal ID of the gimbal manager to address (component ID or 1-6 for non-MAVLink
 * gimbal, 0 for all gimbals). Send command multiple times for more than one but not all gimbals.
 * @param client Client which is contacting the gimbal manager (must be set).
 * @param roll Roll angle (positive to roll to the right).
 * units = rad
 */
@GeneratedMavMessage(
  id = 60_014u,
  crcExtra = -122,
)
public data class Storm32GimbalManagerCorrectRoll(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Gimbal ID of the gimbal manager to address (component ID or 1-6 for non-MAVLink gimbal, 0 for
   * all gimbals). Send command multiple times for more than one but not all gimbals.
   */
  @GeneratedMavField(type = "uint8_t")
  public val gimbalId: UByte = 0u,
  /**
   * Client which is contacting the gimbal manager (must be set).
   */
  @GeneratedMavField(type = "uint8_t")
  public val client: MavEnumValue<MavStorm32GimbalManagerClient> = MavEnumValue.fromValue(0u),
  /**
   * Roll angle (positive to roll to the right).
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
) : MavMessage<Storm32GimbalManagerCorrectRoll> {
  override val instanceCompanion: MavMessage.MavCompanion<Storm32GimbalManagerCorrectRoll> =
      Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(roll)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(gimbalId)
    encoder.encodeEnumValue(client.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(roll)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(gimbalId)
    encoder.encodeEnumValue(client.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Storm32GimbalManagerCorrectRoll> {
    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 8

    override val id: UInt = 60_014u

    override val crcExtra: Byte = -122

    override fun deserialize(bytes: ByteArray): Storm32GimbalManagerCorrectRoll {
      val decoder = MavDataDecoder(bytes)

      val roll = decoder.safeDecodeFloat()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val gimbalId = decoder.safeDecodeUInt8()
      val client = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavStorm32GimbalManagerClient.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return Storm32GimbalManagerCorrectRoll(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        gimbalId = gimbalId,
        client = client,
        roll = roll,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Storm32GimbalManagerCorrectRoll =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var gimbalId: UByte = 0u

    public var client: MavEnumValue<MavStorm32GimbalManagerClient> = MavEnumValue.fromValue(0u)

    public var roll: Float = 0F

    public fun build(): Storm32GimbalManagerCorrectRoll = Storm32GimbalManagerCorrectRoll(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      gimbalId = gimbalId,
      client = client,
      roll = roll,
    )
  }
}
