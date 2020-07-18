package waytoodanny.definition.infrastructure.owl

import java.net.URI
import java.net.http.HttpRequest

class OwlRequestFactory(private val owlProperties: OwlConfiguration.OwlProperties) {

    fun wordDefinitionRequest(word: String): HttpRequest {
        return HttpRequest.newBuilder(fullURI(word))
                .GET()
                .header("Authorization", "Token ${owlProperties.token}")
                .build()
    }

    private fun fullURI(word: String): URI = owlProperties.definitionUri!!.resolve(word)
}