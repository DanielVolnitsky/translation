import { NestFactory } from '@nestjs/core'
import { Logger } from '@nestjs/common'
import * as winston from 'winston'
import { WinstonModule } from 'nest-winston'
import { AppModule } from './app.module'

async function bootstrap() {
  const logger = new Logger('bootstrap')
  const app = await NestFactory.create(AppModule, {
    logger: WinstonModule.createLogger({
      transports: [
        new winston.transports.File({ filename: 'info.log', level: 'info' }),
        new winston.transports.File({ filename: 'error.log', level: 'error' })
      ]
    })
  })

  const port = 3000 // TODO: do it process.env variable
  await app.listen(port)
  logger.log(`Application listening on port ${port}`)
}
bootstrap()
