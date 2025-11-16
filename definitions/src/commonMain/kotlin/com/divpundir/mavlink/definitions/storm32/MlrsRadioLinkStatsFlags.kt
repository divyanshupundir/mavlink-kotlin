package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * RADIO_LINK_STATS flags (bitmask).
 *         The RX_RECEIVE and TX_RECEIVE flags indicate from which antenna the received data are
 * taken for processing.
 *         If a flag is set then the data received on antenna2 is processed, else the data received
 * on antenna1 is used.
 *         The RX_TRANSMIT and TX_TRANSMIT flags specify which antenna are transmitting data.
 *         Both antenna 1 and antenna 2 transmit flags can be set simultaneously, e.g., in case of
 * dual-band or dual-frequency systems.
 *         If neither flag is set then antenna 1 should be assumed.
 *       
 */
@GeneratedMavEnum(bitmask = true)
public enum class MlrsRadioLinkStatsFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Rssi values are in negative dBm. Values 1..254 corresponds to -1..-254 dBm. 0: no reception,
   * UINT8_MAX: unknown.
   */
  @GeneratedMavEnumEntry
  RSSI_DBM(1u),
  /**
   * Rx receive antenna. When set the data received on antenna 2 are taken, else the data stems from
   * antenna 1.
   */
  @GeneratedMavEnumEntry
  RX_RECEIVE_ANTENNA2(2u),
  /**
   * Rx transmit antenna. Data are transmitted on antenna 1.
   */
  @GeneratedMavEnumEntry
  RX_TRANSMIT_ANTENNA1(4u),
  /**
   * Rx transmit antenna. Data are transmitted on antenna 2.
   */
  @GeneratedMavEnumEntry
  RX_TRANSMIT_ANTENNA2(8u),
  /**
   * Tx receive antenna. When set the data received on antenna 2 are taken, else the data stems from
   * antenna 1.
   */
  @GeneratedMavEnumEntry
  TX_RECEIVE_ANTENNA2(16u),
  /**
   * Tx transmit antenna. Data are transmitted on antenna 1.
   */
  @GeneratedMavEnumEntry
  TX_TRANSMIT_ANTENNA1(32u),
  /**
   * Tx transmit antenna. Data are transmitted on antenna 2.
   */
  @GeneratedMavEnumEntry
  TX_TRANSMIT_ANTENNA2(64u),
  ;

  public companion object : MavBitmask.MavCompanion<MlrsRadioLinkStatsFlags> {
    override fun getEntryFromValueOrNull(v: UInt): MlrsRadioLinkStatsFlags? = when (v) {
      1u -> RSSI_DBM
      2u -> RX_RECEIVE_ANTENNA2
      4u -> RX_TRANSMIT_ANTENNA1
      8u -> RX_TRANSMIT_ANTENNA2
      16u -> TX_RECEIVE_ANTENNA2
      32u -> TX_TRANSMIT_ANTENNA1
      64u -> TX_TRANSMIT_ANTENNA2
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<MlrsRadioLinkStatsFlags> = buildList {
      if (v and 1u == 1u) add(RSSI_DBM)
      if (v and 2u == 2u) add(RX_RECEIVE_ANTENNA2)
      if (v and 4u == 4u) add(RX_TRANSMIT_ANTENNA1)
      if (v and 8u == 8u) add(RX_TRANSMIT_ANTENNA2)
      if (v and 16u == 16u) add(TX_RECEIVE_ANTENNA2)
      if (v and 32u == 32u) add(TX_TRANSMIT_ANTENNA1)
      if (v and 64u == 64u) add(TX_TRANSMIT_ANTENNA2)
    }
  }
}
