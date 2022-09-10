package xyz.urbanmatrix.mavlink.definitions.asluav

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Off-board controls/commands for ASLUAVs
 */
@GeneratedMavMessage(
  id = 8008,
  crc = 234,
)
public data class AslObctrl(
  /**
   *  Time since system start
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: BigInteger = BigInteger.ZERO,
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
  public val obctrlStatus: Int = 0,
) : MavMessage<AslObctrl> {
  public override val instanceMetadata: MavMessage.Metadata<AslObctrl> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeFloat(uelev)
    outputBuffer.encodeFloat(uthrot)
    outputBuffer.encodeFloat(uthrot2)
    outputBuffer.encodeFloat(uaill)
    outputBuffer.encodeFloat(uailr)
    outputBuffer.encodeFloat(urud)
    outputBuffer.encodeUint8(obctrlStatus)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeFloat(uelev)
    outputBuffer.encodeFloat(uthrot)
    outputBuffer.encodeFloat(uthrot2)
    outputBuffer.encodeFloat(uaill)
    outputBuffer.encodeFloat(uailr)
    outputBuffer.encodeFloat(urud)
    outputBuffer.encodeUint8(obctrlStatus)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 8008

    private const val CRC: Int = 234

    private const val SIZE_V1: Int = 33

    private const val SIZE_V2: Int = 33

    private val DESERIALIZER: MavDeserializer<AslObctrl> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUint64()
      val uelev = inputBuffer.decodeFloat()
      val uthrot = inputBuffer.decodeFloat()
      val uthrot2 = inputBuffer.decodeFloat()
      val uaill = inputBuffer.decodeFloat()
      val uailr = inputBuffer.decodeFloat()
      val urud = inputBuffer.decodeFloat()
      val obctrlStatus = inputBuffer.decodeUint8()

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


    private val METADATA: MavMessage.Metadata<AslObctrl> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AslObctrl> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: BigInteger = BigInteger.ZERO

    public var uelev: Float = 0F

    public var uthrot: Float = 0F

    public var uthrot2: Float = 0F

    public var uaill: Float = 0F

    public var uailr: Float = 0F

    public var urud: Float = 0F

    public var obctrlStatus: Int = 0

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
