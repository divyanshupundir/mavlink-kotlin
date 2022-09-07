package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * General status information of an UAVCAN node. Please refer to the definition of the UAVCAN
 * message "uavcan.protocol.NodeStatus" for the background information. The UAVCAN specification is
 * available at http://uavcan.org.
 */
@GeneratedMavMessage(
  id = 310,
  crc = 28,
)
public data class UavcanNodeStatus(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Time since the start-up of the node.
   */
  public val uptimeSec: Long = 0L,
  /**
   * Generalized node health status.
   */
  public val health: MavEnumValue<UavcanNodeHealth> = MavEnumValue.fromValue(0),
  /**
   * Generalized operating mode.
   */
  public val mode: MavEnumValue<UavcanNodeMode> = MavEnumValue.fromValue(0),
  /**
   * Not used currently.
   */
  public val subMode: Int = 0,
  /**
   * Vendor-specific status information.
   */
  public val vendorSpecificStatusCode: Int = 0,
) : MavMessage<UavcanNodeStatus> {
  public override val instanceMetadata: MavMessage.Metadata<UavcanNodeStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint32(uptimeSec)
    outputBuffer.encodeUint16(vendorSpecificStatusCode)
    outputBuffer.encodeEnumValue(health.value, 1)
    outputBuffer.encodeEnumValue(mode.value, 1)
    outputBuffer.encodeUint8(subMode)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 310

    private const val CRC: Int = 28

    private const val SIZE: Int = 17

    private val DESERIALIZER: MavDeserializer<UavcanNodeStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val uptimeSec = inputBuffer.decodeUint32()
      val vendorSpecificStatusCode = inputBuffer.decodeUint16()
      val health = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = UavcanNodeHealth.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val mode = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = UavcanNodeMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val subMode = inputBuffer.decodeUint8()

      UavcanNodeStatus(
        timeUsec = timeUsec,
        uptimeSec = uptimeSec,
        health = health,
        mode = mode,
        subMode = subMode,
        vendorSpecificStatusCode = vendorSpecificStatusCode,
      )
    }


    private val METADATA: MavMessage.Metadata<UavcanNodeStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<UavcanNodeStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: BigInteger = BigInteger.ZERO

    public var uptimeSec: Long = 0L

    public var health: MavEnumValue<UavcanNodeHealth> = MavEnumValue.fromValue(0)

    public var mode: MavEnumValue<UavcanNodeMode> = MavEnumValue.fromValue(0)

    public var subMode: Int = 0

    public var vendorSpecificStatusCode: Int = 0

    public fun build(): UavcanNodeStatus = UavcanNodeStatus(
      timeUsec = timeUsec,
      uptimeSec = uptimeSec,
      health = health,
      mode = mode,
      subMode = subMode,
      vendorSpecificStatusCode = vendorSpecificStatusCode,
    )
  }
}
