package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * To debug something using a named 3D vector.
 */
@GeneratedMavMessage(
  id = 250u,
  crcExtra = 49,
)
public data class DebugVect(
  /**
   * Name
   */
  @GeneratedMavField(type = "char[10]")
  public val name: String = "",
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * x
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * y
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * z
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
) : MavMessage<DebugVect> {
  public override val instanceMetadata: MavMessage.Metadata<DebugVect> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeString(name, 10)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeString(name, 10)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 250u

    private const val CRC_EXTRA: Byte = 49

    private const val SIZE_V1: Int = 30

    private const val SIZE_V2: Int = 30

    private val DESERIALIZER: MavDeserializer<DebugVect> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val x = inputBuffer.decodeFloat()
      val y = inputBuffer.decodeFloat()
      val z = inputBuffer.decodeFloat()
      val name = inputBuffer.decodeString(10)

      DebugVect(
        name = name,
        timeUsec = timeUsec,
        x = x,
        y = y,
        z = z,
      )
    }


    private val METADATA: MavMessage.Metadata<DebugVect> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DebugVect> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): DebugVect =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var name: String = ""

    public var timeUsec: ULong = 0uL

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public fun build(): DebugVect = DebugVect(
      name = name,
      timeUsec = timeUsec,
      x = x,
      y = y,
      z = z,
    )
  }
}
