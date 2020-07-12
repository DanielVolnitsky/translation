import { getApiBaseHeader } from './utils'

describe('[config/utils]', () => {
  beforeEach(() => {
    process.env.API_TOKEN = 'Token abc123'
  })

  it('should return base header with authorization token', () => {
    const expectedResult = {
      headers: {
        Authorization: process.env.API_TOKEN
      }
    }
    const result = getApiBaseHeader()
    expect(result).toStrictEqual(expectedResult)
  })
})
