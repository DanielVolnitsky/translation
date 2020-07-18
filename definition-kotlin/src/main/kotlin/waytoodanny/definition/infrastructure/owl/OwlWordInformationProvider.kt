package waytoodanny.definition.infrastructure.owl

import io.vavr.control.Either
import org.springframework.stereotype.Service
import waytoodanny.definition.domain.Definition
import waytoodanny.definition.domain.Language
import waytoodanny.definition.domain.WordInformation
import waytoodanny.definition.usecase.GetWordInformation

@Service
class OwlWordInformationProvider(val owlClient: OwlWordInformationClient) : GetWordInformation {

    override fun wordInformation(word: String): Either<Exception, WordInformation> {
        return owlClient.wordInformation(word)
                .map(this::wordInformationDomain)
    }

    private fun wordInformationDomain(dto: OwlWordInformationDTO): WordInformation =
            WordInformation(
                    dto.word,
                    Language.ENGLISH,
                    dto.definitions.map { d -> Definition(d.type, d.definition, d.example) }
            )
}