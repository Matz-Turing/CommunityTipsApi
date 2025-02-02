package com.financasapp.tips.repository

import com.financasapp.tips.data.TipsDatabase
import com.financasapp.tips.data.TipsPreferences
import com.financasapp.tips.model.DrivingTip
import com.financasapp.tips.model.VehicleType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TipsRepository(
    private val tipsPreferences: TipsPreferences
) {
    fun getTips(): Flow<List<DrivingTip>> = flow {
        val vehicleType = tipsPreferences.getVehicleType()
        val implementedTips = tipsPreferences.getImplementedTips()
        
        val tips = if (vehicleType != null) {
            TipsDatabase.getTipsByVehicleType(vehicleType)
        } else {
            TipsDatabase.getAllTips()
        }

        // Marca as dicas que já foram implementadas
        val tipsWithImplementationStatus = tips.map { tip ->
            tip.copy(isImplemented = implementedTips.contains(tip.id))
        }

        emit(tipsWithImplementationStatus)
    }

    fun setVehicleType(type: VehicleType) {
        tipsPreferences.saveVehicleType(type)
    }

    fun markTipAsImplemented(tipId: String) {
        tipsPreferences.saveImplementedTip(tipId)
    }

    fun unmarkTipAsImplemented(tipId: String) {
        tipsPreferences.removeImplementedTip(tipId)
    }

    fun getVehicleType(): VehicleType? {
        return tipsPreferences.getVehicleType()
    }
}
