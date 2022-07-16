package com.urbanmatrix.mavlink.minimal

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Deprecated
import kotlin.Long

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
public enum class MavComponent(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Target id (target_component) used to broadcast messages to all components of the receiving
   * system. Components should attempt to process messages with this component ID and forward to
   * components on any other interfaces. Note: This is not a valid *source* component id for a message.
   */
  MAV_COMP_ID_ALL(0L),
  /**
   * System flight controller component ("autopilot"). Only one autopilot is expected in a
   * particular system.
   */
  MAV_COMP_ID_AUTOPILOT1(1L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER1(25L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER2(26L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER3(27L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER4(28L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER5(29L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER6(30L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER7(31L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER8(32L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER9(33L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER10(34L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER11(35L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER12(36L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER13(37L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER14(38L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER15(39L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER16(40L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER17(41L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER18(42L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER19(43L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER20(44L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER21(45L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER22(46L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER23(47L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER24(48L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER25(49L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER26(50L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER27(51L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER28(52L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER29(53L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER30(54L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER31(55L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER32(56L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER33(57L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER34(58L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER35(59L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER36(60L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER37(61L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER38(62L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER39(63L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER40(64L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER41(65L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER42(66L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER43(67L),
  /**
   * Telemetry radio (e.g. SiK radio, or other component that emits RADIO_STATUS messages).
   */
  MAV_COMP_ID_TELEMETRY_RADIO(68L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER45(69L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER46(70L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER47(71L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER48(72L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER49(73L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER50(74L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER51(75L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER52(76L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER53(77L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER54(78L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER55(79L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER56(80L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER57(81L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER58(82L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER59(83L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER60(84L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER61(85L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER62(86L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER63(87L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER64(88L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER65(89L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER66(90L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER67(91L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER68(92L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER69(93L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER70(94L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER71(95L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER72(96L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER73(97L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER74(98L),
  /**
   * Id for a component on privately managed MAVLink network. Can be used for any purpose but may
   * not be published by components outside of the private network.
   */
  MAV_COMP_ID_USER75(99L),
  /**
   * Camera #1.
   */
  MAV_COMP_ID_CAMERA(100L),
  /**
   * Camera #2.
   */
  MAV_COMP_ID_CAMERA2(101L),
  /**
   * Camera #3.
   */
  MAV_COMP_ID_CAMERA3(102L),
  /**
   * Camera #4.
   */
  MAV_COMP_ID_CAMERA4(103L),
  /**
   * Camera #5.
   */
  MAV_COMP_ID_CAMERA5(104L),
  /**
   * Camera #6.
   */
  MAV_COMP_ID_CAMERA6(105L),
  /**
   * Servo #1.
   */
  MAV_COMP_ID_SERVO1(140L),
  /**
   * Servo #2.
   */
  MAV_COMP_ID_SERVO2(141L),
  /**
   * Servo #3.
   */
  MAV_COMP_ID_SERVO3(142L),
  /**
   * Servo #4.
   */
  MAV_COMP_ID_SERVO4(143L),
  /**
   * Servo #5.
   */
  MAV_COMP_ID_SERVO5(144L),
  /**
   * Servo #6.
   */
  MAV_COMP_ID_SERVO6(145L),
  /**
   * Servo #7.
   */
  MAV_COMP_ID_SERVO7(146L),
  /**
   * Servo #8.
   */
  MAV_COMP_ID_SERVO8(147L),
  /**
   * Servo #9.
   */
  MAV_COMP_ID_SERVO9(148L),
  /**
   * Servo #10.
   */
  MAV_COMP_ID_SERVO10(149L),
  /**
   * Servo #11.
   */
  MAV_COMP_ID_SERVO11(150L),
  /**
   * Servo #12.
   */
  MAV_COMP_ID_SERVO12(151L),
  /**
   * Servo #13.
   */
  MAV_COMP_ID_SERVO13(152L),
  /**
   * Servo #14.
   */
  MAV_COMP_ID_SERVO14(153L),
  /**
   * Gimbal #1.
   */
  MAV_COMP_ID_GIMBAL(154L),
  /**
   * Logging component.
   */
  MAV_COMP_ID_LOG(155L),
  /**
   * Automatic Dependent Surveillance-Broadcast (ADS-B) component.
   */
  MAV_COMP_ID_ADSB(156L),
  /**
   * On Screen Display (OSD) devices for video links.
   */
  MAV_COMP_ID_OSD(157L),
  /**
   * Generic autopilot peripheral component ID. Meant for devices that do not implement the
   * parameter microservice.
   */
  MAV_COMP_ID_PERIPHERAL(158L),
  /**
   * Gimbal ID for QX1.
   */
  @Deprecated(message = "All gimbals should use MAV_COMP_ID_GIMBAL.")
  MAV_COMP_ID_QX1_GIMBAL(159L),
  /**
   * FLARM collision alert component.
   */
  MAV_COMP_ID_FLARM(160L),
  /**
   * Parachute component.
   */
  MAV_COMP_ID_PARACHUTE(161L),
  /**
   * Gimbal #2.
   */
  MAV_COMP_ID_GIMBAL2(171L),
  /**
   * Gimbal #3.
   */
  MAV_COMP_ID_GIMBAL3(172L),
  /**
   * Gimbal #4
   */
  MAV_COMP_ID_GIMBAL4(173L),
  /**
   * Gimbal #5.
   */
  MAV_COMP_ID_GIMBAL5(174L),
  /**
   * Gimbal #6.
   */
  MAV_COMP_ID_GIMBAL6(175L),
  /**
   * Battery #1.
   */
  MAV_COMP_ID_BATTERY(180L),
  /**
   * Battery #2.
   */
  MAV_COMP_ID_BATTERY2(181L),
  /**
   * CAN over MAVLink client.
   */
  MAV_COMP_ID_MAVCAN(189L),
  /**
   * Component that can generate/supply a mission flight plan (e.g. GCS or developer API).
   */
  MAV_COMP_ID_MISSIONPLANNER(190L),
  /**
   * Component that lives on the onboard computer (companion computer) and has some generic
   * functionalities, such as settings system parameters and monitoring the status of some processes
   * that don't directly speak mavlink and so on.
   */
  MAV_COMP_ID_ONBOARD_COMPUTER(191L),
  /**
   * Component that lives on the onboard computer (companion computer) and has some generic
   * functionalities, such as settings system parameters and monitoring the status of some processes
   * that don't directly speak mavlink and so on.
   */
  MAV_COMP_ID_ONBOARD_COMPUTER2(192L),
  /**
   * Component that lives on the onboard computer (companion computer) and has some generic
   * functionalities, such as settings system parameters and monitoring the status of some processes
   * that don't directly speak mavlink and so on.
   */
  MAV_COMP_ID_ONBOARD_COMPUTER3(193L),
  /**
   * Component that lives on the onboard computer (companion computer) and has some generic
   * functionalities, such as settings system parameters and monitoring the status of some processes
   * that don't directly speak mavlink and so on.
   */
  MAV_COMP_ID_ONBOARD_COMPUTER4(194L),
  /**
   * Component that finds an optimal path between points based on a certain constraint (e.g. minimum
   * snap, shortest path, cost, etc.).
   */
  MAV_COMP_ID_PATHPLANNER(195L),
  /**
   * Component that plans a collision free path between two points.
   */
  MAV_COMP_ID_OBSTACLE_AVOIDANCE(196L),
  /**
   * Component that provides position estimates using VIO techniques.
   */
  MAV_COMP_ID_VISUAL_INERTIAL_ODOMETRY(197L),
  /**
   * Component that manages pairing of vehicle and GCS.
   */
  MAV_COMP_ID_PAIRING_MANAGER(198L),
  /**
   * Inertial Measurement Unit (IMU) #1.
   */
  MAV_COMP_ID_IMU(200L),
  /**
   * Inertial Measurement Unit (IMU) #2.
   */
  MAV_COMP_ID_IMU_2(201L),
  /**
   * Inertial Measurement Unit (IMU) #3.
   */
  MAV_COMP_ID_IMU_3(202L),
  /**
   * GPS #1.
   */
  MAV_COMP_ID_GPS(220L),
  /**
   * GPS #2.
   */
  MAV_COMP_ID_GPS2(221L),
  /**
   * Open Drone ID transmitter/receiver (Bluetooth/WiFi/Internet).
   */
  MAV_COMP_ID_ODID_TXRX_1(236L),
  /**
   * Open Drone ID transmitter/receiver (Bluetooth/WiFi/Internet).
   */
  MAV_COMP_ID_ODID_TXRX_2(237L),
  /**
   * Open Drone ID transmitter/receiver (Bluetooth/WiFi/Internet).
   */
  MAV_COMP_ID_ODID_TXRX_3(238L),
  /**
   * Component to bridge MAVLink to UDP (i.e. from a UART).
   */
  MAV_COMP_ID_UDP_BRIDGE(240L),
  /**
   * Component to bridge to UART (i.e. from UDP).
   */
  MAV_COMP_ID_UART_BRIDGE(241L),
  /**
   * Component handling TUNNEL messages (e.g. vendor specific GUI of a component).
   */
  MAV_COMP_ID_TUNNEL_NODE(242L),
  /**
   * Component for handling system messages (e.g. to ARM, takeoff, etc.).
   */
  @Deprecated(message = "System control does not require a separate component ID.")
  MAV_COMP_ID_SYSTEM_CONTROL(250L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavComponent? = when (v) {
      0L -> MAV_COMP_ID_ALL
      1L -> MAV_COMP_ID_AUTOPILOT1
      25L -> MAV_COMP_ID_USER1
      26L -> MAV_COMP_ID_USER2
      27L -> MAV_COMP_ID_USER3
      28L -> MAV_COMP_ID_USER4
      29L -> MAV_COMP_ID_USER5
      30L -> MAV_COMP_ID_USER6
      31L -> MAV_COMP_ID_USER7
      32L -> MAV_COMP_ID_USER8
      33L -> MAV_COMP_ID_USER9
      34L -> MAV_COMP_ID_USER10
      35L -> MAV_COMP_ID_USER11
      36L -> MAV_COMP_ID_USER12
      37L -> MAV_COMP_ID_USER13
      38L -> MAV_COMP_ID_USER14
      39L -> MAV_COMP_ID_USER15
      40L -> MAV_COMP_ID_USER16
      41L -> MAV_COMP_ID_USER17
      42L -> MAV_COMP_ID_USER18
      43L -> MAV_COMP_ID_USER19
      44L -> MAV_COMP_ID_USER20
      45L -> MAV_COMP_ID_USER21
      46L -> MAV_COMP_ID_USER22
      47L -> MAV_COMP_ID_USER23
      48L -> MAV_COMP_ID_USER24
      49L -> MAV_COMP_ID_USER25
      50L -> MAV_COMP_ID_USER26
      51L -> MAV_COMP_ID_USER27
      52L -> MAV_COMP_ID_USER28
      53L -> MAV_COMP_ID_USER29
      54L -> MAV_COMP_ID_USER30
      55L -> MAV_COMP_ID_USER31
      56L -> MAV_COMP_ID_USER32
      57L -> MAV_COMP_ID_USER33
      58L -> MAV_COMP_ID_USER34
      59L -> MAV_COMP_ID_USER35
      60L -> MAV_COMP_ID_USER36
      61L -> MAV_COMP_ID_USER37
      62L -> MAV_COMP_ID_USER38
      63L -> MAV_COMP_ID_USER39
      64L -> MAV_COMP_ID_USER40
      65L -> MAV_COMP_ID_USER41
      66L -> MAV_COMP_ID_USER42
      67L -> MAV_COMP_ID_USER43
      68L -> MAV_COMP_ID_TELEMETRY_RADIO
      69L -> MAV_COMP_ID_USER45
      70L -> MAV_COMP_ID_USER46
      71L -> MAV_COMP_ID_USER47
      72L -> MAV_COMP_ID_USER48
      73L -> MAV_COMP_ID_USER49
      74L -> MAV_COMP_ID_USER50
      75L -> MAV_COMP_ID_USER51
      76L -> MAV_COMP_ID_USER52
      77L -> MAV_COMP_ID_USER53
      78L -> MAV_COMP_ID_USER54
      79L -> MAV_COMP_ID_USER55
      80L -> MAV_COMP_ID_USER56
      81L -> MAV_COMP_ID_USER57
      82L -> MAV_COMP_ID_USER58
      83L -> MAV_COMP_ID_USER59
      84L -> MAV_COMP_ID_USER60
      85L -> MAV_COMP_ID_USER61
      86L -> MAV_COMP_ID_USER62
      87L -> MAV_COMP_ID_USER63
      88L -> MAV_COMP_ID_USER64
      89L -> MAV_COMP_ID_USER65
      90L -> MAV_COMP_ID_USER66
      91L -> MAV_COMP_ID_USER67
      92L -> MAV_COMP_ID_USER68
      93L -> MAV_COMP_ID_USER69
      94L -> MAV_COMP_ID_USER70
      95L -> MAV_COMP_ID_USER71
      96L -> MAV_COMP_ID_USER72
      97L -> MAV_COMP_ID_USER73
      98L -> MAV_COMP_ID_USER74
      99L -> MAV_COMP_ID_USER75
      100L -> MAV_COMP_ID_CAMERA
      101L -> MAV_COMP_ID_CAMERA2
      102L -> MAV_COMP_ID_CAMERA3
      103L -> MAV_COMP_ID_CAMERA4
      104L -> MAV_COMP_ID_CAMERA5
      105L -> MAV_COMP_ID_CAMERA6
      140L -> MAV_COMP_ID_SERVO1
      141L -> MAV_COMP_ID_SERVO2
      142L -> MAV_COMP_ID_SERVO3
      143L -> MAV_COMP_ID_SERVO4
      144L -> MAV_COMP_ID_SERVO5
      145L -> MAV_COMP_ID_SERVO6
      146L -> MAV_COMP_ID_SERVO7
      147L -> MAV_COMP_ID_SERVO8
      148L -> MAV_COMP_ID_SERVO9
      149L -> MAV_COMP_ID_SERVO10
      150L -> MAV_COMP_ID_SERVO11
      151L -> MAV_COMP_ID_SERVO12
      152L -> MAV_COMP_ID_SERVO13
      153L -> MAV_COMP_ID_SERVO14
      154L -> MAV_COMP_ID_GIMBAL
      155L -> MAV_COMP_ID_LOG
      156L -> MAV_COMP_ID_ADSB
      157L -> MAV_COMP_ID_OSD
      158L -> MAV_COMP_ID_PERIPHERAL
      159L -> MAV_COMP_ID_QX1_GIMBAL
      160L -> MAV_COMP_ID_FLARM
      161L -> MAV_COMP_ID_PARACHUTE
      171L -> MAV_COMP_ID_GIMBAL2
      172L -> MAV_COMP_ID_GIMBAL3
      173L -> MAV_COMP_ID_GIMBAL4
      174L -> MAV_COMP_ID_GIMBAL5
      175L -> MAV_COMP_ID_GIMBAL6
      180L -> MAV_COMP_ID_BATTERY
      181L -> MAV_COMP_ID_BATTERY2
      189L -> MAV_COMP_ID_MAVCAN
      190L -> MAV_COMP_ID_MISSIONPLANNER
      191L -> MAV_COMP_ID_ONBOARD_COMPUTER
      192L -> MAV_COMP_ID_ONBOARD_COMPUTER2
      193L -> MAV_COMP_ID_ONBOARD_COMPUTER3
      194L -> MAV_COMP_ID_ONBOARD_COMPUTER4
      195L -> MAV_COMP_ID_PATHPLANNER
      196L -> MAV_COMP_ID_OBSTACLE_AVOIDANCE
      197L -> MAV_COMP_ID_VISUAL_INERTIAL_ODOMETRY
      198L -> MAV_COMP_ID_PAIRING_MANAGER
      200L -> MAV_COMP_ID_IMU
      201L -> MAV_COMP_ID_IMU_2
      202L -> MAV_COMP_ID_IMU_3
      220L -> MAV_COMP_ID_GPS
      221L -> MAV_COMP_ID_GPS2
      236L -> MAV_COMP_ID_ODID_TXRX_1
      237L -> MAV_COMP_ID_ODID_TXRX_2
      238L -> MAV_COMP_ID_ODID_TXRX_3
      240L -> MAV_COMP_ID_UDP_BRIDGE
      241L -> MAV_COMP_ID_UART_BRIDGE
      242L -> MAV_COMP_ID_TUNNEL_NODE
      250L -> MAV_COMP_ID_SYSTEM_CONTROL
      else -> null
    }
  }
}
