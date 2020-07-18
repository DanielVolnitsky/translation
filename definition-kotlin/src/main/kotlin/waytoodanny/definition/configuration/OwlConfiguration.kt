package waytoodanny.definition.configuration

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import waytoodanny.definition.infrastructure.owl.OwlRequestFactory
import waytoodanny.definition.infrastructure.owl.OwlWordInformationClient
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
                    owlHttpClient
            )


    @Bean
    fun owlHttpClient(): HttpClient = HttpClient.newHttpClient()

    @Bean
    fun test(client: OwlWordInformationClient): CommandLineRunner {
        return CommandLineRunner {
            run {
                while (true) {
                    client.wordInformation("owl")
                }
            }
        }
    }

    @ConfigurationProperties("definition.provider.owl")
    data class OwlProperties(var token: String?, var definitionUri: URI?)
}