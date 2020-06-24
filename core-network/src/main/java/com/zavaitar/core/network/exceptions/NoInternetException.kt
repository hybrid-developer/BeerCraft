package com.zavaitar.core.network.exceptions

import java.io.IOException

class NoInternetException : IOException() {
    override val message: String
        get() =
            "No internet available, please check your connected WIFi or Data"
}
