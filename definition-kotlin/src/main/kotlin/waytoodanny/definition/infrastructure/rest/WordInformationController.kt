package waytoodanny.definition.infrastructure.rest

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import waytoodanny.definition.domain.WordInformation
import waytoodanny.definition.usecase.GetWordInformation

@RestController
class WordInformationController constructor(val wordInformationProvider: GetWordInformation) {

    @GetMapping("/{word}/details")
    fun greeting(@PathVariable word: String): ResponseEntity<WordInformation> =
            wordInformationProvider.wordInformation(word)
                    .fold(
                            { ResponseEntity.notFound().build() },
                            { wordInformation -> ResponseEntity.ok(wordInformation) })
}