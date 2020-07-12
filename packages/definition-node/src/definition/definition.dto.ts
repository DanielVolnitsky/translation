interface Definition {
  type: string
  definition: string
  example: string
  image_url: string
  emoji: string
}

export class GetDefinitionDto {
  definitions: Definition[]
  word: string
  pronunciation: string
}
