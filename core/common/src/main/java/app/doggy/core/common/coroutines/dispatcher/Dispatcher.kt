package app.doggy.core.common.coroutines.dispatcher

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val mybraryDispatcher: MybraryDispatchers)
