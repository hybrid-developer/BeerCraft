package ${packageName}

import com.zavaitar.core.mvi.MviRenderer

internal class ${className}Renderer : MviRenderer<${className}View, ${className}ViewState> {
    override fun render(view: ${className}View, viewState: ${className}ViewState) {
        if (viewState.initialized) {
            view.hideProgress()
        } else {
            view.showProgress()
        }
    }
}
