package com.financasapp.tips.data

import com.financasapp.tips.model.*

object TipsDatabase {
    val carTips = listOf(
        DrivingTip(
            id = "car_1",
            title = "Calibragem dos Pneus",
            description = "Mantenha os pneus sempre calibrados na pressão recomendada pelo fabricante. Pneus com pressão incorreta aumentam o consumo de combustível em até 5%.",
            savingPercentage = 5,
            category = TipCategory.MAINTENANCE,
            difficulty = TipDifficulty.EASY,
            vehicleType = VehicleType.CAR
        ),
        DrivingTip(
            id = "car_2",
            title = "Velocidade Constante",
            description = "Mantenha velocidade constante em rodovias, evitando acelerações e frenagens bruscas. Isso pode economizar até 10% de combustível.",
            savingPercentage = 10,
            category = TipCategory.DRIVING_HABITS,
            difficulty = TipDifficulty.MEDIUM,
            vehicleType = VehicleType.CAR
        ),
        DrivingTip(
            id = "car_3",
            title = "Troca de Marchas",
            description = "Faça as trocas de marcha no momento certo (2.000 a 2.500 RPM para carros flex). Trocas no momento correto podem economizar até 8% de combustível.",
            savingPercentage = 8,
            category = TipCategory.DRIVING_HABITS,
            difficulty = TipDifficulty.MEDIUM,
            vehicleType = VehicleType.CAR
        ),
        DrivingTip(
            id = "car_4",
            title = "Peso Extra",
            description = "Retire peso desnecessário do porta-malas. Cada 40kg extras representam um aumento de 2% no consumo de combustível.",
            savingPercentage = 2,
            category = TipCategory.VEHICLE_CARE,
            difficulty = TipDifficulty.EASY,
            vehicleType = VehicleType.CAR
        ),
        DrivingTip(
            id = "car_5",
            title = "Filtro de Ar",
            description = "Mantenha o filtro de ar limpo. Um filtro sujo pode aumentar o consumo em até 7%.",
            savingPercentage = 7,
            category = TipCategory.MAINTENANCE,
            difficulty = TipDifficulty.MEDIUM,
            vehicleType = VehicleType.CAR
        )
    )

    val bikeTips = listOf(
        DrivingTip(
            id = "bike_1",
            title = "Corrente Lubrificada",
            description = "Mantenha a corrente sempre limpa e lubrificada. Uma corrente sem manutenção pode aumentar o consumo em até 6%.",
            savingPercentage = 6,
            category = TipCategory.MAINTENANCE,
            difficulty = TipDifficulty.EASY,
            vehicleType = VehicleType.BIKE
        ),
        DrivingTip(
            id = "bike_2",
            title = "Pressão dos Pneus",
            description = "Verifique semanalmente a pressão dos pneus. Pneus murchos aumentam o consumo em até 3%.",
            savingPercentage = 3,
            category = TipCategory.MAINTENANCE,
            difficulty = TipDifficulty.EASY,
            vehicleType = VehicleType.BIKE
        ),
        DrivingTip(
            id = "bike_3",
            title = "Acelerações Suaves",
            description = "Evite acelerações bruscas, principalmente nos semáforos. Acelerações suaves podem economizar até 12% de combustível.",
            savingPercentage = 12,
            category = TipCategory.DRIVING_HABITS,
            difficulty = TipDifficulty.MEDIUM,
            vehicleType = VehicleType.BIKE
        ),
        DrivingTip(
            id = "bike_4",
            title = "Troca de Óleo",
            description = "Faça a troca de óleo no prazo recomendado. Óleo vencido pode aumentar o consumo em até 5%.",
            savingPercentage = 5,
            category = TipCategory.MAINTENANCE,
            difficulty = TipDifficulty.MEDIUM,
            vehicleType = VehicleType.BIKE
        ),
        DrivingTip(
            id = "bike_5",
            title = "Postura na Pilotagem",
            description = "Mantenha uma postura que reduza a resistência do ar. A aerodinâmica pode influenciar em até 4% no consumo.",
            savingPercentage = 4,
            category = TipCategory.DRIVING_HABITS,
            difficulty = TipDifficulty.HARD,
            vehicleType = VehicleType.BIKE
        )
    )

    val truckTips = listOf(
        DrivingTip(
            id = "truck_1",
            title = "Velocidade Econômica",
            description = "Mantenha a velocidade entre 70-80 km/h em rodovias. Esta é a faixa mais econômica para caminhões.",
            savingPercentage = 15,
            category = TipCategory.DRIVING_HABITS,
            difficulty = TipDifficulty.MEDIUM,
            vehicleType = VehicleType.TRUCK
        ),
        DrivingTip(
            id = "truck_2",
            title = "Calibragem dos Pneus",
            description = "Verifique diariamente a calibragem dos pneus. Em caminhões, a pressão incorreta pode aumentar o consumo em até 8%.",
            savingPercentage = 8,
            category = TipCategory.MAINTENANCE,
            difficulty = TipDifficulty.EASY,
            vehicleType = VehicleType.TRUCK
        ),
        DrivingTip(
            id = "truck_3",
            title = "Distribuição de Carga",
            description = "Distribua a carga de forma equilibrada. Uma distribuição inadequada pode aumentar o consumo em até 6%.",
            savingPercentage = 6,
            category = TipCategory.PLANNING,
            difficulty = TipDifficulty.MEDIUM,
            vehicleType = VehicleType.TRUCK
        ),
        DrivingTip(
            id = "truck_4",
            title = "Marcha Lenta",
            description = "Evite deixar o caminhão em marcha lenta por longos períodos. Isso pode economizar até 5% de combustível.",
            savingPercentage = 5,
            category = TipCategory.DRIVING_HABITS,
            difficulty = TipDifficulty.EASY,
            vehicleType = VehicleType.TRUCK
        ),
        DrivingTip(
            id = "truck_5",
            title = "Manutenção Preventiva",
            description = "Siga rigorosamente o plano de manutenção preventiva. Manutenções em dia podem economizar até 10% de combustível.",
            savingPercentage = 10,
            category = TipCategory.MAINTENANCE,
            difficulty = TipDifficulty.HARD,
            vehicleType = VehicleType.TRUCK
        )
    )

    fun getAllTips(): List<DrivingTip> = carTips + bikeTips + truckTips

    fun getTipsByVehicleType(type: VehicleType): List<DrivingTip> = when(type) {
        VehicleType.CAR -> carTips
        VehicleType.BIKE -> bikeTips
        VehicleType.TRUCK -> truckTips
    }
}
