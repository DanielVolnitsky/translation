import { Module, HttpModule } from '@nestjs/common'
import { DefinitionService } from './definition.service'
import { DefinitionController } from './definition.controller'

@Module({
  imports: [HttpModule],
  providers: [DefinitionService],
  controllers: [DefinitionController]
})
export class DefinitionModule {}
