package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect
import com.divpundir.mavlink.definitions.common.CommonDialect
import com.divpundir.mavlink.definitions.csairlink.CsairlinkDialect
import com.divpundir.mavlink.definitions.cubepilot.CubepilotDialect
import com.divpundir.mavlink.definitions.icarous.IcarousDialect
import com.divpundir.mavlink.definitions.loweheiser.LoweheiserDialect
import com.divpundir.mavlink.definitions.uavionix.UavionixDialect

@GeneratedMavDialect
public data object ArdupilotmegaDialect : AbstractMavDialect(
  setOf(
    CsairlinkDialect,
    CubepilotDialect,
    LoweheiserDialect,
    IcarousDialect,
    UavionixDialect,
    CommonDialect,
  ), 
  mapOf(
    SensorOffsets.id to SensorOffsets,
    SetMagOffsets.id to SetMagOffsets,
    Meminfo.id to Meminfo,
    ApAdc.id to ApAdc,
    DigicamConfigure.id to DigicamConfigure,
    DigicamControl.id to DigicamControl,
    MountConfigure.id to MountConfigure,
    MountControl.id to MountControl,
    MountStatus.id to MountStatus,
    FencePoint.id to FencePoint,
    FenceFetchPoint.id to FenceFetchPoint,
    Ahrs.id to Ahrs,
    Simstate.id to Simstate,
    Hwstatus.id to Hwstatus,
    Radio.id to Radio,
    LimitsStatus.id to LimitsStatus,
    Wind.id to Wind,
    Data16.id to Data16,
    Data32.id to Data32,
    Data64.id to Data64,
    Data96.id to Data96,
    Rangefinder.id to Rangefinder,
    AirspeedAutocal.id to AirspeedAutocal,
    RallyPoint.id to RallyPoint,
    RallyFetchPoint.id to RallyFetchPoint,
    CompassmotStatus.id to CompassmotStatus,
    Ahrs2.id to Ahrs2,
    CameraStatus.id to CameraStatus,
    CameraFeedback.id to CameraFeedback,
    Battery2.id to Battery2,
    Ahrs3.id to Ahrs3,
    AutopilotVersionRequest.id to AutopilotVersionRequest,
    RemoteLogDataBlock.id to RemoteLogDataBlock,
    RemoteLogBlockStatus.id to RemoteLogBlockStatus,
    LedControl.id to LedControl,
    MagCalProgress.id to MagCalProgress,
    EkfStatusReport.id to EkfStatusReport,
    PidTuning.id to PidTuning,
    Deepstall.id to Deepstall,
    GimbalReport.id to GimbalReport,
    GimbalControl.id to GimbalControl,
    GimbalTorqueCmdReport.id to GimbalTorqueCmdReport,
    GoproHeartbeat.id to GoproHeartbeat,
    GoproGetRequest.id to GoproGetRequest,
    GoproGetResponse.id to GoproGetResponse,
    GoproSetRequest.id to GoproSetRequest,
    GoproSetResponse.id to GoproSetResponse,
    Rpm.id to Rpm,
    DeviceOpRead.id to DeviceOpRead,
    DeviceOpReadReply.id to DeviceOpReadReply,
    DeviceOpWrite.id to DeviceOpWrite,
    DeviceOpWriteReply.id to DeviceOpWriteReply,
    SecureCommand.id to SecureCommand,
    SecureCommandReply.id to SecureCommandReply,
    AdapTuning.id to AdapTuning,
    VisionPositionDelta.id to VisionPositionDelta,
    AoaSsa.id to AoaSsa,
    EscTelemetry1To4.id to EscTelemetry1To4,
    EscTelemetry5To8.id to EscTelemetry5To8,
    EscTelemetry9To12.id to EscTelemetry9To12,
    OsdParamConfig.id to OsdParamConfig,
    OsdParamConfigReply.id to OsdParamConfigReply,
    OsdParamShowConfig.id to OsdParamShowConfig,
    OsdParamShowConfigReply.id to OsdParamShowConfigReply,
    ObstacleDistance3d.id to ObstacleDistance3d,
    WaterDepth.id to WaterDepth,
    McuStatus.id to McuStatus,
    EscTelemetry13To16.id to EscTelemetry13To16,
    EscTelemetry17To20.id to EscTelemetry17To20,
    EscTelemetry21To24.id to EscTelemetry21To24,
    EscTelemetry25To28.id to EscTelemetry25To28,
    EscTelemetry29To32.id to EscTelemetry29To32,
  )
)
