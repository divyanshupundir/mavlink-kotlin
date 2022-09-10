package xyz.urbanmatrix.mavlink.connection.performance

import org.junit.jupiter.api.Test
import xyz.urbanmatrix.mavlink.definitions.common.CommandLong
import xyz.urbanmatrix.mavlink.definitions.common.MavCmd
import xyz.urbanmatrix.mavlink.wrap

class MavlinkKotlinSpeedTest {

    companion object {
        private const val WARMUP_ITERS = 5
        private const val ACTUAL_ITERS = 5

        private const val SERIALIZATION_ITERS = 1_000_000
        private const val DESERIALIZATION_ITERS = 100_000
    }

    @Test
    fun serialization() {
        val cmd = CommandLong(
            1,
            2,
            MavCmd.MAV_CMD_DO_FOLLOW.wrap(),
            3,
            4f,
            3f,
            4f,
            5f,
            6f,
            7f,
            2f
        )

        for (i in 1..WARMUP_ITERS) {
            println("Warmup: ${serializationStep(cmd)}")
        }

        for (i in 1..ACTUAL_ITERS) {
            println("Actual: ${serializationStep(cmd)}")
        }
    }

    private fun serializationStep(cmd: CommandLong): Long {
        val start = System.nanoTime()
        for (i in 1..SERIALIZATION_ITERS) {
            cmd.serializeV2()
        }
        val end = System.nanoTime()

        return (end - start) / 1000
    }

    @Test
    fun deserialization() {
        val data = ByteArray(200)

        for (i in 0..WARMUP_ITERS) {
            println("Warmup: " + deserializationStep(data))
        }

        for (i in 0..ACTUAL_ITERS) {
            println("Actual: " + deserializationStep(data))
        }
    }

    private fun deserializationStep(data: ByteArray): Long {
        val start = System.nanoTime()
        for (i in 1..DESERIALIZATION_ITERS) {
            CommandLong.classMetadata.deserializer.deserialize(data)
        }
        val end = System.nanoTime()
        return (end - start) / 1000
    }
}
