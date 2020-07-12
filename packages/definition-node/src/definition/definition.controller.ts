import { Controller, Logger, Get, Param } from '@nestjs/common'
import { DefinitionService } from './definition.service'
import { GetDefinitionDto } from './definition.dto'

@Controller('definition')
export class DefinitionController {
  private static readonly logger = new Logger(DefinitionController.name)

  constructor(private readonly definitionService: DefinitionService) {}

  @Get(':word')
  async getDefinition(@Param('word') word: string): Promise<GetDefinitionDto> {
    DefinitionController.logger.log(
      `About to fetch a definition of word: ${word}`
    )

    const response = await this.definitionService.getDefinition(word)
    return response.data
  }
}
