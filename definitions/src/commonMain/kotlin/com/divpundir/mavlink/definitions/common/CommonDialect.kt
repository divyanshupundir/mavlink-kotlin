package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect
import com.divpundir.mavlink.definitions.standard.StandardDialect

@GeneratedMavDialect
public data object CommonDialect : AbstractMavDialect(
  setOf(
    StandardDialect,
  ), 
  mapOf(
    SysStatus.id to SysStatus,
    SystemTime.id to SystemTime,
    Ping.id to Ping,
    ChangeOperatorControl.id to ChangeOperatorControl,
    ChangeOperatorControlAck.id to ChangeOperatorControlAck,
    AuthKey.id to AuthKey,
    LinkNodeStatus.id to LinkNodeStatus,
    SetMode.id to SetMode,
    ParamRequestRead.id to ParamRequestRead,
    ParamRequestList.id to ParamRequestList,
    ParamValue.id to ParamValue,
    ParamSet.id to ParamSet,
    GpsRawInt.id to GpsRawInt,
    GpsStatus.id to GpsStatus,
    ScaledImu.id to ScaledImu,
    RawImu.id to RawImu,
    RawPressure.id to RawPressure,
    ScaledPressure.id to ScaledPressure,
    Attitude.id to Attitude,
    AttitudeQuaternion.id to AttitudeQuaternion,
    LocalPositionNed.id to LocalPositionNed,
    GlobalPositionInt.id to GlobalPositionInt,
    RcChannelsScaled.id to RcChannelsScaled,
    RcChannelsRaw.id to RcChannelsRaw,
    ServoOutputRaw.id to ServoOutputRaw,
    MissionRequestPartialList.id to MissionRequestPartialList,
    MissionWritePartialList.id to MissionWritePartialList,
    MissionItem.id to MissionItem,
    MissionRequest.id to MissionRequest,
    MissionSetCurrent.id to MissionSetCurrent,
    MissionCurrent.id to MissionCurrent,
    MissionRequestList.id to MissionRequestList,
    MissionCount.id to MissionCount,
    MissionClearAll.id to MissionClearAll,
    MissionItemReached.id to MissionItemReached,
    MissionAck.id to MissionAck,
    SetGpsGlobalOrigin.id to SetGpsGlobalOrigin,
    GpsGlobalOrigin.id to GpsGlobalOrigin,
    ParamMapRc.id to ParamMapRc,
    MissionRequestInt.id to MissionRequestInt,
    SafetySetAllowedArea.id to SafetySetAllowedArea,
    SafetyAllowedArea.id to SafetyAllowedArea,
    AttitudeQuaternionCov.id to AttitudeQuaternionCov,
    NavControllerOutput.id to NavControllerOutput,
    GlobalPositionIntCov.id to GlobalPositionIntCov,
    LocalPositionNedCov.id to LocalPositionNedCov,
    RcChannels.id to RcChannels,
    RequestDataStream.id to RequestDataStream,
    DataStream.id to DataStream,
    ManualControl.id to ManualControl,
    RcChannelsOverride.id to RcChannelsOverride,
    MissionItemInt.id to MissionItemInt,
    VfrHud.id to VfrHud,
    CommandInt.id to CommandInt,
    CommandLong.id to CommandLong,
    CommandAck.id to CommandAck,
    CommandCancel.id to CommandCancel,
    ManualSetpoint.id to ManualSetpoint,
    SetAttitudeTarget.id to SetAttitudeTarget,
    AttitudeTarget.id to AttitudeTarget,
    SetPositionTargetLocalNed.id to SetPositionTargetLocalNed,
    PositionTargetLocalNed.id to PositionTargetLocalNed,
    SetPositionTargetGlobalInt.id to SetPositionTargetGlobalInt,
    PositionTargetGlobalInt.id to PositionTargetGlobalInt,
    LocalPositionNedSystemGlobalOffset.id to LocalPositionNedSystemGlobalOffset,
    HilState.id to HilState,
    HilControls.id to HilControls,
    HilRcInputsRaw.id to HilRcInputsRaw,
    HilActuatorControls.id to HilActuatorControls,
    OpticalFlow.id to OpticalFlow,
    GlobalVisionPositionEstimate.id to GlobalVisionPositionEstimate,
    VisionPositionEstimate.id to VisionPositionEstimate,
    VisionSpeedEstimate.id to VisionSpeedEstimate,
    ViconPositionEstimate.id to ViconPositionEstimate,
    HighresImu.id to HighresImu,
    OpticalFlowRad.id to OpticalFlowRad,
    HilSensor.id to HilSensor,
    SimState.id to SimState,
    RadioStatus.id to RadioStatus,
    FileTransferProtocol.id to FileTransferProtocol,
    Timesync.id to Timesync,
    CameraTrigger.id to CameraTrigger,
    HilGps.id to HilGps,
    HilOpticalFlow.id to HilOpticalFlow,
    HilStateQuaternion.id to HilStateQuaternion,
    ScaledImu2.id to ScaledImu2,
    LogRequestList.id to LogRequestList,
    LogEntry.id to LogEntry,
    LogRequestData.id to LogRequestData,
    LogData.id to LogData,
    LogErase.id to LogErase,
    LogRequestEnd.id to LogRequestEnd,
    GpsInjectData.id to GpsInjectData,
    Gps2Raw.id to Gps2Raw,
    PowerStatus.id to PowerStatus,
    SerialControl.id to SerialControl,
    GpsRtk.id to GpsRtk,
    Gps2Rtk.id to Gps2Rtk,
    ScaledImu3.id to ScaledImu3,
    DataTransmissionHandshake.id to DataTransmissionHandshake,
    EncapsulatedData.id to EncapsulatedData,
    DistanceSensor.id to DistanceSensor,
    TerrainRequest.id to TerrainRequest,
    TerrainData.id to TerrainData,
    TerrainCheck.id to TerrainCheck,
    TerrainReport.id to TerrainReport,
    ScaledPressure2.id to ScaledPressure2,
    AttPosMocap.id to AttPosMocap,
    SetActuatorControlTarget.id to SetActuatorControlTarget,
    ActuatorControlTarget.id to ActuatorControlTarget,
    Altitude.id to Altitude,
    ResourceRequest.id to ResourceRequest,
    ScaledPressure3.id to ScaledPressure3,
    FollowTarget.id to FollowTarget,
    ControlSystemState.id to ControlSystemState,
    BatteryStatus.id to BatteryStatus,
    AutopilotVersion.id to AutopilotVersion,
    LandingTarget.id to LandingTarget,
    FenceStatus.id to FenceStatus,
    MagCalReport.id to MagCalReport,
    EfiStatus.id to EfiStatus,
    EstimatorStatus.id to EstimatorStatus,
    WindCov.id to WindCov,
    GpsInput.id to GpsInput,
    GpsRtcmData.id to GpsRtcmData,
    HighLatency.id to HighLatency,
    HighLatency2.id to HighLatency2,
    Vibration.id to Vibration,
    HomePosition.id to HomePosition,
    SetHomePosition.id to SetHomePosition,
    MessageInterval.id to MessageInterval,
    ExtendedSysState.id to ExtendedSysState,
    AdsbVehicle.id to AdsbVehicle,
    Collision.id to Collision,
    V2Extension.id to V2Extension,
    MemoryVect.id to MemoryVect,
    DebugVect.id to DebugVect,
    NamedValueFloat.id to NamedValueFloat,
    NamedValueInt.id to NamedValueInt,
    Statustext.id to Statustext,
    Debug.id to Debug,
    SetupSigning.id to SetupSigning,
    ButtonChange.id to ButtonChange,
    PlayTune.id to PlayTune,
    CameraInformation.id to CameraInformation,
    CameraSettings.id to CameraSettings,
    StorageInformation.id to StorageInformation,
    CameraCaptureStatus.id to CameraCaptureStatus,
    CameraImageCaptured.id to CameraImageCaptured,
    FlightInformation.id to FlightInformation,
    MountOrientation.id to MountOrientation,
    LoggingData.id to LoggingData,
    LoggingDataAcked.id to LoggingDataAcked,
    LoggingAck.id to LoggingAck,
    VideoStreamInformation.id to VideoStreamInformation,
    VideoStreamStatus.id to VideoStreamStatus,
    CameraFovStatus.id to CameraFovStatus,
    CameraTrackingImageStatus.id to CameraTrackingImageStatus,
    CameraTrackingGeoStatus.id to CameraTrackingGeoStatus,
    GimbalManagerInformation.id to GimbalManagerInformation,
    GimbalManagerStatus.id to GimbalManagerStatus,
    GimbalManagerSetAttitude.id to GimbalManagerSetAttitude,
    GimbalDeviceInformation.id to GimbalDeviceInformation,
    GimbalDeviceSetAttitude.id to GimbalDeviceSetAttitude,
    GimbalDeviceAttitudeStatus.id to GimbalDeviceAttitudeStatus,
    AutopilotStateForGimbalDevice.id to AutopilotStateForGimbalDevice,
    GimbalManagerSetPitchyaw.id to GimbalManagerSetPitchyaw,
    GimbalManagerSetManualControl.id to GimbalManagerSetManualControl,
    EscInfo.id to EscInfo,
    EscStatus.id to EscStatus,
    WifiConfigAp.id to WifiConfigAp,
    AisVessel.id to AisVessel,
    UavcanNodeStatus.id to UavcanNodeStatus,
    UavcanNodeInfo.id to UavcanNodeInfo,
    ParamExtRequestRead.id to ParamExtRequestRead,
    ParamExtRequestList.id to ParamExtRequestList,
    ParamExtValue.id to ParamExtValue,
    ParamExtSet.id to ParamExtSet,
    ParamExtAck.id to ParamExtAck,
    ObstacleDistance.id to ObstacleDistance,
    Odometry.id to Odometry,
    TrajectoryRepresentationWaypoints.id to TrajectoryRepresentationWaypoints,
    TrajectoryRepresentationBezier.id to TrajectoryRepresentationBezier,
    CellularStatus.id to CellularStatus,
    IsbdLinkStatus.id to IsbdLinkStatus,
    CellularConfig.id to CellularConfig,
    RawRpm.id to RawRpm,
    UtmGlobalPosition.id to UtmGlobalPosition,
    DebugFloatArray.id to DebugFloatArray,
    OrbitExecutionStatus.id to OrbitExecutionStatus,
    BatteryInfo.id to BatteryInfo,
    GeneratorStatus.id to GeneratorStatus,
    ActuatorOutputStatus.id to ActuatorOutputStatus,
    TimeEstimateToTarget.id to TimeEstimateToTarget,
    Tunnel.id to Tunnel,
    CanFrame.id to CanFrame,
    OnboardComputerStatus.id to OnboardComputerStatus,
    ComponentInformation.id to ComponentInformation,
    ComponentMetadata.id to ComponentMetadata,
    PlayTuneV2.id to PlayTuneV2,
    SupportedTunes.id to SupportedTunes,
    Event.id to Event,
    CurrentEventSequence.id to CurrentEventSequence,
    RequestEvent.id to RequestEvent,
    ResponseEventError.id to ResponseEventError,
    CanfdFrame.id to CanfdFrame,
    CanFilterModify.id to CanFilterModify,
    WheelDistance.id to WheelDistance,
    WinchStatus.id to WinchStatus,
    OpenDroneIdBasicId.id to OpenDroneIdBasicId,
    OpenDroneIdLocation.id to OpenDroneIdLocation,
    OpenDroneIdAuthentication.id to OpenDroneIdAuthentication,
    OpenDroneIdSelfId.id to OpenDroneIdSelfId,
    OpenDroneIdSystem.id to OpenDroneIdSystem,
    OpenDroneIdOperatorId.id to OpenDroneIdOperatorId,
    OpenDroneIdMessagePack.id to OpenDroneIdMessagePack,
    OpenDroneIdArmStatus.id to OpenDroneIdArmStatus,
    OpenDroneIdSystemUpdate.id to OpenDroneIdSystemUpdate,
    HygrometerSensor.id to HygrometerSensor,
  )
)
