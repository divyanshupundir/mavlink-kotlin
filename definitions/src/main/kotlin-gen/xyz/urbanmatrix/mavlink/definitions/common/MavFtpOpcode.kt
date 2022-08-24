package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * MAV FTP opcodes: https://mavlink.io/en/services/ftp.html
 */
@GeneratedMavEnum
public enum class MavFtpOpcode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * None. Ignored, always ACKed
   */
  MAV_FTP_OPCODE_NONE(0L),
  /**
   * TerminateSession: Terminates open Read session
   */
  MAV_FTP_OPCODE_TERMINATESESSION(1L),
  /**
   * ResetSessions: Terminates all open read sessions
   */
  MAV_FTP_OPCODE_RESETSESSION(2L),
  /**
   * ListDirectory. List files and directories in path from offset
   */
  MAV_FTP_OPCODE_LISTDIRECTORY(3L),
  /**
   * OpenFileRO: Opens file at path for reading, returns session
   */
  MAV_FTP_OPCODE_OPENFILERO(4L),
  /**
   * ReadFile: Reads size bytes from offset in session
   */
  MAV_FTP_OPCODE_READFILE(5L),
  /**
   * CreateFile: Creates file at path for writing, returns session
   */
  MAV_FTP_OPCODE_CREATEFILE(6L),
  /**
   * WriteFile: Writes size bytes to offset in session
   */
  MAV_FTP_OPCODE_WRITEFILE(7L),
  /**
   * RemoveFile: Remove file at path
   */
  MAV_FTP_OPCODE_REMOVEFILE(8L),
  /**
   * CreateDirectory: Creates directory at path
   */
  MAV_FTP_OPCODE_CREATEDIRECTORY(9L),
  /**
   * RemoveDirectory: Removes directory at path. The directory must be empty.
   */
  MAV_FTP_OPCODE_REMOVEDIRECTORY(10L),
  /**
   * OpenFileWO: Opens file at path for writing, returns session
   */
  MAV_FTP_OPCODE_OPENFILEWO(11L),
  /**
   * TruncateFile: Truncate file at path to offset length
   */
  MAV_FTP_OPCODE_TRUNCATEFILE(12L),
  /**
   * Rename: Rename path1 to path2
   */
  MAV_FTP_OPCODE_RENAME(13L),
  /**
   * CalcFileCRC32: Calculate CRC32 for file at path
   */
  MAV_FTP_OPCODE_CALCFILECRC(14L),
  /**
   * BurstReadFile: Burst download session file
   */
  MAV_FTP_OPCODE_BURSTREADFILE(15L),
  /**
   * ACK: ACK response
   */
  MAV_FTP_OPCODE_ACK(128L),
  /**
   * NAK: NAK response
   */
  MAV_FTP_OPCODE_NAK(129L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavFtpOpcode? = when (v) {
      0L -> MAV_FTP_OPCODE_NONE
      1L -> MAV_FTP_OPCODE_TERMINATESESSION
      2L -> MAV_FTP_OPCODE_RESETSESSION
      3L -> MAV_FTP_OPCODE_LISTDIRECTORY
      4L -> MAV_FTP_OPCODE_OPENFILERO
      5L -> MAV_FTP_OPCODE_READFILE
      6L -> MAV_FTP_OPCODE_CREATEFILE
      7L -> MAV_FTP_OPCODE_WRITEFILE
      8L -> MAV_FTP_OPCODE_REMOVEFILE
      9L -> MAV_FTP_OPCODE_CREATEDIRECTORY
      10L -> MAV_FTP_OPCODE_REMOVEDIRECTORY
      11L -> MAV_FTP_OPCODE_OPENFILEWO
      12L -> MAV_FTP_OPCODE_TRUNCATEFILE
      13L -> MAV_FTP_OPCODE_RENAME
      14L -> MAV_FTP_OPCODE_CALCFILECRC
      15L -> MAV_FTP_OPCODE_BURSTREADFILE
      128L -> MAV_FTP_OPCODE_ACK
      129L -> MAV_FTP_OPCODE_NAK
      else -> null
    }
  }
}
