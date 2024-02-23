package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * MAV FTP opcodes: https://mavlink.io/en/services/ftp.html
 */
@GeneratedMavEnum
public enum class MavFtpOpcode(
  override val `value`: UInt,
) : MavEnum {
  /**
   * None. Ignored, always ACKed
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * TerminateSession: Terminates open Read session
   */
  @GeneratedMavEnumEntry
  TERMINATESESSION(1u),
  /**
   * ResetSessions: Terminates all open read sessions
   */
  @GeneratedMavEnumEntry
  RESETSESSION(2u),
  /**
   * ListDirectory. List files and directories in path from offset
   */
  @GeneratedMavEnumEntry
  LISTDIRECTORY(3u),
  /**
   * OpenFileRO: Opens file at path for reading, returns session
   */
  @GeneratedMavEnumEntry
  OPENFILERO(4u),
  /**
   * ReadFile: Reads size bytes from offset in session
   */
  @GeneratedMavEnumEntry
  READFILE(5u),
  /**
   * CreateFile: Creates file at path for writing, returns session
   */
  @GeneratedMavEnumEntry
  CREATEFILE(6u),
  /**
   * WriteFile: Writes size bytes to offset in session
   */
  @GeneratedMavEnumEntry
  WRITEFILE(7u),
  /**
   * RemoveFile: Remove file at path
   */
  @GeneratedMavEnumEntry
  REMOVEFILE(8u),
  /**
   * CreateDirectory: Creates directory at path
   */
  @GeneratedMavEnumEntry
  CREATEDIRECTORY(9u),
  /**
   * RemoveDirectory: Removes directory at path. The directory must be empty.
   */
  @GeneratedMavEnumEntry
  REMOVEDIRECTORY(10u),
  /**
   * OpenFileWO: Opens file at path for writing, returns session
   */
  @GeneratedMavEnumEntry
  OPENFILEWO(11u),
  /**
   * TruncateFile: Truncate file at path to offset length
   */
  @GeneratedMavEnumEntry
  TRUNCATEFILE(12u),
  /**
   * Rename: Rename path1 to path2
   */
  @GeneratedMavEnumEntry
  RENAME(13u),
  /**
   * CalcFileCRC32: Calculate CRC32 for file at path
   */
  @GeneratedMavEnumEntry
  CALCFILECRC(14u),
  /**
   * BurstReadFile: Burst download session file
   */
  @GeneratedMavEnumEntry
  BURSTREADFILE(15u),
  /**
   * ACK: ACK response
   */
  @GeneratedMavEnumEntry
  ACK(128u),
  /**
   * NAK: NAK response
   */
  @GeneratedMavEnumEntry
  NAK(129u),
  ;

  public companion object : MavEnum.MavCompanion<MavFtpOpcode> {
    override fun getEntryFromValueOrNull(v: UInt): MavFtpOpcode? = when (v) {
      0u -> NONE
      1u -> TERMINATESESSION
      2u -> RESETSESSION
      3u -> LISTDIRECTORY
      4u -> OPENFILERO
      5u -> READFILE
      6u -> CREATEFILE
      7u -> WRITEFILE
      8u -> REMOVEFILE
      9u -> CREATEDIRECTORY
      10u -> REMOVEDIRECTORY
      11u -> OPENFILEWO
      12u -> TRUNCATEFILE
      13u -> RENAME
      14u -> CALCFILECRC
      15u -> BURSTREADFILE
      128u -> ACK
      129u -> NAK
      else -> null
    }
  }
}
