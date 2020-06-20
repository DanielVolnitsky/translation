import { format } from 'winston'

const { combine, timestamp, printf } = format

interface TransformableInfo {
  [key: string]: string | number
}

export const logFormat = combine(
  timestamp(),
  printf(
    (info: TransformableInfo) =>
      `${info.timestamp} [${info.context}] ${info.level}: ${info.message}`
  )
)
