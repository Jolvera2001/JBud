package com.jolvera.jbud

import com.jolvera.jbud.domain.DatabaseConnection
import com.jolvera.jbud.services.ExpenseService
import com.jolvera.jbud.services.IncomeService
import com.jolvera.jbud.ui.viewmodels.DashboardViewModel
import com.jolvera.jbud.ui.viewmodels.ItemsViewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    single { DatabaseConnection() }

    // services
    factory { IncomeService(get()) }
    factory { ExpenseService(get()) }

    // view models
    factory { DashboardViewModel() }
    factory { ItemsViewModel() }
}

fun initKoin() {
    startKoin {
        logger(
            logger = TODO()
        )
        modules(appModule)
    }
}