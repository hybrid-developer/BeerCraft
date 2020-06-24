<?xml version="1.0"?>
<recipe>
    <instantiate from="res/layout/fragment.xml.ftl"
        to="${escapeXmlAttribute(resOut)}/layout/${escapeXmlAttribute(layoutName)}.xml" />

    <instantiate from="src/app_package/Fragment.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/${className}Fragment.kt" />
    <instantiate from="src/app_package/FragmentModule.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/${className}FragmentModule.kt" />
    <instantiate from="src/app_package/Intent.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/${className}Intent.kt" />
    <instantiate from="src/app_package/Renderer.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/${className}Renderer.kt" />
    <instantiate from="src/app_package/Result.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/${className}Result.kt" />
    <instantiate from="src/app_package/UseCase.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/${className}UseCase.kt" />
    <instantiate from="src/app_package/View.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/${className}View.kt" />
    <instantiate from="src/app_package/ViewModel.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/${className}ViewModel.kt" />
    <instantiate from="src/app_package/ViewState.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/${className}ViewState.kt" />
</recipe>
