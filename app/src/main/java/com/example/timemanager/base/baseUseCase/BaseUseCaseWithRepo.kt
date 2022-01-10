package com.example.timemanager.base.baseUseCase

abstract class BaseUseCaseWithRepo<REPOSITORY, ARG_TYPE, RETURN_TYPE>
constructor(protected val repository: REPOSITORY) : BaseUseCase<ARG_TYPE, RETURN_TYPE>