package com.zavaitar.feature.startup.presentation

import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.zavaitar.core.mvi.MviFragment
import com.zavaitar.feature.startup.R
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.Observable
import kotlinx.android.synthetic.main.startup_fragment.*

@AndroidEntryPoint
internal class StartupFragment :
    MviFragment<StartupView, StartupIntent, StartupResult, StartupViewState>(R.layout.startup_fragment),
    StartupView {

    override val viewModel: StartupViewModel by lazy {
        ViewModelProvider(this, defaultViewModelProviderFactory).get(StartupViewModel::class.java)
    }

    override val view: StartupView = this

    override val renderer: StartupRenderer = StartupRenderer()

    override fun onStartIntents(): Observable<StartupIntent> = Observable.mergeArray(
        Observable.just(StartupIntent.Initialize)
    )

    override fun showProgress() {
       // sampleFactory.getSampleData()
        startup_progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
       // sampleFactory.getSampleData()
        startup_progress.visibility = View.GONE
    }
}
