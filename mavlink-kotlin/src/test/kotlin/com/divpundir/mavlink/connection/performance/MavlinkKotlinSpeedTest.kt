package com.divpundir.mavlink.connection.performance

import com.divpundir.mavlink.definitions.common.CommandLong
import com.divpundir.mavlink.definitions.common.MavCmd
import com.divpundir.mavlink.wrap
import org.junit.jupiter.api.Test
import kotlin.system.measureNanoTime

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
            1u,
            2u,
            MavCmd.DO_FOLLOW.wrap(),
            3u,
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

    private fun serializationStep(cmd: CommandLong) = measureNanoTime {
        for (i in 1..SERIALIZATION_ITERS) {
            cmd.serializeV2()
        }
    } / 1000

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

    private fun deserializationStep(data: ByteArray) = measureNanoTime {
        for (i in 1..DESERIALIZATION_ITERS) {
            CommandLong.deserialize(data)
        }
    } / 1000
}
