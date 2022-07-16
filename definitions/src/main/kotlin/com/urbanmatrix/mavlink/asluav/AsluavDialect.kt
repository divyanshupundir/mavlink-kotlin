package com.urbanmatrix.mavlink.asluav

import com.urbanmatrix.mavlink.ASLUAV.AslObctrl
import com.urbanmatrix.mavlink.ASLUAV.AslctrlData
import com.urbanmatrix.mavlink.ASLUAV.AslctrlDebug
import com.urbanmatrix.mavlink.ASLUAV.AsluavStatus
import com.urbanmatrix.mavlink.ASLUAV.CommandIntStamped
import com.urbanmatrix.mavlink.ASLUAV.CommandLongStamped
import com.urbanmatrix.mavlink.ASLUAV.EkfExt
import com.urbanmatrix.mavlink.ASLUAV.FwSoaringData
import com.urbanmatrix.mavlink.ASLUAV.GsmLinkStatus
import com.urbanmatrix.mavlink.ASLUAV.SatcomLinkStatus
import com.urbanmatrix.mavlink.ASLUAV.SensAtmos
import com.urbanmatrix.mavlink.ASLUAV.SensBatmon
import com.urbanmatrix.mavlink.ASLUAV.SensMppt
import com.urbanmatrix.mavlink.ASLUAV.SensPower
import com.urbanmatrix.mavlink.ASLUAV.SensPowerBoard
import com.urbanmatrix.mavlink.ASLUAV.SensorAirflowAngles
import com.urbanmatrix.mavlink.ASLUAV.SensorpodStatus
import com.urbanmatrix.mavlink.api.AbstractMavDialect
import com.urbanmatrix.mavlink.common.CommonDialect

public object AsluavDialect : AbstractMavDialect(
  setOf(
    CommonDialect
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
