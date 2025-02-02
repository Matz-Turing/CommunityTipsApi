package com.financasapp.tips.data

import android.content.Context
import com.financasapp.tips.model.VehicleType

class TipsPreferences(context: Context) {
    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun saveVehicleType(type: VehicleType) {
        prefs.edit().putString(KEY_VEHICLE_TYPE, type.name).apply()
    }

    fun getVehicleType(): VehicleType? {
        val typeName = prefs.getString(KEY_VEHICLE_TYPE, null)
        return typeName?.let { VehicleType.valueOf(it) }
    }

    fun saveImplementedTip(tipId: String) {
        val implementedTips = getImplementedTips().toMutableSet()
        implementedTips.add(tipId)
        prefs.edit().putStringSet(KEY_IMPLEMENTED_TIPS, implementedTips).apply()
    }

    fun removeImplementedTip(tipId: String) {
        val implementedTips = getImplementedTips().toMutableSet()
        implementedTips.remove(tipId)
        prefs.edit().putStringSet(KEY_IMPLEMENTED_TIPS, implementedTips).apply()
    }

    fun getImplementedTips(): Set<String> {
        return prefs.getStringSet(KEY_IMPLEMENTED_TIPS, emptySet()) ?: emptySet()
    }

    fun clear() {
        prefs.edit().clear().apply()
    }

    companion object {
        private const val PREFS_NAME = "tips_preferences"
        private const val KEY_VEHICLE_TYPE = "vehicle_type"
        private const val KEY_IMPLEMENTED_TIPS = "implemented_tips"
    }
}
