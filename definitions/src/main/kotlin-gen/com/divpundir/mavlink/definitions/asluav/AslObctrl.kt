package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
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
import kotlin.ULong
import kotlin.Unit

/**
 * Off-board controls/commands for ASLUAVs
 */
@GeneratedMavMessage(
  id = 8_008u,
  crcExtra = -22,
)
public data class AslObctrl(
  /**
   *  Time since system start
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   *  Elevator command [~]
   */
  @GeneratedMavField(type = "float")
  public val uelev: Float = 0F,
  /**
   *  Throttle command [~]
   */
  @GeneratedMavField(type = "float")
  public val uthrot: Float = 0F,
  /**
   *  Throttle 2 command [~]
   */
  @GeneratedMavField(type = "float")
  public val uthrot2: Float = 0F,
  /**
   *  Left aileron command [~]
   */
  @GeneratedMavField(type = "float")
  public val uaill: Float = 0F,
  /**
   *  Right aileron command [~]
   */
  @GeneratedMavField(type = "float")
  public val uailr: Float = 0F,
  /**
   *  Rudder command [~]
   */
  @GeneratedMavField(type = "float")
  public val urud: Float = 0F,
  /**
   *  Off-board computer status
   */
  @GeneratedMavField(type = "uint8_t")
  public val obctrlStatus: UByte = 0u,
) : MavMessage<AslObctrl> {
  public override val instanceMetadata: MavMessage.Metadata<AslObctrl> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeFloat(uelev)
    outputBuffer.encodeFloat(uthrot)
    outputBuffer.encodeFloat(uthrot2)
    outputBuffer.encodeFloat(uaill)
    outputBuffer.encodeFloat(uailr)
    outputBuffer.encodeFloat(urud)
    outputBuffer.encodeUInt8(obctrlStatus)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeFloat(uelev)
    outputBuffer.encodeFloat(uthrot)
    outputBuffer.encodeFloat(uthrot2)
    outputBuffer.encodeFloat(uaill)
    outputBuffer.encodeFloat(uailr)
    outputBuffer.encodeFloat(urud)
    outputBuffer.encodeUInt8(obctrlStatus)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 8_008u

    private const val CRC_EXTRA: Byte = -22

    private const val SIZE_V1: Int = 33

    private const val SIZE_V2: Int = 33

    private val DESERIALIZER: MavDeserializer<AslObctrl> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUInt64()
      val uelev = inputBuffer.decodeFloat()
      val uthrot = inputBuffer.decodeFloat()
      val uthrot2 = inputBuffer.decodeFloat()
      val uaill = inputBuffer.decodeFloat()
      val uailr = inputBuffer.decodeFloat()
      val urud = inputBuffer.decodeFloat()
      val obctrlStatus = inputBuffer.decodeUInt8()

      AslObctrl(
        timestamp = timestamp,
        uelev = uelev,
        uthrot = uthrot,
        uthrot2 = uthrot2,
        uaill = uaill,
        uailr = uailr,
        urud = urud,
        obctrlStatus = obctrlStatus,
      )
    }


    private val METADATA: MavMessage.Metadata<AslObctrl> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AslObctrl> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): AslObctrl =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: ULong = 0uL

    public var uelev: Float = 0F

    public var uthrot: Float = 0F

    public var uthrot2: Float = 0F

    public var uaill: Float = 0F

    public var uailr: Float = 0F

    public var urud: Float = 0F

    public var obctrlStatus: UByte = 0u

    public fun build(): AslObctrl = AslObctrl(
      timestamp = timestamp,
      uelev = uelev,
      uthrot = uthrot,
      uthrot2 = uthrot2,
      uaill = uaill,
      uailr = uailr,
      urud = urud,
      obctrlStatus = obctrlStatus,
    )
  }
}
