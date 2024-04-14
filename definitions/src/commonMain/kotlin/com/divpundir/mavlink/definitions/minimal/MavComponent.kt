package com.divpundir.mavlink.definitions.minimal

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.Deprecated
import kotlin.UInt

/**
 * Component ids (values) for the different types and instances of onboard hardware/software that
 * might make up a MAVLink system (autopilot, cameras, servos, GPS systems, avoidance systems etc.).
 *       Components must use the appropriate ID in their source address when sending messages.
 * Components can also use IDs to determine if they are the intended recipient of an incoming message.
 * The MAV_COMP_ID_ALL value is used to indicate messages that must be processed by all components.
 *       When creating new entries, components that can have multiple instances (e.g. cameras,
 * servos etc.) should be allocated sequential values. An appropriate number of values should be left
 * free after these components to allow the number of instances to be expanded.
 */
@GeneratedMavEnum
public enum class MavComponent(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Target id (target_component) used to broadcast messages to all components of the receiving
   * system. Components should attempt to process messages with this component ID and forward to
   * components on any other interfaces. Note: This is not a valid *source* component id for a message.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_ALL(0u),
  /**
   * System flight controller component ("autopilot"). Only one autopilot is expected in a
   * particular system.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_AUTOPILOT1(1u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER1(25u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER2(26u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER3(27u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER4(28u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER5(29u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER6(30u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER7(31u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER8(32u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER9(33u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER10(34u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER11(35u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER12(36u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER13(37u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER14(38u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER15(39u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER16(40u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER17(41u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER18(42u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER19(43u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER20(44u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER21(45u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER22(46u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER23(47u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER24(48u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER25(49u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER26(50u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER27(51u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER28(52u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER29(53u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER30(54u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER31(55u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER32(56u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER33(57u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER34(58u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER35(59u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER36(60u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER37(61u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER38(62u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER39(63u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER40(64u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER41(65u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER42(66u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER43(67u),
  /**
   * Telemetry radio (e.g. SiK radio, or other component that emits RADIO_STATUS messages).
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_TELEMETRY_RADIO(68u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER45(69u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER46(70u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER47(71u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER48(72u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER49(73u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER50(74u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER51(75u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER52(76u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER53(77u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER54(78u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER55(79u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER56(80u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER57(81u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER58(82u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER59(83u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER60(84u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER61(85u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER62(86u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER63(87u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER64(88u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER65(89u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER66(90u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER67(91u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER68(92u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER69(93u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER70(94u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER71(95u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER72(96u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER73(97u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER74(98u),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_USER75(99u),
  /**
   * Camera #1.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_CAMERA(100u),
  /**
   * Camera #2.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_CAMERA2(101u),
  /**
   * Camera #3.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_CAMERA3(102u),
  /**
   * Camera #4.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_CAMERA4(103u),
  /**
   * Camera #5.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_CAMERA5(104u),
  /**
   * Camera #6.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_CAMERA6(105u),
  /**
   * Servo #1.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_SERVO1(140u),
  /**
   * Servo #2.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_SERVO2(141u),
  /**
   * Servo #3.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_SERVO3(142u),
  /**
   * Servo #4.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_SERVO4(143u),
  /**
   * Servo #5.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_SERVO5(144u),
  /**
   * Servo #6.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_SERVO6(145u),
  /**
   * Servo #7.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_SERVO7(146u),
  /**
   * Servo #8.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_SERVO8(147u),
  /**
   * Servo #9.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_SERVO9(148u),
  /**
   * Servo #10.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_SERVO10(149u),
  /**
   * Servo #11.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_SERVO11(150u),
  /**
   * Servo #12.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_SERVO12(151u),
  /**
   * Servo #13.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_SERVO13(152u),
  /**
   * Servo #14.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_SERVO14(153u),
  /**
   * Gimbal #1.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_GIMBAL(154u),
  /**
   * Logging component.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_LOG(155u),
  /**
   * Automatic Dependent Surveillance-Broadcast (ADS-B) component.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_ADSB(156u),
  /**
   * On Screen Display (OSD) devices for video links.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_OSD(157u),
  /**
   * Generic autopilot peripheral component ID. Meant for devices that do not implement the
   * parameter microservice.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_PERIPHERAL(158u),
  /**
   * Gimbal ID for QX1.
   */
  @Deprecated(message = "All gimbals should use MAV_COMP_ID_GIMBAL.")
  @GeneratedMavEnumEntry
  MAV_COMP_ID_QX1_GIMBAL(159u),
  /**
   * FLARM collision alert component.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_FLARM(160u),
  /**
   * Parachute component.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_PARACHUTE(161u),
  /**
   * Winch component.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_WINCH(169u),
  /**
   * Gimbal #2.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_GIMBAL2(171u),
  /**
   * Gimbal #3.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_GIMBAL3(172u),
  /**
   * Gimbal #4
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_GIMBAL4(173u),
  /**
   * Gimbal #5.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_GIMBAL5(174u),
  /**
   * Gimbal #6.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_GIMBAL6(175u),
  /**
   * Battery #1.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_BATTERY(180u),
  /**
   * Battery #2.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_BATTERY2(181u),
  /**
   * CAN over MAVLink client.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_MAVCAN(189u),
  /**
   * Component that can generate/supply a mission flight plan (e.g. GCS or developer API).
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_MISSIONPLANNER(190u),
  /**
   * Component that lives on the onboard computer (companion computer) and has some generic
   * functionalities, such as settings system parameters and monitoring the status of some processes
   * that don't directly speak mavlink and so on.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_ONBOARD_COMPUTER(191u),
  /**
   * Component that lives on the onboard computer (companion computer) and has some generic
   * functionalities, such as settings system parameters and monitoring the status of some processes
   * that don't directly speak mavlink and so on.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_ONBOARD_COMPUTER2(192u),
  /**
   * Component that lives on the onboard computer (companion computer) and has some generic
   * functionalities, such as settings system parameters and monitoring the status of some processes
   * that don't directly speak mavlink and so on.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_ONBOARD_COMPUTER3(193u),
  /**
   * Component that lives on the onboard computer (companion computer) and has some generic
   * functionalities, such as settings system parameters and monitoring the status of some processes
   * that don't directly speak mavlink and so on.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_ONBOARD_COMPUTER4(194u),
  /**
   * Component that finds an optimal path between points based on a certain constraint (e.g. minimum
   * snap, shortest path, cost, etc.).
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_PATHPLANNER(195u),
  /**
   * Component that plans a collision free path between two points.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_OBSTACLE_AVOIDANCE(196u),
  /**
   * Component that provides position estimates using VIO techniques.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_VISUAL_INERTIAL_ODOMETRY(197u),
  /**
   * Component that manages pairing of vehicle and GCS.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_PAIRING_MANAGER(198u),
  /**
   * Inertial Measurement Unit (IMU) #1.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_IMU(200u),
  /**
   * Inertial Measurement Unit (IMU) #2.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_IMU_2(201u),
  /**
   * Inertial Measurement Unit (IMU) #3.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_IMU_3(202u),
  /**
   * GPS #1.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_GPS(220u),
  /**
   * GPS #2.
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_GPS2(221u),
  /**
   * Open Drone ID transmitter/receiver (Bluetooth/WiFi/Internet).
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_ODID_TXRX_1(236u),
  /**
   * Open Drone ID transmitter/receiver (Bluetooth/WiFi/Internet).
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_ODID_TXRX_2(237u),
  /**
   * Open Drone ID transmitter/receiver (Bluetooth/WiFi/Internet).
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_ODID_TXRX_3(238u),
  /**
   * Component to bridge MAVLink to UDP (i.e. from a UART).
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_UDP_BRIDGE(240u),
  /**
   * Component to bridge to UART (i.e. from UDP).
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_UART_BRIDGE(241u),
  /**
   * Component handling TUNNEL messages (e.g. vendor specific GUI of a component).
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_TUNNEL_NODE(242u),
  /**
   * Illuminator
   */
  @GeneratedMavEnumEntry
  MAV_COMP_ID_ILLUMINATOR(243u),
  /**
   * Deprecated, don't use. Component for handling system messages (e.g. to ARM, takeoff, etc.).
   */
  @Deprecated(message =
      "System control does not require a separate component ID. Instead, system commands should be sent with target_component=MAV_COMP_ID_ALL allowing the target component to use any appropriate component id.")
  @GeneratedMavEnumEntry
  MAV_COMP_ID_SYSTEM_CONTROL(250u),
  ;

  public companion object : MavEnum.MavCompanion<MavComponent> {
    override fun getEntryFromValueOrNull(v: UInt): MavComponent? = when (v) {
      0u -> MAV_COMP_ID_ALL
      1u -> MAV_COMP_ID_AUTOPILOT1
      25u -> MAV_COMP_ID_USER1
      26u -> MAV_COMP_ID_USER2
      27u -> MAV_COMP_ID_USER3
      28u -> MAV_COMP_ID_USER4
      29u -> MAV_COMP_ID_USER5
      30u -> MAV_COMP_ID_USER6
      31u -> MAV_COMP_ID_USER7
      32u -> MAV_COMP_ID_USER8
      33u -> MAV_COMP_ID_USER9
      34u -> MAV_COMP_ID_USER10
      35u -> MAV_COMP_ID_USER11
      36u -> MAV_COMP_ID_USER12
      37u -> MAV_COMP_ID_USER13
      38u -> MAV_COMP_ID_USER14
      39u -> MAV_COMP_ID_USER15
      40u -> MAV_COMP_ID_USER16
      41u -> MAV_COMP_ID_USER17
      42u -> MAV_COMP_ID_USER18
      43u -> MAV_COMP_ID_USER19
      44u -> MAV_COMP_ID_USER20
      45u -> MAV_COMP_ID_USER21
      46u -> MAV_COMP_ID_USER22
      47u -> MAV_COMP_ID_USER23
      48u -> MAV_COMP_ID_USER24
      49u -> MAV_COMP_ID_USER25
      50u -> MAV_COMP_ID_USER26
      51u -> MAV_COMP_ID_USER27
      52u -> MAV_COMP_ID_USER28
      53u -> MAV_COMP_ID_USER29
      54u -> MAV_COMP_ID_USER30
      55u -> MAV_COMP_ID_USER31
      56u -> MAV_COMP_ID_USER32
      57u -> MAV_COMP_ID_USER33
      58u -> MAV_COMP_ID_USER34
      59u -> MAV_COMP_ID_USER35
      60u -> MAV_COMP_ID_USER36
      61u -> MAV_COMP_ID_USER37
      62u -> MAV_COMP_ID_USER38
      63u -> MAV_COMP_ID_USER39
      64u -> MAV_COMP_ID_USER40
      65u -> MAV_COMP_ID_USER41
      66u -> MAV_COMP_ID_USER42
      67u -> MAV_COMP_ID_USER43
      68u -> MAV_COMP_ID_TELEMETRY_RADIO
      69u -> MAV_COMP_ID_USER45
      70u -> MAV_COMP_ID_USER46
      71u -> MAV_COMP_ID_USER47
      72u -> MAV_COMP_ID_USER48
      73u -> MAV_COMP_ID_USER49
      74u -> MAV_COMP_ID_USER50
      75u -> MAV_COMP_ID_USER51
      76u -> MAV_COMP_ID_USER52
      77u -> MAV_COMP_ID_USER53
      78u -> MAV_COMP_ID_USER54
      79u -> MAV_COMP_ID_USER55
      80u -> MAV_COMP_ID_USER56
      81u -> MAV_COMP_ID_USER57
      82u -> MAV_COMP_ID_USER58
      83u -> MAV_COMP_ID_USER59
      84u -> MAV_COMP_ID_USER60
      85u -> MAV_COMP_ID_USER61
      86u -> MAV_COMP_ID_USER62
      87u -> MAV_COMP_ID_USER63
      88u -> MAV_COMP_ID_USER64
      89u -> MAV_COMP_ID_USER65
      90u -> MAV_COMP_ID_USER66
      91u -> MAV_COMP_ID_USER67
      92u -> MAV_COMP_ID_USER68
      93u -> MAV_COMP_ID_USER69
      94u -> MAV_COMP_ID_USER70
      95u -> MAV_COMP_ID_USER71
      96u -> MAV_COMP_ID_USER72
      97u -> MAV_COMP_ID_USER73
      98u -> MAV_COMP_ID_USER74
      99u -> MAV_COMP_ID_USER75
      100u -> MAV_COMP_ID_CAMERA
      101u -> MAV_COMP_ID_CAMERA2
      102u -> MAV_COMP_ID_CAMERA3
      103u -> MAV_COMP_ID_CAMERA4
      104u -> MAV_COMP_ID_CAMERA5
      105u -> MAV_COMP_ID_CAMERA6
      140u -> MAV_COMP_ID_SERVO1
      141u -> MAV_COMP_ID_SERVO2
      142u -> MAV_COMP_ID_SERVO3
      143u -> MAV_COMP_ID_SERVO4
      144u -> MAV_COMP_ID_SERVO5
      145u -> MAV_COMP_ID_SERVO6
      146u -> MAV_COMP_ID_SERVO7
      147u -> MAV_COMP_ID_SERVO8
      148u -> MAV_COMP_ID_SERVO9
      149u -> MAV_COMP_ID_SERVO10
      150u -> MAV_COMP_ID_SERVO11
      151u -> MAV_COMP_ID_SERVO12
      152u -> MAV_COMP_ID_SERVO13
      153u -> MAV_COMP_ID_SERVO14
      154u -> MAV_COMP_ID_GIMBAL
      155u -> MAV_COMP_ID_LOG
      156u -> MAV_COMP_ID_ADSB
      157u -> MAV_COMP_ID_OSD
      158u -> MAV_COMP_ID_PERIPHERAL
      159u -> MAV_COMP_ID_QX1_GIMBAL
      160u -> MAV_COMP_ID_FLARM
      161u -> MAV_COMP_ID_PARACHUTE
      169u -> MAV_COMP_ID_WINCH
      171u -> MAV_COMP_ID_GIMBAL2
      172u -> MAV_COMP_ID_GIMBAL3
      173u -> MAV_COMP_ID_GIMBAL4
      174u -> MAV_COMP_ID_GIMBAL5
      175u -> MAV_COMP_ID_GIMBAL6
      180u -> MAV_COMP_ID_BATTERY
      181u -> MAV_COMP_ID_BATTERY2
      189u -> MAV_COMP_ID_MAVCAN
      190u -> MAV_COMP_ID_MISSIONPLANNER
      191u -> MAV_COMP_ID_ONBOARD_COMPUTER
      192u -> MAV_COMP_ID_ONBOARD_COMPUTER2
      193u -> MAV_COMP_ID_ONBOARD_COMPUTER3
      194u -> MAV_COMP_ID_ONBOARD_COMPUTER4
      195u -> MAV_COMP_ID_PATHPLANNER
      196u -> MAV_COMP_ID_OBSTACLE_AVOIDANCE
      197u -> MAV_COMP_ID_VISUAL_INERTIAL_ODOMETRY
      198u -> MAV_COMP_ID_PAIRING_MANAGER
      200u -> MAV_COMP_ID_IMU
      201u -> MAV_COMP_ID_IMU_2
      202u -> MAV_COMP_ID_IMU_3
      220u -> MAV_COMP_ID_GPS
      221u -> MAV_COMP_ID_GPS2
      236u -> MAV_COMP_ID_ODID_TXRX_1
      237u -> MAV_COMP_ID_ODID_TXRX_2
      238u -> MAV_COMP_ID_ODID_TXRX_3
      240u -> MAV_COMP_ID_UDP_BRIDGE
      241u -> MAV_COMP_ID_UART_BRIDGE
      242u -> MAV_COMP_ID_TUNNEL_NODE
      243u -> MAV_COMP_ID_ILLUMINATOR
      250u -> MAV_COMP_ID_SYSTEM_CONTROL
      else -> null
    }
  }
}
