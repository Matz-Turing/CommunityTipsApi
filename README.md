# Community Tips API

<img src="https://user-images.githubusercontent.com/74038190/212284115-f47cd8ff-2ffb-4b04-b5bf-4d1c14c0247f.gif" width="1000">

Uma API Android simples para fornecer dicas de economia de combustível e manutenção de veículos.

## Características

- Dicas personalizadas por tipo de veículo (Carro, Moto, Caminhão)
- Categorias de dicas (Manutenção, Hábitos de Direção, Planejamento, Cuidados com o Veículo)
- Níveis de dificuldade (Fácil, Médio, Difícil)
- Economia potencial em porcentagem
- Sistema de persistência para dicas implementadas
- Suporte para múltiplos idiomas (atualmente em Português)

## Instalação

1. Adicione o repositório JitPack ao seu arquivo `settings.gradle.kts`:
```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

2. Adicione a dependência ao seu arquivo `build.gradle.kts`:
```kotlin
dependencies {
    implementation("com.github.YourUsername:community-tips-api:1.0.0")
}
```

## Uso

### Inicialização
```kotlin
// Criar instância do TipsPreferences
val tipsPreferences = TipsPreferences(context)

// Criar instância do TipsRepository
val tipsRepository = TipsRepository(tipsPreferences)
```

### Obter Dicas
```kotlin
// Obter todas as dicas
val allTips = TipsDatabase.getAllTips()

// Obter dicas por tipo de veículo
val carTips = TipsDatabase.getTipsByVehicleType(VehicleType.CAR)
val bikeTips = TipsDatabase.getTipsByVehicleType(VehicleType.BIKE)
val truckTips = TipsDatabase.getTipsByVehicleType(VehicleType.TRUCK)

// Obter dicas com estado de implementação (usando Flow)
tipsRepository.getTips().collect { tips ->
    // Usar a lista de dicas
    tips.forEach { tip ->
        println("${tip.title} - Implementada: ${tip.isImplemented}")
    }
}
```

### Gerenciar Preferências
```kotlin
// Definir tipo de veículo
tipsRepository.setVehicleType(VehicleType.CAR)

// Marcar dica como implementada
tipsRepository.markTipAsImplemented("car_1")

// Desmarcar dica implementada
tipsRepository.unmarkTipAsImplemented("car_1")
```

## Estrutura de Dados

### DrivingTip
```kotlin
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
```

### Enums
```kotlin
enum class TipCategory {
    MAINTENANCE,    // Manutenção
    DRIVING_HABITS, // Hábitos de Direção
    PLANNING,       // Planejamento
    VEHICLE_CARE    // Cuidados com o Veículo
}

enum class TipDifficulty {
    EASY,   // Fácil
    MEDIUM, // Médio
    HARD    // Difícil
}

enum class VehicleType {
    CAR,   // Carro
    BIKE,  // Moto
    TRUCK  // Caminhão
}
```

## Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

## Créditos

Desenvolvido por Mateus S.  
GitHub: [Matz-Turing](https://github.com/Matz-Turing)
