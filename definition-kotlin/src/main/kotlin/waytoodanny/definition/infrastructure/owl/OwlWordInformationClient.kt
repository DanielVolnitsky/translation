package waytoodanny.definition.infrastructure.owl

import io.vavr.control.Either
import java.net.http.HttpClient
import java.net.http.HttpResponse

class OwlWordInformationClient(private val requestFactory: OwlRequestFactory,
                               private val httpClient: HttpClient) {

    fun wordInformation(word: String): Either<Exception, OwlWordInformationDTO> {

        val response: HttpResponse<String>? =
                httpClient.send(requestFactory.wordDefinitionRequest(word), HttpResponse.BodyHandlers.ofString())

        return Either.left(IllegalArgumentException())
    }
}