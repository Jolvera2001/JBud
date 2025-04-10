package com.jolvera.jbud

import com.jolvera.jbud.domain.DatabaseConnection
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    single { DatabaseConnection() }
}

fun initKoin() {
    startKoin {
        modules(appModule)
    }
}