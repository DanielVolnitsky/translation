package waytoodanny.definition.domain

class WordInformation(val word: String,
                      val language: Language,
                      val type: String,
                      val definitions: List<Definition>)