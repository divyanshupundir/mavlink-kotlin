package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeString
import com.urbanmatrix.mavlink.serialization.encodeString
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.String

/**
 * Emit an encrypted signature / key identifying this system. PLEASE NOTE: This protocol has been
 * kept simple, so transmitting the key requires an encrypted channel for true safety.
 */
public data class AuthKey(
  /**
   * key
   */
  public val key: String = "",
) : MavMessage<AuthKey> {
  public override val instanceMetadata: MavMessage.Metadata<AuthKey> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeString(key, 32)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 7

    private const val CRC: Int = 152

    private const val SIZE: Int = 32

    private val DESERIALIZER: MavDeserializer<AuthKey> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for AuthKey: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val key = inputBuffer.decodeString(32)

      AuthKey(
        key = key,
      )
    }


    private val METADATA: MavMessage.Metadata<AuthKey> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AuthKey> = METADATA
  }
}
