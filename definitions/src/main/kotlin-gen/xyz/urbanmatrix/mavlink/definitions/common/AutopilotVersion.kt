package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array

/**
 * Version and capability of autopilot software. This should be emitted in response to a request
 * with MAV_CMD_REQUEST_MESSAGE.
 */
@GeneratedMavMessage(
  id = 148,
  crc = 178,
)
public data class AutopilotVersion(
  /**
   * Bitmap of capabilities
   */
  public val capabilities: MavEnumValue<MavProtocolCapability> = MavEnumValue.fromValue(0),
  /**
   * Firmware version number
   */
  public val flightSwVersion: Long = 0L,
  /**
   * Middleware version number
   */
  public val middlewareSwVersion: Long = 0L,
  /**
   * Operating system version number
   */
  public val osSwVersion: Long = 0L,
  /**
   * HW / board version (last 8 bits should be silicon ID, if any). The first 16 bits of this field
   * specify https://github.com/PX4/PX4-Bootloader/blob/master/board_types.txt
   */
  public val boardVersion: Long = 0L,
  /**
   * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique
   * identifier, but should allow to identify the commit using the main version number even for very
   * large code bases.
   */
  public val flightCustomVersion: List<Int> = emptyList(),
  /**
   * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique
   * identifier, but should allow to identify the commit using the main version number even for very
   * large code bases.
   */
  public val middlewareCustomVersion: List<Int> = emptyList(),
  /**
   * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique
   * identifier, but should allow to identify the commit using the main version number even for very
   * large code bases.
   */
  public val osCustomVersion: List<Int> = emptyList(),
  /**
   * ID of the board vendor
   */
  public val vendorId: Int = 0,
  /**
   * ID of the product
   */
  public val productId: Int = 0,
  /**
   * UID if provided by hardware (see uid2)
   */
  public val uid: BigInteger = BigInteger.ZERO,
  /**
   * UID if provided by hardware (supersedes the uid field. If this is non-zero, use this field,
   * otherwise use uid)
   */
  public val uid2: List<Int> = emptyList(),
) : MavMessage<AutopilotVersion> {
  public override val instanceMetadata: MavMessage.Metadata<AutopilotVersion> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(capabilities.value, 8)
    outputBuffer.encodeUint64(uid)
    outputBuffer.encodeUint32(flightSwVersion)
    outputBuffer.encodeUint32(middlewareSwVersion)
    outputBuffer.encodeUint32(osSwVersion)
    outputBuffer.encodeUint32(boardVersion)
    outputBuffer.encodeUint16(vendorId)
    outputBuffer.encodeUint16(productId)
    outputBuffer.encodeUint8Array(flightCustomVersion, 8)
    outputBuffer.encodeUint8Array(middlewareCustomVersion, 8)
    outputBuffer.encodeUint8Array(osCustomVersion, 8)
    outputBuffer.encodeUint8Array(uid2, 18)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 148

    private const val CRC: Int = 178

    private const val SIZE: Int = 78

    private val DESERIALIZER: MavDeserializer<AutopilotVersion> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val capabilities = inputBuffer.decodeEnumValue(8).let { value ->
        val entry = MavProtocolCapability.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val uid = inputBuffer.decodeUint64()
      val flightSwVersion = inputBuffer.decodeUint32()
      val middlewareSwVersion = inputBuffer.decodeUint32()
      val osSwVersion = inputBuffer.decodeUint32()
      val boardVersion = inputBuffer.decodeUint32()
      val vendorId = inputBuffer.decodeUint16()
      val productId = inputBuffer.decodeUint16()
      val flightCustomVersion = inputBuffer.decodeUint8Array(8)
      val middlewareCustomVersion = inputBuffer.decodeUint8Array(8)
      val osCustomVersion = inputBuffer.decodeUint8Array(8)
      val uid2 = inputBuffer.decodeUint8Array(18)

      AutopilotVersion(
        capabilities = capabilities,
        flightSwVersion = flightSwVersion,
        middlewareSwVersion = middlewareSwVersion,
        osSwVersion = osSwVersion,
        boardVersion = boardVersion,
        flightCustomVersion = flightCustomVersion,
        middlewareCustomVersion = middlewareCustomVersion,
        osCustomVersion = osCustomVersion,
        vendorId = vendorId,
        productId = productId,
        uid = uid,
        uid2 = uid2,
      )
    }


    private val METADATA: MavMessage.Metadata<AutopilotVersion> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AutopilotVersion> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var capabilities: MavEnumValue<MavProtocolCapability> = MavEnumValue.fromValue(0)

    public var flightSwVersion: Long = 0L

    public var middlewareSwVersion: Long = 0L

    public var osSwVersion: Long = 0L

    public var boardVersion: Long = 0L

    public var flightCustomVersion: List<Int> = emptyList()

    public var middlewareCustomVersion: List<Int> = emptyList()

    public var osCustomVersion: List<Int> = emptyList()

    public var vendorId: Int = 0

    public var productId: Int = 0

    public var uid: BigInteger = BigInteger.ZERO

    public var uid2: List<Int> = emptyList()

    public fun build(): AutopilotVersion = AutopilotVersion(
      capabilities = capabilities,
      flightSwVersion = flightSwVersion,
      middlewareSwVersion = middlewareSwVersion,
      osSwVersion = osSwVersion,
      boardVersion = boardVersion,
      flightCustomVersion = flightCustomVersion,
      middlewareCustomVersion = middlewareCustomVersion,
      osCustomVersion = osCustomVersion,
      vendorId = vendorId,
      productId = productId,
      uid = uid,
      uid2 = uid2,
    )
  }
}
