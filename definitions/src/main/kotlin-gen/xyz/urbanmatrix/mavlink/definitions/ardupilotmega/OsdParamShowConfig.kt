package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Read a configured an OSD parameter slot.
 */
@GeneratedMavMessage(
  id = 11035,
  crc = 128,
)
public data class OsdParamShowConfig(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * Request ID - copied to reply.
   */
  @GeneratedMavField(type = "uint32_t")
  public val requestId: Long = 0L,
  /**
   * OSD parameter screen index.
   */
  @GeneratedMavField(type = "uint8_t")
  public val osdScreen: Int = 0,
  /**
   * OSD parameter display index.
   */
  @GeneratedMavField(type = "uint8_t")
  public val osdIndex: Int = 0,
) : MavMessage<OsdParamShowConfig> {
  public override val instanceMetadata: MavMessage.Metadata<OsdParamShowConfig> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(requestId)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(osdScreen)
    outputBuffer.encodeUint8(osdIndex)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(requestId)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(osdScreen)
    outputBuffer.encodeUint8(osdIndex)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 11035

    private const val CRC: Int = 128

    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 8

    private val DESERIALIZER: MavDeserializer<OsdParamShowConfig> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val requestId = inputBuffer.decodeUint32()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val osdScreen = inputBuffer.decodeUint8()
      val osdIndex = inputBuffer.decodeUint8()

      OsdParamShowConfig(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        requestId = requestId,
        osdScreen = osdScreen,
        osdIndex = osdIndex,
      )
    }


    private val METADATA: MavMessage.Metadata<OsdParamShowConfig> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OsdParamShowConfig> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): OsdParamShowConfig =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var requestId: Long = 0L

    public var osdScreen: Int = 0

    public var osdIndex: Int = 0

    public fun build(): OsdParamShowConfig = OsdParamShowConfig(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      requestId = requestId,
      osdScreen = osdScreen,
      osdIndex = osdIndex,
    )
  }
}
