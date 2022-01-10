package com.example.timemanager.base.baseUseCase

interface BaseUseCase<ARG_TYPE, RETURN_TYPE> {
    fun start(arg: ARG_TYPE? = null): RETURN_TYPE
}