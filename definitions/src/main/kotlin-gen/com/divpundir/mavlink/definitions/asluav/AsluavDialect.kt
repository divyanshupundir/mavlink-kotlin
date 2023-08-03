package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.AbstractMavDialect
import com.divpundir.mavlink.api.GeneratedMavDialect
import com.divpundir.mavlink.definitions.common.CommonDialect

@GeneratedMavDialect
public data object AsluavDialect : AbstractMavDialect(
  setOf(
    CommonDialect,
  ), 
  mapOf(
    CommandIntStamped.id to CommandIntStamped,
    CommandLongStamped.id to CommandLongStamped,
    SensPower.id to SensPower,
    SensMppt.id to SensMppt,
    AslctrlData.id to AslctrlData,
    AslctrlDebug.id to AslctrlDebug,
    AsluavStatus.id to AsluavStatus,
    EkfExt.id to EkfExt,
    AslObctrl.id to AslObctrl,
    SensAtmos.id to SensAtmos,
    SensBatmon.id to SensBatmon,
    FwSoaringData.id to FwSoaringData,
    SensorpodStatus.id to SensorpodStatus,
    SensPowerBoard.id to SensPowerBoard,
    GsmLinkStatus.id to GsmLinkStatus,
    SatcomLinkStatus.id to SatcomLinkStatus,
    SensorAirflowAngles.id to SensorAirflowAngles,
  )
)
