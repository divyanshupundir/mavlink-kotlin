package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

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
  MAV_FTP_ERR_NONE(0L),
  /**
   * Fail: Unknown failure
   */
  MAV_FTP_ERR_FAIL(1L),
  /**
   * FailErrno: Command failed, Err number sent back in PayloadHeader.data[1].
   * 		This is a file-system error number understood by the server operating system.
   */
  MAV_FTP_ERR_FAILERRNO(2L),
  /**
   * InvalidDataSize: Payload size is invalid
   */
  MAV_FTP_ERR_INVALIDDATASIZE(3L),
  /**
   * InvalidSession: Session is not currently open
   */
  MAV_FTP_ERR_INVALIDSESSION(4L),
  /**
   * NoSessionsAvailable: All available sessions are already in use
   */
  MAV_FTP_ERR_NOSESSIONSAVAILABLE(5L),
  /**
   * EOF: Offset past end of file for ListDirectory and ReadFile commands
   */
  MAV_FTP_ERR_EOF(6L),
  /**
   * UnknownCommand: Unknown command / opcode
   */
  MAV_FTP_ERR_UNKNOWNCOMMAND(7L),
  /**
   * FileExists: File/directory already exists
   */
  MAV_FTP_ERR_FILEEXISTS(8L),
  /**
   * FileProtected: File/directory is write protected
   */
  MAV_FTP_ERR_FILEPROTECTED(9L),
  /**
   * FileNotFound: File/directory not found
   */
  MAV_FTP_ERR_FILENOTFOUND(10L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavFtpErr? = when (v) {
      0L -> MAV_FTP_ERR_NONE
      1L -> MAV_FTP_ERR_FAIL
      2L -> MAV_FTP_ERR_FAILERRNO
      3L -> MAV_FTP_ERR_INVALIDDATASIZE
      4L -> MAV_FTP_ERR_INVALIDSESSION
      5L -> MAV_FTP_ERR_NOSESSIONSAVAILABLE
      6L -> MAV_FTP_ERR_EOF
      7L -> MAV_FTP_ERR_UNKNOWNCOMMAND
      8L -> MAV_FTP_ERR_FILEEXISTS
      9L -> MAV_FTP_ERR_FILEPROTECTED
      10L -> MAV_FTP_ERR_FILENOTFOUND
      else -> null
    }
  }
}
