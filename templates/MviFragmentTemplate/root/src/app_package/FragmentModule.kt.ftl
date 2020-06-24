package ${packageName}

import androidx.lifecycle.ViewModel
import com.zavaitar.core.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ${className}FragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(${className}ViewModel::class)
    internal abstract fun bind${className}ViewModel(viewModel: ${className}ViewModel): ViewModel
}
