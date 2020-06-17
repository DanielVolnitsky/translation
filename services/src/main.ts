import { NestFactory } from '@nestjs/core'
import { Logger } from '@nestjs/common'
import { transports } from 'winston'
import { WinstonModule } from 'nest-winston'
import { AppModule } from './app.module'

async function bootstrap() {
  const logger = new Logger('bootstrap')
  const app = await NestFactory.create(AppModule, {
    logger: WinstonModule.createLogger({
      transports: [
        new transports.File({ filename: 'info.log', level: 'info' }),
        new transports.File({ filename: 'error.log', level: 'error' })
      ]
    })
  })

  const port = 3000 // TODO: do it process.env variable
  await app.listen(port)
  logger.log(`Application listening on port ${port}`)
}
bootstrap()
