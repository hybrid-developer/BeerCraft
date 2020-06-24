package ${packageName}

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zavaitar.core.mvi.MviFragment
import com.zavaitar.core.nw.ui.theme.utils.setDarkWindowMode
import com.zavaitar.core.viewmodel.ViewModelFactory
import io.reactivex.Observable
import kotlinx.android.synthetic.main.${layoutName}.*
import javax.inject.Inject

internal class ${className}Fragment :
    MviFragment<${className}View, ${className}Intent, ${className}Result, ${className}ViewState>(),
    ${className}View {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    override val view: ${className}View = this

    override val viewModel: ${className}ViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(${className}ViewModel::class.java)
    }

    override val renderer: ${className}Renderer = ${className}Renderer()

    override fun onStartIntents(): Observable<${className}Intent> = Observable.mergeArray(
        Observable.just(${className}Intent.Initialize)
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.setDarkWindowMode()
        return inflater.inflate(R.layout.${layoutName}, container, false)
    }

    override fun showProgress() {
        ${layoutElementName}_progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        ${layoutElementName}_progress.visibility = View.GONE
    }
}
