package ${packageName}

import io.reactivex.Completable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

internal class ${className}UseCase @Inject constructor() {

    fun initialize(): Completable {
        return Completable.complete()
            .delay(3L, TimeUnit.SECONDS)
    }
}
