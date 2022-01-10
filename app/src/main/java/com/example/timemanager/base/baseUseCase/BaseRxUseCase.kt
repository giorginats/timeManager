package com.example.timemanager.base.baseUseCase

import io.reactivex.Observable

interface BaseRxUseCase<ARG_TYPE, RETURN_TYPE> : BaseUseCase<ARG_TYPE, Observable<RETURN_TYPE>> {
}