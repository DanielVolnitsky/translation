package waytoodanny.definition.infrastructure.owl

import com.fasterxml.jackson.databind.ObjectMapper
import io.vavr.control.Either
import waytoodanny.definition.domain.exception.WordInformationRetrievalException
import java.net.http.HttpClient
import java.net.http.HttpResponse

class OwlWordInformationClient(private val requestFactory: OwlRequestFactory,
                               private val httpClient: HttpClient,
                               private val jsonMapper: ObjectMapper) {

    fun wordInformation(word: String): Either<Exception, OwlWordInformationDTO> {
        val response: HttpResponse<String> =
                httpClient.send(
                        requestFactory.wordDefinitionRequest(word),
                        HttpResponse.BodyHandlers.ofString())

        return validateResponseStatus(response)
                .flatMap { validatedResponse -> wordInformationDTO(validatedResponse) }
    }

    private fun validateResponseStatus(response: HttpResponse<String>): Either<Exception, HttpResponse<String>> {
        return if (response.statusCode() == 200)
            Either.right<Exception, HttpResponse<String>>(response)
        else
            Either.left(
                    WordInformationRetrievalException("Failed to get successful response from Owl API: $response"))
    }

    private fun wordInformationDTO(response: HttpResponse<String>): Either<Exception, OwlWordInformationDTO> {
        return response
                .let(HttpResponse<String>::body)
                .let { body -> jsonMapper.readValue(body, OwlWordInformationDTO::class.java) }
                .let { dto -> Either.right<Exception, OwlWordInformationDTO>(dto) }
                ?: Either.left<Exception, OwlWordInformationDTO>(
                        WordInformationRetrievalException("Failed to parse Owl response body: ${response.body()}"))
    }
}