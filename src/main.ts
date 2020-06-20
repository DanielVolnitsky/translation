import { NestFactory } from '@nestjs/core'
import { Logger } from '@nestjs/common'
import { transports } from 'winston'
import { WinstonModule } from 'nest-winston'
import { AppModule } from './app.module'

import { logFormatFile, logFormatConsole } from './utils/LogFormat'

const port = process.env.PORT || 3000

async function bootstrap() {
  const logger = new Logger('bootstrap')
  const app = await NestFactory.create(AppModule, {
    logger: WinstonModule.createLogger({
      format: logFormatFile,
      transports: [
        new transports.File({ filename: 'info.log', level: 'info' }),
        new transports.File({ filename: 'error.log', level: 'error' }),
        new transports.Console({ format: logFormatConsole })
      ]
    })
  })

  await app.listen(port)
  logger.log(`Application listening on ${port}`)
}
void bootstrap()
