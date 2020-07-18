package waytoodanny.definition.infrastructure.owl

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.net.URI
import java.net.http.HttpClient

@Configuration
@EnableConfigurationProperties(OwlConfiguration.OwlProperties::class)
class OwlConfiguration {

    @Bean
    fun owlWordInformationClient(owlProperties: OwlProperties,
                                 owlHttpClient: HttpClient): OwlWordInformationClient =
            OwlWordInformationClient(
                    OwlRequestFactory(owlProperties),
                    owlHttpClient,
                    owlJsonMapper()
            )

    @Bean
    fun owlHttpClient(): HttpClient = HttpClient.newHttpClient()

    @Bean
    fun owlJsonMapper(): ObjectMapper =
            ObjectMapper()
                    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)

    @ConfigurationProperties("definition.provider.owl")
    data class OwlProperties(var token: String?, var definitionUri: URI?)
}