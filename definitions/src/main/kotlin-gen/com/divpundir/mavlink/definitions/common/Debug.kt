package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Send a debug value. The index is used to discriminate between values. These values show up in the
 * plot of QGroundControl as DEBUG N.
 */
@GeneratedMavMessage(
  id = 254u,
  crcExtra = 46,
)
public data class Debug(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * index of debug variable
   */
  @GeneratedMavField(type = "uint8_t")
  public val ind: UByte = 0u,
  /**
   * DEBUG value
   */
  @GeneratedMavField(type = "float")
  public val `value`: Float = 0F,
) : MavMessage<Debug> {
  public override val instanceMetadata: MavMessage.Metadata<Debug> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeFloat(value)
    outputBuffer.encodeUInt8(ind)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeFloat(value)
    outputBuffer.encodeUInt8(ind)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 254u

    private const val CRC_EXTRA: Byte = 46

    private const val SIZE_V1: Int = 9

    private const val SIZE_V2: Int = 9

    private val DESERIALIZER: MavDeserializer<Debug> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val value = inputBuffer.decodeFloat()
      val ind = inputBuffer.decodeUInt8()

      Debug(
        timeBootMs = timeBootMs,
        ind = ind,
        value = value,
      )
    }


    private val METADATA: MavMessage.Metadata<Debug> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Debug> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Debug =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var ind: UByte = 0u

    public var `value`: Float = 0F

    public fun build(): Debug = Debug(
      timeBootMs = timeBootMs,
      ind = ind,
      value = value,
    )
  }
}
