package com.zavaitar.feature.startup.presentation

import javax.inject.Inject

class SampleFactory @Inject constructor() {

    fun getSampleData() = "This is sample data"
}