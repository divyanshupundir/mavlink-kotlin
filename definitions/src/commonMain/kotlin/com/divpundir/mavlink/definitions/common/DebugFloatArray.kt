package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * Large debug/prototyping array. The message uses the maximum available payload for data. The
 * array_id and name fields are used to discriminate between messages in code and in user interfaces
 * (respectively). Do not use in production code.
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param name Name, for human-friendly display in a Ground Control Station
 * @param arrayId Unique ID used to discriminate between arrays
 * @param data data
 */
@GeneratedMavMessage(
  id = 350u,
  crcExtra = -24,
)
public data class DebugFloatArray(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Name, for human-friendly display in a Ground Control Station
   */
  @GeneratedMavField(type = "char[10]")
  public val name: String = "",
  /**
   * Unique ID used to discriminate between arrays
   */
  @GeneratedMavField(type = "uint16_t")
  public val arrayId: UShort = 0u,
  /**
   * data
   */
  @GeneratedMavField(
    type = "float[58]",
    extension = true,
  )
  public val `data`: List<Float> = emptyList(),
) : MavMessage<DebugFloatArray> {
  override val instanceCompanion: MavMessage.MavCompanion<DebugFloatArray> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt16(arrayId)
    encoder.encodeString(name, 10)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt16(arrayId)
    encoder.encodeString(name, 10)
    encoder.encodeFloatArray(data, 232)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<DebugFloatArray> {
    private const val SIZE_V1: Int = 20

    private const val SIZE_V2: Int = 252

    override val id: UInt = 350u

    override val crcExtra: Byte = -24

    override fun deserialize(bytes: ByteArray): DebugFloatArray {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val arrayId = decoder.safeDecodeUInt16()
      val name = decoder.safeDecodeString(10)
      val data = decoder.safeDecodeFloatArray(232)

      return DebugFloatArray(
        timeUsec = timeUsec,
        name = name,
        arrayId = arrayId,
        data = data,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): DebugFloatArray =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var name: String = ""

    public var arrayId: UShort = 0u

    public var `data`: List<Float> = emptyList()

    public fun build(): DebugFloatArray = DebugFloatArray(
      timeUsec = timeUsec,
      name = name,
      arrayId = arrayId,
      data = data,
    )
  }
}
