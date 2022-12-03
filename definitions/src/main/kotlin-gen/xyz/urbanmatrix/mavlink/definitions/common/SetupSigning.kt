package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Setup a MAVLink2 signing key. If called with secret_key of all zero and zero initial_timestamp
 * will disable signing
 */
@GeneratedMavMessage(
  id = 256,
  crc = 71,
)
public data class SetupSigning(
  /**
   * system id of the target
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * component ID of the target
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * signing key
   */
  @GeneratedMavField(type = "uint8_t[32]")
  public val secretKey: List<Int> = emptyList(),
  /**
   * initial timestamp
   */
  @GeneratedMavField(type = "uint64_t")
  public val initialTimestamp: BigInteger = BigInteger.ZERO,
) : MavMessage<SetupSigning> {
  public override val instanceMetadata: MavMessage.Metadata<SetupSigning> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(initialTimestamp)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8Array(secretKey, 32)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(initialTimestamp)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8Array(secretKey, 32)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 256

    private const val CRC: Int = 71

    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    private val DESERIALIZER: MavDeserializer<SetupSigning> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val initialTimestamp = inputBuffer.decodeUint64()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val secretKey = inputBuffer.decodeUint8Array(32)

      SetupSigning(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        secretKey = secretKey,
        initialTimestamp = initialTimestamp,
      )
    }


    private val METADATA: MavMessage.Metadata<SetupSigning> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SetupSigning> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SetupSigning =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var secretKey: List<Int> = emptyList()

    public var initialTimestamp: BigInteger = BigInteger.ZERO

    public fun build(): SetupSigning = SetupSigning(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      secretKey = secretKey,
      initialTimestamp = initialTimestamp,
    )
  }
}
