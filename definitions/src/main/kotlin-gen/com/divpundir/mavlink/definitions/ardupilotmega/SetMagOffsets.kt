package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Set the magnetometer offsets
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
  public override val instanceCompanion: MavMessage.MavCompanion<SetMagOffsets> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt16(magOfsX)
    buffer.encodeInt16(magOfsY)
    buffer.encodeInt16(magOfsZ)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt16(magOfsX)
    buffer.encodeInt16(magOfsY)
    buffer.encodeInt16(magOfsZ)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SetMagOffsets> {
    public override val id: UInt = 151u

    public override val crcExtra: Byte = -37

    public override fun deserialize(bytes: ByteArray): SetMagOffsets {
      val buffer = Buffer().write(bytes)

      val magOfsX = buffer.decodeInt16()
      val magOfsY = buffer.decodeInt16()
      val magOfsZ = buffer.decodeInt16()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()

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
