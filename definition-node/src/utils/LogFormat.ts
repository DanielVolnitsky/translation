import { format } from 'winston'

const { combine, timestamp, printf, colorize } = format

interface TransformableInfo {
  [key: string]: string
}

export const logFormatFile = combine(
  timestamp(),
  printf(
    (info: TransformableInfo) =>
      `${info.timestamp} [${info.context}] ${info.level}: ${info.message}`
  )
)

export const logFormatConsole = combine(
  timestamp({ format: 'YYYY-MM-DD HH:mm:ss' }),
  colorize(),
  printf(
    (info: TransformableInfo) =>
      `${info.timestamp} [${info.context}] - [${info.level}]: ${info.message}`
  )
)
