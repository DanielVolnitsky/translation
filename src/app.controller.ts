import { Controller, Get, Logger } from '@nestjs/common'
import { AppService } from './app.service'

@Controller()
export class AppController {
  private static readonly logger = new Logger(AppController.name)

  constructor(private readonly appService: AppService) {}

  @Get()
  getHello(): string {
    AppController.logger.log('Get request to / route')
    return this.appService.getHello()
  }
}
