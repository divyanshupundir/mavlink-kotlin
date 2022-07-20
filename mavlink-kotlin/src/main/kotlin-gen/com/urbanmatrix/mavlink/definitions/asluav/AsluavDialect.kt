package com.urbanmatrix.mavlink.definitions.asluav

import com.urbanmatrix.mavlink.api.AbstractMavDialect
import com.urbanmatrix.mavlink.definitions.common.CommonDialect

public object AsluavDialect : AbstractMavDialect(
  setOf(
    CommonDialect,
  ), 
  mapOf(
    CommandIntStamped.classMetadata.id to CommandIntStamped.classMetadata,
    CommandLongStamped.classMetadata.id to CommandLongStamped.classMetadata,
    SensPower.classMetadata.id to SensPower.classMetadata,
    SensMppt.classMetadata.id to SensMppt.classMetadata,
    AslctrlData.classMetadata.id to AslctrlData.classMetadata,
    AslctrlDebug.classMetadata.id to AslctrlDebug.classMetadata,
    AsluavStatus.classMetadata.id to AsluavStatus.classMetadata,
    EkfExt.classMetadata.id to EkfExt.classMetadata,
    AslObctrl.classMetadata.id to AslObctrl.classMetadata,
    SensAtmos.classMetadata.id to SensAtmos.classMetadata,
    SensBatmon.classMetadata.id to SensBatmon.classMetadata,
    FwSoaringData.classMetadata.id to FwSoaringData.classMetadata,
    SensorpodStatus.classMetadata.id to SensorpodStatus.classMetadata,
    SensPowerBoard.classMetadata.id to SensPowerBoard.classMetadata,
    GsmLinkStatus.classMetadata.id to GsmLinkStatus.classMetadata,
    SatcomLinkStatus.classMetadata.id to SatcomLinkStatus.classMetadata,
    SensorAirflowAngles.classMetadata.id to SensorAirflowAngles.classMetadata,
  )
)
