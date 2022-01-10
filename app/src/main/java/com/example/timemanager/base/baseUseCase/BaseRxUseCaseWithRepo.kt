package com.example.timemanager.base.baseUseCase

import io.reactivex.Observable

abstract class BaseRxUseCaseWithRepo<REPOSITORY,ARG_TYPE,RETURN_TYPE>(repository: REPOSITORY) :
    BaseUseCaseWithRepo<REPOSITORY, ARG_TYPE, Observable<RETURN_TYPE>>(repository)