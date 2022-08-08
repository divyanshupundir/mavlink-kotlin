package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeString
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeString
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.String

/**
 * Request to control this MAV
 */
@GeneratedMavMessage(
  id = 5,
  crc = 217,
)
public data class ChangeOperatorControl(
  /**
   * System the GCS requests control for
   */
  public val targetSystem: Int = 0,
  /**
   * 0: request control of this MAV, 1: Release control of this MAV
   */
  public val controlRequest: Int = 0,
  /**
   * 0: key as plaintext, 1-255: future, different hashing/encryption variants. The GCS should in
   * general use the safest mode possible initially and then gradually move down the encryption level
   * if it gets a NACK message indicating an encryption mismatch.
   */
  public val version: Int = 0,
  /**
   * Password / Key, depending on version plaintext or encrypted. 25 or less characters, NULL
   * terminated. The characters may involve A-Z, a-z, 0-9, and "!?,.-"
   */
  public val passkey: String = "",
) : MavMessage<ChangeOperatorControl> {
  public override val instanceMetadata: MavMessage.Metadata<ChangeOperatorControl> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(controlRequest)
    outputBuffer.encodeUint8(version)
    outputBuffer.encodeString(passkey, 25)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 5

    private const val CRC: Int = 217

    private const val SIZE: Int = 28

    private val DESERIALIZER: MavDeserializer<ChangeOperatorControl> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUint8()
      val controlRequest = inputBuffer.decodeUint8()
      val version = inputBuffer.decodeUint8()
      val passkey = inputBuffer.decodeString(25)

      ChangeOperatorControl(
        targetSystem = targetSystem,
        controlRequest = controlRequest,
        version = version,
        passkey = passkey,
      )
    }


    private val METADATA: MavMessage.Metadata<ChangeOperatorControl> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ChangeOperatorControl> = METADATA
  }
}
