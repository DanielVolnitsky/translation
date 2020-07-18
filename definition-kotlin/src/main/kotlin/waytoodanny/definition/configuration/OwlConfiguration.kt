package waytoodanny.definition.configuration

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(OwlConfiguration.OwlProperties::class)
class OwlConfiguration {

    @Bean
    fun test(props: OwlProperties): CommandLineRunner {
        return CommandLineRunner {
            run {
                print(props.token);
                print(props.token);
            }
        }
    }

    @ConfigurationProperties("definition.provider.owl")
    data class OwlProperties(var token: String?)
}