interface BaseHeader {
  headers: {
    Authorization: string
  }
}

export const getApiBaseHeader = (): BaseHeader => ({
  headers: {
    Authorization: process.env.API_TOKEN
  }
})
