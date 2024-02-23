package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Request to control this MAV
 *
 * @param targetSystem System the GCS requests control for
 * @param controlRequest 0: request control of this MAV, 1: Release control of this MAV
 * @param version 0: key as plaintext, 1-255: future, different hashing/encryption variants. The GCS
 * should in general use the safest mode possible initially and then gradually move down the encryption
 * level if it gets a NACK message indicating an encryption mismatch.
 * units = rad
 * @param passkey Password / Key, depending on version plaintext or encrypted. 25 or less
 * characters, NULL terminated. The characters may involve A-Z, a-z, 0-9, and "!?,.-"
 */
@GeneratedMavMessage(
  id = 5u,
  crcExtra = -39,
)
public data class ChangeOperatorControl(
  /**
   * System the GCS requests control for
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * 0: request control of this MAV, 1: Release control of this MAV
   */
  @GeneratedMavField(type = "uint8_t")
  public val controlRequest: UByte = 0u,
  /**
   * 0: key as plaintext, 1-255: future, different hashing/encryption variants. The GCS should in
   * general use the safest mode possible initially and then gradually move down the encryption level
   * if it gets a NACK message indicating an encryption mismatch.
   * units = rad
   */
  @GeneratedMavField(type = "uint8_t")
  public val version: UByte = 0u,
  /**
   * Password / Key, depending on version plaintext or encrypted. 25 or less characters, NULL
   * terminated. The characters may involve A-Z, a-z, 0-9, and "!?,.-"
   */
  @GeneratedMavField(type = "char[25]")
  public val passkey: String = "",
) : MavMessage<ChangeOperatorControl> {
  override val instanceCompanion: MavMessage.MavCompanion<ChangeOperatorControl> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(controlRequest)
    encoder.encodeUInt8(version)
    encoder.encodeString(passkey, 25)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(controlRequest)
    encoder.encodeUInt8(version)
    encoder.encodeString(passkey, 25)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ChangeOperatorControl> {
    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    override val id: UInt = 5u

    override val crcExtra: Byte = -39

    override fun deserialize(bytes: ByteArray): ChangeOperatorControl {
      val decoder = MavDataDecoder(bytes)

      val targetSystem = decoder.safeDecodeUInt8()
      val controlRequest = decoder.safeDecodeUInt8()
      val version = decoder.safeDecodeUInt8()
      val passkey = decoder.safeDecodeString(25)

      return ChangeOperatorControl(
        targetSystem = targetSystem,
        controlRequest = controlRequest,
        version = version,
        passkey = passkey,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ChangeOperatorControl =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var controlRequest: UByte = 0u

    public var version: UByte = 0u

    public var passkey: String = ""

    public fun build(): ChangeOperatorControl = ChangeOperatorControl(
      targetSystem = targetSystem,
      controlRequest = controlRequest,
      version = version,
      passkey = passkey,
    )
  }
}
