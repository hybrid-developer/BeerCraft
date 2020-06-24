package ${packageName}

import androidx.annotation.VisibleForTesting
import com.zavaitar.core.mvi.MviViewModel
import io.reactivex.Observable
import io.reactivex.ObservableSource
import javax.inject.Inject

internal class ${className}ViewModel @VisibleForTesting  constructor(
  state: ${className}ViewState,
  private val useCase: ${className}UseCase
) : MviViewModel<${className}Intent, ${className}Result, ${className}ViewState>(state) {

    @Inject
    constructor(useCase: ${className}UseCase) : this(${className}ViewState.default(), useCase)

    override fun dispatchIntent(intent: ${className}Intent): Observable<${className}Result> = when (intent) {
        ${className}Intent.Initialize -> initialize()
    }

    override fun filterIntents(intents: Observable<${className}Intent>): ObservableSource<${className}Intent> = Observable.merge(
            intents.ofType(${className}Intent.Initialize::class.java).take(1),
            intents.filter { !${className}Intent.Initialize::class.java.isInstance(it) }
    )

    fun initialize(): Observable<${className}Result> {
        return useCase.initialize()
            .toSingleDefault<${className}Result>(${className}Result.Initialized)
            .toObservable()
    }
}
