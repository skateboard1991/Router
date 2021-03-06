package com.skateboard.processor

import com.skateboard.routerannoation.Constants
import com.skateboard.routerannoation.Route
import com.squareup.javapoet.*
import javax.annotation.processing.*
import javax.lang.model.element.ElementKind
import javax.lang.model.element.Modifier
import javax.lang.model.element.TypeElement
import javax.lang.model.util.Elements
import javax.lang.model.util.Types
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import com.squareup.javapoet.JavaFile
import javax.lang.model.SourceVersion
import javax.tools.Diagnostic


class RouterProcessor : AbstractProcessor()
{
    private var elementsUtil: Elements? = null

    private var filer: Filer? = null

    private var typeUtil: Types? = null

    private var messager: Messager? = null

    private var hasCreateFile = false

    private lateinit var moduleName: String

    override fun getSupportedAnnotationTypes(): Set<String>
    {
        return setOf(Route::class.java.canonicalName)
    }

    override fun getSupportedSourceVersion(): SourceVersion
    {
        return SourceVersion.latestSupported()
    }

    @Synchronized
    override fun init(processingEnvironment: ProcessingEnvironment)
    {
        super.init(processingEnvironment)
        elementsUtil = processingEnvironment.elementUtils
        filer = processingEnvironment.filer
        messager = processingEnvironment.messager
        typeUtil = processingEnvironment.typeUtils
        moduleName = processingEnvironment.options[Constants.KEY_MODULENAME] ?: ""
    }

    override fun process(set: Set<TypeElement>, roundEnvironment: RoundEnvironment): Boolean
    {

        if (!hasCreateFile)
        {
            val elementSet = roundEnvironment.getElementsAnnotatedWith(Route::class.java)
            val typeSpecBuilder = TypeSpec.classBuilder(generateClassName())
            typeSpecBuilder.addSuperinterface(ClassName.get(Constants.PACKAGE_NAME, Constants.ROUTE_TABLE))
            typeSpecBuilder.addModifiers(Modifier.PUBLIC)
            val methodSpecBuilder = MethodSpec.methodBuilder("putRouteClass")
            val parameterTypeName = ParameterizedTypeName.get(ClassName.get("android.support.v4.util", "ArrayMap"), ClassName.get(String::class.java), ParameterizedTypeName.get(ClassName.get(Class::class.java), WildcardTypeName.subtypeOf(Any::class.java)))
            methodSpecBuilder.addParameter(ParameterSpec.builder(parameterTypeName, "routableMap").build())
                    .addModifiers(Modifier.PUBLIC)
                    .returns(Void.TYPE)

            for (element in elementSet)
            {
                if (element is TypeElement)
                {
                    if (element.kind == ElementKind.CLASS)
                    {
                        val route = element.getAnnotation(Route::class.java)
                        methodSpecBuilder.addStatement("routableMap.put(\$S, \$T.class)", route.url, ClassName.get(element))
                    }
                }
            }
            typeSpecBuilder.addMethod(methodSpecBuilder.build())
            val javaFile = JavaFile.builder("com.skateboard.router", typeSpecBuilder.build()).build()
            filer?.let {
                javaFile.writeTo(it)
                hasCreateFile = true
            }
        }
        return true
    }

    private fun generateClassName(): String
    {
        return if (moduleName.isNotEmpty())
        {
            moduleName + "_" + "RouterTableImp"
        } else
        {
            "RouterTableImp"
        }
    }

}
