package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Set the magnetometer offsets
 *
 * @param targetSystem System ID.
 * @param targetComponent Component ID.
 * @param magOfsX Magnetometer X offset.
 * @param magOfsY Magnetometer Y offset.
 * @param magOfsZ Magnetometer Z offset.
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 151u,
  crcExtra = -37,
)
public data class SetMagOffsets(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Magnetometer X offset.
   */
  @GeneratedMavField(type = "int16_t")
  public val magOfsX: Short = 0,
  /**
   * Magnetometer Y offset.
   */
  @GeneratedMavField(type = "int16_t")
  public val magOfsY: Short = 0,
  /**
   * Magnetometer Z offset.
   */
  @GeneratedMavField(type = "int16_t")
  public val magOfsZ: Short = 0,
) : MavMessage<SetMagOffsets> {
  override val instanceCompanion: MavMessage.MavCompanion<SetMagOffsets> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt16(magOfsX)
    encoder.encodeInt16(magOfsY)
    encoder.encodeInt16(magOfsZ)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt16(magOfsX)
    encoder.encodeInt16(magOfsY)
    encoder.encodeInt16(magOfsZ)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SetMagOffsets> {
    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 8

    override val id: UInt = 151u

    override val crcExtra: Byte = -37

    override fun deserialize(bytes: ByteArray): SetMagOffsets {
      val decoder = MavDataDecoder(bytes)

      val magOfsX = decoder.safeDecodeInt16()
      val magOfsY = decoder.safeDecodeInt16()
      val magOfsZ = decoder.safeDecodeInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

      return SetMagOffsets(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        magOfsX = magOfsX,
        magOfsY = magOfsY,
        magOfsZ = magOfsZ,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SetMagOffsets =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var magOfsX: Short = 0

    public var magOfsY: Short = 0

    public var magOfsZ: Short = 0

    public fun build(): SetMagOffsets = SetMagOffsets(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      magOfsX = magOfsX,
      magOfsY = magOfsY,
      magOfsZ = magOfsZ,
    )
  }
}
