package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
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
  @GeneratedMavEnumEntry
  NONE(0L),
  /**
   * TerminateSession: Terminates open Read session
   */
  @GeneratedMavEnumEntry
  TERMINATESESSION(1L),
  /**
   * ResetSessions: Terminates all open read sessions
   */
  @GeneratedMavEnumEntry
  RESETSESSION(2L),
  /**
   * ListDirectory. List files and directories in path from offset
   */
  @GeneratedMavEnumEntry
  LISTDIRECTORY(3L),
  /**
   * OpenFileRO: Opens file at path for reading, returns session
   */
  @GeneratedMavEnumEntry
  OPENFILERO(4L),
  /**
   * ReadFile: Reads size bytes from offset in session
   */
  @GeneratedMavEnumEntry
  READFILE(5L),
  /**
   * CreateFile: Creates file at path for writing, returns session
   */
  @GeneratedMavEnumEntry
  CREATEFILE(6L),
  /**
   * WriteFile: Writes size bytes to offset in session
   */
  @GeneratedMavEnumEntry
  WRITEFILE(7L),
  /**
   * RemoveFile: Remove file at path
   */
  @GeneratedMavEnumEntry
  REMOVEFILE(8L),
  /**
   * CreateDirectory: Creates directory at path
   */
  @GeneratedMavEnumEntry
  CREATEDIRECTORY(9L),
  /**
   * RemoveDirectory: Removes directory at path. The directory must be empty.
   */
  @GeneratedMavEnumEntry
  REMOVEDIRECTORY(10L),
  /**
   * OpenFileWO: Opens file at path for writing, returns session
   */
  @GeneratedMavEnumEntry
  OPENFILEWO(11L),
  /**
   * TruncateFile: Truncate file at path to offset length
   */
  @GeneratedMavEnumEntry
  TRUNCATEFILE(12L),
  /**
   * Rename: Rename path1 to path2
   */
  @GeneratedMavEnumEntry
  RENAME(13L),
  /**
   * CalcFileCRC32: Calculate CRC32 for file at path
   */
  @GeneratedMavEnumEntry
  CALCFILECRC(14L),
  /**
   * BurstReadFile: Burst download session file
   */
  @GeneratedMavEnumEntry
  BURSTREADFILE(15L),
  /**
   * ACK: ACK response
   */
  @GeneratedMavEnumEntry
  ACK(128L),
  /**
   * NAK: NAK response
   */
  @GeneratedMavEnumEntry
  NAK(129L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavFtpOpcode? = when (v) {
      0L -> NONE
      1L -> TERMINATESESSION
      2L -> RESETSESSION
      3L -> LISTDIRECTORY
      4L -> OPENFILERO
      5L -> READFILE
      6L -> CREATEFILE
      7L -> WRITEFILE
      8L -> REMOVEFILE
      9L -> CREATEDIRECTORY
      10L -> REMOVEDIRECTORY
      11L -> OPENFILEWO
      12L -> TRUNCATEFILE
      13L -> RENAME
      14L -> CALCFILECRC
      15L -> BURSTREADFILE
      128L -> ACK
      129L -> NAK
      else -> null
    }
  }
}
