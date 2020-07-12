import { NestFactory } from '@nestjs/core'
import { Logger } from '@nestjs/common'
import { AppModule } from './app.module'
import { appConfig, port } from './config/app.config'

async function bootstrap(): Promise<void> {
  const logger = new Logger('bootstrap')
  const app = await NestFactory.create(AppModule, appConfig)

  await app.listen(port)
  logger.log(`Application listening on ${port}`)
}
void bootstrap()
