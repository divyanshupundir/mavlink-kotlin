package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * MAV FTP error codes (https://mavlink.io/en/services/ftp.html)
 */
@GeneratedMavEnum
public enum class MavFtpErr(
  public override val `value`: Long,
) : MavEnum {
  /**
   * None: No error
   */
  @GeneratedMavEnumEntry
  NONE(0L),
  /**
   * Fail: Unknown failure
   */
  @GeneratedMavEnumEntry
  FAIL(1L),
  /**
   * FailErrno: Command failed, Err number sent back in PayloadHeader.data[1].
   * 		This is a file-system error number understood by the server operating system.
   */
  @GeneratedMavEnumEntry
  FAILERRNO(2L),
  /**
   * InvalidDataSize: Payload size is invalid
   */
  @GeneratedMavEnumEntry
  INVALIDDATASIZE(3L),
  /**
   * InvalidSession: Session is not currently open
   */
  @GeneratedMavEnumEntry
  INVALIDSESSION(4L),
  /**
   * NoSessionsAvailable: All available sessions are already in use
   */
  @GeneratedMavEnumEntry
  NOSESSIONSAVAILABLE(5L),
  /**
   * EOF: Offset past end of file for ListDirectory and ReadFile commands
   */
  @GeneratedMavEnumEntry
  EOF(6L),
  /**
   * UnknownCommand: Unknown command / opcode
   */
  @GeneratedMavEnumEntry
  UNKNOWNCOMMAND(7L),
  /**
   * FileExists: File/directory already exists
   */
  @GeneratedMavEnumEntry
  FILEEXISTS(8L),
  /**
   * FileProtected: File/directory is write protected
   */
  @GeneratedMavEnumEntry
  FILEPROTECTED(9L),
  /**
   * FileNotFound: File/directory not found
   */
  @GeneratedMavEnumEntry
  FILENOTFOUND(10L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavFtpErr? = when (v) {
      0L -> NONE
      1L -> FAIL
      2L -> FAILERRNO
      3L -> INVALIDDATASIZE
      4L -> INVALIDSESSION
      5L -> NOSESSIONSAVAILABLE
      6L -> EOF
      7L -> UNKNOWNCOMMAND
      8L -> FILEEXISTS
      9L -> FILEPROTECTED
      10L -> FILENOTFOUND
      else -> null
    }
  }
}
