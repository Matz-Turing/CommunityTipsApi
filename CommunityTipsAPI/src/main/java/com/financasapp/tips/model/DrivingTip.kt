package com.financasapp.tips.model

data class DrivingTip(
    val id: String,
    val title: String,
    val description: String,
    val savingPercentage: Int,
    val category: TipCategory,
    val difficulty: TipDifficulty,
    val vehicleType: VehicleType,
    val isImplemented: Boolean = false
)

enum class TipCategory {
    MAINTENANCE,    // Manutenção
    DRIVING_HABITS, // Hábitos de Direção
    PLANNING,       // Planejamento
    VEHICLE_CARE;   // Cuidados com o Veículo

    fun getDisplayName(): String = when(this) {
        MAINTENANCE -> "Manutenção"
        DRIVING_HABITS -> "Hábitos de Direção"
        PLANNING -> "Planejamento"
        VEHICLE_CARE -> "Cuidados com o Veículo"
    }
}

enum class TipDifficulty {
    EASY,   // Fácil
    MEDIUM, // Médio
    HARD;   // Difícil

    fun getDisplayName(): String = when(this) {
        EASY -> "Fácil"
        MEDIUM -> "Médio"
        HARD -> "Difícil"
    }
}

enum class VehicleType {
    CAR,   // Carro
    BIKE,  // Moto
    TRUCK; // Caminhão

    fun getDisplayName(): String = when(this) {
        CAR -> "Carro"
        BIKE -> "Moto"
        TRUCK -> "Caminhão"
    }
}
