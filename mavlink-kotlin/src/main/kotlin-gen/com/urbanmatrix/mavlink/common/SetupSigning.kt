package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List

/**
 * Setup a MAVLink2 signing key. If called with secret_key of all zero and zero initial_timestamp
 * will disable signing
 */
public data class SetupSigning(
  /**
   * system id of the target
   */
  public val targetSystem: Int = 0,
  /**
   * component ID of the target
   */
  public val targetComponent: Int = 0,
  /**
   * signing key
   */
  public val secretKey: List<Int> = emptyList(),
  /**
   * initial timestamp
   */
  public val initialTimestamp: BigInteger = BigInteger.ZERO,
) : MavMessage<SetupSigning> {
  public override val instanceMetadata: MavMessage.Metadata<SetupSigning> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(42).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(initialTimestamp)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8Array(secretKey, 32)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 256

    private const val CRC: Int = 91

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
  }
}
