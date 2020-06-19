import { format } from 'winston'
const { combine, timestamp, printf } = format

export const logFormat = combine(
  timestamp(),
  printf(
    info => `${info.timestamp} [${info.context}] ${info.level}: ${info.message}`
  )
)
