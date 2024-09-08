package app.kaito_dogi.mybrary.core.common.coroutines.dispatcher

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MybraryDispatcher(val mybraryDispatchers: MybraryDispatchers)
