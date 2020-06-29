import { transports } from 'winston'
import { WinstonModule } from 'nest-winston'

import { logFormatFile, logFormatConsole } from '../utils/LogFormat'

export const port = process.env.PORT || 3000

export const appConfig = {
  logger: WinstonModule.createLogger({
    format: logFormatFile,
    transports: [
      new transports.File({ filename: 'logs/info.log', level: 'info' }),
      new transports.File({ filename: 'logs/error.log', level: 'error' }),
      new transports.Console({ format: logFormatConsole })
    ]
  })
}
