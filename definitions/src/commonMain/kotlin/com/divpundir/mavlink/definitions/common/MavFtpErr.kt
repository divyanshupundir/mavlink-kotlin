package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * MAV FTP error codes (https://mavlink.io/en/services/ftp.html)
 */
@GeneratedMavEnum
public enum class MavFtpErr(
  override val `value`: UInt,
) : MavEnum {
  /**
   * None: No error
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Fail: Unknown failure
   */
  @GeneratedMavEnumEntry
  FAIL(1u),
  /**
   * FailErrno: Command failed, Err number sent back in PayloadHeader.data[1].
   * 		This is a file-system error number understood by the server operating system.
   */
  @GeneratedMavEnumEntry
  FAILERRNO(2u),
  /**
   * InvalidDataSize: Payload size is invalid
   */
  @GeneratedMavEnumEntry
  INVALIDDATASIZE(3u),
  /**
   * InvalidSession: Session is not currently open
   */
  @GeneratedMavEnumEntry
  INVALIDSESSION(4u),
  /**
   * NoSessionsAvailable: All available sessions are already in use
   */
  @GeneratedMavEnumEntry
  NOSESSIONSAVAILABLE(5u),
  /**
   * EOF: Offset past end of file for ListDirectory and ReadFile commands
   */
  @GeneratedMavEnumEntry
  EOF(6u),
  /**
   * UnknownCommand: Unknown command / opcode
   */
  @GeneratedMavEnumEntry
  UNKNOWNCOMMAND(7u),
  /**
   * FileExists: File/directory already exists
   */
  @GeneratedMavEnumEntry
  FILEEXISTS(8u),
  /**
   * FileProtected: File/directory is write protected
   */
  @GeneratedMavEnumEntry
  FILEPROTECTED(9u),
  /**
   * FileNotFound: File/directory not found
   */
  @GeneratedMavEnumEntry
  FILENOTFOUND(10u),
  ;

  public companion object : MavEnum.MavCompanion<MavFtpErr> {
    override fun getEntryFromValueOrNull(v: UInt): MavFtpErr? = when (v) {
      0u -> NONE
      1u -> FAIL
      2u -> FAILERRNO
      3u -> INVALIDDATASIZE
      4u -> INVALIDSESSION
      5u -> NOSESSIONSAVAILABLE
      6u -> EOF
      7u -> UNKNOWNCOMMAND
      8u -> FILEEXISTS
      9u -> FILEPROTECTED
      10u -> FILENOTFOUND
      else -> null
    }
  }
}
