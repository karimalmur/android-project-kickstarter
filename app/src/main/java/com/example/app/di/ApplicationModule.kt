package com.example.app.di

import com.example.app.domain.coreModule
import org.koin.dsl.module

val applicationModule = module {}

val appModules = listOf(applicationModule, coreModule)
