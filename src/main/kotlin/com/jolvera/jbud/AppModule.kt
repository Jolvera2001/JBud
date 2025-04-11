package com.jolvera.jbud

import com.jolvera.jbud.domain.DatabaseConnection
import com.jolvera.jbud.services.IncomeService
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    single { DatabaseConnection() }

    factory { IncomeService(get()) }
}

fun initKoin() {
    startKoin {
        modules(appModule)
    }
}