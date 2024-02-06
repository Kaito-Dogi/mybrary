package app.doggy.mybrary.core.common.coroutines.dispatcher

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val mybraryDispatcher: MybraryDispatchers)
