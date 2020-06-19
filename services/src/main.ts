import { NestFactory } from '@nestjs/core'
import { Logger } from '@nestjs/common'
import { transports } from 'winston'
import { WinstonModule } from 'nest-winston'
import { config } from 'dotenv'
import { AppModule } from './app.module'

import { logFormat } from './utils/LogFormat'

config()
const port = process.env.PORT || 3000

async function bootstrap() {
  const logger = new Logger('bootstrap')
  const app = await NestFactory.create(AppModule, {
    logger: WinstonModule.createLogger({
      format: logFormat,
      transports: [
        new transports.File({ filename: 'info.log', level: 'info' }),
        new transports.File({ filename: 'error.log', level: 'error' }),
        new transports.Console()
      ]
    })
  })

  await app.listen(port)
  logger.log(`Application listening on ${port}`)
}
bootstrap()
