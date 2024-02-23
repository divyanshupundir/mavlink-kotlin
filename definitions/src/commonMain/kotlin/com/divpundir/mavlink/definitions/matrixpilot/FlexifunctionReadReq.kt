package com.divpundir.mavlink.definitions.matrixpilot

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
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Request reading of flexifunction data
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param readReqType Type of flexifunction data requested
 * @param dataIndex index into data where needed
 */
@GeneratedMavMessage(
  id = 151u,
  crcExtra = 26,
)
public data class FlexifunctionReadReq(
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
   * Type of flexifunction data requested
   */
  @GeneratedMavField(type = "int16_t")
  public val readReqType: Short = 0,
  /**
   * index into data where needed
   */
  @GeneratedMavField(type = "int16_t")
  public val dataIndex: Short = 0,
) : MavMessage<FlexifunctionReadReq> {
  override val instanceCompanion: MavMessage.MavCompanion<FlexifunctionReadReq> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt16(readReqType)
    encoder.encodeInt16(dataIndex)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt16(readReqType)
    encoder.encodeInt16(dataIndex)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FlexifunctionReadReq> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    override val id: UInt = 151u

    override val crcExtra: Byte = 26

    override fun deserialize(bytes: ByteArray): FlexifunctionReadReq {
      val decoder = MavDataDecoder(bytes)

      val readReqType = decoder.safeDecodeInt16()
      val dataIndex = decoder.safeDecodeInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

      return FlexifunctionReadReq(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        readReqType = readReqType,
        dataIndex = dataIndex,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FlexifunctionReadReq =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var readReqType: Short = 0

    public var dataIndex: Short = 0

    public fun build(): FlexifunctionReadReq = FlexifunctionReadReq(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      readReqType = readReqType,
      dataIndex = dataIndex,
    )
  }
}
